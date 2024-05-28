package co.inges.redvendedores.viewcontroller;

import co.inges.redvendedores.controller.ModelFactoryController;
import co.inges.redvendedores.model.Vendedor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class LoginGUIController {

    private static ModelFactoryController modelFactoryController;

    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();
    }

    private Map<String, String> usuarios = new HashMap<>();
    @FXML
    private TextField usuarioField;


    @FXML
    private PasswordField contrasenaField;


    @FXML
    private void handleLoginButton(ActionEvent event) throws IOException, NoSuchFieldException {
        String user = usuarioField.getText();
        String pass = contrasenaField.getText();

        if (verificarCredenciales(user, pass)) {
            String cargo = cargoUsuario(user, pass); // Obtener el cargo del usuario

            if (cargo != null) {
                // Determinar la interfaz a cargar según el cargo del usuario
                if (cargo.equals("admin")) {
                    // Cargar la interfaz de administrador
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/inges/redvendedores/AdminInicioGUI.fxml"));
                    Parent root = loader.load();
                    AdminInicioGUIController controller = loader.getController();
                    controller.init(user, cargo);
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                    cerrarVentana(event);
                    // Resto del código para mostrar la ventana...

                } else if (cargo.equals("vendedor")) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/inges/redvendedores/VendedorGUI.fxml"));
                    Parent root = loader.load();
                    VendedorGUIController vendedorGUIControllercontroller = loader.getController();
                    vendedorGUIControllercontroller.init(user, cargo);
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                    cerrarVentana(event);
                }
            }
        } else {
            // Las credenciales son incorrectas
            showAlert(Alert.AlertType.WARNING, "Error", "El usuario y/o contraseña ingresados son incorrectos");
        }
    }





    /*private boolean verificarCredenciales(String usuario, String contrasena) {
        // Aquí debes implementar la lógica para verificar las credenciales.
        // Por ahora, solo devolveremos verdadero si el usuario es "admin" y la contraseña es "admin123".
        return usuario.equals("admin") && contrasena.equals("admin123");
    }*/

    private boolean verificarCredenciales(String usuario, String contrasena) {

        // Verifica las credenciales del administrador primero
        if (usuario.equals("admin") && contrasena.equals("admin123")) {
            return true;
        }

        // Recorre la lista de vendedores y verifica las credenciales
        for (Vendedor vendedor : modelFactoryController.redSocial.getListaVendedores()) {
            if (vendedor.getUsuario().trim().equals(usuario) && vendedor.getContrasena().equals(contrasena)) {
                return true; // Credenciales válidas
            }
        }
        return false; // Credenciales inválidas
    }


    private void abrirVentanaPrincipal(String usuario) {
        // Aquí puedes abrir la ventana principal de la aplicación una vez que se haya iniciado sesión correctamente.
        System.out.println("Bienvenido, " + usuario + "!");
    }


    private void mostrarMensajeError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void onCancelarClick(ActionEvent event) {
    }



    public void onClicAcceso(ActionEvent event) {
    }


    public static void showAlert(Alert.AlertType alertType, String tittle, String message){
        Alert alert = new Alert(alertType);
        alert.setTitle(tittle);
        alert.setContentText(message);
        alert.show();
    }

   /* public static String cargoUsuario(String user, String pass) {
        // Mapa para almacenar los usuarios y contraseñas
        Map<String, String> usuarios = new HashMap<>();
        // Inicialización de usuarios (podrías cargar esto desde una fuente externa como una base de datos o un archivo)
        usuarios.put("usuario1", "password1"); // Usuario y contraseña de un empleado
        usuarios.put("admin", "admin123"); // Usuario y contraseña de un administrador

        // Verificar si el usuario existe y la contraseña es correcta
        if (usuarios.containsKey(user)) {
            String contraseñaAlmacenada = usuarios.get(user);
            if (contraseñaAlmacenada.equals(pass)) {
                // Determinar el rol del usuario
                if (user.equals("admin")) {
                    return "admin";
                } else {
                    return "vendedor";
                }
            }
        }

        // Las credenciales son incorrectas o el usuario no existe
        return null;
    }*/

    public static String cargoUsuario(String user, String pass) {
        if (user.equals("admin") && pass.equals("admin123")) {
            return "admin";
        } else {
            // Verifica si el usuario autenticado es un vendedor
            for (Vendedor vendedor : modelFactoryController.redSocial.getListaVendedores()) {
                if (vendedor.getUsuario().equals(user) && vendedor.getContrasena().equals(pass)) {
                    return "vendedor";
                }
            }
        }
        return null; // Credenciales inválidas
    }



    public static boolean ingresarSistema(String user, String pass) {
        // Mapa para almacenar los usuarios y contraseñas
        Map<String, String> usuarios = new HashMap<>();
        // Inicialización de usuarios (podrías cargar esto desde una fuente externa como una base de datos o un archivo)
        usuarios.put("usuario1", "password1"); // Usuario y contraseña de un empleado
        usuarios.put("admin", "admin123"); // Usuario y contraseña de un administrador

        // Verificar si el usuario y la contraseña coinciden
        if (usuarios.containsKey(user)) {
            String contraseñaAlmacenada = usuarios.get(user);
            if (contraseñaAlmacenada.equals(pass)) {
                return true; // Usuario autenticado exitosamente
            }
        }

        // Las credenciales son incorrectas o el usuario no existe
        return false;
    }

    private void cerrarVentana(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }






}