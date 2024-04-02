package Ejercicio8;

import java.util.*;

public class Grafo {
    private final HashMap<Puerto, List<Arista>> grafo;

    public Grafo() {
        this.grafo = new HashMap<>();
    }

    public void agregarPuerto(Puerto puerto) {
        grafo.putIfAbsent(puerto, new ArrayList<>());
    }

    public void agregarArista(Puerto origen, Puerto destino, int distancia) {
        grafo.get(origen).add(new Arista(destino, distancia));
        grafo.get(destino).add(new Arista(origen, distancia)); // Por ser un grafo no dirigido
    }

    public void barridoProfundidad(Puerto puertoInicial) {
        HashSet<Puerto> visitados = new HashSet<>();
        Stack<Puerto> stack = new Stack<>();
        stack.push(puertoInicial);

        while (!stack.isEmpty()) {
            Puerto actual = stack.pop();

            if (!visitados.contains(actual)) {
                visitados.add(actual);
                System.out.println("Visitando puerto: " + actual.getNombre());

                for (Arista arista : grafo.get(actual)) {
                    stack.push(arista.getDestino());
                }
            }
        }
    }

    public void caminoMasCorto(Puerto origen, Puerto destino) {
        // Implementación del algoritmo de Dijkstra
        HashMap<Puerto, Integer> distancias = new HashMap<>();
        PriorityQueue<Arista> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(Arista::getDistancia));
        HashMap<Puerto, Puerto> predecesores = new HashMap<>();
        HashSet<Puerto> visitados = new HashSet<>();

        for (Puerto puerto : grafo.keySet()) {
            distancias.put(puerto, Integer.MAX_VALUE);
        }
        distancias.put(origen, 0);
        colaPrioridad.add(new Arista(origen, 0));

        while (!colaPrioridad.isEmpty()) {
            Arista aristaActual = colaPrioridad.poll();
            Puerto puertoActual = aristaActual.getDestino();

            if (!visitados.contains(puertoActual)) {
                visitados.add(puertoActual);

                for (Arista arista : grafo.get(puertoActual)) {
                    Puerto vecino = arista.getDestino();
                    int nuevaDistancia = distancias.get(puertoActual) + arista.getDistancia();

                    if (nuevaDistancia < distancias.get(vecino)) {
                        distancias.put(vecino, nuevaDistancia);
                        predecesores.put(vecino, puertoActual);
                        colaPrioridad.add(new Arista(vecino, nuevaDistancia));
                    }
                }
            }
        }

        // Imprimir el camino más corto
        Stack<Puerto> stack = new Stack<>();
        stack.push(destino);
        Puerto predecesor = predecesores.get(destino);

        while (predecesor != null) {
            stack.push(predecesor);
            predecesor = predecesores.get(predecesor);
        }

        System.out.println("Camino más corto desde " + origen.getNombre() + " a " + destino.getNombre() + ":");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().getNombre());
            if (!stack.isEmpty()) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public void eliminarPuertoConMasAristas() {
        Puerto puertoConMasAristas = null;
        int maxAristas = 0;

        for (Map.Entry<Puerto, List<Arista>> entry : grafo.entrySet()) {
            int numAristas = entry.getValue().size();
            if (numAristas > maxAristas) {
                puertoConMasAristas = entry.getKey();
                maxAristas = numAristas;
            }
        }

        if (puertoConMasAristas != null) {
            final Puerto puertoFinal = puertoConMasAristas;
            grafo.remove(puertoConMasAristas);
            for (List<Arista> aristas : grafo.values()) {
                aristas.removeIf(arista -> arista.getDestino().equals(puertoFinal));
            }
            System.out.println("Puerto eliminado: " + puertoConMasAristas.getNombre());
        }
    }
}