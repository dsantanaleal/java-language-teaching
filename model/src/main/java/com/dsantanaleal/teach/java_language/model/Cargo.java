package com.dsantanaleal.teach.java_language.model;

import java.io.Serializable;

public class Cargo implements Serializable {

    private Long id;
    private String nombre;

    public Cargo(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
