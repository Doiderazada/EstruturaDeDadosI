package controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import source.App;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class TelaInicialController {
    
    @FXML private Button buttonDM;
    @FXML private Button buttonLista;
    @FXML private Button buttonPDF;
    @FXML private Button buttonSobre;
    @FXML private Label copyRight;
    @FXML private BorderPane telaInicial;


    @FXML
    public void initialize() {
        acaoDosBotoes();
        setStilo();
    }


    private void setStilo() {
        if (App.darkMode) {
            telaInicial.setStyle("-fx-background-color: #282828");
            buttonLista.getStyleClass().setAll("btn-questao-DM");
            buttonPDF.getStyleClass().setAll("btn-questao-DM");
            buttonSobre.getStyleClass().setAll("btn-questao-DM");
            buttonDM.getStyleClass().setAll("btn-DarkMode");
        } else {
            telaInicial.setStyle(null);
            buttonLista.getStyleClass().setAll("btn-questao");
            buttonPDF.getStyleClass().setAll("btn-questao");
            buttonSobre.getStyleClass().setAll("btn-questao");
            buttonDM.getStyleClass().setAll("btn-LightMode");
        }
        
    }


    private void acaoDosBotoes() {
        buttonLista.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("telaQuestoes");
            }
            
        });

        buttonPDF.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                try{
                    File pdf = new File("..\\EstruturaDeDadosI\\EstruturaDeDadosI\\Lista1.pdf");
                    if (Desktop.isDesktopSupported()) {
                        Desktop.getDesktop().open(pdf);
                    }
                } catch(IOException e) {
                    System.out.println("Não foi possível abrir o pdf: " + e.getMessage());
                    e.printStackTrace();
                }
            }
            
        });

        buttonSobre.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("telaSobre");
            }
            
        });

        buttonDM.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (App.darkMode) {
                    App.darkMode = false;
                    setStilo();
                } else {
                    App.darkMode = true;
                    setStilo();
                }
            }
            
        });
    }
}
