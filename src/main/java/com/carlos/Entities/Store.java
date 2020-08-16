package com.carlos.Entities;

public class Store{
    private String nombre;
    private String Direccion;
    private String StoreCode;
    private String Phone1;
    private String Phone2;
    private String Email;
    private String Horario;
    /**
     * Constructor principal del objeto tienda
     * @param nombre
     * @param Direccion
     * @param StoreCode
     * @param Phone1
     * @param Phone2
     * @param Email
     * @param Horario
     */
    public Store(String nombre,String Direccion, String StoreCode, String Phone1, String Phone2, String Email,String Horario){
        this.nombre=nombre;
        this.Direccion=Direccion;
        this.StoreCode=StoreCode;
        this.Phone1=Phone1;
        this.Phone2=Phone2;
        this.Email=Email;
        this.Horario=Horario;
    }
    /**
     * Retorna el nombre de la tienda
     * @return
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Asigna el nombre de la tienda
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Retorna la direccion de la tienda
     * @return
     */
    public String getDireccion() {
        return Direccion;
    }
    /**
     * Asigna la direcccion de la tienda
     * @param direccion
     */
    public void setDireccion(String direccion) {
        Direccion = direccion;
    }
    /**
     * Retorna el email de la tienda
     * @return
     */
    public String getEmail() {
        return Email;
    }
    /**
     * Asigna el email de la tienda
     */
    public void setEmail(String email) {
        Email = email;
    }
    /**
     * Retorna el horario en texto de la tienda
     * @return
     */
    public String getHorario() {
        return Horario;
    }
    /**
     * Asigna el horario de la tienda en texto
     * @param horario
     */
    public void setHorario(String horario) {
        Horario = horario;
    }
    /**
     * Retorna el numero te telefono 1 de la tienda
     * @return
     */
    public String getPhone1() {
        return Phone1;
    }
    /**
     * Asigna el numero de telefono 1 de la tienda ¿
     * @param phone1
     */
    public void setPhone1(String phone1) {
        Phone1 = phone1;
    }
    /**
     * Retorna el numero de telefono 2 de la tienda
     * @return
     */
    public String getPhone2() {
        return Phone2;
    }
    /**
     * Asigna el numero de telefono 2 de la tienda
     * @param phone2
     */
    public void setPhone2(String phone2) {
        Phone2 = phone2;
    }
    /**
     * Retorna el codigo de tienda
     * @return
     */
    public String getStoreCode() {
        return StoreCode;
    }
    /**
     * Asigna el codigo de tienda
     * @param storeCode
     */
    public void setStoreCode(String storeCode) {
        StoreCode = storeCode;
    }
}