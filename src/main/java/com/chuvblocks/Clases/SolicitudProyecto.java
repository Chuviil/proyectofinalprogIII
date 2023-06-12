package com.chuvblocks.Clases;

public class SolicitudProyecto {
    private final String nombre;
    private final String ubicacionPreferencia;
    private final int tiempoEstimado;
    private final boolean usoMaterialesEcoAgradables;
    private final boolean tieneEspaciosVerdes;
    private final boolean tieneParqueaderos;
    private final boolean tieneExtras;
    private final String detalles;
    private final Cliente solicitante;

    public SolicitudProyecto(String nombre, String ubicacionPreferencia, int tiempoEstimado, boolean usoMaterialesEcoAgradables, boolean tieneEspaciosVerdes, boolean tieneParqueaderos, boolean tieneExtras, String detalles, Cliente solicitante) {
        this.nombre = nombre;
        this.ubicacionPreferencia = ubicacionPreferencia;
        this.tiempoEstimado = tiempoEstimado;
        this.usoMaterialesEcoAgradables = usoMaterialesEcoAgradables;
        this.tieneEspaciosVerdes = tieneEspaciosVerdes;
        this.tieneParqueaderos = tieneParqueaderos;
        this.tieneExtras = tieneExtras;
        this.detalles = detalles;
        this.solicitante = solicitante;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    public String getUbicacionPreferencia() {
        return ubicacionPreferencia;
    }

    public boolean getUsoMaterialesEcoAgradables() {
        return usoMaterialesEcoAgradables;
    }

    public boolean getTieneEspaciosVerdes() {
        return tieneEspaciosVerdes;
    }

    public boolean getTieneParqueaderos() {
        return tieneParqueaderos;
    }

    public boolean getTieneExtras() {
        return tieneExtras;
    }

    public String getDetalles() {
        return detalles;
    }

    public Cliente getSolicitante() {
        return solicitante;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\t  Ubicacion Preferencia: " + ubicacionPreferencia +
                "\t  TiempoEstimado: " + tiempoEstimado + " Semanas" +
                "\t  Uso de Materiales EcoAgradables: " + (usoMaterialesEcoAgradables ? "Si" : "No") +
                "\t  TieneEspaciosVerdes: " + (tieneEspaciosVerdes ? "Si" : "No") +
                "\t  Tiene Parqueaderos: " + (tieneParqueaderos ? "Si" : "No") +
                "\t  Tiene Extras: " + (tieneExtras ? "Si" : "No") +
                "\t  Detalles: " + detalles +
                "\t  Solicitante: " + solicitante.getNombre();
    }
}
