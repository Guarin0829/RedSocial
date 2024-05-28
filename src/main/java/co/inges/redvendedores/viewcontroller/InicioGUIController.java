package co.inges.redvendedores.viewcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class InicioGUIController {

    @FXML
    private ComboBox<?> categoriaProductoInicio;

    @FXML
    private TableColumn<?, ?> colComentarios;

    @FXML
    private TableColumn<?, ?> colFechaPublicacionInicio;

    @FXML
    private TableColumn<?, ?> colNombreProductoInicio;

    @FXML
    private TextArea comentario;

    @FXML
    private ComboBox<?> estadoProductoInicio;

    @FXML
    private ImageView imagenProdcuto;

    @FXML
    private TextField nombreProductoInicio;

    @FXML
    private TextField precioProdcutoInicio;

    @FXML
    private TableView<?> tablaComentarios;

    @FXML
    private TableView<?> tablaProductosInicio;

    @FXML
    private TextField vendedorProducto;

    @FXML
    void buscarProductoInicio(ActionEvent event) {

    }

    @FXML
    void comentar(ActionEvent event) {

    }

    @FXML
    void imagenProducto(MouseEvent event) {

    }

    @FXML
    void meGusta(ActionEvent event) {

    }

}

