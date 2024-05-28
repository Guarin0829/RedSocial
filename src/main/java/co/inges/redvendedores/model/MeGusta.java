package co.inges.redvendedores.model;

public class MeGusta {
    private Vendedor autor;
    private String fecha;

    // Constructor
    public MeGusta(Vendedor autor, String fecha) {
        this.autor = autor;
        this.fecha = fecha;
    }

    // Getters y setters
    public Vendedor getAutor() {
        return autor;
    }

    public void setAutor(Vendedor autor) {
        this.autor = autor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
