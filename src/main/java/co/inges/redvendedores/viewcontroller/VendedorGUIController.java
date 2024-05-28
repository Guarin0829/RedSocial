package co.inges.redvendedores.viewcontroller;

import javafx.scene.control.*;

public class VendedorGUIController {

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



/*package co.inges.redvendedores.viewcontroller;

import co.inges.redvendedores.model.Chat;
import co.inges.redvendedores.model.Cola;
import co.inges.redvendedores.model.Producto;
import co.inges.redvendedores.model.Vendedor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

public class VendedorGUIController {

    @FXML
    private ListView<String> productosListView;

    @FXML
    private ListView<String> contactosListView;

    @FXML
    private Button solicitarVinculoButton;

    @FXML
    private Button publicarComentarioButton;

    @FXML
    private Button meGustaButton;

    @FXML
    private Button enviarMensajeButton; // Nuevo botón para enviar mensajes

    @FXML
    private Button recibirMensajesButton; // Nuevo botón para recibir mensajes

    @FXML
    private TextField comentarioField;

    private List<Producto> productos; // Lista de productos simulada
    private List<Vendedor> contactos; // Lista de contactos simulada
    private Cola<Chat> chatCola = new Cola<>(); // Utilizamos la clase Cola

    // Método para inicializar el controlador con listas de productos y contactos
    public void initialize(List<Producto> productos, List<Vendedor> contactos) {
        this.productos = productos;
        this.contactos = contactos;
        cargarProductosOrdenados(productos);
        cargarContactos();
    }

    private void cargarProductosOrdenados(List<Producto> productos) {
        // Ordenar la lista de productos por fecha y hora de publicación
        productos.sort(Comparator.comparing(Producto::getFechaPublicacion));

        // Convertir los productos ordenados a una lista de cadenas para mostrar en el ListView
        ObservableList<String> items = FXCollections.observableArrayList();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (Producto producto : productos) {
            String productoInfo = producto.getNombre() + " - Publicado el " +
                    producto.getFechaPublicacion().format(formatter);
            items.add(productoInfo);
        }

        // Asignar la lista de productos al ListView
        productosListView.setItems(items);
    }

    private void cargarContactos() {
        ObservableList<String> nombresVendedores = FXCollections.observableArrayList();
        for (Vendedor vendedor : contactos) {
            // Agregar el nombre del vendedor a la lista de nombres
            nombresVendedores.add(vendedor.getNombre());
        }
        contactosListView.setItems(nombresVendedores);
    }

    @FXML
    private void solicitarVinculoButtonClicked() {
        String contactoSeleccionado = contactosListView.getSelectionModel().getSelectedItem();
        if (contactoSeleccionado != null) {
            // Aquí implementa la lógica para enviar la solicitud de vínculo al contacto seleccionado
            mostrarMensaje("Solicitud de vínculo enviada a " + contactoSeleccionado);
        } else {
            mostrarMensaje("Por favor, selecciona un contacto.");
        }
    }

    @FXML
    private void publicarComentarioButtonClicked() {
        String productoSeleccionado = productosListView.getSelectionModel().getSelectedItem();
        String comentario = comentarioField.getText();
        if (productoSeleccionado != null && !comentario.isEmpty()) {
            // Aquí implementa la lógica para publicar el comentario en el producto seleccionado
            mostrarMensaje("Comentario publicado en " + productoSeleccionado + ": " + comentario);
        } else if (productoSeleccionado == null) {
            mostrarMensaje("Por favor, selecciona un producto.");
        } else {
            mostrarMensaje("Por favor, escribe un comentario.");
        }
    }

    @FXML
    private void meGustaButtonClicked() {
        String productoSeleccionado = productosListView.getSelectionModel().getSelectedItem();
        if (productoSeleccionado != null) {
            // Aquí implementa la lógica para registrar el "Me gusta" en el producto seleccionado
            mostrarMensaje("Me gusta agregado a " + productoSeleccionado);
        } else {
            mostrarMensaje("Por favor, selecciona un producto.");
        }
    }

    @FXML
    private void enviarMensajeButtonClicked() {
        String vendedorSeleccionado = contactosListView.getSelectionModel().getSelectedItem();
        String mensaje = comentarioField.getText();
        if (vendedorSeleccionado != null && !mensaje.isEmpty()) {
            Chat chat = new Chat(vendedorSeleccionado, mensaje);
            chatCola.encolar(chat);
            mostrarMensaje("Mensaje enviado a " + vendedorSeleccionado);
        } else if (vendedorSeleccionado == null) {
            mostrarMensaje("Por favor, selecciona un vendedor.");
        } else {
            mostrarMensaje("Por favor, escribe un mensaje.");
        }
    }

    @FXML
    private void recibirMensajesButtonClicked() {
        if (!chatCola.estaVacia()) {
            Chat chat = chatCola.desencolar();
            mostrarMensaje("Mensaje de " + chat.getVendedores() + ": " + chat.getMiChat());
        } else {
            mostrarMensaje("No hay mensajes nuevos.");
        }
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
}*/

