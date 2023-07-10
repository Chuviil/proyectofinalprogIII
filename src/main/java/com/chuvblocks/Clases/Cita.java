package com.chuvblocks.Clases;

import java.time.LocalDateTime;

public class Cita {
    private final String motivo;
    private final LocalDateTime fechaYHora;
    private final Empleado empleadoPreferido;
    private final Cliente solicitante;

    public Cita(String motivo, LocalDateTime fechaYHora, Empleado empleadoPreferido, Cliente solicitante) {
        this.motivo = motivo;
        this.fechaYHora = fechaYHora;
        this.empleadoPreferido = empleadoPreferido;
        this.solicitante = solicitante;
    }

    public String getMotivo() {
        return motivo;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public Empleado getEmpleadoPreferido() {
        return empleadoPreferido;
    }

    public Cliente getSolicitante() {
        return solicitante;
    }
}
