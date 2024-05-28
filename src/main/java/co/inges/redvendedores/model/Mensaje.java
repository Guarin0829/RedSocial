package co.inges.redvendedores.model;

public class Mensaje {
    private String texto;
    private Vendedor remitente;
    private Vendedor destinatario;
    private String fechaEnvio;

    // Constructor
    public Mensaje(String texto, Vendedor remitente, Vendedor destinatario, String fechaEnvio) {
        this.texto = texto;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.fechaEnvio = fechaEnvio;
    }

    // Getters y setters
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Vendedor getRemitente() {
        return remitente;
    }

    public void setRemitente(Vendedor remitente) {
        this.remitente = remitente;
    }

    public Vendedor getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Vendedor destinatario) {
        this.destinatario = destinatario;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
}

