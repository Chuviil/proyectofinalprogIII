package com.chuvblocks.Clases;

import java.util.LinkedList;
import java.util.Queue;

public class ListaCitas {
    private final Queue<Cita> citas;
    public ListaCitas(){
        citas = new LinkedList<>();
    }

    public void agregar(Cita cita){
        citas.add(cita);
    }

    public Queue<Cita> getCitas() {
        return citas;
    }
}
