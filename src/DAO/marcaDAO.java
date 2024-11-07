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
import modelos.categoria;
import modelos.marca;

/**
 *
 * @author anyi4
 */
public class marcaDAO {
      Connection conn = DBConnection.getConnection();
    public List<marca> getMaarca() {
        List<marca> marca = new ArrayList<>();
        
        String sql = "select * from marca";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs= stmt.executeQuery();
            while(rs.next()){
             int id_marca= rs.getInt("id_marca");
             String tipo_marca = rs.getString("tipo_marca");
            
              
             marca  marcas= new marca(id_marca, tipo_marca);
                
                marca.add(marcas);
            }
            
        } catch (Exception e) {
            System.out.println("ERROR EN GETMARCA");
        } return marca;
    }
    public void addmarca(String nombremarca) {
    
       
        String sql = "insert into marca(tipo_marca) values (?)";
        
        try {
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, nombremarca);
            
            stmt.executeUpdate();
            
            System.out.println("Marca AGREGADA");
            
        } catch (Exception e) {
            System.out.println("Error addmarca " + e.getMessage());
        }
    
}
public marca getOneMarca (int pIdMarca) {
        
        marca marc = new marca();
        
        String sql = "select * from marca where id_marca = ?";
        
        try {
            
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setInt(1, pIdMarca);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                
                int idmarca= rs.getInt("id_marca");
                String tipomarca = rs.getString("tipo_marca"); 
                
              marc.setId_marca(idmarca);
              marc.setTipo_marca(tipomarca);
              
            }

        } catch (Exception e) {
            System.out.println("Error getOneMarca: " + e.getMessage());
        }
        return marc;
      
        
    }
    
    // ACTUALIZAR UNA categoria
    public void updateMarca (int pIdMarca, String pTipoMarca) {
    
        String sql = "update especialidad set tipo_marca = ? where id_marca = ?";
        
        try {
            
            
            marca mar = this.getOneMarca(pIdMarca);
            
            if(mar.getId_marca() != 0) {
                
                PreparedStatement stmt = conn.prepareStatement(sql);
                
                stmt.setInt(1, pIdMarca);
                stmt.setString(2, pTipoMarca);
                
                stmt.executeUpdate();
            
                System.out.println("MARCA ACTUALIZADA");
                
            } else {
                
                System.out.println("LA MARCA A ACTUALIZAR NO EXISTE");
                
            }
            
        } catch (Exception e) {
            System.out.println("Error updateMarca: " + e.getMessage());
        }
        
    }
    
    }