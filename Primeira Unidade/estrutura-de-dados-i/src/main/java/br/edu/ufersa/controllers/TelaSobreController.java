package br.edu.ufersa.controllers;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.util.Duration;
import br.edu.ufersa.App;

public class TelaSobreController {
    
    @FXML private BorderPane telaSobre;
    @FXML private Button buttonGitHub;
    @FXML private Button buttonLinkedIn;
    @FXML private Button buttonTwitter;
    @FXML private Button buttonVoltar;
    @FXML private Label copyRight;
    @FXML private Text textLink;
    @FXML private Text textPara1;
    @FXML private Text textPara2;
    @FXML private Text textSobre;


    
    public void initialize() {
        acaoDosBotoes();
        setStilo();
    }


    private void setStilo() {
        if (App.darkMode) {
            buttonGitHub.getStyleClass().setAll("btn-GitHub-DM");
            buttonLinkedIn.getStyleClass().setAll("btn-LinkedIn-DM");
            buttonTwitter.getStyleClass().setAll("btn-Twitter-DM");
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            telaSobre.setStyle("-fx-background-color: #282828");
            textLink.setFill(Paint.valueOf("WHITE"));
            textPara1.setFill(Paint.valueOf("WHITE"));
            textPara2.setFill(Paint.valueOf("WHITE"));
            textSobre.setFill(Paint.valueOf("WHITE"));
        } else {
            buttonGitHub.getStyleClass().setAll("btn-GitHub");
            buttonLinkedIn.getStyleClass().setAll("btn-LinkedIn");
            buttonTwitter.getStyleClass().setAll("btn-Twitter");
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            telaSobre.setStyle(null);
            textLink.setFill(Paint.valueOf("BLACK"));
            textPara1.setFill(Paint.valueOf("BLACK"));
            textPara2.setFill(Paint.valueOf("BLACK"));
            textSobre.setFill(Paint.valueOf("BLACK"));
        }
    }


    private void acaoDosBotoes() {
        Tooltip tGitHub = new Tooltip("Link do repositório do programa");
        tGitHub.setShowDelay(Duration.millis(200));

        Tooltip tLinkedIn = new Tooltip("Link do perfil do LinkedIn");
        tLinkedIn.setShowDelay(Duration.millis(200));

        Tooltip tTwitter = new Tooltip("Link do perfil do Twitter");
        tTwitter.setShowDelay(Duration.millis(200));

        Tooltip tmensagemSubliminar = new Tooltip("Se gostou, favorita lá no GitHub. XD");
        tmensagemSubliminar.setShowDelay(Duration.millis(200));
        tmensagemSubliminar.setShowDuration(Duration.millis(700));
        Tooltip.install(copyRight, tmensagemSubliminar);

        buttonGitHub.setTooltip(tGitHub);
        buttonLinkedIn.setTooltip(tLinkedIn);
        buttonTwitter.setTooltip(tTwitter);

        
        buttonVoltar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("telaInicial");
            }
        });

        buttonGitHub.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                try{
                    String url = "https://github.com/Doiderazada/EstruturaDeDadosI";
                    Desktop desktop = Desktop.getDesktop();
                    if (Desktop.isDesktopSupported()) {
                        desktop.browse(new URI(url));
                    }
                } catch(IOException | URISyntaxException e) {
                    System.out.println("Não foi possível abrir o endereço especificado: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        buttonLinkedIn.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                try{
                    String url = "https://www.linkedin.com/in/jo%C3%A3o-emanoel-75007029b/";
                    Desktop desktop = Desktop.getDesktop();
                    if (Desktop.isDesktopSupported()) {
                        desktop.browse(new URI(url));
                    }
                } catch(IOException | URISyntaxException e) {
                    System.out.println("Não foi possível abrir o endereço especificado: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        });
        buttonTwitter.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                try{
                    String url = "https://twitter.com/jao_doidera";
                    Desktop desktop = Desktop.getDesktop();
                    if (Desktop.isDesktopSupported()) {
                        desktop.browse(new URI(url));
                    }
                } catch(IOException | URISyntaxException e) {
                    System.out.println("Não foi possível abrir o endereço especificado: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }
}
