package co.inges.redvendedores;

import co.inges.redvendedores.controller.ModelFactoryController;
import co.inges.redvendedores.model.Chat;
import co.inges.redvendedores.model.EstadisticasInteraccion;
import co.inges.redvendedores.model.Producto;
import co.inges.redvendedores.model.Vendedor;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

import static javafx.fxml.FXMLLoader.load;

public class Main extends Application {

    private static final String VENDEDORES_CSV = "vendedores.csv";
    private static final String PRODUCTOS_CSV = "productos.csv";
    private static final String CHATS_CSV = "chats.csv";
    private static final String ESTADISTICAS_CSV = "estadisticas.csv";

    private List<Vendedor> vendedores;
    private List<Producto> productos;
    private List<Chat> chats;
    private EstadisticasInteraccion estadisticasInteraccion;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = load(getClass().getResource("LoginGUI.fxml"));
        primaryStage.setTitle("RED DE VENDEDORES");
        primaryStage.setScene(new Scene(root, 723, 400));
        primaryStage.show();

        primaryStage.setOnCloseRequest(event -> {
            try {
                guardarDatos();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void cargarDatos() throws IOException {
        vendedores = Vendedor.cargarVendedoresDesdeCSV(VENDEDORES_CSV);
        productos = Producto.cargarProductosDesdeCSV(PRODUCTOS_CSV);
        chats = Chat.cargarChatsDesdeCSV(CHATS_CSV);
        estadisticasInteraccion = new EstadisticasInteraccion();
        estadisticasInteraccion.cargarEstadisticasDesdeCSV(ESTADISTICAS_CSV);
    }

    private void guardarDatos() throws IOException {
        Vendedor.guardarVendedoresEnCSV(VENDEDORES_CSV, vendedores);
        Producto.guardarProductosEnCSV(PRODUCTOS_CSV, productos);
        Chat.guardarChatsEnCSV(CHATS_CSV, chats);
        estadisticasInteraccion.guardarEstadisticasEnCSV(ESTADISTICAS_CSV);
    }

    public static void main(String[] args) {
        ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();
        launch(args);
    }


}




