package entity;
// Generated May 24, 2015 10:16:20 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Despacho generated by hbm2java
 */
public class Despacho  implements java.io.Serializable {


     private Integer id;
     private int idUnidadTransporte;
     private Set guiaRemisions = new HashSet(0);
     private Set pallets = new HashSet(0);
     private Set pedidoParcials = new HashSet(0);

    public Despacho() {
    }

	
    public Despacho(int idUnidadTransporte) {
        this.idUnidadTransporte = idUnidadTransporte;
    }
    public Despacho(int idUnidadTransporte, Set guiaRemisions, Set pallets, Set pedidoParcials) {
       this.idUnidadTransporte = idUnidadTransporte;
       this.guiaRemisions = guiaRemisions;
       this.pallets = pallets;
       this.pedidoParcials = pedidoParcials;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public int getIdUnidadTransporte() {
        return this.idUnidadTransporte;
    }
    
    public void setIdUnidadTransporte(int idUnidadTransporte) {
        this.idUnidadTransporte = idUnidadTransporte;
    }
    public Set getGuiaRemisions() {
        return this.guiaRemisions;
    }
    
    public void setGuiaRemisions(Set guiaRemisions) {
        this.guiaRemisions = guiaRemisions;
    }
    public Set getPallets() {
        return this.pallets;
    }
    
    public void setPallets(Set pallets) {
        this.pallets = pallets;
    }
    public Set getPedidoParcials() {
        return this.pedidoParcials;
    }
    
    public void setPedidoParcials(Set pedidoParcials) {
        this.pedidoParcials = pedidoParcials;
    }




}


