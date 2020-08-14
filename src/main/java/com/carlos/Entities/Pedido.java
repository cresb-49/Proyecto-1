package com.carlos.Entities;

public class Pedido {
    private String codigo;
    private String tienda1;
    private String tienda2;
    private String fecha;
    private String cliente;
    private String producto;
    private int cantidad;
    private float total;
    private float anticipo;

    /**
     * Cosntructor del objeto pedido
     * @param codigo
     * @param tienda1
     * @param tienda2
     * @param fecha
     * @param cliente
     * @param cantidad
     * @param total
     * @param anticipo
     */
    public Pedido(String codigo, String tienda1,String tienda2,String fecha,String cliente,String producto,int cantidad,float total, float anticipo){
        this.codigo=codigo;
        this.tienda1=tienda1;
        this.tienda2=tienda2;
        this.fecha=fecha;
        this.cliente=cliente;
        this.cantidad=cantidad;
        this.total=total;
        this.anticipo=anticipo;
        this.producto=producto;
    }
    /**
     * Asigna un anticipo al pedido
     * @param anticipo
     */
    public void setAnticipo(float anticipo) {
        this.anticipo = anticipo;
    }
    /**
     * Retorna el anticipo asignado al pedido
     * @return
     */
    public float getAnticipo() {
        return anticipo;
    }
    /**
     * Assigna una cantiad del producto al pedido
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * Retorna la cantidad del producto del pedido
     * @return
     */
    public int getCantidad() {
        return cantidad;
    }
    /**
     * Asigna el cliente de la compra
     * @param cliente
     */
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    /**
     * Retorna el cliente asignado al pedido
     * @return
     */
    public String getCliente() {
        return cliente;
    }
    /**
     * Asigna un codigo al pedido 
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    /**
     * Retorna el codigo asignado al pedido
     * @return
     */
    public String getCodigo() {
        return codigo;
    }
    /**
     * Asigna una fecha al pedido
     * @param fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    /**
     * Retorna la fecha asignada al producto
     */
    public String getFecha() {
        return fecha;
    }
    /**
     * Asigna el codigo de tienda de donde saldra el producto
     * @param tienda1
     */
    public void setTienda1(String tienda1) {
        this.tienda1 = tienda1;
    }
    /**
     * Retorna el codigo de tienda donde saldra el producto 
     * @return
     */
    public String getTienda1() {
        return tienda1;
    }
    /**
     * Asigna el codigo de tienda a donde irea el producto
     * @param tienda2
     */
    public void setTienda2(String tienda2) {
        this.tienda2 = tienda2;
    }
    /**
     * Retorna el codigo de tienda a donde llegara el producto
     * @return
     */
    public String getTienda2() {
        return tienda2;
    }
    /**
     * Asigna el total del pedido
     * @param total
     */
    public void setTotal(float total) {
        this.total = total;
    }
    /**
     * Retorna el total asignado al producto
     */
    public float getTotal() {
        return total;
    }
    /**
     * Asigna el codigo del producto
     * @param producto
     */
    public void setProducto(String producto) {
        this.producto = producto;
    }
    /**
     * Retrona el codigo del producto
     * @return
     */
    public String getProducto() {
        return producto;
    }
}