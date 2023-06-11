package com.chuvblocks.Clases;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ListaUsuarios {
    private Set<Usuario> usuarios;

    public ListaUsuarios() {
        usuarios = new LinkedHashSet<>();
        usuarios.add(new Cliente("Sebastian Quito", "1727575936", "josueq12@gmail.com", "TitaniC2"));
        usuarios.add(new Empleado("Juan Sanchez", "1245789637", "juancarlos@gmail.com", "Juan123"));
        usuarios.add(new Empleado("Pedro Arauz", "1285746985", "pedroc@gmail.com", "Pedro123"));
        usuarios.add(new Empleado("Juan Perez", "1296574821", "juanperez@gmail.com", "Juan123"));
    }

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

    public Usuario obtenerUsuario(String cedula, String contrasenia) throws Exception {
        for (Usuario usuario : usuarios) {
            if (usuario.getCedula().compareTo(cedula) == 0 && usuario.getContrasenia().compareTo(contrasenia) == 0)
                return usuario;
        }
        throw new Exception("Usuario no encontrado");
    }
}
