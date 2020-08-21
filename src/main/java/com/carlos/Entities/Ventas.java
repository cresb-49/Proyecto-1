package com.carlos.Entities;


public class Ventas {
    private String codigoProducto;
    private String codigoTienda;
    private String nitCliente;
    private int cantidad;
    private String fecha;
    /**
     * CONSTRUCTOR PRINCIPAL PARA VENTAS
     * @param codigoProducto
     * @param codigoTienda
     * @param nitCliente
     * @param cantidad
     * @param fecha 
     */
    public Ventas(String codigoProducto, String codigoTienda,String nitCliente,int cantidad,String fecha){
        this.codigoProducto=codigoProducto;
        this.codigoTienda=codigoTienda;
        this.nitCliente=nitCliente;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }
    /**
     * Retorna la cantidad que fue vendida del producto
     * @return
     */
    public int getCantidad() {
        return cantidad;
    }
    /**
     * Asigna la cantidad qu fue vendida de un producto
     * @param cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * Retorna el codigo del producto que fue vendido
     * @return
     */
    public String getCodigoProducto() {
        return codigoProducto;
    }
    /**
     * Asigna el codigo del poducto que fue vendido
     * @param codigoProducto
     */
    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
    /**
     * Retorna el codigo de la tienda donde se realizo la venta
     * @return
     */
    public String getCodigoTienda() {
        return codigoTienda;
    }
    /**
     * Asigna el codigo de tienda donde se realiza la venta
     * @param codigoTienda
     */
    public void setCodigoTienda(String codigoTienda) {
        this.codigoTienda = codigoTienda;
    }
    /**
     * Retorna la fecha en que se realizo una venta
     * @return
     */
    public String getFecha() {
        return fecha;
    }
    /**
     * Asigna la fecha en que se realiza una venta
     * @param fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    /**
     * Retorna el nit del cliente quien realizo la compra
     * @return
     */
    public String getNitCliente() {
        return nitCliente;
    }
    /**
     * asgina el nit del cliente quien realizo la compra
     * @param nitCliente
     */
    public void setNitCliente(String nitCliente) {
        this.nitCliente = nitCliente;
    }
    
}
