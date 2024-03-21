package br.edu.ufersa.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import br.edu.ufersa.questoes.Questao33;

public class Questao33Controller extends BaseController{


    @FXML private BorderPane telaQuestao33;
    @FXML private Button buttonConfirmar;
    @FXML private Button buttonNovaFrase;
    @FXML private Button buttonVisualizar;
    @FXML private HBox hBoxOutput;
    @FXML private Label copyRight;
    @FXML private Label labelFrase;
    @FXML private Pane paneView;
    @FXML private ScrollPane sPaneView;
    @FXML private Text textView;
    @FXML private TextField tfFrase;
    @FXML private VBox vBoxButtons;
    @FXML private VBox vBoxFrase;


    
    private Questao33 fraseQ33 = new Questao33(" ");
    

    public void initialize() {
        BaseController.numQuestao = 33;
        super.initialize();
        acaoDosBotoes();
        setStilo(new Button[] { buttonConfirmar, buttonNovaFrase, buttonVisualizar},
                 new Label[]  { labelFrase}, 
                 new Pane[]   { paneView, telaQuestao33}, null,
                 new Text[]   { textView});
        estadoInicial();
    }



    private void estadoInicial(){
        buttonVisualizar.setDisable(true);
        hBoxOutput.getChildren().removeAll(vBoxFrase, sPaneView);
    }




    private void acaoDosBotoes() {
        buttonNovaFrase.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (hBoxOutput.getChildren().contains(sPaneView)) hBoxOutput.getChildren().remove(sPaneView);
                hBoxOutput.getChildren().add(vBoxFrase);
                tfFrase.clear();
            }
        });
        buttonVisualizar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                visualizarFrase();
            }
        });

        buttonConfirmar.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
                novaFrase();
                
                hBoxOutput.getChildren().remove(vBoxFrase);

                if (buttonVisualizar.isDisable()) buttonVisualizar.setDisable(false);
			}
        });
    }


    private void novaFrase(){

        if (validarFrase()) {
            String frase = tfFrase.getText();
            
            fraseQ33.setFrase(frase);
            fraseQ33.setLetras();
            fraseQ33.setQuantidade();

            fraseQ33.contarLetras();

            textView.setText("A frase foi cadastrada com sucesso.");
            hBoxOutput.getChildren().add(sPaneView);
        }
    }

    private void visualizarFrase(){
        textView.setText("Informações sobre a frase \"" + fraseQ33.getFrase() + "\".\n" +
        fraseQ33.exibirConteudo());
    }


    
    
    private boolean validarFrase() {
        if (tfFrase.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        } 
        return true;
    }   
}