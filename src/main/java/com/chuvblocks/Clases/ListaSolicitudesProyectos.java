package com.chuvblocks.Clases;

import java.util.LinkedList;
import java.util.List;

public class ListaSolicitudesProyectos {
    List<SolicitudProyecto> solicitudesProyectos;

    public ListaSolicitudesProyectos() {
        solicitudesProyectos = new LinkedList<>();
    }

    public List<SolicitudProyecto> obtenertSolicitudesProyectos() {
        return solicitudesProyectos;
    }

    public void eliminarSolicitud(SolicitudProyecto solicitudProyecto) {
        solicitudesProyectos.remove(solicitudProyecto);
    }

    public void agregarSolicitud(SolicitudProyecto solicitudProyecto) {
        solicitudesProyectos.add(solicitudProyecto);
    }
}
