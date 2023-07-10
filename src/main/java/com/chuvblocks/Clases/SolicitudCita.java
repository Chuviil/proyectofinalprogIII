package com.chuvblocks.Clases;

public class SolicitudCita {
    private final String mensaje;
    private final String fechaYHoraPrefencia;
    private final Empleado empleadoPreferido;
    private final Cliente solicitante;

    public SolicitudCita(String mensaje, String fechaYHoraPrefencia, Empleado empleadoPreferido, Cliente solicitante) {
        this.mensaje = mensaje;
        this.fechaYHoraPrefencia = fechaYHoraPrefencia;
        this.empleadoPreferido = empleadoPreferido;
        this.solicitante = solicitante;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getFechaYHoraPrefencia() {
        return fechaYHoraPrefencia;
    }

    public Empleado getEmpleadoPreferido() {
        return empleadoPreferido;
    }

    public Cliente getSolicitante() {
        return solicitante;
    }

    @Override
    public String toString() {
        return "Fecha Y Hora Prefencia: " + fechaYHoraPrefencia +
                "\t   Empleado Preferido: " + empleadoPreferido.getNombre();
    }
}
