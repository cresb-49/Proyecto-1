package com.carlos.DBSuport;

import java.sql.*;
import java.util.ArrayList;

public class ConsultasDB {

    private ConexionDB con = new ConexionDB();
    private Connection cn;
    private Statement st;
    private ResultSet rs;
    /**
     * CONSTRUCTOR VACIO DE LA CLASE
     */
    public ConsultasDB(){
        try {
            con = new ConexionDB();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public int consultaUsuarios(String nombre,String codeNIT){
        int respuesta = 0;
        String consulta = "SELECT nombre,nit FROM CLIENTE WHERE nit = '"+codeNIT+"' AND nombre = '"+nombre+"'";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                respuesta=1;
            }
        } catch (Exception e) {
        }
        String consulta2 = "SELECT nombre,codigo FROM EMPLEADO WHERE codigo = '"+codeNIT+"' AND nombre = '"+nombre+"'";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta2);
            while(rs.next()){
                respuesta=2;
            }
        } catch (Exception e) {
        }
        return respuesta;
    }
    public ArrayList<String> consultaDeTiendas(){
        ArrayList<String> tiendasDisponibles = new ArrayList<String>();
        String consulta="SELECT nombre FROM TIENDA";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                tiendasDisponibles.add(rs.getString("nombre"));
            }
        } catch (Exception e) {
        }
        return tiendasDisponibles;
    }
    
    public ArrayList<String> datosCliente(String nit){
        ArrayList<String> cliente = new ArrayList<String>();
        String consulta="SELECT nombre,telefono,credito,dpi,email,direccion FROM CLIENTE WHERE nit = '"+nit+"'";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                cliente.add(rs.getString(1));
                cliente.add(rs.getString(2));
                cliente.add(rs.getString(3));
                cliente.add(rs.getString(4));
                cliente.add(rs.getString(5));
                cliente.add(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return cliente;
    }
    public ArrayList<String> datosEmpleado(String codigo){
        ArrayList<String> cliente = new ArrayList<String>();
        String consulta="SELECT nombre,telefono,dpi,nit,email,direccion FROM EMPLEADO WHERE codigo = '"+codigo+"'";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                cliente.add(rs.getString(1));
                cliente.add(rs.getString(2));
                cliente.add(rs.getString(3));
                cliente.add(rs.getString(4));
                cliente.add(rs.getString(5));
                cliente.add(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return cliente;
    }
    public ArrayList<String> datosTienda(String codigo){
        ArrayList<String> cliente = new ArrayList<String>();
        String consulta="SELECT nombre,direccion,telefono_1,telefono_2,email,horario FROM TIENDA WHERE codigo = '"+codigo+"'";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                cliente.add(rs.getString(1));
                cliente.add(rs.getString(2));
                cliente.add(rs.getString(3));
                cliente.add(rs.getString(4));
                cliente.add(rs.getString(5));
                cliente.add(rs.getString(6));
            }
        } catch (Exception e) {
        }
        return cliente;
    }
    public String codigoTienda(String nombre){
        String cliente ="";
        String consulta="SELECT codigo FROM TIENDA WHERE nombre = '"+nombre+"'";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                cliente = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return cliente;
    }
    
    public ArrayList<String> tiempoEntreTiendas(String codigoTienda1,String codigoTienda2){
        ArrayList<String> tiempo = new ArrayList<String>();
        String consulta="SELECT tiempo,codigo FROM TIEMPO_TRASLADO WHERE TIENDA_codigo1 = '"+codigoTienda1+"' AND TIENDA_codigo2 = '"+codigoTienda2+"'";
        try {
            cn = con.getConexion();
            st = cn.createStatement();
            rs=st.executeQuery(consulta);
            while(rs.next()){
                tiempo.add(rs.getString(1));
                tiempo.add(rs.getString(2));
            }
        } catch (Exception e) {
        }
        return tiempo;
    }
}