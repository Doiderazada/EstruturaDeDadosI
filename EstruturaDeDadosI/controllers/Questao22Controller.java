package controllers;

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
import questoes.Questao22;

public class Questao22Controller extends BaseController{
    
    
    @FXML private BorderPane telaQuestao22;
    @FXML private Button buttonConfirmar;
    @FXML private Button buttonNovamente;
    @FXML private Label copyRight;
    @FXML private Label labelNumFin;
    @FXML private Label labelNumIni;
    @FXML private Text textResposta;
    @FXML private TextField tfNumFin;
    @FXML private TextField tfNumIni;
    @FXML private VBox vBoxInput;
    @FXML private VBox vBoxOutput;


    public void initialize() {
        BaseController.numQuestao = 22;
        super.initialize();
        acaoDosBotoes();
        setStilo(new Button[] { buttonConfirmar, buttonNovamente},
                 new Label[]  { labelNumFin, labelNumFin},
                 new Pane[]   { telaQuestao22}, null,
                 new Text[]   { textResposta});
        vBoxOutput.setVisible(false);
    }



    private void acaoDosBotoes() {
        buttonConfirmar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (verificarInput()) {
                    int numIni = Integer.parseInt(tfNumIni.getText());
                    int numFin = Integer.parseInt(tfNumFin.getText());

                    int soma = Questao22.fazerSomatorio(numIni, numFin);

                    textResposta.setText("O resultado do somatório dos números percententes " + 
                                         "ao intervalo de " + numIni + " a " + numFin + " é: " + soma);
                    
                    vBoxInput.setVisible(false);
                    vBoxOutput.setVisible(true);
                }
            }
        });

        buttonNovamente.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                tfNumIni.clear();
                tfNumFin.clear();
                vBoxOutput.setVisible(false);
                vBoxInput.setVisible(true);
            }
        });
    }

 


    private boolean verificarInput() {
        if (tfNumIni.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        } else if (tfNumIni.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras", false);
            return false;
        } 
        if (tfNumFin.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        } else if (tfNumFin.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras", false);
            return false;
        } 
        return true;
    }
}
