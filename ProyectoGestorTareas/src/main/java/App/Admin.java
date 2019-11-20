/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;
import java.io.Serializable;
import java.io.*;
import java.util.*;


/**
 *
 * @author marco
 */
public class Admin extends Usuario{
    public Admin(String id,String nombre,String puesto, String usuario, String password){
        super(id, nombre, puesto, usuario, password);
        System.out.println("nuevo admin");
        this.crearAdmin(this);
    }
    public boolean asignarTarea(Tarea tarea, int i){
        List<Usuario> users=getUsuarios();
        File usuarios=new File("usuarios.txt");
        for(Tarea tempTarea:users.get(i).getTareas()){
            if(tempTarea.getNombre().equals(tarea.getNombre())){
                return false;
            }
        }
        users.get(i).setTarea(tarea);
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(usuarios)))) {
             for(Usuario user: users)
                out.writeObject(user);
             return true;
             
        }catch(IOException e){
            return false;
        }
    }
    public boolean crearUsuario(Usuario usuario){
        List<Usuario> users=getUsuarios();
        File usuarios=new File("usuarios.txt");
        for(Usuario user:users){
            if(user.getId().equals(usuario.getId())){
                return false;
            }
        }
        users.add(usuario);
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(usuarios)))) {
             for(Usuario user: users){
                out.writeObject(user);
             }
             return true;
             
        }catch(IOException e){
            return false;
        }
    }
    public boolean crearAdmin(Admin admin){
        List<Usuario> users=getUsuarios();
        File usuarios=new File("usuarios.txt");
        for(Usuario user:users){
            if(user.getId().equals(admin.getId())){
                return false;
            }
        }
        users.add(admin);
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(usuarios)))) {
             for(Usuario user: users){
                out.writeObject(user);
             }
             return true;
             
        }catch(IOException e){
            return false;
        }
    }
    public boolean modificarUsuario(int i,Usuario usuario){
        List<Usuario> users=getUsuarios();
        File usuarios=new File("usuarios.txt");
        users.set(i,usuario);
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(usuarios)))) {
             for(Usuario user: users){
                out.writeObject(user);
             }
             return true;
             
        }catch(IOException e){
            return false;
        }
    }
    public void eliminarUsuario(int i){
        File usuarios=new File("usuarios.txt");
        List<Usuario> users=getUsuarios();
        users.remove(i);
        try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(usuarios)))) {
            for(Usuario usuario:users)
             out.writeObject(usuario);
        }catch(IOException e){
            
        }
    }
    
    public List<Usuario> getUsuarios(){
        File usuarios=new File("usuarios.txt");
        List<Usuario> users = new ArrayList<Usuario>();
        try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(usuarios)))) {
            while(true) {
                Object object = in.readObject();
                if(object instanceof Usuario)
                    users.add((Usuario)object);
           }
       }catch (Exception e) {
       // File end reached
       }
        return users;
    }
    public int indexOfUsuarios(Usuario usuario){
        int i=0;
        File usuarios=new File("usuarios.txt");
        List<Usuario> users =getUsuarios();
        for(Usuario user:users){
            if(user.getId().equals(usuario.getId())){
                return i;
            }
            i++;
        }
        return -1;
    }
}
