package controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import questoes.Questao16;

public class Questao16Controller extends BaseController{

    @FXML private BorderPane telaQuestao16;
    @FXML private Button buttonConfirmar;
    @FXML private Label copyRight;
    @FXML private Label labelNumeroFinal;
    @FXML private Label labelNumeroInicial;
    @FXML private Pane paneTeste;
    @FXML private ScrollPane sPaneOutput;
    @FXML private Text textDoWhile;
    @FXML private Text textFor;
    @FXML private Text textRespostaDoWhile;
    @FXML private Text textRespostaFor;
    @FXML private Text textRespostaWhile;
    @FXML private Text textWhile;
    @FXML private TextField tfNumero1;
    @FXML private TextField tfNumero2;


    public void initialize() {
        BaseController.numQuestao = 16;
        super.initialize();
        acaoDosBotoes();
        setStilo(new Button[] { buttonConfirmar}, 
                 new Label[]  { labelNumeroFinal, labelNumeroInicial},
                 new Pane[]   { paneTeste, telaQuestao16}, null,
                 new Text[]   { textDoWhile, textFor, textRespostaDoWhile, 
                                textRespostaFor, textRespostaWhile, textWhile});
        sPaneOutput.setVisible(false);
    }





    private void acaoDosBotoes() {
        buttonConfirmar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (verificarInput()) {
                    Questao16.setNumInicial(Integer.parseInt(tfNumero1.getText()));
                    Questao16.setNumFinal(Integer.parseInt(tfNumero2.getText()));
                    
                    textRespostaFor.setText(Questao16.contarFor());
                    textRespostaDoWhile.setText(Questao16.contarDoWhile());
                    textRespostaWhile.setText(Questao16.contarWhile());
                    
                    sPaneOutput.setVisible(true);
                }
            }
        });

        
        tfNumero1.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent arg0) {
                sPaneOutput.setVisible(false);
            }
        });
        tfNumero2.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent arg0) {
                sPaneOutput.setVisible(false);
            }
        });
    }

    
    



    private boolean verificarInput() {
        
        if (tfNumero1.getText().matches("[\\D]+")) {
            showPopup("O campo não pode conter letras, tente novamente", false);
            return false;
        }
        
        if (tfNumero2.getText().matches("[\\D]+")) {
            showPopup("O campo não pode conter letras, tente novamente", false);
            return false;
        }

        return true;
    }
}