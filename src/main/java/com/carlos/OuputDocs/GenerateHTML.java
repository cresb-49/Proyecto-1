package com.carlos.OuputDocs;

import com.carlos.DBSuport.ConsultasDB;
import java.io.*;
import java.sql.Connection;
import java.util.ArrayList;

public class GenerateHTML {
    private File archivo;
    private String codigoTienda;
    private String NITcliente;
    private String tiempoSuperior;
    private String timepoInferior;
    
    ////////VARIABLES DE CONSULTAS A BASE DE DATOS////////////
    private ConsultasDB consultaDB = new ConsultasDB();
    private Connection baseDeDatos;

    public GenerateHTML (File archivo,Connection conexionBaseDatos){
        this.baseDeDatos=conexionBaseDatos;
        this.archivo=archivo;
    }
    /**
     * Genera el archivo HTML segun el tipo de reporte que se selecciono
     * @param tipoReporte 
     */
    public void Generate (String tipoReporte){
        //genera un lugar de escritura
        PrintWriter html = null;
        try {
            html = new PrintWriter(new DataOutputStream(new FileOutputStream(archivo)));
            //Segun el tipo de reporte se puede crear un archivo con un contenido u otro
            if(tipoReporte.equals("Listado_Entrada_Pedido")){
                html = this.htmlContentPedidosTienda(html);
            }
            if(tipoReporte.equals("Listado_Pedido_Atrazado")){
                html = this.htmlContentPedidosAtrazadosTienda(html);
            }
            if(tipoReporte.equals("Listado_Pedidos_Salida_Tienda")){
                html = this.htmlContentPedidosExpendidosPorTienda(html);
            }
            if(tipoReporte.equals("Listado_Compras_Cliente_")){
                html = this.htmlComprasPorCliente(html);
            }
            if(tipoReporte.equals("Listado_Pedidos_Cliente_")){
                html=this.htmlPedidosPorCliente(html);
            }
            if(tipoReporte.equals("10_Productos_Mas_Vendidos")){
                //Si no hay una fecha de referencia para la creacion del reporte entonces se hace a nivel global
                if(this.tiempoSuperior.equals("Año-Mes-Dia")&&this.timepoInferior.equals("Año-Mes-Dia")){
                    html = this.htmlDiezProductosMasVendidos(html);
                }
                else{
                    html = this.htmlDiezProductosMasVendidosIntervalo(html);
                }
            }
            if(tipoReporte.equals("Listado_Produtos_Mas_Vendidos")){
                //Si no hay una fecha de referencia para la creacion del reporte entonces se hace a nivel global en tienda
                if(this.tiempoSuperior.equals("Año-Mes-Dia")&&this.timepoInferior.equals("Año-Mes-Dia")){
                    html = this.htmlProductosMasVendidosTienda(html);
                }
                else{
                    html = this.htmlProductosMasVendidosTiendaIntervalo(html);
                }
                
            }
            if(tipoReporte.equals("Listado_Productos_No_Vendidos")){
                html=this.htmlProductosNoVendidosPorTienda(html);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            html.close();
        }
        
    }
    /**
     * Genera el archivo con los datos de los pedidos que llegran a la tienda
     * @param html
     * @return 
     */
    private PrintWriter htmlContentPedidosTienda(PrintWriter html){
        ArrayList<String[]> pedidosDelReporte = new ArrayList<String[]>();
        pedidosDelReporte = this.consultaDB.pedidosReporte(this.codigoTienda,"ET",this.baseDeDatos);
        //////////////////////////////////////////////////////////////////////////////////////
        html.println("<h1>REPORTE DE PEDIDOS QUE LLEGARAN A LA TIENDA "+codigoTienda+"</h1>");
        html.println("<h2>Descripcion de los pedidos que llegaran</h2>");
        html.println("<table border=\"1\">");
            html.println("<thead>");
                html.println("<tr>");
                    html.println("<th>Codigo Pedido</th>");
                    html.println("<th>Nombre del Cliente</th>");
                    html.println("<th>Nit del Cliente</th>");
                    html.println("<th>Tienda de Origen</th>");
                html.println("</tr>");
            html.println("</thead>");
            html.println("<tbody>");
                //Ciclo de imprecion de los datos a generar
                ///////////////////////////////////////////////
                for (int i = 0; i < pedidosDelReporte.size(); i++) {
                    html.println("<tbody>");
                        html.println("<td>"+pedidosDelReporte.get(i)[0]+"</td>");
                        html.println("<td>"+pedidosDelReporte.get(i)[1]+"</td>");
                        html.println("<td>"+pedidosDelReporte.get(i)[2]+"</td>");
                        html.println("<td>"+pedidosDelReporte.get(i)[3]+"</td>");
                    html.println("<tbody>");
                }
                ///////////////////////////////////////////////
            html.println("</tbody>");
        html.println("</table>");
        try {
            html.close();    
        } catch (Exception e) {
            
        }
        return html;
    }
    /**
     * Genera el archivo de reporte con los pedidos atrasados en la tienda
     * @param html
     * @return 
     */
    private PrintWriter htmlContentPedidosAtrazadosTienda(PrintWriter html){
        ArrayList<String[]> pedidosDelReporte = new ArrayList<String[]>();
        pedidosDelReporte = this.consultaDB.pedidosReporte(this.codigoTienda,"TR",this.baseDeDatos);
        //////////////////////////////////////////////////////////////////////////////////////
        html.println("<h1>REPORTE DE PEDIDOS ATRAZADOS QUE ESTAN EN LA TIENDA "+codigoTienda+"</h1>");
        html.println("<h2>Descripcion de los pedidos de ingreso atrazado</h2>");
        html.println("<table border=\"1\">");
            html.println("<thead>");
                html.println("<tr>");
                    html.println("<th>Codigo Pedido</th>");
                    html.println("<th>Nombre del Cliente</th>");
                    html.println("<th>Nit del Cliente</th>");
                    html.println("<th>Tienda de Origen</th>");
                html.println("</tr>");
            html.println("</thead>");
            html.println("<tbody>");
                //Ciclo de imprecion de los datos a generar
                ///////////////////////////////////////////////
                for (int i = 0; i < pedidosDelReporte.size(); i++) {
                    html.println("<tbody>");
                        html.println("<td>"+pedidosDelReporte.get(i)[0]+"</td>");
                        html.println("<td>"+pedidosDelReporte.get(i)[1]+"</td>");
                        html.println("<td>"+pedidosDelReporte.get(i)[2]+"</td>");
                        html.println("<td>"+pedidosDelReporte.get(i)[3]+"</td>");
                    html.println("<tbody>");
                }
                ///////////////////////////////////////////////
            html.println("</tbody>");
        html.println("</table>");
        try {
            html.close();    
        } catch (Exception e) {
            
        }
        return html;
    }
    private PrintWriter htmlContentPedidosExpendidosPorTienda(PrintWriter html){
        ArrayList<String[]> pedidosDelReporte = new ArrayList<String[]>();
        pedidosDelReporte = this.consultaDB.pedidosSalidaReporte(this.codigoTienda,this.baseDeDatos);
        //////////////////////////////////////////////////////////////////////////////////////
        html.println("<h1>REPORTE DE PEDIDOS EXPENDIDOS POR LA TIENDA "+codigoTienda+"</h1>");
        html.println("<h2>Descripcion de los pedidos que salieron de la tienda</h2>");
        html.println("<table border=\"1\">");
            html.println("<thead>");
                html.println("<tr>");
                    html.println("<th>Codigo Pedido</th>");
                    html.println("<th>Nombre del Cliente</th>");
                    html.println("<th>Nit del Cliente</th>");
                    html.println("<th>Tienda de Origen</th>");
                html.println("</tr>");
            html.println("</thead>");
            html.println("<tbody>");
                //Ciclo de imprecion de los datos a generar
                ///////////////////////////////////////////////
                for (int i = 0; i < pedidosDelReporte.size(); i++) {
                    html.println("<tbody>");
                        html.println("<td>"+pedidosDelReporte.get(i)[0]+"</td>");
                        html.println("<td>"+pedidosDelReporte.get(i)[1]+"</td>");
                        html.println("<td>"+pedidosDelReporte.get(i)[2]+"</td>");
                        html.println("<td>"+pedidosDelReporte.get(i)[3]+"</td>");
                    html.println("<tbody>");
                }
                ///////////////////////////////////////////////
            html.println("</tbody>");
        html.println("</table>");
        try {
            html.close();    
        } catch (Exception e) {
            
        }
        return html;
    }
    /**
     * Genera el contenido del reporte en el cual se adjunta las compras de un cliente especifico
     * @param html
     * @return 
     */
    private PrintWriter htmlComprasPorCliente(PrintWriter html){
        ArrayList<String[]> comprasCliente = new ArrayList<String[]>();
        comprasCliente = this.consultaDB.comprasClienteReporte(NITcliente,this.baseDeDatos);
        //////////////////////////////////////////////////////////////////////////////////////
        html.println("<h1>REPORTE DE COMPRAS HECHOS POR EL CLIENTE "+NITcliente+"</h1>");
        html.println("<h2>Descripcion de las compras hechas</h2>");
        html.println("<table border=\"1\">");
            html.println("<thead>");
                html.println("<tr>");
                    html.println("<th>Tienda donde se compro</th>");
                    html.println("<th>Producto</th>");
                    html.println("<th>Fecha de compra</th>");
                    html.println("<th>Cantidad Comprada</th>");
                html.println("</tr>");
            html.println("</thead>");
            html.println("<tbody>");
                //Ciclo de imprecion de los datos a generar
                ///////////////////////////////////////////////
                for (int i = 0; i < comprasCliente.size(); i++) {
                    html.println("<tbody>");
                        html.println("<td>"+comprasCliente.get(i)[0]+"</td>");
                        html.println("<td>"+comprasCliente.get(i)[1]+"</td>");
                        html.println("<td>"+comprasCliente.get(i)[2]+"</td>");
                        html.println("<td>"+comprasCliente.get(i)[3]+"</td>");
                    html.println("<tbody>");
                }
                ///////////////////////////////////////////////
            html.println("</tbody>");
        html.println("</table>");
        try {
            html.close();    
        } catch (Exception e) {
            
        }
        return html;
    }
    /**
     * Genera el contenido del reporte que contiene los pedidos hechos por un cliente
     * @param html
     * @return 
     */
    private PrintWriter htmlPedidosPorCliente(PrintWriter html){
        ArrayList<String[]> pedidosCliente = new ArrayList<String[]>();
        pedidosCliente = this.consultaDB.pedidosClienteReporte(NITcliente,this.baseDeDatos);
        //////////////////////////////////////////////////////////////////////////////////////
        html.println("<h1>REPORTE DE PEDIDOS HECHOS POR EL CLIENTE "+NITcliente+"</h1>");
        html.println("<h2>Descripcion de las compras hechas</h2>");
        html.println("<table border=\"1\">");
            html.println("<thead>");
                html.println("<tr>");
                    html.println("<th>Codigo Pedido</th>");
                    html.println("<th>Producto</th>");
                    html.println("<th>Cantidad</th>");
                    html.println("<th>Tienda de Salida</th>");
                    html.println("<th>Tienda de Recepcion</th>");
                html.println("</tr>");
            html.println("</thead>");
            html.println("<tbody>");
                //Ciclo de imprecion de los datos a generar
                ///////////////////////////////////////////////
                for (int i = 0; i < pedidosCliente.size(); i++) {
                    html.println("<tbody>");
                        html.println("<td>"+pedidosCliente.get(i)[0]+"</td>");
                        html.println("<td>"+pedidosCliente.get(i)[1]+"</td>");
                        html.println("<td>"+pedidosCliente.get(i)[2]+"</td>");
                        html.println("<td>"+pedidosCliente.get(i)[3]+"</td>");
                        html.println("<td>"+pedidosCliente.get(i)[4]+"</td>");
                    html.println("<tbody>");
                }
                ///////////////////////////////////////////////
            html.println("</tbody>");
        html.println("</table>");
        try {
            html.close();    
        } catch (Exception e) {
            
        }
        return html;
    }
    /**
     * Genrena el reporte de los 10 porductos mas vendidos
     * @param html
     * @return 
     */
    private PrintWriter htmlDiezProductosMasVendidos(PrintWriter html){
        ArrayList<String[]> productosMasVendidos = new ArrayList<String[]>();
        productosMasVendidos = this.consultaDB.diezProductosMasVendidos(this.baseDeDatos);
        //////////////////////////////////////////////////////////////////////////////////////
        html.println("<h1>REPORTE DE LOS PRODUCTOS MAS VENDIDOS POR LA EMPRESA</h1>");
        html.println("<h2>Descripcion de los productos</h2>");
        html.println("<table border=\"1\">");
            html.println("<thead>");
                html.println("<tr>");
                    html.println("<th>Nombre del producto</th>");
                    html.println("<th>Codigo del producto</th>");
                    html.println("<th>Fabricante del producto</th>");
                    html.println("<th>Cantidad Vendida</th>");
                html.println("</tr>");
            html.println("</thead>");
            html.println("<tbody>");
                //Ciclo de imprecion de los datos a generar
                ///////////////////////////////////////////////
                for (int i = 0; i < productosMasVendidos.size(); i++) {
                    html.println("<tbody>");
                        html.println("<td>"+productosMasVendidos.get(i)[0]+"</td>");
                        html.println("<td>"+productosMasVendidos.get(i)[1]+"</td>");
                        html.println("<td>"+productosMasVendidos.get(i)[2]+"</td>");
                        html.println("<td>"+productosMasVendidos.get(i)[3]+"</td>");
                    html.println("<tbody>");
                }
                ///////////////////////////////////////////////
            html.println("</tbody>");
        html.println("</table>");
        try {
            html.close();    
        } catch (Exception e) {
            
        }
        return html;
    }
    /**
     * Genera el reporte de los productos mas vendidos en un intervalo de tiempo
     * @param html
     * @return 
     */
    private PrintWriter htmlDiezProductosMasVendidosIntervalo(PrintWriter html){
        ArrayList<String[]> productosMasVendidos = new ArrayList<String[]>();
        productosMasVendidos = this.consultaDB.diezProductosMasVendidosIntervalo(this.timepoInferior,this.tiempoSuperior,this.baseDeDatos);
        //////////////////////////////////////////////////////////////////////////////////////
        html.println("<h1>REPORTE DE LOS PRODUCTOS MAS VENDIDOS ENTRE "+this.timepoInferior+" Y "+this.tiempoSuperior+" </h1>");
        html.println("<h2>Descripcion de los productos</h2>");
        html.println("<table border=\"1\">");
            html.println("<thead>");
                html.println("<tr>");
                    html.println("<th>Nombre del producto</th>");
                    html.println("<th>Codigo del producto</th>");
                    html.println("<th>Fabricante del producto</th>");
                    html.println("<th>Cantidad Vendida</th>");
                html.println("</tr>");
            html.println("</thead>");
            html.println("<tbody>");
                //Ciclo de imprecion de los datos a generar
                ///////////////////////////////////////////////
                for (int i = 0; i < productosMasVendidos.size(); i++) {
                    html.println("<tbody>");
                        html.println("<td>"+productosMasVendidos.get(i)[0]+"</td>");
                        html.println("<td>"+productosMasVendidos.get(i)[1]+"</td>");
                        html.println("<td>"+productosMasVendidos.get(i)[2]+"</td>");
                        html.println("<td>"+productosMasVendidos.get(i)[3]+"</td>");
                    html.println("<tbody>");
                }
                ///////////////////////////////////////////////
            html.println("</tbody>");
        html.println("</table>");
        try {
            html.close();    
        } catch (Exception e) {
            
        }
        return html;
    }
    /**
     * Genera el reporte de los productos mas vendidos por la tienda en donde se genero el codigo
     * @param html
     * @return 
     */
    private PrintWriter htmlProductosMasVendidosTienda(PrintWriter html){
        ArrayList<String[]> productosMasVendidos = new ArrayList<String[]>();
        productosMasVendidos = this.consultaDB.ProductosMasVendidosTienda(this.codigoTienda, this.baseDeDatos);
        //////////////////////////////////////////////////////////////////////////////////////
        html.println("<h1>REPORTE DE LOS PRODUCTOS MAS VENDIDOS EN LA TIENDA "+this.codigoTienda+"</h1>");
        html.println("<h2>Descripcion de los productos</h2>");
        html.println("<table border=\"1\">");
            html.println("<thead>");
                html.println("<tr>");
                    html.println("<th>Nombre del producto</th>");
                    html.println("<th>Codigo del producto</th>");
                    html.println("<th>Fabricante del producto</th>");
                    html.println("<th>Cantidad Vendida</th>");
                html.println("</tr>");
            html.println("</thead>");
            html.println("<tbody>");
                //Ciclo de imprecion de los datos a generar
                ///////////////////////////////////////////////
                for (int i = 0; i < productosMasVendidos.size(); i++) {
                    html.println("<tbody>");
                        html.println("<td>"+productosMasVendidos.get(i)[0]+"</td>");
                        html.println("<td>"+productosMasVendidos.get(i)[1]+"</td>");
                        html.println("<td>"+productosMasVendidos.get(i)[2]+"</td>");
                        html.println("<td>"+productosMasVendidos.get(i)[3]+"</td>");
                    html.println("<tbody>");
                }
                ///////////////////////////////////////////////
            html.println("</tbody>");
        html.println("</table>");
        try {
            html.close();    
        } catch (Exception e) {
            
        }
        return html;
    }
    /**
     * Genera un reporte de los productos mas vendidos en un lapso de tiempo
     * @param html
     * @return 
     */
    private PrintWriter htmlProductosMasVendidosTiendaIntervalo(PrintWriter html){
        ArrayList<String[]> productosMasVendidos = new ArrayList<String[]>();
        productosMasVendidos = this.consultaDB.ProductosMasVendidosTiendaIntervalo(this.codigoTienda, this.timepoInferior, this.tiempoSuperior, this.baseDeDatos);
        //////////////////////////////////////////////////////////////////////////////////////
        html.println("<h1>REPORTE DE LOS PRODUCTOS MAS VENDIDOS EN LA TIENDA "+this.codigoTienda+"\nENTRE EL "+this.timepoInferior+" Y "+this.tiempoSuperior+" POR LA EMPRESA</h1>");
        html.println("<h2>Descripcion de los productos</h2>");
        html.println("<table border=\"1\">");
            html.println("<thead>");
                html.println("<tr>");
                    html.println("<th>Nombre del producto</th>");
                    html.println("<th>Codigo del producto</th>");
                    html.println("<th>Fabricante del producto</th>");
                    html.println("<th>Cantidad Vendida</th>");
                html.println("</tr>");
            html.println("</thead>");
            html.println("<tbody>");
                //Ciclo de imprecion de los datos a generar
                ///////////////////////////////////////////////
                for (int i = 0; i < productosMasVendidos.size(); i++) {
                    html.println("<tbody>");
                        html.println("<td>"+productosMasVendidos.get(i)[0]+"</td>");
                        html.println("<td>"+productosMasVendidos.get(i)[1]+"</td>");
                        html.println("<td>"+productosMasVendidos.get(i)[2]+"</td>");
                        html.println("<td>"+productosMasVendidos.get(i)[3]+"</td>");
                    html.println("<tbody>");
                }
                ///////////////////////////////////////////////
            html.println("</tbody>");
        html.println("</table>");
        try {
            html.close();    
        } catch (Exception e) {
            
        }
        return html;
    }
    /**
     * Genera el reporte donde se incluyen los productos que no se han vendido en un atienda determinada
     * @param html
     * @return 
     */
    private PrintWriter htmlProductosNoVendidosPorTienda(PrintWriter html){
        ArrayList<String[]> productosNoVendidos = new ArrayList<String[]>();
        productosNoVendidos = this.consultaDB.productosNoVendidosPorTienda(this.codigoTienda,this.baseDeDatos);
        //////////////////////////////////////////////////////////////////////////////////////
        html.println("<h1>REPORTE DE LOS PRODUCTOS NO VENDIDOS EN LA TIENDA "+this.codigoTienda+" </h1>");
        html.println("<h2>Descripcion de los productos</h2>");
        html.println("<table border=\"1\">");
            html.println("<thead>");
                html.println("<tr>");
                    html.println("<th>Codigo del producto</th>");
                    html.println("<th>Nombre del producto</th>");
                    html.println("<th>Fabricante del producto</th>");
                html.println("</tr>");
            html.println("</thead>");
            html.println("<tbody>");
                //Ciclo de imprecion de los datos a generar
                ///////////////////////////////////////////////
                for (int i = 0; i < productosNoVendidos.size(); i++) {
                    html.println("<tbody>");
                        html.println("<td>"+productosNoVendidos.get(i)[0]+"</td>");
                        html.println("<td>"+productosNoVendidos.get(i)[1]+"</td>");
                        html.println("<td>"+productosNoVendidos.get(i)[2]+"</td>");
                    html.println("<tbody>");
                }
                ///////////////////////////////////////////////
            html.println("</tbody>");
        html.println("</table>");
        try {
            html.close();    
        } catch (Exception e) {
            
        }
        return html;
    }
    ///////////////////////////////////////////////////////////////////////
    //ASIGANACION DE VARIABLES EN USO PARA LA GENERACION DEL REPORTE HTML//
    ///////////////////////////////////////////////////////////////////////
    /**
     * Retorna el codigo de la tienda en la cual se realiza el reporte
     * @return
     */
    public String getCodigoTienda() {
        return codigoTienda;
    }
    /**
     * Asigna el codigo de la tienda en la cual se realiza el reporte
     * @param codigoTienda
     */
    public void setCodigoTienda(String codigoTienda) {
        this.codigoTienda = codigoTienda;
    }
    /**
     * Retorna el nit del cliente en el cual se realizara el reporte
     * @return
     */
    public String getNITcliente() {
        return NITcliente;
    }
    /**
     * Asigna el nit del cliente en el cual se realizara un reporte
     * @param NITcliente
     */
    public void setNITcliente(String NITcliente) {
        this.NITcliente = NITcliente;
    }
    /**
     * Retorna la fecha limite superior en la cual se evalua un reporte
     * @return
     */
    public String getTiempoSuperior() {
        return tiempoSuperior;
    }
    /**
     * Asigna la fecha limite superior en la cual se evalua un reporte
     * @param tiempoSuperior
     */
    public void setTiempoSuperior(String tiempoSuperior) {
        this.tiempoSuperior = tiempoSuperior;
    }
    /**
     * Rertona la fecha inferior en la cual se realiza un reporte
     * @return
     */
    public String getTimepoInferior() {
        return timepoInferior;
    }
    /**
     * Asigna la fecha inferior en la cial se evalua un reporte
     * @param timepoInferior
     */
    public void setTimepoInferior(String timepoInferior) {
        this.timepoInferior = timepoInferior;
    }
    
}
