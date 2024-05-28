package co.inges.redvendedores.utils;

import co.inges.redvendedores.model.Vendedor;

import java.util.function.Predicate;

public class VendedorUtil {

    public static Predicate<Vendedor> buscarPorTodo(String nombre, String apellido, String cedula,
                                                    String direccion, String usuario, String contrasena) {
        return vendedor ->
                vendedor.getNombre().toLowerCase().contains(nombre.toLowerCase()) &&
                        vendedor.getApellido().toLowerCase().contains(apellido.toLowerCase()) &&
                        vendedor.getIdentificacion().toLowerCase().contains(cedula.toLowerCase()) &&
                        vendedor.getDireccion().toLowerCase().contains(direccion.toLowerCase()) &&
                        vendedor.getUsuario().toLowerCase().contains(usuario.toLowerCase()) &&
                        vendedor.getContrasena().toLowerCase().contains(contrasena.toLowerCase());
    }
}
