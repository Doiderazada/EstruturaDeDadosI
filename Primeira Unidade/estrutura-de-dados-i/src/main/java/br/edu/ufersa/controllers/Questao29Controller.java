package br.edu.ufersa.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import br.edu.ufersa.questoes.Questao25;
import br.edu.ufersa.questoes.Questao29;
import br.edu.ufersa.App;

public class Questao29Controller extends BaseController{


    @FXML private BorderPane telaQuestao29;
    @FXML private Button buttonConfirmEdit;
    @FXML private Button buttonCriar;
    @FXML private Button buttonEditar;
    @FXML private Button buttonVisualizar;
    @FXML private Label copyRight;
    @FXML private Label labelPosicao;
    @FXML private Label labelValor;
    @FXML private Pane paneView;
    @FXML private ScrollPane sPaneView;
    @FXML private Text textResposta;
    @FXML private TextField tfPosicao;
    @FXML private TextField tfValor;
    @FXML private VBox vBoxEdit;


    public static boolean questao25 = false;
    @SuppressWarnings("exports")
    public static Questao25 vetorQ25;
    private Questao29 vetorQ29;
    private String vetorOriginalString;
    private int[] vetorTemp;
    private int tamanho;

    public void initialize() {
        BaseController.numQuestao = 29;
        super.initialize();
        acaoDosBotoes();
        setStilo(new Button[] { buttonConfirmEdit, buttonCriar, buttonEditar, buttonVisualizar},
                 new Label[]  { labelPosicao, labelValor},
                 new Pane[]   { paneView, telaQuestao29}, null,
                 new Text[]   { textResposta});
        estadoInicial(questao25);

        if(questao25) {
            vetorTemp = vetorQ25.getVetor();
            vetorQ29 = new Questao29(vetorTemp);
        }
    }


    private void estadoInicial(boolean questao){
        buttonCriar.setDisable(questao);
        buttonEditar.setDisable(!questao);
        buttonVisualizar.setDisable(!questao);

        vBoxEdit.setVisible(false);
        sPaneView.setVisible(false);
    }


    private void acaoDosBotoes() {
        buttonCriar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                Questao25Controller.questao29 = true;
                showPopup("Você foi redirecionado para a questão 25 para a criação do vetor", true);
                App.trocarDeTela("questao25");
            }
        });
    
        buttonEditar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (sPaneView.isVisible()) sPaneView.setVisible(false); 
                vBoxEdit.setVisible(true);
            }
        });

        buttonConfirmEdit.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                tamanho = vetorQ25.getVetor().length;
                tamanho--;

                if (validarEdit()) {
                    int posicao = Integer.parseInt(tfPosicao.getText());
                    int valor = Integer.parseInt(tfValor.getText());
                    vetorQ25.setValor(posicao,valor);

                    vetorTemp = vetorQ25.getVetor();
                    vetorQ29.setVetorInverso(vetorTemp);

                    tfPosicao.clear();
                    tfValor.clear();

                    textResposta.setText("O vetor foi editado com sucesso!");
                    vBoxEdit.setVisible(false);
                    sPaneView.setVisible(true);
                }
            }
        });

        buttonVisualizar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (vBoxEdit.isVisible()) vBoxEdit.setVisible(false);
                if (sPaneView.isVisible()) sPaneView.setVisible(false);

                vetorOriginalString = vetorQ25.exibirVetor();
                vetorQ29.moverElemento();

                textResposta.setText("Vetor original: " + vetorOriginalString + "\n\n" + 
                "Vetor invertido: \n"+ vetorQ29.getInversoString());
                sPaneView.setVisible(true);
            }
        });
    }





    private boolean validarEdit() {
        
        if (tfPosicao.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        } else if (tfPosicao.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras", false);
            return false;
        } else if (tfPosicao.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfPosicao.getText());
            if (num < 0 || num > tamanho) {
                showPopup("O valor é inválido para a posição", false);
                return false;
            }
        }

        if (tfValor.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        } else if (tfValor.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras", false);
            return false;
        }

        return true;
    }
}