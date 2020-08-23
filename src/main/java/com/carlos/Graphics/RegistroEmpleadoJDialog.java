/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.Graphics;

import com.carlos.DBSuport.ConexionDB;
import com.carlos.DBSuport.ConsultasDB;
import com.carlos.DBSuport.ModificacionesDB;
import com.carlos.DBSuport.RegistroDB;
import com.carlos.Entities.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author benjamin
 */
public class RegistroEmpleadoJDialog extends javax.swing.JDialog {
    //Variables de base de datos
    private Connection baseDeDatos ;
    /**
     * Creates new form RegistroEmpleadoJDialog
     */
    public RegistroEmpleadoJDialog(java.awt.Frame parent, boolean modal,Connection conexionBaseDatos) {
        super(parent, modal);
        this.baseDeDatos=conexionBaseDatos;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("REGISTRO DE EMPLEADO");
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jFormattedTextFieldNombre = new javax.swing.JFormattedTextField();
        jFormattedTextFieldTelefono = new javax.swing.JFormattedTextField();
        jFormattedTextFieldCodigo = new javax.swing.JFormattedTextField();
        jFormattedTextFieldDPI = new javax.swing.JFormattedTextField();
        jFormattedTextField1NIT = new javax.swing.JFormattedTextField();
        jFormattedTextFieldEmail = new javax.swing.JFormattedTextField();
        jButtonRegistrar = new javax.swing.JButton();
        jFormattedTextFieldDireccion = new javax.swing.JFormattedTextField();
        jButtonModificar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButtonLimpiar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldCampoDeBusqueda = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBoxTipoBusqueda = new javax.swing.JComboBox<>();
        jButtonBuscar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEmpleados = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("* Codigo:");

        jLabel2.setText("* Nombre:");

        jLabel3.setText("* Telefono:");

        jLabel4.setText("NIT:");

        jLabel5.setText("* DPI");

        jLabel6.setText("* Email:");

        jLabel7.setText("* Direccion:");

        try {
            jFormattedTextFieldTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldDPI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        jButtonModificar.setText("Modificar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jLabel13.setText("* Campos obligarios del formulario");

        jButtonLimpiar.setText("Limpiar Campos");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jLabel12.setText("EMPLEADOS");

        jLabel8.setText("Tipo de busqueda:");

        jComboBoxTipoBusqueda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Nombre", "Codigo" }));
        jComboBoxTipoBusqueda.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxTipoBusquedaItemStateChanged(evt);
            }
        });

        jButtonBuscar1.setText("Buscar");
        jButtonBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscar1ActionPerformed(evt);
            }
        });

        jTableEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Telefono"
            }
        ));
        jTableEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEmpleados);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(145, 145, 145))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(39, 39, 39)
                                    .addComponent(jComboBoxTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jTextFieldCampoDeBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButtonBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBoxTipoBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBuscar1)
                    .addComponent(jTextFieldCampoDeBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4))
                                    .addComponent(jLabel3))
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFormattedTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormattedTextFieldDPI, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormattedTextField1NIT, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormattedTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormattedTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jFormattedTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(56, 56, 56)
                                        .addComponent(jFormattedTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(18, 21, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jFormattedTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jFormattedTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jFormattedTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextField1NIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFormattedTextFieldDPI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonRegistrar)
                            .addComponent(jButtonModificar)
                            .addComponent(jButtonLimpiar))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        // TODO add your handling code here:
        String codigoEmpleado;
        String nombre;
        String NIT;
        long telefono=0;
        long DPI=0;
        String correoElectronico;
        String direccion;
        //Extraccion de informacion ingresada en el formulario
        codigoEmpleado = this.jFormattedTextFieldCodigo.getText();
        nombre = this.jFormattedTextFieldNombre.getText();
        NIT = this.jFormattedTextField1NIT.getText();
        correoElectronico= this.jFormattedTextFieldDireccion.getText();
        direccion = this.jFormattedTextFieldDireccion.getText();
        try {
            telefono = Long.parseLong(this.jFormattedTextFieldTelefono.getText());
            DPI = Long.parseLong(this.jFormattedTextFieldDPI.getText());
        } catch (Exception e) {
        }
        if(codigoEmpleado.equals("")||nombre.equals("")||telefono==0||DPI==0||correoElectronico.equals("")||direccion.equals("")){
            JOptionPane.showMessageDialog(this, "No ah completado los campos obligatorios del formulario");
        }
        else
        {
            String resultadoDPI="";
            if(DPI>0){
                resultadoDPI=String.valueOf(DPI);
            }
            Employee nuevoEmpledo = new Employee(codigoEmpleado, nombre, String.valueOf(telefono), NIT, resultadoDPI, correoElectronico, direccion);
            RegistroDB registroEmpleado = new RegistroDB();
            String respuesta = registroEmpleado.registroEmpleado(nuevoEmpledo,this.baseDeDatos);
            if(!(respuesta.equals(""))){
                JOptionPane.showMessageDialog(this, respuesta);
            }
            else{
                JOptionPane.showMessageDialog(this, "Se ha registrado el empleado con exito");
                this.limpiezaDeCampos();
                listarDatos();
            }
        }
        
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        // TODO add your handling code here:
        this.limpiezaDeCampos();
    }//GEN-LAST:event_jButtonLimpiarActionPerformed
    /**
     * Elimina el texto que se encuentra en las entrdas de texto
     */
    private void limpiezaDeCampos(){
         //----------------------------------------------
        this.jFormattedTextFieldCodigo.setEditable(true);
        //----------------------------------------------
        this.jFormattedTextFieldCodigo.setText(null);
        this.jFormattedTextFieldNombre.setText(null);
        this.jFormattedTextFieldTelefono.setText(null);
        this.jFormattedTextField1NIT.setText(null);
        this.jFormattedTextFieldDPI.setText(null);
        this.jFormattedTextFieldEmail.setText(null);
        this.jFormattedTextFieldDireccion.setText(null);
    }
    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        // TODO add your handling code here:
        String codigoEmpleado;
        String nombre;
        String NIT;
        long telefono=0;
        long DPI=0;
        String correoElectronico;
        String direccion;
        //Extraccion de la informacion del formulario
        codigoEmpleado = this.jFormattedTextFieldCodigo.getText();
        nombre = this.jFormattedTextFieldNombre.getText();
        NIT = this.jFormattedTextField1NIT.getText();
        correoElectronico= this.jFormattedTextFieldEmail.getText();
        direccion = this.jFormattedTextFieldDireccion.getText();
        try {
            telefono = Long.parseLong(this.jFormattedTextFieldTelefono.getText());
            DPI = Long.parseLong(this.jFormattedTextFieldDPI.getText());
        } catch (Exception e) {
        }
        if(codigoEmpleado.equals("")||nombre.equals("")||telefono==0||DPI==0||correoElectronico.equals("")||direccion.equals("")){
            JOptionPane.showMessageDialog(this, "No ah completado los campos obligatorios del formulario");
        }
        else
        {
            String resultadoDPI="";
            if(DPI>0){
                resultadoDPI=String.valueOf(DPI);
            }
            Employee empleadoModificado = new Employee(codigoEmpleado, nombre, String.valueOf(telefono), NIT, resultadoDPI, correoElectronico, direccion);
            ModificacionesDB modificarEmpleado = new ModificacionesDB();
            String respuesta = modificarEmpleado.modificarEmpleado(empleadoModificado,this.baseDeDatos);
            if(!(respuesta.equals(""))){
                JOptionPane.showMessageDialog(this, respuesta);
            }
            else{
                JOptionPane.showMessageDialog(this, "Se ha modificado con exito el empleado");
                listarDatos();
            }
            
        }
    }//GEN-LAST:event_jButtonModificarActionPerformed

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

    private void jButtonBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscar1ActionPerformed
        // TODO add your handling code here:
        if(jTextFieldCampoDeBusqueda.getText().equals("")&&!(jComboBoxTipoBusqueda.getSelectedItem().toString().equals("Todos")))
        {
            JOptionPane.showMessageDialog(this, "Introduzca una palabra clave para la busqueda");
        }
        else{
            listarDatos();
        }
    }//GEN-LAST:event_jButtonBuscar1ActionPerformed

    private void jTableEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmpleadosMouseClicked
        // TODO add your handling code here:
        this.jFormattedTextFieldCodigo.setEditable(false);
        int filaSeleccionada = jTableEmpleados.getSelectedRow();
        if(!(filaSeleccionada==-1)){
            String codigoEmpleado = String.valueOf(jTableEmpleados.getValueAt(filaSeleccionada, 0));
            ConsultasDB consultaEmpleado = new ConsultasDB();
            ArrayList<String> datosCliente = consultaEmpleado.datosEmpleado(codigoEmpleado,this.baseDeDatos);
            jFormattedTextFieldCodigo.setText(codigoEmpleado);
            jFormattedTextFieldNombre.setText(datosCliente.get(0));
            jFormattedTextFieldTelefono.setText(datosCliente.get(1));
            jFormattedTextFieldDPI.setText(datosCliente.get(2));
            jFormattedTextField1NIT.setText(datosCliente.get(3));
            jFormattedTextFieldEmail.setText(datosCliente.get(4));
            jFormattedTextFieldDireccion.setText(datosCliente.get(5));
        }
    }//GEN-LAST:event_jTableEmpleadosMouseClicked
    /**
     * Lsita los empleados en la tabla que se encuntra en la tabla de interfaz
     */
    private void listarDatos(){
        DefaultTableModel modeloDeTabla;
        String modoListado = this.jComboBoxTipoBusqueda.getSelectedItem().toString();
        String sentencia = "SELECT * FROM EMPLEADO WHERE nombre LIKE ? ORDER BY ? ASC;";
        String busqueda="";
        busqueda = this.jTextFieldCampoDeBusqueda.getText();
        if(modoListado.equals("Todos")){
            sentencia = "SELECT * FROM EMPLEADO ORDER BY codigo ASC";
        }
        if(modoListado.equals("Codigo")){
            sentencia = "SELECT * FROM EMPLEADO WHERE codigo LIKE ? ORDER BY codigo ASC;";
        }
        if(modoListado.equals("Nombre")){
            sentencia = "SELECT * FROM EMPLEADO WHERE nombre LIKE ? ORDER BY codigo ASC;";
        }
        
        try(PreparedStatement preSt = this.baseDeDatos.prepareStatement(sentencia)){
            if(!(modoListado.equals("Todos"))){
                preSt.setString(1, "%" + busqueda + "%");
            }
            ResultSet result = preSt.executeQuery();
            Object[] empleado = new Object[3];
            modeloDeTabla = (DefaultTableModel)jTableEmpleados.getModel();
            modeloDeTabla.setNumRows(0);
            while (result.next()){
                empleado[0]=result.getString(1);
                empleado[1]=result.getString(2);
                empleado[2]=result.getString(3);
                modeloDeTabla.addRow(empleado);
            }
            jTableEmpleados.setModel(modeloDeTabla);
            result.close();
            preSt.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar1;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JComboBox<String> jComboBoxTipoBusqueda;
    private javax.swing.JFormattedTextField jFormattedTextField1NIT;
    private javax.swing.JFormattedTextField jFormattedTextFieldCodigo;
    private javax.swing.JFormattedTextField jFormattedTextFieldDPI;
    private javax.swing.JFormattedTextField jFormattedTextFieldDireccion;
    private javax.swing.JFormattedTextField jFormattedTextFieldEmail;
    private javax.swing.JFormattedTextField jFormattedTextFieldNombre;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEmpleados;
    private javax.swing.JTextField jTextFieldCampoDeBusqueda;
    // End of variables declaration//GEN-END:variables
}
