package com.chuvblocks.Clases;

import java.util.LinkedList;
import java.util.Queue;

public class ListaSolicitudesCitas {
    private final Queue<SolicitudCita> solicitudesCitas;

    public ListaSolicitudesCitas() {
        solicitudesCitas = new LinkedList<>();
    }

    public Queue<SolicitudCita> getSolicitudesCitas() {
        return solicitudesCitas;
    }

    public void addSolicitudCita(SolicitudCita solicitudCita) {
        solicitudesCitas.add(solicitudCita);
    }
}
