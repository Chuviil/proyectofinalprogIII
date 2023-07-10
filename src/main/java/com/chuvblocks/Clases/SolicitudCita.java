package com.chuvblocks.Clases;

public class SolicitudCita {
    private final String mensaje;
    private final String fechaYHoraPrefencia;
    private final Empleado empleadoPreferido;

    public SolicitudCita(String mensaje, String fechaYHoraPrefencia, Empleado empleadoPreferido) {
        this.mensaje = mensaje;
        this.fechaYHoraPrefencia = fechaYHoraPrefencia;
        this.empleadoPreferido = empleadoPreferido;
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

    @Override
    public String toString() {
        return "Fecha Y Hora Prefencia: " + fechaYHoraPrefencia +
                "\t   Empleado Preferido: " + empleadoPreferido.getNombre();
    }
}
