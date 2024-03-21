package br.edu.ufersa.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.util.Duration;
import br.edu.ufersa.questoes.Questao13;

public class Questao13Controller extends BaseController{

    @FXML private BorderPane telaQuestao13;
    @FXML private Button buttonConfirmar;
    @FXML private Label copyRight;
    @FXML private Label labelNota1;
    @FXML private Label labelNota2;
    @FXML private Label labelNota3;
    @FXML private Line divLine;
    @FXML private Text textIgual;
    @FXML private Text textNota1;
    @FXML private Text textNota2;
    @FXML private Text textNota3;
    @FXML private Text textNota4;
    @FXML private Text textNotaMin;
    @FXML private Text textPlusSign1;
    @FXML private Text textPlusSign2;
    @FXML private Text textResultado;
    @FXML private Text textSitRes;
    @FXML private Text textSituacao;
    @FXML private Text textTres;
    @FXML private TextField tfNota1;
    @FXML private TextField tfNota2;
    @FXML private TextField tfNota3;
    @FXML private VBox vBoxOutput;


    public void initialize() {
        BaseController.numQuestao = 13;
        super.initialize();
        setStilo(new Button[] { buttonConfirmar}, 
                 new Label[]  { labelNota1, labelNota2, labelNota3}, 
                 new Pane[]   { telaQuestao13}, 
                 new Shape[]  { (Shape)divLine}, 
                 new Text[]   { textIgual, textNota1, textNota2, textNota3, textNota4, textNotaMin, 
                                textPlusSign1, textPlusSign2, textResultado, textSitRes, textSituacao, textTres});
        acaoDosBotoes();
        vBoxOutput.setVisible(false);
    }





    private void acaoDosBotoes() {
        Tooltip mensagemSubliminar = new Tooltip("Agora sim, essa é melhor");
        mensagemSubliminar.setShowDelay(Duration.millis(100));
        mensagemSubliminar.setShowDuration(Duration.millis(800));
        Tooltip.install(copyRight, mensagemSubliminar);

        buttonConfirmar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (verificarInput()) {
                    Questao13.setNota1(Double.parseDouble(tfNota1.getText()));
                    Questao13.setNota2(Double.parseDouble(tfNota2.getText()));
                    Questao13.setNota3(Double.parseDouble(tfNota3.getText()));
                    textNota1.setText(tfNota1.getText());
                    textNota2.setText(tfNota2.getText());
                    textNota3.setText(tfNota3.getText());

                    textSitRes.setText(Questao13.calcularMedia());
                    textResultado.setText(String.valueOf(Questao13.getMedia()));

                    if (textSitRes.getText().contentEquals("Aluno aprovado")) {
                        textNotaMin.setVisible(false);
                        textNota4.setVisible(false);
                    } else {
                        textNotaMin.setVisible(true);
                        textNota4.setVisible(true);
                    }
                    textNota4.setText(String.valueOf(Questao13.getNota4()));
                    vBoxOutput.setVisible(true);
                }
            }
        });

        tfNota1.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent arg0) {
                vBoxOutput.setVisible(false);
            }
        });
        tfNota2.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent arg0) {
                vBoxOutput.setVisible(false);
            }
        });
        tfNota3.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent arg0) {
                vBoxOutput.setVisible(false);
            }
        });
    }

    

    private boolean verificarInput() {
        if (tfNota1.getText().matches("[a-zA-Z]+")) {
            showPopup("O valor inserido não é válido, tente novamente", false);
            return false;
        } else if (tfNota1.getText().matches("[\\d^.]+")) { 
            double valor = Double.parseDouble(tfNota1.getText());
            if (valor < 0) {
                showPopup("O valor não pode ser menor que 0", false);
                return false;
            }
            if (valor > 10) {
                showPopup("O Valor não pode ultrapassar 10", false);
                return false;
            }
        }
        if (tfNota2.getText().matches("[a-zA-Z]+")) {
            showPopup("O valor inserido não é válido, tente novamente", false);
            return false;
        } else if (tfNota2.getText().matches("[\\d^.]+")) { 
            double valor = Double.parseDouble(tfNota2.getText());
            if (valor < 0) {
                showPopup("O valor não pode ser menor que 0", false);
                return false;
            }
            if (valor > 10) {
                showPopup("O Valor não pode ultrapassar 10", false);
                return false;
            }
        }
        if (tfNota3.getText().matches("[a-zA-Z]+")) {
            showPopup("O valor inserido não é válido, tente novamente", false);
            return false;
        } else if (tfNota3.getText().matches("[\\d^.]+")) { 
            double valor = Double.parseDouble(tfNota3.getText());
            if (valor < 0) {
                showPopup("O valor não pode ser menor que 0", false);
                return false;
            }
            if (valor > 10) {
                showPopup("O Valor não pode ultrapassar 10", false);
                return false;
            }
        }
        return true;
    }
}