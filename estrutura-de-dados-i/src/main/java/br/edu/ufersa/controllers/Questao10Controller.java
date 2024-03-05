package br.edu.ufersa.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import br.edu.ufersa.questoes.Questao10;

public class Questao10Controller extends BaseController{
    

    @FXML private BorderPane telaQuestao10;
    @FXML private Button buttonConfirmar;
    @FXML private HBox hBoxMultiplo;
    @FXML private Label copyRight;
    @FXML private Label labelNumero;
    @FXML private VBox vBoxOutput;
    @FXML private Text textE;
    @FXML private Text textFormula;
    @FXML private Text textInteiro;
    @FXML private Text textMultiplo;
    @FXML private Text textOnde;
    @FXML private Text textResposta;
    @FXML private TextField tfNumero;

    


    public void initialize() {
        BaseController.numQuestao = 10;
        super.initialize();
        setStilo(new Button[] { buttonConfirmar}, 
                 new Label[]  { labelNumero}, 
                 new Pane[]   { telaQuestao10}, null, 
                 new Text[]   { textE, textFormula, textInteiro, 
                                textMultiplo, textOnde, textResposta});
        acaoDosBotoes();
        estadoInicial();
    }



    private void estadoInicial() {
        vBoxOutput.setVisible(false);
        hBoxMultiplo.setVisible(false);
    }



    private void acaoDosBotoes() {
        buttonConfirmar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (verificarInput()) {
                    Questao10.setNumero(Integer.parseInt(tfNumero.getText()));
                    
                    if (Questao10.verificarParidade()) {
                        textMultiplo.setText("K = " + Questao10.getMultiplo());
                        textResposta.setText("O valor inserido é par, pois se aplica à formula:");
                        hBoxMultiplo.setVisible(true);

                    } else textResposta.setText("O valor inserido não é par, pois não se aplica à formula:");
                    vBoxOutput.setVisible(true);
                }
            }
        });

        tfNumero.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent arg0) {
                estadoInicial();
            }
        });
    }

    

    private boolean verificarInput() {
        if (tfNumero.getText().matches("[a-zA-Z]+")) {
            showPopup("O valor inserido não é válido, tente novamente", false);
            return false;
        } else if (tfNumero.getText().matches("[0-9^.]+")) { 
            double valor = Double.parseDouble(tfNumero.getText());
            if (valor == 0) {
                showPopup("O valor não pode ser 0", false);
                return false;
            }
        }
        return true;
    }
}