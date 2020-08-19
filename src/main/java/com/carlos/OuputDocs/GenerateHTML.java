package com.carlos.OuputDocs;

import com.carlos.DBSuport.ConexionDB;
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

            }
            if(tipoReporte.equals("Listado_Productos_No_Vendidos")){

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            html.close();
        }
        
    }
    /**
     * Imprime el archivo html
     * @param html
     * @return
     */
    private PrintWriter htmlContenent(PrintWriter html){
        html.println("<h1>REPORTES DE TIENDA</h1>");
        html.println("<h2>Pedidos que llegaran a la tienda</h2>");
        html.println("<table border=\"1\">");
        html.println("</table>");
        html.println("<h2>Pedidos a confirmar entrada </h2>");
        html.println("<h2>Pedidos atrasados</h2>");
        html.println("<h2>Pedidos que han salido de la tienda</h2>");
        html.println("<h2>Pedidos que llegaran</h2>");
        html.println("<h2>Pedido por cliente seleccionado</h2>");
        html.println("<h2>Compras por cliente</h2>");
        html.println("<h2>10 productos mas vendidos</h2>");
        html.println("<h2>Productos mas vendisos por tienda</h2>");
        html.println("<h2>Productos que no se han vendido</h2>");
        try {
            html.close();    
        } catch (Exception e) {
            
        }
        return html;
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
    ///////////////////////////////////////////////////////////////////////
    //ASIGANACION DE VARIABLES EN USO PARA LA GENERACION DEL REPORTE HTML//
    ///////////////////////////////////////////////////////////////////////

    public String getCodigoTienda() {
        return codigoTienda;
    }

    public void setCodigoTienda(String codigoTienda) {
        this.codigoTienda = codigoTienda;
    }

    public String getNITcliente() {
        return NITcliente;
    }

    public void setNITcliente(String NITcliente) {
        this.NITcliente = NITcliente;
    }

    public String getTiempoSuperior() {
        return tiempoSuperior;
    }

    public void setTiempoSuperior(String tiempoSuperior) {
        this.tiempoSuperior = tiempoSuperior;
    }

    public String getTimepoInferior() {
        return timepoInferior;
    }

    public void setTimepoInferior(String timepoInferior) {
        this.timepoInferior = timepoInferior;
    }
    
}
