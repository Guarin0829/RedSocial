package co.inges.redvendedores.pruebasunitarias;

import co.inges.redvendedores.model.Categoria;
import co.inges.redvendedores.model.EstadoProducto;
import co.inges.redvendedores.model.Producto;
import org.testng.annotations.Test;


import java.time.LocalDateTime;

import static org.testng.AssertJUnit.assertEquals;


public class ProductoTest {


    @Test
    public void testCrearProducto() {
        Producto producto = new Producto("Camiseta", "imagen1.jpg", Categoria.BELLEZA, 20.0, EstadoProducto.PUBLICADO, LocalDateTime.now());


        assertEquals("Camiseta", producto.getNombre());
        assertEquals("imagen1.jpg", producto.getImagen());
        assertEquals("Ropa", producto.getCategoria());
        assertEquals(20.0, producto.getPrecio(), 0.01); // Asegurar que el precio sea aproximadamente igual
        assertEquals("Publicado", producto.getEstado());
    }


    @Test
    public void testCambiarEstadoProducto() {
        Producto producto = new Producto("Camiseta", "imagen1.jpg", Categoria.BELLEZA, 20.0, EstadoProducto.PUBLICADO, LocalDateTime.now());


        producto.setEstado(EstadoProducto.CANCELADO);


        assertEquals("Vendido", producto.getEstado());
    }
}

