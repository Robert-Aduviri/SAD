package entity;
// Generated Jun 3, 2015 6:36:49 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Ubicacion generated by hbm2java
 */
public class Ubicacion  implements java.io.Serializable {


     private Integer id;
     private Rack rack;
     private Integer fila;
     private Integer columna;
     private String lado;
     private Integer estado;
     private Set pallets = new HashSet(0);

    public Ubicacion() {
    }

	
    public Ubicacion(Rack rack) {
        this.rack = rack;
    }
    public Ubicacion(Rack rack, Integer fila, Integer columna, String lado, Integer estado, Set pallets) {
       this.rack = rack;
       this.fila = fila;
       this.columna = columna;
       this.lado = lado;
       this.estado = estado;
       this.pallets = pallets;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Rack getRack() {
        return this.rack;
    }
    
    public void setRack(Rack rack) {
        this.rack = rack;
    }
    public Integer getFila() {
        return this.fila;
    }
    
    public void setFila(Integer fila) {
        this.fila = fila;
    }
    public Integer getColumna() {
        return this.columna;
    }
    
    public void setColumna(Integer columna) {
        this.columna = columna;
    }
    public String getLado() {
        return this.lado;
    }
    
    public void setLado(String lado) {
        this.lado = lado;
    }
    public Integer getEstado() {
        return this.estado;
    }
    
    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    public Set getPallets() {
        return this.pallets;
    }
    
    public void setPallets(Set pallets) {
        this.pallets = pallets;
    }




}


