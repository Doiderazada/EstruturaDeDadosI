package controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import questoes.EnunciadoDasQuestoes;
import questoes.Questao2;
import source.App;

public class Questao2Controller {
    
    @FXML private BorderPane telaQuestao2;
    @FXML private Button buttonConfirmar;
    @FXML private Button buttonHome;
    @FXML private Button buttonVoltar;
    @FXML private HBox outputHBox;
    @FXML private Label copyRight;
    @FXML private Label labelAltura;
    @FXML private Label labelIdade;
    @FXML private Label labelNome;
    @FXML private Text nomeCompleto;
    @FXML private Text altura;
    @FXML private Text idade;
    @FXML private Text inicial;
    @FXML private Text questao;
    @FXML private Text textAltura;
    @FXML private Text textEnunciado;
    @FXML private Text textIdade;
    @FXML private Text textInicial;
    @FXML private Text textNome;
    @FXML private TextField tfAltura;
    @FXML private TextField tfIdade;
    @FXML private TextField tfNome;
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
                Questao2.setNome(tfNome.getText());
                Questao2.setInicial(tfNome.getText().charAt(0));
                Questao2.setIdade(Integer.parseInt(tfIdade.getText()));
                Questao2.setAltura(Float.parseFloat(tfAltura.getText()));

                textNome.setText(Questao2.getNome());
                textInicial.setText(String.valueOf(Questao2.getInicial()));
                textIdade.setText(String.valueOf(Questao2.getIdade()) + " anos");
                textAltura.setText(String.valueOf(Questao2.getAltura()) + "m");

                inputVBox.setVisible(false);
                outputHBox.setVisible(true);
            }
            
        });
    }

    

    private void exibirConteudo() {
        questao.setText(questao.getText() + "\t");
        textEnunciado.setText(EnunciadoDasQuestoes.questao2.substring(3));
    }


    private void setStilo() {
        if (App.darkMode) {
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            buttonHome.getStyleClass().setAll("btn-questao-DM");
            buttonConfirmar.getStyleClass().setAll("btn-questao-DM");
            telaQuestao2.setStyle("-fx-background-color: #282828");

            altura.setFill(Paint.valueOf("WHITE"));
            idade.setFill(Paint.valueOf("WHITE"));
            inicial.setFill(Paint.valueOf("WHITE"));
            nomeCompleto.setFill(Paint.valueOf("WHITE"));
            labelNome.setTextFill(Paint.valueOf("WHITE"));
            labelIdade.setTextFill(Paint.valueOf("WHITE"));
            labelAltura.setTextFill(Paint.valueOf("WHITE"));
            
            questao.setFill(Paint.valueOf("WHITE"));
            textAltura.setFill(Paint.valueOf("WHITE"));
            textEnunciado.setFill(Paint.valueOf("WHITE"));
            textIdade.setFill(Paint.valueOf("WHITE"));
            textInicial.setFill(Paint.valueOf("WHITE"));
            textNome.setFill(Paint.valueOf("WHITE"));
        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            buttonConfirmar.getStyleClass().setAll("btn-questao");
            telaQuestao2.setStyle(null);

            altura.setFill(Paint.valueOf("BLACK"));
            idade.setFill(Paint.valueOf("BLACK"));
            inicial.setFill(Paint.valueOf("BLACK"));
            nomeCompleto.setFill(Paint.valueOf("BLACK"));
            labelNome.setTextFill(Paint.valueOf("BLACK"));
            labelIdade.setTextFill(Paint.valueOf("BLACK"));
            labelNome.setTextFill(Paint.valueOf("BLACK"));
            
            questao.setFill(Paint.valueOf("BLACK"));
            textAltura.setFill(Paint.valueOf("BLACK"));
            textEnunciado.setFill(Paint.valueOf("BLACK"));
            textIdade.setFill(Paint.valueOf("BLACK"));
            textInicial.setFill(Paint.valueOf("BLACK"));
            textNome.setFill(Paint.valueOf("BLACK"));
        }
    }
}