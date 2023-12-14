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
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.util.Duration;
import questoes.EnunciadoDasQuestoes;
import questoes.Questao5;
import source.App;

public class Questao5Controller {

    @FXML private BorderPane telaQuestao4;
    @FXML private Button buttonConfirmar;
    @FXML private Button buttonHome;
    @FXML private Button buttonVoltar;
    @FXML private HBox outputHBox;
    @FXML private Label copyRight;
    @FXML private Label labelValA;
    @FXML private Label labelValB;
    @FXML private Label labelValC;
    @FXML private Line divLine;
    @FXML private Text igual;
    @FXML private Text plusSign1;
    @FXML private Text plusSign2;
    @FXML private Text questao;
    @FXML private Text textEnunciado;
    @FXML private Text textResultado;
    @FXML private Text textValA;
    @FXML private Text textValB;
    @FXML private Text textValC;
    @FXML private Text tres;
    @FXML private TextField tfValA;
    @FXML private TextField tfValB;
    @FXML private TextField tfValC;
    @FXML private VBox inputVBox;


    public void initialize() {
        acaoDosBotoes();
        setStilo();
        exibirConteudo();
        outputHBox.setVisible(false);
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
                
                Questao5.setValA(Float.valueOf(tfValA.getText()));                
                Questao5.setValB(Float.valueOf(tfValB.getText()));
                Questao5.setValC(Float.parseFloat(tfValC.getText()));

                textResultado.setText(String.valueOf(Questao5.media()));
                textValA.setText(tfValA.getText());
                textValB.setText(tfValB.getText());
                textValC.setText(tfValC.getText());

                outputHBox.setVisible(true);
            }
            
        });


        Tooltip texto = new Tooltip("Texto copiado");
        
        Tooltip mensagemSubliminar = new Tooltip("Boa escolha");
        mensagemSubliminar.setShowDelay(Duration.millis(100));
        mensagemSubliminar.setShowDuration(Duration.millis(300));
        Tooltip.install(copyRight, mensagemSubliminar);
        

        textResultado.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(textResultado.getText());
                clipboard.setContent(content);

                Tooltip.install(textResultado, texto);
                texto.setAutoHide(true);
                texto.fireEvent(arg0);
                texto.centerOnScreen();
                texto.show(telaQuestao4.getScene().getWindow());
            }
        });
        textResultado.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                texto.hide();
                Tooltip.uninstall(textResultado, texto);
            }
        });
    }

    

    private void exibirConteudo() {
        textEnunciado.setText(EnunciadoDasQuestoes.questao5.substring(3));
    }


    
    private void setStilo() {
        if (App.darkMode) {
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            buttonHome.getStyleClass().setAll("btn-questao-DM");
            buttonConfirmar.getStyleClass().setAll("btn-questao-DM");
            telaQuestao4.setStyle("-fx-background-color: #282828");

            plusSign1.setFill(Paint.valueOf("WHITE"));
            plusSign2.setFill(Paint.valueOf("WHITE"));
            igual.setFill(Paint.valueOf("WHITE"));
            tres.setFill(Paint.valueOf("WHITE"));
            divLine.setStroke(Paint.valueOf("WHITE"));

            labelValA.setTextFill(Paint.valueOf("WHITE"));
            labelValB.setTextFill(Paint.valueOf("WHITE"));
            labelValC.setTextFill(Paint.valueOf("WHITE"));
            
            questao.setFill(Paint.valueOf("WHITE"));
            textEnunciado.setFill(Paint.valueOf("WHITE"));
            textResultado.setFill(Paint.valueOf("WHITE"));
            textValA.setFill(Paint.valueOf("WHITE"));
            textValB.setFill(Paint.valueOf("WHITE"));
            textValC.setFill(Paint.valueOf("WHITE"));
        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            buttonConfirmar.getStyleClass().setAll("btn-questao");
            telaQuestao4.setStyle(null);

            plusSign1.setFill(Paint.valueOf("BLACK"));
            plusSign2.setFill(Paint.valueOf("BLACK"));
            igual.setFill(Paint.valueOf("BLACK"));
            tres.setFill(Paint.valueOf("BLACK"));
            divLine.setStroke(Paint.valueOf("BLACK"));

            labelValA.setTextFill(Paint.valueOf("BLACK"));
            labelValB.setTextFill(Paint.valueOf("BLACK"));
            labelValC.setTextFill(Paint.valueOf("BLACK"));
            
            questao.setFill(Paint.valueOf("BLACK"));
            textEnunciado.setFill(Paint.valueOf("BLACK"));
            textResultado.setFill(Paint.valueOf("BLACK"));
            textValA.setFill(Paint.valueOf("BLACK"));
            textValB.setFill(Paint.valueOf("BLACK"));
            textValC.setFill(Paint.valueOf("BLACK"));
        }
    }
}