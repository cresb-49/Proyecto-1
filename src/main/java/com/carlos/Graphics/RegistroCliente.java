/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.Graphics;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author benjamin
 */
public class RegistroCliente extends javax.swing.JFrame {

    /**
     * Creates new form RegistroCliente
     */
    private PrincipalFrame principal;
    public RegistroCliente(PrincipalFrame principal) {
        super("Registro");
        this.principal=principal;
        initComponents();
        ProfileComponents();
        this.setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jFormattedTextFieldNombre = new javax.swing.JFormattedTextField();
        jFormattedTextFieldNIT = new javax.swing.JFormattedTextField();
        jFormattedTextFieldTelefono = new javax.swing.JFormattedTextField();
        jFormattedTextFieldEmail = new javax.swing.JFormattedTextField();
        jFormattedTextFieldDirecion = new javax.swing.JFormattedTextField();
        jFormattedTextFieldDPI = new javax.swing.JFormattedTextField();
        jButtonRegresar = new javax.swing.JButton();
        jButtonRegistrar = new javax.swing.JButton();
        jLabelImagen = new javax.swing.JLabel();

        jFormattedTextField3.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Nombre: ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(12, 20, 64, 18);

        jLabel2.setText("Telefono: ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(12, 67, 71, 18);

        jLabel3.setText("NIT:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(12, 114, 27, 18);

        jLabel4.setText("DPI:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(12, 162, 60, 18);

        jLabel5.setText("Correo Electronico:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(12, 209, 136, 18);

        jLabel6.setText("Dirección:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(12, 256, 70, 18);
        getContentPane().add(jFormattedTextFieldNombre);
        jFormattedTextFieldNombre.setBounds(160, 12, 250, 35);
        getContentPane().add(jFormattedTextFieldNIT);
        jFormattedTextFieldNIT.setBounds(160, 106, 250, 35);
        getContentPane().add(jFormattedTextFieldTelefono);
        jFormattedTextFieldTelefono.setBounds(160, 60, 250, 35);
        getContentPane().add(jFormattedTextFieldEmail);
        jFormattedTextFieldEmail.setBounds(160, 201, 250, 35);
        getContentPane().add(jFormattedTextFieldDirecion);
        jFormattedTextFieldDirecion.setBounds(160, 248, 250, 35);
        getContentPane().add(jFormattedTextFieldDPI);
        jFormattedTextFieldDPI.setBounds(160, 154, 250, 35);

        jButtonRegresar.setText("Regresar");
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonRegresar);
        jButtonRegresar.setBounds(465, 232, 104, 28);

        jButtonRegistrar.setText("Registrar");
        getContentPane().add(jButtonRegistrar);
        jButtonRegistrar.setBounds(465, 192, 104, 28);
        getContentPane().add(jLabelImagen);
        jLabelImagen.setBounds(450, 30, 130, 130);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        // TODO add your handling code here:
        this.principal.AccesoDeUsuario(false);
        this.dispose();
    }//GEN-LAST:event_jButtonRegresarActionPerformed

    private void ProfileComponents(){
        this.setBounds(0,0,628, 336);
        ImageIcon imagen = new ImageIcon(getClass().getClassLoader().getResource("index.png"));
        jLabelImagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(152, 152, Image.SCALE_SMOOTH)));
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JFormattedTextField jFormattedTextField3;
    private javax.swing.JFormattedTextField jFormattedTextFieldDPI;
    private javax.swing.JFormattedTextField jFormattedTextFieldDirecion;
    private javax.swing.JFormattedTextField jFormattedTextFieldEmail;
    private javax.swing.JFormattedTextField jFormattedTextFieldNIT;
    private javax.swing.JFormattedTextField jFormattedTextFieldNombre;
    private javax.swing.JFormattedTextField jFormattedTextFieldTelefono;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelImagen;
    // End of variables declaration//GEN-END:variables
}
