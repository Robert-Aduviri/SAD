package entity;
// Generated Jun 3, 2015 6:36:49 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * OrdenInternamiento generated by hbm2java
 */
public class OrdenInternamiento  implements java.io.Serializable {


     private Integer id;
     private Date fecha;
     private Integer estado;
     private Set ordenInternamientoXProductos = new HashSet(0);
     private Set pallets = new HashSet(0);

    public OrdenInternamiento() {
    }

    public OrdenInternamiento(Date fecha, Integer estado, Set ordenInternamientoXProductos, Set pallets) {
       this.fecha = fecha;
       this.estado = estado;
       this.ordenInternamientoXProductos = ordenInternamientoXProductos;
       this.pallets = pallets;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Integer getEstado() {
        return this.estado;
    }
    
    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    public Set getOrdenInternamientoXProductos() {
        return this.ordenInternamientoXProductos;
    }
    
    public void setOrdenInternamientoXProductos(Set ordenInternamientoXProductos) {
        this.ordenInternamientoXProductos = ordenInternamientoXProductos;
    }
    public Set getPallets() {
        return this.pallets;
    }
    
    public void setPallets(Set pallets) {
        this.pallets = pallets;
    }




}


