package com.carlos.Entities;

public class ClientRegistrer extends Users{
    //El nombre se usuario para acceder al sistema es el correo electronico

    private int CreditoCompra;
    
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
    public ClientRegistrer(String name,int phoneNumber,String nit, String dpi,int CreditoCompra,String email,String direction) {
        super(name, phoneNumber, nit, dpi, email, direction);
        this.CreditoCompra = CreditoCompra;
    }

    public int getCreditoCompra() {
        return CreditoCompra;
    }

    public void setCreditoCompra(int creditoCompra) {
        CreditoCompra = creditoCompra;
    }
}