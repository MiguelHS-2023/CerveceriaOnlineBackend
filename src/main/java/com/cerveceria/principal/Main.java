/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cerveceria.principal;

import com.cerveceria.dao.ProductoDAO;
import com.cerveceria.modelo.Producto;

/**
 *
 * @author EDUARDO RADA
 */
public class Main {
    public static void main(String[] args) {
        ProductoDAO dao = new ProductoDAO();

        // 1. Probar Inserción
        Producto nuevaCerveza = new Producto();
        nuevaCerveza.setNombre("Stout Imperial Negra");
        nuevaCerveza.setPrecio(85.00);
        nuevaCerveza.setStock(50);
        
        System.out.println("Guardando producto...");
        dao.registrarProducto(nuevaCerveza);

        // 2. Probar Consulta
        dao.listarProductos();

        // 3. Probar Actualización (Supongamos que el ID asignado fue el 1)
        System.out.println("Actualizando producto...");
        dao.actualizarInventario(1, 90.00, 45);
        
        //4. Probar Eliminación
        System.out.println("Eliminando producto...");
        dao.eliminarProducto(2);
        
        dao.listarProductos();
    }
}
