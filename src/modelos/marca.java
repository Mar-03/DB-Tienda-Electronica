/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author anyi4
 */
public class marca {
    
    private int id_marca;
    private String tipo_marca;

    public marca() {
    }

    public marca(String tipo_marca) {
        this.tipo_marca = tipo_marca;
    }

    public marca(int id_marca, String tipo_marca) {
        this.id_marca = id_marca;
        this.tipo_marca = tipo_marca;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public String getTipo_marca() {
        return tipo_marca;
    }

    public void setTipo_marca(String tipo_marca) {
        this.tipo_marca = tipo_marca;
    }
    
    
}
