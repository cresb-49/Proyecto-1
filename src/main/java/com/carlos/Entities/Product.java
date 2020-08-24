package com.carlos.Entities;

public class Product{
    private String name;
    private String manufacturer;
    private String code;
    private int cantidad;
    private double price;
    private String description;
    private int garantia;
    private String tienda;
    /**
     * Constructor principal de registro de productos
     * @param name  nombre del producto
     * @param manufacturer  fabricante del producto
     * @param code  codigo del producto
     * @param cantidad  cantidad en bodega del producto
     * @param price precio del producto
     * @param description   descripcion del producto
     * @param garantia  garantia en meses del producto
     */
    public Product(String name,String manufacturer,String code, int cantidad, double price, String description,int garantia,String tienda){
        this.name=name;
        this.manufacturer=manufacturer;
        this.code=code;
        this.cantidad=cantidad;
        this.price=price;
        this.description=description;
        this.garantia=garantia;
        this.tienda=tienda;
    }
    /**
     * Retorna la cantidad de producto
     */
    public int getCantidad() {
        return cantidad;
    }
    /**
     * Asigna la cantida de producto
     * @param cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    /**
     * Retorna el codigo del producto
     * @return
     */
    public String getCode() {
        return code;
    }
    /**
     * Asigna el codigo del producto
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }
    /**
     * Retrona la descripcion del producto
     * @return
     */
    public String getDescription() {
        return description;
    }
    /**
     * Asigna la descripcion del producto
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Retrona la garantia del producto
     * @return
     */
    public int getGarantia() {
        return garantia;
    }
    /**
     * Asigna la garantia del producto
     * @param garantia
     */
    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }
    /**
     * Retorna el fabricante del producto
     * @return
     */
    public String getManufacturer() {
        return manufacturer;
    }
    /**
     * Asigna el fabricamte del producto
     * @param manufacturer
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    /**
     * Retorna el nombre del producto
     */
    public String getName() {
        return name;
    }
    /**
     * Asigna el nombre del producto
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Retorna el precio del producto
     */
    public double getPrice() {
        return price;
    }
    /**
     * Asigna el precio del producto
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * Retorna el codigo de tienda donde se encuentra el producto
     * @return
     */
    public String getTienda() {
        return tienda;
    }
    /**
     * Asigna el codigo de tienda donde esta el producto
     * @param tienda
     */
    public void setTienda(String tienda) {
        this.tienda = tienda;
    }
}