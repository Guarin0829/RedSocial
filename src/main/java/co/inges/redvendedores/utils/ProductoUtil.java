package co.inges.redvendedores.util;

import co.inges.redvendedores.model.Categoria;
import co.inges.redvendedores.model.EstadoProducto;
import co.inges.redvendedores.model.Producto;

import java.util.function.Predicate;

public class ProductoUtil {

    public static Predicate<Producto> buscarPorTodo(String nombre, Categoria categoria, double precioMin, double precioMax, EstadoProducto estado) {
        return producto -> {
            boolean coincideNombre = nombre == null || nombre.isEmpty() || producto.getNombre().toLowerCase().contains(nombre.toLowerCase());
            boolean coincideCategoria = categoria == null || producto.getCategoria() == categoria;
            boolean coincidePrecio = producto.getPrecio() >= precioMin && producto.getPrecio() <= precioMax;
            boolean coincideEstado = estado == null || producto.getEstado() == estado;

            return coincideNombre && coincideCategoria && coincidePrecio && coincideEstado;
        };
    }
}
