package com.chuvblocks.Clases;

import java.util.LinkedList;
import java.util.List;

public class ListaSolicitudesProyectos {
    List<SolicitudProyecto> solicitudesProyectos;

    public ListaSolicitudesProyectos() {
        solicitudesProyectos = new LinkedList<>();
    }

    public void agregarSolicitud(SolicitudProyecto solicitudProyecto) {
        solicitudesProyectos.add(solicitudProyecto);
    }
}
