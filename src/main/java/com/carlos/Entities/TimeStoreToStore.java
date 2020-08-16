
package com.carlos.Entities;

public class TimeStoreToStore {
    String StoreCode1;
    String StoreCode2;
    int time;
    int id;
    /**
     * Cosntructo Principal de la entidad tiempo
     * @param tienda1Codigo
     * @param tienda2Codigo
     * @param tiempo 
     */
    public TimeStoreToStore(String tienda1Codigo, String tienda2Codigo,int tiempo){
        this.StoreCode1=tienda1Codigo;
        this.StoreCode2=tienda2Codigo;
        this.time=tiempo;
    }
    /**
     * Retorna el codigo de tienda1
     * @return 
     */
    public String getStoreCode1() {
        return StoreCode1;
    }
    /**
     * Asigna el codigo de tienda1
     * @param StoreCode1 
     */
    public void setStoreCode1(String StoreCode1) {
        this.StoreCode1 = StoreCode1;
    }
    /**
     * Retorna el codigo de tienda2
     * @return 
     */
    public String getStoreCode2() {
        return StoreCode2;
    }
    /**
     * Asigna el tiempo de tienda2
     * @param StoreCode2 
     */
    public void setStoreCode2(String StoreCode2) {
        this.StoreCode2 = StoreCode2;
    }
    /**
     * Retorna el tiempo entre ambas tiendas
     * @return 
     */
    public int getTime() {
        return time;
    }
    /**
     * Asigna el tiempo entra ambas tiendas
     * @param time 
     */
    public void setTime(int time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
