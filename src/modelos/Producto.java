/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author anyi4
 */
public class Producto {
    private int id_productos;
    private String nombre_producto;
    private Double precio;
    private Double cantidad;
    private int id_categoria;
    private int id_marca;

    public Producto() {
    }

    public Producto(String nombre_producto, Double precio, Double cantidad, int id_categoria, int id_marca) {
        this.nombre_producto = nombre_producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.id_categoria = id_categoria;
        this.id_marca = id_marca;
    }

    public Producto(int id_productos, String nombre_producto, Double precio, Double cantidad, int id_categoria, int id_marca) {
        this.id_productos = id_productos;
        this.nombre_producto = nombre_producto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.id_categoria = id_categoria;
        this.id_marca = id_marca;
    }

    public int getId_productos() {
        return id_productos;
    }

    public void setId_productos(int id_productos) {
        this.id_productos = id_productos;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }
    
}
