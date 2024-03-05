package br.edu.ufersa.controllers;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import br.edu.ufersa.App;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class TelaInicialController {
    
    @FXML private Button buttonDM;
    @FXML private Button buttonLista;
    @FXML private Button buttonPDF;
    @FXML private Button buttonSobre;
    @FXML private Label copyRight;
    @FXML private BorderPane telaInicial;

    private BaseController controller = new BaseController();

    @FXML
    public void initialize() {
        acaoDosBotoes();
        setStilo();
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
                    String path = App.class.getResource("Lista1.pdf").toString();
                    
                    if (path.startsWith("jar:")) path = path.replace("jar:", "");
                    if (path.contains("file:/")) path = path.replace("file:/", "");
                    System.out.println(path);

                    File pdf = new File(path);
                    Desktop desktop = Desktop.getDesktop();
                    if (Desktop.isDesktopSupported()) {
                        desktop.open(pdf);
                    }
                } catch(IOException e) {
                    controller.showPopup("Infelizmente não foi possível abrir o arquivo PDF", false, App.getJanela());
                    buttonPDF.setDisable(true);
                    System.out.println("Não foi possível abrir o pdf: " + e.getMessage());
                    System.out.println("\n\n");
                    e.printStackTrace();
                } catch (Exception e) {
                    controller.showPopup("Ocorreu um erro com o arquivo PDF", false, App.getJanela());
                    buttonDM.setDisable(true);
                    System.out.println("Mensagem de erro: " + e.getMessage());
                    System.out.println("\n\n");
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
}
