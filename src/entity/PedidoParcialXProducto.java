package entity;
// Generated 15/06/2015 04:35:07 PM by Hibernate Tools 4.3.1



/**
 * PedidoParcialXProducto generated by hbm2java
 */
public class PedidoParcialXProducto  implements java.io.Serializable {


     private PedidoParcialXProductoId id;
     private PedidoParcial pedidoParcial;
     private Producto producto;
     private Integer cantidad;

    public PedidoParcialXProducto() {
    }

	
    public PedidoParcialXProducto(PedidoParcialXProductoId id, PedidoParcial pedidoParcial, Producto producto) {
        this.id = id;
        this.pedidoParcial = pedidoParcial;
        this.producto = producto;
    }
    public PedidoParcialXProducto(PedidoParcialXProductoId id, PedidoParcial pedidoParcial, Producto producto, Integer cantidad) {
       this.id = id;
       this.pedidoParcial = pedidoParcial;
       this.producto = producto;
       this.cantidad = cantidad;
    }
   
    public PedidoParcialXProductoId getId() {
        return this.id;
    }
    
    public void setId(PedidoParcialXProductoId id) {
        this.id = id;
    }
    public PedidoParcial getPedidoParcial() {
        return this.pedidoParcial;
    }
    
    public void setPedidoParcial(PedidoParcial pedidoParcial) {
        this.pedidoParcial = pedidoParcial;
    }
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Integer getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }




}


