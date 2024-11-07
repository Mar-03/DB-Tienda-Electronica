/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bdtiendaelectronica;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author anyi4
 */
public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/tienda_electronica?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "umg$123456";
    
     public static Connection getConnection(){
     Connection conn = null;
         try {
             conn = DriverManager.getConnection(URL, USER, PASSWORD);
             System.out.println("CONEXION EXITOSA");
         } catch (Exception e) {
             System.out.println("Error en la conexión de BD: " + e.getMessage());
         } return conn;
     }
}
