package com.carlos.DBSuport;

import com.carlos.Entities.Pedido;
import java.sql.*;
import java.util.ArrayList;

public class ConsultasDB {
    /**
     * CONSTRUCTOR VACIO DE LA CLASE
     */
    public ConsultasDB(){
        
    }
    /**
     * Retrona si los datos ingresados pertenecen a un empleado o a un cliente en el sistema
     * @param nombre
     * @param codeNIT
     * @param conexion
     * @return 
     */
    public int consultaUsuarios(String nombre,String codeNIT,Connection conexion){
        int respuesta = 0;
        String consulta = "SELECT nombre,nit FROM CLIENTE WHERE nit = ? AND nombre = ?";
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, codeNIT);
            preSt.setString(2, nombre);
            try (ResultSet result = preSt.executeQuery()){
                while (result.next()) {
                respuesta=1;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        String consulta2 = "SELECT nombre,codigo FROM EMPLEADO WHERE codigo = ? AND nombre = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta2)) {
            preSt.setString(1, codeNIT);
            preSt.setString(2, nombre);
            try(ResultSet result = preSt.executeQuery()) {
                while (result.next()) {
                respuesta=2;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return respuesta;
    }
    /**
     * Retrona el nombre de las tiendas que estan en el sistema de base de datos
     * @return 
     */
    public ArrayList<String> consultaDeTiendas(Connection conexion){
        ArrayList<String> tiendasDisponibles = new ArrayList<String>();
        String consulta="SELECT nombre FROM TIENDA";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            ResultSet result = preSt.executeQuery();
            while(result.next()){
                tiendasDisponibles.add(result.getString("nombre"));
            }
            result.close();
            preSt.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return tiendasDisponibles;
    }
    /**
     * Retorna los codigos de las tiendas que estan en la base de datos
     * @return 
     */
    public ArrayList<String> codigosDeTiendas(Connection conexion){
        ArrayList<String> tiendasDisponibles = new ArrayList<String>();
        String consulta="SELECT codigo FROM TIENDA";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            ResultSet result = preSt.executeQuery();
            while(result.next()){
                tiendasDisponibles.add(result.getString("codigo"));
            }
            result.close();
            preSt.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return tiendasDisponibles;
    }
    /**
     * Retorna todos los datos de un cliente segun si nit de ingreso
     * @param nit
     * @return 
     */
    public ArrayList<String> datosCliente(String nit,Connection conexion){
        ArrayList<String> cliente = new ArrayList<String>();
        String consulta="SELECT nombre,telefono,credito,dpi,email,direccion FROM CLIENTE WHERE nit = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1, nit);
            ResultSet result = preSt.executeQuery();
            while(result.next()){
                cliente.add(result.getString(1));
                cliente.add(result.getString(2));
                cliente.add(result.getString(3));
                cliente.add(result.getString(4));
                cliente.add(result.getString(5));
                cliente.add(result.getString(6));
            }
            result.close();
            preSt.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return cliente;
    }
    /**
     * Retorna los datos de un empleado
     * @param codigo
     * @return 
     */
    public ArrayList<String> datosEmpleado(String codigo,Connection conexion){
        ArrayList<String> empleado = new ArrayList<String>();
        String consulta="SELECT nombre,telefono,dpi,nit,email,direccion FROM EMPLEADO WHERE codigo = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
	    preSt.setString(1,codigo);
	    ResultSet result = preSt.executeQuery();
	    while(result.next()){
                empleado.add(result.getString(1));
                empleado.add(result.getString(2));
                empleado.add(result.getString(3));
                empleado.add(result.getString(4));
                empleado.add(result.getString(5));
                empleado.add(result.getString(6));
	    }
	    result.close();
	    preSt.close();
	}catch(Exception e){
	    System.out.println(e.getMessage());
	}
        return empleado;
    }
    /**
     * Retrona los datos de la tienda segun el codigo de la tienda
     * @param codigo
     * @return 
     */
    public ArrayList<String> datosTienda(String codigo,Connection conexion){
        ArrayList<String> tienda = new ArrayList<String>();
        String consulta="SELECT nombre,direccion,telefono_1,telefono_2,email,horario FROM TIENDA WHERE codigo = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
	    preSt.setString(1,codigo);
	    ResultSet result = preSt.executeQuery();
	    while(result.next()){
                tienda.add(result.getString(1));
                tienda.add(result.getString(2));
                tienda.add(result.getString(3));
                tienda.add(result.getString(4));
                tienda.add(result.getString(5));
                tienda.add(result.getString(6));
	    }
	    result.close();
	    preSt.close();
	}catch(Exception e){
	    System.out.println(e.getMessage());
	}
        return tienda;
    }
    /**
     * Retrona el codigo de la tienda segun el nombre de la misma
     * @param nombre
     * @param conexion
     * @return 
     */
    public String codigoTienda(String nombre,Connection conexion){
        String cliente ="";
        String consulta="SELECT codigo FROM TIENDA WHERE nombre = ?";
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
	    preSt.setString(1,nombre);
	    ResultSet result = preSt.executeQuery();
	    while(result.next()){
	      cliente = result.getString(1);
	    }
	    result.close();
	    preSt.close();
	}catch(Exception e){
	    System.out.println(e.getMessage());
	}
        return cliente;
    }
    /**
     * Retorna el tiempo entre las tiendas segun el codigo de tienda ingrasados
     * @param codigoTienda1
     * @param codigoTienda2
     * @return 
     */
    public ArrayList<String> tiempoEntreTiendas(String codigoTienda1,String codigoTienda2,Connection conexion){
        ArrayList<String> tiempo = new ArrayList<String>();
        String consulta="SELECT tiempo,codigo FROM TIEMPO_TRASLADO WHERE TIENDA_codigo1 = ? AND TIENDA_codigo2 = ?";
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
	    preSt.setString(1,codigoTienda1);
            preSt.setString(2,codigoTienda2);
	    ResultSet result = preSt.executeQuery();
	    while(result.next()){
                tiempo.add(result.getString(1));
                tiempo.add(result.getString(2));
	    }
	    result.close();
	    preSt.close();
	}catch(Exception e){
	    System.out.println(e.getMessage());
	}
        return tiempo;
    }
    /**
     * Retornar los datos de producto segun codigo el codigo del mismo
     * @param codigo
     * @return 
     */
    public ArrayList<String> datosProducto(String codigo,Connection conexion){
        ArrayList<String> datosProducto = new ArrayList<String>();
        
        String consulta="SELECT nombre,fabricante,precio,descripcion,garantia FROM PRODUCTO WHERE codigo = ?";
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
	    preSt.setString(1,codigo);
	    ResultSet result = preSt.executeQuery();
	    while(result.next()){
                datosProducto.add(result.getString(1));
                datosProducto.add(result.getString(2));
                datosProducto.add(result.getString(3));
                datosProducto.add(result.getString(4));
                datosProducto.add(result.getString(5));
	    }
	    result.close();
	    preSt.close();
	}catch(Exception e){
	    System.out.println(e.getMessage());
	}
        return datosProducto;
    }
    /**
     * Retorna los datos de existencia de un producto
     * @param codigo
     * @param codigoTienda
     * @return 
     */
    public String datosExistenciaProducto(String codigo,String codigoTienda,Connection conexion){
        String datosProducto = "";
        
        String consulta="SELECT cantidad FROM EXISTENCIA WHERE PRODUCTO_codigo = ? AND TIENDA_codigo = ?";
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
	    preSt.setString(1,codigo);
            preSt.setString(2,codigoTienda);
	    ResultSet result = preSt.executeQuery();
	    while(result.next()){
                datosProducto = result.getString(1);
	    }
	    result.close();
	    preSt.close();
	}catch(Exception e){
	    System.out.println(e.getMessage());
	}
        return datosProducto;
    }
    /**
     * Retorna el producto de un pedido
     * @param codigo
     * @return 
     */
    public ArrayList<String> productoDeUnPedido(String codigo,Connection conexion){
        ArrayList<String> datosProducto = new ArrayList<String>();
        
        String consulta="SELECT PRODUCTO_codigo FROM PEDIDO WHERE codigo = ?";
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
	    preSt.setString(1,codigo);
	    ResultSet result = preSt.executeQuery();
	    while(result.next()){
	      datosProducto.add(result.getString(1));
	    }
	    result.close();
	    preSt.close();
	}catch(Exception e){
	    System.out.println(e.getMessage());
	}
        return datosProducto;
    }
    /**
     * Retorna el estado de un pedido
     * @param codigoPedido
     * @return 
     */
    public ArrayList<String> estadoPedido(String codigoPedido,Connection conexion){
        ArrayList<String> datosProducto = new ArrayList<String>();
        
        String consulta="SELECT cantidad,total,anticipo,fecha_orden,estado_pedido,CLIENTE_nit,PRODUCTO_codigo,TIENDA_codigo_salida,TIENDA_codigo_llegada FROM PEDIDO WHERE codigo = ? LIMIT 1";
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
	    preSt.setString(1,codigoPedido);
	    ResultSet result = preSt.executeQuery();
	    while(result.next()){
                datosProducto.add(result.getString(1));
                datosProducto.add(result.getString(2));
                datosProducto.add(result.getString(3));
                datosProducto.add(result.getString(4));
                datosProducto.add(result.getString(5));
                datosProducto.add(result.getString(6));
                datosProducto.add(result.getString(7));
                datosProducto.add(result.getString(8));
                datosProducto.add(result.getString(9));
	    }
	    result.close();
	    preSt.close();
	}catch(Exception e){
	    System.out.println(e.getMessage());
	}
        return datosProducto;
    }
    /**
     * Retorno de los pedidos segun el codigo enlazado al mismo
     * @param codigoPedido
     * @return 
     */
    public ArrayList<Pedido> retornoDePedidos(String codigoPedido,Connection conexion){
        ArrayList<Pedido> Pedidos = new ArrayList<Pedido>();
        
        String consulta="SELECT cantidad,total,anticipo,fecha_orden,estado_pedido,CLIENTE_nit,PRODUCTO_codigo,TIENDA_codigo_salida,TIENDA_codigo_llegada FROM PEDIDO WHERE codigo = ?";
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
	    preSt.setString(1,codigoPedido);
	    ResultSet result = preSt.executeQuery();
	    while(result.next()){
	      Pedidos.add(new Pedido(codigoPedido, result.getString(8), result.getString(9), result.getString(4), result.getString(6), result.getString(7), result.getInt(1),result.getFloat(2),result.getFloat(3)));
	    }
	    result.close();
	    preSt.close();
	}catch(Exception e){
	    System.out.println(e.getMessage());
	}
        return Pedidos;
    }
    /**
     * Cuenta el numero de pedidos asignado a un codigo
     * @param codigoPedido
     * @return 
     */
    public int contarPedidos(String codigoPedido,Connection conexion){
        int contar=0;
        
        String consulta="SELECT COUNT(*) FROM PEDIDO WHERE codigo = ?";
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
	    preSt.setString(1,codigoPedido);
	    ResultSet result = preSt.executeQuery();
	    while(result.next()){
	      contar = result.getInt(1);
	    }
	    result.close();
	    preSt.close();
	}catch(Exception e){
	    System.out.println(e.getMessage());
	}
        return contar;
    }
    /**
     * Esta clase funciona solemnete para el apartado de aceso al usuario
     * Retorna datos de un pedido segun el codigo generado
     * @param codigo
     * @return 
     */
    public ArrayList<String> datosPedido(String codigo,Connection conexion){
        ArrayList<String> datosProducto = new ArrayList<String>();
        
        String consulta="SELECT anticipo,TIENDA_codigo_salida,TIENDA_codigo_llegada FROM PEDIDO  WHERE codigo = ? LIMIT 1";
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
	    preSt.setString(1,codigo);
	    ResultSet result = preSt.executeQuery();
	    while(result.next()){
                datosProducto.add(result.getString(1));
                datosProducto.add(result.getString(2));
                datosProducto.add(result.getString(3));
	    }
	    result.close();
	    preSt.close();
	}catch(Exception e){
	    System.out.println(e.getMessage());
	}
        return datosProducto;
    }
    /**
     * Retorna la suma total del pedido
     * @param codigo
     * @return 
     */
    public float  sumaTotalPedido(String codigo,Connection conexion){
        float total=0;
        
        String consulta="SELECT SUM(total) FROM PEDIDO WHERE codigo = ?";
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
	    preSt.setString(1,codigo);
	    ResultSet result = preSt.executeQuery();
	    while(result.next()){
                total = result.getFloat(1);
	    }
	    result.close();
	    preSt.close();
	}catch(Exception e){
	    System.out.println(e.getMessage());
	}
        return total;
    }
    /**
     * Suma total del anticipo de un pedido
     * @param codigo
     * @return 
     */
    public float  sumaAnticipoPedido(String codigo,Connection conexion){
        float anticipo=0;
        
        String consulta="SELECT SUM(anticipo) FROM PEDIDO WHERE codigo = ?";
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
	    preSt.setString(1,codigo);
	    ResultSet result = preSt.executeQuery();
	    while(result.next()){
                anticipo = result.getFloat(1);
	    }
	    result.close();
	    preSt.close();
	}catch(Exception e){
	    System.out.println(e.getMessage());
	}
        return anticipo;
    }
    /**
     * Retorna el codigo de una tienda segun su nombre
     * @param nombre
     * @return 
     */
    public String  consultarCodigoTienda(String nombre,Connection conexion){
        String codigo = "";
        
        String consulta="SELECT codigo FROM TIENDA WHERE nombre = ?";
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
	    preSt.setString(1,nombre);
	    ResultSet result = preSt.executeQuery();
	    while(result.next()){
                codigo = result.getString(1);
	    }
	    result.close();
	    preSt.close();
	}catch(Exception e){
	    System.out.println(e.getMessage());
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
    public ArrayList<String[]> pedidosReporte(String codigoTienda,String estadoDePedido,Connection conexion){
        ArrayList<String[]> datosProducto = new ArrayList<String[]>();
        
        String consulta="SELECT PEDIDO.codigo,CLIENTE.nombre,PEDIDO.CLIENTE_nit,PEDIDO.TIENDA_codigo_salida FROM PEDIDO,CLIENTE WHERE PEDIDO.TIENDA_codigo_llegada = ? AND PEDIDO.CLIENTE_nit = CLIENTE.nit AND PEDIDO.estado_pedido= ?";
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
	    preSt.setString(1,codigoTienda);
            preSt.setString(2,estadoDePedido);
	    ResultSet result = preSt.executeQuery();
	    while(result.next()){
                datosProducto.add(new String[]{result.getString(1),result.getString(2),result.getString(3),result.getString(4)});
	    }
	    result.close();
	    preSt.close();
	}catch(Exception e){
	    System.out.println(e.getMessage());
	}
        return datosProducto;
    }
    /**
     * Da la informacion de los pedidos que salieron de la tienda
     * @param codigoTienda
     * @param estadoDePedido
     * @return 
     */
    public ArrayList<String[]> pedidosSalidaReporte(String codigoTienda,Connection conexion){
        ArrayList<String[]> datosProducto = new ArrayList<String[]>();
        
        String consulta="SELECT PEDIDO.codigo,CLIENTE.nombre,PEDIDO.CLIENTE_nit,PEDIDO.TIENDA_codigo_llegada FROM PEDIDO,CLIENTE WHERE PEDIDO.TIENDA_codigo_salida = ? AND PEDIDO.CLIENTE_nit = CLIENTE.nit AND PEDIDO.estado_pedido='ET'";
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
	    preSt.setString(1,codigoTienda);
	    ResultSet result = preSt.executeQuery();
	    while(result.next()){
                datosProducto.add(new String[]{result.getString(1),result.getString(2),result.getString(3),result.getString(4)});
	    }
	    result.close();
	    preSt.close();
	}catch(Exception e){
	    System.out.println(e.getMessage());
	}
        return datosProducto;
    }
    /**
     * Da informacion de las compras de un cliente en especifico
     * @param nitCliente
     * @return 
     */
    public ArrayList<String[]> comprasClienteReporte(String nitCliente ,Connection conexion){
        ArrayList<String[]> comprasCliente = new ArrayList<String[]>();
        
        String consulta="SELECT TIENDA_codigo,PRODUCTO_codigo,fecha_venta,cantidad_producto FROM VENTAS WHERE CLIENTE_nit = ?";
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
	    preSt.setString(1,nitCliente);
	    ResultSet result = preSt.executeQuery();
	    while(result.next()){
                comprasCliente.add(new String[]{result.getString(1),result.getString(2),result.getString(3),result.getString(4)});
	    }
	    result.close();
	    preSt.close();
	}catch(Exception e){
	    System.out.println(e.getMessage());
	}
        return comprasCliente;
    }
    /**
     * Da informacion de los pedidos de un cliente en especifico
     * @param nitCliente
     * @return 
     */
    public ArrayList<String[]> pedidosClienteReporte(String nitCliente,Connection conexion){
        ArrayList<String[]> pedidosCliente = new ArrayList<String[]>();
        
        String consulta="SELECT codigo,PRODUCTO_codigo,cantidad,TIENDA_codigo_salida,TIENDA_codigo_llegada FROM PEDIDO WHERE CLIENTE_nit = ? AND estado_pedido != 'entregado'";
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
	    preSt.setString(1,nitCliente);
	    ResultSet result = preSt.executeQuery();
	    while(result.next()){
                pedidosCliente.add(new String[]{result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5)});
	    }
	    result.close();
	    preSt.close();
	}catch(Exception e){
	    System.out.println(e.getMessage());
	}
        return pedidosCliente;
    }
    /**
     * Retorna los 10 productos mas vendidos contando todas las tiendas
     * @param conexion
     * @return 
     */
    public ArrayList<String[]> diezProductosMasVendidos(Connection conexion){
        ArrayList<String[]> productosMasVendidos = new ArrayList<String[]>();
        
        String consulta="SELECT PRODUCTO.codigo,PRODUCTO.nombre,PRODUCTO.fabricante FROM PRODUCTO WHERE codigo IN (SELECT PRODUCTO_codigo FROM VENTAS GROUP BY PRODUCTO_codigo ORDER BY count(PRODUCTO_codigo) DESC) LIMIT 10";
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            try(ResultSet result = preSt.executeQuery()){
                while(result.next()){
                productosMasVendidos.add(new String[]{result.getString(1),result.getString(2),result.getString(3)});
	    }
            }catch(Exception e){
                
            }
	}catch(Exception e){
	    System.out.println(e.getMessage());
	}
        return productosMasVendidos;
    }
    /**
     * Retorna los 10 productos mas vendidos contando todas las tiendas en un intervalo de tiempo
     * @param conexion
     * @return 
     */
    public ArrayList<String[]> diezProductosMasVendidosIntervalo(String fechaInferior,String fechaSuperior,Connection conexion){
        ArrayList<String[]> productosMasVendidos = new ArrayList<String[]>();
        
        String consulta="SELECT PRODUCTO.codigo,PRODUCTO.nombre,PRODUCTO.fabricante FROM PRODUCTO WHERE codigo IN (SELECT PRODUCTO_codigo FROM VENTAS WHERE fecha_venta BETWEEN ? AND ? GROUP BY PRODUCTO_codigo ORDER BY count(PRODUCTO_codigo) DESC) LIMIT 10";
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1,fechaInferior);
            preSt.setString(2,fechaSuperior);
            try(ResultSet result = preSt.executeQuery()){
                while(result.next()){
                productosMasVendidos.add(new String[]{result.getString(1),result.getString(2),result.getString(3)});
	    }
            }catch(Exception e){
                
            }
	}catch(Exception e){
	    System.out.println(e.getMessage());
	}
        return productosMasVendidos;
    }
    /**
     * Retorna los prodcutos mas vendidos por la tienda en que se realizo el reporte
     * @param codigoTienda
     * @param conexion
     * @return 
     */
    public ArrayList<String[]> ProductosMasVendidosTienda(String codigoTienda,Connection conexion){
        ArrayList<String[]> productosMasVendidos = new ArrayList<String[]>();
        
        String consulta="SELECT PRODUCTO.codigo,PRODUCTO.nombre,PRODUCTO.fabricante FROM PRODUCTO WHERE codigo IN (SELECT PRODUCTO_codigo FROM VENTAS WHERE VENTAS.TIENDA_codigo = ? GROUP BY PRODUCTO_codigo ORDER BY count(PRODUCTO_codigo) DESC)";
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1,codigoTienda);
            try(ResultSet result = preSt.executeQuery()){
                while(result.next()){
                productosMasVendidos.add(new String[]{result.getString(1),result.getString(2),result.getString(3)});
	    }
            }catch(Exception e){
                
            }
	}catch(Exception e){
	    System.out.println(e.getMessage());
	}
        return productosMasVendidos;
    }
    /**
     * Retorna los productos mas vendidos en una tienda especifica y un rango de tiempo
     * @param codigoTienda
     * @param fechaInferior
     * @param fechaSuperior
     * @param conexion
     * @return 
     */
     public ArrayList<String[]> ProductosMasVendidosTiendaIntervalo(String codigoTienda,String fechaInferior,String fechaSuperior,Connection conexion){
        ArrayList<String[]> productosMasVendidos = new ArrayList<String[]>();
        
        String consulta="SELECT PRODUCTO.codigo,PRODUCTO.nombre,PRODUCTO.fabricante FROM PRODUCTO WHERE codigo IN (SELECT PRODUCTO_codigo FROM VENTAS WHERE VENTAS.TIENDA_codigo = ? AND fecha_venta BETWEEN ? AND ? GROUP BY PRODUCTO_codigo ORDER BY count(PRODUCTO_codigo) DESC)";
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1,codigoTienda);
            preSt.setString(2,fechaInferior);
            preSt.setString(3,fechaSuperior);
            try(ResultSet result = preSt.executeQuery()){
                while(result.next()){
                productosMasVendidos.add(new String[]{result.getString(1),result.getString(2),result.getString(3)});
	    }
            }catch(Exception e){
                
            }
	}catch(Exception e){
	    System.out.println(e.getMessage());
	}
        return productosMasVendidos;
    }
     /**
      * Retorna los productos que nunca se han vendido segun la tienda que se seleccione
      * @param codigoTienda
      * @param fechaInferior
      * @param fechaSuperior
      * @param conexion
      * @return 
      */
     public ArrayList<String[]> productosNoVendidosPorTienda(String codigoTienda,Connection conexion){
        ArrayList<String[]> productoNoVendidos = new ArrayList<String[]>();
        
        String consulta="SELECT PRODUCTO.codigo,PRODUCTO.nombre,PRODUCTO.fabricante FROM PRODUCTO WHERE codigo IN (SELECT PRODUCTO_codigo FROM EXISTENCIA WHERE ((SELECT COUNT(*) FROM VENTAS WHERE VENTAS.TIENDA_codigo = ? AND VENTAS.PRODUCTO_codigo = EXISTENCIA.PRODUCTO_codigo) = 0) AND EXISTENCIA.TIENDA_codigo= ? )";
        
        try (PreparedStatement preSt = conexion.prepareStatement(consulta)) {
            preSt.setString(1,codigoTienda);
            preSt.setString(2,codigoTienda);
            try(ResultSet result = preSt.executeQuery()){
                while(result.next()){
                productoNoVendidos.add(new String[]{result.getString(1),result.getString(2),result.getString(3)});
	    }
            }catch(Exception e){
                
            }
	}catch(Exception e){
	    System.out.println(e.getMessage());
	}
        return productoNoVendidos;
    }
}