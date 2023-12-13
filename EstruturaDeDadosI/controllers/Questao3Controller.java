package controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
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
import questoes.EnunciadoDasQuestoes;
import questoes.Questao3;
import source.App;

public class Questao3Controller {
    
    @FXML private BorderPane telaQuestao3;
    @FXML private Button buttonConfirmar;
    @FXML private Button buttonHome;
    @FXML private Button buttonVoltar;
    @FXML private HBox outputHBox;
    @FXML private Label copyRight;
    @FXML private Label labelValA;
    @FXML private Label labelValB;
    @FXML private Text divisao;
    @FXML private Text multiplicacao;
    @FXML private Text questao;
    @FXML private Text resto;
    @FXML private Text resultadoDiv;
    @FXML private Text resultadoMod;
    @FXML private Text resultadoMult;
    @FXML private Text resultadoSoma;
    @FXML private Text resultadoSub;
    @FXML private Text soma;
    @FXML private Text subtracao;
    @FXML private Text textEnunciado;
    @FXML private TextField tfValA;
    @FXML private TextField tfValB;
    @FXML private VBox inputVBox;


    public void initialize() {
        acaoDosBotoes();
        setStilo();
        exibirConteudo();
        outputHBox.setVisible(false);
        inputVBox.setVisible(true);
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
                Questao3.setValA(Integer.valueOf(tfValA.getText()));                
                Questao3.setValB(Integer.valueOf(tfValB.getText()));

                soma.setText(tfValA.getText() + " + " + tfValB.getText() + " = ");
                subtracao.setText(tfValA.getText() + " - " + tfValB.getText() + " = ");
                multiplicacao.setText(tfValA.getText() + " * " + tfValB.getText() + " = ");
                divisao.setText(tfValA.getText() + " / " + tfValB.getText() + " = ");
                resto.setText(tfValA.getText() + " % " + tfValB.getText() + " = ");
                
                
                resultadoSoma.setText(String.valueOf(Questao3.somar()));
                resultadoSub.setText(String.valueOf(Questao3.subtrair()));
                resultadoMult.setText(String.valueOf(Questao3.multiplicar()));
                resultadoDiv.setText(String.valueOf(Questao3.dividir()));
                resultadoMod.setText(String.valueOf(Questao3.modulo()));


                outputHBox.setVisible(true);
            }
            
        });


        Tooltip texto = new Tooltip("Texto copiado");
        

        resultadoSoma.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(resultadoSoma.getText());
                clipboard.setContent(content);

                Tooltip.install(resultadoSoma, texto);
                texto.setAutoHide(true);
                texto.fireEvent(arg0);
                texto.centerOnScreen();
                texto.show(telaQuestao3.getScene().getWindow());
            }
        });
        resultadoSoma.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                texto.hide();
                Tooltip.uninstall(resultadoSoma, texto);
            }
        });
        

        resultadoSub.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(resultadoSoma.getText());
                clipboard.setContent(content);
                
                Tooltip.install(resultadoSub, texto);
                texto.setAutoHide(true);
                texto.fireEvent(arg0);
                texto.centerOnScreen();
                texto.show(telaQuestao3.getScene().getWindow());
            } 
        });
        resultadoSub.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                texto.hide();
                Tooltip.uninstall(resultadoSub, texto);
            }
        });
        

        resultadoMult.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(resultadoSoma.getText());
                clipboard.setContent(content);
                
                Tooltip.install(resultadoMult, texto);
                texto.setAutoHide(true);
                texto.fireEvent(arg0);
                texto.centerOnScreen();
                texto.show(telaQuestao3.getScene().getWindow());
            }
        });
        resultadoMult.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                texto.hide();
                Tooltip.uninstall(resultadoMult, texto);
            } 
        });
        

        resultadoDiv.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(resultadoSoma.getText());
                clipboard.setContent(content);
                
                Tooltip.install(resultadoDiv, texto);
                texto.setAutoHide(true);
                texto.fireEvent(arg0);
                texto.centerOnScreen();
                texto.show(telaQuestao3.getScene().getWindow());
            }
        });
        resultadoDiv.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                texto.hide();
                Tooltip.uninstall(resultadoDiv, texto);
            }
        });
        
        resultadoMod.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(resultadoSoma.getText());
                clipboard.setContent(content);
                
                Tooltip.install(resultadoMod, texto);
                texto.setAutoHide(true);
                texto.fireEvent(arg0);
                texto.centerOnScreen();
                texto.show(telaQuestao3.getScene().getWindow());
            }
        });
        resultadoMod.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                texto.hide();
                Tooltip.uninstall(resultadoMod, texto);
            }
        });
        
    }

    

    private void exibirConteudo() {
        textEnunciado.setText(EnunciadoDasQuestoes.questao3.substring(3));
    }


    
    private void setStilo() {
        if (App.darkMode) {
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            buttonHome.getStyleClass().setAll("btn-questao-DM");
            buttonConfirmar.getStyleClass().setAll("btn-questao-DM");
            telaQuestao3.setStyle("-fx-background-color: #282828");

            divisao.setFill(Paint.valueOf("WHITE"));
            multiplicacao.setFill(Paint.valueOf("WHITE"));
            soma.setFill(Paint.valueOf("WHITE"));
            subtracao.setFill(Paint.valueOf("WHITE"));
            resto.setFill(Paint.valueOf("WHITE"));
            labelValA.setTextFill(Paint.valueOf("WHITE"));
            labelValB.setTextFill(Paint.valueOf("WHITE"));
            
            questao.setFill(Paint.valueOf("WHITE"));
            textEnunciado.setFill(Paint.valueOf("WHITE"));
            resultadoDiv.setFill(Paint.valueOf("WHITE"));
            resultadoMod.setFill(Paint.valueOf("WHITE"));
            resultadoMult.setFill(Paint.valueOf("WHITE"));
            resultadoSoma.setFill(Paint.valueOf("WHITE"));
            resultadoSub.setFill(Paint.valueOf("WHITE"));
        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            buttonConfirmar.getStyleClass().setAll("btn-questao");
            telaQuestao3.setStyle(null);

            divisao.setFill(Paint.valueOf("BLACK"));
            multiplicacao.setFill(Paint.valueOf("BLACK"));
            soma.setFill(Paint.valueOf("BLACK"));
            subtracao.setFill(Paint.valueOf("BLACK"));
            resto.setFill(Paint.valueOf("BLACK"));
            labelValA.setTextFill(Paint.valueOf("BLACK"));
            labelValB.setTextFill(Paint.valueOf("BLACK"));
            
            questao.setFill(Paint.valueOf("BLACK"));
            textEnunciado.setFill(Paint.valueOf("BLACK"));
            resultadoDiv.setFill(Paint.valueOf("BLACK"));
            resultadoMod.setFill(Paint.valueOf("BLACK"));
            resultadoMult.setFill(Paint.valueOf("BLACK"));
            resultadoSoma.setFill(Paint.valueOf("BLACK"));
            resultadoSub.setFill(Paint.valueOf("BLACK"));
        }
    }
}