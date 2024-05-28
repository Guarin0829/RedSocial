package co.inges.redvendedores.viewcontroller;
import co.inges.redvendedores.controller.ModelFactoryController;
import co.inges.redvendedores.model.*;
import co.inges.redvendedores.utils.VendedorUtil;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.shape.Rectangle;

import java.time.LocalDateTime;
import java.util.function.Predicate;

public class AdminGUIController {

    
    public ObservableList<Vendedor> getListaUsuarios() {
        listaVendedores.clear(); // Limpiar la lista antes de agregar los vendedores
        listaVendedores.addAll(modelFactoryController.obtenerVendedoresRedSocial());
        return listaVendedores;
    }
    private ObservableList<Vendedor> listaVendedores = FXCollections.observableArrayList();
    RedSocial redSocial;
    ModelFactoryController modelFactoryController;
    Vendedor vendedorSeleccionado;
    private Cola cola = new Cola();
    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnLimpiarCampos;

    @FXML
    private TableColumn<Vendedor, String> colApellidos;

    @FXML
    private TableColumn<Vendedor, String> colCedula;

    @FXML
    private TableColumn<Vendedor, String> colDireccion;

    @FXML
    private TableColumn<Vendedor, String> colNombres;

    @FXML
    private TableColumn<Vendedor, String> colUsuario;

    @FXML
    private Label lblApellido;

    @FXML
    private Label lblCedula;

    @FXML
    private Label lblContrasenia;

    @FXML
    private Label lblDireccion;

    @FXML
    private Label lblFecha;

    @FXML
    private Label lblNombre;

    @FXML
    private Rectangle shape;

    @FXML
    private TableView<Vendedor> tableVendedores;

    @FXML
    private PasswordField tpdContrasenia;

    @FXML
    private TextField txfApellidoAnunciante;

    @FXML
    private TextField txfCedula;

    @FXML
    private TextField txfDireccion;

    @FXML
    private TextField txfNombreAnunciante;

    @FXML
    private TextField txfUsuario;

    @FXML
    void actualizarVendedor(ActionEvent event) {
        if (vendedorSeleccionado != null) {
            String nombre = txfNombreAnunciante.getText();
            String apellido = txfApellidoAnunciante.getText();
            String id = txfCedula.getText();
            String direccion = txfDireccion.getText();
            String usuario = txfUsuario.getText();
            String contrasena = tpdContrasenia.getText();

            // Actualizar los datos del vendedor seleccionado
            vendedorSeleccionado.setNombre(nombre);
            vendedorSeleccionado.setApellido(apellido);
            vendedorSeleccionado.setIdentificacion(id);
            vendedorSeleccionado.setDireccion(direccion);
            vendedorSeleccionado.setUsuario(usuario);
            vendedorSeleccionado.setContrasena(contrasena);

            // Actualizar la tabla de vendedores
            tableVendedores.refresh();

            // Guardar la red social actualizada en el archivo XML
            modelFactoryController.guardarResourceXML();

            // Limpiar los campos del formulario
            Limpiar();

            mostrarMensaje("El vendedor se ha actualizado con éxito.");
        } else {
            mostrarMensaje("Vendedor no seleccionado");
        }
    }

    @FXML
    void agregarVendedor(ActionEvent event) {
        String nombre = txfNombreAnunciante.getText();
        String apellido = txfApellidoAnunciante.getText();
        String id = txfCedula.getText();
        String direccion = txfDireccion.getText();
        String usuario = txfUsuario.getText();
        String contrasena = tpdContrasenia.getText();

        Vendedor nuevoVendedor = new Vendedor(nombre, apellido, id, direccion, usuario, contrasena);

        // Agregar el nuevo vendedor a la lista de la red social
        modelFactoryController.redSocial.getListaVendedores().add(nuevoVendedor);

        // Actualizar la tabla de vendedores
        listaVendedores.add(nuevoVendedor);
        tableVendedores.refresh();

        // Guardar la red social actualizada en el archivo XML
        modelFactoryController.guardarResourceXML();

        // Limpiar los campos del formulario
        Limpiar();





    }


    @FXML
    void atras(ActionEvent event) {

    }

    @FXML
    void busquedaVendedor(ActionEvent event) {
        String nombre = txfNombreAnunciante.getText();
        String apellido = txfApellidoAnunciante.getText();
        String cedula = txfCedula.getText();
        String direccion = txfDireccion.getText();
        String usuario = txfUsuario.getText();
        String contrasena = tpdContrasenia.getText();

        Predicate<Vendedor> predicado = VendedorUtil.buscarPorTodo(nombre, apellido, cedula, direccion, usuario, contrasena);
        ObservableList<Vendedor> vendedoresFiltrados = listaVendedores.filtered(predicado);
        tableVendedores.setItems(vendedoresFiltrados);
    }

    @FXML
    void eliminarVendedor(ActionEvent event) {
        boolean vendedorEliminado = false;
        if (vendedorSeleccionado != null) {
            if (mostrarMensajeConfirmacion("¿Estás seguro de eliminar al vendedor?")) {
                vendedorEliminado = modelFactoryController.eliminarVendedor(vendedorSeleccionado.getIdentificacion());
                if (vendedorEliminado) {
                    listaVendedores.remove(vendedorSeleccionado);
                    vendedorSeleccionado = null;
                    tableVendedores.getSelectionModel().clearSelection();
                    Limpiar();

                } else {
                    mostrarMensaje("El vendedor no se puede eliminar");
                }
            }
        } else {
            mostrarMensaje("Vendedor no seleccionado");
        }
    }


    @FXML
    void limpiarBusqueda(ActionEvent event) {
        Limpiar();
        tableVendedores.getSelectionModel().clearSelection();
        tableVendedores.setItems(getListaUsuarios()); // Restablecer la tabla con la lista completa de vendedores
    }

    @FXML
    void initialize() {
        modelFactoryController = ModelFactoryController.getInstance();
        vendedorSeleccionado = new Vendedor();
        redSocial = new RedSocial();
        initView();
    }
    private void initView() {
        initDataBinding();
        listenerSelection();
        obtenerVendedoresRedSocial();
        tableVendedores.getItems().clear();
        tableVendedores.setItems(listaVendedores);
    }


    private void obtenerVendedoresRedSocial() {
        listaVendedores.addAll(modelFactoryController.obtenerVendedoresRedSocial());
    }

    private void initDataBinding() {
        colNombres.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        colApellidos.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        colCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdentificacion()));
        colDireccion.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDireccion()));
        colUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUsuario()));


    }

    private void listenerSelection() {
        tableVendedores.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            vendedorSeleccionado = newSelection;
            mostrarInformacionVendedor(vendedorSeleccionado);
        });
    }

    private void mostrarInformacionVendedor(Vendedor vendedorSeleccionado) {
        if(vendedorSeleccionado != null){
            txfNombreAnunciante.setText(vendedorSeleccionado.getNombre());
            txfApellidoAnunciante.setText(vendedorSeleccionado.getApellido());
            txfCedula.setText(vendedorSeleccionado.getIdentificacion());
            txfDireccion.setText(vendedorSeleccionado.getDireccion());
            txfUsuario.setText(vendedorSeleccionado.getUsuario());
            tpdContrasenia.setText(vendedorSeleccionado.getContrasena());

        }
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mensaje");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }



    public void Limpiar() {
        txfNombreAnunciante.setText("");
        txfApellidoAnunciante.setText("");
        txfCedula.setText("");
        txfDireccion.setText("");
        txfUsuario.setText("");
        tpdContrasenia.setText("");

    }



    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmación");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        return alert.showAndWait().filter(response -> response == ButtonType.OK).isPresent();
    }










}






