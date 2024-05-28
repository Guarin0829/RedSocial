package co.inges.redvendedores.pruebasunitarias;

import co.inges.redvendedores.model.Categoria;
import co.inges.redvendedores.model.EstadoProducto;
import co.inges.redvendedores.model.Producto;
import co.inges.redvendedores.model.Vendedor;
import org.testng.annotations.Test;


import java.time.LocalDateTime;

import static org.testng.AssertJUnit.*;


public class VendedorTest {


    // Test 1. agregar un vendedor
    @Test
    public void testAgregarContacto() {
        Vendedor vendedor1 = new Vendedor("Juan", "Charrasqueado", "123",
                "Kilómetro 5 vía a San Paleste", "Juan123", "123" );
        Vendedor vendedor2 = new Vendedor("Maria", "Charrasqueado", "123",
                "Kilómetro 5 vía a San Paleste", "Maria123", "123");


        // Verificar que la lista de contactos esté vacía inicialmente
        assertTrue(vendedor1.getContactos().isEmpty());


        // Agregar un contacto
        vendedor1.agregarContacto(vendedor2);


        // Verificar que el contacto se haya agregado correctamente
        assertEquals(1, vendedor1.getContactos().size());
        assertTrue(vendedor1.getContactos().contains(vendedor2));
    }


    // Test 2. agregar producto a un vendedor
    @Test
    public void testAgregarProducto() {
        Vendedor vendedor = new Vendedor("Juan", "Charrasqueado", "123",
                "Kilómetro 5 vía a San Paleste", "Juan123", "123");
        Producto producto = new Producto("Camiseta", "imagen1.jpg", Categoria.BELLEZA, 20.0, EstadoProducto.PUBLICADO, LocalDateTime.now());


        vendedor.agregarProducto(producto);


        assertEquals(1, vendedor.getProductos().size());
        assertTrue(vendedor.getProductos().contains(producto));
    }


    // Test 3. Enviar y recibir mensaje entre vendedores
    @Test
    public void testEnviarYRecibirMensaje() {
        Vendedor remitente = new Vendedor("Juan", "Charrasqueado", "123",
                "Kilómetro 5 vía a San Paleste", "Juan123", "123" );
        Vendedor destinatario = new Vendedor("Maria", "Charrasqueado", "123",
                "Kilómetro 5 vía a San Paleste", "Maria123", "123");


        remitente.enviarMensaje(destinatario, "Hola Maria!");


        destinatario.revisarBandejaEntrada();


        //assertFalse(destinatario.getBandejaEntrada().isEmpty());
    }
}



