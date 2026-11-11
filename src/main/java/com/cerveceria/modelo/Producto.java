/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cerveceria.modelo;

/**
 *
 * @author EDUARDO RADA
 */
public class Producto {
    // Atributos privados (Encapsulamiento)
    private int idProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private double porcentajeAlcohol;
    private int volumenMl;
    private int stock;
    private int idCategoria;

    // Constructor vacío
    public Producto() {}

    // Constructor con parámetros
    public Producto(String nombre, String descripcion, double precio, double porcentajeAlcohol, int volumenMl, int stock, int idCategoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.porcentajeAlcohol = porcentajeAlcohol;
        this.volumenMl = volumenMl;
        this.stock = stock;
        this.idCategoria = idCategoria;
    }

    // Getters y Setters Necesarios para acceder a los datos
    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPorcentajeAlcohol() { return porcentajeAlcohol; }
    public void setPorcentajeAlcohol(double porcentajeAlcohol) { this.porcentajeAlcohol = porcentajeAlcohol; }

    public int getVolumenMl() { return volumenMl; }
    public void setVolumenMl(int volumenMl) { this.volumenMl = volumenMl; }

    public int getIdCategoria() { return idCategoria; }
    public void setIdCategoria(int idCategoria) { this.idCategoria = idCategoria; }
    
}
