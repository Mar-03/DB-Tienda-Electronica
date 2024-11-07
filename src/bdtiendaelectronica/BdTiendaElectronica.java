/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bdtiendaelectronica;

import vistas.InterfazUsuario;



/**
 *
 * @author anyi4
 */
public class BdTiendaElectronica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InterfazUsuario interfazUsuario = new InterfazUsuario();
        
        interfazUsuario.leerDatos();

       

 System.out.println("-------------------------");
 
   interfazUsuario.actualizar();
     
 interfazUsuario.leerDatos();

      
    }
    
}
