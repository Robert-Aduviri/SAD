package entity;
// Generated 15/06/2015 04:35:07 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Log generated by hbm2java
 */
public class Log  implements java.io.Serializable {


     private Integer id;
     private Usuario usuarioByUsuarioActualizador;
     private Usuario usuarioByUsuarioCreador;
     private Date fechaCreacion;
     private Integer tipo;
     private Date fechaActualizacion;
     private String idObjeto;
     private String ip;
     private String mac;

    public Log() {
    }

    public Log(Usuario usuarioByUsuarioActualizador, Usuario usuarioByUsuarioCreador, Date fechaCreacion, Integer tipo, Date fechaActualizacion, String idObjeto, String ip, String mac) {
       this.usuarioByUsuarioActualizador = usuarioByUsuarioActualizador;
       this.usuarioByUsuarioCreador = usuarioByUsuarioCreador;
       this.fechaCreacion = fechaCreacion;
       this.tipo = tipo;
       this.fechaActualizacion = fechaActualizacion;
       this.idObjeto = idObjeto;
       this.ip = ip;
       this.mac = mac;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Usuario getUsuarioByUsuarioActualizador() {
        return this.usuarioByUsuarioActualizador;
    }
    
    public void setUsuarioByUsuarioActualizador(Usuario usuarioByUsuarioActualizador) {
        this.usuarioByUsuarioActualizador = usuarioByUsuarioActualizador;
    }
    public Usuario getUsuarioByUsuarioCreador() {
        return this.usuarioByUsuarioCreador;
    }
    
    public void setUsuarioByUsuarioCreador(Usuario usuarioByUsuarioCreador) {
        this.usuarioByUsuarioCreador = usuarioByUsuarioCreador;
    }
    public Date getFechaCreacion() {
        return this.fechaCreacion;
    }
    
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public Integer getTipo() {
        return this.tipo;
    }
    
    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }
    public Date getFechaActualizacion() {
        return this.fechaActualizacion;
    }
    
    public void setFechaActualizacion(Date fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }
    public String getIdObjeto() {
        return this.idObjeto;
    }
    
    public void setIdObjeto(String idObjeto) {
        this.idObjeto = idObjeto;
    }
    public String getIp() {
        return this.ip;
    }
    
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getMac() {
        return this.mac;
    }
    
    public void setMac(String mac) {
        this.mac = mac;
    }




}


