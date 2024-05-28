package co.inges.redvendedores.viewcontroller;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminInicioGUIController {

    @FXML
    void crearUsuario(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/inges/redvendedores/AdminGUI.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Red vendedore | Crear Usuario");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();

    }

    private void cerrarVentana(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    void verEstadisticas(ActionEvent event) {

    }
    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mensaje");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void init(String user, String cargo) {
        // Verificar los parámetros de entrada
        System.out.println("Usuario: " + user);
        System.out.println("Cargo: " + cargo);

        // Mostrar mensaje de bienvenida
        mostrarMensaje("Bienvenido, " + user + "!");

        // Configurar la interfaz según el cargo del usuario
        if (cargo.equals("Administrador del Sistema")) {
            // Configurar pestañas específicas u otras acciones para el administrador
            System.out.println("Usuario es un Administrador del Sistema. Configurando la interfaz...");
        } else {
            // Otra lógica según el cargo del usuario (puedes agregar más casos según sea necesario)
            System.out.println("Usuario no es un Administrador del Sistema. Configurando la interfaz...");
        }
    }

}
