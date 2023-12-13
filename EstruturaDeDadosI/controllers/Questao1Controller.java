package controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import questoes.EnunciadoDasQuestoes;
import questoes.Questao1;
import source.App;

public class Questao1Controller {
    
    @FXML private BorderPane telaQuestao1;
    @FXML private Button buttonHome;
    @FXML private Button buttonVoltar;
    @FXML private Label copyRight;
    @FXML private Text altura;
    @FXML private Text idade;
    @FXML private Text inicial;
    @FXML private Text nomeCompleto;
    @FXML private Text questao;
    @FXML private Text textAltura;
    @FXML private Text textEnunciado;
    @FXML private Text textIdade;
    @FXML private Text textInicial;
    @FXML private Text textNome;


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

        Tooltip texto = new Tooltip("Texto copiado");
        Tooltip.install(textNome, texto);
        

        textNome.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(textNome.getText());
                clipboard.setContent(content);

                texto.setAutoHide(true);
                texto.fireEvent(arg0);
                texto.centerOnScreen();

                texto.show(telaQuestao1.getScene().getWindow());
            }
        });
        textNome.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                texto.hide();
                Tooltip.uninstall(textNome, texto);
            }
        });

        
    }



    private void exibirConteudo() {
        textEnunciado.setText(EnunciadoDasQuestoes.questao1.substring(3));
        textNome.setText(Questao1.getNome());
        textInicial.setText(String.valueOf(Questao1.getInicial()));
        textIdade.setText(String.valueOf(Questao1.getIdade()) + " anos");
        textAltura.setText(String.valueOf(Questao1.getAltura()) + "m");
    }

    

    private void setStilo() {
        if (App.darkMode) {
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            buttonHome.getStyleClass().setAll("btn-questao-DM");
            telaQuestao1.setStyle("-fx-background-color: #282828");

            altura.setFill(Paint.valueOf("WHITE"));
            idade.setFill(Paint.valueOf("WHITE"));
            inicial.setFill(Paint.valueOf("WHITE"));
            nomeCompleto.setFill(Paint.valueOf("WHITE"));
            
            questao.setFill(Paint.valueOf("WHITE"));
            textAltura.setFill(Paint.valueOf("WHITE"));
            textEnunciado.setFill(Paint.valueOf("WHITE"));
            textIdade.setFill(Paint.valueOf("WHITE"));
            textInicial.setFill(Paint.valueOf("WHITE"));
            textNome.setFill(Paint.valueOf("WHITE"));
        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            telaQuestao1.setStyle(null);

            altura.setFill(Paint.valueOf("BLACK"));
            idade.setFill(Paint.valueOf("BLACK"));
            inicial.setFill(Paint.valueOf("BLACK"));
            nomeCompleto.setFill(Paint.valueOf("BLACK"));
            
            questao.setFill(Paint.valueOf("BLACK"));
            textAltura.setFill(Paint.valueOf("BLACK"));
            textEnunciado.setFill(Paint.valueOf("BLACK"));
            textIdade.setFill(Paint.valueOf("BLACK"));
            textInicial.setFill(Paint.valueOf("BLACK"));
            textNome.setFill(Paint.valueOf("BLACK"));
        }
    }
}