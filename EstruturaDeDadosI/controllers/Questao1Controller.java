package controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import questoes.Questao1;

public class Questao1Controller extends BaseController{
    
    @FXML private BorderPane telaQuestao1;
    @FXML private Label copyRight;
    @FXML private Text textNome;
    @FXML private Text textInicial;
    @FXML private Text textIdade;
    @FXML private Text textAltura;
    @FXML private Text textRespostaNome;
    @FXML private Text textRespostaInicial;
    @FXML private Text textRespostaIdade;
    @FXML private Text textRespostaAltura;


    public void initialize() {
        BaseController.numQuestao = 1;
        super.initialize();
        setStilo(null, null, 
                 new Pane[] { telaQuestao1}, null, 
                 new Text[] { textAltura, textIdade, textInicial, textNome, 
                              textRespostaAltura, textRespostaIdade, textRespostaInicial, textRespostaNome});
        acaoDosBotoes();
        estadoInicial();
    }




    private void estadoInicial() {
        textRespostaNome.setText(Questao1.getNome());
        textRespostaInicial.setText(String.valueOf(Questao1.getInicial()));
        textRespostaIdade.setText(String.valueOf(Questao1.getIdade()) + " anos");
        textRespostaAltura.setText(String.valueOf(Questao1.getAltura()) + "m");
    }




    private void acaoDosBotoes() {
        Tooltip texto = new Tooltip("Texto copiado");
        Tooltip.install(textNome, texto);

        textNome.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                Clipboard clipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(textNome.getText());
                clipboard.setContent(content);

                texto.setAutoHide(true);
                texto.fireEvent(arg0);
                texto.centerOnScreen();

                texto.show(telaQuestao1.getScene().getWindow());
            }
        });
        textNome.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                texto.hide();
                Tooltip.uninstall(textNome, texto);
            }
        });   
    }
}