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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.util.Duration;
import questoes.EnunciadoDasQuestoes;
import questoes.Questao21;
import source.App;

public class Questao21Controller {
    
    @FXML private BorderPane telaQuestao21;
    @FXML private Button buttonConfirmar;
    @FXML private Button buttonHome;
    @FXML private Button buttonNovoNumero;
    @FXML private Button buttonVoltar;
    @FXML private Label copyRight;
    @FXML private Label labelNumero;
    @FXML private Text questao;
    @FXML private Text textEnunciado;
    @FXML private Text textResposta;
    @FXML private TextField tfNumero;
    @FXML private VBox vBoxOutput;
    @FXML private VBox vBoxInput;

    public void initialize() {
        acaoDosBotoes();
        setStilo();
        exibirConteudo();

        vBoxOutput.setVisible(false);
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
                    int num = Integer.parseInt(tfNumero.getText());

                    if(Questao21.verificarPrimo(num)) textResposta.setText("O número é primo");
                    else {
                        int mult = Questao21.getMult();

                        textResposta.setText("O número não é primo, pois é múltiplo de " + mult);
                    }

                    vBoxInput.setVisible(false);
                    vBoxOutput.setVisible(true);

                }
            }
            
        });

        buttonNovoNumero.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                tfNumero.clear();
                vBoxOutput.setVisible(false);
                vBoxInput.setVisible(true);
            }
            
        });

        
    }


    private boolean verificarInput() {
        
        if (tfNumero.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente");
            return false;
        } else if (tfNumero.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras");
            return false;
        } else if (tfNumero.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfNumero.getText());
            if (num < 1 ) {
                showPopup("Por favor, entre com um número positivo");
                return false;
            }
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
        textEnunciado.setText(EnunciadoDasQuestoes.questao21.substring(3));
    }


    
    private void setStilo() {
        if (App.darkMode) {
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            buttonHome.getStyleClass().setAll("btn-questao-DM");
            buttonConfirmar.getStyleClass().setAll("btn-questao-DM");
            buttonNovoNumero.getStyleClass().setAll("btn-questao-DM");
            telaQuestao21.setStyle("-fx-background-color: #282828");
            
            labelNumero.setTextFill(Paint.valueOf("WHITE"));

            questao.setFill(Paint.valueOf("WHITE"));
            textEnunciado.setFill(Paint.valueOf("WHITE"));
            textResposta.setFill(Paint.valueOf("WHITE"));
            
        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            buttonConfirmar.getStyleClass().setAll("btn-questao");
            buttonNovoNumero.getStyleClass().setAll("btn-questao");
            telaQuestao21.setStyle(null);

            labelNumero.setTextFill(Paint.valueOf("BLACK"));

            questao.setFill(Paint.valueOf("BLACK"));
            textEnunciado.setFill(Paint.valueOf("BLACK"));
            textResposta.setFill(Paint.valueOf("BLACK"));
        }
    }
}
