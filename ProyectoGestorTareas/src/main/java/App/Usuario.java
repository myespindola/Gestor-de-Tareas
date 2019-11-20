/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author marco
 */
public class Usuario implements Serializable{
    private String id;
    private String nombre;
    private List<Tarea> tareas=new ArrayList<>();
    private String puesto;
    private String usuario;
    private String password;
    public Usuario(String id,String nombre,String puesto, String usuario, String password){
        setId(id);
        setNombre(nombre);
        setPuesto(puesto);
        setUsuario(usuario);
        setPassword(password);
    }
    public String getId(){
        return id;
    }
    public Tarea getTarea(int i){
        return tareas.get(i);
    }
    public String getNombre(){
        return nombre;
    }
    public String getPuesto(){
        return puesto;
    }
    public String getUsuario(){
        return usuario;
    }
    public String getPassword(){
        return password;
    }
    public List<Tarea> getTareas(){
        return tareas;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setId(String id){
        this.id=id;
    }
    public void setPuesto(String puesto){
        this.puesto=puesto;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public void setUsuario(String usuario){
        this.usuario=usuario;
    }
    public void setEstado(int i,int estado){
        tareas.get(i).setEstado(estado);
    }
    public void setTarea(Tarea tarea){
        tareas.add(tarea);
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", tareas=" + tareas + ", puesto=" + puesto + ", usuario=" + usuario + ", password=" + password + '}';
    }
    
    
}
