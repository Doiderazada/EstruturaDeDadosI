package controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;
import javafx.util.Duration;
import questoes.Questao5;

public class Questao5Controller extends BaseController{

    @FXML private BorderPane telaQuestao5;
    @FXML private Button buttonConfirmar;
    @FXML private HBox hBoxOutput;
    @FXML private Label copyRight;
    @FXML private Label labelValA;
    @FXML private Label labelValB;
    @FXML private Label labelValC;
    @FXML private Line divLine;
    @FXML private Text textIgual;
    @FXML private Text textPlusSign1;
    @FXML private Text textPlusSign2;
    @FXML private Text textResultado;
    @FXML private Text textValA;
    @FXML private Text textValB;
    @FXML private Text textValC;
    @FXML private Text textTres;
    @FXML private TextField tfValA;
    @FXML private TextField tfValB;
    @FXML private TextField tfValC;
    @FXML private VBox vBoxInput;


    public void initialize() {
        BaseController.numQuestao = 5;
        super.initialize();
        setStilo(new Button[] {buttonConfirmar}, 
                 new Label[]  {labelValA, labelValB, labelValC}, 
                 new Pane[]   { telaQuestao5}, 
                 new Shape[]  {(Shape)divLine}, 
                 new Text[]   { textIgual, textPlusSign1, textPlusSign1, textPlusSign2, textResultado, 
                                textTres, textValA, textValB, textValC});
        acaoDosBotoes();
        hBoxOutput.setVisible(false);
    }



    private void acaoDosBotoes() {
        buttonConfirmar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                
                Questao5.setValA(Float.valueOf(tfValA.getText()));                
                Questao5.setValB(Float.valueOf(tfValB.getText()));
                Questao5.setValC(Float.parseFloat(tfValC.getText()));

                textResultado.setText(String.valueOf(Questao5.media()));
                textValA.setText(tfValA.getText());
                textValB.setText(tfValB.getText());
                textValC.setText(tfValC.getText());

                hBoxOutput.setVisible(true);
            }
        });

        Tooltip texto = new Tooltip("Texto copiado");
        Tooltip mensagemSubliminar = new Tooltip("Boa escolha");
        mensagemSubliminar.setShowDelay(Duration.millis(100));
        mensagemSubliminar.setShowDuration(Duration.millis(300));
        Tooltip.install(copyRight, mensagemSubliminar);

        textResultado.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(textResultado.getText());
                clipboard.setContent(content);

                Tooltip.install(textResultado, texto);
                texto.setAutoHide(true);
                texto.fireEvent(arg0);
                texto.centerOnScreen();
                texto.show(telaQuestao5.getScene().getWindow());
            }
        });
        textResultado.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                texto.hide();
                Tooltip.uninstall(textResultado, texto);
            }
        });
    }
}