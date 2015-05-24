package entity;
// Generated 24-May-2015 11:46:56 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * GuiaRemision generated by hbm2java
 */
public class GuiaRemision  implements java.io.Serializable {


     private Integer id;
     private Despacho despacho;
     private PedidoParcial pedidoParcial;
     private Set pedidoParcials = new HashSet(0);

    public GuiaRemision() {
    }

	
    public GuiaRemision(Despacho despacho, PedidoParcial pedidoParcial) {
        this.despacho = despacho;
        this.pedidoParcial = pedidoParcial;
    }
    public GuiaRemision(Despacho despacho, PedidoParcial pedidoParcial, Set pedidoParcials) {
       this.despacho = despacho;
       this.pedidoParcial = pedidoParcial;
       this.pedidoParcials = pedidoParcials;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Despacho getDespacho() {
        return this.despacho;
    }
    
    public void setDespacho(Despacho despacho) {
        this.despacho = despacho;
    }
    public PedidoParcial getPedidoParcial() {
        return this.pedidoParcial;
    }
    
    public void setPedidoParcial(PedidoParcial pedidoParcial) {
        this.pedidoParcial = pedidoParcial;
    }
    public Set getPedidoParcials() {
        return this.pedidoParcials;
    }
    
    public void setPedidoParcials(Set pedidoParcials) {
        this.pedidoParcials = pedidoParcials;
    }




}


