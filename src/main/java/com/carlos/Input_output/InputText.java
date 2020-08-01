package com.carlos.Input_output;

import java.io.*;
import java.util.*;

public class InputText {

    private String src = "/home/benjamin/Documents/Proyectos IPC2 2020/archivosprueba/";
    private ArrayList<String> lineasDeTexto = new ArrayList<String>();
    private ArrayList<String> erroresDeDatos = new ArrayList<String>();

    public InputText (){

    }
    public void  LecturaArchivo(){
        File textoDeExtrada = new File(src+"simple data.txt");
        BufferedReader buffer = null;
        String textoProcesado = "";
        if(textoDeExtrada.exists()){
            try {
                buffer = new BufferedReader(new FileReader(textoDeExtrada));
                while((textoProcesado = buffer.readLine())!= null)
                {
                    if(textoProcesado!=null)
                    {
                        lineasDeTexto.add(textoProcesado);
                    }
                }
            } catch (Exception e) {
            }
            finally{
                try {
                    buffer.close();
                } catch (Exception e) {
                
                }
            }
        }
        for (int i = 0; i < lineasDeTexto.size(); i++) {
            int cantidad= contarCaracter(lineasDeTexto.get(i));
            //System.out.println("Cantidad de comas: "+cantidad);
            if (cantidad==3 || cantidad==5 || cantidad==6)
            {
                if(validarTexto(extraerTexto(lineasDeTexto.get(i), 0,lineasDeTexto.get(i).indexOf(",")-1))){

                }
                else{
                    String mensaje = "Linea "+(i+1)+" palabra pricipal no corresponde a la base de datos";    
                    System.out.println(mensaje);
                }
            }
            else{
                String mensaje = "Linea "+(i+1)+" La sistaxis no corresponde a la base de datos";
                System.out.println(mensaje);
            }

        }
    }
    public void setSrc(String src) {
        this.src = src;
    }
    public String getSrc() {
        return src;
    }
    public ArrayList<String> getLineasDeTexto() {
        return lineasDeTexto;
    }

    private static String extraerTexto(String cadena, int inicio, int fin){
        String temporal="";
        char []temporalLetras = new char[(fin-inicio)+1];
        int contador=0;
        //extraccion de caracteres en los limites descritos
        for (int i = inicio; i <= fin; i++) {
            temporalLetras[contador]=cadena.charAt(i);
            contador++;
        }
        //converscion de la cadena a un String
        temporal=String.valueOf(temporalLetras);
        return temporal;
    }

    private static int contarCaracter(String cadena){
        String caracter = ",";
        int respuesta=0;
        int j=0;
        int k=0;
        do{
            if(cadena.indexOf(caracter, j)>-1){
                j=cadena.indexOf(caracter, j)+1;
                k++;
            }
        }while(cadena.indexOf(caracter, j)!=-1);
        respuesta=k;
        return respuesta;
    }
    private static boolean validarTexto(String textoProcesar){
        if(textoProcesar.equals("TIENDA")||textoProcesar.equals("TIEMPO")||textoProcesar.equals("PRODUCTO")||textoProcesar.equals("CLIENTE")||textoProcesar.equals("PEDIDO")){
            return true;
        }
        else
        {
            return false;
        }
    }
}