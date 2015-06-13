package entity;
// Generated 13-jun-2015 16:24:54 by Hibernate Tools 4.3.1



/**
 * PedidoParcialXProductoId generated by hbm2java
 */
public class PedidoParcialXProductoId  implements java.io.Serializable {


     private int idPedidoParcial;
     private int idProducto;

    public PedidoParcialXProductoId() {
    }

    public PedidoParcialXProductoId(int idPedidoParcial, int idProducto) {
       this.idPedidoParcial = idPedidoParcial;
       this.idProducto = idProducto;
    }
   
    public int getIdPedidoParcial() {
        return this.idPedidoParcial;
    }
    
    public void setIdPedidoParcial(int idPedidoParcial) {
        this.idPedidoParcial = idPedidoParcial;
    }
    public int getIdProducto() {
        return this.idProducto;
    }
    
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PedidoParcialXProductoId) ) return false;
		 PedidoParcialXProductoId castOther = ( PedidoParcialXProductoId ) other; 
         
		 return (this.getIdPedidoParcial()==castOther.getIdPedidoParcial())
 && (this.getIdProducto()==castOther.getIdProducto());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdPedidoParcial();
         result = 37 * result + this.getIdProducto();
         return result;
   }   


}


