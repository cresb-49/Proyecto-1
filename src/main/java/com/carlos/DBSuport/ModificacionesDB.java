package com.carlos.DBSuport;
import java.sql.*;
import com.carlos.Entities.*;

/**
 * ModificacionesDB
 */
public class ModificacionesDB {
    /**
     * Constructor vacio de la clase modificaciones de los datos de la base de datos
     */
    public ModificacionesDB(){

    }
    /**
     * Modifica los datos existentes de un cliente
     * @param cliente
     * @param conexion
     * @return 
     */
    public String modificarCliente(Client cliente,Connection conexion){
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
        //declaracion de la consulta
        String consulta="UPDATE CLIENTE SET nombre = ?,telefono = ?,credito = ?,dpi = ?,email = ?,direccion = ? WHERE nit = ?";
        //Asignacion de los datos de la variables
        nombre=cliente.getName();
        telefono = cliente.getPhoneNumber();
        credito = cliente.getCreditoCompra();
        dpi = cliente.getDpi();
        email = cliente.getEmail();
        direccion = cliente.getDirection();
        nit=cliente.getNit();
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {

            preSt.setString(1,nombre);
            preSt.setString(2,telefono);
            preSt.setDouble(3,credito);
            preSt.setString(4,dpi);
            preSt.setString(5,email);
            preSt.setString(6,direccion);
            preSt.setString(7,nit);
            
            preSt.executeUpdate();
            
            preSt.close();
        } catch (SQLException e) {
            errores=e.getMessage();
            System.out.println(errores);
        }
        
        return errores;
    }
    /**
     * Modifica los datos de una tienda
     * @param tienda
     * @return 
     */
    public String modificarTienda(Store tienda,Connection conexion){
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
        String consulta="UPDATE TIENDA SET  nombre = ?,direccion = ?,telefono_1 = ?,telefono_2 = ?,email = ?,horario = ? WHERE codigo = ?";
        //Asignacion de los datos de la variables
        nombre = tienda.getNombre();
        direccion = tienda.getDireccion();
        telefono1 = tienda.getPhone1();
        telefono2 = tienda.getPhone2();
        email = tienda.getEmail();
        horario = tienda.getHorario();
        codigo = tienda.getStoreCode();
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {

            preSt.setString(1,nombre);
            preSt.setString(2,direccion);
            preSt.setString(3,telefono1);
            preSt.setString(4,telefono2);
            preSt.setString(5,email);
            preSt.setString(6,horario);
            preSt.setString(7,codigo);
            
            preSt.executeUpdate();
            
            preSt.close();
        } catch (SQLException e) {
            errores=e.getMessage();
            System.out.println(errores);
        }
        return errores;
    }
    /**
     * Modifica los datos de un empleado
     * @param empleado
     * @return 
     */
    public String modificarEmpleado(Employee empleado,Connection conexion){
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
        String consulta="UPDATE EMPLEADO SET nombre = ?,telefono = ?,dpi = ?,nit = ?,email = ?,direccion = ? WHERE codigo = ?";
        //Asignacion de los datos de la variables
        nombre = empleado.getName();
        telefono = empleado.getPhoneNumber();
        dpi = empleado.getDpi();
        nit = empleado.getNit();
        email = empleado.getEmail();
        direccion = empleado.getDirection();
        codigo=empleado.getEmployeeCode();
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {

            preSt.setString(1,nombre);
            preSt.setString(2,telefono);
            preSt.setString(3,dpi);
            preSt.setString(4,nit);
            preSt.setString(5,email);
            preSt.setString(6,direccion);
            preSt.setString(7,codigo);
            
            preSt.executeUpdate();
            
            preSt.close();
        } catch (SQLException e) {
            errores=e.getMessage();
            System.out.println(errores);
        }
        
        return errores;
    }
    /**
     * Modifica los datos de producto
     * @param producto
     * @return 
     */
    public String modificarProducto(Product producto,Connection conexion){
        //Respuesta de errores de sql
        String errores ="";
        //Declaracion de variables para insertar valores de la consulta 
        String name;
        String manufacturer;
        String code;
        float price;
        String description;
        int garantia;
        //declaracion de la consulta
        String consulta="UPDATE PRODUCTO SET nombre = ?,fabricante = ?,precio = ?,descripcion = ?,garantia = ? WHERE codigo = ?";
        //Asignacion de los datos de la variables
        name = producto.getName();
        manufacturer = producto.getManufacturer();
        price=producto.getPrice();
        description = producto.getDescription();
        garantia = producto.getGarantia();
        code = producto.getCode();
        
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {

            preSt.setString(1,name);
            preSt.setString(2,manufacturer);
            preSt.setDouble(3,price);
            preSt.setString(4,description);
            preSt.setInt(5,garantia);
            preSt.setString(6,code);
            
            preSt.executeUpdate();
            
            preSt.close();
        } catch (SQLException e) {
            errores=e.getMessage();
            System.out.println(errores);
        }
        
        return errores;
    }
    /**
     * Modifica la existencia de un producto
     * @param producto
     * @return 
     */
    public String modificarExistencia(Product producto,Connection conexion){
        //Respuesta de errores de sql
        String errores ="";
        //Declaracion de variables para insertar valores de la consulta 
        String code;
        int cantidad;
        String tienda;
        //declaracion de la consulta        
        String consulta="UPDATE EXISTENCIA SET cantidad = ? WHERE TIENDA_codigo = ? AND PRODUCTO_codigo = ?";
        //Asignacion de los datos de la variables
        cantidad = producto.getCantidad();
        tienda = producto.getTienda();
        code = producto.getCode();
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {

            preSt.setInt(1,cantidad);
            preSt.setString(2,tienda);
            preSt.setString(3,code);
            
            preSt.executeUpdate();
            
            preSt.close();
        } catch (SQLException e) {
            errores=e.getMessage();
            System.out.println(errores);
        }
        
        return errores;
    }
    /**
     * Modificacion del tiempo entre tiendas
     * @param tiempoDeTransporte
     * @return 
     */
    public String modificarTiempo(TimeStoreToStore tiempoDeTransporte,Connection conexion){
        //Respuesta de errores de sql
        String errores ="";
        //Declaracion de variables para insertar valores de la consulta 
        String codigoTienda1;
        String codigoTienda2;
        int tiempo;
        //declaracion de la consulta
        String consulta="UPDATE TIEMPO_TRASLADO SET tiempo = ? WHERE TIENDA_codigo1 = ? AND TIENDA_codigo2 = ?";
        //Asignacion de los datos de la variables
        tiempo = tiempoDeTransporte.getTime();
        codigoTienda1= tiempoDeTransporte.getStoreCode1();
        codigoTienda2 = tiempoDeTransporte.getStoreCode2();
        
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {

            preSt.setInt(1,tiempo);
            preSt.setString(2,codigoTienda1);
            preSt.setString(3,codigoTienda2);
            
            preSt.executeUpdate();
            
            preSt.close();
        } catch (SQLException e) {
            errores=e.getMessage();
            System.out.println(errores);
        }
        
        return errores;
    }
    /**
     * Modificacion de datos de un pedido
     * @param pedido
     * @return 
     */
    public String modificarPedido(Pedido pedido,Connection conexion){
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
        //declaracion de la consulta
        String consulta="UPDATE PEDIDO SET cantidad = ?,total = ?,anticipo = ?,fecha_orden = ?,CLIENTE_nit = ?,PRODUCTO_codigo = ?,TIENDA_codigo_salida = ?,TIENDA_codigo_llegada = ? WHERE codigo = ?";
        //Asignacion de los datos de la variables
        cantidad = pedido.getCantidad();
        total = pedido.getTotal();
        anticipo = pedido.getAnticipo();
        fecha = pedido.getFecha();
        cliente = pedido.getCliente();
        producto = pedido.getProducto();
        tienda1 = pedido.getTienda1();
        tienda2 = pedido.getTienda2();
        codigo = pedido.getCodigo();
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {

            preSt.setInt(1,cantidad);
            preSt.setDouble(2,total);
            preSt.setDouble(3,anticipo);
            preSt.setString(4,fecha);
            preSt.setString(5,cliente);
            preSt.setString(6,producto);
            preSt.setString(7,tienda1);
            preSt.setString(8,tienda2);
            preSt.setString(9,codigo);
            
            preSt.executeUpdate();
            
            preSt.close();
        } catch (SQLException e) {
            errores=e.getMessage();
            System.out.println(errores);
        }
                
        return errores;
    }
    /**
     * Modificacion del credito del cliente segun el nit
     * @param nit
     * @param creditoNuevo
     * @return 
     */
    public String modificarCreditoCliente(String nit, String creditoNuevo,Connection conexion){
        //Respuesta de errores de sql
        String errores ="";
        //declaracion de la consulta
        String consulta="UPDATE CLIENTE SET credito = ? where nit= ? ";
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {

            preSt.setString(1,creditoNuevo);
            preSt.setString(2,nit);
            
            preSt.executeUpdate();
            
            preSt.close();
        } catch (SQLException e) {
            errores=e.getMessage();
            System.out.println(errores);
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
    public String modificacionEstadoPedido(String codigoPedido,String estadoPedido,Connection conexion){
        //Respuesta de errores de sql
        String errores ="";
        //declaracion de la consulta
        String consulta="UPDATE PEDIDO SET estado_pedido = ? WHERE codigo = ?";
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {

            preSt.setString(1,estadoPedido);
            preSt.setString(2,codigoPedido);
                        
            preSt.executeUpdate();
            
            preSt.close();
        } catch (SQLException e) {
            errores=e.getMessage();
            System.out.println(errores);
        }
        return errores;
    }
}