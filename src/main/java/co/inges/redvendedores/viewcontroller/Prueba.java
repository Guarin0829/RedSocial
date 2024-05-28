package co.inges.redvendedores.viewcontroller;

import co.inges.redvendedores.controller.ModelFactoryController;
import co.inges.redvendedores.model.RedSocial;
import co.inges.redvendedores.model.Vendedor;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.shape.Rectangle;

public class Prueba {

    private ObservableList<Vendedor> listaVendedores = FXCollections.observableArrayList();
    RedSocial redSocial;
    ModelFactoryController modelFactoryController;
    Vendedor vendedorSeleccionado;
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

    }

    @FXML
    void agregarVendedor(ActionEvent event) {

    }

    @FXML
    void atras(ActionEvent event) {

    }

    @FXML
    void busquedaVendedor(ActionEvent event) {

    }

    @FXML
    void eliminarVendedor(ActionEvent event) {

    }

    @FXML
    void limpiarBusqueda(ActionEvent event) {

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

}
