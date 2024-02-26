package controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import questoes.Questao20;

public class Questao20Controller extends BaseController{
    

    @FXML private BorderPane telaQuestao20;
    @FXML private Button buttonConfirmar;
    @FXML private Button buttonNovoInvestimento;
    @FXML private Label copyRight;
    @FXML private Label labelInvestimentoInicial;
    @FXML private Label labelInvestimentoMensal;
    @FXML private Label labelTaxaJuros;
    @FXML private Label labelTempoRendimento;
    @FXML private Pane paneTeste;
    @FXML private ScrollPane sPaneOutput;
    @FXML private Text textResposta;
    @FXML private Text textSaldo;
    @FXML private TextField tfInvestIni;
    @FXML private TextField tfInvestMens;
    @FXML private TextField tfTaxJur;
    @FXML private TextField tfTempo;
    @FXML private VBox vBoxInput;
    
    private Questao20 investimento;


    public void initialize() {
        BaseController.numQuestao = 20;
        super.initialize();
        acaoDosBotoes();
        setStilo(new Button[] { buttonConfirmar, buttonNovoInvestimento},
                 new Label[]  { labelInvestimentoInicial, labelInvestimentoMensal, 
                                labelTaxaJuros, labelTempoRendimento},
                 new Pane[]   { paneTeste, telaQuestao20}, null,
                 new Text[]   { textResposta, textSaldo});
        estadoInicial();
    }



    private void estadoInicial() {
        sPaneOutput.setVisible(false);
        textResposta.setText(null);
        textSaldo.setText(null);
    }





    private void acaoDosBotoes() {
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

        for (int i = 0; i < tempo; i++) {
            textResposta.setText(textResposta.getText() + "Valor rendido ao final do " + (i+1) + "º mês: \n");
            textSaldo.setText(textSaldo.getText() + investimento.getRendimentoMensal(i) + " R$\n");
        }
    }



    private boolean verificarInput() {
        if (tfInvestIni.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        } else if (tfInvestIni.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras", false);
            return false;
        } else if (tfInvestIni.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfInvestIni.getText());
            if (num < 1 ) {
                showPopup("O investimento não pode ser menor que 1", false);
                return false;
            }
        }
        if (tfInvestMens.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, mas pode ser 0", false);
            return false;
        } else if (tfInvestMens.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras", false);
            return false;
        } else if (tfInvestMens.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfInvestMens.getText());
            if (num < 0 ) {
                showPopup("O investimento não pode ser menor que 0", false);
                return false;
            }
        }
        if (tfTaxJur.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        } else if (tfTaxJur.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras", false);
            return false;
        } else if (tfTaxJur.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfTaxJur.getText());
            if (num <= 0 ) {
                showPopup("A taxa de rendimento não pode ser menor que, ou 0", false);
                return false;
            }
        }
        if (tfTempo.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        } else if (tfTempo.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras", false);
            return false;
        } else if (tfTempo.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfTempo.getText());
            if (num <= 0 ) {
                showPopup("A tempo rendendo não pode ser menor que, ou igual a 0", false);
                return false;
            }
        }
        return true;
    }   
}