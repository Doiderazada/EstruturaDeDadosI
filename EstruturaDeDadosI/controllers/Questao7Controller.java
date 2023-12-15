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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.util.Duration;
import questoes.EnunciadoDasQuestoes;
import questoes.Questao7;
import source.App;

public class Questao7Controller {
    
    @FXML private BorderPane telaQuestao7;
    @FXML private Button buttonConfirmar;
    @FXML private Button buttonHome;
    @FXML private Button buttonVoltar;
    @FXML private Label copyRight;
    @FXML private Label labelValA;
    @FXML private Label labelValB;
    @FXML private Line divLine;
    @FXML private Text equalSign;
    @FXML private Text questao;
    @FXML private Text textEnunciado;
    @FXML private Text textResult;
    @FXML private Text textValA;
    @FXML private Text textValB;
    @FXML private TextField tfValA;
    @FXML private TextField tfValB;
    @FXML private VBox inputVBox;
    @FXML private VBox outputVBox;



    public void initialize() {
        acaoDosBotoes();
        setStilo();
        exibirConteudo();
        inputVBox.setVisible(true);
        outputVBox.setVisible(false);;
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
                if (verificarInput()) {
                    Questao7.setValA(Double.parseDouble(tfValA.getText()));
                    Questao7.setValB(Double.parseDouble(tfValB.getText()));

                    textValA.setText(String.valueOf(Questao7.getValA()));
                    textValB.setText(String.valueOf(Questao7.getValB()));
                    textResult.setText(String.valueOf(Questao7.dividir()));

                    outputVBox.setVisible(true);
                }
            }
            
        });


        Tooltip texto = new Tooltip("Texto copiado");
        

        textResult.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(textResult.getText());
                clipboard.setContent(content);

                Tooltip.install(textResult, texto);
                texto.setAutoHide(true);
                texto.fireEvent(arg0);
                texto.centerOnScreen();
                texto.show(telaQuestao7.getScene().getWindow());
            }
        });
        textResult.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                texto.hide();
                Tooltip.uninstall(textResult, texto);
            }
        });
    }

    

    private boolean verificarInput() {

        if (tfValA.getText().contains(",")) {
            tfValA.setText(tfValA.getText().replace(",", "."));
        }
        if (tfValB.getText().contains(",")) {
            tfValB.setText(tfValB.getText().replace(",", "."));
        }

        if (tfValA.getText().isEmpty()) {
            showPopup("Os valores inseridos não são válidos, por favor, tente novamente.");
            return false;
        } else if (tfValA.getText().matches("[a-zA-Z]+")) {
            showPopup("Os valores inseridos não são válidos, por favor, tente novamente.");
            return false;
        };

        if (tfValB.getText().isEmpty()) {
            showPopup("Os valores inseridos não são válidos, por favor, tente novamente.");
            return false;
        } else if (tfValB.getText().matches("0")) {
            showPopup("O divisor não pode ser 0");
            return false;
        } else if (tfValB.getText().matches("[a-zA-Z]+")) {
            showPopup("Os valores inseridos não são válidos, por favor, tente novamente.");;
            return false;
        }


        return true;
    }





    private void showPopup(String texto) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/telaPopup.fxml"));
            Parent root = loader.load();

            TelaPopupController controller = loader.getController();
            controller.initialize(texto);
            Popup popup = new Popup();

            popup.getContent().add(root);
            popup.setAutoHide(true);
            popup.setHideOnEscape(true);
            
            double winX = buttonConfirmar.getScene().getWindow().getX();
            double winY = buttonConfirmar.getScene().getWindow().getY();
            double halfX = buttonConfirmar.getScene().getWindow().getWidth()/2;
            double halfY = buttonConfirmar.getScene().getWindow().getHeight()/2;

            double newX = (winX + halfX) - (popup.getWidth()/2);
            double newY = (winY + halfY) - (popup.getHeight()/2);

            popup.setX(newX);
            popup.setY(newY);
            
            
            popup.show(buttonConfirmar.getScene().getWindow());

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
        textEnunciado.setText(EnunciadoDasQuestoes.questao7.substring(3));
    }


    
    private void setStilo() {
        if (App.darkMode) {
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            buttonHome.getStyleClass().setAll("btn-questao-DM");
            buttonConfirmar.getStyleClass().setAll("btn-questao-DM");
            telaQuestao7.setStyle("-fx-background-color: #282828");

            labelValA.setTextFill(Paint.valueOf("WHITE"));
            labelValB.setTextFill(Paint.valueOf("WHITE"));
            
            divLine.setStroke(Paint.valueOf("WHITE"));
            equalSign.setFill(Paint.valueOf("WHITE"));
            questao.setFill(Paint.valueOf("WHITE"));
            textEnunciado.setFill(Paint.valueOf("WHITE"));
            textResult.setFill(Paint.valueOf("WHITE"));
            textValA.setFill(Paint.valueOf("WHITE"));
            textValB.setFill(Paint.valueOf("WHITE"));

        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            buttonConfirmar.getStyleClass().setAll("btn-questao");
            telaQuestao7.setStyle(null);

            labelValA.setTextFill(Paint.valueOf("BLACK"));
            labelValB.setTextFill(Paint.valueOf("BLACK"));
            
            divLine.setStroke(Paint.valueOf("BLACK"));
            equalSign.setFill(Paint.valueOf("BLACK"));
            questao.setFill(Paint.valueOf("BLACK"));
            textEnunciado.setFill(Paint.valueOf("BLACK"));
            textResult.setFill(Paint.valueOf("BLACK"));
            textValA.setFill(Paint.valueOf("BLACK"));
            textValB.setFill(Paint.valueOf("BLACK"));
        }
    }
}