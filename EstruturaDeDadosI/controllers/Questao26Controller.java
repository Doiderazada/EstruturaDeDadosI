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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.util.Duration;
import questoes.EnunciadoDasQuestoes;
import questoes.Questao26;
import source.App;

public class Questao26Controller {


    @FXML private BorderPane telaQuestao26;
    @FXML private Button buttonVoltar;
    @FXML private Button buttonHome;
    @FXML private Button buttonCriar;
    @FXML private Button buttonEditar;
    @FXML private Button buttonVisualizar;
    @FXML private Button buttonConfirmCreate;
    @FXML private Button buttonConfirmEdit;
    @FXML private HBox hBoxMatriz;
    @FXML private Label copyRight;
    @FXML private Label labelMatriz;
    @FXML private Label labelLinhaCreate;
    @FXML private Label labelColunaCreate;
    @FXML private Label labelLinhaEdit;
    @FXML private Label labelColunaEdit;
    @FXML private Label labelValor;
    @FXML private Pane paneView;
    @FXML private ScrollPane sPaneView;
    @FXML private Text questao;
    @FXML private Text textEnunciado;
    @FXML private Text textResposta;
    @FXML private TextField tfLinhaCreate;
    @FXML private TextField tfColunaCreate;
    @FXML private TextField tfMatriz;
    @FXML private TextField tfLinhaEdit;
    @FXML private TextField tfColunaEdit;
    @FXML private TextField tfValor;
    @FXML private VBox vBoxCreate;
    @FXML private VBox vBoxEdit;
    @FXML private VBox vBoxMatriz;

    private int cont, contL, contC;
    private int linhas, colunas;
    private Questao26 matriz;

    public void initialize() {
        acaoDosBotoes();
        setStilo();
        exibirConteudo();
        estadoInicial();

        cont = -1;
        contL = 0;
        contC = 0;
    }


    private void estadoInicial(){

        
        buttonEditar.setDisable(true);
        buttonVisualizar.setDisable(true);

        vBoxCreate.setVisible(false);
        vBoxCreate.getChildren().removeAll(vBoxMatriz);

        vBoxEdit.setVisible(false);
        sPaneView.setVisible(false);
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
                if (sPaneView.isVisible()) sPaneView.setVisible(false);

                vBoxEdit.setVisible(true);
            }
            
        });
        buttonVisualizar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (sPaneView.isVisible()) sPaneView.setVisible(false);;
                if (vBoxEdit.isVisible()) vBoxEdit.setVisible(false);

                textResposta.setText(matriz.exibirMatriz());
                sPaneView.setVisible(true);
            }
            
        });


        buttonConfirmCreate.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (cont == -1) {
                    if (validarCreate()) {
                        linhas = Integer.parseInt(tfLinhaCreate.getText());
                        colunas = Integer.parseInt(tfColunaCreate.getText());
                        matriz = new Questao26(linhas, colunas);
                    }

                    cont++;

                    vBoxCreate.getChildren().removeAll(hBoxMatriz, buttonConfirmCreate);
                    vBoxCreate.getChildren().addAll(vBoxMatriz, buttonConfirmCreate);
                    labelMatriz.setText((cont+1) + "º elemento da matriz");
                    tfMatriz.clear();
                    buttonConfirmCreate.setText("Próximo");
                } else {
                    int valor = Integer.parseInt(tfMatriz.getText());
                    matriz.setValor(contL, contC, valor);
                    
                    contC++;
                    if (contC == colunas) {
                        contC = 0;
                        contL++;
                    }
                    cont++;

                    labelMatriz.setText((cont+1) + "º elemento do matriz");
                    tfMatriz.clear();
                }

                if (cont+1 == linhas*colunas) {
                    buttonConfirmCreate.setText("Concluir");
                }

                if (cont == linhas*colunas) {
                    vBoxCreate.setVisible(false);
                    buttonCriar.setDisable(true);

                    buttonEditar.setDisable(false);
                    buttonVisualizar.setDisable(false);

                    textResposta.setText("Matriz criada e preenchida com sucesso!");
                    sPaneView.setVisible(true);
                }
            }
            
        });
        buttonConfirmEdit.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (validarEdit()) {
                    int linEdit = Integer.parseInt(tfLinhaEdit.getText());
                    int colEdit = Integer.parseInt(tfColunaEdit.getText());
                    int valor = Integer.parseInt(tfValor.getText());

                    matriz.setValor(linEdit, colEdit, valor);

                    vBoxEdit.setVisible(false);
                    tfLinhaEdit.clear();
                    tfColunaEdit.clear();
                    tfValor.clear();
                    
                    textResposta.setText("Matriz editado com sucesso!");
                    sPaneView.setVisible(true);
                }
            }
            
        });
    }

    
    



    private boolean validarCreate() {
        
        if (tfLinhaCreate.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente");
            return false;
        } else if (tfLinhaCreate.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras");
            return false;
        } else if (tfLinhaCreate.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfColunaCreate.getText());
            if (num < 1 ) {
                showPopup("A matriz não pode ter tamanho menor que 1");
                return false;
            }
        }
        if (tfColunaCreate.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente");
            return false;
        } else if (tfColunaCreate.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras");
            return false;
        } else if (tfColunaCreate.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfColunaCreate.getText());
            if (num < 1 ) {
                showPopup("A matriz não pode ter tamanho menor que 1");
                return false;
            }
        }

        return true;
    }
    
    private boolean validarEdit() {
        
        if (tfLinhaEdit.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente");
            return false;
        } else if (tfLinhaEdit.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras");
            return false;
        } else if (tfLinhaEdit.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfLinhaEdit.getText());
            if (num < 0 || num > linhas-1) {
                showPopup("O valor não é um número válido para a linha");
                return false;
            }
        }
        if (tfColunaEdit.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente");
            return false;
        } else if (tfColunaEdit.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras");
            return false;
        } else if (tfColunaEdit.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfColunaEdit.getText());
            if (num < 0 || num > colunas-1) {
                showPopup("O valor não é um número válido para a coluna");
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



    private void exibirConteudo() { 
        questao.setText(questao.getText() + "\t");
        textEnunciado.setText(EnunciadoDasQuestoes.questao26.substring(3));
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
            telaQuestao26.setStyle("-fx-background-color: #282828");
            paneView.setStyle("-fx-background-color: #282828");

            labelColunaCreate.setTextFill(Paint.valueOf("WHITE"));
            labelColunaEdit.setTextFill(Paint.valueOf("WHITE"));
            labelLinhaCreate.setTextFill(Paint.valueOf("WHITE"));
            labelLinhaEdit.setTextFill(Paint.valueOf("WHITE"));
            labelValor.setTextFill(Paint.valueOf("WHITE"));
            labelMatriz.setTextFill(Paint.valueOf("WHITE"));
            
            questao.setFill(Paint.valueOf("WHITE"));
            textEnunciado.setFill(Paint.valueOf("WHITE"));
            textResposta.setFill(Paint.valueOf("WHITE"));
            
        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            buttonCriar.getStyleClass().setAll("btn-questao");
            buttonEditar.getStyleClass().setAll("btn-questao");
            buttonVisualizar.getStyleClass().setAll("btn-questao");
            buttonConfirmCreate.getStyleClass().setAll("btn-questao");
            buttonConfirmEdit.getStyleClass().setAll("btn-questao");
            telaQuestao26.setStyle(null);
            paneView.setStyle(null);

            labelColunaCreate.setTextFill(Paint.valueOf("BLACK"));
            labelColunaEdit.setTextFill(Paint.valueOf("BLACK"));
            labelLinhaCreate.setTextFill(Paint.valueOf("BLACK"));
            labelLinhaEdit.setTextFill(Paint.valueOf("BLACK"));
            labelValor.setTextFill(Paint.valueOf("BLACK"));
            labelMatriz.setTextFill(Paint.valueOf("BLACK"));
            
            questao.setFill(Paint.valueOf("BLACK"));
            textEnunciado.setFill(Paint.valueOf("BLACK"));
            textResposta.setFill(Paint.valueOf("BLACK"));
        }
    }
}