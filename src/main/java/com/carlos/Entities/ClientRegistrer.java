package com.carlos.Entities;

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
    public ClientRegistrer(final String name, final int phoneNumber, final String nit, final String dpi,
            final int CreditoCompra, final String email, final String direction) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.nit = nit;
        this.dpi = dpi;
        this.CreditoCompra = CreditoCompra;
        this.email = email;
        this.direction = direction;
    }

    public int getCreditoCompra() {
        return CreditoCompra;
    }

    public void setCreditoCompra(final int creditoCompra) {
        CreditoCompra = creditoCompra;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(final String direction) {
        this.direction = direction;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(final String dpi) {
        this.dpi = dpi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(final String nit) {
        this.nit = nit;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}