package br.edu.ufersa.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import br.edu.ufersa.questoes.Questao11;

public class Questao11Controller extends BaseController{


    @FXML private BorderPane telaQuestao11;
    @FXML private Button buttonAbrirConta;
    @FXML private Button buttonConta;
    @FXML private Button buttonDadosConta;
    @FXML private Button buttonDepositar;
    @FXML private Button buttonConfirmDep;
    @FXML private Button buttonJoao;
    @FXML private Button buttonMaria;
    @FXML private Button buttonConfirmTransf;
    @FXML private Button buttonTransferir;
    @FXML private Group groupOutput;
    @FXML private HBox hBoxDados;
    @FXML private Label copyRight;
    @FXML private Label labelDeposito;
    @FXML private Label labelDestinatario;
    @FXML private Label labelInfoConta;
    @FXML private Label labelInfoDeposito;
    @FXML private Label labelInfoTransf;
    @FXML private Label labelProprietario;
    @FXML private Label labelTransferencia;
    @FXML private Text textAcesso;
    @FXML private Text textConfirmarTransf;
    @FXML private Text textData;
    @FXML private Text textDestTransf;
    @FXML private Text textNome;
    @FXML private Text textNumConta;
    @FXML private Text textNumero;
    @FXML private Text textProp;
    @FXML private Text textSaldoConta;
    @FXML private Text textValTransf;
    @FXML private Text textValor;
    @FXML private TextField tfDeposito;
    @FXML private TextField tfProp;
    @FXML private TextField tfTransf;
    @FXML private VBox vBoxButtons;
    @FXML private VBox vBoxCadastro;
    @FXML private VBox vBoxDeposito;
    @FXML private VBox vBoxTransferencia;

    Questao11 contaUsuario;
    Questao11 contaDestino;
    Questao11 contaJoao = new Questao11("João Maria Soares Pereira");;
    Questao11 contaMaria = new Questao11("Maria José Soares Pereira");


    public void initialize() {
        BaseController.numQuestao = 11;
        super.initialize();
        setStilo(new Button[] { buttonAbrirConta, buttonConta, buttonDadosConta, buttonDepositar, buttonConfirmDep, 
                                buttonJoao, buttonMaria, buttonConfirmTransf, buttonTransferir}, 
                 new Label[]  { labelDeposito, labelDestinatario, labelInfoConta, labelInfoDeposito, 
                                labelInfoTransf, labelProprietario, labelTransferencia}, 
                 new Pane[]   { telaQuestao11}, null, 
                 new Text[]   { textAcesso, textConfirmarTransf, textData, textDestTransf, textNome, 
                                textNumConta, textNumero, textProp, textSaldoConta, textValTransf, textValor});
        acaoDosBotoes();
        estadoInicial();
    }





    private void estadoInicial() {
        vBoxButtons.getChildren().removeAll(buttonTransferir, buttonDepositar);
        buttonDadosConta.setDisable(true);
        buttonConfirmTransf.setDisable(true);

        vBoxCadastro.setVisible(false);
        vBoxDeposito.setVisible(false);
        vBoxTransferencia.setVisible(false);
        hBoxDados.setVisible(false);
    }





    private void acaoDosBotoes() {
        buttonAbrirConta.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                vBoxCadastro.setVisible(true);
            }
        });
        
        buttonConta.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if(validarProprietario()){
                    contaUsuario = new Questao11(tfProp.getText());
                    showPopup("Cliente cadastrado com sucesso", true);
                    
                    vBoxCadastro.setVisible(false);
                    buttonDadosConta.setDisable(false);
                    vBoxButtons.getChildren().removeAll(buttonAbrirConta);
                    vBoxButtons.getChildren().addAll(buttonDepositar, buttonTransferir);
                }
            }
        });
        
        buttonDadosConta.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                textNome.setText(contaUsuario.getProprietario());
                textNumero.setText(String.valueOf(contaUsuario.getNumConta()) + "-00");
                textValor.setText(String.valueOf("R$ " + contaUsuario.getSaldo()));
                textData.setText(String.valueOf(contaUsuario.getUltimoAcesso()));

                if (vBoxTransferencia.isVisible()) {
                    vBoxTransferencia.setVisible(false);
                    buttonConfirmTransf.setDisable(true);
                }
                if (vBoxDeposito.isVisible()) vBoxDeposito.setVisible(false);
                hBoxDados.setVisible(true);
            }
        });
        
        buttonDepositar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                
                if (vBoxTransferencia.isVisible()) {
                    vBoxTransferencia.setVisible(false);
                    buttonConfirmTransf.setDisable(true);
                }
                if (hBoxDados.isVisible()) hBoxDados.setVisible(false);
                vBoxDeposito.setVisible(true);
            }
        });
        buttonConfirmDep.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (validarValor(false)) {
                    if(contaUsuario.depositar((float)Double.parseDouble(tfDeposito.getText()))) {
                        showPopup("Deposito relizado com sucesso", true);
                    }
                    tfDeposito.clear();
                }
            }
        });
        
        buttonJoao.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                contaDestino = contaJoao;
                textValTransf.setText("Valor a transferir: " + tfTransf.getText() + " R$");
                textDestTransf.setText("Destinatário: " + contaDestino.getProprietario());
                buttonConfirmTransf.setDisable(false);
            }
        });
        buttonMaria.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                contaDestino = contaMaria;
                textValTransf.setText("Valor a transferir: " + tfTransf.getText() + " R$");
                textDestTransf.setText("Destinatário: " + contaDestino.getProprietario());
                buttonConfirmTransf.setDisable(false);
            }
        });
        
        buttonConfirmTransf.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if(validarValor(true)){
                    double valorTranf = Double.parseDouble(tfTransf.getText());
                    if(valorTranf <= contaUsuario.getSaldo()){
                        if (contaUsuario.transferir(contaDestino, (float)Double.parseDouble(tfTransf.getText()))) {
                            showPopup("Transferência realizada com sucesso", true);
                        }
                        tfTransf.clear();
                        textValTransf.setText("Valor a transferir: ");
                        textDestTransf.setText("Destinatário: ");
                    } else showPopup("O valor da transferência excede seu saldo", false);
                }
            }
        });
        buttonTransferir.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                tfTransf.clear();
                textValTransf.setText("Valor a transferir: " );
                textDestTransf.setText("Destinatário: " );
                buttonConfirmTransf.setDisable(true);
                if (vBoxDeposito.isVisible()) vBoxDeposito.setVisible(false);
                if (hBoxDados.isVisible()) hBoxDados.setVisible(false);
                vBoxTransferencia.setVisible(true);

            }
        });

        tfTransf.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent arg0) {
                textValTransf.setText("Valor a transferir: " + tfTransf.getText() + " R$");
            }
        });
    }



    private boolean validarProprietario() {
        if (tfProp.getText().isEmpty()) {
            showPopup("O nome do proprietário não pode ser nulo", false);
            return false;
        }
        if (tfProp.getText().matches("[\\d]+")) {
            showPopup("O nome do proprietário não pode ser um número", false);
            return false;
        }
        return true;
    }
    private boolean validarValor(boolean isTranferencia) {
        if(isTranferencia){
            if (tfTransf.getText().matches("[a-zA-Z]+")) {
                showPopup("O valor inserido não é válido, tente novamente", false);
                return false;
            } else if (tfTransf.getText().matches("[\\d^.]+")) { 
                double valor = Double.parseDouble(tfTransf.getText());

                if (valor <= 0) {
                    showPopup("O valor não pode ser negativo ou 0", false);
                    return false;
                }
            }
        } else {
            if (tfDeposito.getText().matches("[a-zA-Z]+")) {
                showPopup("O valor inserido não é válido, tente novamente", false);
                return false;
            } else if (tfDeposito.getText().matches("[\\d^.]+")) { 
                double valor = Double.parseDouble(tfDeposito.getText());
                if (valor <= 0) {
                    showPopup("O valor não pode ser negativo ou 0", false);
                    return false;
                }
            }
        }
        return true;
    }
}