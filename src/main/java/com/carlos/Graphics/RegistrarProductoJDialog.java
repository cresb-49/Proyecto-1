/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.Graphics;

import com.carlos.DBSuport.*;

import com.carlos.Entities.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author benjamin
 */
public class RegistrarProductoJDialog extends javax.swing.JDialog {
    private ConexionDB con = new ConexionDB();
    private Connection cn;
    private Statement st;
    private ResultSet rs;
    /**
     * Creates new form RegistrarProductoJDialog
     */
    //private String tienda;
    public RegistrarProductoJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("REGISTRO DE PRODUCTO");
        listarDatos();
        listarTiendas();
        jTextFieldCampoDeBusquedaProductos.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField6 = new javax.swing.JFormattedTextField();
        jFormattedTextField8 = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextFieldNombre = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextFieldFabricante = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextFieldCodigo = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jFormattedTextFieldCantidad = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jFormattedTextFieldPrecio = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jFormattedTextFieldGatantia = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDescripcion = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jTextFieldCampoDeBusquedaProductos = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxTipoBusquedaProductos = new javax.swing.JComboBox<>();
        jButtonBuscar2 = new javax.swing.JButton();
        jComboBoxTiendas = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REGISTRAR PRODUCTO");

        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButtonModificar)
                    .addComponent(jButtonLimpiar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setText("* campos obligatorios del formulario");

        jLabel1.setText("* Nombre:");

        jLabel2.setText("* Fabricante:");

        jLabel3.setText("* Codigo:");

        jLabel4.setText("* Cantidad:");

        jFormattedTextFieldCantidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel5.setText("* Precio:");

        jFormattedTextFieldPrecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jLabel6.setText("Garantia (meses):");

        jFormattedTextFieldGatantia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        jLabel7.setText("Descripcion:");

        jTextAreaDescripcion.setColumns(20);
        jTextAreaDescripcion.setRows(5);
        jScrollPane2.setViewportView(jTextAreaDescripcion);

        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Tienda"
            }
        ));
        jTableProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableProductos);

        jLabel10.setText("Tipo de busqueda:");

        jComboBoxTipoBusquedaProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nombre", "Codigo", "Tienda" }));
        jComboBoxTipoBusquedaProductos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxTipoBusquedaProductosItemStateChanged(evt);
            }
        });

        jButtonBuscar2.setText("Buscar");
        jButtonBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(39, 39, 39)
                        .addComponent(jComboBoxTipoBusquedaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jTextFieldCampoDeBusquedaProductos)
                        .addGap(30, 30, 30)
                        .addComponent(jButtonBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBoxTipoBusquedaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBuscar2)
                    .addComponent(jTextFieldCampoDeBusquedaProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel14.setText("*Tienda de registro de producto:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jFormattedTextFieldGatantia, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jFormattedTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jFormattedTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jFormattedTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jFormattedTextFieldFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(85, 85, 85)
                            .addComponent(jFormattedTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel12))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel14)
                        .addGap(37, 37, 37)
                        .addComponent(jComboBoxTiendas, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxTiendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jFormattedTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jFormattedTextFieldFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jFormattedTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jFormattedTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jFormattedTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jFormattedTextFieldGatantia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(496, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String nombre;
        String fabricante;
        String codigo;
        int cantidad=0;
        float precio=0;
        int garantia=0;
        String descripcion;
        String tienda;
        nombre = this.jFormattedTextFieldNombre.getText();
        fabricante = this.jFormattedTextFieldFabricante.getText();
        codigo = this.jFormattedTextFieldCodigo.getText();
        descripcion = this.jTextAreaDescripcion.getText();
        tienda = this.jComboBoxTiendas.getSelectedItem().toString();
        //Realiza las conversiones para la comprobacion de informacion
        try {
            cantidad = Integer.parseInt(this.jFormattedTextFieldCantidad.getText());
            precio = Float.parseFloat(this.jFormattedTextFieldPrecio.getText());
            garantia = Integer.parseInt(this.jFormattedTextFieldGatantia.getText());
        } catch (Exception e) {
        }
        //Verifica los campos obligatorios de registro del producto
        if(nombre.equals("")||fabricante.equals("")||codigo.equals("")||cantidad <= 0||precio<=0){
            JOptionPane.showMessageDialog(this, "Campos obligatorios no completados");
        }
        else
        {
            //verifica que la garantia del producto sea la carrecta
            if(!(garantia<0))
            {
                Product productoNuevo = new Product(nombre, fabricante, codigo, cantidad, precio, descripcion, garantia,tienda);
                RegistroDB nuevoProducto = new RegistroDB();
                String respuesta1 = nuevoProducto.registroProducto(productoNuevo);
                String respuesta2 = nuevoProducto.registroExistencia(productoNuevo);
                if(!(respuesta1.equals(""))||!(respuesta2.equals(""))){
                    JOptionPane.showMessageDialog(this, respuesta1+respuesta2);
                }
                else{
                    JOptionPane.showMessageDialog(this, "Producto Registrado con exito");
                    listarDatos();
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Campo de garantia incorrecto");
            }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        // TODO add your handling code here:
        this.jFormattedTextFieldNombre.setText(null);
        this.jFormattedTextFieldFabricante.setText(null);
        this.jFormattedTextFieldCodigo.setText(null);
        this.jFormattedTextFieldCantidad.setText(null);
        this.jFormattedTextFieldGatantia.setText(null);
        this.jTextAreaDescripcion.setText(null);
        this.jFormattedTextFieldPrecio.setText("0.00");
        //------------------------------------------------
        this.jFormattedTextFieldCodigo.setEditable(true);
        //------------------------------------------------
    }//GEN-LAST:event_jButtonLimpiarActionPerformed
    private void buscarDatos(){
        String codigo = this.jFormattedTextFieldCodigo.getText();
        this.jFormattedTextFieldCodigo.setEditable(false);
    }
    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        // TODO add your handling code here:
        String nombre;
        String fabricante;
        String codigo;
        int cantidad=0;
        float precio=0;
        int garantia=0;
        String descripcion;
        String tienda; 
        nombre = this.jFormattedTextFieldNombre.getText();
        fabricante = this.jFormattedTextFieldFabricante.getText();
        codigo = this.jFormattedTextFieldCodigo.getText();
        descripcion = this.jTextAreaDescripcion.getText();
        tienda = this.jComboBoxTiendas.getSelectedItem().toString();
        //Realiza las converciones para verificar los campos
        try {
            cantidad = Integer.parseInt(this.jFormattedTextFieldCantidad.getText());
            precio = Float.parseFloat(this.jFormattedTextFieldPrecio.getText());
            garantia = Integer.parseInt(this.jFormattedTextFieldGatantia.getText());
        } catch (Exception e) {
        }
        //Verifica los campos obligatorio del formulario
        if(nombre.equals("")||fabricante.equals("")||cantidad <= 0||precio<=0){
            JOptionPane.showMessageDialog(this, "Error en los datos obligatorios\nRestaurando datos originales");
            buscarDatos();
        }
        else
        {
            //verfica de la garantia sea la correcta
            if(!(garantia<0))
            {
                Product productoModifacar = new Product(nombre, fabricante, codigo, cantidad, precio, descripcion, garantia,tienda);
                ModificacionesDB modificacion = new ModificacionesDB();
                String respuesta1 = modificacion.modificarProducto(productoModifacar);
                String respuesta2 = modificacion.modificarExistencia(productoModifacar);
                if(!(respuesta1.equals(""))||!(respuesta2.equals(""))){
                    JOptionPane.showMessageDialog(this, respuesta1+respuesta2);
                }
                else{
                    JOptionPane.showMessageDialog(this, "El producto se ha modiciado con exito");
                    listarDatos();
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Campo de garantia incorrecto\nRestaurando datos originales");
                buscarDatos();
            }
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jComboBoxTipoBusquedaProductosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxTipoBusquedaProductosItemStateChanged
        // TODO add your handling code here:
        String contenido = this.jComboBoxTipoBusquedaProductos.getSelectedItem().toString();
        if(contenido.equals("Todos")){
            this.jTextFieldCampoDeBusquedaProductos.setEditable(false);
            this.jTextFieldCampoDeBusquedaProductos.setText("");
        }
        else{
            this.jTextFieldCampoDeBusquedaProductos.setEditable(true);
        }
    }//GEN-LAST:event_jComboBoxTipoBusquedaProductosItemStateChanged

    private void jButtonBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscar2ActionPerformed
        // TODO add your handling code here:
        if(jTextFieldCampoDeBusquedaProductos.getText().equals("")&&!(jComboBoxTipoBusquedaProductos.getSelectedItem().toString().equals("Todos")))
        {
            JOptionPane.showMessageDialog(this, "Introduzca una palabra clave para la busqueda");
        }
        else{
            listarDatos();
        }
    }//GEN-LAST:event_jButtonBuscar2ActionPerformed

    private void jTableProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductosMouseClicked
        // TODO add your handling code here:
        this.jFormattedTextFieldCodigo.setEditable(false);
        int filaSeleccionada = jTableProductos.getSelectedRow();
        
        if(!(filaSeleccionada==-1)){
            String codigoProducto = String.valueOf(jTableProductos.getValueAt(filaSeleccionada, 0));
            String codigoTienda = String.valueOf(jTableProductos.getValueAt(filaSeleccionada, 2));
            ConsultasDB consutaProducto = new ConsultasDB();
            listarTiendas();
            ArrayList<String> datosProducto = new ArrayList<String>();
            datosProducto=consutaProducto.datosProducto(codigoProducto);
            
            String cantidad = consutaProducto.datosExistenciaProducto(codigoProducto, codigoTienda);
            
            jFormattedTextFieldCodigo.setText(codigoProducto);
            jFormattedTextFieldNombre.setText(datosProducto.get(0));
            jFormattedTextFieldFabricante.setText(datosProducto.get(1));
            jFormattedTextFieldPrecio.setText(datosProducto.get(2));
            jTextAreaDescripcion.setText(datosProducto.get(3));
            jFormattedTextFieldGatantia.setText(datosProducto.get(4));
            jFormattedTextFieldCantidad.setText(cantidad);
            jComboBoxTiendas.setSelectedItem(codigoTienda);
        }
    }//GEN-LAST:event_jTableProductosMouseClicked
    private void listarTiendas(){
        ConsultasDB consutaTiendas = new ConsultasDB();
        ArrayList<String> tiendas = new ArrayList<String>();
            tiendas = consutaTiendas.codigosDeTiendas();
            jComboBoxTiendas.removeAllItems();
            for (int i = 0; i < tiendas.size(); i++) {
                jComboBoxTiendas.addItem(tiendas.get(i));
            }
    }
    private void listarDatos(){
        
        DefaultTableModel modeloDeTabla;
        String modoListado = this.jComboBoxTipoBusquedaProductos.getSelectedItem().toString();
        String sentencia = "SELECT codigo,nombre,TIENDA_codigo FROM PRODUCTO,EXISTENCIA WHERE PRODUCTO_codigo = codigo ORDER BY codigo ASC";
        String busqueda="";
        busqueda = this.jTextFieldCampoDeBusquedaProductos.getText();
        if(modoListado.equals("Todos")){
            sentencia = "SELECT codigo,nombre,TIENDA_codigo FROM PRODUCTO,EXISTENCIA WHERE codigo = PRODUCTO_codigo ORDER BY codigo ASC;";
        }
        if(modoListado.equals("Codigo")){
            sentencia = "SELECT codigo,nombre,TIENDA_codigo FROM PRODUCTO,EXISTENCIA WHERE codigo = PRODUCTO_codigo AND codigo LIKE '%"+busqueda+"%' ORDER BY codigo ASC;";
        }
        if(modoListado.equals("Nombre")){
            sentencia = "SELECT codigo,nombre,TIENDA_codigo FROM PRODUCTO,EXISTENCIA WHERE codigo = PRODUCTO_codigo AND nombre LIKE '%"+busqueda+"%' ORDER BY codigo ASC;";
        }
        if(modoListado.equals("Tienda")){
            sentencia = "SELECT codigo,nombre,TIENDA_codigo FROM PRODUCTO,EXISTENCIA WHERE codigo = PRODUCTO_codigo AND TIENDA_codigo LIKE '%"+busqueda+"%' ORDER BY codigo ASC;";
        }
        try {
            cn=con.getConexion();
            st=cn.createStatement();
            rs = st.executeQuery(sentencia);
            Object[] productos = new Object[3];
            modeloDeTabla = (DefaultTableModel)jTableProductos.getModel();
            modeloDeTabla.setNumRows(0);
            while (rs.next()){
                productos[0]=rs.getString(1);
                productos[1]=rs.getString(2);
                productos[2]=rs.getString(3);
                modeloDeTabla.addRow(productos);
            }
            jTableProductos.setModel(modeloDeTabla);
        } catch (Exception e) {
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonBuscar1;
    private javax.swing.JButton jButtonBuscar2;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JComboBox<String> jComboBoxTiendas;
    private javax.swing.JComboBox<String> jComboBoxTipoBusqueda;
    private javax.swing.JComboBox<String> jComboBoxTipoBusqueda1;
    private javax.swing.JComboBox<String> jComboBoxTipoBusquedaProductos;
    private javax.swing.JFormattedTextField jFormattedTextField6;
    private javax.swing.JFormattedTextField jFormattedTextField8;
    private javax.swing.JFormattedTextField jFormattedTextFieldCantidad;
    private javax.swing.JFormattedTextField jFormattedTextFieldCodigo;
    private javax.swing.JFormattedTextField jFormattedTextFieldFabricante;
    private javax.swing.JFormattedTextField jFormattedTextFieldGatantia;
    private javax.swing.JFormattedTextField jFormattedTextFieldNombre;
    private javax.swing.JFormattedTextField jFormattedTextFieldPrecio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTable jTableClientes1;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTextArea jTextAreaDescripcion;
    private javax.swing.JTextField jTextFieldCampoDeBusqueda;
    private javax.swing.JTextField jTextFieldCampoDeBusqueda1;
    private javax.swing.JTextField jTextFieldCampoDeBusquedaProductos;
    // End of variables declaration//GEN-END:variables
}
