package co.inges.redvendedores.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GrafoNoDirigido {
    private Map<String, Set<String>> grafo;
    private Map<String, Nodo<String>> nodos;

    public GrafoNoDirigido() {
        this.grafo = new HashMap<>();
        this.nodos = new HashMap<>();
    }

    // Método para agregar un nodo (vendedor) al grafo
    public void agregarNodo(String vendedor) {
        if (!nodos.containsKey(vendedor)) {
            Nodo<String> nodo = new Nodo<>(vendedor);
            nodos.put(vendedor, nodo);
            grafo.put(vendedor, new HashSet<>());
        }
    }

    // Método para agregar una arista (relación) entre dos nodos (vendedores)
    public void agregarArista(String vendedor1, String vendedor2) {
        agregarNodo(vendedor1);
        agregarNodo(vendedor2);

        grafo.get(vendedor1).add(vendedor2);
        grafo.get(vendedor2).add(vendedor1);
    }

    // Método para obtener los vecinos (contactos) de un nodo (vendedor)
    public Set<String> obtenerVecinos(String vendedor) {
        return grafo.get(vendedor);
    }

    // Otros métodos según sea necesario para la gestión del grafo
}



