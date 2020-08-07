package com.carlos.Entities;

public class Pedido {
    private String codigo;
    private String tienda1;
    private String tienda2;
    private String fecha;
    private String cliente;
    private int cantidad;
    private float total;
    private float anticipo;

    /**
     * 
     * @param codigo
     * @param tienda1
     * @param tienda2
     * @param fecha
     * @param cliente
     * @param cantidad
     * @param total
     * @param anticipo
     */
    public Pedido(String codigo, String tienda1,String tienda2,String fecha,String cliente,int cantidad,float total, float anticipo){
        this.codigo=codigo;
        this.tienda1=tienda1;
        this.tienda2=tienda2;
        this.fecha=fecha;
        this.cliente=cliente;
        this.cantidad=cantidad;
        this.total=total;
        this.anticipo=anticipo;
    }
    public void setAnticipo(float anticipo) {
        this.anticipo = anticipo;
    }
    public float getAnticipo() {
        return anticipo;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public String getCliente() {
        return cliente;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getFecha() {
        return fecha;
    }
    public void setTienda1(String tienda1) {
        this.tienda1 = tienda1;
    }
    public String getTienda1() {
        return tienda1;
    }
    public void setTienda2(String tienda2) {
        this.tienda2 = tienda2;
    }
    public String getTienda2() {
        return tienda2;
    }
    public void setTotal(float total) {
        this.total = total;
    }
    public float getTotal() {
        return total;
    }
    
}