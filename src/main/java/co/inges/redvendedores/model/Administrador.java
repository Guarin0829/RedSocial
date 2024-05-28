package co.inges.redvendedores.model;

import java.util.ArrayList;
import java.util.List;

public class Administrador {
    private List<Vendedor> vendedores;
    private EstadisticasInteraccion estadisticas;

    // Constructor
    public Administrador() {
        this.vendedores = new ArrayList<>();
        this.estadisticas = new EstadisticasInteraccion();
    }

    // Método para agregar un nuevo vendedor a la red social
    public void agregarVendedor(Vendedor vendedor) {
        this.vendedores.add(vendedor);
    }

    // Método para obtener la lista de vendedores
    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    // Método para obtener las estadísticas de interacción
    public EstadisticasInteraccion obtenerEstadisticasInteraccion() {
        return estadisticas;
    }

    // Método para actualizar las estadísticas de interacción
    public void actualizarEstadisticasInteraccion(EstadisticasInteraccion nuevasEstadisticas) {
        this.estadisticas = nuevasEstadisticas;
    }

    // Otros métodos según sea necesario para la administración de la red social
}

