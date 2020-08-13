package com.carlos.DBSuport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.carlos.Entities.Client;


public class RegistroDB {
    //VARIABLES DE CONEXION A BASE DE DATOS
    ConexionDB con = new ConexionDB();
    Connection cn;
    Statement st;
    ResultSet rs;

    public RegistroDB(){

    }
    public void  registroCliente(Client cliente){
        //Declaracion de variables para insertar valores de la consulta 
        String nit;
        Strign nombre;
        String telefono;
        int credito;
        String dpi;
        String email;
        String direccion;
        //Asignacion de los datos de la variables
        nit=cliente.getNit();
        nombre=cliente.getName();
        telefono = String.valueOf(cliente.getPhoneNumber());
        credito = cliente.getCreditoCompra();
        dpi = String.valueOf(cliente.getDpi());
        email = cliente.getEmail();
        direccion = cliente.getDirection();
        //declaracion de la consulta
        String consulta="INSERT INTO CLIENTE (nit.nombre,telefono,credito,dpi,email,direccion) VALUES ('"+nit+"','"+nombre+"','"+telefono+"','"+credito+"','"+dpi+"','"+email+"','"+direccion+"') ";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
        } catch (Exception e) {
        }
        finally{
            try {
                con.cerrar();
            } catch (Exception e) {
            }
        }
    }
    public void registroTienda(){

    }
    public void registroEmpleado(){

    }
    public void registroProducto(){
        
    }
}