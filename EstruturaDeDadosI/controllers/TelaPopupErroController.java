package controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class TelaPopupErroController {
    @FXML private Text errorText;
    @FXML private Pane background;

    
    public void initialize(String texto) {
        setErrorText(texto);
    }


    private void setErrorText(String texto) {
        this.errorText.setText(texto);
    }
}