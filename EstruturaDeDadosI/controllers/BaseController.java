package controllers;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.util.Duration;
import questoes.EnunciadoDasQuestoes;
import source.App;

public class BaseController {
    
    @FXML private Button buttonHome;
    @FXML private Button buttonVoltar;
    @FXML private Text questao;
    @FXML private Text textEnunciado;

    public static int numQuestao = 1;
    final private static EnunciadoDasQuestoes enunciado = new EnunciadoDasQuestoes();

    public void initialize(){
        this.acaoBotoesPrincipais();
        this.exibirConteudo(numQuestao);
    }



    final protected void acaoBotoesPrincipais(){
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
    }


    final protected void showPopup(String texto, boolean isSucess) {
        try{

            FXMLLoader loader;
            Parent root;
            if (isSucess) {
                loader = new FXMLLoader(getClass().getResource("../views/telaPopupSucesso.fxml"));
                root = loader.load();

                TelaPopupSucessoController controller = loader.getController();
                controller.initialize(texto);
            }
            else {
                loader = new FXMLLoader(getClass().getResource("../views/telaPopupErro.fxml"));
                root = loader.load();
                
                TelaPopupErroController controller = loader.getController();
                controller.initialize(texto);
            };
            
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


    final protected void exibirConteudo(final int numQuestao) {
        questao.setText("Questão " + numQuestao + ".\t");
        textEnunciado.setText(enunciado.pegarQuestao(numQuestao).substring(3));
    }


    final protected void setStilo(Button[] args0, Label[] args1, Pane[] args2, Shape[] args3, Text[] args4) {
        if (App.darkMode) {
            buttonHome.getStyleClass().setAll("btn-home-DM");
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            questao.setFill(Color.WHITE);
            textEnunciado.setFill(Color.WHITE);
            if (args0 != null) { for (Button button : args0) button.getStyleClass().setAll("btn-questao-DM");}
            if (args1 != null) { for (Label label : args1) label.setTextFill(Color.WHITE);}
            if (args2 != null) { for (Pane pane : args2) pane.setStyle("-fx-background-color: #282828");}
            if (args3 != null) { for (Shape shape : args3) shape.setStroke(Color.WHITE);}
            if (args4 != null) { for (Text text : args4) text.setFill(Color.WHITE);}
        } else {
            buttonHome.getStyleClass().setAll("btn-home");
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            questao.setFill(Color.BLACK);
            textEnunciado.setFill(Color.BLACK);
            if (args0 != null) { for (Button button : args0) button.getStyleClass().setAll("btn-questao");}
            if (args1 != null) { for (Label label : args1) label.setTextFill(Color.BLACK);}
            if (args2 != null) { for (Pane pane : args2) pane.setStyle(null);}
            if (args3 != null) { for (Shape shape : args3) shape.setStroke(Color.BLACK);}
            if (args4 != null) { for (Text text : args4) text.setFill(Color.BLACK);}
        }
    }
}