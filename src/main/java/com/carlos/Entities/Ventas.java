package com.carlos.Entities;


public class Ventas {
    private String codigoProducto;
    private String codigoTienda;
    private int cantidad;
    private String fecha;
    /**
     * COSTRUCTOR DE LA CLASE VENTAS
     * @param codigoProducto
     * @param codigoTienda
     * @param cantidad
     * @param fecha 
     */
    public Ventas(String codigoProducto, String codigoTienda,int cantidad,String fecha){
        this.codigoProducto=codigoProducto;
        this.codigoTienda=codigoTienda;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getCodigoTienda() {
        return codigoTienda;
    }

    public void setCodigoTienda(String codigoTienda) {
        this.codigoTienda = codigoTienda;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
