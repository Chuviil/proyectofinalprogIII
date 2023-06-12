package com.chuvblocks.Clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Proyecto {
    static int contadorProyectos = 1;
    private final String nombre;
    private int codigo;
    private Cliente clientePropietario;
    private String estado;
    private ArrayList<Empleado> empleadosInvolucrados;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String ubicacion;
    private ArrayList<String> materiales;
    private float costoInicial;
    private float capitalInicial;
    private float costoActual;

    public Proyecto(String nombre, Cliente clientePropietario, String estado,
                    LocalDate fechaFin, String ubicacion, float costoInicial, float capitalInicial) {
        this.nombre = nombre;
        this.codigo = contadorProyectos;
        this.clientePropietario = clientePropietario;
        this.estado = estado;
        this.fechaFin = fechaFin;
        this.ubicacion = ubicacion;
        this.costoInicial = costoInicial;
        this.capitalInicial = capitalInicial;
        contadorProyectos++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proyecto proyecto = (Proyecto) o;
        return codigo == proyecto.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    public String getNombre() {
        return nombre;
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

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
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

    @Override
    public String toString() {
        return "Codigo: " + codigo +
                "\tNombre: " + nombre;
    }
}
