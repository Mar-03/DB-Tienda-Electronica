/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import bdtiendaelectronica.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelos.Producto;
import modelos.categoria;

/**
 *
 * @author anyi4
 */
public class categoriaDAO {
    Connection conn = DBConnection.getConnection();
    public List<categoria> getCategoria() {
        List<categoria> categoria = new ArrayList<>();
        
        String sql = "select * from categoria";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs= stmt.executeQuery();
            while(rs.next()){
             int id_categoria= rs.getInt("id_categoria");
             String nombre_categoria = rs.getString("nombre_categoria");
            
              
             categoria  categorias= new categoria(id_categoria, nombre_categoria);
                
                categoria.add(categorias);
            }
            
        } catch (Exception e) {
            System.out.println("ERROR EN GETCategoria");
        } return categoria;
    }
     public void addcategoria(String nombre_categoria) {
    
       
        String sql = "insert into categoria (nombre_categoria) values (?)";
        
        try {
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, nombre_categoria);
            
            stmt.executeUpdate();
            
            System.out.println("Categoria AGREGADA");
            
        } catch (Exception e) {
            System.out.println("Error addCategoria: " + e.getMessage());
        }}
         // OBTENER UNA categoria SEGÚN UN PARÁMETRO
   public categoria getOneCategoria (int pIdcategoria) {
        
        categoria categoria = new categoria();
        
        String sql = "select * from categoria where id_categoria = ?";
        
        try {
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, pIdcategoria);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                
                int idCategoria= rs.getInt("id_categoria");
                String nombreCategoria = rs.getString("nombre_categoria"); 
                
                categoria.setId_categoria(pIdcategoria);
               categoria.setNombre_categoria(nombreCategoria);
            }

        } catch (Exception e) {
            System.out.println("Error getOneEspecialidad: " + e.getMessage());
        }
        
        return categoria;
        
    }
    
    // ACTUALIZAR UNA categoria
    public void updateCategoria(int pIdCategoria, String pNombrecategoria) {
    
        String sql = "update especialidad set nombre_categoria = ? where id_categoria = ?";
        
        try {
            
            // BUSCAR LA ESPECIALIDAD
            categoria categoriaDB = this.getOneCategoria(pIdCategoria);
            
            if(categoriaDB.getId_categoria() != 0) {
                
                PreparedStatement stmt = conn.prepareStatement(sql);
                
                stmt.setInt(1, pIdCategoria);
                stmt.setString(2, pNombrecategoria);
                
                stmt.executeUpdate();
            
                System.out.println("CATEGORIA ACTUALIZADA");
                
            } else {
                
                System.out.println("LA CATEGORIA  A ACTUALIZAR NO EXISTE");
                
            }
            
        } catch (Exception e) {
            System.out.println("Error updateCateogira: " + e.getMessage());
        }
        
    }
    
    }

