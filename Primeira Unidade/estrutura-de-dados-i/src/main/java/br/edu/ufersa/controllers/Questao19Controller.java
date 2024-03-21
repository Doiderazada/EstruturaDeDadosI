package br.edu.ufersa.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import br.edu.ufersa.questoes.Questao19;

public class Questao19Controller extends BaseController{

    
    @FXML private BorderPane telaQuestao19;
    @FXML private Button buttonConfirmar;
    @FXML private Label copyRight;
    @FXML private Label labelNumero;
    @FXML private Text textResposta;
    @FXML private TextField tfNumero;


    public void initialize() {
        BaseController.numQuestao = 19;
        super.initialize();
        acaoDosBotoes();
        setStilo(new Button[] { buttonConfirmar}, 
                 new Label[]  { labelNumero},
                 new Pane[]   { telaQuestao19}, null,
                 new Text[]   { textResposta});
        textResposta.setVisible(false);
    }





    private void acaoDosBotoes() {
        buttonConfirmar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (verificarInput()) {
                    Questao19.setNumero(Integer.parseInt(tfNumero.getText()));
                    textResposta.setText(Questao19.montarTabuada());
                    textResposta.setVisible(true);
                }
            }
        });

        tfNumero.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent arg0) {
                textResposta.setVisible(false);
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
            if (num < 1 || num > 9) {
                showPopup("O número não pode exceder 9 ou ser menor que 1", false);
                return false;
            }
        }
        return true;
    }
}