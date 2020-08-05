package com.carlos.Entities;

public class Client extends Users{
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
    public Client(String name,int phoneNumber,String  nit, int dpi,int CreditoCompra,String email,String direction) {
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