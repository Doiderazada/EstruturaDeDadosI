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
import questoes.Questao25;
import source.App;

public class Questao25Controller {

    
    @FXML private BorderPane telaQuestao25;
    @FXML private Button buttonConfirmCreate;
    @FXML private Button buttonConfirmEdit;
    @FXML private Button buttonCriar;
    @FXML private Button buttonEditar;
    @FXML private Button buttonHome;
    @FXML private Button buttonQuestao27;
    @FXML private Button buttonQuestao28;
    @FXML private Button buttonQuestao29;
    @FXML private Button buttonVisualizar;
    @FXML private Button buttonVoltar;
    @FXML private Label copyRight;
    @FXML private Label labelPosicao;
    @FXML private Label labelValor;
    @FXML private Label labelVetor;
    @FXML private Pane paneView;
    @FXML private ScrollPane sPaneView;
    @FXML private Text questao;
    @FXML private Text textEnunciado;
    @FXML private Text textResposta;
    @FXML private Text textView;
    @FXML private TextField tfPosicao;
    @FXML private TextField tfValor;
    @FXML private TextField tfVetor;
    @FXML private VBox vBoxButtons;
    @FXML private VBox vBoxCreate;
    @FXML private VBox vBoxEdit;

    private int cont;
    private int tamanho;
    private Questao25 vetor;
    public static boolean questao27, questao28, questao29;

    

    public void initialize() {
        acaoDosBotoes();
        setStilo();
        exibirConteudo();
        estadoInicial();


        cont = -1;
    }


    private void estadoInicial(){

        labelVetor.setText("Tamanho do vetor");
        
        buttonEditar.setDisable(true);
        buttonVisualizar.setDisable(true);
        vBoxButtons.getChildren().removeAll(buttonQuestao27, buttonQuestao28, buttonQuestao29);

        vBoxCreate.setVisible(false);
        vBoxEdit.setVisible(false);
        sPaneView.setVisible(false);

        textResposta.setVisible(false);
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

        buttonCriar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                vBoxCreate.setVisible(true);
            }
            
        });
        buttonEditar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (textResposta.isVisible()) textResposta.setVisible(false);
                if (sPaneView.isVisible()) sPaneView.setVisible(false);

                textResposta.setVisible(false);
                vBoxEdit.setVisible(true);
            }
            
        });
        buttonVisualizar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (textResposta.isVisible()) textResposta.setVisible(false);
                if (vBoxEdit.isVisible()) vBoxEdit.setVisible(false);

                textView.setText(vetor.exibirVetor());
                sPaneView.setVisible(true);
            }
            
        });



        buttonConfirmCreate.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (cont == -1) {
                    if (validarCreate()) {
                        tamanho = Integer.parseInt(tfVetor.getText());
                        vetor = new Questao25(tamanho);
                    }

                    cont++;

                    labelVetor.setText((cont+1) + "º elemento do vetor");
                    tfVetor.clear();
                    buttonConfirmCreate.setText("Próximo");
                } else {
                    int valor = Integer.parseInt(tfVetor.getText());
                    vetor.setValor(cont, valor);

                    cont++;

                    labelVetor.setText((cont+1) + "º elemento do vetor");
                    tfVetor.clear();
                }

                if (cont+1 == tamanho) {
                    buttonConfirmCreate.setText("Concluir");
                }

                if (cont == tamanho) {
                    vBoxCreate.setVisible(false);
                    textResposta.setText("Vetor criado e preenchido com sucesso!");
                    textResposta.setVisible(true);
                    buttonCriar.setDisable(true);

                    buttonEditar.setDisable(false);
                    buttonVisualizar.setDisable(false);

                    if (questao27) vBoxButtons.getChildren().add(buttonQuestao27);
                    if (questao28) vBoxButtons.getChildren().add(buttonQuestao28);
                    if (questao29) vBoxButtons.getChildren().add(buttonQuestao29);
                }
            }
            
        });
        buttonConfirmEdit.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (validarEdit()) {
                    int posicao = Integer.parseInt(tfPosicao.getText());
                    int valor = Integer.parseInt(tfValor.getText());

                    vetor.setValor(posicao, valor);

                    vBoxEdit.setVisible(false);
                    tfPosicao.clear();
                    tfValor.clear();
                    textResposta.setText("Vetor editado com sucesso!");
                    textResposta.setVisible(true);
                }
            }
            
        });


        buttonQuestao27.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                irQuestao27();
            }

            
        });
        buttonQuestao28.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                irQuestao28();
            }

        });
        buttonQuestao29.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                irQuestao29();
            }

        });

        Tooltip mensagem = new Tooltip("Você ainda vai voltar nessa questão...");
        
        if (questao27 || questao28 || questao29) {
            mensagem.setText("Eu avisei.");
        }
        mensagem.setShowDelay(Duration.millis(200));
        mensagem.setShowDuration(Duration.millis(800));
        mensagem.setAutoHide(true);
        copyRight.setTooltip(mensagem);
    }

    
    



    private boolean validarCreate() {
        
        if (tfVetor.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente");
            return false;
        } else if (tfVetor.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras");
            return false;
        } else if (tfVetor.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfVetor.getText());
            if (num < 1 ) {
                showPopup("O vetor não pode ter tamanho menor que 1");
                return false;
            }
        }

        return true;
    }
    
    private boolean validarEdit() {
        
        if (tfPosicao.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente");
            return false;
        } else if (tfPosicao.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras");
            return false;
        } else if (tfPosicao.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfPosicao.getText());
            if (num < 0 || num > tamanho-1) {
                showPopup("O valor não é um número válido para a posição");
                return false;
            }
        }
        
        if (tfValor.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente");
            return false;
        } else if (tfValor.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras");
            return false;
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



    private void irQuestao27() {
        Questao27Controller.questao25 = true;
        Questao27Controller.vetorQ25 = vetor;
        App.trocarDeTela("questao27");
    }

    private void irQuestao28() {
        Questao28Controller.questao25 = true;
        Questao28Controller.vetorQ25 = vetor;
        App.trocarDeTela("questao28");
    }
    
    private void irQuestao29() {
        Questao29Controller.questao25 = true;
        Questao29Controller.vetorQ25 = vetor;
        App.trocarDeTela("questao29");
    }



    private void exibirConteudo() { 
        questao.setText(questao.getText() + "\t");
        textEnunciado.setText(EnunciadoDasQuestoes.questao25.substring(3));
    }


    
    private void setStilo() {
        if (App.darkMode) {
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            buttonHome.getStyleClass().setAll("btn-questao-DM");
            buttonCriar.getStyleClass().setAll("btn-questao-DM");
            buttonEditar.getStyleClass().setAll("btn-questao-DM");
            buttonVisualizar.getStyleClass().setAll("btn-questao-DM");
            buttonConfirmCreate.getStyleClass().setAll("btn-questao-DM");
            buttonConfirmEdit.getStyleClass().setAll("btn-questao-DM");
            buttonQuestao27.getStyleClass().setAll("btn-questao-DM");
            buttonQuestao28.getStyleClass().setAll("btn-questao-DM");
            buttonQuestao29.getStyleClass().setAll("btn-questao-DM");
            telaQuestao25.setStyle("-fx-background-color: #282828");
            paneView.setStyle("-fx-background-color: #282828");

            labelPosicao.setTextFill(Paint.valueOf("WHITE"));
            labelValor.setTextFill(Paint.valueOf("WHITE"));
            labelVetor.setTextFill(Paint.valueOf("WHITE"));
            
            questao.setFill(Paint.valueOf("WHITE"));
            textEnunciado.setFill(Paint.valueOf("WHITE"));
            textResposta.setFill(Paint.valueOf("WHITE"));
            textView.setFill(Paint.valueOf("WHITE"));
            
        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            buttonCriar.getStyleClass().setAll("btn-questao");
            buttonEditar.getStyleClass().setAll("btn-questao");
            buttonVisualizar.getStyleClass().setAll("btn-questao");
            buttonConfirmCreate.getStyleClass().setAll("btn-questao");
            buttonConfirmEdit.getStyleClass().setAll("btn-questao");
            buttonQuestao27.getStyleClass().setAll("btn-questao");
            buttonQuestao28.getStyleClass().setAll("btn-questao");
            buttonQuestao29.getStyleClass().setAll("btn-questao");
            telaQuestao25.setStyle(null);
            paneView.setStyle(null);

            labelPosicao.setTextFill(Paint.valueOf("BLACK"));
            labelValor.setTextFill(Paint.valueOf("BLACK"));
            labelVetor.setTextFill(Paint.valueOf("BLACK"));
            
            questao.setFill(Paint.valueOf("BLACK"));
            textEnunciado.setFill(Paint.valueOf("BLACK"));
            textResposta.setFill(Paint.valueOf("BLACK"));
            textView.setFill(Paint.valueOf("BLACK"));
        }
    }
}