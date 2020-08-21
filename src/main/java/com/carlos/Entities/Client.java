package com.carlos.Entities;

public class Client extends Users{
    //El nombre se usuario para acceder al sistema es el correo electronico

    private float CreditoCompra;

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
    public Client(String name,String phoneNumber,String  nit, String dpi,float CreditoCompra,String email,String direction) {
        super(name, phoneNumber, nit, dpi, email, direction);
        this.CreditoCompra = CreditoCompra;
    }
    /**
     * Rertorna la cantidad de credito que tiene el cliente
     * @return
     */
    public float getCreditoCompra() {
        return CreditoCompra;
    }
    /**
     * Asigna un cantidad de credito a un cliente
     * @param creditoCompra
     */
    public void setCreditoCompra(float creditoCompra) {
        CreditoCompra = creditoCompra;
    }
}