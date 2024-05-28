package co.inges.redvendedores.viewcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class ChatGUIController {

    @FXML
    private Button bttonEnviarMensaje;

    @FXML
    private TableColumn<?, ?> colChats;

    @FXML
    private TableView<?> tablaChats;

    @FXML
    private TextArea textComentarioChat;

    @FXML
    private TextArea textConversacion;

    @FXML
    void enviarMensaje(ActionEvent event) {

    }

}
