package com.carlos.DBSuport;
import java.sql.*;

import com.carlos.Entities.*;


public class RegistroDB {
    //VARIABLES DE CONEXION A BASE DE DATOS
    ConexionDB con = new ConexionDB();
    Connection cn;
    Statement st;
    ResultSet rs;

    public RegistroDB(){

    }
    public String registroCliente(Client cliente){
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
        String consulta="INSERT INTO CLIENTE (nit,nombre,telefono,credito,dpi,email,direccion) VALUES ('"+nit+"','"+nombre+"','"+telefono+"','"+credito+"','"+dpi+"','"+email+"','"+direccion+"') ";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            st.executeUpdate(consulta);
        } catch (Exception e) {
            errores=e.getMessage();
        }
        return errores;
    }
    public String registroTienda(Store tienda){
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
        String consulta="INSERT INTO TIENDA (codigo,nombre,direccion,telefono_1,telefono_2,email,horario) VALUES ('"+codigo+"','"+nombre+"','"+direccion+"','"+telefono1+"','"+telefono2+"','"+email+"','"+horario+"') ";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            st.executeUpdate(consulta);
        } catch (Exception e) {
            errores=e.getMessage();
        }
        
        return errores;
    }
    public String registroEmpleado(Employee empleado){
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
        String consulta="INSERT INTO EMPLEADO (codigo,nombre,telefono,dpi,nit,email,direccion) VALUES ('"+codigo+"','"+nombre+"','"+telefono+"','"+dpi+"','"+nit+"','"+email+"','"+direccion+"') ";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            st.executeUpdate(consulta);
        } catch (Exception e) {
            errores=e.getMessage();
        }
        
        return errores;
    }
    public String registroProducto(Product producto){
        //Respuesta de errores de sql
        String errores ="";
        //Declaracion de variables para insertar valores de la consulta 
        String name;
        String manufacturer;
        String code;
        float price;
        String description;
        int garantia;
        //Asignacion de los datos de la variables
        name = producto.getName();
        manufacturer = producto.getManufacturer();
        code = producto.getCode();
        price=producto.getPrice();
        description = producto.getDescription();
        garantia = producto.getGarantia();
        //declaracion de la consulta
        String consulta="INSERT INTO PRODUCTO (codigo,nombre,fabricante,precio,descripcion,garantia) VALUES ('"+code+"','"+name+"','"+manufacturer+"','"+price+"','"+description+"','"+garantia+"') ";
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
    public String registroExistencia(Product producto){
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
        String consulta="INSERT INTO EXISTENCIA (TIENDA_codigo,PRODUCTO_codigo,cantidad) VALUES ('"+tienda+"','"+code+"','"+cantidad+"') ";
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
    public String registroTiempo(TimeStoreToStore tiempoDeTransporte){
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
        String consulta="INSERT INTO TIEMPO_TRASLADO (TIENDA_codigo1,TIENDA_codigo2,tiempo) VALUES ('"+codigoTienda1+"','"+codigoTienda2+"','"+tiempo+"') ";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            st.executeUpdate(consulta);
        } catch (Exception e) {
            errores=e.getMessage();
        }
        
        return errores;
    }
    public void closeConection() throws SQLException{
        con.cerrar();
    }
    public String registroPedido(Pedido pedido){
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
        String consulta="INSERT INTO PEDIDO (codigo,cantidad,total,anticipo,fecha_orden,estado_pedido,CLIENTE_nit,PRODUCTO_codigo,TIENDA_codigo_salida,TIENDA_codigo_llegada) VALUES ('"+codigo+"','"+cantidad+"','"+total+"','"+anticipo+"','"+fecha+"','ET','"+cliente+"','"+producto+"','"+tienda1+"','"+tienda2+"') ";
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
    public String registroVenta(Ventas venta){
        //Respuesta de errores de sql
        String errores ="";
        //Declaracion de variables para insertar valores de la consulta
        String tiendaCodigo;
        String productoCodigo;
        String nit;
        String fecha;
        int cantidadProducto;
        //Asignacion de los datos de la variables
        tiendaCodigo= venta.getCodigoTienda();
        productoCodigo= venta.getCodigoProducto();
        nit = venta.getNitCliente();
        fecha = venta.getFecha();
        cantidadProducto = venta.getCantidad();
        //declaracion de la consulta
        String consulta="INSERT INTO VENTAS (TIENDA_codigo,PRODUCTO_codigo,CLIENTE_nit,fecha_venta,cantidad_producto) VALUES('"+tiendaCodigo+"','"+productoCodigo+"','"+nit+"','"+fecha+"','"+cantidadProducto+"')";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            st.executeUpdate(consulta);
        } catch (Exception e) {
            errores=e.getMessage();
        }
        return errores;
    }
}