/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;
import java.io.Serializable;
/**
 *
 * @author marco
 */
public class Tarea implements Serializable{
    private String nombre;
    private int estado;
    private String descripcion;
    public Tarea(String nombre, String descripcion){
        this.nombre=nombre;
        this.descripcion=descripcion; 
        int estado=0;
    }
    public String getNombre(){
        return nombre;
    }
    public int getEstado(){
        return estado;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setEstado(int estado){
        this.estado=estado;
    }
    public void setDescripcion(String describcion){
        this.descripcion=describcion;
    }
    public String toString() {
        return "Tarea{" + "nombre=" + nombre + ", estado=" + estado + ", describcion=" + descripcion + '}';
    }
    
}
