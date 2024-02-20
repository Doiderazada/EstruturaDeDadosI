package controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import questoes.EnunciadoDasQuestoes;
import questoes.Questao2;
import questoes.Questao20;
import questoes.Questao30;
import questoes.Questao31;
import questoes.Questao38;
import source.App;

public class Questao38Controller {


    @FXML private Button buttonHome;
    @FXML private Button buttonQ2;
    @FXML private Button buttonQ20;
    @FXML private Button buttonQ30;
    @FXML private Button buttonQ31;
    @FXML private Button buttonVerObjeto;
    @FXML private Button buttonVerVetor;
    @FXML private Button buttonVoltar;
    @FXML private Label copyRight;
    @FXML private HBox hBoxElements;
    @FXML private Pane paneView;
    @FXML private Text questao;
    @FXML private ScrollPane sPaneView;
    @FXML private BorderPane telaQuestao38;
    @FXML private Text textEnunciado;
    @FXML private Text textView;
    @FXML private VBox vBoxButtons;
    @FXML private VBox vBoxQuestoes;


    private boolean objeto = false;
    private boolean vetor = false;


    private Questao2[] usuarios = new Questao2[]{
        new Questao2("usuário número 1", 'u', 30, 1.75f),
        new Questao2("usuário número 2", 'u', 27, 1.6f),
        new Questao2("usuário número 3", 'u', 35, 1.85f)
    };

    private Questao20[] contasBanco = new Questao20[]{
        new Questao20(500, 200, 0.05, 5),
        new Questao20(1000, 200, 0.08, 10),
        new Questao20(5000, 500, 0.03, 15)
    };

    private Questao30[] frases = new Questao30[]{
        new Questao30("frase teste número 1", true),
        new Questao30("frase teste número 2", true),
        new Questao30("frase teste número 3", true)
    };

    private Questao31[] pessoas = new Questao31[]{
        new Questao31("123.456.789-10", "primeira pessoa", 'M', 30, 70, 1.75),
        new Questao31("919.283.847-57", "segunda pessoa", 'F', 27, 65, 1.6),
        new Questao31("121.323.243-33", "terceira pessoa", 'M', 35, 75, 1.85),
    };

    private Questao38<Questao2> objQ2 = new Questao38<>(); 
    private Questao38<Questao20> objQ20 = new Questao38<>(); 
    private Questao38<Questao30> objQ30 = new Questao38<>();
    private Questao38<Questao31> objQ31 = new Questao38<>();

    public void initialize() {
        acaoDosBotoes();
        setStilo();
        exibirConteudo();
        estadoInicial();
    }


    private void estadoInicial(){
        hBoxElements.getChildren().removeAll(vBoxQuestoes, sPaneView);
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

        buttonVerObjeto.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent arg0){
                if(hBoxElements.getChildren().contains(vBoxQuestoes)) hBoxElements.getChildren().remove(vBoxQuestoes);
                if(hBoxElements.getChildren().contains(sPaneView)) hBoxElements.getChildren().remove(sPaneView);

                objeto = true;
                vetor = false;
                hBoxElements.getChildren().add(vBoxQuestoes);
            }
        });
        buttonVerVetor.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent arg0){
                if(hBoxElements.getChildren().contains(vBoxQuestoes)) hBoxElements.getChildren().remove(vBoxQuestoes);
                if(hBoxElements.getChildren().contains(sPaneView)) hBoxElements.getChildren().remove(sPaneView);
                
                objeto = false;
                vetor = true;
                hBoxElements.getChildren().addAll(vBoxQuestoes);
            }
        });

        buttonQ2.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                exibirQuestao2();
            }
            
        });
        buttonQ20.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                exibirQuestao20();
            }
            
        });
        buttonQ30.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                exibirQuestao30();
            }
            
        });
        buttonQ31.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                exibirQuestao31();
            }
            
        });

    
    }

    
    private void exibirQuestao2() {
        if (hBoxElements.getChildren().contains(vBoxQuestoes)) 
            hBoxElements.getChildren().remove(vBoxQuestoes);
        
        if (hBoxElements.getChildren().contains(sPaneView)) 
            hBoxElements.getChildren().remove(sPaneView);
        


        if (objeto) textView.setText(objQ2.exibirObjeto(usuarios[0]));
        if (vetor) textView.setText(objQ2.exibirVetorObjeto(usuarios));

        hBoxElements.getChildren().remove(vBoxQuestoes);
        hBoxElements.getChildren().addAll(sPaneView);
    }

    private void exibirQuestao20() {
        if (hBoxElements.getChildren().contains(vBoxQuestoes)) 
            hBoxElements.getChildren().remove(vBoxQuestoes);
        
        if (hBoxElements.getChildren().contains(sPaneView)) 
            hBoxElements.getChildren().remove(sPaneView);
        


        if (objeto) textView.setText(objQ20.exibirObjeto(contasBanco[0]));
        if (vetor) textView.setText(objQ20.exibirVetorObjeto(contasBanco));

        hBoxElements.getChildren().remove(vBoxQuestoes);
        hBoxElements.getChildren().addAll(sPaneView);
    }
    
    private void exibirQuestao30() {
        if (hBoxElements.getChildren().contains(vBoxQuestoes)) 
            hBoxElements.getChildren().remove(vBoxQuestoes);
        
        if (hBoxElements.getChildren().contains(sPaneView)) 
            hBoxElements.getChildren().remove(sPaneView);
        


        if (objeto) textView.setText(objQ30.exibirObjeto(frases[0]));
        if (vetor) textView.setText(objQ30.exibirVetorObjeto(frases));

        hBoxElements.getChildren().remove(vBoxQuestoes);
        hBoxElements.getChildren().addAll(sPaneView);
    }
    
    private void exibirQuestao31() {
        if (hBoxElements.getChildren().contains(vBoxQuestoes)) 
            hBoxElements.getChildren().remove(vBoxQuestoes);
        
        if (hBoxElements.getChildren().contains(sPaneView)) 
            hBoxElements.getChildren().remove(sPaneView);
        


        if (objeto) textView.setText(objQ31.exibirObjeto(pessoas[0]));
        if (vetor) textView.setText(objQ31.exibirVetorObjeto(pessoas));

        hBoxElements.getChildren().remove(vBoxQuestoes);
        hBoxElements.getChildren().addAll(sPaneView);
    }






    private void exibirConteudo() { 
        questao.setText(questao.getText() + "\t");
        textEnunciado.setText(EnunciadoDasQuestoes.questao38.substring(3));
    }


    
    private void setStilo() {
        if (App.darkMode) {
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            buttonHome.getStyleClass().setAll("btn-questao-DM");
            buttonQ2.getStyleClass().setAll("btn-questao-DM");
            buttonQ20.getStyleClass().setAll("btn-questao-DM");
            buttonQ30.getStyleClass().setAll("btn-questao-DM");
            buttonQ31.getStyleClass().setAll("btn-questao-DM");
            buttonVerObjeto.getStyleClass().setAll("btn-questao-DM");
            buttonVerVetor.getStyleClass().setAll("btn-questao-DM");
            telaQuestao38.setStyle("-fx-background-color: #282828");
            paneView.setStyle("-fx-background-color: #282828");

            
            questao.setFill(Color.WHITE);
            textEnunciado.setFill(Color.WHITE);
            textView.setFill(Color.WHITE);
            
        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            buttonQ2.getStyleClass().setAll("btn-questao");
            buttonQ20.getStyleClass().setAll("btn-questao");
            buttonQ30.getStyleClass().setAll("btn-questao");
            buttonQ31.getStyleClass().setAll("btn-questao");
            buttonVerObjeto.getStyleClass().setAll("btn-questao");
            buttonVerVetor.getStyleClass().setAll("btn-questao");
            telaQuestao38.setStyle(null);
            paneView.setStyle(null);


            questao.setFill(Color.BLACK);
            textEnunciado.setFill(Color.BLACK);
            textView.setFill(Color.BLACK);
            
        }
    }
}