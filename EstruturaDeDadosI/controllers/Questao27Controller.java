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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.util.Duration;
import questoes.EnunciadoDasQuestoes;
import questoes.Questao25;
import questoes.Questao27;
import source.App;

public class Questao27Controller {


    @FXML private Button buttonCriar;
    @FXML private Button buttonHome;
    @FXML private Button buttonInverter;
    @FXML private Button buttonVisualizar;
    @FXML private Button buttonVoltar;
    @FXML private Label copyRight;
    @FXML private Pane paneView;
    @FXML private Text questao;
    @FXML private ScrollPane sPaneView;
    @FXML private BorderPane telaQuestao27;
    @FXML private Text textEnunciado;
    @FXML private Text textResposta;

    public static boolean questao25 = false;
    public static Questao25 vetorQ25;
    private int[] inverso = null;
    private Questao27 inversor;

    
    
    public void initialize() {
        acaoDosBotoes();
        setStilo();
        exibirConteudo();
        estadoInicial(questao25);
    }


    private void estadoInicial(boolean questao){
        buttonCriar.setDisable(questao);
        buttonInverter.setDisable(!questao);
        buttonVisualizar.setDisable(true);

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
                showPopup("Você foi redirecionado para a questão 25 para a criação do vetor");
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


    private void irQuestao25(){
        
        Questao25Controller.questao27 = true;
        Questao25Controller.questao28 = false;

        App.trocarDeTela("questao25");
        
    }


    private void exibirConteudo() { 
        questao.setText(questao.getText() + "\t");
        textEnunciado.setText(EnunciadoDasQuestoes.questao27.substring(3));
    }


    
    private void setStilo() {
        if (App.darkMode) {
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            buttonHome.getStyleClass().setAll("btn-questao-DM");
            buttonCriar.getStyleClass().setAll("btn-questao-DM");
            buttonInverter.getStyleClass().setAll("btn-questao-DM");
            buttonVisualizar.getStyleClass().setAll("btn-questao-DM");
            telaQuestao27.setStyle("-fx-background-color: #282828");
            paneView.setStyle("-fx-background-color: #282828");
            
            questao.setFill(Paint.valueOf("WHITE"));
            textEnunciado.setFill(Paint.valueOf("WHITE"));
            textResposta.setFill(Paint.valueOf("WHITE"));
            
        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            buttonCriar.getStyleClass().setAll("btn-questao");
            buttonInverter.getStyleClass().setAll("btn-questao");
            buttonVisualizar.getStyleClass().setAll("btn-questao");
            telaQuestao27.setStyle(null);
            paneView.setStyle(null);
            
            questao.setFill(Paint.valueOf("BLACK"));
            textEnunciado.setFill(Paint.valueOf("BLACK"));
            textResposta.setFill(Paint.valueOf("BLACK"));
        }
    }
}