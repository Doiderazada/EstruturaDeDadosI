module br.edu.ufersa {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires java.desktop;

    opens br.edu.ufersa to javafx.fxml;
    opens br.edu.ufersa.controllers to javafx.fxml;
    exports br.edu.ufersa;
    exports br.edu.ufersa.controllers;
}