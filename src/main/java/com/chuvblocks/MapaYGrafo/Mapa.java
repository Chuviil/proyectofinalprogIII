package com.chuvblocks.MapaYGrafo;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultUndirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

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

    public Set<PuntoMapa> obtenerPuntosMapa() {
        return grafoMapa.vertexSet();
    }

    public PuntoMapa encontrarPuntoMapaMasCercanoACordenada(int x, int y) {
        Vector2 puntoBusqueda = new Vector2(x, y);
        PuntoMapa puntoMasCercano = null;
        double distanciaMinima = Double.MAX_VALUE;

        for (PuntoMapa punto : grafoMapa.vertexSet()) {
            double distancia = punto.getLocalizacion().distanciaEntreVectores(puntoBusqueda);
            if (distancia < distanciaMinima) {
                distanciaMinima = distancia;
                puntoMasCercano = punto;
            }
        }

        return puntoMasCercano;
    }

    public static Mapa Ejemplo() {
        Mapa mapa = new Mapa();
        Random random = new Random();

        int numVertices = 8;
        int maxCoordinate = 550;

        // Create and add random vertices to the map
        for (int i = 1; i <= numVertices; i++) {
            String nombrePunto = "punto" + i;
            int x = random.nextInt(maxCoordinate) + 1;
            int y = random.nextInt(maxCoordinate) + 1;

            PuntoMapa puntoAnterior = mapa.ultimoPuntoMapa();
            PuntoMapa punto = new PuntoMapa(nombrePunto, new Vector2(x, y));
            mapa.addPuntoMapa(punto);

            if (i > 1) {
                mapa.conectarPuntos(puntoAnterior, punto);
            }
        }

        // Randomly connect the vertices
        Set<PuntoMapa> puntosMapa = mapa.obtenerPuntosMapa();
        for (PuntoMapa punto : puntosMapa) {
            int numConnections = random.nextInt(2) + 1; // Randomly connect 1 or 2 edges per vertex

            for (int i = 0; i < numConnections; i++) {
                PuntoMapa puntoAleatorio = null;

                do {
                    puntoAleatorio = obtenerPuntoMapaAleatorio(puntosMapa, punto);
                } while (puntoAleatorio == punto || mapa.grafoMapa.containsEdge(punto, puntoAleatorio));

                mapa.conectarPuntos(punto, puntoAleatorio);
            }
        }

        return mapa;
    }

    private static PuntoMapa obtenerPuntoMapaAleatorio(Set<PuntoMapa> puntosMapa, PuntoMapa puntoExcluir) {
        List<PuntoMapa> puntosList = new ArrayList<>(puntosMapa);
        puntosList.remove(puntoExcluir);
        Random random = new Random();
        return puntosList.get(random.nextInt(puntosList.size()));
    }

    public static void main(String[] args) {
        Mapa mapa = Mapa.Ejemplo();
        System.out.println(mapa);
    }
}
