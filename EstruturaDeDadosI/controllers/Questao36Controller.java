package controllers;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.util.Duration;
import questoes.EnunciadoDasQuestoes;
import questoes.Questao23;
import questoes.Questao36;
import source.App;

public class Questao36Controller {

    
    @FXML private BorderPane telaQuestao36;
    @FXML private Button buttonCalcular;
    @FXML private Button buttonConfirmar;
    @FXML private Button buttonHome;
    @FXML private Button buttonVisualizar;
    @FXML private Button buttonVoltar;
    @FXML private Label copyRight;
    @FXML private HBox hBoxElements;
    @FXML private Label labelFator;
    @FXML private Text questao;
    @FXML private Text textEnunciado;
    @FXML private Text textResposta;
    @FXML private TextField tfFator;
    @FXML private VBox vBoxButtons;
    @FXML private VBox vBoxInput;


    int fatorial;
    int fator;

    public void initialize() {
        acaoDosBotoes();
        setStilo();
        exibirConteudo();
        estadoInicial();
    }




    private void estadoInicial() {
        hBoxElements.getChildren().removeAll(vBoxInput, textResposta);
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

        buttonCalcular.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0){
                if (hBoxElements.getChildren().contains(vBoxInput)) hBoxElements.getChildren().remove(vBoxInput);
                if (hBoxElements.getChildren().contains(textResposta)) hBoxElements.getChildren().remove(textResposta);

                tfFator.clear();
                hBoxElements.getChildren().addAll(vBoxInput);
                
            }
        });
        buttonVisualizar.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent arg0) {
                if (hBoxElements.getChildren().contains(textResposta)) hBoxElements.getChildren().remove(textResposta);

                fator = Integer.parseInt(tfFator.getText());
                fatorial = Questao23.calcularFatorial(fator);
                textResposta.setText("O fatorial de " + fator + " é igual a " + Questao36.calcularFatorial(fator));
                hBoxElements.getChildren().addAll(textResposta);
            }
        });


        buttonConfirmar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if(calcularFatorial()) buttonVisualizar.setDisable(false);

                hBoxElements.getChildren().remove(vBoxInput);
                hBoxElements.getChildren().addAll(textResposta);
            }
            
        });

        
    }

    
    private boolean calcularFatorial(){
        if (verificarInput()) {
            textResposta.setText("O fatorial foi calculado com sucesso!");
            return true;
        } else {
            showPopup("Não foi possível calcular o fatorial...");
            return false;
        }
        
    }



    private boolean verificarInput() {
        
        if (tfFator.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente");
            return false;
        } else if (tfFator.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras");
            return false;
        } 
        // else if (tfNumero.getText().matches("[0-9]+")) {
        //     int num =  Integer.parseInt(tfNumero.getText());
        //     if (num < 1) {
        //         showPopup("O número não pode ser menor que 1");
        //         return false;
        //     }
        // }

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
            
            double winX = buttonHome.getScene().getWindow().getX();
            double winY = buttonHome.getScene().getWindow().getY();
            double halfX = buttonHome.getScene().getWindow().getWidth()/2;
            double halfY = buttonHome.getScene().getWindow().getHeight()/2;

            double newX = (winX + halfX) - (popup.getWidth()/2);
            double newY = (winY + halfY) - (popup.getHeight()/2);

            popup.setX(newX);
            popup.setY(newY);
            
            
            popup.show(buttonHome.getScene().getWindow());

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
        textEnunciado.setText(EnunciadoDasQuestoes.questao36.substring(3));
    }


    
    private void setStilo() {
        if (App.darkMode) {
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            buttonHome.getStyleClass().setAll("btn-questao-DM");
            buttonCalcular.getStyleClass().setAll("btn-questao-DM");
            buttonConfirmar.getStyleClass().setAll("btn-questao-DM");
            buttonVisualizar.getStyleClass().setAll("btn-questao-DM");
            telaQuestao36.setStyle("-fx-background-color: #282828");

            labelFator.setTextFill(Paint.valueOf("WHITE"));
            
            questao.setFill(Paint.valueOf("WHITE"));
            textEnunciado.setFill(Paint.valueOf("WHITE"));
            textResposta.setFill(Paint.valueOf("WHITE"));
            
        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            buttonConfirmar.getStyleClass().setAll("btn-questao");
            telaQuestao36.setStyle(null);

            labelFator.setTextFill(Paint.valueOf("BLACK"));
            
            questao.setFill(Paint.valueOf("BLACK"));
            textEnunciado.setFill(Paint.valueOf("BLACK"));
            textResposta.setFill(Paint.valueOf("BLACK"));
        }
    }
}