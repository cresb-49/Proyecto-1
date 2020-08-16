/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carlos.Graphics;
import com.carlos.Graphics.*;
import com.carlos.TraslateDB.InputText;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author Carlos Pac
 */
public class TiendaEmpleadoJFrame extends javax.swing.JFrame {

    /**
     * Creates new form TiendaEmpleadoJFrame
     */
    public TiendaEmpleadoJFrame() {
        super("Mi Empresa");
        initComponents();
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

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemRegistroTienda = new javax.swing.JMenuItem();
        jMenuItemRegistroProductos = new javax.swing.JMenuItem();
        jMenuItemRegistroCliente = new javax.swing.JMenuItem();
        jMenuItemRegistroEmpleado = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemCatalogo = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItemTransaccion = new javax.swing.JMenuItem();
        jMenuRealizarPedido = new javax.swing.JMenu();
        jMenuItemRealizarPedido = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuReportes = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemImportasBaseDeDatos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Registro");

        jMenuItemRegistroTienda.setText("Tienda");
        jMenuItemRegistroTienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRegistroTiendaActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemRegistroTienda);

        jMenuItemRegistroProductos.setText("Productos");
        jMenuItemRegistroProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRegistroProductosActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemRegistroProductos);

        jMenuItemRegistroCliente.setText("Cliente");
        jMenuItemRegistroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRegistroClienteActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemRegistroCliente);

        jMenuItemRegistroEmpleado.setText("Empleado");
        jMenuItemRegistroEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRegistroEmpleadoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemRegistroEmpleado);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Productos");

        jMenuItemCatalogo.setText("Catalogo");
        jMenuItemCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCatalogoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemCatalogo);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Ventas");

        jMenuItemTransaccion.setText("Transaccion");
        jMenuItemTransaccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemTransaccionActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemTransaccion);

        jMenuBar1.add(jMenu4);

        jMenuRealizarPedido.setText("Pedidos");

        jMenuItemRealizarPedido.setText("Realizar Pedido");
        jMenuItemRealizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRealizarPedidoActionPerformed(evt);
            }
        });
        jMenuRealizarPedido.add(jMenuItemRealizarPedido);

        jMenuItem1.setText("Acciones dePedido");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenuRealizarPedido.add(jMenuItem1);

        jMenuBar1.add(jMenuRealizarPedido);

        jMenuReportes.setText("Reportes");

        jMenuItem2.setText("Exportar Reportes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenuReportes.add(jMenuItem2);

        jMenuBar1.add(jMenuReportes);

        jMenu3.setText("Cargar Datos");

        jMenuItemImportasBaseDeDatos.setText("Importar Base De Datos");
        jMenuItemImportasBaseDeDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemImportasBaseDeDatosActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemImportasBaseDeDatos);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 613, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 326, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemRegistroTiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRegistroTiendaActionPerformed
        // TODO add your handling code here:
        RegistroTiendaJDialog tiendaNueva = new RegistroTiendaJDialog(this, true);
        tiendaNueva.setVisible(true);
    }//GEN-LAST:event_jMenuItemRegistroTiendaActionPerformed

    private void jMenuItemRegistroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRegistroClienteActionPerformed
        // TODO add your handling code here:
        RegistroClienteJDialog cliente = new RegistroClienteJDialog(this, true);
        cliente.setVisible(true);
    }//GEN-LAST:event_jMenuItemRegistroClienteActionPerformed

    private void jMenuItemRegistroEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRegistroEmpleadoActionPerformed
        // TODO add your handling code here:
        RegistroEmpleadoJDialog empleado = new RegistroEmpleadoJDialog(this, true);
        empleado.setVisible(true);
    }//GEN-LAST:event_jMenuItemRegistroEmpleadoActionPerformed

    private void jMenuItemTransaccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTransaccionActionPerformed
        // TODO add your handling code here:
        VentaJDialog ventaProducto = new VentaJDialog(this, true);
        ventaProducto.setLocationRelativeTo(null);
        ventaProducto.setVisible(true);
    }//GEN-LAST:event_jMenuItemTransaccionActionPerformed

    private void jMenuItemRegistroProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRegistroProductosActionPerformed
        // TODO add your handling code here:
        RegistrarProductoJDialog productoNuevo = new RegistrarProductoJDialog(this, true);
        productoNuevo.setVisible(true);
    }//GEN-LAST:event_jMenuItemRegistroProductosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItemRealizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRealizarPedidoActionPerformed
        // TODO add your handling code here:
        RealizarPedidoJDialog pedidoNuevo = new RealizarPedidoJDialog(this, true);
        pedidoNuevo.setVisible(true);
        
    }//GEN-LAST:event_jMenuItemRealizarPedidoActionPerformed

    private void jMenuItemImportasBaseDeDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemImportasBaseDeDatosActionPerformed
        // TODO add your handling code here:
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
    }//GEN-LAST:event_jMenuItemImportasBaseDeDatosActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        CaracteristicaReportesJDialog reportes = new CaracteristicaReportesJDialog(this, true);
        reportes.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItemCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCatalogoActionPerformed
        // TODO add your handling code here:
        CatalogoJDialog catalogoProductos = new CatalogoJDialog(this, true);
        catalogoProductos.setVisible(true);
    }//GEN-LAST:event_jMenuItemCatalogoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemCatalogo;
    private javax.swing.JMenuItem jMenuItemImportasBaseDeDatos;
    private javax.swing.JMenuItem jMenuItemRealizarPedido;
    private javax.swing.JMenuItem jMenuItemRegistroCliente;
    private javax.swing.JMenuItem jMenuItemRegistroEmpleado;
    private javax.swing.JMenuItem jMenuItemRegistroProductos;
    private javax.swing.JMenuItem jMenuItemRegistroTienda;
    private javax.swing.JMenuItem jMenuItemTransaccion;
    private javax.swing.JMenu jMenuRealizarPedido;
    private javax.swing.JMenu jMenuReportes;
    // End of variables declaration//GEN-END:variables
}
