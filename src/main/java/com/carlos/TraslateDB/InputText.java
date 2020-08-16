package com.carlos.TraslateDB;

import com.carlos.DBSuport.RegistroDB;
import java.io.*;
import java.util.*;

import com.carlos.Entities.Client;
import com.carlos.Entities.Employee;
import com.carlos.Entities.Pedido;
import com.carlos.Entities.Product;
import com.carlos.Entities.TimeStoreToStore;

public class InputText {

    //private String src = "/home/benjamin/Documents/Proyectos IPC2 2020/archivosprueba/";
    private ArrayList<String> lineasDeTexto = new ArrayList<String>();
    private ArrayList<String> erroresDeDatos = new ArrayList<String>();
    private RegistroDB resistrarElemento = new RegistroDB();
    public InputText (){

    }
    /**
     * Ingreso de los datos existentes en una base de datos
     */
    public void  LecturaEIngreso(File archivoSeleccionado){
        File textoDeExtrada = archivoSeleccionado;
        BufferedReader buffer = null;
        String textoProcesado = "";
        if(textoDeExtrada.exists()){
            try {
                buffer = new BufferedReader(new FileReader(textoDeExtrada));
                while((textoProcesado = buffer.readLine())!= null)
                {
                    if(textoProcesado!=null)
                    {
                        lineasDeTexto.add(textoProcesado);
                    }
                }
            } catch (Exception e) {
            }
            finally{
                try {
                    buffer.close();
                } catch (Exception e) {
                
                }
            }
        }
        //Avanza una por una en las lineas de texto y las procesa
        for (int i = 0; i < lineasDeTexto.size(); i++) {
            int cantidad= contarCaracter(lineasDeTexto.get(i),",");
            String nombreApartado=extraerTexto(lineasDeTexto.get(i), 0,lineasDeTexto.get(i).indexOf(",")-1);
            //Establecemos un filtro de la cantidad de datos que esperamos en las lineas de texto
            if (cantidad==3|| cantidad==4 ||cantidad==6 || cantidad==9)
            {
                //Establecemos si hay una coma al final de una linea el cual siguinifia un error en la linea de texto
                if(lineasDeTexto.get(i).indexOf(",", lineasDeTexto.get(i).length()-2)!=lineasDeTexto.get(i).length()-1){
                    ArrayList<String> apartados = new ArrayList<String>();
                    if(validarTexto(nombreApartado)){
                        /*
                            EN LAS CONDICIONES SIGUINETES SOLAMENTE HACEMOS EL RECONOCIMIENTO POR APARTADO DE NOMBRE DE LA BASE IMPORTADA
                            la variable apartado representa la line a analizar durante los filtros
                        */
                        if(nombreApartado.equals("TIENDA")){
                            //Se cuenta la cantidad de datos que posee la palabra clave de reconocimiento
                            if(cantidad==4){
                                apartados=apartadoDeTexto(lineasDeTexto.get(i),",");
                                //Verifiacion del numero telefonico
                                if(verificarRepresentacionNumerica(apartados.get(4))){
                                    if(verificarNumeroTelefonico(apartados.get(4))){
                                        System.out.println(lineasDeTexto.get(i));
                                        /*
                                        for (int j = 0; j < cantidad+1; j++) {
                                            System.out.println(apartados.get(j));
                                        }
                                        */
                                    }
                                    else{
                                        String mensaje = "Linea "+(i+1)+"Numero telefonico no valido";            
                                        erroresDeDatos.add(mensaje);
                                    }
                                    
                                }   
                                else{
                                    String mensaje = "Linea "+(i+1)+"Numero telefonico no valido";            
                                    erroresDeDatos.add(mensaje);
                                }
                                
                            }
                            else{
                                String mensaje = "Linea "+(i+1)+" El codigo TIENDA debe ir con 4 datos y hay "+(cantidad+1)+" datos";            
                                erroresDeDatos.add(mensaje);
                            }
                        }

                        if(nombreApartado.equals("EMPLEADO")){
                            //Se cuenta la cantidad de datos que posee la palabra clave de reconocimiento
                            if(cantidad==4){
                                apartados=apartadoDeTexto(lineasDeTexto.get(i),",");
                                if(verificarRepresentacionNumerica(apartados.get(3))){
                                    if(verificarNumeroTelefonico(apartados.get(3)))
                                    {
                                        if(verificarRepresentacionNumerica(apartados.get(4))){
                                            if(verificarDPI(apartados.get(4)))
                                            {
                                                System.out.println(lineasDeTexto.get(i));
                                                String codigo = apartados.get(2);
                                                String nombre = apartados.get(1);
                                                String nit = "";
                                                String telefono = apartados.get(3);
                                                String dpi=apartados.get(4);
                                                String email="";
                                                String direccion="";
                                                Employee registroEmpleado = new Employee(codigo, nombre, telefono, nit, dpi, email, direccion);
                                                String respuesta = this.resistrarElemento.registroEmpleado(registroEmpleado);
                                                //Comprueba si hubo errores por parte de la base de datos
                                                if(!(respuesta.equals(""))){
                                                    String mensaje = "Linea "+(i+1)+" "+respuesta;            
                                                    erroresDeDatos.add(mensaje);
                                                }
                                            }
                                            else{
                                                String mensaje = "Linea "+(i+1)+" Numero de DPI no valido";            
                                                erroresDeDatos.add(mensaje);
                                            }
                                            
                                        }
                                        else{
                                            String mensaje = "Linea "+(i+1)+" Numero de DPI no valido";            
                                            erroresDeDatos.add(mensaje);
                                        }
                                    }
                                    else{
                                        String mensaje = "Linea "+(i+1)+" Numero telefonico no valido";            
                                        erroresDeDatos.add(mensaje);
                                    }
                                }
                                else{
                                    String mensaje = "Linea "+(i+1)+" Numero telefonico no valido";            
                                    erroresDeDatos.add(mensaje);
                                }
                                
                            }
                            else{
                                String mensaje = "Linea "+(i+1)+" El codigo EMPLEADO debe ir con 4 datos y hay "+(cantidad+1)+" datos";            
                                erroresDeDatos.add(mensaje);
                            }
                        }

                        if(nombreApartado.equals("TIEMPO")){
                            //Se cuenta la cantidad de datos que posee la palabra clave de reconocimiento
                            if(cantidad==3)
                            {
                                apartados=apartadoDeTexto(lineasDeTexto.get(i),",");
                                if(verificarRepresentacionNumerica(apartados.get(3))){

                                    System.out.println(lineasDeTexto.get(i));

                                    String tienda1Codigo = apartados.get(1);
                                    String tienda2Codigo = apartados.get(2);
                                    int tiempo = Integer.valueOf(apartados.get(3));

                                    TimeStoreToStore registroTiempo = new TimeStoreToStore(tienda1Codigo, tienda2Codigo, tiempo);
                                    String respuesta = this.resistrarElemento.registroTiempo(registroTiempo);
                                    //Comprueba si hubo errores por parte de la base de datos
                                    if(!(respuesta.equals(""))){
                                        String mensaje = "Linea "+(i+1)+" "+respuesta;            
                                        erroresDeDatos.add(mensaje);
                                    }
                                }
                                else
                                {
                                    String mensaje = "Linea "+(i+1)+" El texto no representa una unidad de tiempo";            
                                    erroresDeDatos.add(mensaje);   
                                }
                            }
                            else{
                                String mensaje = "Linea "+(i+1)+" El codigo TIEMPO debe ir con 4 datos y hay "+(cantidad+1)+" datos";            
                                erroresDeDatos.add(mensaje);
                            }
                        }

                        if(nombreApartado.equals("CLIENTE")){
                            //Se cuenta la cantidad de datos que posee la palabra clave de reconocimiento
                            if(cantidad==4){
                                apartados=apartadoDeTexto(lineasDeTexto.get(i),",");
                                //Verficamos si el texto ingreaso representa un numero
                                if(verificarRepresentacionNumerica(apartados.get(3))){
                                    if(verificarNumeroTelefonico(apartados.get(3)))
                                    {
                                        //Verificacion de forma flotante del dinero
                                        if(verificarRepresentacionNumericaDecimal(apartados.get(4))){
                                            System.out.println(lineasDeTexto.get(i));
                                            String nombre = apartados.get(1);
                                            String nit = apartados.get(2);
                                            String telefono = apartados.get(3);
                                            Float credito = Float.parseFloat(apartados.get(4));
                                            String dpi="";
                                            String email="";
                                            String direccion="";
                                            Client registroCliente = new Client(nombre, telefono, nit, dpi, credito, email, direccion);
                                            String respuesta = this.resistrarElemento.registroCliente(registroCliente);
                                            //Comprueba si hubo errores por parte de la base de datos
                                            if(!(respuesta.equals(""))){
                                                String mensaje = "Linea "+(i+1)+" "+respuesta;            
                                                erroresDeDatos.add(mensaje);
                                            }
                                        }
                                        else{
                                            String mensaje = "Linea "+(i+1)+" credito al cliente no valido";            
                                            erroresDeDatos.add(mensaje);
                                        }
                                    }
                                    else{
                                        String mensaje = "Linea "+(i+1)+" numero telefonico no valido";
                                        erroresDeDatos.add(mensaje);
                                    }
                                }
                                else{
                                    String mensaje = "Linea "+(i+1)+" numero telefonico no valido";            
                                    erroresDeDatos.add(mensaje);
                                }
                            }
                            else{
                                String mensaje = "Linea "+(i+1)+" El codigo CLIENTE debe ir con 5 datos y hay "+(cantidad+1)+" datos";            
                                erroresDeDatos.add(mensaje);
                            }
                        }

                        if(nombreApartado.equals("PRODUCTO")){
                            //Se cuenta la cantidad de datos que posee la palabra clave de reconocimiento
                            if(cantidad==6)
                            {
                                apartados=apartadoDeTexto(lineasDeTexto.get(i),",");
                                //verficamos si el texto ingresado es un numero
                                if(verificarRepresentacionNumerica(apartados.get(4))){
                                    //verifcamos si el texto es un numero en esta caso de tipo flotante
                                    if(verificarRepresentacionNumericaDecimal(apartados.get(5)))
                                    {
                                        System.out.println(lineasDeTexto.get(i));
                                        String name = apartados.get(1);
                                        String manufacturer = apartados.get(2);
                                        String code = apartados.get(3);
                                        int existencia = Integer.valueOf(apartados.get(4));
                                        float price = Float.valueOf(apartados.get(5));
                                        String description="";
                                        int garantia=0;
                                        String tienda = apartados.get(6);
                                        Product registroProducto = new Product(name, manufacturer, code, existencia, price, description, garantia, tienda);
                                        String respuesta = this.resistrarElemento.registroProducto(registroProducto);
                                        //Comprueba si hubo errores por parte de la base de datos
                                        if(!(respuesta.equals(""))){
                                            String mensaje = "Linea "+(i+1)+" "+respuesta;            
                                            erroresDeDatos.add(mensaje);
                                        }
                                    }
                                    else{
                                        String mensaje = "Linea "+(i+1)+" la sintaxis del precio del producto es incorrecto";            
                                        erroresDeDatos.add(mensaje);
                                    }
                                }
                                else{
                                    String mensaje = "Linea "+(i+1)+" la sintaxis de la cantidad del producto es incorrecta";            
                                    erroresDeDatos.add(mensaje);
                                }
                                
                            }
                            else{
                                String mensaje = "Linea "+(i+1)+" El codigo PRODUCTO debe ir con 7 datos y hay "+(cantidad+1)+" datos";            
                                erroresDeDatos.add(mensaje);
                            }
                        }

                        if(nombreApartado.equals("PEDIDO")){
                            //Se cuenta la cantidad de datos que posee la palabra clave de reconocimiento
                            if(cantidad==9)
                            {
                                apartados=apartadoDeTexto(lineasDeTexto.get(i),",");
                                if(validarFecha(apartados.get(4)))
                                {
                                    //verificacion de la cantidad del producto
                                    if(verificarRepresentacionNumerica(apartados.get(7))){
                                        //verificacion del total de la compra
                                        if(verificarRepresentacionNumericaDecimal(apartados.get(8))){
                                            //verificar el anticipo de la compra
                                            if(verificarRepresentacionNumericaDecimal(apartados.get(9))){
                                                System.out.println(lineasDeTexto.get(i));
                                                
                                                String codigo;
                                                String tienda1;
                                                String tienda2;
                                                String fecha;
                                                String cliente;
                                                String producto;
                                                int cantidadTraslado;
                                                float total;
                                                float anticipo;

                                                Pedido registroPedido = new Pedido(codigo, tienda1, tienda2, fecha, cliente, producto, cantidadTraslado, total, anticipo);
                                                String respuesta = this.resistrarElemento.registroPedido(registroPedido);
                                                //Comprueba si hubo errores por parte de la base de datos
                                                if(!(respuesta.equals(""))){
                                                    String mensaje = "Linea "+(i+1)+" "+respuesta;            
                                                    erroresDeDatos.add(mensaje);
                                                }
                                            }
                                            else{
                                                String mensaje = "Linea "+(i+1)+" el anticipo de compra tiene error de sintaxis";            
                                                erroresDeDatos.add(mensaje);
                                            }
                                        }
                                        else
                                        {
                                            String mensaje = "Linea "+(i+1)+" el total de compra tiene error de sintaxis";            
                                            erroresDeDatos.add(mensaje);
                                        }
                                    }
                                    else{
                                        String mensaje = "Linea "+(i+1)+" la cantidad del producto tiene error de sintaxis";            
                                        erroresDeDatos.add(mensaje);
                                    }

                                }
                                else{
                                    String mensaje = "Linea "+(i+1)+" sintaxis de fecha incorrecta, recuerde la sintaxis año/mes/dia";            
                                    erroresDeDatos.add(mensaje);
                                }
                            }
                            else{
                                String mensaje = "Linea "+(i+1)+" El codigo PRODUCTO debe ir con 7 datos y hay "+(cantidad+1)+" datos";            
                                erroresDeDatos.add(mensaje);
                            }
                        }

                    }
                    else
                    {
                        String mensaje = "Linea "+(i+1)+" palabra pricipal no corresponde a la base de datos";    
                        erroresDeDatos.add(mensaje);
                    }
                }
                else{
                    String mensaje = "Linea "+(i+1)+" Incongruencia en los datos hay una , al final de la linea";            
                    erroresDeDatos.add(mensaje);
                }

            }
            else{
                String mensaje = "Linea "+(i+1)+" La sistaxis no corresponde a la base de datos hay mas separdores de texto de los admitidos";
                erroresDeDatos.add(mensaje);
            }

        }
        //Apartado de los errores que se almacenan en un ArrayList
        /*System.out.println("Imprecion de errores");
        for (int j = 0; j < erroresDeDatos.size(); j++) {
            System.out.println(erroresDeDatos.get(j));
        }*/
        try {
            this.resistrarElemento.closeConection();
        } catch (Exception e) {
        }
    }
    /**
     * Devuelve el array con los datos del procesado
     * @return
     */
    public ArrayList<String> getLineasDeTexto() {
        return lineasDeTexto;
    }
    /**
     * Extra el texto ingresadno el inicio y el final de una cadena especifica
     * @param cadena
     * @param inicio
     * @param fin
     * @return
     */
    private static String extraerTexto(String cadena, int inicio, int fin){
        String temporal="";
        char []temporalLetras = new char[(fin-inicio)+1];
        int contador=0;
        //extraccion de caracteres en los limites descritos
        for (int i = inicio; i <= fin; i++) {
            temporalLetras[contador]=cadena.charAt(i);
            contador++;
        }
        //converscion de la cadena a un String
        temporal=String.valueOf(temporalLetras);
        return temporal;
    }
    /**
     * Cuneta la cantidad de caracteres de un tipo en array de tipo string y decuelve la cantidad
     * @param cadena
     * @param caracter
     * @return
     */
    private static int contarCaracter(String cadena,String caracter){
        int respuesta=0;
        int j=0;
        int k=0;
        do{
            if(cadena.indexOf(caracter, j)>-1){
                j=cadena.indexOf(caracter, j)+1;
                k++;
            }
        }while(cadena.indexOf(caracter, j)!=-1);
        respuesta=k;
        return respuesta;
    }
    /**
     * Compara el texto permitido y lo admite en la configuracion
     * @param textoProcesar
     * @return
     */
    private static boolean validarTexto(String textoProcesar){
        if(textoProcesar.equals("TIENDA")||textoProcesar.equals("TIEMPO")||textoProcesar.equals("PRODUCTO")||textoProcesar.equals("CLIENTE")||textoProcesar.equals("PEDIDO")||textoProcesar.equals("EMPLEADO")){
            return true;
        }
        else
        {
            return false;
        }
    }
    /**
     * Realiza la validacion de una fecha devueleve el valor en un booleano
     * @param fecha
     * @return
     */
    private static boolean validarFecha(String fecha){
        boolean resultado=false;
        if(contarCaracter(fecha, "-")==2&&fecha.indexOf("-",fecha.length()-2)!=(fecha.length()-1))
        {
            boolean flag1=false;
            boolean flag2=false;
            boolean flag3=false;

            ArrayList<String> fechaDesglosada = new ArrayList<String>();
            fechaDesglosada=apartadoDeTexto(fecha, "-");
            int anio =0;
            int mes=0;
            int dia=0;
            try {
                anio = Integer.parseInt(fechaDesglosada.get(0));
                mes = Integer.parseInt(fechaDesglosada.get(1));
                dia = Integer.parseInt(fechaDesglosada.get(2));
            } catch (Exception e) {
            //Comprovamos si los numeros ingresados verdaeramente representa una fecha
            }
            if(anio>=2020)
            {
                flag1=true;
            }
            if(mes>0&&mes<=12)
            {
                flag2=true;
            }
            if(dia>0&&dia<=31)
            {
                flag3=true;
            }
            if(flag1&&flag2&&flag3){
                resultado=true;
            }
        }
        else{
            resultado=false;
        }
        return resultado;
    }
    /**
     * Separa el texto reconociendo los caracteres configurados para realizarlo y lo almacena en un arraylist de tipo string 
     * @param arreglo
     * @param caracterDeApartado
     * @return
     */
    private static ArrayList<String> apartadoDeTexto(String arreglo,String caracterDeApartado){
        ArrayList<String> apartados = new ArrayList<String>();
        int inicio=0;
        int fin=0;
        fin=arreglo.indexOf(caracterDeApartado)-1;
        for (int i = 0; i < contarCaracter(arreglo, caracterDeApartado);i++) {
            apartados.add(extraerTexto(arreglo, inicio, fin));
            inicio=fin+2;
            fin=arreglo.indexOf(caracterDeApartado, inicio)-1;
        }
        fin= arreglo.length()-1;
        apartados.add(extraerTexto(arreglo, inicio, fin));
        return apartados;
    }
    /**
     * Verifica si el string ingresado realmente es un numero
     * @param numeroAEvaluar
     * @return
     */
    private boolean verificarRepresentacionNumerica(String numeroAEvaluar){
        boolean respuesta=false;
        long numero=-1;
        try {
            numero=Long.parseLong(numeroAEvaluar);
        } catch (Exception e) {
        }
        if(numero>=0)
        {
            respuesta=true;
        }
        return respuesta;

    }
    /**
     * Verifica se el texto es un numero en representacion decimal
     * @param numeroAEvaluar
     * @return
     */
    private boolean verificarRepresentacionNumericaDecimal(String numeroAEvaluar){
        boolean respuesta=false;
        float numero=-1;
        try {
            numero=Float.parseFloat(numeroAEvaluar);
        } catch (Exception e) {
        }
        if(numero>=0)
        {
            respuesta=true;
        }
        return respuesta;

    }
    /**
     * Verifica si el numero telefonico es valido
     * @param numeroTelefonico
     * @return
     */
    private boolean verificarNumeroTelefonico(String numeroTelefonico){
        if(numeroTelefonico.length()==8){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Verifica si el numero de DPI es valido
     * @param numeroTelefonico
     * @return
     */
    private boolean verificarDPI(String numeroTelefonico){
        if(numeroTelefonico.length()==10){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Regresa la cadena con los erroes correspondientes de la base de datos
     * @return
     */
    public ArrayList<String> getErroresDeDatos() {
        return erroresDeDatos;
    }
}