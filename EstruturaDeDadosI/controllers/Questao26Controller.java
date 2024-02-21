package controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import questoes.Questao26;

public class Questao26Controller extends BaseController{


    @FXML private BorderPane telaQuestao26;
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
        BaseController.numQuestao = 26;
        super.initialize();
        acaoDosBotoes();
        setStilo(new Button[] { buttonConfirmCreate, buttonConfirmEdit, buttonCriar, buttonEditar, buttonVisualizar},
                 new Label[]  { labelColunaCreate, labelColunaEdit, labelLinhaCreate, 
                                labelLinhaEdit, labelMatriz, labelValor},
                 new Pane[]   { paneView, telaQuestao26}, null,
                 new Text[]   { textResposta});
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
                criarMatriz();   
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

    
    



    private void criarMatriz() {
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
        if (cont+1 == linhas*colunas) buttonConfirmCreate.setText("Concluir");

        if (cont == linhas*colunas) {
            vBoxCreate.setVisible(false);
            buttonCriar.setDisable(true);

            buttonEditar.setDisable(false);
            buttonVisualizar.setDisable(false);

            textResposta.setText("Matriz criada e preenchida com sucesso!");
            sPaneView.setVisible(true);
        }
    }


    private boolean validarCreate() {
        if (tfLinhaCreate.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        } else if (tfLinhaCreate.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras", false);
            return false;
        } else if (tfLinhaCreate.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfColunaCreate.getText());
            if (num < 1 ) {
                showPopup("A matriz não pode ter tamanho menor que 1", false);
                return false;
            }
        }
        if (tfColunaCreate.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        } else if (tfColunaCreate.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras", false);
            return false;
        } else if (tfColunaCreate.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfColunaCreate.getText());
            if (num < 1 ) {
                showPopup("A matriz não pode ter tamanho menor que 1", false);
                return false;
            }
        }
        return true;
    }
    
    private boolean validarEdit() {
        if (tfLinhaEdit.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        } else if (tfLinhaEdit.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras", false);
            return false;
        } else if (tfLinhaEdit.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfLinhaEdit.getText());
            if (num < 0 || num > linhas-1) {
                showPopup("O valor não é um número válido para a linha", false);
                return false;
            }
        }
        if (tfColunaEdit.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        } else if (tfColunaEdit.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras", false);
            return false;
        } else if (tfColunaEdit.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfColunaEdit.getText());
            if (num < 0 || num > colunas-1) {
                showPopup("O valor não é um número válido para a coluna", false);
                return false;
            }
        }
        if (tfValor.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        } else if (tfValor.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras", false);
            return false;
        }
        return true;
    }
}