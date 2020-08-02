package com.carlos.Input_output;

public class ClientRegistrer {
    private String name;
    private int phoneNumber;
    private String nit;
    private String dpi;
    private int CreditoCompra;
    private String email;
    private String direction;

    /**
     * Constructor registro de cliente en tienda
     * @param name
     * @param phoneNumber
     * @param nit
     * @param dpi
     * @param CreditoCompra
     * @param email
     * @param direction
     */
    public ClientRegistrer(String name, int phoneNumber, String nit, String dpi, int CreditoCompra, String email,String direction){
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.nit=nit;
        this.dpi=dpi;
        this.CreditoCompra=CreditoCompra;
        this.email=email;
        this.direction=direction;
    }
    public int getCreditoCompra() {
        return CreditoCompra;
    }
    public void setCreditoCompra(int creditoCompra) {
        CreditoCompra = creditoCompra;
    }
    public String getDirection() {
        return direction;
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
    public String getDpi() {
        return dpi;
    }
    public void setDpi(String dpi) {
        this.dpi = dpi;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNit() {
        return nit;
    }
    public void setNit(String nit) {
        this.nit = nit;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}