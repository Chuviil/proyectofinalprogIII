package com.chuvblocks.Clases;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Proyecto {
    static int contadorProyectos = 1;
    private final String nombre;
    private int codigo;
    private Cliente clientePropietario;
    private EstadoProyecto estado;
    private ArrayList<Empleado> empleadosInvolucrados;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String ubicacion;
    private ArrayList<String> materiales;
    private float costoInicial;
    private float capitalInicial;
    private float costoActual;

    public enum EstadoProyecto {
        PLANIFICACION,
        PRESUPUESTO,
        PROCESOS_JUDICIALES,
        TERRENO_Y_CIMENTACION,
        OBRA_GRIS,
        ACABADOS
    }

    public Proyecto(String nombre, Cliente clientePropietario, EstadoProyecto estado,
                    LocalDate fechaFin, String ubicacion, float costoInicial, float capitalInicial) {
        this.nombre = nombre;
        this.codigo = contadorProyectos;
        this.clientePropietario = clientePropietario;
        this.estado = estado;
        this.fechaFin = fechaFin;
        this.ubicacion = ubicacion;
        this.costoInicial = costoInicial;
        this.capitalInicial = capitalInicial;
        this.empleadosInvolucrados = new ArrayList<>();
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

    public EstadoProyecto getEstado() {
        return estado;
    }

    public void setEstado(EstadoProyecto estado) {
        this.estado = estado;
    }

    public ArrayList<Empleado> getEmpleadosInvolucrados() {
        return empleadosInvolucrados;
    }

    public void setEmpleadosInvolucrados(ArrayList<Empleado> empleadosInvolucrados) {
        this.empleadosInvolucrados = empleadosInvolucrados;
    }

    public void agregarEmpleadoInvolucrado(Empleado empleado) {
        this.empleadosInvolucrados.add(empleado);
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

    public void completarUltimoEstado() {
        switch (estado) {
            case PLANIFICACION -> this.estado = EstadoProyecto.PRESUPUESTO;
            case PRESUPUESTO -> this.estado = EstadoProyecto.PROCESOS_JUDICIALES;
            case PROCESOS_JUDICIALES -> this.estado = EstadoProyecto.TERRENO_Y_CIMENTACION;
            case TERRENO_Y_CIMENTACION -> this.estado = EstadoProyecto.OBRA_GRIS;
            case OBRA_GRIS -> this.estado = EstadoProyecto.ACABADOS;
            default -> throw new IllegalStateException("El proyecto ya se encuentra en la última fase");
        }
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo +
                "\t   Nombre: " + nombre +
                "\t   Progreso: " + (int) (((estado.ordinal() + 1) / 6d) * 100) + "%";
    }
}
