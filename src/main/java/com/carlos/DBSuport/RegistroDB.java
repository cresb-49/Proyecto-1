package com.carlos.DBSuport;
import java.sql.*;

import com.carlos.Entities.*;


public class RegistroDB {
    private ConsultasDB consDB = new ConsultasDB();
    /**
     * CONSTRUCTOR VACIO DE LA CLASE DE REGISTRO EN BASE DE DATOS
     */
    public RegistroDB(){

    }
    /**
     * Metodo en el cual se registran los clientes en la base de datos
     * @param cliente
     * @param conexion
     * @return
     */
    public String registroCliente(Client cliente,Connection conexion){
        //Respuesta de errores de sql
        String errores ="";
        //Declaracion de variables para insertar valores de la consulta
        String nit;
        String nombre;
        String telefono;
        double credito;
        String dpi;
        String email;
        String direccion;
        //declaracion de la consulta
        String query ="INSERT INTO CLIENTE VALUES (?,?,?,?,?,?,?)";
        //Asignacion de los datos de la variables
        nit=cliente.getNit();
        nombre=cliente.getName();
        telefono = cliente.getPhoneNumber();
        credito = cliente.getCreditoCompra();
        dpi = cliente.getDpi();
        email = cliente.getEmail();
        direccion = cliente.getDirection();
        
        try(PreparedStatement preSt = conexion.prepareStatement(query)) {
            preSt.setString(1,nit);
            preSt.setString(2,nombre);
            preSt.setString(3,telefono);
            preSt.setDouble(4,credito);
            preSt.setString(5,dpi);
            preSt.setString(6,email);
            preSt.setString(7,direccion);
            preSt.executeUpdate();
            preSt.close();
        } catch (Exception e) {
            errores=e.getMessage();
        }
        return errores;
        
    }
    /**
     * Metodo en el cual se registran las tiendas en una base de datos
     * @param tienda
     * @param conexion
     * @return
     */
    public String registroTienda(Store tienda,Connection conexion){
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
        
        //declaracion de la consulta
        String query ="INSERT INTO TIENDA VALUES (?,?,?,?,?,?,?)";
        //Asignacion de los datos de la variables
        codigo = tienda.getStoreCode();
        nombre = tienda.getNombre();
        direccion = tienda.getDireccion();
        telefono1 = tienda.getPhone1();
        telefono2 = tienda.getPhone2();
        email = tienda.getEmail();
        horario = tienda.getHorario();
        
        try(PreparedStatement preSt = conexion.prepareStatement(query)) {
            preSt.setString(1,codigo);
            preSt.setString(2,nombre);
            preSt.setString(3,direccion);
            preSt.setString(4,telefono1);
            preSt.setString(5,telefono2);
            preSt.setString(6,email);
            preSt.setString(7,horario);
            preSt.executeUpdate();
            preSt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            errores=e.getMessage();
        }
        return errores;
    }
    /**
     * Metodo en el cual se registran los datos de los empleados en la base de datos
     * @param empleado
     * @param conexion
     * @return
     */
    public String registroEmpleado(Employee empleado,Connection conexion){
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
        //declaracion de la consulta
        String query ="INSERT INTO EMPLEADO VALUES (?,?,?,?,?,?,?)";
        //Asignacion de los datos de la variables
        codigo=empleado.getEmployeeCode();
        nombre = empleado.getName();
        telefono = empleado.getPhoneNumber();
        dpi = empleado.getDpi();
        nit = empleado.getNit();
        email = empleado.getEmail();
        direccion = empleado.getDirection();
        
        try(PreparedStatement preSt = conexion.prepareStatement(query)) {
            preSt.setString(1,codigo);
            preSt.setString(2,nombre);
            preSt.setString(3,telefono);
            preSt.setString(4,dpi);
            preSt.setString(5,nit);
            preSt.setString(6,email);
            preSt.setString(7,direccion);
            preSt.executeUpdate();
            preSt.close();
        } catch (Exception e) {
            errores=e.getMessage();
        }
        return errores;
    }
    /**
     * Metodo en el cual se registran los productos en la base de datos
     * @param producto
     * @param conexion
     * @return
     */
    public String registroProducto(Product producto,Connection conexion){
        //Respuesta de errores de sql
        String errores ="";
        //Declaracion de variables para insertar valores de la consulta 
        String name;
        String manufacturer;
        String code;
        double price;
        String description;
        int garantia;
        //Ceracion de la consulta que se hara en la base de datos
        String query ="INSERT INTO PRODUCTO VALUES (?,?,?,?,?,?)";
        //Asignacion de los datos de la variables
        code = producto.getCode();
        name = producto.getName();
        manufacturer = producto.getManufacturer();
        price=producto.getPrice();
        description = producto.getDescription();
        garantia = producto.getGarantia();
        System.out.println(price);
        
        try(PreparedStatement preSt = conexion.prepareStatement(query)) {
            preSt.setString(1,code);
            preSt.setString(2,name);
            preSt.setString(3,manufacturer);
            preSt.setDouble(4,price);
            preSt.setString(5,description);
            preSt.setInt(6,garantia);
            preSt.executeUpdate();
            preSt.close();
        } catch (Exception e) {
            errores=e.getMessage();
        }
        return errores;
    }
    /**
     * Metodo en el cual se registran la existencia de un producto determinado
     * @param producto
     * @param conexion
     * @return
     */
    public String registroExistencia(Product producto,Connection conexion){
        //Respuesta de errores de sql
        String errores ="";
        //Declaracion de variables para insertar valores de la consulta 
        String codeProducto;
        int cantidad;
        String tienda;
        //Ceracion de la consulta que se hara en la base de datos
        String query ="INSERT INTO EXISTENCIA (TIENDA_codigo,PRODUCTO_codigo,cantidad) VALUES (?,?,?)";
        //Asignacion de los datos de la variables
        codeProducto = producto.getCode();
        cantidad = producto.getCantidad();
        tienda = producto.getTienda();
        if(this.consDB.datosExistenciaProducto(codeProducto,tienda,conexion).equals("")){
            try(PreparedStatement preSt = conexion.prepareStatement(query)) {
                preSt.setString(1,tienda);
                preSt.setString(2,codeProducto);
                preSt.setInt(3,cantidad);
                preSt.executeUpdate();

                preSt.close();
            } catch (Exception e) {
                errores=e.getMessage();
            }
        }
        else{
            errores = "Referencias de producto ya registradas";
        }
        return errores;
    }
    /**
     * Se registra el tiempo entre las tiendas
     * @param tiempoDeTransporte
     * @param conexion
     * @return
     */
    public String registroTiempo(TimeStoreToStore tiempoDeTransporte,Connection conexion){
        //Respuesta de errores de sql
        String errores ="";
        //Declaracion de variables para insertar valores de la consulta 
        String codigoTienda1;
        String codigoTienda2;
        int tiempo;
        //Ceracion de la consulta que se hara en la base de datos
        String query ="INSERT INTO TIEMPO_TRASLADO (TIENDA_codigo1,TIENDA_codigo2,tiempo) VALUES (?,?,?)";
        //Asignacion del valor de la variables
        codigoTienda1= tiempoDeTransporte.getStoreCode1();
        codigoTienda2 = tiempoDeTransporte.getStoreCode2();
        tiempo = tiempoDeTransporte.getTime();
        
        try(PreparedStatement preSt = conexion.prepareStatement(query)) {
            preSt.setString(1,codigoTienda1);
            preSt.setString(2,codigoTienda2);
            preSt.setInt(3,tiempo);
            preSt.executeUpdate();
            //Cierre de la instruccion
            preSt.close();
        } catch (Exception e) {
            errores=e.getMessage();
        }
        
        return errores;
    }
    /**
     * Metodo en el cual se registran los pedidos en base de datos
     * @param pedido
     * @param conexion
     * @return
     */
    public String registroPedido(Pedido pedido,Connection conexion){
        //Respuesta de errores de sql
        String errores ="";
        //Declaracion de variables para insertar valores de la consulta 
        String codigo;
        String tienda1;
        String tienda2;
        String fecha;
        String estadoPedido;
        String cliente;
        String producto;
        int cantidad;
        double total;
        double anticipo;
        //Ceracion de la consulta que se hara en la base de datos
        String query ="INSERT INTO PEDIDO (codigo,cantidad,total,anticipo,fecha_orden,estado_pedido,CLIENTE_nit,PRODUCTO_codigo,TIENDA_codigo_salida,TIENDA_codigo_llegada) VALUES (?,?,?,?,?,?,?,?,?,?)";
        //Asignacion de los datos de la variables
        codigo = pedido.getCodigo();
        tienda1 = pedido.getTienda1();
        tienda2 = pedido.getTienda2();
        fecha = pedido.getFecha();
        estadoPedido = "ET";
        cliente = pedido.getCliente();
        producto = pedido.getProducto();
        cantidad = pedido.getCantidad();
        total = pedido.getTotal();
        anticipo = pedido.getAnticipo();
        
        try(PreparedStatement preSt = conexion.prepareStatement(query)) {
            preSt.setString(1,codigo);
            preSt.setInt(2,cantidad);
            preSt.setDouble(3,total);
            preSt.setDouble(4,anticipo);
            preSt.setString(5,fecha);
            preSt.setString(6,estadoPedido);
            preSt.setString(7,cliente);
            preSt.setString(8,producto);
            preSt.setString(9,tienda1);
            preSt.setString(10,tienda2);
            //Ejecucion de la sentencia
            preSt.executeUpdate();
            //Cierre de la instruccion
            preSt.close();
        } catch (Exception e) {
            errores=e.getMessage();
        }
        return errores;
    }
    /**
     * Metodo en el cual se registran las ventas en la base de datos
     * @param venta
     * @param conexion
     * @return
     */
    public String registroVenta(Ventas venta,Connection conexion){
        //Respuesta de errores de sql
        String errores ="";
        //Declaracion de variables para insertar valores de la consulta
        String tiendaCodigo;
        String productoCodigo;
        String nit;
        String fecha;
        int cantidadProducto;
        //Ceracion de la consulta que se hara en la base de datos
        String query ="INSERT INTO VENTAS (TIENDA_codigo,PRODUCTO_codigo,CLIENTE_nit,fecha_venta,cantidad_producto) VALUES (?,?,?,?,?)";
        //Asignacion de los datos de la variables
        tiendaCodigo= venta.getCodigoTienda();
        productoCodigo= venta.getCodigoProducto();
        nit = venta.getNitCliente();
        fecha = venta.getFecha();
        cantidadProducto = venta.getCantidad();
        
        try(PreparedStatement preSt = conexion.prepareStatement(query)) {
            preSt.setString(1,tiendaCodigo);
            preSt.setString(2,productoCodigo);
            preSt.setString(3,nit);
            preSt.setString(4,fecha);
            preSt.setInt(5,cantidadProducto);
            //Ejecucion de la sentencia
            preSt.executeUpdate();
            //Cierre de la instruccion
            preSt.close();
        } catch (Exception e) {
            errores=e.getMessage();
        }
        return errores;
    }
}