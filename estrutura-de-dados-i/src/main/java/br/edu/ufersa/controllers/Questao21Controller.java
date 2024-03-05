package br.edu.ufersa.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import br.edu.ufersa.questoes.Questao21;

public class Questao21Controller extends BaseController{
    
    @FXML private BorderPane telaQuestao21;
    @FXML private Button buttonConfirmar;
    @FXML private Button buttonNovoNumero;
    @FXML private Label copyRight;
    @FXML private Label labelNumero;
    @FXML private Text textResposta;
    @FXML private TextField tfNumero;
    @FXML private VBox vBoxOutput;
    @FXML private VBox vBoxInput;

    public void initialize() {
        BaseController.numQuestao = 21;
        super.initialize();
        acaoDosBotoes();
        setStilo(new Button[] { buttonConfirmar, buttonNovoNumero},
                 new Label[]  { labelNumero},
                 new Pane[]   { telaQuestao21}, null,
                 new Text[]   { textResposta});
        vBoxOutput.setVisible(false);
    }



    private void acaoDosBotoes() {
        buttonConfirmar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (verificarInput()) {
                    int num = Integer.parseInt(tfNumero.getText());

                    if(Questao21.verificarPrimo(num)) textResposta.setText("O número é primo");
                    else {
                        int mult = Questao21.getMult();

                        textResposta.setText("O número não é primo, pois é múltiplo de " + mult);
                    }

                    vBoxInput.setVisible(false);
                    vBoxOutput.setVisible(true);
                }
            }
        });

        buttonNovoNumero.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                tfNumero.clear();
                vBoxOutput.setVisible(false);
                vBoxInput.setVisible(true);
            }
        });
    }


    private boolean verificarInput() {
        if (tfNumero.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        } else if (tfNumero.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras", false);
            return false;
        } else if (tfNumero.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfNumero.getText());
            if (num < 1 ) {
                showPopup("Por favor, entre com um número positivo", false);
                return false;
            }
        }
        return true;
    }   
}