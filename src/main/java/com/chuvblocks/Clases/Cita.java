package com.chuvblocks.Clases;

import java.time.LocalDateTime;

public class Cita {
    private final String motivo;
    private final LocalDateTime fechaYHora;
    private final Empleado empleadoAsignado;
    private final Cliente solicitante;

    public Cita(String motivo, LocalDateTime fechaYHora, Empleado empleadoAsignado, Cliente solicitante) {
        this.motivo = motivo;
        this.fechaYHora = fechaYHora;
        this.empleadoAsignado = empleadoAsignado;
        this.solicitante = solicitante;
    }

    public String getMotivo() {
        return motivo;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public Empleado getEmpleadoAsignado() {
        return empleadoAsignado;
    }

    public Cliente getSolicitante() {
        return solicitante;
    }

    @Override
    public String toString() {
        return "Fecha Y Hora: " + fechaYHora.toString() +
                "\t   Solicitante: " + solicitante.getNombre();
    }
}
