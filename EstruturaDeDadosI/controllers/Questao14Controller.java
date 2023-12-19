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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.util.Duration;
import questoes.EnunciadoDasQuestoes;
import questoes.Questao14;
import source.App;

public class Questao14Controller {

    @FXML private BorderPane telaQuestao14;
    @FXML private Button buttonConfirmar;
    @FXML private Button buttonHome;
    @FXML private Button buttonVoltar;
    @FXML private Label copyRight;
    @FXML private Label labelTermoA;
    @FXML private Label labelTermoB;
    @FXML private Label labelTermoC;
    @FXML private Line divLine;
    @FXML private Text questao;
    @FXML private Text Raiz;
    @FXML private Text sinalMaisOuMenos;
    @FXML private Text sinalMenos;
    @FXML private Text sinalTermoB;
    @FXML private Text sinalTermoC;
    @FXML private Text text2X;
    @FXML private Text textDeltaBhaskara;
    @FXML private Text textEnunciado;
    @FXML private Text textIgualZero;
    @FXML private Text textSeta;
    @FXML private Text textTermoA;
    @FXML private Text textTermoABhaskara;
    @FXML private Text textTermoB;
    @FXML private Text textTermoBBhaskara;
    @FXML private Text textTermoC;
    @FXML private Text textValX1;
    @FXML private Text textValX2;
    @FXML private Text textX;
    @FXML private Text textX1;
    @FXML private Text textX2;
    @FXML private Text textXQuadrado;
    @FXML private TextField tfTermoA;
    @FXML private TextField tfTermoB;
    @FXML private TextField tfTermoC;
    @FXML private VBox vBoxOutput;


    public void initialize() {
        acaoDosBotoes();
        setStilo();
        exibirConteudo();
        vBoxOutput.setVisible(false);
    }





    private void acaoDosBotoes() {
        Tooltip mensagemSubliminar = new Tooltip("Agora sim, essa é melhor");
        mensagemSubliminar.setShowDelay(Duration.millis(100));
        mensagemSubliminar.setShowDuration(Duration.millis(800));
        Tooltip.install(copyRight, mensagemSubliminar);

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
                    Questao14.setTermoA(Double.parseDouble(tfTermoA.getText()));
                    Questao14.setTermoB(Double.parseDouble(tfTermoB.getText()));
                    Questao14.setTermoC(Double.parseDouble(tfTermoC.getText()));

                    Questao14.calcularRaiz();

                    organizarOutput();

                    vBoxOutput.setVisible(true);
                }
            }
            
        });

        tfTermoA.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent arg0) {
                vBoxOutput.setVisible(false);
            }
            
        });
        
        tfTermoB.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent arg0) {
                vBoxOutput.setVisible(false);
            }
            
        });
        
        tfTermoC.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent arg0) {
                vBoxOutput.setVisible(false);
            }
            
        });

    }

    
    private void organizarOutput() {

        if (tfTermoA.getText().contentEquals("1")) textTermoA.setText("");
        else textTermoA.setText(tfTermoA.getText());



        if (tfTermoA.getText().startsWith("-")) 
        textTermoABhaskara.setText("(" + tfTermoA.getText() + ")");
        else textTermoABhaskara.setText(tfTermoA.getText());
        

        if (tfTermoB.getText().startsWith("-")) {
            sinalTermoB.setText("-");
            textTermoB.setText(tfTermoB.getText().replace("-", ""));
            textTermoBBhaskara.setText("(" + tfTermoB.getText() + ")");
        } else {
            sinalTermoB.setText("+");
            textTermoB.setText(tfTermoB.getText());
            textTermoBBhaskara.setText(tfTermoB.getText());
        }

        if (tfTermoC.getText().startsWith("-")) {
            sinalTermoC.setText("-");
            textTermoC.setText(tfTermoC.getText().replace("-", ""));
        } else {
            sinalTermoC.setText("+");
            textTermoC.setText(tfTermoC.getText());
        }


        textDeltaBhaskara.setText(String.valueOf(Questao14.getDelta()));

        textValX1.setText(String.valueOf(Questao14.getX1()));
        textValX2.setText(String.valueOf(Questao14.getX2()));

    }



    private boolean verificarInput() {
        

        if (tfTermoA.getText().matches("[a-zA-Z]+")) {
            showPopup("O valor inserido não é válido, tente novamente");
            return false;
        } else if (tfTermoA.getText().matches("[\\d^.]+")) { 
            double valor = Double.parseDouble(tfTermoA.getText());

            if (valor < 0) {
                showPopup("O termo A não pode ser 0 para uma equação de segundo grau");
                return false;
            }

        }
        
        
        if (tfTermoB.getText().matches("[a-zA-Z]+")) {
            showPopup("O valor inserido não é válido, tente novamente");
            return false;
        }
        
        
        if (tfTermoC.getText().matches("[a-zA-Z]+")) {
            showPopup("O valor inserido não é válido, tente novamente");
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
        textEnunciado.setText(EnunciadoDasQuestoes.questao14.substring(3));
    }


    
    private void setStilo() {
        if (App.darkMode) {
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            buttonHome.getStyleClass().setAll("btn-questao-DM");
            buttonConfirmar.getStyleClass().setAll("btn-questao-DM");
            telaQuestao14.setStyle("-fx-background-color: #282828");

            labelTermoA.setTextFill(Paint.valueOf("WHITE"));
            labelTermoB.setTextFill(Paint.valueOf("WHITE"));
            labelTermoC.setTextFill(Paint.valueOf("WHITE"));
            
            questao.setFill(Paint.valueOf("WHITE"));
            Raiz.setFill(Paint.valueOf("WHITE"));
            sinalMaisOuMenos.setFill(Paint.valueOf("WHITE"));
            sinalMenos.setFill(Paint.valueOf("WHITE"));
            sinalTermoB.setFill(Paint.valueOf("WHITE"));
            sinalTermoC.setFill(Paint.valueOf("WHITE"));
            text2X.setFill(Paint.valueOf("WHITE"));
            textDeltaBhaskara.setFill(Paint.valueOf("WHITE"));
            textEnunciado.setFill(Paint.valueOf("WHITE"));
            textIgualZero.setFill(Paint.valueOf("WHITE"));
            textSeta.setFill(Paint.valueOf("WHITE"));
            textTermoA.setFill(Paint.valueOf("WHITE"));
            textTermoABhaskara.setFill(Paint.valueOf("WHITE"));
            textTermoB.setFill(Paint.valueOf("WHITE"));
            textTermoBBhaskara.setFill(Paint.valueOf("WHITE"));
            textTermoC.setFill(Paint.valueOf("WHITE"));
            textValX1.setFill(Paint.valueOf("WHITE"));
            textValX2.setFill(Paint.valueOf("WHITE"));
            textX.setFill(Paint.valueOf("WHITE"));
            textX1.setFill(Paint.valueOf("WHITE"));
            textX2.setFill(Paint.valueOf("WHITE"));
            textXQuadrado.setFill(Paint.valueOf("WHITE"));

            divLine.setStroke(Paint.valueOf("WHITE"));
            
        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            buttonConfirmar.getStyleClass().setAll("btn-questao");
            telaQuestao14.setStyle(null);


            labelTermoA.setTextFill(Paint.valueOf("BLACK"));
            labelTermoB.setTextFill(Paint.valueOf("BLACK"));
            labelTermoC.setTextFill(Paint.valueOf("BLACK"));

            
            questao.setFill(Paint.valueOf("BLACK"));
            Raiz.setFill(Paint.valueOf("BLACK"));
            sinalMaisOuMenos.setFill(Paint.valueOf("BLACK"));
            sinalMenos.setFill(Paint.valueOf("BLACK"));
            sinalTermoB.setFill(Paint.valueOf("BLACK"));
            sinalTermoC.setFill(Paint.valueOf("BLACK"));
            text2X.setFill(Paint.valueOf("BLACK"));
            textDeltaBhaskara.setFill(Paint.valueOf("BLACK"));
            textEnunciado.setFill(Paint.valueOf("BLACK"));
            textIgualZero.setFill(Paint.valueOf("BLACK"));
            textSeta.setFill(Paint.valueOf("BLACK"));
            textTermoA.setFill(Paint.valueOf("BLACK"));
            textTermoABhaskara.setFill(Paint.valueOf("BLACK"));
            textTermoB.setFill(Paint.valueOf("BLACK"));
            textTermoBBhaskara.setFill(Paint.valueOf("BLACK"));
            textTermoC.setFill(Paint.valueOf("BLACK"));
            textValX1.setFill(Paint.valueOf("BLACK"));
            textValX2.setFill(Paint.valueOf("BLACK"));
            textX.setFill(Paint.valueOf("BLACK"));
            textX1.setFill(Paint.valueOf("BLACK"));
            textX2.setFill(Paint.valueOf("BLACK"));
            textXQuadrado.setFill(Paint.valueOf("BLACK"));

            divLine.setStroke(Paint.valueOf("BLACK"));
        }
    }
}