package entity;
// Generated May 24, 2015 10:16:20 PM by Hibernate Tools 4.3.1



/**
 * PreguntaSecreta generated by hbm2java
 */
public class PreguntaSecreta  implements java.io.Serializable {


     private Integer id;
     private String pregunta;

    public PreguntaSecreta() {
    }

    public PreguntaSecreta(String pregunta) {
       this.pregunta = pregunta;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getPregunta() {
        return this.pregunta;
    }
    
    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }




}


