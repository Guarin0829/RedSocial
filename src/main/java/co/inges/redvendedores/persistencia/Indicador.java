package co.inges.redvendedores.persistencia;

import co.inges.redvendedores.model.EstadisticasInteraccion;

public abstract class Indicador {
    private String nombre;
    private String descripcion;

    public Indicador(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    // Método abstracto para calcular el valor del indicador
    public abstract int calcularValor(EstadisticasInteraccion estadisticas);
}





