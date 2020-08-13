package com.carlos.Entities;

public class Employee extends Users {
    //El nombre de usuario es el codigo de empleado para acceder al sistema
    private String employeeCode;
    /**
     * Constructor para empleado de la empresa
     * @param employeeCode
     * @param name
     * @param phoneNumber
     * @param nit
     * @param dpi
     * @param email
     * @param direction
     */
    public Employee(String employeeCode, String name, String phoneNumber, String nit,String dpi, String email,String direction){
        super(name, phoneNumber, nit, dpi, email, direction);
        this.employeeCode=employeeCode;
    }
    /**
     * Retorna el codigo de empleado
     * @return
     */
    public String getEmployeeCode() {
        return employeeCode;
    }
    /**
     * Asigna el codigo de empleado
     * @param employeeCode
     */
    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    
}