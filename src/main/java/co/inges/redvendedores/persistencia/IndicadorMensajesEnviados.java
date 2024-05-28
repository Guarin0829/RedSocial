package co.inges.redvendedores.persistencia;

import co.inges.redvendedores.model.EstadisticasInteraccion;
import co.inges.redvendedores.model.Vendedor;

public class IndicadorMensajesEnviados extends Indicador {
    private Vendedor usuario1;
    private Vendedor usuario2;

    public IndicadorMensajesEnviados(Vendedor usuario1, Vendedor usuario2) {
        super("Cantidad de mensajes entre " + usuario1.getNombre() + " y " + usuario2.getNombre(),
                "Cantidad total de mensajes enviados entre " + usuario1.getNombre() + " y " + usuario2.getNombre());
        this.usuario1 = usuario1;
        this.usuario2 = usuario2;
    }

    @Override
    public int calcularValor(EstadisticasInteraccion estadisticas) {
        // Obtener la cantidad de mensajes enviados entre los usuarios 1 y 2
        // desde las estadísticas de interacción
        return estadisticas.getCantidadMensajesEnviados(usuario1, usuario2);
    }
}

