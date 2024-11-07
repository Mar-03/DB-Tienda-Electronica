/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import bdtiendaelectronica.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelos.Producto;

/**
 *
 * @author anyi4
 */
public class ProductoDAO {
    Connection conn = DBConnection.getConnection();
    public List<Producto> getProducto() {
        List<Producto> productos = new ArrayList<>();
        
        String sql = "select * from producto";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs= stmt.executeQuery();
            while(rs.next()){
             int id_productos = rs.getInt("id_productos");
             String nombre_producto = rs.getString("nombre_producto");
              Double precio= rs.getDouble("precio");
              Double cantidad = rs.getDouble("cantidad");
              int id_categoria = rs.getInt("id_categoria");
              int id_marca = rs.getInt("id_marca");
              
            Producto producto = new Producto(id_productos, nombre_producto, precio, cantidad, id_categoria, id_marca);
                
                productos.add(producto);
            }
            
        } catch (Exception e) {
            System.out.println("ERROR EN GETPRODUCTOS");
        } return productos;
    }
     public void addPRODUCTO(String nombreProducto, double precio, int cantidad, int idCategoria, int idMarca) {
    
    String sql = "INSERT INTO producto (nombre_producto, precio, cantidad, id_categoria, id_marca) VALUES (?, ?, ?, ?, ?)";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, nombreProducto);
        stmt.setDouble(2, precio);
        stmt.setInt(3, cantidad);
        stmt.setInt(4, idCategoria);
        stmt.setInt(5, idMarca);
        int rowsInserted = stmt.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Producto agregado");
        } else {
            System.out.println("No se pudo agregar el producto");
        }
    } catch (SQLException e) {
        System.out.println("Error en addProducto: " + e.getMessage());
    
}

        
    }
     // Ler producto 
     public Producto getOneProducto(int pIdProducto) {
    Producto producto = new Producto();
    
    String sql = "SELECT * FROM producto WHERE id_productos = ?";
    
    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, pIdProducto);
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            int idProducto = rs.getInt("id_productos");
            String nombreProducto = rs.getString("nombre_producto");
            double precio = rs.getDouble("precio");
            double  cantidad = rs.getInt("cantidad");
            int idCategoria = rs.getInt("id_categoria");
            int idMarca = rs.getInt("id_marca");
            
            producto.setId_productos(idProducto);
            producto.setNombre_producto(nombreProducto);
            producto.setPrecio(precio);
            producto.setCantidad(cantidad);
            producto.setId_categoria(idCategoria);
            producto.setId_marca(idMarca);
        }
    } catch (Exception e) {
        System.out.println("Error getOneProducto: " + e.getMessage());
    }
    
    return producto;
}
public void updateProducto(int pIdProducto, String nombreProducto, double precio, int cantidad) {
    String sql = "UPDATE producto SET nombre_producto = ?, precio = ?, cantidad = ? WHERE id_productos = ?";
    
    try {
        // BUSCAR EL PRODUCTO
        Producto productoDB = this.getOneProducto(pIdProducto);
        
        if (productoDB.getId_productos() != 0) {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nombreProducto);
            stmt.setDouble(2, precio);
            stmt.setInt(3, cantidad);
            stmt.setInt(4, pIdProducto);
            
            stmt.executeUpdate();
            
            System.out.println("PRODUCTO ACTUALIZADO");
        } else {
            System.out.println("EL PRODUCTO A ACTUALIZAR NO EXISTE");
        }
    } catch (Exception e) {
        System.out.println("Error updateProducto: " + e.getMessage());
    }
}

}
