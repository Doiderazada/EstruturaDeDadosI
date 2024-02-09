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
import questoes.Questao30;
import source.App;

public class Questao30Controller {


    @FXML private BorderPane telaQuestao30;
    @FXML private Button buttonConfirmCreate;
    @FXML private Button buttonConfirmEdit;
    @FXML private Button buttonCriarFrase;
    @FXML private Button buttonHome;
    @FXML private Button buttonNovaFrase;
    @FXML private Button buttonVisualizar;
    @FXML private Button buttonVoltar;
    @FXML private HBox hBoxParent;
    @FXML private Label copyRight;
    @FXML private Label labelCreate;
    @FXML private Label labelEdit;
    @FXML private Pane paneView;
    @FXML private ScrollPane sPaneView;
    @FXML private Text questao;
    @FXML private Text textEnunciado;
    @FXML private Text textResposta;
    @FXML private TextField tfCreate;
    @FXML private TextField tfEdit;
    @FXML private VBox vBoxCreate;
    @FXML private VBox vBoxEdit;

    private String fraseEntrada;
    private String fraseSaida;
    private Questao30 inversor;
    
    public void initialize() {
        acaoDosBotoes();
        setStilo();
        exibirConteudo();
        estadoInicial();
    }


    private void estadoInicial(){
        buttonCriarFrase.setDisable(false);
        buttonNovaFrase.setDisable(true);
        buttonVisualizar.setDisable(true);

        hBoxParent.getChildren().removeAll(vBoxCreate, vBoxEdit, sPaneView);
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


        buttonCriarFrase.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                hBoxParent.getChildren().add(vBoxCreate);
            }
            
        });
    
        buttonNovaFrase.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if(hBoxParent.getChildren().contains(vBoxEdit)) hBoxParent.getChildren().remove(vBoxEdit);
                if(hBoxParent.getChildren().contains(sPaneView)) hBoxParent.getChildren().remove(sPaneView);
                hBoxParent.getChildren().add(vBoxEdit);

                tfEdit.setText(fraseEntrada);

            }
            
        });

        buttonVisualizar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if(hBoxParent.getChildren().contains(vBoxEdit)) hBoxParent.getChildren().remove(vBoxEdit);
                if(hBoxParent.getChildren().contains(sPaneView)) hBoxParent.getChildren().remove(sPaneView);
                inversor.inverterFrase();

                fraseEntrada = inversor.getFraseOriginal();
                fraseSaida = inversor.getFraseInvertida();

                textResposta.setText("Frase original: " + fraseEntrada + "\n\n" + 
                "Frase invertida: " + fraseSaida + "\n");

                hBoxParent.getChildren().add(sPaneView);
            }
            
        });

        buttonConfirmCreate.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                
                if (validarCreate()) {
                    
                    fraseEntrada = tfCreate.getText();

                    inversor = new Questao30(fraseEntrada);
                    
                    textResposta.setText("Frase criada com sucesso!");
                    hBoxParent.getChildren().remove(vBoxCreate);
                    hBoxParent.getChildren().add(sPaneView);

                    buttonCriarFrase.setDisable(true);
                    buttonNovaFrase.setDisable(false);
                    buttonVisualizar.setDisable(false);
                }
            }
            
        });

        buttonConfirmEdit.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (validarEdit()) {
                    fraseEntrada = tfEdit.getText();

                    inversor.setFraseOriginal(fraseEntrada);

                    textResposta.setText("Frase editada com sucesso!");
                    hBoxParent.getChildren().remove(vBoxEdit);
                    hBoxParent.getChildren().add(sPaneView);
                }
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




    private boolean validarCreate() {
        
        if (tfCreate.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente");
            return false;
        } 

        return true;
    }

    private boolean validarEdit() {
        
        if (tfEdit.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente");
            return false;
        } 

        return true;
    }


    private void exibirConteudo() { 
        questao.setText(questao.getText() + "\t");
        textEnunciado.setText(EnunciadoDasQuestoes.questao30.substring(3));
    }


    
    private void setStilo() {
        if (App.darkMode) {
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            buttonHome.getStyleClass().setAll("btn-questao-DM");
            buttonCriarFrase.getStyleClass().setAll("btn-questao-DM");
            buttonNovaFrase.getStyleClass().setAll("btn-questao-DM");
            buttonVisualizar.getStyleClass().setAll("btn-questao-DM");
            buttonConfirmCreate.getStyleClass().setAll("btn-questao-DM");
            buttonConfirmEdit.getStyleClass().setAll("btn-questao-DM");
            telaQuestao30.setStyle("-fx-background-color: #282828");
            paneView.setStyle("-fx-background-color: #282828");
            
            labelCreate.setTextFill(Paint.valueOf("WHITE"));
            labelEdit.setTextFill(Paint.valueOf("WHITE"));

            questao.setFill(Paint.valueOf("WHITE"));
            textEnunciado.setFill(Paint.valueOf("WHITE"));
            textResposta.setFill(Paint.valueOf("WHITE"));
            
        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            buttonCriarFrase.getStyleClass().setAll("btn-questao");
            buttonNovaFrase.getStyleClass().setAll("btn-questao");
            buttonVisualizar.getStyleClass().setAll("btn-questao");
            buttonConfirmCreate.getStyleClass().setAll("btn-questao");
            buttonConfirmEdit.getStyleClass().setAll("btn-questao");
            telaQuestao30.setStyle(null);
            paneView.setStyle(null);
            
            labelCreate.setTextFill(Paint.valueOf("BLACK"));
            labelEdit.setTextFill(Paint.valueOf("BLACK"));

            questao.setFill(Paint.valueOf("BLACK"));
            textEnunciado.setFill(Paint.valueOf("BLACK"));
            textResposta.setFill(Paint.valueOf("BLACK"));
        }
    }
}