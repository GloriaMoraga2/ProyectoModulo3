package com.ejemplo.model;

public class Producto {
    private  int id;
    private String nombre;
    private double precio;

    public Producto(int id, String nombre, double precio) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }


    public  int getId(){
        return id;
    }

    public  String getNombre(){
        return nombre;
    }

    public double getPrecio(){
        return precio;
    }

}

