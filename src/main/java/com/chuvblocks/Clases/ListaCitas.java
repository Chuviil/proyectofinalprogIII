package com.chuvblocks.Clases;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class ListaCitas {
    private final Queue<Cita> citas;
    public ListaCitas(){
        citas = new LinkedList<>();
    }

    public void agregar(Cita cita){
        citas.add(cita);
    }

    public Stream<Cita> obtenerCitasPorEmpleado(Empleado empleado){
        return citas.stream().filter(cita -> cita.getEmpleadoAsignado().equals(empleado));
    }

    public Queue<Cita> getCitas() {
        return citas;
    }
}
