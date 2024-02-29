package controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import questoes.Questao25;
import source.App;

public class Questao25Controller extends BaseController{

    
    @FXML private BorderPane telaQuestao25;
    @FXML private Button buttonConfirmCreate;
    @FXML private Button buttonConfirmEdit;
    @FXML private Button buttonCriar;
    @FXML private Button buttonEditar;
    @FXML private Button buttonQuestao27;
    @FXML private Button buttonQuestao28;
    @FXML private Button buttonQuestao29;
    @FXML private Button buttonVisualizar;
    @FXML private Label copyRight;
    @FXML private Label labelPosicao;
    @FXML private Label labelValor;
    @FXML private Label labelVetor;
    @FXML private Pane paneView;
    @FXML private ScrollPane sPaneView;
    @FXML private Text textResposta;
    @FXML private Text textView;
    @FXML private TextField tfPosicao;
    @FXML private TextField tfValor;
    @FXML private TextField tfVetor;
    @FXML private VBox vBoxButtons;
    @FXML private VBox vBoxCreate;
    @FXML private VBox vBoxEdit;

    private int cont;
    private int tamanho;
    private Questao25 vetor;
    public static boolean questao27 = false, questao28 = false, questao29 = false;

    
    public void initialize() {
        BaseController.numQuestao = 25;
        super.initialize();
        acaoDosBotoes();
        setStilo(new Button[] { buttonConfirmCreate, buttonConfirmEdit, buttonCriar, buttonEditar, 
                                buttonQuestao27, buttonQuestao28, buttonQuestao29, buttonVisualizar},
                 new Label[]  { labelPosicao, labelValor, labelVetor},
                 new Pane[]   { paneView, telaQuestao25}, null,
                 new Text[]   { textResposta, textView});
        estadoInicial();

        cont = -1;
    }


    private void estadoInicial(){
        labelVetor.setText("Tamanho do vetor");
        
        buttonEditar.setDisable(true);
        buttonVisualizar.setDisable(true);
        vBoxButtons.getChildren().removeAll(buttonQuestao27, buttonQuestao28, buttonQuestao29);

        vBoxCreate.setVisible(false);
        vBoxEdit.setVisible(false);
        sPaneView.setVisible(false);

        textResposta.setVisible(false);
    }


    private void acaoDosBotoes() {
        buttonCriar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                vBoxCreate.setVisible(true);
            }
        });
        buttonEditar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (textResposta.isVisible()) textResposta.setVisible(false);
                if (sPaneView.isVisible()) sPaneView.setVisible(false);

                textResposta.setVisible(false);
                vBoxEdit.setVisible(true);
            }
        });
        buttonVisualizar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (textResposta.isVisible()) textResposta.setVisible(false);
                if (vBoxEdit.isVisible()) vBoxEdit.setVisible(false);

                textView.setText(vetor.exibirVetor());
                sPaneView.setVisible(true);
            }
        });

        buttonConfirmCreate.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                criarVetor();
            }
        });
        buttonConfirmEdit.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (validarEdit()) {
                    int posicao = Integer.parseInt(tfPosicao.getText());
                    int valor = Integer.parseInt(tfValor.getText());

                    vetor.setValor(posicao, valor);

                    vBoxEdit.setVisible(false);
                    tfPosicao.clear();
                    tfValor.clear();
                    textResposta.setText("Vetor editado com sucesso!");
                    textResposta.setVisible(true);
                }
            }
        });

        buttonQuestao27.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                irQuestao27();
            }
        });
        buttonQuestao28.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                irQuestao28();
            }
        });
        buttonQuestao29.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                irQuestao29();
            }
        });

        Tooltip mensagem = new Tooltip("Você ainda vai voltar nessa questão...");
        
        if (questao27 || questao28 || questao29) {
            mensagem.setText("Eu avisei.");
        }
        mensagem.setShowDelay(Duration.millis(200));
        mensagem.setShowDuration(Duration.millis(800));
        mensagem.setAutoHide(true);
        copyRight.setTooltip(mensagem);
    }

    
    

    private void criarVetor() {
        if (cont == -1) {
            if (validarCreate()) {
                tamanho = Integer.parseInt(tfVetor.getText());
                vetor = new Questao25(tamanho);
            }

            cont++;

            labelVetor.setText((cont+1) + "º elemento do vetor");
            tfVetor.clear();
            buttonConfirmCreate.setText("Próximo");
        } else {
            int valor = Integer.parseInt(tfVetor.getText());
            vetor.setValor(cont, valor);

            cont++;

            labelVetor.setText((cont+1) + "º elemento do vetor");
            tfVetor.clear();
        }

        if (cont+1 == tamanho) buttonConfirmCreate.setText("Concluir");
        if (cont == tamanho) {
            vBoxCreate.setVisible(false);
            textResposta.setText("Vetor criado e preenchido com sucesso!");
            textResposta.setVisible(true);
            buttonCriar.setDisable(true);

            buttonEditar.setDisable(false);
            buttonVisualizar.setDisable(false);

            if (questao27) vBoxButtons.getChildren().add(buttonQuestao27);
            if (questao28) vBoxButtons.getChildren().add(buttonQuestao28);
            if (questao29) vBoxButtons.getChildren().add(buttonQuestao29);
        }
    }


    private boolean validarCreate() {
        if (tfVetor.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        } else if (tfVetor.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras", false);
            return false;
        } else if (tfVetor.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfVetor.getText());
            if (num < 1 ) {
                showPopup("O vetor não pode ter tamanho menor que 1", false);
                return false;
            }
        }
        return true;
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




    private void irQuestao27() {
        Questao27Controller.questao25 = true;
        Questao27Controller.vetorQ25 = vetor;
        App.trocarDeTela("questao27");
    }
    private void irQuestao28() {
        Questao28Controller.questao25 = true;
        Questao28Controller.vetorQ25 = vetor;
        App.trocarDeTela("questao28");
    }
    private void irQuestao29() {
        Questao29Controller.questao25 = true;
        Questao29Controller.vetorQ25 = vetor;
        App.trocarDeTela("questao29");
    }
}