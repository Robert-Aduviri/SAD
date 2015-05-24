package entity;
// Generated 24-May-2015 14:40:34 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * OrdenInternamiento generated by hbm2java
 */
public class OrdenInternamiento  implements java.io.Serializable {


     private Integer id;
     private Date fecha;
     private Set ordenInternamientoXProductos = new HashSet(0);

    public OrdenInternamiento() {
    }

    public OrdenInternamiento(Date fecha, Set ordenInternamientoXProductos) {
       this.fecha = fecha;
       this.ordenInternamientoXProductos = ordenInternamientoXProductos;
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
    public Set getOrdenInternamientoXProductos() {
        return this.ordenInternamientoXProductos;
    }
    
    public void setOrdenInternamientoXProductos(Set ordenInternamientoXProductos) {
        this.ordenInternamientoXProductos = ordenInternamientoXProductos;
    }




}


