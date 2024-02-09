package controllers;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.util.Duration;
import questoes.EnunciadoDasQuestoes;
import questoes.Questao25;
import questoes.Questao29;
import source.App;

public class Questao29Controller {


    @FXML private BorderPane telaQuestao29;
    @FXML private Button buttonConfirmEdit;
    @FXML private Button buttonCriar;
    @FXML private Button buttonEditar;
    @FXML private Button buttonHome;
    @FXML private Button buttonVisualizar;
    @FXML private Button buttonVoltar;
    @FXML private Label copyRight;
    @FXML private Label labelPosicao;
    @FXML private Label labelValor;
    @FXML private Pane paneView;
    @FXML private ScrollPane sPaneView;
    @FXML private Text questao;
    @FXML private Text textEnunciado;
    @FXML private Text textResposta;
    @FXML private TextField tfPosicao;
    @FXML private TextField tfValor;
    @FXML private VBox vBoxEdit;


    public static boolean questao25 = false;
    public static Questao25 vetorQ25;
    private Questao29 vetorQ29;
    private String vetorOriginalString;
    private int[] vetorTemp;
    private int tamanho;

    public void initialize() {
        acaoDosBotoes();
        setStilo();
        exibirConteudo();
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

        buttonVoltar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("telaQuestoes");
            }
            
        });
        
        buttonHome.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("telaInicial");
            }
            
        });


        buttonCriar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                Questao25Controller.questao29 = true;
                showPopup("Você foi redirecionado para a questão 25 para a criação do vetor");
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
            showPopup("O campo não pode ser vazio, tente novamente");
            return false;
        } else if (tfPosicao.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras");
            return false;
        } else if (tfPosicao.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfPosicao.getText());
            if (num < 0 || num > tamanho) {
                showPopup("O valor é inválido para a posição");
                return false;
            }
        }

        if (tfValor.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente");
            return false;
        } else if (tfValor.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras");
            return false;
        }

        return true;
    }


    private void showPopup(String texto) {
        try{
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/telaPopupErro.fxml"));
            Parent root = loader.load();
            
            TelaPopupErroController controller = loader.getController();
            controller.initialize(texto);
            
            
            Popup popup = new Popup();

            popup.getContent().add(root);
            popup.setAutoHide(true);
            popup.setHideOnEscape(true);
            
            double winX = buttonHome.getScene().getWindow().getX();
            double winY = buttonHome.getScene().getWindow().getY();
            double halfX = buttonHome.getScene().getWindow().getWidth()/2;
            double halfY = buttonHome.getScene().getWindow().getHeight()/2;

            double newX = (winX + halfX) - (popup.getWidth()/2);
            double newY = (winY + halfY) - (popup.getHeight()/2);

            popup.setX(newX);
            popup.setY(newY);
            
            
            popup.show(buttonHome.getScene().getWindow());

            PauseTransition closeDelay = new PauseTransition(Duration.seconds(3));
            closeDelay.setOnFinished(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent arg0) {
                    popup.hide();
                }
            });
            closeDelay.play();

            
        }catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }





    private void exibirConteudo() { 
        questao.setText(questao.getText() + "\t");
        textEnunciado.setText(EnunciadoDasQuestoes.questao29.substring(3));
    }


    
    private void setStilo() {
        if (App.darkMode) {
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            buttonHome.getStyleClass().setAll("btn-questao-DM");
            buttonCriar.getStyleClass().setAll("btn-questao-DM");
            buttonEditar.getStyleClass().setAll("btn-questao-DM");
            buttonVisualizar.getStyleClass().setAll("btn-questao-DM");
            buttonConfirmEdit.getStyleClass().setAll("btn-questao-DM");
            telaQuestao29.setStyle("-fx-background-color: #282828");
            paneView.setStyle("-fx-background-color: #282828");

            labelPosicao.setTextFill(Paint.valueOf("WHITE"));
            labelValor.setTextFill(Paint.valueOf("WHITE"));
            
            questao.setFill(Paint.valueOf("WHITE"));
            textEnunciado.setFill(Paint.valueOf("WHITE"));
            textResposta.setFill(Paint.valueOf("WHITE"));
            
        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            buttonCriar.getStyleClass().setAll("btn-questao");
            buttonEditar.getStyleClass().setAll("btn-questao");
            buttonVisualizar.getStyleClass().setAll("btn-questao");
            buttonConfirmEdit.getStyleClass().setAll("btn-questao");
            telaQuestao29.setStyle(null);
            paneView.setStyle(null);

            labelPosicao.setTextFill(Paint.valueOf("BLACK"));
            labelValor.setTextFill(Paint.valueOf("BLACK"));
            
            questao.setFill(Paint.valueOf("BLACK"));
            textEnunciado.setFill(Paint.valueOf("BLACK"));
            textResposta.setFill(Paint.valueOf("BLACK"));
        }
    }
}