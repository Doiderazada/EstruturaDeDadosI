package controllers;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.util.Duration;
import questoes.EnunciadoDasQuestoes;
import questoes.Questao37;
import source.App;

public class Questao37Controller {


    @FXML private BorderPane telaQuestao37;
    @FXML private Button buttonCalcular;
    @FXML private Button buttonConfirmar;
    @FXML private Button buttonHome;
    @FXML private Button buttonVisualizar;
    @FXML private Button buttonVoltar;
    @FXML private HBox hBoxElements;
    @FXML private Label copyRight;
    @FXML private Label labelNumFin;
    @FXML private Label labelNumIni;
    @FXML private Pane paneTeste;
    @FXML private ScrollPane sPaneResposta;
    @FXML private Text questao;
    @FXML private Text textConfirm;
    @FXML private Text textEnunciado;
    @FXML private Text textFor;
    @FXML private Text textRecursao;
    @FXML private Text textWhile;
    @FXML private TextField tfNumFin;
    @FXML private TextField tfNumIni;
    @FXML private VBox vBoxButtons;
    @FXML private VBox vBoxInput;

    private int valorInicial;
    private int valorFinal;

    public void initialize() {
        acaoDosBotoes();
        setStilo();
        exibirConteudo();
        estadoInicial();
    }


    private void estadoInicial(){
        hBoxElements.getChildren().removeAll(vBoxInput, textConfirm, sPaneResposta);
        buttonVisualizar.setDisable(true);
    }


    private void acaoDosBotoes() {

        buttonVoltar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("telaQuestoes");
            }
            
        });
        
        buttonHome.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("telaInicial");
            }
            
        });

        buttonCalcular.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent arg0){
                if(hBoxElements.getChildren().contains(vBoxInput)) hBoxElements.getChildren().remove(vBoxInput);
                if(hBoxElements.getChildren().contains(textConfirm)) hBoxElements.getChildren().remove(textConfirm);
                if(hBoxElements.getChildren().contains(sPaneResposta)) hBoxElements.getChildren().remove(sPaneResposta);
                
                tfNumFin.clear();
                tfNumIni.clear();
                hBoxElements.getChildren().add(vBoxInput);
            }
        });
        buttonVisualizar.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent arg0){
                if(hBoxElements.getChildren().contains(vBoxInput)) hBoxElements.getChildren().remove(vBoxInput);
                if(hBoxElements.getChildren().contains(textConfirm)) hBoxElements.getChildren().remove(textConfirm);
                if(hBoxElements.getChildren().contains(sPaneResposta)) hBoxElements.getChildren().remove(sPaneResposta);
                
                textFor.setText(String.valueOf("Resultado do somatório com laço for: " + 
                                                Questao37.calcularComLoopFor(valorInicial, valorFinal)));
                textWhile.setText(String.valueOf("Resultado do somatório com laço while: " + 
                                                  Questao37.calcularComLoopWhile(valorInicial, valorFinal)));
                textRecursao.setText(String.valueOf("Resultado do somatório com recusão: " + 
                                                     Questao37.calcularComRecursao(valorInicial, valorFinal)));

                hBoxElements.getChildren().addAll(sPaneResposta);
            }
        });

        buttonConfirmar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (verificarInput()) {
                    valorInicial = Integer.parseInt(tfNumIni.getText());
                    valorFinal = Integer.parseInt(tfNumFin.getText());

                    hBoxElements.getChildren().remove(vBoxInput);
                    textConfirm.setText("Valores cadastrados com sucesso!");
                    hBoxElements.getChildren().addAll(textConfirm);
                    if (buttonVisualizar.isDisabled()) buttonVisualizar.setDisable(false);
                }
            }
            
        });

    
    }

    
    



    private boolean verificarInput() {
        
        if (tfNumIni.getText().isBlank()) {
            showPopup("O campo não pode ser vazio, tente novamente");
            return false;
        }
        if (tfNumIni.getText().matches("[\\D]+")) {
            showPopup("O campo não pode conter letras, tente novamente");
            return false;
        }
        
        if (tfNumFin.getText().isBlank()) {
            showPopup("O campo não pode ser vazio, tente novamente");
            return false;
        }
        if (tfNumFin.getText().matches("[\\D]+")) {
            showPopup("O campo não pode conter letras, tente novamente");
            return false;
        }

        return true;
    }





    private void showPopup(String texto) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/telaPopupErro.fxml"));
            Parent root = loader.load();

            TelaPopupErroController controller = loader.getController();
            controller.initialize(texto);
            Popup popup = new Popup();

            popup.getContent().add(root);
            popup.setAutoHide(true);
            popup.setHideOnEscape(true);
            
            double winX = buttonConfirmar.getScene().getWindow().getX();
            double winY = buttonConfirmar.getScene().getWindow().getY();
            double halfX = buttonConfirmar.getScene().getWindow().getWidth()/2;
            double halfY = buttonConfirmar.getScene().getWindow().getHeight()/2;

            double newX = (winX + halfX) - (popup.getWidth()/2);
            double newY = (winY + halfY) - (popup.getHeight()/2);

            popup.setX(newX);
            popup.setY(newY);
            
            
            popup.show(buttonConfirmar.getScene().getWindow());

            PauseTransition closeDelay = new PauseTransition(Duration.seconds(3));
            closeDelay.setOnFinished(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent arg0) {
                    popup.hide();
                }
            });
            closeDelay.play();

            
        }catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }





    private void exibirConteudo() { 
        questao.setText(questao.getText() + "\t");
        textEnunciado.setText(EnunciadoDasQuestoes.questao37.substring(3));
    }


    
    private void setStilo() {
        if (App.darkMode) {
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            buttonHome.getStyleClass().setAll("btn-questao-DM");
            buttonCalcular.getStyleClass().setAll("btn-questao-DM");
            buttonConfirmar.getStyleClass().setAll("btn-questao-DM");
            buttonVisualizar.getStyleClass().setAll("btn-questao-DM");
            telaQuestao37.setStyle("-fx-background-color: #282828");
            paneTeste.setStyle("-fx-background-color: #282828");

            labelNumFin.setTextFill(Paint.valueOf("WHITE"));
            labelNumIni.setTextFill(Paint.valueOf("WHITE"));
            
            questao.setFill(Paint.valueOf("WHITE"));
            textConfirm.setFill(Paint.valueOf("WHITE"));
            textEnunciado.setFill(Paint.valueOf("WHITE"));
            textFor.setFill(Paint.valueOf("WHITE"));
            textWhile.setFill(Paint.valueOf("WHITE"));
            textRecursao.setFill(Paint.valueOf("WHITE"));
            
        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            buttonCalcular.getStyleClass().setAll("btn-questao");
            buttonConfirmar.getStyleClass().setAll("btn-questao");
            buttonVisualizar.getStyleClass().setAll("btn-questao");
            telaQuestao37.setStyle(null);
            paneTeste.setStyle(null);


            labelNumFin.setTextFill(Paint.valueOf("BLACK"));
            labelNumIni.setTextFill(Paint.valueOf("BLACK"));
            
            questao.setFill(Color.BLACK);
            textConfirm.setFill(Color.BLACK);
            textEnunciado.setFill(Color.BLACK);
            textFor.setFill(Color.BLACK);
            textWhile.setFill(Color.BLACK);
            textRecursao.setFill(Color.BLACK);
            
        }
    }
}