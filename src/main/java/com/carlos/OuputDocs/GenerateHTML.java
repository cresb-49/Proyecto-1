package com.carlos.OuputDocs;

public class GenerateHTML {
    private String src;
    private String nombre;
    public GenerateHTML (String src,String nombre){
        this.nombre=nombre;
        this.src=src;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }public String getSrc() {
        return src;
    }
    public void setSrc(String src) {
        this.src = src;
    }
}