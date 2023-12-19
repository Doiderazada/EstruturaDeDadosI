package controllers;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.util.Duration;
import questoes.EnunciadoDasQuestoes;
import questoes.Questao16;
import source.App;

public class Questao16Controller {

    @FXML private BorderPane telaQuestao16;
    @FXML private Button buttonConfirmar;
    @FXML private Button buttonHome;
    @FXML private Button buttonVoltar;
    @FXML private Label copyRight;
    @FXML private Label labelNumeroFinal;
    @FXML private Label labelNumeroInicial;
    @FXML private HBox hBoxOutput;
    @FXML private Text questao;
    @FXML private Text textDoWhile;
    @FXML private Text textEnunciado;
    @FXML private Text textFor;
    @FXML private Text textRespostaDoWhile;
    @FXML private Text textRespostaFor;
    @FXML private Text textRespostaWhile;
    @FXML private Text textWhile;
    @FXML private TextField tfNumero1;
    @FXML private TextField tfNumero2;


    public void initialize() {
        acaoDosBotoes();
        setStilo();
        exibirConteudo();
        hBoxOutput.setVisible(false);
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


        buttonConfirmar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (verificarInput()) {
                    Questao16.setNumInicial(Integer.parseInt(tfNumero1.getText()));
                    Questao16.setNumFinal(Integer.parseInt(tfNumero2.getText()));
                    
                    textRespostaFor.setText(Questao16.contarFor());
                    textRespostaDoWhile.setText(Questao16.contarDoWhile());
                    textRespostaWhile.setText(Questao16.contarWhile());
                    

                    hBoxOutput.setVisible(true);

                }
            }
            
        });

        
        tfNumero1.setOnKeyTyped(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent arg0) {
                hBoxOutput.setVisible(false);
            }
            
        });
        
        tfNumero2.setOnKeyTyped(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent arg0) {
                hBoxOutput.setVisible(false);
            }
            
        });
    }

    
    



    private boolean verificarInput() {
        
        if (tfNumero1.getText().matches("[\\D]+")) {
            showPopup("O campo não pode conter letras, tente novamente");
            return false;
        }
        
        if (tfNumero2.getText().matches("[\\D]+")) {
            showPopup("O campo não pode conter letras, tente novamente");
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
            
            double winX = buttonConfirmar.getScene().getWindow().getX();
            double winY = buttonConfirmar.getScene().getWindow().getY();
            double halfX = buttonConfirmar.getScene().getWindow().getWidth()/2;
            double halfY = buttonConfirmar.getScene().getWindow().getHeight()/2;

            double newX = (winX + halfX) - (popup.getWidth()/2);
            double newY = (winY + halfY) - (popup.getHeight()/2);

            popup.setX(newX);
            popup.setY(newY);
            
            
            popup.show(buttonConfirmar.getScene().getWindow());

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
        textEnunciado.setText(EnunciadoDasQuestoes.questao16.substring(3));
    }


    
    private void setStilo() {
        if (App.darkMode) {
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            buttonHome.getStyleClass().setAll("btn-questao-DM");
            buttonConfirmar.getStyleClass().setAll("btn-questao-DM");
            telaQuestao16.setStyle("-fx-background-color: #282828");

            labelNumeroFinal.setTextFill(Paint.valueOf("WHITE"));
            labelNumeroInicial.setTextFill(Paint.valueOf("WHITE"));
            
            questao.setFill(Paint.valueOf("WHITE"));
            textEnunciado.setFill(Paint.valueOf("WHITE"));
            textDoWhile.setFill(Paint.valueOf("WHITE"));
            textFor.setFill(Paint.valueOf("WHITE"));
            textWhile.setFill(Paint.valueOf("WHITE"));

            textRespostaDoWhile.setFill(Paint.valueOf("WHITE"));
            textRespostaFor.setFill(Paint.valueOf("WHITE"));
            textRespostaWhile.setFill(Paint.valueOf("WHITE"));
            
        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            buttonConfirmar.getStyleClass().setAll("btn-questao");
            telaQuestao16.setStyle(null);


            labelNumeroFinal.setTextFill(Paint.valueOf("BLACK"));
            labelNumeroInicial.setTextFill(Paint.valueOf("BLACK"));

            
            questao.setFill(Paint.valueOf("BLACK"));
            textEnunciado.setFill(Paint.valueOf("BLACK"));
            textDoWhile.setFill(Paint.valueOf("BLACK"));
            textFor.setFill(Paint.valueOf("BLACK"));
            textWhile.setFill(Paint.valueOf("BLACK"));


            textRespostaDoWhile.setFill(Paint.valueOf("BLACK"));
            textRespostaFor.setFill(Paint.valueOf("BLACK"));
            textRespostaWhile.setFill(Paint.valueOf("BLACK"));
        }
    }
}