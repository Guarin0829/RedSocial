package co.inges.redvendedores.model;

import co.inges.redvendedores.persistencia.CSVUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EstadisticasInteraccion {
    private int cantidadMensajesEnviados;
    private int cantidadProductosPublicados;
    private Map<Vendedor, Integer> cantidadProductosPorUsuario;
    private Map<Vendedor, Integer> cantidadContactosPorVendedor;
    private List<Producto> topProductosMeGusta;

    // Constructor
    public EstadisticasInteraccion() {
        this.cantidadMensajesEnviados = 0;
        this.cantidadProductosPublicados = 0;
        this.cantidadProductosPorUsuario = new HashMap<>();
        this.cantidadContactosPorVendedor = new HashMap<>();
        this.topProductosMeGusta = new ArrayList<>();
    }

    // Getters y setters
    public int getCantidadMensajesEnviados() {
        return cantidadMensajesEnviados;
    }

    public void setCantidadMensajesEnviados(int cantidadMensajesEnviados) {
        this.cantidadMensajesEnviados = cantidadMensajesEnviados;
    }

    public int getCantidadProductosPublicados() {
        return cantidadProductosPublicados;
    }

    public void setCantidadProductosPublicados(int cantidadProductosPublicados) {
        this.cantidadProductosPublicados = cantidadProductosPublicados;
    }

    public Map<Vendedor, Integer> getCantidadProductosPorUsuario() {
        return cantidadProductosPorUsuario;
    }

    public void setCantidadProductosPorUsuario(Map<Vendedor, Integer> cantidadProductosPorUsuario) {
        this.cantidadProductosPorUsuario = cantidadProductosPorUsuario;
    }

    public Map<Vendedor, Integer> getCantidadContactosPorVendedor() {
        return cantidadContactosPorVendedor;
    }

    public void setCantidadContactosPorVendedor(Map<Vendedor, Integer> cantidadContactosPorVendedor) {
        this.cantidadContactosPorVendedor = cantidadContactosPorVendedor;
    }

    public List<Producto> getTopProductosMeGusta() {
        return topProductosMeGusta;
    }

    public void setTopProductosMeGusta(List<Producto> topProductosMeGusta) {
        this.topProductosMeGusta = topProductosMeGusta;
    }

    public int getCantidadMensajesEnviados(Vendedor usuario1, Vendedor usuario2) {
        return 0;
    }

    public void cargarEstadisticasDesdeCSV(String filePath) throws IOException {
        List<String[]> data = CSVUtil.readCSV(filePath);
        for (String[] row : data) {
            switch (row[0]) {
                case "cantidadMensajesEnviados":
                    this.cantidadMensajesEnviados = Integer.parseInt(row[1]);
                    break;
                case "cantidadProductosPublicados":
                    this.cantidadProductosPublicados = Integer.parseInt(row[1]);
                    break;
                case "cantidadProductosPorUsuario":
                    // Implementar la lógica de carga de productos por usuario
                    break;
                case "cantidadContactosPorVendedor":
                    // Implementar la lógica de carga de contactos por vendedor
                    break;
                case "topProductosMeGusta":
                    // Implementar la lógica de carga de top productos
                    break;
            }
        }
    }

    public void guardarEstadisticasEnCSV(String filePath) throws IOException {
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"cantidadMensajesEnviados", String.valueOf(this.cantidadMensajesEnviados)});
        data.add(new String[]{"cantidadProductosPublicados", String.valueOf(this.cantidadProductosPublicados)});
        // Agregar lógica para guardar cantidadProductosPorUsuario
        // Agregar lógica para guardar cantidadContactosPorVendedor
        // Agregar lógica para guardar topProductosMeGusta
        CSVUtil.writeCSV(filePath, data);
    }

}
