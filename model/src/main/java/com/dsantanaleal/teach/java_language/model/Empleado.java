package com.dsantanaleal.teach.java_language.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Empleado extends Persona implements Serializable {

    private Long id;
    public long serialVersionId = 1;

    public Empleado(Long id, String nombre, String apellido, LocalDate fechaNacimiento) {
        super(nombre, apellido, fechaNacimiento);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "id=" + id +
                "} " + super.toString();
    }
}
