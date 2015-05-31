package entity;
// Generated 30/05/2015 08:07:22 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Accion generated by hbm2java
 */
public class Accion  implements java.io.Serializable {


     private int id;
     private Accion accion;
     private String nombre;
     private Set accions = new HashSet(0);
     private Set perfils = new HashSet(0);

    public Accion() {
    }

	
    public Accion(int id) {
        this.id = id;
    }
    public Accion(int id, Accion accion, String nombre, Set accions, Set perfils) {
       this.id = id;
       this.accion = accion;
       this.nombre = nombre;
       this.accions = accions;
       this.perfils = perfils;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Accion getAccion() {
        return this.accion;
    }
    
    public void setAccion(Accion accion) {
        this.accion = accion;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getAccions() {
        return this.accions;
    }
    
    public void setAccions(Set accions) {
        this.accions = accions;
    }
    public Set getPerfils() {
        return this.perfils;
    }
    
    public void setPerfils(Set perfils) {
        this.perfils = perfils;
    }




}


