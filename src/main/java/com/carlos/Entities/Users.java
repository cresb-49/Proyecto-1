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
    private int dpi;
    private String email;
    private String direction;

    /**
     *  Cosntructor principal de usuarios el cual representa caracteristicas de personas en el programa
     *  almacena las caracteristicas que comparten las entidades de clientes y empleados
     * @param name
     * @param phoneNumber
     * @param nit
     * @param dpi
     * @param email
     * @param direction
     */
    public Users(String name, int phoneNumber,String nit,int dpi,String email,String direction){
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.nit=nit;
        this.dpi=dpi;
        this.email=email;
        this.direction=direction;
    }
    /**
     * Asigna el nombre del usuario
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Retorna el nombre del usuario
     * @return
     */
    public String getName() {
        return name;
    }
    /**
     * Asigna la direcccion del usuario
     * @param direction
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }
    /**
     * Retorna la direccion del usuario
     * @return
     */
    public String getDirection() {
        return direction;
    }
    /**
     * Asgina el numero de DPI del usuario 
     * @param dpi
     */
    public void setDpi(int dpi) {
        this.dpi = dpi;
    }
    /**
     * Retorna el numero de DPI del usuario
     * @return
     */
    public int getDpi() {
        return dpi;
    }
    /**
     * Asigna el correo electronico del usuario
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Retorna el correo electronico del usuario
     * @return
     */
    public String getEmail() {
        return email;
    }
    /**
     * Asigna el nit al usuario
     * @param nit
     */
    public void setNit(String nit) {
        this.nit = nit;
    }
    /**
     * Retorna el nit del usuario
     * @return
     */
    public String getNit() {
        return nit;
    }
    /**
     * Asigna el numero de telefono del usuario
     * @param phoneNumber
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /**
     * Retorna el numero del telefono del usuario
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }
}