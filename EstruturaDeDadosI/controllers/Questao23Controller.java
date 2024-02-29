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
import javafx.scene.text.Text;
import questoes.Questao23;

public class Questao23Controller extends BaseController{

    
    @FXML private BorderPane telaQuestao23;
    @FXML private Button buttonConfirmar;
    @FXML private Label copyRight;
    @FXML private Label labelNumero;
    @FXML private Text textResposta;
    @FXML private TextField tfNumero;


    public void initialize() {
        BaseController.numQuestao = 23;
        super.initialize();
        acaoDosBotoes();
        setStilo(new Button[] { buttonConfirmar},
                 new Label[]  { labelNumero}, 
                 new Pane[]   { telaQuestao23}, null,
                 new Text[]   { textResposta});
        textResposta.setVisible(false);
    }





    private void acaoDosBotoes() {
        buttonConfirmar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (verificarInput()) {
                    int fator = Integer.parseInt(tfNumero.getText());
                    double fatorial = Questao23.calcularFatorial(fator);
                    textResposta.setText("O fatorial de " + fator + " é: " + String.valueOf(fatorial));

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
            if (num < 1) {
                showPopup("O número não pode ser menor que 1", false);
                return false;
            }
        }
        return true;
    }
}