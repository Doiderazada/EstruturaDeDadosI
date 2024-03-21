package br.edu.ufersa.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import br.edu.ufersa.questoes.Questao18;
import br.edu.ufersa.App;

public class Questao18Controller extends BaseController {


    @FXML private BorderPane telaQuestao18;
    @FXML private Button buttonConfirmar;
    @FXML private Button buttonSenha;
    @FXML private Label copyRight;
    @FXML private Label labelSenha;
    @FXML private PasswordField pfSenha;
    @FXML private TextField tfSenha;

    
    private boolean veSenha = false;
    private String senha = "";

    public void initialize() {
        BaseController.numQuestao = 18;
        super.initialize();
        acaoDosBotoes();
        setStilo(new Button[] { buttonConfirmar },
                new Label[] { labelSenha },
                new Pane[] { telaQuestao18 }, null, null);
        estadoInicial();
    }



    private void estadoInicial() {
        tfSenha.setVisible(veSenha);
        visualBotaoSenha();
    }



    private void acaoDosBotoes() {
        buttonConfirmar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (verificarInput()) {
                    String senha = pfSenha.getText();
                    System.out.println(senha);
                    if (Questao18.validarSenha(senha)) {
                        showPopup("Senha correta! \nFim do programa", true);
                        App.trocarDeTela("telaQuestoes");

                    } else
                        showPopup("Senha incorreta, tente novamente", false);
                }
            }
        });

        buttonSenha.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                trocarVisibilidade();
            }
        });


        Tooltip mensagemSubliminar = new Tooltip("senhaDeDoidera123");
        mensagemSubliminar.setShowDelay(Duration.millis(100));
        mensagemSubliminar.setShowDuration(Duration.millis(800));
        Tooltip.install(copyRight, mensagemSubliminar);
    }

    private void trocarVisibilidade() {
        veSenha = true ^ veSenha;
        visualBotaoSenha();
        mudarCampos();
    }

    private void visualBotaoSenha() {
        if (veSenha)
            buttonSenha.getStyleClass().setAll("btn-CloseSenha");
        else
            buttonSenha.getStyleClass().setAll("btn-OpenSenha");
    }

    private void mudarCampos() {
        if (veSenha) {
            senha = pfSenha.getText();
            pfSenha.setVisible(false);
            tfSenha.setText(senha);
            tfSenha.setVisible(true);
        } else {
            tfSenha.setVisible(false);
            tfSenha.clear();
            pfSenha.setVisible(true);
        }
    }

    private boolean verificarInput() {
        if (pfSenha.getText().isEmpty()) {
            showPopup("O campo não pode estar vazio, tente novamente", false);
            return false;
        }
        return true;
    }
}