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
import questoes.Questao15;

public class Questao15Controller extends BaseController{


    @FXML private BorderPane telaQuestao15;
    @FXML private Button buttonConfirmar;
    @FXML private Label copyRight;
    @FXML private Label labelNumero;
    @FXML private Text textResposta;
    @FXML private TextField tfNumero;


    public void initialize() {
        BaseController.numQuestao = 15;
        super.initialize();
        acaoDosBotoes();
        setStilo(new Button[] {buttonConfirmar}, 
                 new Label[] {labelNumero}, 
                 new Pane[] {telaQuestao15}, null, 
                 new Text[] { textResposta});
        textResposta.setVisible(false);
    }



    private void acaoDosBotoes() {
        buttonConfirmar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (verificarInput()) {
                    Questao15.setNumero(Byte.parseByte(tfNumero.getText()));

                    textResposta.setText(Questao15.verificarNumero());
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
        if (tfNumero.getText().matches("[\\D]+")) {
            showPopup("O campo não pode conter letras, tente novamente", false);
            return false;
        }
        return true;
    }
}