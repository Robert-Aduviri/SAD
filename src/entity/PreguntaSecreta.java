package entity;
// Generated 04/04/2015 02:29:48 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * PreguntaSecreta generated by hbm2java
 */
public class PreguntaSecreta  implements java.io.Serializable {


     private Integer idPreguntaSecreta;
     private String pregunta;
     private Set usuarios = new HashSet(0);

    public PreguntaSecreta() {
    }

    public PreguntaSecreta(String pregunta, Set usuarios) {
       this.pregunta = pregunta;
       this.usuarios = usuarios;
    }
   
    public Integer getIdPreguntaSecreta() {
        return this.idPreguntaSecreta;
    }
    
    public void setIdPreguntaSecreta(Integer idPreguntaSecreta) {
        this.idPreguntaSecreta = idPreguntaSecreta;
    }
    public String getPregunta() {
        return this.pregunta;
    }
    
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }




}


