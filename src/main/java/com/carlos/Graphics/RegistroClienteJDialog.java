/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.Graphics;

import com.carlos.DBSuport.*;
import com.carlos.Entities.Client;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author benjamin
 */
public class RegistroClienteJDialog extends javax.swing.JDialog {
    private float copiaDeCredito;
    //Conexion a base de datos
    private ConexionDB baseDeDatos = new ConexionDB();
    
    /**
     * Creates new form RegistroClienteJDialog
     */
    public RegistroClienteJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("REGISTRO DE CLIENTE");
        this.jFormattedTextFieldCreditoCompra.setEditable(false);
        this.jTextFieldCampoDeBusqueda.setEditable(false);
        listarDatos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextFieldNombre = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextFieldTelefono = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextFieldNIT = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jFormattedTextFieldDPI = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jFormattedTextFieldEmail = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jFormattedTextFieldDirecion = new javax.swing.JFormattedTextField();
        jFormattedTextFieldCreditoCompra = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jButtonModificar = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButtonRegistrar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jButtonBuscar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxTipoBusqueda = new javax.swing.JComboBox<>();
        jTextFieldCampoDeBusqueda = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("* Nombre: ");

        jLabel2.setText("* Telefono: ");

        try {
            jFormattedTextFieldTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel3.setText("* NIT:");

        jLabel4.setText("DPI:");

        try {
            jFormattedTextFieldDPI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel5.setText("Correo Electronico:");

        jLabel7.setText("Dirección:");

        jFormattedTextFieldCreditoCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextFieldCreditoCompra.setText("0");

        jLabel6.setText("Credito Compra:");

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

        jLabel12.setText("* Campos obligarios del formulario");

        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        jLabel11.setText("CLIENTES");

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIT", "Nombre", "Telefono"
            }
        ));
        jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableClientes);

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jLabel8.setText("Tipo de busqueda:");

        jComboBoxTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nombre", "NIT" }));
        jComboBoxTipoBusqueda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxTipoBusquedaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(39, 39, 39)
                        .addComponent(jComboBoxTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextFieldCampoDeBusqueda)
                        .addGap(30, 30, 30)
                        .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 21, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(182, 182, 182))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBoxTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBuscar)
                    .addComponent(jTextFieldCampoDeBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jFormattedTextFieldDirecion, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormattedTextFieldCreditoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jFormattedTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jFormattedTextFieldDPI, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormattedTextFieldNIT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormattedTextFieldTelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormattedTextFieldNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel12)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jFormattedTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jFormattedTextFieldNIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jFormattedTextFieldDPI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jFormattedTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jFormattedTextFieldCreditoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jFormattedTextFieldDirecion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonModificar)
                            .addComponent(jButtonLimpiar)
                            .addComponent(jButtonRegistrar))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        // TODO add your handling code here:
        this.limpiezaCampos();
    }//GEN-LAST:event_jButtonLimpiarActionPerformed
    private void limpiezaCampos(){
        this.jFormattedTextFieldNombre.setText(null);
        this.jFormattedTextFieldTelefono.setText(null);
        this.jFormattedTextFieldNIT.setText(null);
        this.jFormattedTextFieldDPI.setText(null);
        this.jFormattedTextFieldCreditoCompra.setText("0.00");
        this.jFormattedTextFieldEmail.setText(null);
        this.jFormattedTextFieldDirecion.setText(null);
        //
        this.jFormattedTextFieldNIT.setEditable(true);
        this.jFormattedTextFieldCreditoCompra.setEditable(false);
    }
    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
        if(jTextFieldCampoDeBusqueda.getText().equals("")&&!(jComboBoxTipoBusqueda.getSelectedItem().toString().equals("Todos")))
        {
            JOptionPane.showMessageDialog(this, "Introduzca una palabra clave para la busqueda");
        }
        else{
            listarDatos();
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        // TODO add your handling code here:
        String nombre;
        String NIT;
        long telefono=0;
        long DPI=0;
        float creditoDecompra=0;
        String correoElectronico;
        String direccion;
        //
        boolean bandera =true;
        //Extrae y hace las converciones de los datos ingresados en el formulario
        nombre = this.jFormattedTextFieldNombre.getText();
        NIT = this.jFormattedTextFieldNIT.getText();
        correoElectronico = this.jFormattedTextFieldEmail.getText();
        direccion = this.jFormattedTextFieldDirecion.getText();
        try {
            if(this.jFormattedTextFieldTelefono.getText().length()==8)
            {
                telefono = Long.parseLong(this.jFormattedTextFieldTelefono.getText());
            }
            if(this.jFormattedTextFieldDPI.getText().length()!=0)
            {
                if(this.jFormattedTextFieldDPI.getText().length()==9)
                {
                    DPI = Long.parseLong(this.jFormattedTextFieldDPI.getText());
                }
            }
        } catch (Exception e) {
        }
       
        float tempCredito = 0;
        
        try {
            tempCredito = Float.parseFloat(this.jFormattedTextFieldCreditoCompra.getText());
        } catch (Exception e) {
        }
        if(tempCredito>=0)
        {
            creditoDecompra=tempCredito;
        }
        else
        {
            JOptionPane.showMessageDialog(this, "CANTIDAD DE CREDITO INCORRECTA");
            bandera=false;
        }
        //Verfiicacion de los datos de credito del cliente
        if(bandera)
        {
            if(nombre.equals("")||telefono==0){
                JOptionPane.showMessageDialog(this, "No se han completado los campos obligatorios del formulario");
            }
            else
            {
                String resultadoDPI="";
                if(DPI>0){
                    resultadoDPI=String.valueOf(DPI);
                }
                Client clienteModificado = new Client(nombre, String.valueOf(telefono), NIT, resultadoDPI, creditoDecompra, correoElectronico, direccion);
                ModificacionesDB modificarCliente = new ModificacionesDB();
                String respuesta = modificarCliente.modificarCliente(clienteModificado);
                if(!(respuesta.equals(""))){
                    JOptionPane.showMessageDialog(this, respuesta);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "Se ha modificado con exito en cliente");
                    listarDatos();
                }
            }
        }
        else
        {
            
        }
        
    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        // TODO add your handling code here:
        String nombre;
        String NIT;
        long telefono=0;
        long DPI=0;
        float creditoDecompra=0;
        String correoElectronico;
        String direccion;
        //
        boolean bandera =true;
        
        nombre = this.jFormattedTextFieldNombre.getText();
        NIT = this.jFormattedTextFieldNIT.getText();
        correoElectronico = this.jFormattedTextFieldEmail.getText();
        direccion = this.jFormattedTextFieldDirecion.getText();
        try {
            if(this.jFormattedTextFieldTelefono.getText().length()==8)
            {
                telefono = Long.parseLong(this.jFormattedTextFieldTelefono.getText());
            }
            if(this.jFormattedTextFieldDPI.getText().length()!=0)
            {
                if(this.jFormattedTextFieldDPI.getText().length()==9)
                {
                    DPI = Long.parseLong(this.jFormattedTextFieldDPI.getText());
                }
            }
            
            
        } catch (Exception e) {
        }
       
        float tempCredito = 0;
        
        try {
            tempCredito = Float.parseFloat(this.jFormattedTextFieldCreditoCompra.getText());
        } catch (Exception e) {
        }
        if(tempCredito>=0)
            {
                creditoDecompra=tempCredito;
            }
            else
            {
                JOptionPane.showMessageDialog(this, "CANTIDAD DE CREDITO INCORRECTA");
                bandera=false;
            }
        
        if(bandera)
        {
            if(nombre.equals("")||telefono==0){
                JOptionPane.showMessageDialog(this, "No se han completado los campos obligatorios del formulario");
            }
            else
            {
                String resultadoDPI="";
                if(DPI>0){
                    resultadoDPI=String.valueOf(DPI);
                }
                Client clienteNuevo = new Client(nombre, String.valueOf(telefono), NIT, resultadoDPI, creditoDecompra, correoElectronico, direccion);
                RegistroDB registroCliente = new RegistroDB();
                String respuesta = registroCliente.registroCliente(clienteNuevo,this.baseDeDatos.getConexion());
                if(!(respuesta.equals(""))){
                    JOptionPane.showMessageDialog(this, respuesta);
                }else{
                    JOptionPane.showMessageDialog(this, "Se ha registrado con exito el cliente");
                    limpiezaCampos();
                    listarDatos();
                }
            }
        }
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jComboBoxTipoBusquedaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxTipoBusquedaItemStateChanged
        // TODO add your handling code here:
        String contenido = this.jComboBoxTipoBusqueda.getSelectedItem().toString();
        if(contenido.equals("Todos")){
            this.jTextFieldCampoDeBusqueda.setEditable(false);
            this.jTextFieldCampoDeBusqueda.setText("");
        }
        else{
            this.jTextFieldCampoDeBusqueda.setEditable(true);
        }
    }//GEN-LAST:event_jComboBoxTipoBusquedaItemStateChanged

    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMouseClicked
        // TODO add your handling code here:
        this.jFormattedTextFieldNIT.setEditable(false);
        this.jFormattedTextFieldCreditoCompra.setEditable(true);
        int filaSeleccionada = jTableClientes.getSelectedRow();
        if(!(filaSeleccionada==-1)){
            String nitCliente = String.valueOf(jTableClientes.getValueAt(filaSeleccionada, 0));
            ConsultasDB consutaCliente = new ConsultasDB();
            ArrayList<String> datosCliente = consutaCliente.datosCliente(nitCliente,this.baseDeDatos.getConexion());
            jFormattedTextFieldNIT.setText(nitCliente);
            jFormattedTextFieldNombre.setText(datosCliente.get(0));
            jFormattedTextFieldTelefono.setText(datosCliente.get(1));
            jFormattedTextFieldCreditoCompra.setText(datosCliente.get(2));
            jFormattedTextFieldDPI.setText(datosCliente.get(3));
            jFormattedTextFieldEmail.setText(datosCliente.get(4));
            jFormattedTextFieldDirecion.setText(datosCliente.get(5));
        }
    }//GEN-LAST:event_jTableClientesMouseClicked

    private void listarDatos(){
        DefaultTableModel modeloDeTabla;
        String modoListado = this.jComboBoxTipoBusqueda.getSelectedItem().toString();
        String sentencia = "SELECT * FROM CLIENTE WHERE nombre LIKE ? ORDER BY nit ASC;";
        String busqueda="";
        busqueda = this.jTextFieldCampoDeBusqueda.getText();
        if(modoListado.equals("Todos")){
            sentencia = "SELECT * FROM CLIENTE ORDER BY nit ASC";
        }
        if(modoListado.equals("NIT")){
            sentencia = "SELECT * FROM CLIENTE WHERE nit LIKE ? ORDER BY nit ASC;";
        }
        if(modoListado.equals("Nombre")){
            sentencia = "SELECT * FROM CLIENTE WHERE nombre LIKE ? ORDER BY nit ASC;";
        }
        
        Connection conexion;
        conexion = this.baseDeDatos.getConexion();
        try (PreparedStatement preSt = conexion.prepareStatement(sentencia)){
            if(!(modoListado.equals("Todos"))){
                preSt.setString(1, "%" + busqueda + "%");
            }
            ResultSet result = preSt.executeQuery();
            Object[] cliente = new Object[3];
            modeloDeTabla = (DefaultTableModel)jTableClientes.getModel();
            modeloDeTabla.setNumRows(0);
            while (result.next()){
                cliente[0]=result.getString(1);
                cliente[1]=result.getString(2);
                cliente[2]=result.getString(3);
                modeloDeTabla.addRow(cliente);
            }
            jTableClientes.setModel(modeloDeTabla);
            result.close();
            preSt.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JComboBox<String> jComboBoxTipoBusqueda;
    private javax.swing.JFormattedTextField jFormattedTextFieldCreditoCompra;
    private javax.swing.JFormattedTextField jFormattedTextFieldDPI;
    private javax.swing.JFormattedTextField jFormattedTextFieldDirecion;
    private javax.swing.JFormattedTextField jFormattedTextFieldEmail;
    private javax.swing.JFormattedTextField jFormattedTextFieldNIT;
    private javax.swing.JFormattedTextField jFormattedTextFieldNombre;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTextField jTextFieldCampoDeBusqueda;
    // End of variables declaration//GEN-END:variables
}
