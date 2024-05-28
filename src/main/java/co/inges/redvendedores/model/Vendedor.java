package co.inges.redvendedores.model;

import co.inges.redvendedores.persistencia.CSVUtil;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombre;
    private String apellido;
    private String identificacion;
    private String direccion;
    private String usuario;
    private String contrasena;
    private List<Vendedor> contactos;
    private List<Producto> productos;
    private List<String> muro; // Lista de mensajes en el muro

    private Queue<String> bandejaEntrada; // Cola para mensajes entrantes
    // Puedes agregar más atributos según sea necesario

    public Vendedor(){

    }

    public Vendedor(String nombre, String apellido, String identificacion, String direccion, String usuario, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.contactos = new ArrayList<>();
        this.productos = new ArrayList<>();
        this.muro = new ArrayList<>();
        this.bandejaEntrada = new LinkedList<>();
    }

    // Métodos para administrar la lista de contactos
    public void agregarContacto(Vendedor vendedor) {
        if (this.contactos.size() < 10 && !this.contactos.contains(vendedor)) {
            this.contactos.add(vendedor);
        } else {
            System.out.println("No se puede agregar más contactos.");
        }
    }

    public List<Vendedor> getContactos() {
        return contactos;
    }

    // Métodos para administrar la lista de productos
    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    // Métodos para administrar el muro
    public void publicarMensaje(String mensaje) {
        this.muro.add(mensaje);
    }

    public List<String> getMuro() {
        return muro;
    }

    // Método para enviar un mensaje a otro vendedor
    public void enviarMensaje(Vendedor destinatario, String mensaje) {
        destinatario.recibirMensaje(mensaje);
    }

    // Método para recibir un mensaje de otro vendedor
    public void recibirMensaje(String mensaje) {
        bandejaEntrada.offer(mensaje); // Agregar mensaje a la cola de bandeja de entrada
    }

    // Método para revisar los mensajes en la bandeja de entrada
    public void revisarBandejaEntrada() {
        while (!bandejaEntrada.isEmpty()) {
            System.out.println("Mensaje recibido de " + nombre + ": " + bandejaEntrada.poll());
        }
    }

    public static List<Vendedor> cargarVendedoresDesdeCSV(String filePath) throws IOException {
        List<Vendedor> vendedores = new ArrayList<>();
        List<String[]> data = CSVUtil.readCSV(filePath);
        for (String[] row : data) {
            Vendedor vendedor = new Vendedor(row[0], row[1], row[2], row[3], row[4], row[5]);
            vendedores.add(vendedor);
        }
        return vendedores;
    }

    public static void guardarVendedoresEnCSV(String filePath, List<Vendedor> vendedores) throws IOException {
        List<String[]> data = new ArrayList<>();
        for (Vendedor vendedor : vendedores) {
            data.add(new String[]{vendedor.getNombre(), vendedor.getApellido(),
                    vendedor.getIdentificacion(), vendedor.getDireccion(), vendedor.getUsuario(),
                    vendedor.getContrasena()});
        }
        CSVUtil.writeCSV(filePath, data);
    }


    // Otros métodos según sea necesario

    // Getters y setters para los nuevos atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


    public void setContactos(List<Vendedor> contactos) {
        this.contactos = contactos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public void setMuro(List<String> muro) {
        this.muro = muro;
    }

    public Queue<String> getBandejaEntrada() {
        return bandejaEntrada;
    }

    public void setBandejaEntrada(Queue<String> bandejaEntrada) {
        this.bandejaEntrada = bandejaEntrada;
    }
}
