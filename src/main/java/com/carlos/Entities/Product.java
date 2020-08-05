package com.carlos.Entities;

public class ProductRegistrer {
    private String name;
    private String manufacturer;
    private String code;
    private int cantidad;
    private float price;
    private String description;
    private int garantia;
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
    public Product(String name,String manufacturer,String code, int cantidad, float price, String description,int garantia){
        this.name=name;
        this.manufacturer=manufacturer;
        this.code=code;
        this.cantidad=cantidad;
        this.price=price;
        this.description=description;
        this.garantia=garantia;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getGarantia() {
        return garantia;
    }
    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getPrice() {
        return price;
    }
    public void setPrice(float price) {
        this.price = price;
    }
}