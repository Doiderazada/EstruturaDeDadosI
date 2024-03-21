package br.edu.ufersa.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import br.edu.ufersa.questoes.Questao36;

public class Questao36Controller extends BaseController{

    
    @FXML private BorderPane telaQuestao36;
    @FXML private Button buttonCalcular;
    @FXML private Button buttonConfirmar;
    @FXML private Button buttonVisualizar;
    @FXML private HBox hBoxElements;
    @FXML private Label copyRight;
    @FXML private Label labelFator;
    @FXML private Text questao;
    @FXML private Text textEnunciado;
    @FXML private Text textResposta;
    @FXML private TextField tfFator;
    @FXML private VBox vBoxButtons;
    @FXML private VBox vBoxInput;


    private double fatorial;
    private int fator;

    public void initialize() {
        BaseController.numQuestao = 36;
        super.initialize();
        acaoDosBotoes();
        setStilo(new Button[] { buttonCalcular, buttonConfirmar, buttonVisualizar},
                 new Label[]  { labelFator}, 
                 new Pane[]   { telaQuestao36}, null,
                 new Text[]   { textResposta});
        estadoInicial();
    }



    private void estadoInicial() {
        hBoxElements.getChildren().removeAll(vBoxInput, textResposta);
        buttonVisualizar.setDisable(true);
    }



    private void acaoDosBotoes() {

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
                fatorial = Questao36.calcularFatorial(fator);
                textResposta.setText("O fatorial de " + fator + " é igual a " + fatorial);
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
            showPopup("Não foi possível calcular o fatorial...", false);
            return false;
        }
        
    }



    private boolean verificarInput() {
        
        if (tfFator.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        } else if (tfFator.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras", false);
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
}