package entity;
// Generated 30/05/2015 08:07:22 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Pedido generated by hbm2java
 */
public class Pedido  implements java.io.Serializable {


     private Integer id;
     private Cliente cliente;
     private Local local;
     private Integer estado;
     private Date fecha;
     private Set pedidoParcials = new HashSet(0);

    public Pedido() {
    }

	
    public Pedido(Cliente cliente, Local local) {
        this.cliente = cliente;
        this.local = local;
    }
    public Pedido(Cliente cliente, Local local, Integer estado, Date fecha, Set pedidoParcials) {
       this.cliente = cliente;
       this.local = local;
       this.estado = estado;
       this.fecha = fecha;
       this.pedidoParcials = pedidoParcials;
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
    public Local getLocal() {
        return this.local;
    }
    
    public void setLocal(Local local) {
        this.local = local;
    }
    public Integer getEstado() {
        return this.estado;
    }
    
    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Set getPedidoParcials() {
        return this.pedidoParcials;
    }
    
    public void setPedidoParcials(Set pedidoParcials) {
        this.pedidoParcials = pedidoParcials;
    }




}


