package com.carlos.Entities;

public class EmployeeRegistrer extends Users {
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
    public EmployeeRegistrer(String employeeCode, String name, int phoneNumber, String nit,int dpi, String email,String direction){
        super(name, phoneNumber, nit, dpi, email, direction);
        this.employeeCode=employeeCode;
    }
    public String getEmployeeCode() {
        return employeeCode;
    }
    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    
}