module co.inges.redvendedores {
    requires javafx.graphics;
    requires javafx.fxml;
    requires org.testng;
    requires javafx.controls;
    requires java.logging;
    requires java.desktop;
    exports co.inges.redvendedores;
    exports co.inges.redvendedores.model;
    exports co.inges.redvendedores.viewcontroller;
    opens co.inges.redvendedores.viewcontroller to javafx.fxml;




}

