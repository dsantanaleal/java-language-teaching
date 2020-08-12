package com.dsantanaleal.teach.java_language.model;

import com.dsantanaleal.teach.java_language.model.enums.TipoContrato;
import com.dsantanaleal.teach.java_language.model.exceptions.SalarioNoMenorACeroException;

import java.io.Serializable;
import java.time.LocalDate;

public class Contrato implements Serializable {

    private Empleado empleado;
    private TipoContrato tipoContrato;
    private LocalDate inicioContrato;
    private LocalDate finalContrato;
    private Cargo cargo;
    private Departamento departamento;
    private Double salario;

    public Contrato(Empleado empleado, Double salario, TipoContrato tipoContrato, LocalDate inicioContrato, Cargo cargo, Departamento departamento) throws SalarioNoMenorACeroException {
        this.empleado = empleado;
        this.salario = salario;
        this.tipoContrato = tipoContrato;
        this.inicioContrato = inicioContrato;
        this.cargo = cargo;
        this.departamento = departamento;
    }

    public Contrato(Empleado empleado, Double salario, TipoContrato tipoContrato, LocalDate inicioContrato, LocalDate finalContrato, Cargo cargo, Departamento departamento) throws SalarioNoMenorACeroException {
        this.empleado = empleado;
        this.salario = salario;
        this.tipoContrato = tipoContrato;
        this.inicioContrato = inicioContrato;
        this.finalContrato = finalContrato;
        this.cargo = cargo;
        this.departamento = departamento;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public TipoContrato getTipoContrato() {
        return tipoContrato;
    }

    public void setTipoContrato(TipoContrato tipoContrato) {
        this.tipoContrato = tipoContrato;
    }

    public LocalDate getInicioContrato() {
        return inicioContrato;
    }

    public void setInicioContrato(LocalDate inicioContrato) {
        this.inicioContrato = inicioContrato;
    }

    public LocalDate getFinalContrato() {
        return finalContrato;
    }

    public void setFinalContrato(LocalDate finalContrato) {
        this.finalContrato = finalContrato;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) throws SalarioNoMenorACeroException {
        if(salario < 0.0) {
            throw new SalarioNoMenorACeroException("El salario no puede ser menor a cero");
        }
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "empleado=" + empleado +
                ", tipoContrato=" + tipoContrato +
                ", inicioContrato=" + inicioContrato +
                ", finalContrato=" + finalContrato +
                ", cargo=" + cargo +
                ", departamento=" + departamento +
                ", salario=" + salario +
                '}';
    }
}
