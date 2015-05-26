package entity;
// Generated May 26, 2015 12:45:04 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * UnidadTransporte generated by hbm2java
 */
public class UnidadTransporte  implements java.io.Serializable {


     private Integer id;
     private TipoUnidadTransporte tipoUnidadTransporte;
     private String transportista;
     private String placa;
     private Integer estado;
     private Set despachos = new HashSet(0);

    public UnidadTransporte() {
    }

	
    public UnidadTransporte(TipoUnidadTransporte tipoUnidadTransporte) {
        this.tipoUnidadTransporte = tipoUnidadTransporte;
    }
    public UnidadTransporte(TipoUnidadTransporte tipoUnidadTransporte, String transportista, String placa, Integer estado, Set despachos) {
       this.tipoUnidadTransporte = tipoUnidadTransporte;
       this.transportista = transportista;
       this.placa = placa;
       this.estado = estado;
       this.despachos = despachos;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public TipoUnidadTransporte getTipoUnidadTransporte() {
        return this.tipoUnidadTransporte;
    }
    
    public void setTipoUnidadTransporte(TipoUnidadTransporte tipoUnidadTransporte) {
        this.tipoUnidadTransporte = tipoUnidadTransporte;
    }
    public String getTransportista() {
        return this.transportista;
    }
    
    public void setTransportista(String transportista) {
        this.transportista = transportista;
    }
    public String getPlaca() {
        return this.placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public Integer getEstado() {
        return this.estado;
    }
    
    public void setEstado(Integer estado) {
        this.estado = estado;
    }
    public Set getDespachos() {
        return this.despachos;
    }
    
    public void setDespachos(Set despachos) {
        this.despachos = despachos;
    }




}


