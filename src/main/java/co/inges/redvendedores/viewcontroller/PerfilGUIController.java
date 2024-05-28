package co.inges.redvendedores.viewcontroller;

import co.inges.redvendedores.controller.ModelFactoryController;
import co.inges.redvendedores.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class PerfilGUIController implements Initializable {

    ModelFactoryController modelFactoryController;

    private Cola cola = new Cola();
    private ObservableList<Vendedor> listaVendedores = FXCollections.observableArrayList();
    private ObservableList<Producto> listaProductos = FXCollections.observableArrayList();

    private String imagen;


    @FXML
    private TextField PrecioProducto;

    @FXML
    private ComboBox<Categoria> categoriaProducto;

    @FXML
    private TableColumn<Producto, Categoria> colCategoria;

    @FXML
    private TableColumn<Producto, EstadoProducto> colEstado;

    @FXML
    private TableColumn<Producto, LocalDateTime> colFechaPublicacion;

    @FXML
    private TableColumn<?, ?> colListaAmigos;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private TableColumn<Producto, Double> colPrecio;

    @FXML
    private ComboBox<EstadoProducto> estadoProducto;

    @FXML
    private TextField nombreProducto;

    @FXML
    private ImageView subirImagen;

    @FXML
    private TableView<?> tablaListaAmigos;

    @FXML
    private TableView<Producto> tablaProductosPerfil;

    @FXML
    void actualizarProdcuto(ActionEvent event) {
        actualizarTablaProductos();

    }

    @FXML
    void buscarProducto(ActionEvent event) {

    }

    @FXML
    void elegirImagen(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivos de imagen", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("Todos los archivos", "*.*")
        );
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            // Guardar la ruta del archivo seleccionado en la variable imagen
            String imagenPath = selectedFile.getAbsolutePath();
            System.out.println("Ruta de la imagen seleccionada: " + imagenPath); // Agregamos esta línea para imprimir la ruta de la imagen
            // Cargar la imagen en el ImageView
            Image image = new Image(selectedFile.toURI().toString());
            subirImagen.setImage(image);
        }
    }

    @FXML
    void eliminarProducto(ActionEvent event) {

    }

    @FXML
    void limpiarEspacios(ActionEvent event) {
        Limpiar();

    }

    /*@FXML
    void publicarProducto(ActionEvent event) {
        String nombre = nombreProducto.getText();
        String imagen = ""; // Puedes obtener la imagen de algún lugar si es necesario
        Categoria categoria = categoriaProducto.getValue();
        double precio = Double.parseDouble(PrecioProducto.getText());
        EstadoProducto estado = estadoProducto.getValue();
        LocalDateTime fechaPublicacion = LocalDateTime.now();

        Producto nuevoProducto = new Producto(nombre, imagen, categoria, precio, estado, fechaPublicacion);

        // Encolar el nuevo producto
        cola.encolar(nuevoProducto);

        // Actualizar la lista de productos
        actualizarTablaProductos();
        Limpiar();

    }*/



    @FXML
    void publicarProducto(ActionEvent event) {
        String nombre = nombreProducto.getText();
        Categoria categoria = categoriaProducto.getValue();
        double precio = Double.parseDouble(PrecioProducto.getText());
        EstadoProducto estado = estadoProducto.getValue();
        LocalDateTime fechaPublicacion = LocalDateTime.now();

        Producto nuevoProducto = new Producto(nombre, imagen, categoria, precio, estado, fechaPublicacion);

        // Agregar el nuevo producto a la lista de productos de RedSocial
        modelFactoryController.redSocial.agregarProducto(nuevoProducto);

        // Guardar los cambios en la persistencia
        modelFactoryController.guardarResourceXML();

        // Actualizar la tabla de productos
        actualizarTablaProductos();
        Limpiar();
    }

    @FXML
    void subirImagen(MouseEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initView();
        // Configurar valores predeterminados para los ComboBox
        categoriaProducto.setItems(FXCollections.observableArrayList(Categoria.values()));
        estadoProducto.setItems(FXCollections.observableArrayList(EstadoProducto.values()));

        // Configurar columnas de la tabla si no se hizo en el archivo FXML
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colFechaPublicacion.setCellValueFactory(new PropertyValueFactory<>("fechaPublicacion"));

        // Actualizar la tabla de productos
        actualizarTablaProductos();

        // Configurar el evento para cargar la imagen al seleccionar un producto de la tabla
        tablaProductosPerfil.getSelectionModel().selectedItemProperty().addListener((observable, oldProduct, newProduct) -> {
            if (newProduct != null) {
                // Actualizar los campos con la información del producto seleccionado
                nombreProducto.setText(newProduct.getNombre());
                categoriaProducto.setValue(newProduct.getCategoria());
                estadoProducto.setValue(newProduct.getEstado());
                PrecioProducto.setText(String.valueOf(newProduct.getPrecio()));
                String imagen = newProduct.getImagen();
                if (imagen != null && !imagen.isEmpty()) {
                    Image image = new Image("file:" + imagen);
                    subirImagen.setImage(image);
                }
            }
        });
    }

    private void initView() {
        modelFactoryController = ModelFactoryController.getInstance();
        obtenerVendedoresRedSocial();
        //obtenerProductossRedSocial();
    }

    private void obtenerVendedoresRedSocial() {
        listaVendedores.addAll(modelFactoryController.obtenerVendedoresRedSocial());
    }

    private void obtenerProductossRedSocial() {
       listaProductos.addAll(modelFactoryController.obtenerProductoRedSocial());
    }


   /* private void actualizarTablaProductos() {
        // Obtener la lista de productos de la cola
        ObservableList<Producto> productos = FXCollections.observableArrayList();
        Nodo<Producto> nodoActual = cola.getPrimero();
        while (nodoActual != null) {
            productos.add(nodoActual.getValorNodo());
            nodoActual = nodoActual.getSiguienteNodo();
        }

        // Actualizar la tabla de productos
        tablaProductosPerfil.setItems(productos);
    }*/

    private void actualizarTablaProductos() {
        // Obtener la lista de productos de la instancia de RedSocial
        listaProductos.clear(); // Limpiar la lista antes de volver a cargar los productos
        listaProductos.addAll(modelFactoryController.redSocial.getListaProductos());

        // Actualizar la tabla de productos
        tablaProductosPerfil.setItems(listaProductos);
    }

    public void Limpiar() {
        subirImagen.setImage(null);
        nombreProducto.setText("");
        estadoProducto.setValue(null);
        categoriaProducto.setValue(null);
        PrecioProducto.setText("");
    }



}

/*package co.inges.redvendedores.viewcontroller;

import co.inges.redvendedores.controller.ModelFactoryController;
import co.inges.redvendedores.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;

public class PerfilGUIController implements Initializable {


    RedSocial redSocial;
    private ModelFactoryController modelFactoryController;
    private ObservableList<Producto> listaProductos = FXCollections.observableArrayList();
    private Producto productoSeleccionado;

    @FXML
    private TextField PrecioProducto;

    @FXML
    private ComboBox<Categoria> categoriaProducto;

    @FXML
    private TableColumn<Producto, Categoria> colCategoria;

    @FXML
    private TableColumn<Producto, EstadoProducto> colEstado;

    @FXML
    private TableColumn<Producto, LocalDateTime> colFechaPublicacion;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Producto, Double> colPrecio;

    @FXML
    private ComboBox<EstadoProducto> estadoProducto;

    @FXML
    private TextField nombreProducto;

    @FXML
    private ImageView subirImagen;

    @FXML
    private TableView<Producto> tablaProductosPerfil;

    @FXML
    void actualizarProducto(ActionEvent event) {
        if (productoSeleccionado != null) {
            String nombre = nombreProducto.getText();
            Categoria categoria = categoriaProducto.getValue();
            double precio = Double.parseDouble(PrecioProducto.getText());
            EstadoProducto estado = estadoProducto.getValue();
            LocalDateTime fechaPublicacion = productoSeleccionado.getFechaPublicacion();

            productoSeleccionado.setNombre(nombre);
            productoSeleccionado.setCategoria(categoria);
            productoSeleccionado.setPrecio(precio);
            productoSeleccionado.setEstado(estado);

            // Guardar el producto actualizado
            modelFactoryController.guardarResourceXML();

            tablaProductosPerfil.refresh();
            Limpiar();

            mostrarMensaje("El producto se ha actualizado con éxito.");
        } else {
            mostrarMensaje("Producto no seleccionado");
        }
    }

    @FXML
    void buscarProducto(ActionEvent event) {
        // Implementación de búsqueda de productos (puede ser según nombre, categoría, etc.)
    }

    @FXML
    void elegirImagen(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivos de imagen", "*.png", "*.jpg", "*.gif"),
                new FileChooser.ExtensionFilter("Todos los archivos", "*.*")
        );
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            String imagenPath = selectedFile.getAbsolutePath();
            Image image = new Image(selectedFile.toURI().toString());
            subirImagen.setImage(image);
        }
    }

    @FXML
    void eliminarProducto(ActionEvent event) {
        if (productoSeleccionado != null) {
            // Eliminar el producto
            modelFactoryController.eliminarProducto(productoSeleccionado.getNombre());
            listaProductos.remove(productoSeleccionado);
            productoSeleccionado = null;
            tablaProductosPerfil.getSelectionModel().clearSelection();
            Limpiar();
            mostrarMensaje("El producto se ha eliminado con éxito.");
        } else {
            mostrarMensaje("Producto no seleccionado");
        }
    }

    @FXML
    void limpiarEspacios(ActionEvent event) {
        Limpiar();
    }

    @FXML
    void publicarProducto(ActionEvent event) {
        String nombre = nombreProducto.getText();
        Categoria categoria = categoriaProducto.getValue();
        double precio = Double.parseDouble(PrecioProducto.getText());
        EstadoProducto estado = estadoProducto.getValue();
        LocalDateTime fechaPublicacion = LocalDateTime.now();

        Producto nuevoProducto = new Producto(nombre, "", categoria, precio, estado, fechaPublicacion);

        // Agregar el producto a la lista y guardar
        listaProductos.add(nuevoProducto);
        modelFactoryController.redSocial.getListaProductos().add(nuevoProducto);

        tablaProductosPerfil.refresh();
        Limpiar();
        mostrarMensaje("El producto se ha publicado con éxito.");
    }

    @FXML
    void subirImagen(javafx.scene.input.MouseEvent event) {
        // Implementación de carga de imagen al hacer clic en el ImageView
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        modelFactoryController = ModelFactoryController.getInstance();
        productoSeleccionado = new Producto();
        initView();
        cargarDatosIniciales();
    }

    private void initView() {
        cargarComboBox();
        initDataBinding();
        listenerSelection();
        obtenerProductos();
    }

    private void cargarComboBox() {
        categoriaProducto.setItems(FXCollections.observableArrayList(Categoria.values()));
        estadoProducto.setItems(FXCollections.observableArrayList(EstadoProducto.values()));
    }

    private void cargarDatosIniciales() {
        tablaProductosPerfil.setItems(listaProductos);
    }

    private void initDataBinding() {
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colFechaPublicacion.setCellValueFactory(new PropertyValueFactory<>("fechaPublicacion"));
    }

    private void listenerSelection() {
        tablaProductosPerfil.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            productoSeleccionado = newSelection;
            mostrarInformacionProducto(productoSeleccionado);
        });
    }

    private void mostrarInformacionProducto(Producto productoSeleccionado) {
        if (productoSeleccionado != null) {
            nombreProducto.setText(productoSeleccionado.getNombre());
            categoriaProducto.setValue(productoSeleccionado.getCategoria());
            estadoProducto.setValue(productoSeleccionado.getEstado());
            PrecioProducto.setText(String.valueOf(productoSeleccionado.getPrecio()));
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
        subirImagen.setImage(null);
        nombreProducto.setText("");
        estadoProducto.setValue(null);
        categoriaProducto.setValue(null);
        PrecioProducto.setText("");
    }
    private void obtenerProductos() {
        listaProductos.addAll(modelFactoryController.obtenerProductoRedSocial());
    }
}*/

