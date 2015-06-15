package entity;
// Generated 15/06/2015 04:35:07 PM by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Kardex generated by hbm2java
 */
public class Kardex  implements java.io.Serializable {


     private KardexId id;
     private Almacen almacen;
     private Producto producto;
     private Integer cantidad;
     private Date fecha;
     private String tipoMovimiento;
     private Integer stockInicial;
     private Integer stockFinal;

    public Kardex() {
    }

	
    public Kardex(KardexId id, Almacen almacen, Producto producto) {
        this.id = id;
        this.almacen = almacen;
        this.producto = producto;
    }
    public Kardex(KardexId id, Almacen almacen, Producto producto, Integer cantidad, Date fecha, String tipoMovimiento, Integer stockInicial, Integer stockFinal) {
       this.id = id;
       this.almacen = almacen;
       this.producto = producto;
       this.cantidad = cantidad;
       this.fecha = fecha;
       this.tipoMovimiento = tipoMovimiento;
       this.stockInicial = stockInicial;
       this.stockFinal = stockFinal;
    }
   
    public KardexId getId() {
        return this.id;
    }
    
    public void setId(KardexId id) {
        this.id = id;
    }
    public Almacen getAlmacen() {
        return this.almacen;
    }
    
    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
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
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getTipoMovimiento() {
        return this.tipoMovimiento;
    }
    
    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }
    public Integer getStockInicial() {
        return this.stockInicial;
    }
    
    public void setStockInicial(Integer stockInicial) {
        this.stockInicial = stockInicial;
    }
    public Integer getStockFinal() {
        return this.stockFinal;
    }
    
    public void setStockFinal(Integer stockFinal) {
        this.stockFinal = stockFinal;
    }




}


