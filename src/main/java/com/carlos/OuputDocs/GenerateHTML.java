package com.carlos.OuputDocs;

import java.io.*;

public class GenerateHTML {
    private File archivo;

    public GenerateHTML (File archivo){
        this.archivo=archivo;
    }
    /**
     * Genera el archivo html
     */
    public void Generate (){
        //genera un lugar de escritura
        PrintWriter html = null;
        try {
            html = new PrintWriter(new DataOutputStream(new FileOutputStream(archivo)));
            html = this.htmlContenent(html);
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
        html.println("<h2>Pedidos que llegaran</h2>");
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
}