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
import javafx.scene.layout.HBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.util.Duration;
import questoes.EnunciadoDasQuestoes;
import questoes.Questao9;
import source.App;

public class Questao9Controller {
    
    @FXML private BorderPane telaQuestao9;
    @FXML private Button buttonConfirmar;
    @FXML private Button buttonHome;
    @FXML private Button buttonVoltar;
    @FXML private Circle circulo;
    @FXML private Label copyRight;
    @FXML private Label labelRaio;
    @FXML private Line lineRaio;
    @FXML private HBox outputHBox;
    @FXML private Text questao;
    @FXML private Text textArea;
    @FXML private Text textC;
    @FXML private Text textCirc;
    @FXML private Text textEnunciado;
    @FXML private Text textR;
    @FXML private Text textRaio;
    @FXML private Text textResultArea;
    @FXML private Text textResultCirc;
    @FXML private Text textResultRaio;
    @FXML private TextField tfRaio;



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
                if (verificarInput()) {
                    Questao9.setRaio(Double.valueOf(tfRaio.getText()));

                    textResultRaio.setText(String.valueOf(Questao9.getRaio()) + "u.m");
                    textResultArea.setText(String.valueOf(Questao9.medirArea()) + "u.m");
                    textResultCirc.setText(String.valueOf(Questao9.medirCircunferencia()) + "u.m");

                    outputHBox.setVisible(true);
                }
            }
            
        });

        Tooltip texto = new Tooltip("Texto copiado");
        Tooltip.install(textResultArea, texto);
        Tooltip.install(textResultCirc, texto);
        Tooltip.install(textResultRaio, texto);

        textResultArea.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(textResultArea.getText());
                clipboard.setContent(content);

                texto.setAutoHide(true);
                texto.fireEvent(arg0);
                texto.centerOnScreen();

                texto.show(telaQuestao9.getScene().getWindow());
            }
            
        });
        textResultArea.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                texto.hide();
            }
            
        });

        
        textResultCirc.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(textResultCirc.getText());
                clipboard.setContent(content);

                texto.setAutoHide(true);
                texto.fireEvent(arg0);
                texto.centerOnScreen();

                texto.show(telaQuestao9.getScene().getWindow());
            }
            
        });
        textResultCirc.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                texto.hide();
            }
            
        });
        
        textResultRaio.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(textResultRaio.getText());
                clipboard.setContent(content);

                texto.setAutoHide(true);
                texto.fireEvent(arg0);
                texto.centerOnScreen();

                texto.show(telaQuestao9.getScene().getWindow());
            }
            
        });
        textResultRaio.setOnMouseExited(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                texto.hide();
            }
            
        });

        
        Tooltip unidade = new Tooltip("Unidades de medida");
        unidade.setShowDelay(Duration.millis(100));
        Tooltip.install(textResultArea, unidade);
        Tooltip.install(textResultCirc, unidade);
        Tooltip.install(textResultRaio, unidade);

    }

    

    private boolean verificarInput() {
        

        if (tfRaio.getText().matches("[a-zA-Z]+")) {
            showPopup("O valor inserido não é válido, tente novamente");
            return false;
        } else if (tfRaio.getText().matches("[0-9^.]+")) { 
            double raio = Double.parseDouble(tfRaio.getText());

            if (raio <= 0) {
                showPopup("Valor do raio é inválido");
                return false;
            }
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
        textEnunciado.setText(EnunciadoDasQuestoes.questao9.substring(3));
    }


    
    private void setStilo() {
        if (App.darkMode) {
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            buttonHome.getStyleClass().setAll("btn-questao-DM");
            buttonConfirmar.getStyleClass().setAll("btn-questao-DM");
            telaQuestao9.setStyle("-fx-background-color: #282828");

            labelRaio.setTextFill(Paint.valueOf("WHITE"));
            
            lineRaio.setStroke(Paint.valueOf("WHITE"));
            circulo.setStroke(Paint.valueOf("WHITE"));
            questao.setFill(Paint.valueOf("WHITE"));
            textEnunciado.setFill(Paint.valueOf("WHITE"));
            textArea.setFill(Paint.valueOf("WHITE"));
            textC.setFill(Paint.valueOf("WHITE"));
            textCirc.setFill(Paint.valueOf("WHITE"));
            textR.setFill(Paint.valueOf("WHITE"));
            textRaio.setFill(Paint.valueOf("WHITE"));

            textResultArea.setFill(Paint.valueOf("WHITE"));
            textResultCirc.setFill(Paint.valueOf("WHITE"));
            textResultRaio.setFill(Paint.valueOf("WHITE"));
            
        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            buttonConfirmar.getStyleClass().setAll("btn-questao");
            telaQuestao9.setStyle(null);

            labelRaio.setTextFill(Paint.valueOf("BLACK"));
            
            lineRaio.setStroke(Paint.valueOf("BLACK"));
            circulo.setStroke(Paint.valueOf("BLACK"));
            questao.setFill(Paint.valueOf("BLACK"));
            textEnunciado.setFill(Paint.valueOf("BLACK"));
            textArea.setFill(Paint.valueOf("BLACK"));
            textC.setFill(Paint.valueOf("BLACK"));
            textCirc.setFill(Paint.valueOf("BLACK"));
            textR.setFill(Paint.valueOf("BLACK"));
            textRaio.setFill(Paint.valueOf("BLACK"));

            textResultArea.setFill(Paint.valueOf("BLACK"));
            textResultCirc.setFill(Paint.valueOf("BLACK"));
            textResultRaio.setFill(Paint.valueOf("BLACK"));
        }
    }
}