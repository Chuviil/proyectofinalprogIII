package com.chuvblocks.Clases;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

public class ListaProyectos {
    private final Set<Proyecto> proyectos;

    public ListaProyectos() {
        proyectos = new LinkedHashSet<>();
    }

    public Set<Proyecto> getProyectos() {
        return proyectos;
    }

    public void agregarProyecto(Proyecto proyecto) {
        proyectos.add(proyecto);
    }

    public Stream<Proyecto> obtenerProyectosPorCliente(Cliente cliente) {
        return proyectos.stream().filter(proyecto -> proyecto.getClientePropietario().equals(cliente));
    }
}
