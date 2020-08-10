package com.carlos.App;

import java.sql.SQLException;

import com.carlos.DBSuport.ConexionDB;

/**
 * Hello world!
 *
 */
public class Main {
    public static void main(String[] args) throws SQLException
    {
        //InputText prueba1 = new InputText();
        //prueba1.LecturaEIngreso();
        //PrincipalFrame frame = new PrincipalFrame("Bienvenido");
        ConexionDB conecionBaseDatos = new ConexionDB();
        System.out.println(conecionBaseDatos.conectarMySQL());
        try {
            conecionBaseDatos.cerrar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
