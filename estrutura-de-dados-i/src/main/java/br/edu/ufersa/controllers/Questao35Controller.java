package br.edu.ufersa.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import br.edu.ufersa.App;
import br.edu.ufersa.questoes.Questao35;

public class Questao35Controller extends BaseController{

    
    @FXML private BorderPane telaQuestao35;
    @FXML private Button buttonAbrirCSV;
    @FXML private Button buttonConfirmar;
    @FXML private Button buttonNovaFrase;
    @FXML private Button buttonSalvarCSV;
    @FXML private Button buttonVisualizar;
    @FXML private HBox hBoxOutput;
    @FXML private Label copyRight;
    @FXML private Label labelFrase;
    @FXML private Pane paneView;
    @FXML private ScrollPane sPaneView;
    @FXML private Text textView;
    @FXML private TextField tfFrase;
    @FXML private VBox vBoxButtons;
    @FXML private VBox vBoxFrase;



    private String caminhoSalvo;
    private final String tipoArquivo = ".CSV";
    private String nomeArquivo = "frase";

    private FileChooser selecionador = new FileChooser();
    private ArrayList<String> linhasLidas = new ArrayList<>(1);
    
    private Questao35 fraseQ35;
    

    public void initialize() {
        BaseController.numQuestao = 35;
        super.initialize();
        acaoDosBotoes();
        setStilo(new Button[]{ buttonAbrirCSV, buttonConfirmar, buttonNovaFrase, buttonSalvarCSV, buttonVisualizar},
                 new Label[] { labelFrase}, 
                 new Pane[]  { paneView, telaQuestao35}, null,
                 new Text[]  { textView});
        estadoInicial();
    }



    private void estadoInicial(){
        buttonVisualizar.setDisable(true);
        buttonSalvarCSV.setDisable(true);
        hBoxOutput.getChildren().removeAll(vBoxFrase, sPaneView);
    }




    private void acaoDosBotoes() {
        buttonNovaFrase.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                removerElementos();

                hBoxOutput.getChildren().add(vBoxFrase);
                tfFrase.clear();
            }
        });
        buttonVisualizar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                visualizarFrase();
            }
        });
        buttonAbrirCSV.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                removerElementos();
                realizarAbertura();
            }
        });
        buttonSalvarCSV.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                removerElementos();
                realizarSalvamento();
            }
        });

        buttonConfirmar.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
                novaFrase();
                
                hBoxOutput.getChildren().remove(vBoxFrase);

                if (buttonVisualizar.isDisable()) buttonVisualizar.setDisable(false);
                if (buttonSalvarCSV.isDisable()) buttonSalvarCSV.setDisable(false);
			}
        });
    }




    

    private void removerElementos() {
        if (hBoxOutput.getChildren().contains(sPaneView)) hBoxOutput.getChildren().remove(sPaneView);
        if (hBoxOutput.getChildren().contains(vBoxFrase)) hBoxOutput.getChildren().remove(vBoxFrase);
    }






    private void novaFrase(){
        if (validarFrase()) {
            String frase = tfFrase.getText();
            
            fraseQ35 = new Questao35(frase, true);

            textView.setText("A frase foi cadastrada com sucesso.");
            hBoxOutput.getChildren().add(sPaneView);
        }
    }
    private boolean validarFrase() {
        if (tfFrase.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        } 
        return true;
    }


    private void visualizarFrase(){
        textView.setText("Informações sobre a frase \"" + fraseQ35.getFrase() + "\".\n\n" +
        fraseQ35.exibirConteudo());
        if(!hBoxOutput.getChildren().contains(sPaneView)) hBoxOutput.getChildren().addAll(sPaneView);
    }
    
    


    private void realizarAbertura() {
        if (abrirArquivoCSV()) {
            if (converterConteudoLido()) {
                showPopup("O arquivo foi aberto com sucesso!", true);

                textView.setText("Clique no botão \"Visualizar\" para acessar o arquivo aberto.");
                buttonVisualizar.setDisable(false);
                buttonSalvarCSV.setDisable(false);
                hBoxOutput.getChildren().addAll(sPaneView);
            } else showPopup("Ops... Ocorreu um erro ao ler o arquivo desejado. :(", false);
        }
    }

    private void realizarSalvamento() {
        if (salvarArquivoCSV()) {
            textView.setText("O arquivo foi salvo com sucesso! \nSalvo em: " + caminhoSalvo);
            hBoxOutput.getChildren().addAll(sPaneView);
        } else showPopup("Ops... O arquivo não foi salvo, tente novamente", false);
    }




    private boolean converterConteudoLido() {
        String fraseLida = linhasLidas.get(0);
        fraseLida = fraseLida.replace("\"", "");
        fraseQ35 = new Questao35(fraseLida, false);
        
        String[] conteudo = new String[2];
        String linha;
        boolean adicionado = false;

        for (int i = 1; i < linhasLidas.size(); i++) {
            linha = linhasLidas.get(i);
            if (linha.contains(" ")) linha = linha.replace(" ", "");

            conteudo = linha.split(",");
            if (fraseQ35.getPalavras().add(conteudo[0]))
                if (fraseQ35.getQuantidade().add(Integer.parseInt(conteudo[1]))) 
                    adicionado = true;
                else {
                    adicionado = false;
                    break;
                }
            else {
                adicionado = false;
                break;
            }
        }
        return adicionado;
    }
    



    private boolean abrirArquivoCSV() {
        selecionador.getExtensionFilters().addAll(new ExtensionFilter("Comma-separated values", "*"+tipoArquivo));
        selecionador.setTitle("Selecione o aquivo CSV que deseja abrir");
        selecionador.setInitialDirectory(new File(App.raizProjeto));

        Stage janela = (Stage) buttonAbrirCSV.getScene().getWindow();

        File arquivoSelecionado = selecionador.showOpenDialog(janela);

        if(arquivoSelecionado != null){
            try {
                String linha = "";
                BufferedReader leitorCSV = new BufferedReader(new FileReader(arquivoSelecionado));
                while ((linha = leitorCSV.readLine()) != null) {
                    linhasLidas.add(linha);
                }

                leitorCSV.close();

                return true;
                
            } catch (IOException e) {
                showPopup("Infelizmente não foi possível ler o arquivo...", false);
                e.printStackTrace();
                return false;
            } 
        } 
        else return false;
    }
    private boolean salvarArquivoCSV() {
        try {
            
            Stage janela = (Stage) buttonSalvarCSV.getScene().getWindow();
            selecionador.setInitialFileName(nomeArquivo);
            selecionador.setInitialDirectory(new File(App.raizProjeto));
            selecionador.getExtensionFilters().addAll(new ExtensionFilter("Comma-separated values", "*"+tipoArquivo));
            File arquivoSalvo = selecionador.showSaveDialog(janela);
            if (arquivoSalvo == null) 
                return false;

            nomeArquivo = arquivoSalvo.getName();
            caminhoSalvo = arquivoSalvo.getPath();
            caminhoSalvo = caminhoSalvo.replace(nomeArquivo, "");

            PrintWriter escritorCSV = new PrintWriter(arquivoSalvo);
            
            escritorCSV.println("\"" + fraseQ35.getFrase() + "\"");
            
            for (int i = 0; i < fraseQ35.getPalavras().size(); i++) {
                escritorCSV.printf("%s, %d\n", fraseQ35.getPalavras().get(i), fraseQ35.getQuantidade().get(i));
            }
            escritorCSV.close();

            return true;
        } catch (FileNotFoundException e) {
            showPopup("Não foi possível criar o arquivo desejado...", false);
            e.printStackTrace();
            return false;
        } 
    }
}