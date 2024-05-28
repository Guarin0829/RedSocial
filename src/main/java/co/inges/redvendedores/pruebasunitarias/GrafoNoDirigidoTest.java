package co.inges.redvendedores.pruebasunitarias;

import co.inges.redvendedores.model.GrafoNoDirigido;
import org.testng.annotations.Test;


import static org.testng.AssertJUnit.assertTrue;


public class GrafoNoDirigidoTest {


    @Test
    public void testAgregarNodo() {
        GrafoNoDirigido grafo = new GrafoNoDirigido();


        grafo.agregarNodo("Juan");


        assertTrue(grafo.obtenerVecinos("Juan").isEmpty());
    }


    @Test
    public void testAgregarArista() {
        GrafoNoDirigido grafo = new GrafoNoDirigido();


        grafo.agregarArista("Juan", "Maria");


        assertTrue(grafo.obtenerVecinos("Juan").contains("Maria"));
        assertTrue(grafo.obtenerVecinos("Maria").contains("Juan"));
    }
}

