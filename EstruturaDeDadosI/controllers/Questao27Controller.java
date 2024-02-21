package controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import questoes.Questao25;
import questoes.Questao27;
import source.App;

public class Questao27Controller extends BaseController{


    @FXML private BorderPane telaQuestao27;
    @FXML private Button buttonCriar;
    @FXML private Button buttonInverter;
    @FXML private Button buttonVisualizar;
    @FXML private Label copyRight;
    @FXML private Pane paneView;
    @FXML private ScrollPane sPaneView;
    @FXML private Text textResposta;

    public static boolean questao25 = false;
    public static Questao25 vetorQ25;
    private int[] inverso = null;
    private Questao27 inversor;

    
    
    public void initialize() {
        BaseController.numQuestao = 27;
        super.initialize();
        acaoDosBotoes();
        setStilo(new Button[] { buttonCriar, buttonInverter, buttonVisualizar}, null,
                 new Pane[]   { paneView, telaQuestao27}, null,
                 new Text[]   { textResposta});
        estadoInicial(questao25);
    }


    private void estadoInicial(boolean questao){
        buttonCriar.setDisable(questao);
        buttonInverter.setDisable(!questao);
        buttonVisualizar.setDisable(true);

        sPaneView.setVisible(false);
    }


    private void acaoDosBotoes() {
        buttonCriar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                showPopup("Você foi redirecionado para a questão 25 para a criação do vetor", true);
                irQuestao25();
            }
        });
        buttonInverter.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (sPaneView.isVisible()) sPaneView.setVisible(false);
                if(inverso == null) inverso = vetorQ25.getVetor();

                inversor = new Questao27(inverso);
                inverso = inversor.getInverso();

                buttonVisualizar.setDisable(false);

                textResposta.setText("O vetor foi invertido com sucesso!");
                sPaneView.setVisible(true);
            }
        });
        buttonVisualizar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (sPaneView.isVisible()) sPaneView.setVisible(false);

                textResposta.setText("Vetor original: " + vetorQ25.exibirVetor() + "\n\n" +
                "Vetor inverso: " + inversor.exibirInverso());
                sPaneView.setVisible(true);
            }
        });
    }



    private void irQuestao25(){
        Questao25Controller.questao27 = true;
        Questao25Controller.questao28 = false;

        App.trocarDeTela("questao25");
    }
}