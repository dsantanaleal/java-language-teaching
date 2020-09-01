package com.dsantanaleal.teach.java_language.model;

import java.io.Serializable;

public class Departamento implements Serializable {

    private Long idDepartamento;
    private String nomDepartamento;

    public Long getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Long idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNomDepartamento() {
        return nomDepartamento;
    }

    public void setNomDepartamento(String nomDepartamento) {
        this.nomDepartamento = nomDepartamento;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "idDepartamento=" + idDepartamento +
                ", nomDepartamento='" + nomDepartamento + '\'' +
                '}';
    }
}
