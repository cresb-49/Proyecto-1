/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.Graphics;

import com.carlos.DBSuport.ConsultasDB;
import com.carlos.OuputDocs.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author benjamin
 */
public class CaracteristicaReportesJDialog extends javax.swing.JDialog {
    private ConsultasDB consDB = new ConsultasDB();
    private String codigoDeTiendaSeleccionada;
    private String nitClienteSelecionado;
    /**
     * Creates new form CaracteristicaReportesJDialog
     */
    public CaracteristicaReportesJDialog(java.awt.Frame parent, boolean modal,String tienda) {
        super(parent, modal);
        this.codigoDeTiendaSeleccionada=this.consDB.codigoTienda(tienda);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("REPORTES DE TIENDA");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jButtonRealizarreporte = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jButtonRealizarreporte.setText("Realizar Reporte");
        jButtonRealizarreporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRealizarreporteActionPerformed(evt);
            }
        });

        jLabel1.setText("1. Listado de productos que llegaran a la tienda");

        jLabel2.setText("2. Listado pedidos atrazados que llegaran a la tienda");

        jLabel3.setText("3. Listado de los pedidos que salieron de la tienda");

        jLabel4.setText("4. Compras realizadas por un cliente");

        jLabel5.setText("5. Pedidos de un cliente");

        jLabel6.setText("6. 10 productos mas vendidos en un lapso de tiempo");

        jLabel7.setText("7. Listado de los productos mas vendidos por tienda en un lapso de tiempo");

        jLabel8.setText("8. Listado de productos que no se han vendido por tienda");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setSelected(true);

        buttonGroup1.add(jRadioButton2);

        buttonGroup1.add(jRadioButton3);

        buttonGroup1.add(jRadioButton4);

        buttonGroup1.add(jRadioButton5);

        buttonGroup1.add(jRadioButton6);

        buttonGroup1.add(jRadioButton7);

        buttonGroup1.add(jRadioButton8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRealizarreporte))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton5)
                            .addComponent(jRadioButton6)
                            .addComponent(jRadioButton7)
                            .addComponent(jRadioButton8))))
                .addGap(46, 46, 46))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jRadioButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jRadioButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jRadioButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jRadioButton5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jRadioButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jRadioButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jRadioButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(jButtonRealizarreporte)
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRealizarreporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRealizarreporteActionPerformed
        // TODO add your handling code here:
        String confReporte = this.tipoReporte();
        
        GeneracionDelArchivo(confReporte);
    }//GEN-LAST:event_jButtonRealizarreporteActionPerformed
    private void GeneracionDelArchivo(String tipoReporte){
        
        JFileChooser ventanaDeGuardado = new JFileChooser();
        //se establece el modo de trabajo de Jfilechooser
        ventanaDeGuardado.setFileSelectionMode(0);
        ventanaDeGuardado.setDialogTitle("Guardar en");
        //filtro para el tipo de archivos de guadado del archivo
        FileNameExtensionFilter filtroExportacion=new FileNameExtensionFilter("HTML","html");
        ventanaDeGuardado.setFileFilter(filtroExportacion);
        //extremos el directorio por defento donde aparecera el jFileChooser
        String src = ventanaDeGuardado.getCurrentDirectory().toString();
        //Nombre por el cual se genera el archivo
        String nameFile = tipoReporte+".html";
        //Completado del path completo con nombre de archivo
        src= src +"/"+nameFile;
        //se genera una variable de tipo file para almacenar el path y asignarlo al JFileChooser
        File archivo = new File(src);
        //Asignacion del archivo seleccionado
        ventanaDeGuardado.setSelectedFile(archivo);
        //condicion si se da en el boton de aceptar en la interfaz del JFileChooser
        if(ventanaDeGuardado.showSaveDialog(this)==JFileChooser.APPROVE_OPTION){
            /*Extraemos nuevamente el path del archivo por si este 
            cambio de parametros como de directorio como el nombre del archivo a guardar
            */
            File guardado = ventanaDeGuardado.getSelectedFile();
            //comprueba si el archivo termina en extencion .html
            if(guardado.getName().endsWith(".html")){
                //comprueba si hay un archivo con las misma caracteristicas
                if(!(guardado.exists()))
                {
                    //usa un objeto de tipo GenerateHTML para crear el archivo de salida
                    //Segun el tipo de reporte se puede crear un archivo con un contenido u otro
                    GenerateHTML html = new GenerateHTML(guardado);
                    html.setCodigoTienda(this.codigoDeTiendaSeleccionada);
                    html.setNITcliente("");
                    html.setTiempoSuperior("");
                    html.setTimepoInferior("");
                    
                    html.Generate(tipoReporte);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Existe un archivo con el mismo nombre guardelo con otro nombre");
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Tipo de archivo no soportado exporte nuevamente la infomarmacion");
            }
        }
    }
    private String tipoReporte(){
        String tipoReporte = "";
        if(jRadioButton1.isSelected()){
            tipoReporte = "Listado_Entrada_Pedido";
        }   
        if(jRadioButton2.isSelected()){
            tipoReporte = "Listado_Pedido_Atrazado";
        }
        if(jRadioButton3.isSelected()){
            tipoReporte = "Listado_Pedidos_Salida_Tienda";
        }
        if(jRadioButton4.isSelected()){
            tipoReporte = "Listado_Compras_Cliente_";
            this.nitClienteSelecionado = JOptionPane.showInputDialog(this, "Ingrese el nit del cliente en el cual se basara el reporte");
        }
        if(jRadioButton5.isSelected()){
            tipoReporte = "Listado_Pedidos_Cliente_";
            this.nitClienteSelecionado = JOptionPane.showInputDialog(this, "Ingrese el nit del cliente en el cual se basara el reporte");
        }
        if(jRadioButton6.isSelected()){
            tipoReporte = "10_Productos_Mas_Vendidos";
        }
        if(jRadioButton7.isSelected()){
            tipoReporte = "Listado_Produtos_Mas_Vendidos";
        }
        if(jRadioButton8.isSelected()){
            tipoReporte = "Listado_Productos_No_Vendidos";
        }
        return tipoReporte;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonRealizarreporte;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    // End of variables declaration//GEN-END:variables
}
