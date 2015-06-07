package entity;
// Generated 06/06/2015 08:19:10 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Local generated by hbm2java
 */
public class Local  implements java.io.Serializable {


     private Integer id;
     private Cliente cliente;
     private Double latitud;
     private Double longitud;
     private String nombre;
     private String descripcion;
     private String direccion;
     private Integer estado;
     private Set pedidos = new HashSet(0);

    public Local() {
    }

	
    public Local(Cliente cliente) {
        this.cliente = cliente;
    }
    public Local(Cliente cliente, Double latitud, Double longitud, String nombre, String descripcion, String direccion, Integer estado, Set pedidos) {
       this.cliente = cliente;
       this.latitud = latitud;
       this.longitud = longitud;
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.direccion = direccion;
       this.estado = estado;
       this.pedidos = pedidos;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Double getLatitud() {
        return this.latitud;
    }
    
    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }
    public Double getLongitud() {
        return this.longitud;
    }
    
    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Integer getEstado() {
        return this.estado;
    }
    
    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    public Set getPedidos() {
        return this.pedidos;
    }
    
    public void setPedidos(Set pedidos) {
        this.pedidos = pedidos;
    }




}


