package br.edu.ufersa.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class TelaPopupSucessoController {
    @FXML private Text sucessText;
    @FXML private Pane background;


    public void initialize(String texto) {
        setSucessText(texto);
    }

    
    private void setSucessText(String texto) {
        this.sucessText.setText(texto);
    }
}