package controllers;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.util.Duration;
import questoes.EnunciadoDasQuestoes;
import questoes.Questao6;
import source.App;

public class Questao6Controller {

    @FXML private BorderPane telaQuestao6;
    @FXML private Button buttonConfirmar;
    @FXML private Button buttonHome;
    @FXML private Button buttonVoltar;
    @FXML private HBox outputHBox;
    @FXML private Label copyRight;
    @FXML private Label labelPessoa;
    @FXML private Label labelPizza;
    @FXML private Label labelRefri;
    @FXML private Text questao;
    @FXML private Text resultPessoa;
    @FXML private Text resultPizza;
    @FXML private Text resultRefri;
    @FXML private Text resultSubT;
    @FXML private Text resultTot;
    @FXML private Text subTotal;
    @FXML private Text textEnunciado;
    @FXML private Text total;
    @FXML private Text valPessoa;
    @FXML private Text valRefri;
    @FXML private Text valPizza;
    @FXML private TextField tfPessoa;
    @FXML private TextField tfPizza;
    @FXML private TextField tfRefri;
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
                Questao6.setQuantPessoa(Integer.valueOf(tfPessoa.getText()));
                Questao6.setQuantPizza(Integer.valueOf(tfPizza.getText()));
                Questao6.setQuantRefri(Integer.valueOf(tfRefri.getText()));

                Questao6.calcularTotal();

                resultPessoa.setText(String.valueOf(Questao6.getValPessoa()) + " R$");
                resultPizza.setText(String.valueOf(Questao6.getValPizza()) + " R$");
                resultRefri.setText(String.valueOf(Questao6.getValRefri()) + " R$");
                resultSubT.setText(String.valueOf(Questao6.getSubTotal()) + " R$");
                resultTot.setText(String.valueOf(Questao6.getTotal()) + " R$");
                

                outputHBox.setVisible(true);
            }
            
        });

        Tooltip dica = new Tooltip("Clique para ver um projeto bacana de pizzaria");
        dica.setShowDelay(Duration.millis(200));
        Tooltip.install(copyRight, dica);

        copyRight.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                try{
                    String url = "https://github.com/CaioAndersonMM/Pizzaria-POO";
                    Desktop desktop = Desktop.getDesktop();
                    if (Desktop.isDesktopSupported()) {
                        desktop.browse(new URI(url));
                    }
                } catch(IOException | URISyntaxException e) {
                    System.out.println("Não foi possível abrir o endereço especificado: " + e.getMessage());
                    e.printStackTrace();
                }
            }
            
        });
    }

    

    private void exibirConteudo() {
        questao.setText(questao.getText() + "\t");
        textEnunciado.setText(EnunciadoDasQuestoes.questao6.substring(3));
    }


    
    private void setStilo() {
        if (App.darkMode) {
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            buttonHome.getStyleClass().setAll("btn-questao-DM");
            buttonConfirmar.getStyleClass().setAll("btn-questao-DM");
            telaQuestao6.setStyle("-fx-background-color: #282828");


            labelPessoa.setTextFill(Paint.valueOf("WHITE"));
            labelPizza.setTextFill(Paint.valueOf("WHITE"));
            labelRefri.setTextFill(Paint.valueOf("WHITE"));
            
            questao.setFill(Paint.valueOf("WHITE"));
            textEnunciado.setFill(Paint.valueOf("WHITE"));
            resultPessoa.setFill(Paint.valueOf("WHITE"));
            resultPizza.setFill(Paint.valueOf("WHITE"));
            resultRefri.setFill(Paint.valueOf("WHITE"));
            resultSubT.setFill(Paint.valueOf("WHITE"));
            resultTot.setFill(Paint.valueOf("WHITE"));

            valRefri.setFill(Paint.valueOf("WHITE"));
            valPizza.setFill(Paint.valueOf("WHITE"));
            valPessoa.setFill(Paint.valueOf("WHITE"));
            subTotal.setFill(Paint.valueOf("WHITE"));
            total.setFill(Paint.valueOf("WHITE"));

        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            buttonConfirmar.getStyleClass().setAll("btn-questao");
            telaQuestao6.setStyle(null);


            labelPessoa.setTextFill(Paint.valueOf("BLACK"));
            labelPizza.setTextFill(Paint.valueOf("BLACK"));
            labelRefri.setTextFill(Paint.valueOf("BLACK"));
            
            questao.setFill(Paint.valueOf("BLACK"));
            textEnunciado.setFill(Paint.valueOf("BLACK"));
            resultPessoa.setFill(Paint.valueOf("BLACK"));
            resultPizza.setFill(Paint.valueOf("BLACK"));
            resultRefri.setFill(Paint.valueOf("BLACK"));
            resultSubT.setFill(Paint.valueOf("BLACK"));
            resultTot.setFill(Paint.valueOf("BLACK"));

            valRefri.setFill(Paint.valueOf("BLACK"));
            valPizza.setFill(Paint.valueOf("BLACK"));
            valPessoa.setFill(Paint.valueOf("BLACK"));
            subTotal.setFill(Paint.valueOf("BLACK"));
            total.setFill(Paint.valueOf("BLACK"));
        }
    }
}