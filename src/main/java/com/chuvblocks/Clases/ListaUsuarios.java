package com.chuvblocks.Clases;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ListaUsuarios {
    private final Set<Usuario> usuarios = new LinkedHashSet<>();

    public void agregarUsuario(Usuario usuario) throws Exception {
        if (!usuarios.add(usuario)) throw new Exception("No se puede agregar el usuario");
    }

    public Set<Usuario> obtenerUsuarios() {
        return usuarios;
    }

    public List<Cliente> obtenerClientes() {
        List<Cliente> clientes = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Cliente) {
                clientes.add((Cliente) usuario);
            }
        }
        return clientes;
    }

    public Cliente obtenerCliente(String cedula) {
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Cliente clienteTemporal) {
                if (clienteTemporal.getCedula().compareTo(cedula) == 0) return clienteTemporal;
            }
        }
        return null;
    }

    public List<Empleado> obtenerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Empleado) {
                empleados.add((Empleado) usuario);
            }
        }
        return empleados;
    }

    public Usuario obtenerUsuario(String cedula) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCedula().compareTo(cedula) == 0) return usuario;
        }
        return null;
    }
}
