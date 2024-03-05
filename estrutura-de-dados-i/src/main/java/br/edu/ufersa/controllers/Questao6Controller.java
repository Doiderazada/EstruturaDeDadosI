package br.edu.ufersa.controllers;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.Desktop;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import br.edu.ufersa.questoes.Questao6;

public class Questao6Controller extends BaseController{

    @FXML private BorderPane telaQuestao6;
    @FXML private Button buttonConfirmar;
    @FXML private HBox outputHBox;
    @FXML private Label copyRight;
    @FXML private Label labelPessoa;
    @FXML private Label labelPizza;
    @FXML private Label labelRefri;
    @FXML private Text textResultPessoa;
    @FXML private Text textResultPizza;
    @FXML private Text textResultRefri;
    @FXML private Text textResultSubT;
    @FXML private Text textResultTot;
    @FXML private Text textSubTotal;
    @FXML private Text textTotal;
    @FXML private Text textValPessoa;
    @FXML private Text textValRefri;
    @FXML private Text textValPizza;
    @FXML private TextField tfPessoa;
    @FXML private TextField tfPizza;
    @FXML private TextField tfRefri;
    @FXML private VBox inputVBox;


    public void initialize() {
        BaseController.numQuestao = 6;
        super.initialize();
        setStilo(new Button[] { buttonConfirmar}, 
                 new Label[]  { labelPessoa, labelPizza, labelRefri}, 
                 new Pane[]   { telaQuestao6}, null, 
                 new Text[]   { textResultPessoa,  textResultPizza, textResultRefri, textResultSubT, textResultTot,
                                textSubTotal, textSubTotal, textTotal, textValPessoa, textValPizza, textValRefri});
        acaoDosBotoes();
        outputHBox.setVisible(false);
    }





    private void acaoDosBotoes() {
        buttonConfirmar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                Questao6.setQuantPessoa(Integer.valueOf(tfPessoa.getText()));
                Questao6.setQuantPizza(Integer.valueOf(tfPizza.getText()));
                Questao6.setQuantRefri(Integer.valueOf(tfRefri.getText()));
                Questao6.calcularTotal();

                textResultPessoa.setText(String.valueOf(Questao6.getValPessoa()) + " R$");
                textResultPizza.setText(String.valueOf(Questao6.getValPizza()) + " R$");
                textResultRefri.setText(String.valueOf(Questao6.getValRefri()) + " R$");
                textResultSubT.setText(String.valueOf(Questao6.getSubTotal()) + " R$");
                textResultTot.setText(String.valueOf(Questao6.getTotal()) + " R$");
            
                outputHBox.setVisible(true);
            }
        });

        Tooltip dica = new Tooltip("Clique para ver um projeto bacana de pizzaria");
        dica.setShowDelay(Duration.millis(200));
        Tooltip.install(copyRight, dica);
        copyRight.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                try{
                    String url = "https://github.com/CaioAndersonMM/Pizzaria-POO";
                    Desktop desktop = Desktop.getDesktop();
                    if (Desktop.isDesktopSupported()) {
                        desktop.browse(new URI(url));
                    }
                } catch(IOException | URISyntaxException e) {
                    System.out.println("Não foi possível abrir o endereço especificado: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }
}