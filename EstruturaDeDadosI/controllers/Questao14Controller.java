package controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import questoes.Questao14;

public class Questao14Controller extends BaseController{

    
    @FXML private BorderPane telaQuestao14;
    @FXML private Button buttonConfirmar;
    @FXML private Label copyRight;
    @FXML private Label labelTermoA;
    @FXML private Label labelTermoB;
    @FXML private Label labelTermoC;
    @FXML private Line divLine;
    @FXML private Text raiz;
    @FXML private Text sinalMaisOuMenos;
    @FXML private Text sinalMenos;
    @FXML private Text sinalTermoB;
    @FXML private Text sinalTermoC;
    @FXML private Text text2X;
    @FXML private Text textDeltaBhaskara;
    @FXML private Text textIgualZero;
    @FXML private Text textSeta;
    @FXML private Text textTermoA;
    @FXML private Text textTermoABhaskara;
    @FXML private Text textTermoB;
    @FXML private Text textTermoBBhaskara;
    @FXML private Text textTermoC;
    @FXML private Text textValX1;
    @FXML private Text textValX2;
    @FXML private Text textX;
    @FXML private Text textX1;
    @FXML private Text textX2;
    @FXML private Text textXQuadrado;
    @FXML private TextField tfTermoA;
    @FXML private TextField tfTermoB;
    @FXML private TextField tfTermoC;
    @FXML private VBox vBoxOutput;


    public void initialize() {
        BaseController.numQuestao = 14;
        super.initialize();
        acaoDosBotoes();
        setStilo(new Button[] { buttonConfirmar}, 
                 new Label[]  { labelTermoA, labelTermoB, labelTermoC},
                 new Pane[]   { telaQuestao14},
                 new Shape[]  { (Shape)divLine}, 
                 new Text[]   { raiz, sinalMaisOuMenos, sinalMenos, sinalTermoB, sinalTermoC, 
                                text2X, textDeltaBhaskara, textIgualZero, textSeta, textTermoA, 
                                textTermoABhaskara, textTermoB, textTermoBBhaskara, textTermoC, 
                                textValX1, textValX2, textX, textX1, textX2, textXQuadrado});
        vBoxOutput.setVisible(false);
    }





    private void acaoDosBotoes() {
        buttonConfirmar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (verificarInput()) {
                    Questao14.setTermoA(Double.parseDouble(tfTermoA.getText()));
                    Questao14.setTermoB(Double.parseDouble(tfTermoB.getText()));
                    Questao14.setTermoC(Double.parseDouble(tfTermoC.getText()));
                    try {
                        Questao14.calcularRaiz();
                        organizarOutput();
                        vBoxOutput.setVisible(true);
                    } catch (NumberFormatException exception) {
                        showPopup("Ocorreu um erro ao calcular a raiz, algum dos valores é inválido", false);
                    } 
                }
            }
        });

        tfTermoA.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent arg0) {
                vBoxOutput.setVisible(false);
            } 
        });
        tfTermoB.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent arg0) {
                vBoxOutput.setVisible(false);
            } 
        });
        tfTermoC.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent arg0) {
                vBoxOutput.setVisible(false);
            }
        });
    }

    
    private void organizarOutput() {
        if (tfTermoA.getText().contentEquals("1")) textTermoA.setText("");
        else textTermoA.setText(tfTermoA.getText());

        if (tfTermoA.getText().startsWith("-")) textTermoABhaskara.setText("(" + tfTermoA.getText() + ")");
        else textTermoABhaskara.setText(tfTermoA.getText());
        
        if (tfTermoB.getText().startsWith("-")) {
            sinalTermoB.setText("-");
            textTermoB.setText(tfTermoB.getText().replace("-", ""));
            textTermoBBhaskara.setText("(" + tfTermoB.getText() + ")");
        } else {
            sinalTermoB.setText("+");
            textTermoB.setText(tfTermoB.getText());
            textTermoBBhaskara.setText(tfTermoB.getText());
        }
        if (tfTermoC.getText().startsWith("-")) {
            sinalTermoC.setText("-");
            textTermoC.setText(tfTermoC.getText().replace("-", ""));
        } else {
            sinalTermoC.setText("+");
            textTermoC.setText(tfTermoC.getText());
        }

        textDeltaBhaskara.setText(String.valueOf(Questao14.getDelta()));

        textValX1.setText(String.valueOf(Questao14.getX1()));
        textValX2.setText(String.valueOf(Questao14.getX2()));
    }



    private boolean verificarInput() {
        if (tfTermoA.getText().matches("[a-zA-Z]+")) {
            showPopup("O valor inserido não é válido, tente novamente", false);
            return false;
        } else if (tfTermoA.getText().matches("[\\d^.]+")) { 
            double valor = Double.parseDouble(tfTermoA.getText());
            if (valor < 0) {
                showPopup("O termo A não pode ser 0 para uma equação de segundo grau", false);
                return false;
            }
        }
        if (tfTermoB.getText().matches("[a-zA-Z]+")) {
            showPopup("O valor inserido não é válido, tente novamente", false);
            return false;
        }
        if (tfTermoC.getText().matches("[a-zA-Z]+")) {
            showPopup("O valor inserido não é válido, tente novamente", false);
            return false;
        }
        return true;
    }
}