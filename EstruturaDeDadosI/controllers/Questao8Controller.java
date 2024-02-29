package controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.util.Duration;
import questoes.Questao8;

public class Questao8Controller extends BaseController{
    
    @FXML private BorderPane telaQuestao8;
    @FXML private Button buttonConfirmar;
    @FXML private Button buttonVerTabela;
    @FXML private ImageView imageTabelaIMC;
    @FXML private Label copyRight;
    @FXML private Label labelAltura;
    @FXML private Label labelMassa;
    @FXML private Line divLine;
    @FXML private Text textIMC;
    @FXML private Text textEqualSign;
    @FXML private Text textPotencia;
    @FXML private Text textMassa;
    @FXML private Text textAltura;
    @FXML private TextField tfAltura;
    @FXML private TextField tfMassa;
    @FXML private VBox vBoxInput;
    @FXML private VBox vBoxOutput;



    public void initialize() {
        BaseController.numQuestao = 8;
        super.initialize();
        setStilo(new Button[] { buttonConfirmar, buttonVerTabela}, 
                 new Label[]  { labelAltura, labelMassa}, 
                 new Pane[]   { telaQuestao8}, 
                 new Shape[]  { (Shape)divLine}, 
                 new Text[]   { textIMC, textEqualSign, textPotencia, textAltura, textMassa});
        acaoDosBotoes();;
        estadoInicial();
    }


    private void estadoInicial() {
        vBoxInput.setVisible(true);
        vBoxOutput.setVisible(false);
        imageTabelaIMC.setVisible(false);
    }


    private void acaoDosBotoes() {
        Tooltip texto = new Tooltip("Cuidado com a saúde, irmão...");
        texto.setShowDelay(Duration.millis(200));
        texto.setShowDuration(Duration.millis(800));
        Tooltip.install(copyRight, texto);

        buttonConfirmar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (verificarInput()) {
                    double altura = Double.parseDouble(tfAltura.getText());
                    double massa = Double.parseDouble(tfMassa.getText());
                    Questao8 pessoa = new Questao8(altura, massa);
                    
                    textAltura.setText(tfAltura.getText());
                    textMassa.setText(tfMassa.getText());
                    textIMC.setText(String.valueOf(pessoa.getIMC()) + "Kg/m²");

                    vBoxOutput.setVisible(true);
                }
            }
        });

        buttonVerTabela.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                if (imageTabelaIMC.isVisible()) {
                    imageTabelaIMC.setVisible(false);
                    buttonVerTabela.setText("Visualizar tabela");
                } else {
                    imageTabelaIMC.setVisible(true);
                    buttonVerTabela.setText("Ocultar tabela");
                }
            }
        });

        tfAltura.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent arg0) {
                estadoInicial();
            }
        });
        tfMassa.setOnKeyPressed(new EventHandler<KeyEvent>(){
            @Override
            public void handle(KeyEvent arg0) {
                estadoInicial();
            }
        });
    }

    

    private boolean verificarInput() {
        if (tfAltura.getText().contains(",")) 
            tfAltura.setText(tfAltura.getText().replace(",", "."));
        if (tfMassa.getText().contains(",")) 
            tfMassa.setText(tfMassa.getText().replace(",", "."));

        if (tfAltura.getText().isEmpty()) {
            showPopup("Os valores inseridos não são válidos, por favor, tente novamente.", false);
            return false;
        } else if (tfAltura.getText().matches("0")) {
            showPopup("O valor não pode ser 0", false);
            return false;
        } else if (tfAltura.getText().matches("[a-zA-Z]+")) {
            showPopup("Os valores inseridos não são válidos, por favor, tente novamente.", false);
            return false;
        };

        if (tfMassa.getText().isEmpty()) {
            showPopup("Os valores inseridos não são válidos, por favor, tente novamente.", false);
            return false;
        } else if (tfMassa.getText().matches("0")) {
            showPopup("O valor não pode ser 0", false);
            return false;
        } else if (tfMassa.getText().matches("[a-zA-Z]+")) {
            showPopup("Os valores inseridos não são válidos, por favor, tente novamente.", false);
            return false;
        }
        return true;
    }
}