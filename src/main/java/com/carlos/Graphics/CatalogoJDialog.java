/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.Graphics;

import com.carlos.DBSuport.ConexionDB;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author benjamin
 */
public class CatalogoJDialog extends javax.swing.JDialog {
    //Conexion a base de datos
    private Connection baseDeDatos;
    /**
     * Genera una ventana en la cual por medio de una tablas y por metodo de ordenamiento de base de datos podemos visualizar todo el catalogo de productos
     * @param parent
     * @param modal
     * @param conexionBaseDatos
     */
    public CatalogoJDialog(java.awt.Frame parent, boolean modal,Connection conexionBaseDatos) {
        super(parent, modal);
        this.baseDeDatos=conexionBaseDatos;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("CATALOGO");
        ListarDatos();
        jFormattedTextFieldBusqeuda.setEditable(false);
    }
    /**
     * Recupera la informacion a nivel visual y genera la orden para la pedida de informacion
     */
    private void ListarDatos(){
        DefaultTableModel modeloDeTabla;
        
        //Sentencia por defecto
        //"SELECT PRODUCTO.nombre, PRODUCTO.fabricante, PRODUCTO.codigo, EXISTENCIA.cantidad, PRODUCTO.precio, TIENDA.nombre FROM PRODUCTO, TIENDA, EXISTENCIA where PRODUCTO_codigo = PRODUCTO.codigo AND TIENDA_codigo = TIENDA.codigo and PRODUCTO.nombre LIKE '%10%' ORDER BY PRODUCTO.nombre ASC;";
        String sentencia = "SELECT PRODUCTO.nombre, PRODUCTO.fabricante, PRODUCTO.codigo, EXISTENCIA.cantidad, PRODUCTO.precio, TIENDA.nombre FROM PRODUCTO INNER JOIN TIENDA INNER JOIN EXISTENCIA ON PRODUCTO_codigo = PRODUCTO.codigo AND TIENDA_codigo = TIENDA.codigo";
        String modoDeBusqueda = jComboBoxParametroDeBusqueda.getSelectedItem().toString();
        String busqueda = jFormattedTextFieldBusqeuda.getText();
        //tabla.columna like '%10%'
        String like="";
        if(modoDeBusqueda.equals("Todos los productos")){
            like = "";
        }
        if(modoDeBusqueda.equals("Codigo del producto")){
            like = " AND PRODUCTO.codigo LIKE '%"+busqueda+"%' ";
        }
        if(modoDeBusqueda.equals("Nombre del porducto")){
            like = " AND PRODUCTO.nombre LIKE '%"+busqueda+"%' ";
        }
        if(modoDeBusqueda.equals("Fabricante del Producto")){
            like = " AND PRODUCTO.fabricante LIKE '%"+busqueda+"%' ";
        }
        //parte referida al orden
        String asenDes="";
        if(jRadioButtonAcendente.isSelected()){
            asenDes="ASC;";
        }
        if(jRadioButtonDecendente.isSelected()){
            asenDes="DESC;";
        }
        //parte refirida a la organizacion del orden
        String orden="";
        if(jRadioButtonNombre.isSelected()){
            orden = " ORDER BY PRODUCTO.nombre ";
        }
        if(jRadioButtonfabri.isSelected()){
            orden = " ORDER BY PRODUCTO.fabricante ";
        }
        if(jRadioButtonCodigo.isSelected()){
            orden = " ORDER BY PRODUCTO.codigo ";
        }
        if(jRadioButtonCantidad.isSelected()){
            orden = " ORDER BY EXISTENCIA.cantidad ";
        }
        if(jRadioButtonPrecio.isSelected()){
            orden = " ORDER BY PRODUCTO.precio ";
        }
        if(jRadioButtonTienda.isSelected()){
            orden = " ORDER BY TIENDA.nombre ";
        }
        //System.out.println(sentencia+like+orden+asenDes);
        sentencia = sentencia+like+orden+asenDes;
        try(PreparedStatement preSt = this.baseDeDatos.prepareStatement(sentencia)){
            ResultSet result = preSt.executeQuery();
            Object[] cliente = new Object[6];
            modeloDeTabla = (DefaultTableModel)jTableCatalogo.getModel();
            modeloDeTabla.setNumRows(0);
            while (result.next()){
                cliente[0]=result.getString(1);
                cliente[1]=result.getString(2);
                cliente[2]=result.getString(3);
                cliente[3]=result.getString(4);
                cliente[4]=result.getString(5);
                cliente[5]=result.getString(6);
                modeloDeTabla.addRow(cliente);
            }
            this.jTableCatalogo.setModel(modeloDeTabla);
            result.close();
            preSt.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
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
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCatalogo = new javax.swing.JTable();
        jFormattedTextFieldBusqeuda = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxParametroDeBusqueda = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jRadioButtonAcendente = new javax.swing.JRadioButton();
        jRadioButtonDecendente = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jRadioButtonNombre = new javax.swing.JRadioButton();
        jRadioButtonfabri = new javax.swing.JRadioButton();
        jRadioButtonCodigo = new javax.swing.JRadioButton();
        jRadioButtonCantidad = new javax.swing.JRadioButton();
        jRadioButtonPrecio = new javax.swing.JRadioButton();
        jRadioButtonTienda = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableCatalogo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Fabricante", "Codigo", "Cantidad", "Precio", "Tienda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableCatalogo);

        jLabel1.setText("Parametro de Busqueda:");

        jComboBoxParametroDeBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos los productos", "Codigo del producto", "Nombre del porducto", "Fabricante del Producto" }));
        jComboBoxParametroDeBusqueda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxParametroDeBusquedaItemStateChanged(evt);
            }
        });

        jLabel2.setText("Busqueda");

        buttonGroup1.add(jRadioButtonAcendente);
        jRadioButtonAcendente.setSelected(true);
        jRadioButtonAcendente.setText("Acendente");

        buttonGroup1.add(jRadioButtonDecendente);
        jRadioButtonDecendente.setText("Decendente");

        jLabel3.setText("Orden de busqueda:");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButtonNombre);
        jRadioButtonNombre.setSelected(true);
        jRadioButtonNombre.setText("Ordenar por");
        jRadioButtonNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonNombreActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButtonfabri);
        jRadioButtonfabri.setText("Ordenar por");

        buttonGroup2.add(jRadioButtonCodigo);
        jRadioButtonCodigo.setText("Ordenar por");
        jRadioButtonCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCodigoActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButtonCantidad);
        jRadioButtonCantidad.setText("Ordenar por");
        jRadioButtonCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonCantidadActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButtonPrecio);
        jRadioButtonPrecio.setText("Ordenar por");
        jRadioButtonPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonPrecioActionPerformed(evt);
            }
        });

        buttonGroup2.add(jRadioButtonTienda);
        jRadioButtonTienda.setText("Ordenar por");
        jRadioButtonTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTiendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jRadioButtonNombre)
                .addGap(81, 81, 81)
                .addComponent(jRadioButtonfabri)
                .addGap(72, 72, 72)
                .addComponent(jRadioButtonCodigo)
                .addGap(71, 71, 71)
                .addComponent(jRadioButtonCantidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRadioButtonPrecio)
                .addGap(74, 74, 74)
                .addComponent(jRadioButtonTienda)
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonfabri)
                    .addComponent(jRadioButtonNombre)
                    .addComponent(jRadioButtonCodigo)
                    .addComponent(jRadioButtonCantidad)
                    .addComponent(jRadioButtonPrecio)
                    .addComponent(jRadioButtonTienda))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(119, 119, 119)
                                .addComponent(jComboBoxParametroDeBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jFormattedTextFieldBusqeuda, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel3)
                        .addGap(51, 51, 51)
                        .addComponent(jRadioButtonAcendente)
                        .addGap(41, 41, 41)
                        .addComponent(jRadioButtonDecendente)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxParametroDeBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldBusqeuda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButtonAcendente)
                    .addComponent(jRadioButtonDecendente)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButtonNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonNombreActionPerformed

    private void jRadioButtonCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonCodigoActionPerformed

    private void jRadioButtonCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonCantidadActionPerformed

    private void jRadioButtonPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonPrecioActionPerformed

    private void jRadioButtonTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTiendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonTiendaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ListarDatos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBoxParametroDeBusquedaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxParametroDeBusquedaItemStateChanged
        // TODO add your handling code here:
        String contenido = this.jFormattedTextFieldBusqeuda.getText();
        if(contenido.equals("Todos los productos")){
            jFormattedTextFieldBusqeuda.setText("");
            jFormattedTextFieldBusqeuda.setEditable(false);
        }
        else
        {
            jFormattedTextFieldBusqeuda.setEditable(true);
        }
        
    }//GEN-LAST:event_jComboBoxParametroDeBusquedaItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxParametroDeBusqueda;
    private javax.swing.JFormattedTextField jFormattedTextFieldBusqeuda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonAcendente;
    private javax.swing.JRadioButton jRadioButtonCantidad;
    private javax.swing.JRadioButton jRadioButtonCodigo;
    private javax.swing.JRadioButton jRadioButtonDecendente;
    private javax.swing.JRadioButton jRadioButtonNombre;
    private javax.swing.JRadioButton jRadioButtonPrecio;
    private javax.swing.JRadioButton jRadioButtonTienda;
    private javax.swing.JRadioButton jRadioButtonfabri;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableCatalogo;
    // End of variables declaration//GEN-END:variables
}
