package com.example.apivolley.model;

import java.util.Date;

public class Publicacion {


    private  int id;
    private String titulo;
    private  String precio;
    private  String descripcion;
    private  String categoria;

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(final String titulo) {
        this.titulo = titulo;
    }

    public String getPrecio() {
        return this.precio;
    }

    public void setPrecio(final String precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(final String categoria) {
        this.categoria = categoria;
    }
}
