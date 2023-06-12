package com.chuvblocks.Clases;

import java.util.Objects;

public class Usuario {
    private String nombre;
    private final String cedula;
    private String email;
    private String contrasenia;

    public Usuario(String nombre, String cedula, String email, String contrasenia) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.email = email;
        this.contrasenia = contrasenia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(cedula, usuario.cedula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
