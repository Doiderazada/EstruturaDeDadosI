package controllers;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.util.Duration;
import questoes.EnunciadoDasQuestoes;
import questoes.Questao10;
import source.App;

public class Questao10Controller {
    
    @FXML
    private Button buttonConfirmar;

    @FXML
    private Button buttonHome;

    @FXML
    private Button buttonVoltar;

    @FXML
    private Label copyRight;

    @FXML
    private Label labelNumero;

    @FXML
    private VBox outputVBox;

    @FXML
    private Text questao;

    @FXML
    private BorderPane telaQuestao10;

    @FXML
    private Text textEnunciado;

    @FXML
    private Text textFormula;

    @FXML
    private Text textInteiro;

    @FXML
    private Text textOnde;

    @FXML
    private Text textResposta;

    @FXML
    private TextField tfNumero;

    Text textoMultiplo;
    Text textoText;
    HBox box;


    public void initialize() {
        acaoDosBotoes();
        
        
        textoMultiplo = new Text();
        textoMultiplo.setFont(Font.font(25));
        textoText = new Text("e ");
        textoText.setFont(Font.font(20));
        
        setStilo();
        exibirConteudo();
        outputVBox.setVisible(false);

        box = new HBox();
        box.getChildren().addAll(textoText, textoMultiplo);
        box.setAlignment(Pos.BASELINE_LEFT);
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
                    Questao10.setNumero(Integer.parseInt(tfNumero.getText()));
                    
                    if (Questao10.verificarParidade()) {
                        textoMultiplo.setText("K = " + Questao10.getMultiplo());
                        

                        textResposta.setText("O valor inserido é par, pois se aplica à formula:");
                        outputVBox.getChildren().add(box);

                    } else {
                        textResposta.setText("O valor inserido não é par, pois não se aplica à formula:");
                    }

                    outputVBox.setVisible(true);


                }
            }
            
        });

        tfNumero.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent arg0) {
                outputVBox.setVisible(false);
                outputVBox.getChildren().remove(box);
            }
            
        });

    }

    

    private boolean verificarInput() {
        

        if (tfNumero.getText().matches("[a-zA-Z]+")) {
            showPopup("O valor inserido não é válido, tente novamente");
            return false;
        } else if (tfNumero.getText().matches("[0-9^.]+")) { 
            double valor = Double.parseDouble(tfNumero.getText());

            if (valor == 0) {
                showPopup("O valor não pode ser 0");
                return false;
            }
        }

        return true;
    }





    private void showPopup(String texto) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/telaPopup.fxml"));
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
        textEnunciado.setText(EnunciadoDasQuestoes.questao10.substring(3));
    }


    
    private void setStilo() {
        if (App.darkMode) {
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            buttonHome.getStyleClass().setAll("btn-questao-DM");
            buttonConfirmar.getStyleClass().setAll("btn-questao-DM");
            telaQuestao10.setStyle("-fx-background-color: #282828");

            labelNumero.setTextFill(Paint.valueOf("WHITE"));
            
            questao.setFill(Paint.valueOf("WHITE"));
            textEnunciado.setFill(Paint.valueOf("WHITE"));
            textFormula.setFill(Paint.valueOf("WHITE"));
            textInteiro.setFill(Paint.valueOf("WHITE"));
            textOnde.setFill(Paint.valueOf("WHITE"));
            textResposta.setFill(Paint.valueOf("WHITE"));

            textoText.setFill(Paint.valueOf("WHITE"));
            textoMultiplo.setFill(Paint.valueOf("WHITE"));

            
        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            buttonConfirmar.getStyleClass().setAll("btn-questao");
            telaQuestao10.setStyle(null);

            labelNumero.setTextFill(Paint.valueOf("BLACK"));
            
            questao.setFill(Paint.valueOf("BLACK"));
            textEnunciado.setFill(Paint.valueOf("BLACK"));
            textFormula.setFill(Paint.valueOf("BLACK"));
            textInteiro.setFill(Paint.valueOf("BLACK"));
            textOnde.setFill(Paint.valueOf("BLACK"));
            textResposta.setFill(Paint.valueOf("BLACK"));

            textoText.setFill(Paint.valueOf("BLACK"));
            textoMultiplo.setFill(Paint.valueOf("BLACK"));

        }
    }
}