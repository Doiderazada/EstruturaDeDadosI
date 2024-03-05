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
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import br.edu.ufersa.questoes.Questao3;

public class Questao3Controller extends BaseController{
    
    
    @FXML private BorderPane telaQuestao3;
    @FXML private Button buttonConfirmar;
    @FXML private HBox hBoxOutput;
    @FXML private Label copyRight;
    @FXML private Label labelValA;
    @FXML private Label labelValB;
    @FXML private Text textDivisao;
    @FXML private Text textMultiplicacao;
    @FXML private Text textResto;
    @FXML private Text textResultadoDiv;
    @FXML private Text textResultadoMod;
    @FXML private Text textResultadoMult;
    @FXML private Text textResultadoSoma;
    @FXML private Text textResultadoSub;
    @FXML private Text textSoma;
    @FXML private Text textSubtracao;
    @FXML private TextField tfValA;
    @FXML private TextField tfValB;
    @FXML private VBox vBoxInput;


    private final Tooltip texto = new Tooltip("Texto copiado");

    public void initialize() {
        BaseController.numQuestao = 3;
        super.initialize();
        setStilo(new Button[] { buttonConfirmar}, 
                 new Label[]  { labelValA, labelValB}, 
                 new Pane[]   { telaQuestao3}, null, 
                 new Text[]   { textDivisao, textMultiplicacao, textResto, textResultadoDiv, textResultadoMod, 
                                textResultadoMult, textResultadoSoma, textResultadoSub, textSoma, textSubtracao});
        acaoDosBotoes();
        hBoxOutput.setVisible(false);
        vBoxInput.setVisible(true);
    }





    private void acaoDosBotoes() {
        buttonConfirmar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                Questao3.setValA(Integer.valueOf(tfValA.getText()));                
                Questao3.setValB(Integer.valueOf(tfValB.getText()));

                textSoma.setText(tfValA.getText() + " + " + tfValB.getText() + " = ");
                textSubtracao.setText(tfValA.getText() + " - " + tfValB.getText() + " = ");
                textMultiplicacao.setText(tfValA.getText() + " * " + tfValB.getText() + " = ");
                textDivisao.setText(tfValA.getText() + " / " + tfValB.getText() + " = ");
                textResto.setText(tfValA.getText() + " % " + tfValB.getText() + " = ");
                
                textResultadoSoma.setText(String.valueOf(Questao3.somar()));
                textResultadoSub.setText(String.valueOf(Questao3.subtrair()));
                textResultadoMult.setText(String.valueOf(Questao3.multiplicar()));
                textResultadoDiv.setText(String.valueOf(Questao3.dividir()));
                textResultadoMod.setText(String.valueOf(Questao3.modulo()));

                hBoxOutput.setVisible(true);
            }
        });


        textResultadoSoma.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                copiarTexto(arg0, textResultadoSoma);
            }
        });
        textResultadoSoma.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                texto.hide();
                Tooltip.uninstall(textResultadoSoma, texto);
            }
        });
        
        textResultadoSub.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                copiarTexto(arg0, textResultadoSub);
            } 
        });
        textResultadoSub.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                texto.hide();
                Tooltip.uninstall(textResultadoSub, texto);
            }
        });

        textResultadoMult.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                copiarTexto(arg0, textResultadoMult);
            }
        });
        textResultadoMult.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                texto.hide();
                Tooltip.uninstall(textResultadoMult, texto);
            } 
        });
        
        textResultadoDiv.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                copiarTexto(arg0, textResultadoDiv);
            }
        });
        textResultadoDiv.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                texto.hide();
                Tooltip.uninstall(textResultadoDiv, texto);
            }
        });
        
        textResultadoMod.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                copiarTexto(arg0, textResultadoMod);
            }
        });
        textResultadoMod.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                texto.hide();
                Tooltip.uninstall(textResultadoMod, texto);
            }
        });
    }

    private void copiarTexto(MouseEvent evento, Text textoCopiado) {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(textoCopiado.getText());
        clipboard.setContent(content);
        
        Tooltip.install(textoCopiado, texto);
        texto.setAutoHide(true);
        texto.fireEvent(evento);
        texto.centerOnScreen();
        texto.show(telaQuestao3.getScene().getWindow());
    }
}