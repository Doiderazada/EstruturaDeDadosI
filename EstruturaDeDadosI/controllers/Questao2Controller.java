package controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import questoes.Questao2;

public class Questao2Controller extends BaseController{
    
    @FXML private BorderPane telaQuestao2;
    @FXML private Button buttonConfirmar;
    @FXML private Label copyRight;
    @FXML private Label labelNome;
    @FXML private Label labelIdade;
    @FXML private Label labelAltura;
    @FXML private HBox outputHBox;
    @FXML private Text textNome;
    @FXML private Text textInicial;
    @FXML private Text textIdade;
    @FXML private Text textAltura;
    @FXML private Text textRespostaNome;
    @FXML private Text textRespostaInicial;
    @FXML private Text textRespostaIdade;
    @FXML private Text textRespostaAltura;
    @FXML private TextField tfAltura;
    @FXML private TextField tfIdade;
    @FXML private TextField tfNome;
    @FXML private VBox inputVBox;


    public void initialize() {
        BaseController.numQuestao = 2;
        super.initialize();
        setStilo(new Button[] { buttonConfirmar}, 
                 new Label[]  { labelAltura, labelIdade, labelNome}, 
                 new Pane[]   { telaQuestao2}, null, 
                 new Text[]   { textAltura,  textIdade, textInicial, textNome, textRespostaAltura, 
                                textRespostaIdade, textRespostaInicial, textRespostaNome});
        acaoDosBotoes();
        outputHBox.setVisible(false);
        inputVBox.setVisible(true);
    }





    private void acaoDosBotoes() {
        buttonConfirmar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                String nome = tfNome.getText();
                char inicial = tfNome.getText().charAt(0);
                int idade = Integer.parseInt(tfIdade.getText());
                float altura = Float.parseFloat(tfAltura.getText());
                Questao2 usuario = new Questao2();
                usuario.setNome(nome);
                usuario.setInicial(inicial);
                usuario.setIdade(idade);
                usuario.setAltura(altura);

                textRespostaNome.setText(usuario.getNome());
                textRespostaInicial.setText(String.valueOf(usuario.getInicial()));
                textRespostaIdade.setText(String.valueOf(usuario.getIdade()) + " anos");
                textRespostaAltura.setText(String.valueOf(usuario.getAltura()) + "m");

                inputVBox.setVisible(false);
                outputHBox.setVisible(true);
            }
        });
    }
}