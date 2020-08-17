package com.carlos.DBSuport;
import java.sql.*;
import com.carlos.Entities.*;

/**
 * ModificacionesDB
 */
public class ModificacionesDB {
    //VARIABLES DE CONEXION A BASE DE DATOS
    ConexionDB con = new ConexionDB();
    Connection cn;
    Statement st;
    ResultSet rs;
    /**
     * Constructor vacio de la clase modificaciones de los datos de la base de datos
     */
    public ModificacionesDB(){

    }
    public String modificarCliente(Client cliente){
        //Respuesta de errores de sql
        String errores ="";
        //Declaracion de variables para insertar valores de la consulta
        String nit;
        String nombre;
        String telefono;
        float credito;
        String dpi;
        String email;
        String direccion;
        //Asignacion de los datos de la variables
        nit=cliente.getNit();
        nombre=cliente.getName();
        telefono = cliente.getPhoneNumber();
        credito = cliente.getCreditoCompra();
        dpi = cliente.getDpi();
        email = cliente.getEmail();
        direccion = cliente.getDirection();
        //declaracion de la consulta
        String consulta="UPDATE CLIENTE SET nombre = '"+nombre+"',telefono = '"+telefono+"',credito = '"+credito+"',dpi = '"+dpi+"',email = '"+email+"',direccion = '"+direccion+"' WHERE nit = '"+nit+"'";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            st.executeUpdate(consulta);
        } catch (Exception e) {
            errores=e.getMessage();
        }
        return errores;
    }
    public String modificarTienda(Store tienda){
         //Respuesta de errores de sql
        String errores ="";
        //Declaracion de variables para insertar valores de la consulta 
        String codigo;
        String nombre;
        String direccion;
        String telefono1;
        String telefono2;
        String email;
        String horario;
        //Asignacion de los datos de la variables
        codigo = tienda.getStoreCode();
        nombre = tienda.getNombre();
        direccion = tienda.getDireccion();
        telefono1 = tienda.getPhone1();
        telefono2 = tienda.getPhone2();
        email = tienda.getEmail();
        horario = tienda.getHorario();
        
        //declaracion de la consulta
        String consulta="UPDATE TIENDA SET  nombre = '"+nombre+"',direccion = '"+direccion+"',telefono_1 = '"+telefono1+"',telefono_2 = '"+telefono2+"',email = '"+email+"',horario = '"+horario+"' WHERE codigo = '"+codigo+"'";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            st.executeUpdate(consulta);
        } catch (Exception e) {
            errores=e.getMessage();
        }
        
        return errores;
    }
    public String modificarEmpleado(Employee empleado){
        //Respuesta de errores de sql
        String errores ="";
        //Declaracion de variables para insertar valores de la consulta 
        String codigo;
        String nombre;
        String telefono;
        String dpi;
        String nit;
        String email;
        String direccion;
        //Asignacion de los datos de la variables
        codigo=empleado.getEmployeeCode();
        nombre = empleado.getName();
        telefono = empleado.getPhoneNumber();
        dpi = empleado.getDpi();
        nit = empleado.getNit();
        email = empleado.getEmail();
        direccion = empleado.getDirection();
        //declaracion de la consulta
        String consulta="UPDATE EMPLEADO SET nombre = '"+nombre+"',telefono = '"+telefono+"',dpi = '"+dpi+"',nit = '"+nit+"',email = '"+email+"',direccion = '"+direccion+"' WHERE codigo = '"+codigo+"'";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            st.executeUpdate(consulta);
        } catch (Exception e) {
            errores=e.getMessage();
        }
        
        return errores;
    }
    public String modificarProducto(Product producto){
        //Respuesta de errores de sql
        String errores ="";
        //Declaracion de variables para insertar valores de la consulta 
        String name;
        String manufacturer;
        String code;
        int cantidad;
        float price;
        String description;
        int garantia;
        String tienda;
        //Asignacion de los datos de la variables
        name = producto.getName();
        manufacturer = producto.getManufacturer();
        code = producto.getCode();
        cantidad = producto.getCantidad();
        price=producto.getPrice();
        description = producto.getDescription();
        garantia = producto.getGarantia();
        tienda = producto.getTienda();
        //declaracion de la consulta
        String consulta="UPDATE PRODUCTO SET nombre = '"+name+"',fabricante = '"+manufacturer+"',precio = '"+price+"',descripcion = '"+description+"',garantia = '"+garantia+"' WHERE codigo = '"+code+"'";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            //INGRESO DE LOS VALORES A LA BASE DE DATOS
            st.executeUpdate(consulta);
        } catch (Exception e) {
            errores=e.getMessage();
        }
        
        return errores;
    }
    public String modificarExistencia(Product producto){
        //Respuesta de errores de sql
        String errores ="";
        //Declaracion de variables para insertar valores de la consulta 
        String code;
        int cantidad;
        String tienda;
        //Asignacion de los datos de la variables
        code = producto.getCode();
        cantidad = producto.getCantidad();
        tienda = producto.getTienda();
        //declaracion de la consulta        
        String consulta="UPDATE EXISTENCIA SET cantidad = '"+cantidad+"' WHERE TIENDA_codigo = '"+tienda+"' AND PRODUCTO_codigo = '"+code+"'";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            //INGRESO DE LOS VALORES A LA BASE DE DATOS
            st.executeUpdate(consulta);
        } catch (Exception e) {
            errores=e.getMessage();
        }
        
        return errores;
    }
    public String modificarTiempo(TimeStoreToStore tiempoDeTransporte){
        //Respuesta de errores de sql
        String errores ="";
        //Declaracion de variables para insertar valores de la consulta 
        String codigoTienda1;
        String codigoTienda2;
        int tiempo;
        //Asignacion de los datos de la variables
        codigoTienda1= tiempoDeTransporte.getStoreCode1();
        codigoTienda2 = tiempoDeTransporte.getStoreCode2();
        tiempo = tiempoDeTransporte.getTime();
        //declaracion de la consulta
        String consulta="UPDATE TIEMPO_TRASLADO SET tiempo = '"+tiempo+"' WHERE TIENDA_codigo1 = '"+codigoTienda1+"',TIENDA_codigo2 = '"+codigoTienda2+"'";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            st.executeUpdate(consulta);
        } catch (Exception e) {
            errores=e.getMessage();
        }
        
        return errores;
    }

    public String modificarPedido(Pedido pedido){
        //Respuesta de errores de sql
        String errores ="";
        //Declaracion de variables para insertar valores de la consulta 
        String codigo;
        String tienda1;
        String tienda2;
        String fecha;
        String cliente;
        String producto;
        int cantidad;
        float total;
        float anticipo;
        //Asignacion de los datos de la variables
        codigo = pedido.getCodigo();
        tienda1 = pedido.getTienda1();
        tienda2 = pedido.getTienda2();
        fecha = pedido.getFecha();
        cliente = pedido.getCliente();
        producto = pedido.getProducto();
        cantidad = pedido.getCantidad();
        total = pedido.getTotal();
        anticipo = pedido.getAnticipo();
        //declaracion de la consulta
        String consulta="UPDATE PEDIDO SET cantidad = '"+cantidad+"',total = '"+total+"',anticipo = '"+anticipo+"',fecha_orden = '"+fecha+"',CLIENTE_nit = '"+cliente+"',PRODUCTO_codigo = '"+producto+"',TIENDA_codigo_salida = '"+tienda1+"',TIENDA_codigo_llegada = '"+tienda2+"' WHERE codigo = '"+codigo+"'";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            //INGRESO DE LOS VALORES A LA BASE DE DATOS
            st.executeUpdate(consulta);
        } catch (Exception e) {
            errores=e.getMessage();
        }
        
        return errores;
    }
    public void closeConection() throws SQLException{
        con.cerrar();
    }
    
    public String modificarCreditoCliente(String nit, String creditoNuevo){
        //Respuesta de errores de sql
        String errores ="";
        //declaracion de la consulta
        String consulta="update CLIENTE set credito='"+creditoNuevo+"' where nit='"+nit+"';";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            //INGRESO DE LOS VALORES A LA BASE DE DATOS
            st.executeUpdate(consulta);
        } catch (Exception e) {
            errores=e.getMessage();
        }
        
        return errores;
    }
    /**
     * Cambia el estado del pedido es entrega
     *  "ET" en trafico, "T" en tienda, "R" retraso, "E" entegado
     * @param codigoPedido
     * @param estadoPedido
     * @return
     */
    private String moficiacionEstadoPedido(String codigoPedido,String estadoPedido){
        //Respuesta de errores de sql
        String errores ="";
        //declaracion de la consulta
        String consulta="UPDATE PEDIDO SET estado_pedido='"+estadoPedido+"' WHERE codigo ='"+codigoPedido+"';";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            //INGRESO DE LOS VALORES A LA BASE DE DATOS
            st.executeUpdate(consulta);
        } catch (Exception e) {
            errores=e.getMessage();
        }
        
        return errores;
    }
}