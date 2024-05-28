package co.inges.redvendedores.utils;

import co.inges.redvendedores.model.*;

import java.time.LocalDateTime;

public class RedSocialUtils {

    public static RedSocial inicializarDatos(){
        RedSocial redsocial = new RedSocial();

        Vendedor vendedor1 = new Vendedor("Jorge", "Curioso", "1094967885",
                "Centro", "jorgito", "1234");

        Producto producto = new Producto("Mouse", "imagen", Categoria.TECNOLOGIA, 34000, EstadoProducto.PUBLICADO, LocalDateTime.now());
        vendedor1.getProductos().add(producto);
        redsocial.getListaVendedores().add(vendedor1);

        Vendedor vendedor2 = new Vendedor("Debora", "Dora", "1094967875",
                "Centro", "debora", "1234");
        redsocial.getListaVendedores().add(vendedor2);

        Vendedor vendedor3 = new Vendedor("Miguel", "Sanchez", "1094967385",
                "Centro", "miguel", "1234");
        redsocial.getListaVendedores().add(vendedor3);

        return redsocial;
    }
}
