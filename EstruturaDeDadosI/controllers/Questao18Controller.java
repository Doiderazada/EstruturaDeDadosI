package controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import questoes.Questao18;
import source.App;

public class Questao18Controller extends BaseController{

    
    @FXML private BorderPane telaQuestao18;
    @FXML private Button buttonConfirmar;
    @FXML private Label copyRight;
    @FXML private Label labelSenha;
    @FXML private TextField tfSenha;


    public void initialize() {
        BaseController.numQuestao = 18;
        super.initialize();
        acaoDosBotoes();
        setStilo(new Button[] { buttonConfirmar},
                 new Label[]  { labelSenha}, 
                 new Pane[]   { telaQuestao18}, null, null);
    }





    private void acaoDosBotoes() {
        buttonConfirmar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (verificarInput()) {
                    String senha = tfSenha.getText();
                    System.out.println(senha);
                    if (Questao18.validarSenha(senha)) {
                        showPopup("Senha correta! \nFim do programa", true);
                        App.trocarDeTela("telaQuestoes");
                        
                    } else showPopup("Senha incorreta, tente novamente", false);

                }
            }
        });


        Tooltip mensagemSubliminar = new Tooltip("senhaDeDoidera123");
        mensagemSubliminar.setShowDelay(Duration.millis(100));
        mensagemSubliminar.setShowDuration(Duration.millis(800));
        Tooltip.install(copyRight, mensagemSubliminar);
        
    }

    
    

    private boolean verificarInput() {
        if (tfSenha.getText().isEmpty()) {
            showPopup("O campo vazio, tente novamente", false);
            return false;
        }
        return true;
    }
}