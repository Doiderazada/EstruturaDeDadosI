package br.edu.ufersa.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import br.edu.ufersa.questoes.Questao37;

public class Questao37Controller extends BaseController{


    @FXML private BorderPane telaQuestao37;
    @FXML private Button buttonCalcular;
    @FXML private Button buttonConfirmar;
    @FXML private Button buttonVisualizar;
    @FXML private HBox hBoxElements;
    @FXML private Label copyRight;
    @FXML private Label labelNumFin;
    @FXML private Label labelNumIni;
    @FXML private Pane paneTeste;
    @FXML private ScrollPane sPaneResposta;
    @FXML private Text textConfirm;
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
        BaseController.numQuestao = 37;
        super.initialize();
        acaoDosBotoes();
        setStilo(new Button[]{ buttonCalcular, buttonConfirmar, buttonVisualizar},
                 new Label[] { labelNumFin, labelNumIni},
                 new Pane[]  { paneTeste, telaQuestao37}, null,
                 new Text[]  { textConfirm, textFor, textRecursao, textWhile});
        estadoInicial();
    }


    
    private void estadoInicial(){
        hBoxElements.getChildren().removeAll(vBoxInput, textConfirm, sPaneResposta);
        buttonVisualizar.setDisable(true);
    }


    private void acaoDosBotoes() {

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
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        }
        if (tfNumIni.getText().matches("[\\D]+")) {
            showPopup("O campo não pode conter letras, tente novamente", false);
            return false;
        }
        
        if (tfNumFin.getText().isBlank()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        }
        if (tfNumFin.getText().matches("[\\D]+")) {
            showPopup("O campo não pode conter letras, tente novamente", false);
            return false;
        }
        return true;
    }
}