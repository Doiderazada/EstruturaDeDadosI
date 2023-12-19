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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.util.Duration;
import questoes.EnunciadoDasQuestoes;
import questoes.Questao13;
import source.App;

public class Questao13Controller {

    @FXML private BorderPane telaQuestao13;
    @FXML private Button buttonConfirmar;
    @FXML private Button buttonHome;
    @FXML private Button buttonVoltar;
    @FXML private Label copyRight;
    @FXML private Label labelNota1;
    @FXML private Label labelNota2;
    @FXML private Label labelNota3;
    @FXML private Line divLine;
    @FXML private Text igual;
    @FXML private Text plusSign1;
    @FXML private Text plusSign2;
    @FXML private Text questao;
    @FXML private Text textEnunciado;
    @FXML private Text textNota1;
    @FXML private Text textNota2;
    @FXML private Text textNota3;
    @FXML private Text textNota4;
    @FXML private Text textNotaMin;
    @FXML private Text textResultado;
    @FXML private Text textSitRes;
    @FXML private Text textSituacao;
    @FXML private Text tres;
    @FXML private TextField tfNota1;
    @FXML private TextField tfNota2;
    @FXML private TextField tfNota3;
    @FXML private VBox vBoxOutput;


    public void initialize() {
        acaoDosBotoes();
        setStilo();
        exibirConteudo();
        vBoxOutput.setVisible(false);
    }





    private void acaoDosBotoes() {
        Tooltip mensagemSubliminar = new Tooltip("Agora sim, essa é melhor");
        mensagemSubliminar.setShowDelay(Duration.millis(100));
        mensagemSubliminar.setShowDuration(Duration.millis(800));
        Tooltip.install(copyRight, mensagemSubliminar);

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
                    Questao13.setNota1(Double.parseDouble(tfNota1.getText()));
                    Questao13.setNota2(Double.parseDouble(tfNota2.getText()));
                    Questao13.setNota3(Double.parseDouble(tfNota3.getText()));

                    textNota1.setText(tfNota1.getText());
                    textNota2.setText(tfNota2.getText());
                    textNota3.setText(tfNota3.getText());


                    textSitRes.setText(Questao13.calcularMedia());
                    textResultado.setText(String.valueOf(Questao13.getMedia()));
                    if (textSitRes.getText().contentEquals("Aluno aprovado")) {
                        textNotaMin.setVisible(false);
                        textNota4.setVisible(false);
                    } else {
                        textNotaMin.setVisible(true);
                        textNota4.setVisible(true);
                    }
                    textNota4.setText(String.valueOf(Questao13.getNota4()));

                    vBoxOutput.setVisible(true);
                }
            }
            
        });

        tfNota1.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent arg0) {
                vBoxOutput.setVisible(false);
            }
            
        });
        
        tfNota2.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent arg0) {
                vBoxOutput.setVisible(false);
            }
            
        });
        
        tfNota3.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent arg0) {
                vBoxOutput.setVisible(false);
            }
            
        });

    }

    

    private boolean verificarInput() {
        

        if (tfNota1.getText().matches("[a-zA-Z]+")) {
            showPopup("O valor inserido não é válido, tente novamente");
            return false;
        } else if (tfNota1.getText().matches("[\\d^.]+")) { 
            double valor = Double.parseDouble(tfNota1.getText());

            if (valor < 0) {
                showPopup("O valor não pode ser menor que 0");
                return false;
            }

            if (valor > 10) {
                showPopup("O Valor não pode ultrapassar 10");
                return false;
            }
        }
        
        
        if (tfNota2.getText().matches("[a-zA-Z]+")) {
            showPopup("O valor inserido não é válido, tente novamente");
            return false;
        } else if (tfNota2.getText().matches("[\\d^.]+")) { 
            double valor = Double.parseDouble(tfNota2.getText());

            if (valor < 0) {
                showPopup("O valor não pode ser menor que 0");
                return false;
            }

            if (valor > 10) {
                showPopup("O Valor não pode ultrapassar 10");
                return false;
            }
        }
        
        
        if (tfNota3.getText().matches("[a-zA-Z]+")) {
            showPopup("O valor inserido não é válido, tente novamente");
            return false;
        } else if (tfNota3.getText().matches("[\\d^.]+")) { 
            double valor = Double.parseDouble(tfNota3.getText());

            if (valor < 0) {
                showPopup("O valor não pode ser menor que 0");
                return false;
            }

            if (valor > 10) {
                showPopup("O Valor não pode ultrapassar 10");
                return false;
            }
        }

        return true;
    }





    private void showPopup(String texto) {
        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/telaPopupErro.fxml"));
            Parent root = loader.load();

            TelaPopupErroController controller = loader.getController();
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
        textEnunciado.setText(EnunciadoDasQuestoes.questao13.substring(3));
    }


    
    private void setStilo() {
        if (App.darkMode) {
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            buttonHome.getStyleClass().setAll("btn-questao-DM");
            buttonConfirmar.getStyleClass().setAll("btn-questao-DM");
            telaQuestao13.setStyle("-fx-background-color: #282828");

            labelNota1.setTextFill(Paint.valueOf("WHITE"));
            labelNota2.setTextFill(Paint.valueOf("WHITE"));
            labelNota3.setTextFill(Paint.valueOf("WHITE"));
            
            plusSign1.setFill(Paint.valueOf("WHITE"));
            plusSign2.setFill(Paint.valueOf("WHITE"));


            divLine.setStroke(Paint.valueOf("WHITE"));

            questao.setFill(Paint.valueOf("WHITE"));
            textEnunciado.setFill(Paint.valueOf("WHITE"));
            textNota1.setFill(Paint.valueOf("WHITE"));
            textNota2.setFill(Paint.valueOf("WHITE"));
            textNota3.setFill(Paint.valueOf("WHITE"));
            textNota4.setFill(Paint.valueOf("WHITE"));
            textResultado.setFill(Paint.valueOf("WHITE"));
            textSitRes.setFill(Paint.valueOf("WHITE"));
            textSituacao.setFill(Paint.valueOf("WHITE"));
            textNotaMin.setFill(Paint.valueOf("WHITE"));
            tres.setFill(Paint.valueOf("WHITE"));
            igual.setFill(Paint.valueOf("WHITE"));

            
        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            buttonConfirmar.getStyleClass().setAll("btn-questao");
            telaQuestao13.setStyle(null);


            labelNota1.setTextFill(Paint.valueOf("BLACK"));
            labelNota2.setTextFill(Paint.valueOf("BLACK"));
            labelNota3.setTextFill(Paint.valueOf("BLACK"));

            plusSign1.setFill(Paint.valueOf("BLACK"));
            plusSign2.setFill(Paint.valueOf("BLACK"));

            divLine.setStroke(Paint.valueOf("BLACK"));
            
            questao.setFill(Paint.valueOf("BLACK"));
            textEnunciado.setFill(Paint.valueOf("BLACK"));
            textNota1.setFill(Paint.valueOf("BLACK"));
            textNota2.setFill(Paint.valueOf("BLACK"));
            textNota3.setFill(Paint.valueOf("BLACK"));
            textNota4.setFill(Paint.valueOf("BLACK"));
            textResultado.setFill(Paint.valueOf("BLACK"));
            textSitRes.setFill(Paint.valueOf("BLACK"));
            textSituacao.setFill(Paint.valueOf("BLACK"));
            textNotaMin.setFill(Paint.valueOf("BLACK"));
            tres.setFill(Paint.valueOf("BLACK"));
            igual.setFill(Paint.valueOf("BLACK"));
        }
    }
}