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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import br.edu.ufersa.questoes.Questao7;

public class Questao7Controller extends BaseController{
    
    @FXML private BorderPane telaQuestao7;
    @FXML private Button buttonConfirmar;
    @FXML private Label copyRight;
    @FXML private Label labelValA;
    @FXML private Label labelValB;
    @FXML private Line divLine;
    @FXML private Text textEqualSign;
    @FXML private Text textResult;
    @FXML private Text textValA;
    @FXML private Text textValB;
    @FXML private TextField tfValA;
    @FXML private TextField tfValB;
    @FXML private VBox inputVBox;
    @FXML private VBox outputVBox;



    public void initialize() {
        BaseController.numQuestao = 7;
        super.initialize();
        setStilo(new Button[] {buttonConfirmar}, 
                 new Label[]  { labelValA, labelValB}, 
                 new Pane[]   { telaQuestao7}, 
                 new Shape[]  { (Shape)divLine}, 
                 new Text[]   { textEqualSign, textResult, textValA, textValB});
        acaoDosBotoes();
        inputVBox.setVisible(true);
        outputVBox.setVisible(false);
    }





    private void acaoDosBotoes() {
        buttonConfirmar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (verificarInput()) {
                    Questao7.setValA(Double.parseDouble(tfValA.getText()));
                    Questao7.setValB(Double.parseDouble(tfValB.getText()));

                    textValA.setText(String.valueOf(Questao7.getValA()));
                    textValB.setText(String.valueOf(Questao7.getValB()));
                    textResult.setText(String.valueOf(Questao7.dividir()));

                    outputVBox.setVisible(true);
                }
            }    
        });

        Tooltip texto = new Tooltip("Texto copiado");
        textResult.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(textResult.getText());
                clipboard.setContent(content);

                Tooltip.install(textResult, texto);
                texto.setAutoHide(true);
                texto.fireEvent(arg0);
                texto.centerOnScreen();
                texto.show(telaQuestao7.getScene().getWindow());
            }
        });
        textResult.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                texto.hide();
                Tooltip.uninstall(textResult, texto);
            }
        });
    }

    

    private boolean verificarInput() {
        if (tfValA.getText().contains(",")) 
            tfValA.setText(tfValA.getText().replace(",", "."));
        if (tfValB.getText().contains(",")) 
            tfValB.setText(tfValB.getText().replace(",", "."));

        if (tfValA.getText().isEmpty()) {
            showPopup("Os valores inseridos não são válidos, por favor, tente novamente.", false);
            return false;
        } else if (tfValA.getText().matches("[a-zA-Z]+")) {
            showPopup("Os valores inseridos não são válidos, por favor, tente novamente.", false);
            return false;
        };
        if (tfValB.getText().isEmpty()) {
            showPopup("Os valores inseridos não são válidos, por favor, tente novamente.", false);
            return false;
        } else if (tfValB.getText().matches("0")) {
            showPopup("O divisor não pode ser 0", false);
            return false;
        } else if (tfValB.getText().matches("[a-zA-Z]+")) {
            showPopup("Os valores inseridos não são válidos, por favor, tente novamente.", false);
            return false;
        }
        return true;
    }
}