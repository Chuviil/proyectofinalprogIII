package com.chuvblocks.MapaYGrafo;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultUndirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.Random;

public class Mapa {
    Graph<PuntoMapa, DefaultWeightedEdge> grafoMapa;

    public Mapa() {
        this.grafoMapa = new DefaultUndirectedWeightedGraph<>(DefaultWeightedEdge.class);
    }

    public PuntoMapa ultimoPuntoMapa() {
        PuntoMapa ultimoElemento = null;
        for (PuntoMapa punto : grafoMapa.vertexSet()) {
            ultimoElemento = punto;
        }
        return ultimoElemento;
    }

    public void addPuntoMapa(PuntoMapa punto) {
        grafoMapa.addVertex(punto);
    }

    public void addPuntosMapaConectados(PuntoMapa punto1, PuntoMapa punto2) {
        grafoMapa.addVertex(punto1);
        grafoMapa.addVertex(punto2);
        DefaultWeightedEdge conexion = grafoMapa.addEdge(punto1, punto2);
        grafoMapa.setEdgeWeight(conexion, punto1.getLocalizacion().distanciaEntreVectores(punto2.getLocalizacion()));
    }

    public void conectarPuntos(PuntoMapa punto1, PuntoMapa punto2) {
        DefaultWeightedEdge conexion = grafoMapa.addEdge(punto1, punto2);
        grafoMapa.setEdgeWeight(conexion, punto1.getLocalizacion().distanciaEntreVectores(punto2.getLocalizacion()));
    }

    public static Mapa Ejemplo() {
        Mapa mapa = new Mapa();
        Random random = new Random();

        for (int i = 1; i <= 20; i++) {
            String nombrePunto = "punto" + i;
            int x = random.nextInt(2000) + 1;
            int y = random.nextInt(2000) + 1;

            PuntoMapa puntoAnterior = mapa.ultimoPuntoMapa();
            PuntoMapa punto = new PuntoMapa(nombrePunto, new Vector2(x, y));
            mapa.addPuntoMapa(punto);

            if (i > 1) {
                mapa.conectarPuntos(puntoAnterior, punto);
            }
        }

        return mapa;
    }

    public static void main(String[] args) {
        Mapa mapa = Mapa.Ejemplo();
        System.out.println(mapa);
    }
}
