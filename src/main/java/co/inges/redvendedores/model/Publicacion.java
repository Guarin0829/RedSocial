package co.inges.redvendedores.model;

import java.util.ArrayList;
import java.util.List;

public class Publicacion {
    private String texto;
    private String fechaPublicacion;
    private Vendedor autor;
    private List<Comentario> comentarios;
    private List<MeGusta> meGusta;

    // Constructor
    public Publicacion(String texto, String fechaPublicacion, Vendedor autor) {
        this.texto = texto;
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
        this.comentarios = new ArrayList<>();
        this.meGusta = new ArrayList<>();
    }

    // Getters y setters
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Vendedor getAutor() {
        return autor;
    }

    public void setAutor(Vendedor autor) {
        this.autor = autor;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public List<MeGusta> getMeGusta() {
        return meGusta;
    }

    public void setMeGusta(List<MeGusta> meGusta) {
        this.meGusta = meGusta;
    }
}
