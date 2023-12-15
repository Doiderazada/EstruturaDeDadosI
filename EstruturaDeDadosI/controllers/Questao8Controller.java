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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.util.Duration;
import questoes.EnunciadoDasQuestoes;
import questoes.Questao8;
import source.App;

public class Questao8Controller {
    
    @FXML private BorderPane telaQuestao8;
    @FXML private Button buttonConfirmar;
    @FXML private Button buttonHome;
    @FXML private Button buttonVerTabela;
    @FXML private Button buttonVoltar;
    @FXML private ImageView imageTabelaIMC;
    @FXML private Label copyRight;
    @FXML private Label labelAltura;
    @FXML private Label labelMassa;
    @FXML private Line divLine;
    @FXML private Text IMC;
    @FXML private Text equalSign;
    @FXML private Text potencia;
    @FXML private Text questao;
    @FXML private Text textEnunciado;
    @FXML private Text textMassa;
    @FXML private Text textAltura;
    @FXML private TextField tfAltura;
    @FXML private TextField tfMassa;
    @FXML private VBox inputVBox;
    @FXML private VBox outputVBox;



    public void initialize() {
        acaoDosBotoes();
        setStilo();
        exibirConteudo();
        inputVBox.setVisible(true);
        outputVBox.setVisible(false);
        imageTabelaIMC.setVisible(false);
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
                    Questao8.setAltura(Double.parseDouble(tfAltura.getText()));
                    Questao8.setMassa(Double.parseDouble(tfMassa.getText()));
                    
                    textAltura.setText(tfAltura.getText());
                    textMassa.setText(tfMassa.getText());
                    IMC.setText(String.valueOf(Questao8.medirIMC()));

                    outputVBox.setVisible(true);
                }
            }
            
        });

        buttonVerTabela.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (imageTabelaIMC.isVisible()) imageTabelaIMC.setVisible(false);
                else imageTabelaIMC.setVisible(true);
            }
            
        });

        Tooltip texto = new Tooltip("Cuidado com a saúde, irmão...");
        texto.setShowDelay(Duration.millis(200));
        texto.setShowDuration(Duration.millis(800));
        Tooltip.install(copyRight, texto);
    }

    

    private boolean verificarInput() {

        if (tfAltura.getText().contains(",")) {
            tfAltura.setText(tfAltura.getText().replace(",", "."));
        }
        if (tfMassa.getText().contains(",")) {
            tfMassa.setText(tfMassa.getText().replace(",", "."));
        }

        if (tfAltura.getText().isEmpty()) {
            showPopup("Os valores inseridos não são válidos, por favor, tente novamente.");
            return false;
        } else if (tfAltura.getText().matches("[a-zA-Z]+")) {
            showPopup("Os valores inseridos não são válidos, por favor, tente novamente.");
            return false;
        };

        if (tfMassa.getText().isEmpty()) {
            showPopup("Os valores inseridos não são válidos, por favor, tente novamente.");
            return false;
        } else if (tfMassa.getText().matches("0")) {
            showPopup("O divisor não pode ser 0");
            return false;
        } else if (tfMassa.getText().matches("[a-zA-Z]+")) {
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
        textEnunciado.setText(EnunciadoDasQuestoes.questao8.substring(3));
    }


    
    private void setStilo() {
        if (App.darkMode) {
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            buttonHome.getStyleClass().setAll("btn-questao-DM");
            buttonConfirmar.getStyleClass().setAll("btn-questao-DM");
            buttonVerTabela.getStyleClass().setAll("btn-questao-DM");
            telaQuestao8.setStyle("-fx-background-color: #282828");

            labelMassa.setTextFill(Paint.valueOf("WHITE"));
            labelAltura.setTextFill(Paint.valueOf("WHITE"));
            
            divLine.setStroke(Paint.valueOf("WHITE"));
            equalSign.setFill(Paint.valueOf("WHITE"));
            questao.setFill(Paint.valueOf("WHITE"));
            textEnunciado.setFill(Paint.valueOf("WHITE"));
            IMC.setFill(Paint.valueOf("WHITE"));
            textAltura.setFill(Paint.valueOf("WHITE"));
            textMassa.setFill(Paint.valueOf("WHITE"));
            potencia.setFill(Paint.valueOf("WHITE"));
            
        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            buttonConfirmar.getStyleClass().setAll("btn-questao");
            buttonVerTabela.getStyleClass().setAll("btn-questao");
            telaQuestao8.setStyle(null);

            labelMassa.setTextFill(Paint.valueOf("BLACK"));
            labelAltura.setTextFill(Paint.valueOf("BLACK"));
            
            divLine.setStroke(Paint.valueOf("BLACK"));
            equalSign.setFill(Paint.valueOf("BLACK"));
            questao.setFill(Paint.valueOf("BLACK"));
            textEnunciado.setFill(Paint.valueOf("BLACK"));
            IMC.setFill(Paint.valueOf("BLACK"));
            textAltura.setFill(Paint.valueOf("BLACK"));
            textMassa.setFill(Paint.valueOf("BLACK"));
            potencia.setFill(Paint.valueOf("BLACK"));
        }
    }
}