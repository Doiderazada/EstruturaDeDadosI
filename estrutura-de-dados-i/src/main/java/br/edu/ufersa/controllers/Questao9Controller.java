package br.edu.ufersa.controllers;

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
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.util.Duration;
import br.edu.ufersa.questoes.Questao9;

public class Questao9Controller extends BaseController{
    

    @FXML private BorderPane telaQuestao9;
    @FXML private Button buttonConfirmar;
    @FXML private Circle circulo;
    @FXML private Label copyRight;
    @FXML private Label labelRaio;
    @FXML private Line lineRaio;
    @FXML private HBox outputHBox;
    @FXML private Text textArea;
    @FXML private Text textC;
    @FXML private Text textCirc;
    @FXML private Text textR;
    @FXML private Text textRaio;
    @FXML private Text textResultArea;
    @FXML private Text textResultCirc;
    @FXML private Text textResultRaio;
    @FXML private TextField tfRaio;


    public void initialize() {
        BaseController.numQuestao = 9;
        super.initialize();
        setStilo(new Button[] { buttonConfirmar}, 
                 new Label[]  { labelRaio}, 
                 new Pane[]   { telaQuestao9}, 
                 new Shape[]  {(Shape)lineRaio, circulo}, 
                 new Text[]   { textArea, textC, textCirc, textR, textRaio, 
                                textResultArea, textResultCirc, textResultRaio});
        acaoDosBotoes();
        outputHBox.setVisible(false);
    }





    private void acaoDosBotoes() {
        Tooltip texto = new Tooltip("Texto copiado");
        Tooltip.install(textResultArea, texto);
        Tooltip.install(textResultCirc, texto);
        Tooltip.install(textResultRaio, texto);
        Tooltip unidade = new Tooltip("Unidades de medida");
        unidade.setShowDelay(Duration.millis(100));
        Tooltip.install(textResultArea, unidade);
        Tooltip.install(textResultCirc, unidade);
        Tooltip.install(textResultRaio, unidade);

        buttonConfirmar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (verificarInput()) {
                    Questao9.setRaio(Double.valueOf(tfRaio.getText()));

                    textResultRaio.setText(String.valueOf(Questao9.getRaio()) + " u.m");
                    textResultCirc.setText(String.valueOf(Questao9.medirCircunferencia()) + " u.m");
                    textResultArea.setText(String.valueOf(Questao9.medirArea()) + " u.m²");

                    outputHBox.setVisible(true);
                }
            }
        });

        
        textResultArea.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(textResultArea.getText());
                clipboard.setContent(content);

                texto.setAutoHide(true);
                texto.fireEvent(arg0);
                texto.centerOnScreen();

                texto.show(telaQuestao9.getScene().getWindow());
            }
        });
        textResultArea.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                texto.hide();
            }
        });

        textResultCirc.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(textResultCirc.getText());
                clipboard.setContent(content);

                texto.setAutoHide(true);
                texto.fireEvent(arg0);
                texto.centerOnScreen();

                texto.show(telaQuestao9.getScene().getWindow());
            }
        });
        textResultCirc.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                texto.hide();
            }
        });
        
        textResultRaio.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(textResultRaio.getText());
                clipboard.setContent(content);

                texto.setAutoHide(true);
                texto.fireEvent(arg0);
                texto.centerOnScreen();

                texto.show(telaQuestao9.getScene().getWindow());
            }
        });
        textResultRaio.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                texto.hide();
            }
        });
    }

    

    private boolean verificarInput() {
        if (tfRaio.getText().matches("[a-zA-Z]+")) {
            showPopup("O valor inserido não é válido, tente novamente", false);
            return false;
        } else if (tfRaio.getText().matches("[0-9^.]+")) { 
            double raio = Double.parseDouble(tfRaio.getText());

            if (raio <= 0) {
                showPopup("Valor do raio é inválido", false);
                return false;
            }
        }
        return true;
    }
}