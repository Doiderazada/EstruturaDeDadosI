package controllers;

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
import questoes.Questao30;

public class Questao30Controller extends BaseController{


    @FXML private BorderPane telaQuestao30;
    @FXML private Button buttonConfirmCreate;
    @FXML private Button buttonConfirmEdit;
    @FXML private Button buttonCriarFrase;
    @FXML private Button buttonNovaFrase;
    @FXML private Button buttonVisualizar;
    @FXML private HBox hBoxParent;
    @FXML private Label copyRight;
    @FXML private Label labelCreate;
    @FXML private Label labelEdit;
    @FXML private Pane paneView;
    @FXML private ScrollPane sPaneView;
    @FXML private Text textResposta;
    @FXML private TextField tfCreate;
    @FXML private TextField tfEdit;
    @FXML private VBox vBoxCreate;
    @FXML private VBox vBoxEdit;


    private String fraseEntrada;
    private String fraseSaida;
    private Questao30 inversor;
    
    public void initialize() {
        BaseController.numQuestao = 30;
        super.initialize();
        acaoDosBotoes();
        setStilo(new Button[] { buttonConfirmCreate, buttonConfirmEdit, buttonCriarFrase, buttonNovaFrase, buttonVisualizar},
                 new Label[]  { labelCreate, labelEdit},
                 new Pane[]   { paneView, telaQuestao30}, null,
                 new Text[]   { textResposta});
        estadoInicial();
    }


    private void estadoInicial(){
        buttonCriarFrase.setDisable(false);
        buttonNovaFrase.setDisable(true);
        buttonVisualizar.setDisable(true);

        hBoxParent.getChildren().removeAll(vBoxCreate, vBoxEdit, sPaneView);
    }


    private void acaoDosBotoes() {
        buttonCriarFrase.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                hBoxParent.getChildren().add(vBoxCreate);
            }
        });
        buttonNovaFrase.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if(hBoxParent.getChildren().contains(vBoxEdit)) hBoxParent.getChildren().remove(vBoxEdit);
                if(hBoxParent.getChildren().contains(sPaneView)) hBoxParent.getChildren().remove(sPaneView);
                hBoxParent.getChildren().add(vBoxEdit);

                tfEdit.clear();
            }
        });
        buttonVisualizar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if(hBoxParent.getChildren().contains(vBoxEdit)) hBoxParent.getChildren().remove(vBoxEdit);
                if(hBoxParent.getChildren().contains(sPaneView)) hBoxParent.getChildren().remove(sPaneView);
                inversor.inverterFrase();

                fraseEntrada = inversor.getFraseOriginal();
                fraseSaida = inversor.getFraseInvertida();

                textResposta.setText("Frase original: " + fraseEntrada + "\n\n" + 
                                     "Frase invertida: " + fraseSaida + "\n");

                hBoxParent.getChildren().add(sPaneView);
            }
        });

        buttonConfirmCreate.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                
                if (validarCreate()) {
                    
                    fraseEntrada = tfCreate.getText();

                    inversor = new Questao30(fraseEntrada, false);
                    
                    textResposta.setText("Frase criada com sucesso!");
                    hBoxParent.getChildren().remove(vBoxCreate);
                    hBoxParent.getChildren().add(sPaneView);

                    buttonCriarFrase.setDisable(true);
                    buttonNovaFrase.setDisable(false);
                    buttonVisualizar.setDisable(false);
                }
            }
        });
        buttonConfirmEdit.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (validarEdit()) {
                    fraseEntrada = tfEdit.getText();

                    inversor.setFraseOriginal(fraseEntrada);

                    textResposta.setText("Frase editada com sucesso!");
                    hBoxParent.getChildren().remove(vBoxEdit);
                    hBoxParent.getChildren().add(sPaneView);
                }
            }
        });
    }



    private boolean validarCreate() {
        if (tfCreate.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        } 
        return true;
    }

    private boolean validarEdit() {
        if (tfEdit.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        } 
        return true;
    }
}