package com.carlos.Entities;

public class Store{
    private String nombre;
    private String Direccion;
    private String StoreCode;
    private String Phone1;
    private String Phone2;
    private String Email;
    private String Horario;
    
    public Store(String nombre,String Direccion, String StoreCode, String Phone1, String Phone2, String Email,String Horario){
        this.nombre=nombre;
        this.Direccion=Direccion;
        this.StoreCode=StoreCode;
        this.Phone1=Phone1;
        this.Phone2=Phone2;
        this.Email=Email;
        this.Horario=Horario;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return Direccion;
    }
    public void setDireccion(String direccion) {
        Direccion = direccion;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getHorario() {
        return Horario;
    }
    public void setHorario(String horario) {
        Horario = horario;
    }
    public String getPhone1() {
        return Phone1;
    }
    public void setPhone1(String phone1) {
        Phone1 = phone1;
    }
    public String getPhone2() {
        return Phone2;
    }
    public void setPhone2(String phone2) {
        Phone2 = phone2;
    }
    public String getStoreCode() {
        return StoreCode;
    }
    public void setStoreCode(String storeCode) {
        StoreCode = storeCode;
    }
}