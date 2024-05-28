package co.inges.redvendedores.model;

import co.inges.redvendedores.persistencia.CSVUtil;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombre;
    private String imagen;
    private Categoria categoria;
    private double precio;
    private EstadoProducto estado;
    private LocalDateTime fechaPublicacion; // Nuevo atributo para la fecha y hora de publicación

    public Producto(){

    }

    public Producto(String nombre, String imagen, Categoria categoria, double precio, EstadoProducto estado, LocalDateTime fechaPublicacion) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.categoria = categoria;
        this.precio = precio;
        this.estado = estado;
        this.fechaPublicacion = fechaPublicacion;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public EstadoProducto getEstado() {
        return estado;
    }

    public void setEstado(EstadoProducto estado) {
        this.estado = estado;
    }

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDateTime fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public static List<Producto> cargarProductosDesdeCSV(String filePath) throws IOException {
        List<Producto> productos = new ArrayList<>();
        List<String[]> data = CSVUtil.readCSV(filePath);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (String[] row : data) {
            Producto producto = new Producto(row[0], row[1],Categoria.valueOf(row[2]), Double.parseDouble(row[3]),
                    EstadoProducto.valueOf(row[4]), LocalDateTime.parse(row[5], formatter));
            productos.add(producto);
        }
        return productos;
    }

    public static void guardarProductosEnCSV(String filePath, List<Producto> productos) throws IOException {
        List<String[]> data = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (Producto producto : productos) {
            data.add(new String[]{producto.getNombre(), producto.getImagen(), String.valueOf(producto.getCategoria()),
                    String.valueOf(producto.getPrecio()), String.valueOf(producto.getEstado()),
                    producto.getFechaPublicacion().format(formatter)});
        }
        CSVUtil.writeCSV(filePath, data);
    }



}
