package com.carlos.Entities;

/**
 * User
 */
public class Users {
    //Registros Obligatorios de un usuario
    private String name;
    private int phoneNumber;
    //Registro opcionales para algunas clases de herencia
    private String nit;
    private String dpi;
    private String email;
    private String direction;
    //Caracteristicas a nivel de cuenta
    private String password;


    public Users(String name, int phoneNumber,String nit,int dpi,String email,String direction){
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.nit=nit;
        this.dpi=dpi;
        this.email=email;
        this.direction=direction;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setphoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public int getphoneNumber() {
        return phoneNumber;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
    public String getDirection() {
        return direction;
    }
    public void setDpi(String dpi) {
        this.dpi = dpi;
    }
    public String getDpi() {
        return dpi;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }
    public void setNit(String nit) {
        this.nit = nit;
    }
    public String getNit() {
        return nit;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
}