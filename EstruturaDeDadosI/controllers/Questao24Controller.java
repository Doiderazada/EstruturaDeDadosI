package controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import questoes.Questao24;

public class Questao24Controller extends BaseController{

    
    @FXML private BorderPane telaQuestao24;
    @FXML private Button buttonCalcFatorial;
    @FXML private Button buttonCalcPotencia;
    @FXML private Button buttonCalcRaiz;
    @FXML private Button buttonFatorial;
    @FXML private Button buttonPotencia;
    @FXML private Button buttonRaiz;
    @FXML private HBox hBoxParent;
    @FXML private Label copyRight;
    @FXML private Label labelBase;
    @FXML private Label labelExpoente;
    @FXML private Label labelFatorial;
    @FXML private Label labelRaiz;
    @FXML private Text textResposta;
    @FXML private TextField tfBase;
    @FXML private TextField tfExpoente;
    @FXML private TextField tfFatorial;
    @FXML private TextField tfRaiz;
    @FXML private VBox vBoxButtons;
    @FXML private VBox vBoxFatorial;
    @FXML private VBox vBoxPotencia;
    @FXML private VBox vBoxRaiz;


    private int resultadoFatorial;
    private double resultadoPotencia;
    private double resultadoRaiz;
    private boolean fatorial = false, potencia = false, raiz = false;

    public void initialize() {
        BaseController.numQuestao = 24;
        super.initialize();
        acaoDosBotoes();
        setStilo(new Button[] { buttonCalcFatorial, buttonCalcPotencia, buttonCalcRaiz, 
                                buttonFatorial, buttonPotencia, buttonRaiz},
                 new Label[]  { labelBase, labelExpoente, labelFatorial, labelRaiz}, 
                 new Pane[]   { telaQuestao24}, null,
                 new Text[]   { textResposta});
        estadoInicial();
    }





    private void estadoInicial() {
        hBoxParent.getChildren().removeAll(vBoxFatorial, vBoxPotencia, vBoxRaiz, textResposta);
        tfBase.clear();
        tfExpoente.clear();
        tfFatorial.clear();
        tfRaiz.clear();
    }





    private void acaoDosBotoes() {
        buttonFatorial.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                estadoInicial();
                hBoxParent.getChildren().add(vBoxFatorial);
            }
        });
        buttonPotencia.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                estadoInicial();
                hBoxParent.getChildren().add(vBoxPotencia);
            }
        });
        buttonRaiz.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                estadoInicial();
                hBoxParent.getChildren().add(vBoxRaiz);
            }
        });


        buttonCalcFatorial.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (verificarFator()) {
                    int fator = Integer.parseInt(tfFatorial.getText());
                    resultadoFatorial = Questao24.calcFactor(fator);

                    textResposta.setText("O resultado é: " + resultadoFatorial);
                    fatorial = true; potencia = false; raiz = false;

                    hBoxParent.getChildren().remove(vBoxFatorial);
                    hBoxParent.getChildren().add(textResposta);
                }
            }
        });
        buttonCalcPotencia.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (verificarPotencia()) {
                    int base = Integer.parseInt(tfBase.getText());
                    int expoente = Integer.parseInt(tfExpoente.getText());
                    resultadoPotencia = Questao24.calcPower(base, expoente);

                    textResposta.setText("O resultado é: " + resultadoPotencia);
                    fatorial = false; potencia = true; raiz = false;
                    
                    hBoxParent.getChildren().remove(vBoxPotencia);
                    hBoxParent.getChildren().add(textResposta);
                }
            }
        });
        buttonCalcRaiz.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (verificarRaiz()) {
                    int radical = Integer.parseInt(tfRaiz.getText());
                    resultadoRaiz = Questao24.calcRoot(radical);

                    textResposta.setText("O resultado é: " + resultadoRaiz);
                    fatorial = false; potencia = false; raiz = true;
                    
                    hBoxParent.getChildren().remove(vBoxRaiz);
                    hBoxParent.getChildren().add(textResposta);
                }
            }
        });


        Tooltip texto = new Tooltip("Texto copiado com sucesso");
        textResposta.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                
                Tooltip.install(textResposta, texto);
                
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();

                if (fatorial) {
                    content.putString(String.valueOf(resultadoFatorial));
                    clipboard.setContent(content);
                }
                if (potencia) {
                    content.putString(String.valueOf(resultadoPotencia));
                    clipboard.setContent(content);
                }
                if (raiz) {
                    content.putString(String.valueOf(resultadoRaiz));
                    clipboard.setContent(content);
                }
                
                texto.setAutoHide(true);
                texto.fireEvent(arg0);
                texto.centerOnScreen();

                texto.show(telaQuestao24.getScene().getWindow());
            }
        });
        textResposta.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                texto.hide();
                Tooltip.uninstall(textResposta, texto);
            }
        });
    }

    
    



    private boolean verificarFator() {
        
        if (tfFatorial.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        } else if (tfFatorial.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras", false);
            return false;
        } else if (tfFatorial.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfFatorial.getText());
            if (num < 0) {
                showPopup("O número não pode ser negativo", false);
                return false;
            }
        }
        return true;
    }
    private boolean verificarPotencia() {
        if (tfExpoente.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        } else if (tfExpoente.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras", false);
            return false;
        }
        if (tfBase.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        } else if (tfBase.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras", false);
            return false;
        }
        return true;
    }
    private boolean verificarRaiz() {
        if (tfRaiz.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        } else if (tfRaiz.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras", false);
            return false;
        } else if (tfRaiz.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfRaiz.getText());
            if (num < 1) {
                showPopup("O número não pode ser menor que 1", false);
                return false;
            }
        }
        return true;
    }
}