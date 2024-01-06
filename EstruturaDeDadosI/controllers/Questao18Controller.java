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
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.util.Duration;
import questoes.EnunciadoDasQuestoes;
import questoes.Questao18;
import source.App;

public class Questao18Controller {

    
    @FXML private BorderPane telaQuestao18;
    @FXML private Button buttonConfirmar;
    @FXML private Button buttonHome;
    @FXML private Button buttonVoltar;
    @FXML private Label copyRight;
    @FXML private Label labelSenha;
    @FXML private Text questao;
    @FXML private Text textEnunciado;
    @FXML private TextField tfSenha;


    public void initialize() {
        acaoDosBotoes();
        setStilo();
        exibirConteudo();

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
                    String senha = tfSenha.getText();
                    System.out.println(senha);
                    if (Questao18.validarSenha(senha)) {
                        showPopup("Senha correta! \nFim do programa", true);
                        App.trocarDeTela("telaQuestoes");
                        
                    } else showPopup("Senha incorreta, tente novamente", false);

                }
            }
            
        });


        Tooltip mensagemSubliminar = new Tooltip("senhaDeDoidera123");
        mensagemSubliminar.setShowDelay(Duration.millis(100));
        mensagemSubliminar.setShowDuration(Duration.millis(800));
        Tooltip.install(copyRight, mensagemSubliminar);
        
    }

    
    



    private boolean verificarInput() {
        
        if (tfSenha.getText().isEmpty()) {
            showPopup("O campo vazio, tente novamente", false);
            return false;
        }

        return true;
    }





    private void showPopup(String texto, boolean isSucess) {
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





    private void exibirConteudo() { 
        questao.setText(questao.getText() + "\t");
        textEnunciado.setText(EnunciadoDasQuestoes.questao18.substring(3));
    }


    
    private void setStilo() {
        if (App.darkMode) {
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            buttonHome.getStyleClass().setAll("btn-questao-DM");
            buttonConfirmar.getStyleClass().setAll("btn-questao-DM");
            telaQuestao18.setStyle("-fx-background-color: #282828");

            labelSenha.setTextFill(Paint.valueOf("WHITE"));
            
            questao.setFill(Paint.valueOf("WHITE"));
            textEnunciado.setFill(Paint.valueOf("WHITE"));
            
        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            buttonConfirmar.getStyleClass().setAll("btn-questao");
            telaQuestao18.setStyle(null);

            labelSenha.setTextFill(Paint.valueOf("BLACK"));
            
            questao.setFill(Paint.valueOf("BLACK"));
            textEnunciado.setFill(Paint.valueOf("BLACK"));
        }
    }
}