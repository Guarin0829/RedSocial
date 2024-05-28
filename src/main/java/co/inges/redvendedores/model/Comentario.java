package co.inges.redvendedores.model;

public class Comentario {
    private String texto;
    private Vendedor autor;
    private String fechaPublicacion;

    // Constructor
    public Comentario(String texto, Vendedor autor, String fechaPublicacion) {
        this.texto = texto;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
    }

    // Getters y setters
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Vendedor getAutor() {
        return autor;
    }

    public void setAutor(Vendedor autor) {
        this.autor = autor;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}

