/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cerveceria.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author EDUARDO RADA
 */
public class ConexionDB {
    // Variables de configuración
    private static final String URL = "jdbc:mysql://localhost:3306/ecommerce_cervezas";
    private static final String USUARIO = "root"; // usuario de MySQL
    private static final String CLAVE = "Miguel_mysql"; // contraseña de MySQL

    // Método para obtener la conexión
    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            // Registrar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("¡Éxito! Conectado a la base de datos de la Cervecería.");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
        return conexion;
    }
}
