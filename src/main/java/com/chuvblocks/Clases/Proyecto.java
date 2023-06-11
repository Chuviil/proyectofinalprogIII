package com.chuvblocks.Clases;

import java.util.ArrayList;
import java.util.Date;

public class Proyecto {
    private String nombre;
    private int codigo;
    private Cliente clientePropietario;
    private String estado;
    private ArrayList<Empleado> empleadosInvolucrados;
    private Date fechaInicio;
    private Date fechaFin;
    private String ubicacion;
    private ArrayList<String> materiales;
    private float costoInicial;
    private float capitalInicial;
    private float costoActual;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getClientePropietario() {
        return clientePropietario;
    }

    public void setClientePropietario(Cliente clientePropietario) {
        this.clientePropietario = clientePropietario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<Empleado> getEmpleadosInvolucrados() {
        return empleadosInvolucrados;
    }

    public void setEmpleadosInvolucrados(ArrayList<Empleado> empleadosInvolucrados) {
        this.empleadosInvolucrados = empleadosInvolucrados;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public ArrayList<String> getMateriales() {
        return materiales;
    }

    public void setMateriales(ArrayList<String> materiales) {
        this.materiales = materiales;
    }

    public float getCostoInicial() {
        return costoInicial;
    }

    public void setCostoInicial(float costoInicial) {
        this.costoInicial = costoInicial;
    }

    public float getCapitalInicial() {
        return capitalInicial;
    }

    public void setCapitalInicial(float capitalInicial) {
        this.capitalInicial = capitalInicial;
    }

    public float getCostoActual() {
        return costoActual;
    }

    public void setCostoActual(float costoActual) {
        this.costoActual = costoActual;
    }
}
