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
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.util.Duration;
import questoes.EnunciadoDasQuestoes;
import questoes.Questao24;
import source.App;

public class Questao24Controller {

    
    @FXML private BorderPane telaQuestao24;
    @FXML private Button buttonCalcFatorial;
    @FXML private Button buttonCalcPotencia;
    @FXML private Button buttonCalcRaiz;
    @FXML private Button buttonFatorial;
    @FXML private Button buttonHome;
    @FXML private Button buttonPotencia;
    @FXML private Button buttonRaiz;
    @FXML private Button buttonVoltar;
    @FXML private HBox hBoxParent;
    @FXML private Label copyRight;
    @FXML private Label labelBase;
    @FXML private Label labelExpoente;
    @FXML private Label labelFatorial;
    @FXML private Label labelRaiz;
    @FXML private Text questao;
    @FXML private Text textEnunciado;
    @FXML private Text textResposta;
    @FXML private TextField tfBase;
    @FXML private TextField tfExpoente;
    @FXML private TextField tfFatorial;
    @FXML private TextField tfRaiz;
    @FXML private VBox vBoxButtons;
    @FXML private VBox vBoxFatorial;
    @FXML private VBox vBoxPotencia;
    @FXML private VBox vBoxRaiz;


    private int resultadoFatorial;
    private double resultadoPotencia;
    private double resultadoRaiz;
    private boolean fatorial = false, potencia = false, raiz = false;

    public void initialize() {
        acaoDosBotoes();
        setStilo();
        estadoInicial();
        exibirConteudo();

    }





    private void estadoInicial() {
        hBoxParent.getChildren().removeAll(vBoxFatorial, vBoxPotencia, vBoxRaiz, textResposta);

        tfBase.clear();
        tfExpoente.clear();
        tfFatorial.clear();
        tfRaiz.clear();
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

        buttonFatorial.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                estadoInicial();
                hBoxParent.getChildren().add(vBoxFatorial);
            }
            
        });
        buttonPotencia.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                estadoInicial();
                hBoxParent.getChildren().add(vBoxPotencia);
            }
            
        });
        buttonRaiz.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                estadoInicial();
                hBoxParent.getChildren().add(vBoxRaiz);
            }
            
        });


        buttonCalcFatorial.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (verificarFator()) {
                    int fator = Integer.parseInt(tfFatorial.getText());
                    resultadoFatorial = Questao24.calcFactor(fator);

                    textResposta.setText("O resultado é: " + resultadoFatorial);
                    fatorial = true; potencia = false; raiz = false;

                    hBoxParent.getChildren().remove(vBoxFatorial);
                    hBoxParent.getChildren().add(textResposta);
                }
            }
            
        });
        buttonCalcPotencia.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (verificarPotencia()) {
                    int base = Integer.parseInt(tfBase.getText());
                    int expoente = Integer.parseInt(tfExpoente.getText());
                    resultadoPotencia = Questao24.calcPower(base, expoente);

                    textResposta.setText("O resultado é: " + resultadoPotencia);
                    fatorial = false; potencia = true; raiz = false;
                    
                    hBoxParent.getChildren().remove(vBoxPotencia);
                    hBoxParent.getChildren().add(textResposta);
                }
            }
            
        });
        buttonCalcRaiz.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (verificarRaiz()) {
                    int radical = Integer.parseInt(tfRaiz.getText());
                    resultadoRaiz = Questao24.calcRoot(radical);

                    textResposta.setText("O resultado é: " + resultadoRaiz);
                    fatorial = false; potencia = false; raiz = true;
                    
                    hBoxParent.getChildren().remove(vBoxRaiz);
                    hBoxParent.getChildren().add(textResposta);
                }
            }
            
        });



        Tooltip texto = new Tooltip("Texto copiado com sucesso");
        

        textResposta.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                
                Tooltip.install(textResposta, texto);
                
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();

                if (fatorial) {
                    content.putString(String.valueOf(resultadoFatorial));
                    clipboard.setContent(content);
                }
                if (potencia) {
                    content.putString(String.valueOf(resultadoPotencia));
                    clipboard.setContent(content);
                }
                if (raiz) {
                    content.putString(String.valueOf(resultadoRaiz));
                    clipboard.setContent(content);
                }
                

                texto.setAutoHide(true);
                texto.fireEvent(arg0);
                texto.centerOnScreen();

                texto.show(telaQuestao24.getScene().getWindow());
            }
        });
        textResposta.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                texto.hide();
                Tooltip.uninstall(textResposta, texto);
            }
        });
        
    }

    
    



    private boolean verificarFator() {
        
        if (tfFatorial.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente");
            return false;
        } else if (tfFatorial.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras");
            return false;
        } else if (tfFatorial.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfFatorial.getText());
            if (num < 0) {
                showPopup("O número não pode ser negativo");
                return false;
            }
        }

        return true;
    }
    private boolean verificarPotencia() {
        
        if (tfExpoente.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente");
            return false;
        } else if (tfExpoente.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras");
            return false;
        }
        if (tfBase.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente");
            return false;
        } else if (tfBase.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras");
            return false;
        }

        return true;
    }
    private boolean verificarRaiz() {
        
        if (tfRaiz.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente");
            return false;
        } else if (tfRaiz.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras");
            return false;
        } else if (tfRaiz.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfRaiz.getText());
            if (num < 1) {
                showPopup("O número não pode ser menor que 1");
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
        textEnunciado.setText(EnunciadoDasQuestoes.questao24.substring(3));
    }


    
    private void setStilo() {
        if (App.darkMode) {
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            buttonHome.getStyleClass().setAll("btn-questao-DM");
            buttonCalcFatorial.getStyleClass().setAll("btn-questao-DM");
            buttonCalcPotencia.getStyleClass().setAll("btn-questao-DM");
            buttonCalcRaiz.getStyleClass().setAll("btn-questao-DM");
            buttonCalcFatorial.getStyleClass().setAll("btn-questao-DM");
            buttonFatorial.getStyleClass().setAll("btn-factor-DM");
            buttonPotencia.getStyleClass().setAll("btn-power-DM");
            buttonRaiz.getStyleClass().setAll("btn-root-DM");
            telaQuestao24.setStyle("-fx-background-color: #282828");

            labelBase.setTextFill(Paint.valueOf("WHITE"));
            labelExpoente.setTextFill(Paint.valueOf("WHITE"));
            labelFatorial.setTextFill(Paint.valueOf("WHITE"));
            labelRaiz.setTextFill(Paint.valueOf("WHITE"));
            
            questao.setFill(Paint.valueOf("WHITE"));
            textEnunciado.setFill(Paint.valueOf("WHITE"));
            textResposta.setFill(Paint.valueOf("WHITE"));
            
        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            buttonCalcFatorial.getStyleClass().setAll("btn-questao");
            buttonCalcPotencia.getStyleClass().setAll("btn-questao");
            buttonCalcRaiz.getStyleClass().setAll("btn-questao");
            buttonFatorial.getStyleClass().setAll("btn-factor");
            buttonPotencia.getStyleClass().setAll("btn-power");
            buttonRaiz.getStyleClass().setAll("btn-root");
            telaQuestao24.setStyle(null);

            labelBase.setTextFill(Paint.valueOf("BLACK"));
            labelExpoente.setTextFill(Paint.valueOf("BLACK"));
            labelFatorial.setTextFill(Paint.valueOf("BLACK"));
            labelRaiz.setTextFill(Paint.valueOf("BLACK"));
            
            questao.setFill(Paint.valueOf("BLACK"));
            textEnunciado.setFill(Paint.valueOf("BLACK"));
            textResposta.setFill(Paint.valueOf("BLACK"));
        }
    }
}