package br.edu.ufersa.controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import br.edu.ufersa.App;
import br.edu.ufersa.questoes.Questao40;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Questao40Controller extends BaseController{


    @FXML private BorderPane telaQuestao40;
    @FXML private Button buttonAbrirTexto;
    @FXML private Button buttonConfirmarTexto;
    @FXML private Button buttonEditarTexto;
    @FXML private Button buttonNovoTexto;
    @FXML private Button buttonSalvarTexto;
    @FXML private Button buttonVisualizar;
    @FXML private HBox hBoxElements;
    @FXML private Label copyRight;
    @FXML private Label labelMensagem;
    @FXML private Pane paneView;
    @FXML private ScrollPane sPaneView;
    @FXML private Text textView;
    @FXML private TextArea taMensagem;
    @FXML private VBox vBoxButtons;
    @FXML private VBox vBoxTexto;



    
    private final String tipoArquivo = ".txt";
    private String nomeArquivo = "mensagem";
    private String caminhoSalvo;
    private File arquivoSelecionado;
    private FileChooser selecionador = new FileChooser();


    private boolean textoAberto = false;
    private String fraseLida = "";
    private String mensagemCodificada;
    private String mensagemDecoficicada;
    private String mensagem;
    private Questao40 coderDecoder;
    

    public void initialize() {
        BaseController.numQuestao = 40;
        super.initialize();
        this.acaoDosBotoes();
        setStilo(new Button[]{ buttonAbrirTexto, buttonConfirmarTexto, 
                               buttonEditarTexto, buttonNovoTexto, buttonSalvarTexto, buttonVisualizar},
                 new Label[] { labelMensagem},
                 new Pane[]  { telaQuestao40, paneView},
                 null,
                 new Text[]  { textView});
        this.estadoInicial();
    }



    private void estadoInicial(){
        coderDecoder = new Questao40();
        hBoxElements.getChildren().removeAll( vBoxTexto, sPaneView);
        buttonEditarTexto.setDisable(true);
        buttonVisualizar.setDisable(true);
        buttonSalvarTexto.setDisable(true);
    }




    private void acaoDosBotoes() {

        buttonNovoTexto.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                removerElementos();
                taMensagem.clear();
                hBoxElements.getChildren().add(vBoxTexto);
            }
        });
        buttonEditarTexto.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                removerElementos();
                taMensagem.setText(mensagem);
                hBoxElements.getChildren().add(vBoxTexto);
            }
        });
        buttonVisualizar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                removerElementos();
                
                if (textoAberto) {
                    mensagemDecoficicada = coderDecoder.decodificar(mensagem);
                    mensagem = mensagemDecoficicada;
                    mensagemCodificada = coderDecoder.getFraseCodificada();
                    textView.setText("Mensagem original \n" + mensagemDecoficicada + "\n\n" +
                                     "Mensagem codificada \n" + mensagemCodificada);
                    textoAberto = false;
                }
                else {
                    textView.setText("Mensagem original \n" + mensagem + "\n\n" + 
                                     "Mensagem codificada \n" + mensagemCodificada);
                }
                hBoxElements.getChildren().add(sPaneView);
            }
        });
        buttonAbrirTexto.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                removerElementos();
                realizarAbertura();
            }
        });
        buttonSalvarTexto.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                removerElementos();
                realizarSalvamento();
            }
        });


        buttonConfirmarTexto.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                removerElementos();
                if(validarMensagem()) {
                    mensagem = taMensagem.getText();

                    mensagemCodificada = coderDecoder.codificar(mensagem);
                    textView.setText("mensagem codificada com sucesso!");
                    if(buttonVisualizar.isDisable()) buttonVisualizar.setDisable(false);
                    if(buttonEditarTexto.isDisable()) buttonEditarTexto.setDisable(false);
                    if(buttonSalvarTexto.isDisable()) buttonSalvarTexto.setDisable(false);
                    hBoxElements.getChildren().add(sPaneView);
                }
            }
        });
    }





    private void realizarAbertura() {
        if(abrirArquivo()) {
            showPopup("O arquivo foi aberto com sucesso!", true);
            
            buttonEditarTexto.setDisable(false);
            buttonVisualizar.setDisable(false);
            buttonSalvarTexto.setDisable(false);

            textView.setText("Clique em \"Visualizar\" para acessar o arquivo aberto");
            hBoxElements.getChildren().add(sPaneView);
        } else showPopup("Ops... Ocorreu um erro ao abrir o arquivo desejado", false);
    }



    private void realizarSalvamento() {
        if(salvarArquivo()){
            textView.setText("O arquivo foi salvo com sucesso! \nSalvo em: " + caminhoSalvo);
            hBoxElements.getChildren().add(sPaneView);
        } else showPopup("Ops... Ocorreu um erro ao tentar salvar o arquivo desejado", false);
    }



    private boolean validarMensagem() {
        if (taMensagem.getText().isBlank()) {
            showPopup("O campo não pode ficar vazio", false);
            return false;
        }
        return true;
    }



    private void removerElementos() {
        if (hBoxElements.getChildren().contains(vBoxTexto)) hBoxElements.getChildren().remove(vBoxTexto);
        if (hBoxElements.getChildren().contains(sPaneView)) hBoxElements.getChildren().remove(sPaneView);
    }






    private boolean abrirArquivo() {
        selecionador.getExtensionFilters().addAll(new ExtensionFilter("Text files", "*"+tipoArquivo));
        selecionador.setTitle("Selecione o aquivo binário que deseja abrir");
        selecionador.setInitialDirectory(new File(App.raizProjeto));

        Stage janela = (Stage) buttonAbrirTexto.getScene().getWindow();

        arquivoSelecionado = selecionador.showOpenDialog(janela);

        if(arquivoSelecionado != null){
            try {
                BufferedReader leitor = new BufferedReader(new FileReader(arquivoSelecionado));
                String linha = "";
                
                while ((linha = leitor.readLine()) != null) {
                    fraseLida += linha;
                }
                mensagem = fraseLida;
                textoAberto = true;

                leitor.close();
                return true;
                
            } catch (IOException e) {
                showPopup("Infelizmente não foi possível ler o arquivo...", false);
                e.printStackTrace();
                return false;
            }  
        } else return false;
    }
    private boolean salvarArquivo() {
        try {
            Stage janela = (Stage) buttonSalvarTexto.getScene().getWindow();
            selecionador.setInitialFileName(nomeArquivo);
            selecionador.setInitialDirectory(new File(App.raizProjeto));
            selecionador.getExtensionFilters().addAll(new ExtensionFilter("Text files", "*"+tipoArquivo));
            File arquivoSalvo = selecionador.showSaveDialog(janela);
            if (arquivoSalvo == null) 
                return false;

            nomeArquivo = arquivoSalvo.getName();
            caminhoSalvo = arquivoSalvo.getPath();
            caminhoSalvo = caminhoSalvo.replace("\\" + nomeArquivo, "");

            BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoSalvo));
            
            
            escritor.write(mensagemCodificada);
            escritor.close();

            return true;

        } catch (FileNotFoundException e) {
            showPopup("Não foi possível criar o arquivo desejado...", false);
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            showPopup("Infelizmente não foi possível escrever o arquivo...", false);
            e.printStackTrace();
            return false;
        }
    }
}