package entity;
// Generated 24-May-2015 11:46:56 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Perfil generated by hbm2java
 */
public class Perfil  implements java.io.Serializable {


     private Integer idPerfil;
     private String nombrePerfil;
     private String descripcion;
     private Set usuarios = new HashSet(0);
     private Set accions = new HashSet(0);

    public Perfil() {
    }

    public Perfil(String nombrePerfil, String descripcion, Set usuarios, Set accions) {
       this.nombrePerfil = nombrePerfil;
       this.descripcion = descripcion;
       this.usuarios = usuarios;
       this.accions = accions;
    }
   
    public Integer getIdPerfil() {
        return this.idPerfil;
    }
    
    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }
    public String getNombrePerfil() {
        return this.nombrePerfil;
    }
    
    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }
    public Set getAccions() {
        return this.accions;
    }
    
    public void setAccions(Set accions) {
        this.accions = accions;
    }




}


