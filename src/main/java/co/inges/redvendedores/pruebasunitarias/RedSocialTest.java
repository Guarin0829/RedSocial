package co.inges.redvendedores.pruebasunitarias;


import co.inges.redvendedores.model.RedSocial;
import co.inges.redvendedores.model.Vendedor;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class RedSocialTest {

    @Test
    public void testEstablecerRelacion() {
        Vendedor vendedor1 = new Vendedor("Juan", "Charrasqueado", "123",
                "Kilómetro 5 vía a San Paleste", "Juan123", "123" );
        Vendedor vendedor2 = new Vendedor("Maria", "Charrasqueado", "123",
                "Kilómetro 5 vía a San Paleste", "Maria123", "123");
        RedSocial redSocial = new RedSocial();

        redSocial.agregarVendedor(vendedor1);
        redSocial.agregarVendedor(vendedor2);
        //redSocial.establecerRelacion(vendedor1, vendedor2);

        assertTrue(vendedor1.getContactos().contains(vendedor2));
        assertTrue(vendedor2.getContactos().contains(vendedor1));
    }
}
