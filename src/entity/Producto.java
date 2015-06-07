package entity;
// Generated Jun 7, 2015 10:23:55 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Producto generated by hbm2java
 */
public class Producto  implements java.io.Serializable {


     private Integer id;
     private Condicion condicion;
     private TipoProducto tipoProducto;
     private String nombre;
     private String descripcion;
     private String ean13;
     private Integer cantidadProductosEnPallet;
     private Double peso;
     private String unidad;
     private Integer palletsUbicados;
     private Integer palletsRegistrados;
     private Integer stockLogico;
     private Integer stockTotal;
     private Set pedidoParcialXProductos = new HashSet(0);
     private Set pallets = new HashSet(0);
     private Set ordenInternamientoXProductos = new HashSet(0);
     private Set kardexes = new HashSet(0);

    public Producto() {
    }

	
    public Producto(Condicion condicion, TipoProducto tipoProducto) {
        this.condicion = condicion;
        this.tipoProducto = tipoProducto;
    }
    public Producto(Condicion condicion, TipoProducto tipoProducto, String nombre, String descripcion, String ean13, Integer cantidadProductosEnPallet, Double peso, String unidad, Integer palletsUbicados, Integer palletsRegistrados, Integer stockLogico, Integer stockTotal, Set pedidoParcialXProductos, Set pallets, Set ordenInternamientoXProductos, Set kardexes) {
       this.condicion = condicion;
       this.tipoProducto = tipoProducto;
       this.nombre = nombre;
       this.descripcion = descripcion;
       this.ean13 = ean13;
       this.cantidadProductosEnPallet = cantidadProductosEnPallet;
       this.peso = peso;
       this.unidad = unidad;
       this.palletsUbicados = palletsUbicados;
       this.palletsRegistrados = palletsRegistrados;
       this.stockLogico = stockLogico;
       this.stockTotal = stockTotal;
       this.pedidoParcialXProductos = pedidoParcialXProductos;
       this.pallets = pallets;
       this.ordenInternamientoXProductos = ordenInternamientoXProductos;
       this.kardexes = kardexes;
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Condicion getCondicion() {
        return this.condicion;
    }
    
    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }
    public TipoProducto getTipoProducto() {
        return this.tipoProducto;
    }
    
    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getEan13() {
        return this.ean13;
    }
    
    public void setEan13(String ean13) {
        this.ean13 = ean13;
    }
    public Integer getCantidadProductosEnPallet() {
        return this.cantidadProductosEnPallet;
    }
    
    public void setCantidadProductosEnPallet(Integer cantidadProductosEnPallet) {
        this.cantidadProductosEnPallet = cantidadProductosEnPallet;
    }
    public Double getPeso() {
        return this.peso;
    }
    
    public void setPeso(Double peso) {
        this.peso = peso;
    }
    public String getUnidad() {
        return this.unidad;
    }
    
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
    public Integer getPalletsUbicados() {
        return this.palletsUbicados;
    }
    
    public void setPalletsUbicados(Integer palletsUbicados) {
        this.palletsUbicados = palletsUbicados;
    }
    public Integer getPalletsRegistrados() {
        return this.palletsRegistrados;
    }
    
    public void setPalletsRegistrados(Integer palletsRegistrados) {
        this.palletsRegistrados = palletsRegistrados;
    }
    public Integer getStockLogico() {
        return this.stockLogico;
    }
    
    public void setStockLogico(Integer stockLogico) {
        this.stockLogico = stockLogico;
    }
    public Integer getStockTotal() {
        return this.stockTotal;
    }
    
    public void setStockTotal(Integer stockTotal) {
        this.stockTotal = stockTotal;
    }
    public Set getPedidoParcialXProductos() {
        return this.pedidoParcialXProductos;
    }
    
    public void setPedidoParcialXProductos(Set pedidoParcialXProductos) {
        this.pedidoParcialXProductos = pedidoParcialXProductos;
    }
    public Set getPallets() {
        return this.pallets;
    }
    
    public void setPallets(Set pallets) {
        this.pallets = pallets;
    }
    public Set getOrdenInternamientoXProductos() {
        return this.ordenInternamientoXProductos;
    }
    
    public void setOrdenInternamientoXProductos(Set ordenInternamientoXProductos) {
        this.ordenInternamientoXProductos = ordenInternamientoXProductos;
    }
    public Set getKardexes() {
        return this.kardexes;
    }
    
    public void setKardexes(Set kardexes) {
        this.kardexes = kardexes;
    }




}


