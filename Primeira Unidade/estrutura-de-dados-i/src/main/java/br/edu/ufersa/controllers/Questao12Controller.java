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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.util.Duration;
import br.edu.ufersa.questoes.Questao12;

public class Questao12Controller extends BaseController{
    
    @FXML private BorderPane telaQuestao12;
    @FXML private Button buttonConfirmar;
    @FXML private HBox hBoxInput;
    @FXML private Label copyRight;
    @FXML private Label labelNota1;
    @FXML private Label labelNota2;
    @FXML private Label labelNota3;
    @FXML private Line divLine;
    @FXML private Text textIgual;
    @FXML private Text textPlusSign1;
    @FXML private Text textPlusSign2;
    @FXML private Text textNota1;
    @FXML private Text textNota2;
    @FXML private Text textNota3;
    @FXML private Text textResultado;
    @FXML private Text textSitRes;
    @FXML private Text textSituacao;
    @FXML private Text textTres;
    @FXML private TextField tfNota1;
    @FXML private TextField tfNota2;
    @FXML private TextField tfNota3;
    @FXML private VBox vBoxOutput;


    public void initialize() {
        BaseController.numQuestao = 12;
        super.initialize();
        setStilo(new Button[] { buttonConfirmar}, 
                 new Label[]  { labelNota1, labelNota2, labelNota3}, 
                 new Pane[]   { telaQuestao12}, 
                 new Shape[]  { (Shape)divLine}, 
                 new Text[]   { textIgual, textPlusSign1, textPlusSign2, 
                                textNota1, textNota2, textNota3, 
                                textResultado, textSitRes, textSituacao, textTres});
        acaoDosBotoes();
        vBoxOutput.setVisible(false);
    }





    private void acaoDosBotoes() {
        Tooltip mensagemSubliminar = new Tooltip("Essa questão é ruim, a próxima é melhor");
        mensagemSubliminar.setShowDelay(Duration.millis(100));
        mensagemSubliminar.setShowDuration(Duration.seconds(1));
        Tooltip.install(copyRight, mensagemSubliminar);

        buttonConfirmar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (verificarInput()) {
                    Questao12.setNota1(Double.parseDouble(tfNota1.getText()));
                    Questao12.setNota2(Double.parseDouble(tfNota2.getText()));
                    Questao12.setNota3(Double.parseDouble(tfNota3.getText()));

                    textNota1.setText(tfNota1.getText());
                    textNota2.setText(tfNota2.getText());
                    textNota3.setText(tfNota3.getText());
                    textSitRes.setText(Questao12.calcularMedia());
                    textResultado.setText(String.valueOf(Questao12.getMedia()));

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
        if (tfNota1.getText().isEmpty() || tfNota2.getText().isEmpty() || tfNota3.getText().isEmpty()) {
            showPopup("Os campos não podem ser vazios, preencha e tente novamente", false);
            return false;
        }

        if (tfNota1.getText().matches("[a-zA-Z]+")) {
            showPopup("O valor inserido não é válido, tente novamente", false);
            return false;
        } else if (tfNota1.getText().matches("[\\d^.]+")) { 
            double valor = Double.parseDouble(tfNota1.getText());
            if (valor < 0) {
                showPopup("O valor não pode ser 0", false);
                return false;
            }
        }
        if (tfNota2.getText().matches("[a-zA-Z]+")) {
            showPopup("O valor inserido não é válido, tente novamente", false);
            return false;
        } else if (tfNota2.getText().matches("[\\d^.]+")) { 
            double valor = Double.parseDouble(tfNota2.getText());
            if (valor < 0) {
                showPopup("O valor não pode ser 0", false);
                return false;
            }
        }
        if (tfNota3.getText().matches("[a-zA-Z]+")) {
            showPopup("O valor inserido não é válido, tente novamente", false);
            return false;
        } else if (tfNota3.getText().matches("[\\d^.]+")) { 
            double valor = Double.parseDouble(tfNota3.getText());
            if (valor < 0) {
                showPopup("O valor não pode ser 0", false);
                return false;
            }
        }
        return true;
    }
}