package controllers;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.util.Duration;
import questoes.EnunciadoDasQuestoes;
import questoes.Questao20;
import source.App;

public class Questao20Controller {
    

    @FXML private BorderPane telaQuestao20;
    @FXML private Button buttonConfirmar;
    @FXML private Button buttonHome;
    @FXML private Button buttonNovoInvestimento;
    @FXML private Button buttonVoltar;
    @FXML private Label copyRight;
    @FXML private Label labelInvestimentoInicial;
    @FXML private Label labelInvestimentoMensal;
    @FXML private Label labelTaxaJuros;
    @FXML private Label labelTempoRendimento;
    @FXML private Pane paneTeste;
    @FXML private ScrollPane sPaneOutput;
    @FXML private Text questao;
    @FXML private Text textEnunciado;
    @FXML private Text textResposta;
    @FXML private Text textSaldo;
    @FXML private TextField tfInvestIni;
    @FXML private TextField tfInvestMens;
    @FXML private TextField tfTaxJur;
    @FXML private TextField tfTempo;
    @FXML private VBox vBoxInput;
    
    private Questao20 investimento;


    public void initialize() {
        acaoDosBotoes();
        setStilo();
        exibirConteudo();

        sPaneOutput.setVisible(false);
        textResposta.setText(null);
        textSaldo.setText(null);
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
                    vBoxInput.setVisible(false);
                    fazerRender();
                    sPaneOutput.setVisible(true);
                }
            }
            
        });

        
        buttonNovoInvestimento.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                textResposta.setText(null);
                textSaldo.setText(null);

                sPaneOutput.setVisible(false);

                tfInvestIni.clear();
                tfInvestMens.clear();
                tfTaxJur.clear();
                tfTempo.clear();

                vBoxInput.setVisible(true);
            }
            
        });

        Tooltip investHint1 = new Tooltip("O depósito inicial na poupança");
        Tooltip investHint2 = new Tooltip("O depósito recorrente mensal, se houver");
        Tooltip investHint3 = new Tooltip("A taxa de rendimento da poupança, em porcentagem");
        Tooltip investHint4 = new Tooltip("O tempo que deseja deixar a poupança rendendo, em meses");

        investHint1.setShowDelay(Duration.millis(200));
        investHint2.setShowDelay(Duration.millis(200));
        investHint3.setShowDelay(Duration.millis(200));
        investHint4.setShowDelay(Duration.millis(200));

        investHint1.setShowDuration(Duration.seconds(1.5));
        investHint2.setShowDuration(Duration.seconds(1.5));
        investHint3.setShowDuration(Duration.seconds(1.5));
        investHint4.setShowDuration(Duration.seconds(1.5));

        investHint1.setAutoHide(true);
        investHint2.setAutoHide(true);
        investHint3.setAutoHide(true);
        investHint4.setAutoHide(true);

        labelInvestimentoInicial.setTooltip(investHint1);
        labelInvestimentoMensal.setTooltip(investHint2);
        labelTaxaJuros.setTooltip(investHint3);
        labelTempoRendimento.setTooltip(investHint4);

    }

    
    private void fazerRender() {
        

        double iniInvest = Double.parseDouble(tfInvestIni.getText());
        double investMens = Double.parseDouble(tfInvestMens.getText());
        double taxaJur = Double.parseDouble(tfTaxJur.getText());
        int tempo = Integer.parseInt(tfTempo.getText());

        investimento = new Questao20(iniInvest, investMens, taxaJur, tempo);

        investimento.deixarRender(tempo, iniInvest, investMens, taxaJur);

        for (int i = 0; i < tempo; i++) {
            textResposta.setText(textResposta.getText() + "Valor rendido ao final do " + (i+1) + "º mês: \n");
            textSaldo.setText(textSaldo.getText() + investimento.getRendimentoMensal(i) + " R$\n");
        }

    }



    private boolean verificarInput() {
        
        if (tfInvestIni.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente");
            return false;
        } else if (tfInvestIni.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras");
            return false;
        } else if (tfInvestIni.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfInvestIni.getText());
            if (num < 1 ) {
                showPopup("O investimento não pode ser menor que 1");
                return false;
            }
        }
        
        
        if (tfInvestMens.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, mas pode ser 0");
            return false;
        } else if (tfInvestMens.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras");
            return false;
        } else if (tfInvestMens.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfInvestMens.getText());
            if (num < 0 ) {
                showPopup("O investimento não pode ser menor que 0");
                return false;
            }
        }
        
        
        if (tfTaxJur.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente");
            return false;
        } else if (tfTaxJur.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras");
            return false;
        } else if (tfTaxJur.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfTaxJur.getText());
            if (num <= 0 ) {
                showPopup("A taxa de rendimento não pode ser menor que, ou 0");
                return false;
            }
        }
        
        
        if (tfTempo.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente");
            return false;
        } else if (tfTempo.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras");
            return false;
        } else if (tfTempo.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfTempo.getText());
            if (num <= 0 ) {
                showPopup("A tempo rendendo não pode ser menor que, ou igual a 0");
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
            
            double winX = buttonHome.getScene().getWindow().getX();
            double winY = buttonHome.getScene().getWindow().getY();
            double halfX = buttonHome.getScene().getWindow().getWidth()/2;
            double halfY = buttonHome.getScene().getWindow().getHeight()/2;

            double newX = (winX + halfX) - (popup.getWidth()/2);
            double newY = (winY + halfY) - (popup.getHeight()/2);

            popup.setX(newX);
            popup.setY(newY);
            
            
            popup.show(buttonHome.getScene().getWindow());

            

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
        textEnunciado.setText(EnunciadoDasQuestoes.questao20.substring(3));
    }


    
    private void setStilo() {
        if (App.darkMode) {
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            buttonHome.getStyleClass().setAll("btn-questao-DM");
            buttonConfirmar.getStyleClass().setAll("btn-questao-DM");
            buttonNovoInvestimento.getStyleClass().setAll("btn-questao-DM");
            telaQuestao20.setStyle("-fx-background-color: #282828");
            paneTeste.setStyle("-fx-background-color: #282828");

            labelInvestimentoInicial.setTextFill(Paint.valueOf("WHITE"));
            labelInvestimentoMensal.setTextFill(Paint.valueOf("WHITE"));
            labelTaxaJuros.setTextFill(Paint.valueOf("WHITE"));
            labelTempoRendimento.setTextFill(Paint.valueOf("WHITE"));

            questao.setFill(Paint.valueOf("WHITE"));
            textEnunciado.setFill(Paint.valueOf("WHITE"));
            textResposta.setFill(Paint.valueOf("WHITE"));
            textSaldo.setFill(Paint.valueOf("WHITE"));
            
        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            buttonConfirmar.getStyleClass().setAll("btn-questao");
            buttonNovoInvestimento.getStyleClass().setAll("btn-questao");
            telaQuestao20.setStyle(null);
            paneTeste.setStyle(null);

            labelInvestimentoInicial.setTextFill(Paint.valueOf("BLACK"));
            labelInvestimentoMensal.setTextFill(Paint.valueOf("BLACK"));
            labelTaxaJuros.setTextFill(Paint.valueOf("BLACK"));
            labelTempoRendimento.setTextFill(Paint.valueOf("BLACK"));

            questao.setFill(Paint.valueOf("BLACK"));
            textEnunciado.setFill(Paint.valueOf("BLACK"));
            textResposta.setFill(Paint.valueOf("BLACK"));
            textSaldo.setFill(Paint.valueOf("BLACK"));
        }
    }
}
