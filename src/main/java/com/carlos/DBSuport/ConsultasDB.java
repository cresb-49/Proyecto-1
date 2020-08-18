package com.carlos.DBSuport;

import com.carlos.Entities.Pedido;
import java.sql.*;
import java.util.ArrayList;

public class ConsultasDB {

    private ConexionDB con = new ConexionDB();
    private Connection cn;
    private Statement st;
    private ResultSet rs;
    /**
     * CONSTRUCTOR VACIO DE LA CLASE
     */
    public ConsultasDB(){
        try {
            con = new ConexionDB();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public int consultaUsuarios(String nombre,String codeNIT){
        int respuesta = 0;
        String consulta = "SELECT nombre,nit FROM CLIENTE WHERE nit = '"+codeNIT+"' AND nombre = '"+nombre+"'";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                respuesta=1;
            }
        } catch (Exception e) {
        }
        String consulta2 = "SELECT nombre,codigo FROM EMPLEADO WHERE codigo = '"+codeNIT+"' AND nombre = '"+nombre+"'";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta2);
            while(rs.next()){
                respuesta=2;
            }
        } catch (Exception e) {
        }
        return respuesta;
    }
    public ArrayList<String> consultaDeTiendas(){
        ArrayList<String> tiendasDisponibles = new ArrayList<String>();
        String consulta="SELECT nombre FROM TIENDA";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                tiendasDisponibles.add(rs.getString("nombre"));
            }
        } catch (Exception e) {
        }
        return tiendasDisponibles;
    }
    public ArrayList<String> codigosDeTiendas(){
        ArrayList<String> tiendasDisponibles = new ArrayList<String>();
        String consulta="SELECT codigo FROM TIENDA";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                tiendasDisponibles.add(rs.getString("codigo"));
            }
        } catch (Exception e) {
        }
        return tiendasDisponibles;
    }
    
    public ArrayList<String> datosCliente(String nit){
        ArrayList<String> cliente = new ArrayList<String>();
        String consulta="SELECT nombre,telefono,credito,dpi,email,direccion FROM CLIENTE WHERE nit = '"+nit+"'";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                cliente.add(rs.getString(1));
                cliente.add(rs.getString(2));
                cliente.add(rs.getString(3));
                cliente.add(rs.getString(4));
                cliente.add(rs.getString(5));
                cliente.add(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return cliente;
    }
    public ArrayList<String> datosEmpleado(String codigo){
        ArrayList<String> cliente = new ArrayList<String>();
        String consulta="SELECT nombre,telefono,dpi,nit,email,direccion FROM EMPLEADO WHERE codigo = '"+codigo+"'";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                cliente.add(rs.getString(1));
                cliente.add(rs.getString(2));
                cliente.add(rs.getString(3));
                cliente.add(rs.getString(4));
                cliente.add(rs.getString(5));
                cliente.add(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return cliente;
    }
    public ArrayList<String> datosTienda(String codigo){
        ArrayList<String> cliente = new ArrayList<String>();
        String consulta="SELECT nombre,direccion,telefono_1,telefono_2,email,horario FROM TIENDA WHERE codigo = '"+codigo+"'";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                cliente.add(rs.getString(1));
                cliente.add(rs.getString(2));
                cliente.add(rs.getString(3));
                cliente.add(rs.getString(4));
                cliente.add(rs.getString(5));
                cliente.add(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return cliente;
    }
    public String codigoTienda(String nombre){
        String cliente ="";
        String consulta="SELECT codigo FROM TIENDA WHERE nombre = '"+nombre+"'";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                cliente = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return cliente;
    }
    
    public ArrayList<String> tiempoEntreTiendas(String codigoTienda1,String codigoTienda2){
        ArrayList<String> tiempo = new ArrayList<String>();
        String consulta="SELECT tiempo,codigo FROM TIEMPO_TRASLADO WHERE TIENDA_codigo1 = '"+codigoTienda1+"' AND TIENDA_codigo2 = '"+codigoTienda2+"'";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                tiempo.add(rs.getString(1));
                tiempo.add(rs.getString(2));
            }
        } catch (Exception e) {
        }
        return tiempo;
    }
    public ArrayList<String> datosProducto(String codigo){
        ArrayList<String> datosProducto = new ArrayList<String>();
        
        String consulta="SELECT nombre,fabricante,precio,descripcion,garantia FROM PRODUCTO WHERE codigo = '"+codigo+"'";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                datosProducto.add(rs.getString(1));
                datosProducto.add(rs.getString(2));
                datosProducto.add(rs.getString(3));
                datosProducto.add(rs.getString(4));
                datosProducto.add(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return datosProducto;
    }
    public String datosExistenciaProducto(String codigo,String codigoTienda){
        String datosProducto = "";
        
        String consulta="SELECT cantidad FROM EXISTENCIA WHERE PRODUCTO_codigo = '"+codigo+"' AND TIENDA_codigo = '"+codigoTienda+"'";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                datosProducto = rs.getString(1);
            }
        }
        catch (Exception e) {
            
        }
        return datosProducto;
    }
    public ArrayList<String> productoDeUnPedido(String codigo){
        ArrayList<String> datosProducto = new ArrayList<String>();
        
        String consulta="SELECT PRODUCTO_codigo FROM PEDIDO WHERE codigo = '"+codigo+"'";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                datosProducto.add(rs.getString(1));
            }
        } catch (Exception e) {
        }
        return datosProducto;
    }
    public ArrayList<String> estadoPedido(String codigoPedido){
        ArrayList<String> datosProducto = new ArrayList<String>();
        
        String consulta="SELECT cantidad,total,anticipo,fecha_orden,estado_pedido,CLIENTE_nit,PRODUCTO_codigo,TIENDA_codigo_salida,TIENDA_codigo_llegada FROM PEDIDO WHERE codigo = '"+codigoPedido+"' LIMIT 1";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                datosProducto.add(rs.getString(1));
                datosProducto.add(rs.getString(2));
                datosProducto.add(rs.getString(3));
                datosProducto.add(rs.getString(4));
                datosProducto.add(rs.getString(5));
                datosProducto.add(rs.getString(6));
                datosProducto.add(rs.getString(7));
                datosProducto.add(rs.getString(8));
                datosProducto.add(rs.getString(9));
            }
        } catch (Exception e) {
        }
        return datosProducto;
    }
    public ArrayList<Pedido> retornoDePedidos(String codigoPedido){
        ArrayList<Pedido> Pedidos = new ArrayList<Pedido>();
        
        String consulta="SELECT cantidad,total,anticipo,fecha_orden,estado_pedido,CLIENTE_nit,PRODUCTO_codigo,TIENDA_codigo_salida,TIENDA_codigo_llegada FROM PEDIDO WHERE codigo = '"+codigoPedido+"'";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                Pedidos.add(new Pedido(codigoPedido, rs.getString(8), rs.getString(9), rs.getString(4), rs.getString(6), rs.getString(7), rs.getInt(1),rs.getFloat(2),rs.getFloat(3)));
            }
        } catch (Exception e) {
        }
        return Pedidos;
    }
    public int contarPedidos(String codigoPedido){
        int contar=0;
        
        String consulta="SELECT COUNT(*) FROM PEDIDO WHERE codigo ='"+codigoPedido+"';";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                contar = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return contar;
    }
    /**
     * Esta clase funciona solemnete para el apartado de aceso al usuario
     * @param codigo
     * @return 
     */
    public ArrayList<String> datosPedido(String codigo){
        ArrayList<String> datosProducto = new ArrayList<String>();
        
        String consulta="SELECT anticipo,TIENDA_codigo_salida,TIENDA_codigo_llegada FROM PEDIDO  WHERE codigo = '"+codigo+"' LIMIT 1;";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                datosProducto.add(rs.getString(1));
                datosProducto.add(rs.getString(2));
                datosProducto.add(rs.getString(3));
            }
        } catch (Exception e) {
        }
        return datosProducto;
    }
    public float  sumaTotalPedido(String codigo){
        float total=0;
        
        String consulta="SELECT SUM(total) FROM PEDIDO WHERE codigo = '"+codigo+"';";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                total = rs.getFloat(1);
            }
        } catch (Exception e) {
        }
        return total;
    }
    public float  sumaAnticipoPedido(String codigo){
        float anticipo=0;
        
        String consulta="SELECT SUM(anticipo) FROM PEDIDO WHERE codigo = '"+codigo+"';";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                anticipo = rs.getFloat(1);
            }
        } catch (Exception e) {
        }
        return anticipo;
    }
    public String  consultarCodigoTienda(String nombre){
        String codigo = "";
        
        String consulta="SELECT codigo FROM TIENDA WHERE nombre = '"+nombre+"';";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                codigo = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return codigo;
    }
    ///////////////////////////////////////////////////////////
    //CONSULTAS ESPESIFICAS PARA REPORTES EN LA BASE DE DATOS//
    ///////////////////////////////////////////////////////////
    /**
     * Da la informacion necesaria para generar un reporte
     * @param codigoTienda
     * @return 
     */
    public ArrayList<String[]> pedidosReporte(String codigoTienda,String estadoDePedido){
        ArrayList<String[]> datosProducto = new ArrayList<String[]>();
        
        String consulta="SELECT PEDIDO.codigo,CLIENTE.nombre,PEDIDO.CLIENTE_nit,PEDIDO.TIENDA_codigo_salida FROM PEDIDO,CLIENTE WHERE PEDIDO.TIENDA_codigo_llegada = '"+codigoTienda+"' AND PEDIDO.CLIENTE_nit = CLIENTE.nit AND PEDIDO.estado_pedido='"+estadoDePedido+"';";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                
                datosProducto.add(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
            }
        } catch (Exception e) {
        }
        return datosProducto;
    }
    /**
     * Da la informacion de los pedidos que salieron de la tienda
     * @param codigoTienda
     * @param estadoDePedido
     * @return 
     */
    public ArrayList<String[]> pedidosSalidaReporte(String codigoTienda){
        ArrayList<String[]> datosProducto = new ArrayList<String[]>();
        
        String consulta="SELECT PEDIDO.codigo,CLIENTE.nombre,PEDIDO.CLIENTE_nit,PEDIDO.TIENDA_codigo_llegada FROM PEDIDO,CLIENTE WHERE PEDIDO.TIENDA_codigo_salida = '"+codigoTienda+"' AND PEDIDO.CLIENTE_nit = CLIENTE.nit AND PEDIDO.estado_pedido='ET';";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                
                datosProducto.add(new String[]{rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)});
            }
        } catch (Exception e) {
        }
        return datosProducto;
    }
}