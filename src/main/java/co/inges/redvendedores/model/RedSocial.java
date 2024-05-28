/*package co.inges.redvendedores.model;

import java.util.ArrayList;
import java.util.List;

public class RedSocial {
    private Administrador administrador;
    private Vendedor vendedor;
    private List<Vendedor> listaVendedores;
    private List<Producto> listaProductos;

    public RedSocial() {
        this.administrador = new Administrador();
        this.listaVendedores = new ArrayList<>();
        this.listaProductos = new ArrayList<>();
    }

    // Método para agregar un nuevo vendedor a la red social
    public void agregarVendedor(Vendedor vendedor) {

        administrador.agregarVendedor(vendedor);
    }
    public void agregarProducto(Producto producto) {

        vendedor.agregarProducto(producto);
    }

    // Método para establecer una relación de red entre dos vendedores
    public void establecerRelacion(Vendedor vendedor1, Vendedor vendedor2) {
        vendedor1.agregarContacto(vendedor2);
        vendedor2.agregarContacto(vendedor1);
    }

    // Método para obtener la cantidad de mensajes enviados entre dos usuarios
    public int cantidadMensajesEnviados(Vendedor vendedor1, Vendedor vendedor2) {
        // Lógica para calcular la cantidad de mensajes enviados entre vendedor1 y vendedor2
        return 0; // Por ahora devolvemos un valor arbitrario, debes implementar la lógica adecuada
    }

    // Método para obtener la cantidad de productos publicados entre determinada fecha
    public int cantidadProductosPublicadosEnFecha(List<Vendedor> vendedores, String fecha) {
        // Lógica para calcular la cantidad de productos publicados por los vendedores en la fecha especificada
        return 0; // Por ahora devolvemos un valor arbitrario, debes implementar la lógica adecuada
    }

    // Método para obtener la cantidad de productos publicados por un vendedor
    public int cantidadProductosPublicadosPorVendedor(Vendedor vendedor) {
        // Lógica para calcular la cantidad de productos publicados por el vendedor
        return vendedor.getProductos().size();
    }

    // Método para obtener la cantidad de contactos por cada vendedor
    public int cantidadContactosPorVendedor(Vendedor vendedor) {
        // Lógica para calcular la cantidad de contactos del vendedor
        return vendedor.getContactos().size();
    }

    // Método para obtener el top 10 de los productos más me gusta
    public List<Producto> top10ProductosMasMeGusta() {
        // Lógica para obtener el top 10 de los productos más me gusta
        return null; // Por ahora devolvemos null, debes implementar la lógica adecuada
    }

    // Otros métodos según sea necesario para la gestión de la red social


    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public List<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    public void setListaVendedores(List<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}*/

package co.inges.redvendedores.model;

import java.util.ArrayList;
import java.util.List;

public class RedSocial {
    private Administrador administrador;
    private List<Vendedor> listaVendedores;
    private List<Producto> listaProductos;

    public RedSocial() {
        this.administrador = new Administrador();
        this.listaVendedores = new ArrayList<>();
        this.listaProductos = new ArrayList<>();
    }

    // Método para agregar un nuevo vendedor a la red social
    public void agregarVendedor(Vendedor vendedor) {
        listaVendedores.add(vendedor);
    }

    // Método para agregar un producto a la red social
    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    // Otros métodos según sea necesario para la gestión de la red social

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }

    public List<Vendedor> getListaVendedores() {
        return listaVendedores;
    }

    public void setListaVendedores(List<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
