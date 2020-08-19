/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.Graphics;

import com.carlos.DBSuport.ConexionDB;
import com.carlos.TraslateDB.InputText;
import java.sql.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author benjamin
 */
public class PrincipalFrame extends javax.swing.JFrame {
    private ConexionDB con;
    private Connection cn;
    private Statement st;
    private ResultSet rs;
    //Esta variable representa el estado de la base de datos
    private boolean estadoDB=true;
    //True significa que la base de datos no tiene datos y false es que ya contiene datos en su interior

    /**
     * Creates new form PrincipalFrame
     */
    public PrincipalFrame(String titulo) {
        super(titulo);
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        try {
            con = new ConexionDB();
            this.comprobacionDB();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        ProfileComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonRegistrarse = new javax.swing.JButton();
        jButtonIniciarSesion = new javax.swing.JButton();
        jLabelImage = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jButtonRegistrarse.setText("Registrarse");
        jButtonRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarseActionPerformed(evt);
            }
        });

        jButtonIniciarSesion.setText("Iniciar Sesion");
        jButtonIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIniciarSesionActionPerformed(evt);
            }
        });

        jLabel3.setText("Bienvenidos a Mi Negocio");

        jLabel1.setText("Todos los derechos reservados © 2020");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonIniciarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonRegistrarse, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel3)
                        .addGap(31, 31, 31)
                        .addComponent(jButtonRegistrarse)
                        .addGap(28, 28, 28)
                        .addComponent(jButtonIniciarSesion)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarseActionPerformed
        // TODO add your handling code here:
        //Crea un frame de tipo de registro de clientes
        this.setVisible(false);
        RegistroCliente registroNuevo = new RegistroCliente(this);
        registroNuevo.setVisible(true);
    }//GEN-LAST:event_jButtonRegistrarseActionPerformed

    private void jButtonIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIniciarSesionActionPerformed
        // TODO add your handling code here:
        //Genera un frame de tipo login
        this.setVisible(false);
        LogInFrame login = new LogInFrame(this);
        login.setVisible(true);
        
    }//GEN-LAST:event_jButtonIniciarSesionActionPerformed
    /**
     * Configuracion del componentes que pertenecen al frame de origen
     */
    private void ProfileComponents(){
        ImageIcon imagen = new ImageIcon(getClass().getClassLoader().getResource("index.png"));
        jLabelImage.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(225, 225, Image.SCALE_SMOOTH)));
        if(this.estadoDB){
            JOptionPane.showMessageDialog(this, "No hay datos en el sistema debe cargarlos");
            cargaDatos();
        }
    }

    /**
     * 
     * @param token
     */
    public void AccesoDeUsuario(boolean token){
        this.setVisible(true);
    }
    private void comprobacionDB(){
        String consulta="SELECT * FROM TIENDA";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                this.estadoDB = false;
            }
        } catch (Exception e) {
        }
        finally{
            try {
                con.cerrarConexion();
            } catch (Exception e) {
            }
        }
    }
    private void cargaDatos(){
        JFileChooser cargaDeDatos = new JFileChooser();
        //Establece los tipos de archivos permitidos en el programa
        FileNameExtensionFilter filtroCarga=new FileNameExtensionFilter("TXT","txt");
        //Parametros de configuracion del filechooser par aceptar solamente archivo y de tipo txt
        cargaDeDatos.setFileSelectionMode(JFileChooser.FILES_ONLY);
        cargaDeDatos.setFileFilter(filtroCarga);
        
        int respuesta = cargaDeDatos.showOpenDialog(this);
        //Si se da aceptar en la ventana se hacen las intrucciones
        if(respuesta == JFileChooser.APPROVE_OPTION)
        {
            File ficheroSeleccionado = cargaDeDatos.getSelectedFile();
            //si el fichero es aceptado entonces se hacen las instruccuiones de carga
            if (ficheroSeleccionado.getName().endsWith("txt")){
                InputText entradaDeInformacion = new InputText();
                entradaDeInformacion.LecturaEIngreso(ficheroSeleccionado);
                //se muestran los errores de carga y donde sucedieron los mismos
                if(entradaDeInformacion.getErroresDeDatos().size()>0)
                {
                    VisualizadorDeErroresJDialog errores = new VisualizadorDeErroresJDialog(this, true, entradaDeInformacion.getErroresDeDatos());
                    errores.setVisible(true);
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Formato de archivo no soprtado");
            }
            
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIniciarSesion;
    private javax.swing.JButton jButtonRegistrarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelImage;
    // End of variables declaration//GEN-END:variables
}
