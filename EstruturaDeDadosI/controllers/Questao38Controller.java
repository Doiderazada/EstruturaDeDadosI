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
import javafx.scene.text.Text;
import questoes.Questao2;
import questoes.Questao20;
import questoes.Questao30;
import questoes.Questao31;
import questoes.Questao38;

public class Questao38Controller extends BaseController{


    @FXML private BorderPane telaQuestao38;
    @FXML private Button buttonQ2;
    @FXML private Button buttonQ20;
    @FXML private Button buttonQ30;
    @FXML private Button buttonQ31;
    @FXML private Button buttonVerObjeto;
    @FXML private Button buttonVerVetor;
    @FXML private HBox hBoxElements;
    @FXML private Label copyRight;
    @FXML private Pane paneView;
    @FXML private ScrollPane sPaneView;
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
        BaseController.numQuestao = 38;
        super.initialize();
        acaoDosBotoes();
        setStilo(new Button[] { buttonQ2, buttonQ20, buttonQ30, buttonQ31, buttonVerObjeto, buttonVerVetor}, null,
                 new Pane[]   { paneView, telaQuestao38}, null, 
                 new Text[]   { textView});
        estadoInicial();
    }


    private void estadoInicial(){
        if(hBoxElements.getChildren().contains(vBoxQuestoes)) hBoxElements.getChildren().remove(vBoxQuestoes);
        if(hBoxElements.getChildren().contains(sPaneView)) hBoxElements.getChildren().remove(sPaneView);
    }


    private void acaoDosBotoes() {

        buttonVerObjeto.setOnMouseClicked(new EventHandler<MouseEvent>(){
            
            @Override
            public void handle(MouseEvent arg0){
                estadoInicial();

                objeto = true;
                vetor = false;
                hBoxElements.getChildren().add(vBoxQuestoes);
            }
        });
        buttonVerVetor.setOnMouseClicked(new EventHandler<MouseEvent>(){
            
            @Override
            public void handle(MouseEvent arg0){
                estadoInicial();
                
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
        estadoInicial();

        if (objeto) textView.setText(objQ2.exibirObjeto(usuarios[0]));
        if (vetor) textView.setText(objQ2.exibirVetorObjeto(usuarios));

        hBoxElements.getChildren().remove(vBoxQuestoes);
        hBoxElements.getChildren().addAll(sPaneView);
    }
    private void exibirQuestao20() {
        estadoInicial();

        if (objeto) textView.setText(objQ20.exibirObjeto(contasBanco[0]));
        if (vetor) textView.setText(objQ20.exibirVetorObjeto(contasBanco));

        hBoxElements.getChildren().remove(vBoxQuestoes);
        hBoxElements.getChildren().addAll(sPaneView);
    }
    private void exibirQuestao30() {
        estadoInicial();

        if (objeto) textView.setText(objQ30.exibirObjeto(frases[0]));
        if (vetor) textView.setText(objQ30.exibirVetorObjeto(frases));

        hBoxElements.getChildren().remove(vBoxQuestoes);
        hBoxElements.getChildren().addAll(sPaneView);
    }
    
    private void exibirQuestao31() {
        estadoInicial();

        if (objeto) textView.setText(objQ31.exibirObjeto(pessoas[0]));
        if (vetor) textView.setText(objQ31.exibirVetorObjeto(pessoas));

        hBoxElements.getChildren().remove(vBoxQuestoes);
        hBoxElements.getChildren().addAll(sPaneView);
    }
}