package controllers;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.util.Duration;
import questoes.EnunciadoDasQuestoes;
import questoes.Questao11;
import source.App;

public class Questao11Controller {


    @FXML private BorderPane telaQuestao11;
    @FXML private Button buttonAbrirConta;
    @FXML private Button buttonConta;
    @FXML private Button buttonDadosConta;
    @FXML private Button buttonDepositar;
    @FXML private Button buttonDeposito;
    @FXML private Button buttonHome;
    @FXML private Button buttonJoao;
    @FXML private Button buttonMaria;
    @FXML private Button buttonTransferencia;
    @FXML private Button buttonTransferir;
    @FXML private Button buttonVoltar;
    @FXML private Group groupOutput;
    @FXML private HBox hBoxDados;
    @FXML private Label copyRight;
    @FXML private Label labelDeposito;
    @FXML private Label labelDest;
    @FXML private Label labelProp;
    @FXML private Label labelTransferencia;
    @FXML private Label textInfoDeposito;
    @FXML private Label textInfoTransf;
    @FXML private Text questao;
    @FXML private Text textAcesso;
    @FXML private Text textConfirmarTransf;
    @FXML private Text textData;
    @FXML private Text textDestTransf;
    @FXML private Text textEnunciado;
    @FXML private Text textInfoConta;
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
    @FXML private VBox buttonsVBox;
    @FXML private VBox vBoxCadastro;
    @FXML private VBox vBoxDeposito;
    @FXML private VBox vBoxTransferencia;

    Questao11 contaUsuario;
    Questao11 contaDestino;
    Questao11 contaJoao;
    Questao11 contaMaria;


    public void initialize() {
        acaoDosBotoes();
        statusInicial();

        setStilo();
        exibirConteudo();

        contaJoao = new Questao11("João Maria Soares Pereira");
        contaMaria = new Questao11("Maria José Soares Pereira");
        
    }





    private void statusInicial() {
        buttonsVBox.getChildren().removeAll(buttonTransferir, buttonDepositar);
        buttonDadosConta.setDisable(true);

        buttonTransferencia.setDisable(true);

        vBoxCadastro.setVisible(false);
        vBoxDeposito.setVisible(false);
        vBoxTransferencia.setVisible(false);
        hBoxDados.setVisible(false);
    }





    private void acaoDosBotoes() {

        Tooltip nome = new Tooltip("Que questão chata de fazer da p*rra, bicho...");
        nome.setShowDelay(Duration.millis(200));
        nome.setShowDuration(Duration.millis(800));
        Tooltip.install(copyRight, nome);

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
                    buttonsVBox.getChildren().removeAll(buttonAbrirConta);
                    buttonsVBox.getChildren().addAll(buttonDepositar, buttonTransferir);

                }
            }
            
        });
        
        buttonDadosConta.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                textNome.setText(contaUsuario.getProprietario());
                textNumero.setText(String.valueOf(contaUsuario.getNumConta()) + "-00");
                textValor.setText(String.valueOf(contaUsuario.getSaldo()));
                textData.setText(String.valueOf(contaUsuario.getUltimoAcesso()));

                
                if (vBoxTransferencia.isVisible()) {
                    vBoxTransferencia.setVisible(false);
                    buttonTransferencia.setDisable(true);
                }

                if (vBoxDeposito.isVisible()) {
                    vBoxDeposito.setVisible(false);
                }

                hBoxDados.setVisible(true);
            }
            
        });
        
        buttonDepositar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                
                if (vBoxTransferencia.isVisible()) {
                    vBoxTransferencia.setVisible(false);
                    buttonTransferencia.setDisable(true);
                }

                if (hBoxDados.isVisible()) {
                    hBoxDados.setVisible(false);
                }

                vBoxDeposito.setVisible(true);

            }
            
        });

        buttonDeposito.setOnMouseClicked(new EventHandler<MouseEvent>() {

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
                buttonTransferencia.setDisable(false);
            }
            
        });
        
        buttonMaria.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                contaDestino = contaMaria;
                textValTransf.setText("Valor a transferir: " + tfTransf.getText() + " R$");
                textDestTransf.setText("Destinatário: " + contaDestino.getProprietario());
                buttonTransferencia.setDisable(false);
            }
            
        });
        
        buttonTransferencia.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if(validarValor(true)){
                    if (contaUsuario.transferir(contaDestino, (float)Double.parseDouble(tfTransf.getText()))) {
                        showPopup("Transferência realizada com sucesso", true);
                    }
                    tfTransf.clear();
                    textValTransf.setText("Valor a transferir: ");
                    textDestTransf.setText("Destinatário: ");
                }
            }
            
        });
        
        buttonTransferir.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (vBoxDeposito.isVisible()) {
                    vBoxDeposito.setVisible(false);
                }

                if (hBoxDados.isVisible()) {
                    hBoxDados.setVisible(false);
                }

                vBoxTransferencia.setVisible(true);
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





    private void showPopup(String texto, boolean isSucess) {
        try{

            FXMLLoader loader;
            Parent root;
            if (isSucess) {
                loader = new FXMLLoader(getClass().getResource("../views/telaPopupSucesso.fxml"));
                root = loader.load();

                
                TelaPopupSucessoController controller = loader.getController();
                controller.initialize(texto);

            }
            else {
                loader = new FXMLLoader(getClass().getResource("../views/telaPopupErro.fxml"));
                root = loader.load();
                
                TelaPopupErroController controller = loader.getController();
                controller.initialize(texto);
            };
            
            
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
        textEnunciado.setText(EnunciadoDasQuestoes.questao11.substring(3));
    }


    
    private void setStilo() {
        if (App.darkMode) {
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            buttonHome.getStyleClass().setAll("btn-questao-DM");
            buttonAbrirConta.getStyleClass().setAll("btn-questao-DM");
            buttonConta.getStyleClass().setAll("btn-questao-DM");
            buttonDadosConta.getStyleClass().setAll("btn-questao-DM");
            buttonDepositar.getStyleClass().setAll("btn-questao-DM");
            buttonDeposito.getStyleClass().setAll("btn-questao-DM");
            buttonJoao.getStyleClass().setAll("btn-questao-DM");
            buttonMaria.getStyleClass().setAll("btn-questao-DM");
            buttonTransferencia.getStyleClass().setAll("btn-questao-DM");
            buttonTransferir.getStyleClass().setAll("btn-questao-DM");
            telaQuestao11.setStyle("-fx-background-color: #282828");

            labelDeposito.setTextFill(Paint.valueOf("WHITE"));
            labelDest.setTextFill(Paint.valueOf("WHITE"));
            labelProp.setTextFill(Paint.valueOf("WHITE"));
            labelTransferencia.setTextFill(Paint.valueOf("WHITE"));
            textInfoDeposito.setTextFill(Paint.valueOf("WHITE"));
            textInfoTransf.setTextFill(Paint.valueOf("WHITE"));
            
            questao.setFill(Paint.valueOf("WHITE"));
            textAcesso.setFill(Paint.valueOf("WHITE"));
            textConfirmarTransf.setFill(Paint.valueOf("WHITE"));
            textData.setFill(Paint.valueOf("WHITE"));
            textDestTransf.setFill(Paint.valueOf("WHITE"));
            textEnunciado.setFill(Paint.valueOf("WHITE"));
            textInfoConta.setFill(Paint.valueOf("WHITE"));
            textNome.setFill(Paint.valueOf("WHITE"));
            textNumConta.setFill(Paint.valueOf("WHITE"));
            textNumero.setFill(Paint.valueOf("WHITE"));
            textProp.setFill(Paint.valueOf("WHITE"));
            textSaldoConta.setFill(Paint.valueOf("WHITE"));
            textValTransf.setFill(Paint.valueOf("WHITE"));
            textValor.setFill(Paint.valueOf("WHITE"));

            
        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            buttonAbrirConta.getStyleClass().setAll("btn-questao");
            buttonConta.getStyleClass().setAll("btn-questao");
            buttonDadosConta.getStyleClass().setAll("btn-questao");
            buttonDepositar.getStyleClass().setAll("btn-questao");
            buttonDeposito.getStyleClass().setAll("btn-questao");
            buttonJoao.getStyleClass().setAll("btn-questao");
            buttonMaria.getStyleClass().setAll("btn-questao");
            buttonTransferencia.getStyleClass().setAll("btn-questao");
            buttonTransferir.getStyleClass().setAll("btn-questao");
            telaQuestao11.setStyle(null);

            labelDeposito.setTextFill(Paint.valueOf("BLACK"));
            labelDest.setTextFill(Paint.valueOf("BLACK"));
            labelProp.setTextFill(Paint.valueOf("BLACK"));
            labelTransferencia.setTextFill(Paint.valueOf("BLACK"));
            textInfoDeposito.setTextFill(Paint.valueOf("BLACK"));
            textInfoTransf.setTextFill(Paint.valueOf("BLACK"));
            
            questao.setFill(Paint.valueOf("BLACK"));
            textAcesso.setFill(Paint.valueOf("BLACK"));
            textConfirmarTransf.setFill(Paint.valueOf("BLACK"));
            textData.setFill(Paint.valueOf("BLACK"));
            textDestTransf.setFill(Paint.valueOf("BLACK"));
            textEnunciado.setFill(Paint.valueOf("BLACK"));
            textInfoConta.setFill(Paint.valueOf("BLACK"));
            textNome.setFill(Paint.valueOf("BLACK"));
            textNumConta.setFill(Paint.valueOf("BLACK"));
            textNumero.setFill(Paint.valueOf("BLACK"));
            textProp.setFill(Paint.valueOf("BLACK"));
            textSaldoConta.setFill(Paint.valueOf("BLACK"));
            textValTransf.setFill(Paint.valueOf("BLACK"));
            textValor.setFill(Paint.valueOf("BLACK"));

        }
    }
}