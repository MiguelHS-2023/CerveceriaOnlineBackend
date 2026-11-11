/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cerveceria.dao;

import com.cerveceria.conexion.ConexionDB;
import com.cerveceria.modelo.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author EDUARDO RADA
 */
public class ProductoDAO {
    // 1. INSERCIÓN (Create)
    public boolean registrarProducto(Producto prod) {
        String sql = "INSERT INTO productos (nombre, descripcion, precio, porcentaje_alcohol, volumen_ml, stock, id_categoria) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = ConexionDB.obtenerConexion(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setString(1, prod.getNombre());
            ps.setString(2, "Cerveza artesanal premium"); // prod.getDescripcion()
            ps.setDouble(3, prod.getPrecio());
            ps.setDouble(4, 5.5); // prod.getPorcentajeAlcohol()
            ps.setInt(5, 330); // prod.getVolumenMl()
            ps.setInt(6, prod.getStock());
            ps.setInt(7, 1); // idCategoria por defecto

            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al registrar: " + e.getMessage());
            return false;
        }
    }

    // 2. CONSULTA (Read)
    public void listarProductos() {
        String sql = "SELECT * FROM productos";
        try (Connection con = ConexionDB.obtenerConexion(); 
             PreparedStatement ps = con.prepareStatement(sql); 
             ResultSet rs = ps.executeQuery()) {
             
            System.out.println("--- CATÁLOGO DE CERVEZAS ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id_producto") + 
                                   " | Cerveza: " + rs.getString("nombre") + 
                                   " | Precio: $" + rs.getDouble("precio") +
                                   " | Stock: " + rs.getInt("stock"));
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar: " + e.getMessage());
        }
    }

    // 3. ACTUALIZACIÓN (Update - Actualizar precio y stock)
    public boolean actualizarInventario(int id, double nuevoPrecio, int nuevoStock) {
        String sql = "UPDATE productos SET precio = ?, stock = ? WHERE id_producto = ?";
        try (Connection con = ConexionDB.obtenerConexion(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setDouble(1, nuevoPrecio);
            ps.setInt(2, nuevoStock);
            ps.setInt(3, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al actualizar: " + e.getMessage());
            return false;
        }
    }

    // 4. ELIMINACIÓN (Delete)
    public boolean eliminarProducto(int id) {
        String sql = "DELETE FROM productos WHERE id_producto = ?";
        try (Connection con = ConexionDB.obtenerConexion(); 
             PreparedStatement ps = con.prepareStatement(sql)) {
             
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }
}
