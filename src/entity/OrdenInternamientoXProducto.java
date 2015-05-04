package entity;
// Generated 03/05/2015 07:54:51 PM by Hibernate Tools 4.3.1



/**
 * OrdenInternamientoXProducto generated by hbm2java
 */
public class OrdenInternamientoXProducto  implements java.io.Serializable {


     private OrdenInternamientoXProductoId id;
     private OrdenInternamiento ordenInternamiento;
     private Producto producto;
     private Integer cantidad;
     private String cantidadIngresada;

    public OrdenInternamientoXProducto() {
    }

	
    public OrdenInternamientoXProducto(OrdenInternamientoXProductoId id, OrdenInternamiento ordenInternamiento, Producto producto) {
        this.id = id;
        this.ordenInternamiento = ordenInternamiento;
        this.producto = producto;
    }
    public OrdenInternamientoXProducto(OrdenInternamientoXProductoId id, OrdenInternamiento ordenInternamiento, Producto producto, Integer cantidad, String cantidadIngresada) {
       this.id = id;
       this.ordenInternamiento = ordenInternamiento;
       this.producto = producto;
       this.cantidad = cantidad;
       this.cantidadIngresada = cantidadIngresada;
    }
   
    public OrdenInternamientoXProductoId getId() {
        return this.id;
    }
    
    public void setId(OrdenInternamientoXProductoId id) {
        this.id = id;
    }
    public OrdenInternamiento getOrdenInternamiento() {
        return this.ordenInternamiento;
    }
    
    public void setOrdenInternamiento(OrdenInternamiento ordenInternamiento) {
        this.ordenInternamiento = ordenInternamiento;
    }
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Integer getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public String getCantidadIngresada() {
        return this.cantidadIngresada;
    }
    
    public void setCantidadIngresada(String cantidadIngresada) {
        this.cantidadIngresada = cantidadIngresada;
    }




}


