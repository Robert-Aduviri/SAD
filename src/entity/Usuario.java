package entity;
// Generated 24-May-2015 14:40:34 by Hibernate Tools 4.3.1



/**
 * Usuario generated by hbm2java
 */
public class Usuario  implements java.io.Serializable {


     private String idusuario;
     private Perfil perfil;
     private PreguntaSecreta preguntaSecreta;
     private String correo;
     private String password;
     private String nombre;
     private String apellidoPaterno;
     private String apellidoMaterno;
     private String respuesta;
     private Integer estado;

    public Usuario() {
    }

	
    public Usuario(String idusuario, String correo) {
        this.idusuario = idusuario;
        this.correo = correo;
    }
    public Usuario(String idusuario, Perfil perfil, PreguntaSecreta preguntaSecreta, String correo, String password, String nombre, String apellidoPaterno, String apellidoMaterno, String respuesta, Integer estado) {
       this.idusuario = idusuario;
       this.perfil = perfil;
       this.preguntaSecreta = preguntaSecreta;
       this.correo = correo;
       this.password = password;
       this.nombre = nombre;
       this.apellidoPaterno = apellidoPaterno;
       this.apellidoMaterno = apellidoMaterno;
       this.respuesta = respuesta;
       this.estado = estado;
    }
   
    public String getIdusuario() {
        return this.idusuario;
    }
    
    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }
    public Perfil getPerfil() {
        return this.perfil;
    }
    
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    public PreguntaSecreta getPreguntaSecreta() {
        return this.preguntaSecreta;
    }
    
    public void setPreguntaSecreta(PreguntaSecreta preguntaSecreta) {
        this.preguntaSecreta = preguntaSecreta;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }
    
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }
    
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    public String getRespuesta() {
        return this.respuesta;
    }
    
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    public Integer getEstado() {
        return this.estado;
    }
    
    public void setEstado(Integer estado) {
        this.estado = estado;
    }




}


