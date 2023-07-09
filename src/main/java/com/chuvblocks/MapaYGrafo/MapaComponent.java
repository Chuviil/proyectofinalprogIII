package com.chuvblocks.MapaYGrafo;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.piccolo2d.PCanvas;
import org.piccolo2d.event.PBasicInputEventHandler;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.event.PMouseWheelZoomEventHandler;
import org.piccolo2d.nodes.PPath;
import org.piccolo2d.nodes.PText;

import java.awt.*;

public class MapaComponent extends PCanvas {
    Mapa mapa;

    public MapaComponent(Mapa mapa) {
        this.mapa = mapa;
        PMouseWheelZoomEventHandler zoomRueda = new PMouseWheelZoomEventHandler();
        zoomRueda.setScaleFactor(-0.1);
        addInputEventListener(zoomRueda);
        setZoomEventHandler(null);
        graficar();
    }

    public void graficar() {
        removeAll();
        for (PuntoMapa punto : mapa.grafoMapa.vertexSet()) {
            PPath marcadorMapa = PPath.createEllipse(
                    punto.getLocalizacion().getX() - 10,
                    punto.getLocalizacion().getY() - 10, 20, 20);
            marcadorMapa.setPaint(punto.estaOcupado() ? Color.RED : Color.GREEN);
            PText texto = new PText(punto.getNombre());
            texto.setBounds(punto.getLocalizacion().getX(), punto.getLocalizacion().getY() + 5, 10, 10);
            getLayer().addChild(marcadorMapa);
            getLayer().addChild(texto);
        }

        for (DefaultWeightedEdge vertice : mapa.grafoMapa.edgeSet()) {
            PuntoMapa fuente = mapa.grafoMapa.getEdgeSource(vertice);
            PuntoMapa destino = mapa.grafoMapa.getEdgeTarget(vertice);
            PPath linea = PPath.createLine(
                    fuente.getLocalizacion().getX(), fuente.getLocalizacion().getY(),
                    destino.getLocalizacion().getX(), destino.getLocalizacion().getY()
            );
            linea.setPaint(Color.BLACK);
            getLayer().addChild(linea);
        }

    }
}
