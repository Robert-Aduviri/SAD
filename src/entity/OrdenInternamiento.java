package entity;
// Generated May 26, 2015 12:45:04 AM by Hibernate Tools 4.3.1


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
     private Set ordenInternamientoXItemProductos = new HashSet(0);

    public OrdenInternamiento() {
    }

    public OrdenInternamiento(Date fecha, Integer estado, Set ordenInternamientoXItemProductos) {
       this.fecha = fecha;
       this.estado = estado;
       this.ordenInternamientoXItemProductos = ordenInternamientoXItemProductos;
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
    public Set getOrdenInternamientoXItemProductos() {
        return this.ordenInternamientoXItemProductos;
    }
    
    public void setOrdenInternamientoXItemProductos(Set ordenInternamientoXItemProductos) {
        this.ordenInternamientoXItemProductos = ordenInternamientoXItemProductos;
    }




}


