/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vistas;

import DAO.ProductoDAO;
import DAO.categoriaDAO;
import DAO.marcaDAO;
import java.util.List;
import java.util.Scanner;
import modelos.Producto;
import modelos.categoria;
import modelos.marca;


/**
 *
 * @author anyi4
 */
public class InterfazUsuario {
    ProductoDAO pr = new ProductoDAO() ;
    categoriaDAO CR = new categoriaDAO();
    marcaDAO mr= new marcaDAO();
    Scanner scanner = new Scanner(System.in);
    
    public void leerDatos() {
        
        List<Producto> productos = pr.getProducto();
        List <categoria> categorias = CR.getCategoria();
        List <marca>marcas = mr.getMaarca();
        System.out.println("Lista de productos ");
        for(Producto e: productos) {
            System.out.println(e.getId_productos() + " - " + e.getNombre_producto() + " - " + e.getPrecio() 
                    + " - " + e.getCantidad() + " - " + e.getId_categoria() + " - " + e.getId_marca()
            );}
        System.out.println("Lista de categorias ");

            for(categoria e: categorias){
            System.out.println(e.getId_categoria()+ "-"+ e.getNombre_categoria());
            
        }
            System.out.println("Lista de marcas ");

            for(marca e: marcas){
                    System.out.println(e.getId_marca()+"-"+ e.getTipo_marca());
            
            }
        
    }
     public void agregarCategoria(){
           System.out.println("INGRESE NOMBRE CATEGORIA");
   String nombre_categoria = scanner.next();
      CR.addcategoria(nombre_categoria);
     }
     public void agregarMarca(){
      System.out.println("Ingrese nombre marca");
      String tipo_marca = scanner.next();
      mr.addmarca(tipo_marca);
     }
  public void agregarProducto() {
     
     
   System.out.println("INGRESE EL NOMBRE DEL PRODUCTO");
    String nombreProducto = scanner.next();
    System.out.println("INGRESE EL PRECIO DEL PRODUCTO");
    double precio = scanner.nextDouble();
    System.out.println("INGRESE LA CANTIDAD DEL PRODUCTO");
    int cantidad = scanner.nextInt();
    System.out.println("INGRESE EL ID DE LA CATEGORIA");
    int idCategoria = scanner.nextInt();
    System.out.println("INGRESE EL ID DE LA MARCA");
    int idMarca = scanner.nextInt();
    pr.addPRODUCTO(nombreProducto, precio, cantidad, idCategoria, idMarca);
    

    }
    
    public void leerUnDato() {
        
        System.out.println("INGRESE EL ID A CONSULTAR");
        
        int pIdproducto = scanner.nextInt();
         Producto producto= pr.getOneProducto(pIdproducto);
        
        if(producto.getId_productos() == 0) {
            System.out.println("NO SE ENCONTRARON DATOS PARA EL ID: " + pIdproducto);
        } else 
            System.out.println(producto.getId_productos() + " - " + producto.getNombre_producto() + " - " + producto.getPrecio()
                    + " - " + producto.getCantidad() + " - " + producto.getId_categoria() + " - " + producto.getId_marca());
        }
    
    
    
    public void actualizar() {
    
        System.out.println("INGRESE EL ID A ACTUALIZAR");
        
        int pIdProductos = scanner.nextInt();
        
        System.out.println("INGRESE EL NUEVO NOMBRE DEl Producto ");
        
        String pNombreProducto = scanner.next();
        pr.updateProducto(pIdProductos, pNombreProducto, pIdProductos, pIdProductos);
        
    }

}