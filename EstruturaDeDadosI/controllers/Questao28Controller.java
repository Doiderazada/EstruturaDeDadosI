package controllers;

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
import questoes.Questao25;
import questoes.Questao28;
import source.App;

public class Questao28Controller extends BaseController{


    @FXML private BorderPane telaQuestao28;
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
    public static Questao25 vetorQ25;
    private int[] vetor;
    private int tamanho;

    
    public void initialize() {
        BaseController.numQuestao = 28;
        super.initialize();
        acaoDosBotoes();
        setStilo(new Button[] { buttonConfirmEdit, buttonCriar, buttonEditar, buttonVisualizar},
                 new Label[]  { labelPosicao, labelValor},
                 new Pane[]   { paneView, telaQuestao28}, null,
                 new Text[]   { textResposta});
        estadoInicial(questao25);

        if (questao25) {
            vetor = vetorQ25.getVetor();
            tamanho = vetor.length;
        }
    }


    private void estadoInicial(boolean questao){
        buttonCriar.setDisable(questao);
        buttonEditar.setDisable(!questao);
        buttonVisualizar.setDisable(!questao);
        
        sPaneView.setVisible(false);
        vBoxEdit.setVisible(false);
    }


    private void acaoDosBotoes() {
        buttonCriar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                showPopup("Você foi redirecionado para a questão 25 para a criação do vetor", true);
                irQuestao25();
            }
        });
        buttonEditar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (sPaneView.isVisible()) sPaneView.setVisible(false);
                tfPosicao.clear();
                tfValor.clear();
                vBoxEdit.setVisible(true);
            }
        });
        buttonVisualizar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (sPaneView.isVisible()) sPaneView.setVisible(false);

                Questao28.calcMaxMin(vetor);
                int maior = Questao28.getMaior();
                int menor = Questao28.getMenor();

                textResposta.setText("Elementos do vetor: " + vetorQ25.exibirVetor() + "\n\n" +
                "maior elemento do vetor: " + "[" + maior + "]\n" + "menor elemento do vetor: " + 
                "[" + menor + "]\n");

                sPaneView.setVisible(true);
            }
        });

        buttonConfirmEdit.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (validarEdit()) {
                    if (sPaneView.isVisible()) sPaneView.setVisible(false);

                    int posicao = Integer.parseInt(tfPosicao.getText());
                    int valor = Integer.parseInt(tfValor.getText());

                    vetor[posicao] = valor;

                    textResposta.setText("O vetor foi editado com sucesso!");
                    vBoxEdit.setVisible(false);
                    sPaneView.setVisible(true);
                }
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
            if (num < 0 || num > tamanho-1) {
                showPopup("O valor não é um número válido para a posição", false);
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



    private void irQuestao25(){
        Questao25Controller.questao27 = false;
        Questao25Controller.questao28 = true;

        App.trocarDeTela("questao25");   
    }
}