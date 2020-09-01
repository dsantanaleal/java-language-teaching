package com.dsantanaleal.teach.java_language.model;

import java.io.Serializable;

public class Cargo implements Serializable {

    private Long idCargo;
    private String nomCargo;

    public Cargo(Long idCargo, String nomCargo) {
        this.idCargo = idCargo;
        this.nomCargo = nomCargo;
    }

    public Long getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Long idCargo) {
        this.idCargo = idCargo;
    }

    public String getNomCargo() {
        return nomCargo;
    }

    public void setNomCargo(String nomCargo) {
        this.nomCargo = nomCargo;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "idCargo=" + idCargo +
                ", nomCargo='" + nomCargo + '\'' +
                '}';
    }
}
