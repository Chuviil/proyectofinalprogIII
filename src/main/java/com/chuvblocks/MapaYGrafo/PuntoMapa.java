package com.chuvblocks.MapaYGrafo;

import java.util.Objects;

public class PuntoMapa {
    private Vector2 localizacion;
    private String nombre;

    public PuntoMapa(String nombre, Vector2 localizacion) {
        this.localizacion = localizacion;
        this.nombre = nombre;
    }

    public PuntoMapa(String nombre, int x, int y) {
        this.localizacion = new Vector2(x, y);
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PuntoMapa puntoMapa = (PuntoMapa) o;
        return Objects.equals(nombre, puntoMapa.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    public Vector2 getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Vector2 localizacion) {
        this.localizacion = localizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
