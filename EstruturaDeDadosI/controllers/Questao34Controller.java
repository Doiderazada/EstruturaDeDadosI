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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.util.Duration;
import questoes.EnunciadoDasQuestoes;
import questoes.Questao34;
import source.App;

public class Questao34Controller {

    
    @FXML private BorderPane telaQuestao34;
    @FXML private Button buttonConfirmar;
    @FXML private Button buttonHome;
    @FXML private Button buttonNovaFrase;
    @FXML private Button buttonVisualizar;
    @FXML private Button buttonVoltar;
    @FXML private HBox hBoxOutput;
    @FXML private Label copyRight;
    @FXML private Label labelFrase;
    @FXML private Pane paneView;
    @FXML private ScrollPane sPaneView;
    @FXML private Text questao;
    @FXML private Text textEnunciado;
    @FXML private Text textView;
    @FXML private TextField tfFrase;
    @FXML private VBox vBoxButtons;
    @FXML private VBox vBoxFrase;


    
    private Questao34 fraseQ34 = new Questao34(" ");
    

    public void initialize() {
        acaoDosBotoes();
        setStilo();
        exibirConteudo();
        estadoInicial();

    }



    private void estadoInicial(){
        buttonVisualizar.setDisable(true);
        hBoxOutput.getChildren().removeAll(vBoxFrase, sPaneView);
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

        buttonNovaFrase.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (hBoxOutput.getChildren().contains(sPaneView)) hBoxOutput.getChildren().remove(sPaneView);
                hBoxOutput.getChildren().add(vBoxFrase);
                tfFrase.clear();
            }
        });
        buttonVisualizar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                visualizarFrase();
            }
        });

        buttonConfirmar.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
                
                novaFrase();
                
                hBoxOutput.getChildren().remove(vBoxFrase);

                if (buttonVisualizar.isDisable()) buttonVisualizar.setDisable(false);
			}
        });

    }


    private void novaFrase(){

        if (validarFrase()) {
            String frase = tfFrase.getText();
            
            fraseQ34.setFrase(frase);
            fraseQ34.setPalavras();
            fraseQ34.setQuantidade();

            fraseQ34.contarPalavras();

            textView.setText("A frase foi cadastrada com sucesso.");
            hBoxOutput.getChildren().add(sPaneView);
        }
    }

    private void visualizarFrase(){
        textView.setText("Informações sobre a frase \"" + fraseQ34.getFrase() + "\".\n\n" +
        fraseQ34.exibirConteudo());
    }


    
    
    private boolean validarFrase() {

        if (tfFrase.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente");
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

            PauseTransition closeDelay = new PauseTransition(Duration.seconds(2.5));
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
        textEnunciado.setText(EnunciadoDasQuestoes.questao34.substring(3));
    }



    

    private void setStilo() {
        if (App.darkMode) {
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            buttonHome.getStyleClass().setAll("btn-questao-DM");
            buttonConfirmar.getStyleClass().setAll("btn-questao-DM");
            buttonNovaFrase.getStyleClass().setAll("btn-questao-DM");
            buttonVisualizar.getStyleClass().setAll("btn-questao-DM");
            telaQuestao34.setStyle("-fx-background-color: #282828");
            paneView.setStyle("-fx-background-color: #282828");

            labelFrase.setTextFill(Paint.valueOf("WHITE"));
            
            questao.setFill(Paint.valueOf("WHITE"));
            textEnunciado.setFill(Paint.valueOf("WHITE"));
            textView.setFill(Paint.valueOf("WHITE"));
            
        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            buttonConfirmar.getStyleClass().setAll("btn-questao");
            buttonNovaFrase.getStyleClass().setAll("btn-questao");
            buttonVisualizar.getStyleClass().setAll("btn-questao");
            telaQuestao34.setStyle(null);
            paneView.setStyle(null);

            labelFrase.setTextFill(Paint.valueOf("BLACK"));
            
            questao.setFill(Paint.valueOf("BLACK"));
            textEnunciado.setFill(Paint.valueOf("BLACK"));
            textView.setFill(Paint.valueOf("BLACK"));
        }
    }
}