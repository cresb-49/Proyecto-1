package com.carlos.TraslateDB;

import java.io.*;
import java.util.*;

public class InputTextOLD {

    private String src = "/home/benjamin/Documents/Proyectos IPC2 2020/archivosprueba/";
    private ArrayList<String> lineasDeTexto = new ArrayList<String>();
    private ArrayList<String> erroresDeDatos = new ArrayList<String>();

    public InputTextOLD(){

    }
    /**
     * Ingreso de los datos existentes en una base de datos
     */
    public void  LecturaEIngreso(){
        File textoDeExtrada = new File(src+"simple data.txt");
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
            if (cantidad==3 || cantidad==9||cantidad==4)
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
                                //Verifiacion del numeror telefonico
                                if(verificarRepresentacionNumerica(apartados.get(4))){
                                    System.out.println(lineasDeTexto.get(i));
                                    apartados=apartadoDeTexto(lineasDeTexto.get(i),",");
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
                                String mensaje = "Linea "+(i+1)+" El codigo TIENDA debe ir con 4 datos y hay "+(cantidad+1)+" datos";            
                                erroresDeDatos.add(mensaje);
                            }
                        }

                        if(nombreApartado.equals("EMPLEADO")){
                            //Se cuenta la cantidad de datos que posee la palabra clave de reconocimiento
                            if(cantidad==4){
                                if(verificarRepresentacionNumerica(apartados.get(3))){
                                    if(verificarRepresentacionNumerica(apartados.get(4))){
                                        System.out.println(lineasDeTexto.get(i));
                                        apartados=apartadoDeTexto(lineasDeTexto.get(i),",");
                                        /*
                                        for (int j = 0; j < cantidad+1; j++) {
                                        System.out.println(apartados.get(j));
                                        }
                                        */
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
                                String mensaje = "Linea "+(i+1)+" El codigo EMPLEADO debe ir con 4 datos y hay "+(cantidad+1)+" datos";            
                                erroresDeDatos.add(mensaje);
                            }
                        }

                        if(nombreApartado.equals("TIEMPO")){
                            //Se cuenta la cantidad de datos que posee la palabra clave de reconocimiento
                            if(cantidad==3)
                            {
                                if(verificarRepresentacionNumerica(apartados.get(3))){
                                    System.out.println(lineasDeTexto.get(i));
                                    apartados=apartadoDeTexto(lineasDeTexto.get(i),",");
                                    
                                    /*
                                    for (int j = 0; j < cantidad+1; j++) {
                                        System.out.println(apartados.get(j));
                                    }
                                    */
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
                                    //Verificacion de forma flotante del dinero
                                    if(verificarRepresentacionNumericaDecimal(apartados.get(4))){
                                        System.out.println(lineasDeTexto.get(i));
                                        /*
                                        for (int j = 0; j < cantidad+1; j++) {
                                            System.out.println(apartados.get(j));
                                        }
                                        */
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
                                String mensaje = "Linea "+(i+1)+" El codigo CLIENTE debe ir con 5 datos y hay "+(cantidad+1)+" datos";            
                                erroresDeDatos.add(mensaje);
                            }
                        }

                        if(nombreApartado.equals("PRODUCTO")){
                            //Se cuenta la cantidad de datos que posee la palabra clave de reconocimiento
                            if(cantidad==6)
                            {
                                apartados=apartadoDeTexto(lineasDeTexto.get(i),",");
                                /*
                                for (int j = 0; j < cantidad+1; j++) {
                                    System.out.println(apartados.get(j));
                                }
                                */
                                //verficamos si el texto ingreado es un numero
                                if(verificarRepresentacionNumerica(apartados.get(4))){
                                    //verifcamos si el texto es un numero en esta caso de tipo flotante
                                    if(verificarRepresentacionNumericaDecimal(apartados.get(5)))
                                    {
                                        System.out.println(lineasDeTexto.get(i));
                                        
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
                                                /*
                                                for (int j = 0; j < cantidad+1; j++) {
                                                    System.out.println(apartados.get(j));
                                                }
                                                */
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
                String mensaje = "Linea "+(i+1)+" La sistaxis no corresponde a la base de datos";
                erroresDeDatos.add(mensaje);
            }

        }
        //Apartado de los errores que se almacenan en un ArrayList
        System.out.println("Imprecion de errores");
        for (int j = 0; j < erroresDeDatos.size(); j++) {
            System.out.println(erroresDeDatos.get(j));
        }
    }
    /**
     * Establecemos el directorio del archivo procesado
     * @param src
     */
    public void setSrc(String src) {
        this.src = src;
    }
    /**
     * Devuelve el directorio del archivo procesado
     * @return
     */
    public String getSrc() {
        return src;
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
        int numero=-1;
        try {
            numero=Integer.parseInt(numeroAEvaluar);
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
}