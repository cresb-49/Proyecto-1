package com.carlos.DBSuport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    // Librería de MySQL
    private String driver = "com.mysql.jdbc.Driver";
    // Nombre de la base de datos
    private String database = "mi_empresa_proyecto1";
    // Host
    private String hostname = "localhost";
    // Puerto
    private String port = "3306";
    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    private String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
    // Nombre de usuario
    private String username = "root";
    // Clave de usuario
    private String password = "201931012";
    // conencion de base de datos
    private static Connection conexion = null;

    /**
     * Constructor principal de la clase conexion
     * Genera la conexion de la base de datos al principio
     */
    public ConexionDB() {
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Retorna la conexion de la base de datos
     * @return
     */
    public static Connection getConexion() {
        return conexion;
    }

    public static void cerrar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
    
}