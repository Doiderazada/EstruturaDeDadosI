package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import questoes.Questao40;

public class Questao40Controller extends BaseController{


    @FXML private BorderPane telaQuestao40;
    @FXML private Button buttonAbrirTexto;
    @FXML private Button buttonConfirmarSave;
    @FXML private Button buttonConfirmarTexto;
    @FXML private Button buttonEditarTexto;
    @FXML private Button buttonNovoTexto;
    @FXML private Button buttonSalvarTexto;
    @FXML private Button buttonVisualizar;
    @FXML private HBox hBoxElements;
    @FXML private Label copyRight;
    @FXML private Label labelMensagem;
    @FXML private Label labelNomeArquivo;
    @FXML private Pane paneView;
    @FXML private ScrollPane sPaneView;
    @FXML private Text textView;
    @FXML private TextArea taMensagem;
    @FXML private TextField tfNomeArquivo;
    @FXML private VBox vBoxButtons;
    @FXML private VBox vBoxSave;
    @FXML private VBox vBoxTexto;



    
    private final String diretorioProjeto = System.getProperty("user.dir");
    private final String pasta = "/EstruturaDeDadosI/arquivos/";
    private final String tipoArquivo = ".txt";
    private String caminhoSalvo = diretorioProjeto + pasta;
    private String nomeArquivo = "mensagem";
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
        setStilo(new Button[]{ buttonAbrirTexto, buttonConfirmarSave, buttonConfirmarTexto, 
                               buttonEditarTexto, buttonNovoTexto, buttonSalvarTexto, buttonVisualizar},
                 new Label[] { labelMensagem, labelNomeArquivo},
                 new Pane[]  { telaQuestao40, paneView},
                 null,
                 new Text[]  { textView});
        this.estadoInicial();
    }



    private void estadoInicial(){
        coderDecoder = new Questao40();
        hBoxElements.getChildren().removeAll(vBoxSave, vBoxTexto, sPaneView);
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
                if(abrirArquivo()) {
                    showPopup("O arquivo foi aberto com sucesso!", true);
                    
                    buttonEditarTexto.setDisable(false);
                    buttonVisualizar.setDisable(false);
                    buttonSalvarTexto.setDisable(false);

                    textView.setText("Clieque em \"Visualizar\" para acessar o arquivo aberto");
                    hBoxElements.getChildren().add(sPaneView);
                }
            }
        });
        buttonSalvarTexto.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                removerElementos();
                hBoxElements.getChildren().addAll(vBoxSave);
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
        buttonConfirmarSave.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (validarNome()) {
                    nomeArquivo = tfNomeArquivo.getText();
                    if(salvarArquivo()){
                        removerElementos();

                        textView.setText("O arquivo foi salvo com sucesso! \nSalvo no diretório: " + caminhoSalvo);
                        hBoxElements.getChildren().add(sPaneView);
                        if(buttonVisualizar.isDisable()) buttonVisualizar.setDisable(false);
                        if(buttonEditarTexto.isDisable()) buttonEditarTexto.setDisable(false);
                        if(buttonSalvarTexto.isDisable()) buttonSalvarTexto.setDisable(false);
                    } else showPopup("Ops... Ocorreu um erro ao tentar salvar o arquivo", false);
                }
            }
        });
        
    }




    private boolean validarNome() {
        if (tfNomeArquivo.getText().isBlank()) {
            showPopup("O nome do arquivo não pode estar em branco", false);
            return false;
        }
        return true;
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
        if (hBoxElements.getChildren().contains(vBoxSave)) hBoxElements.getChildren().remove(vBoxSave);
        if (hBoxElements.getChildren().contains(sPaneView)) hBoxElements.getChildren().remove(sPaneView);
    }





    private boolean abrirArquivo() {
        selecionador.getExtensionFilters().addAll(new ExtensionFilter("Text files", "*.txt"));
        selecionador.setTitle("Selecione o aquivo binário que deseja abrir");
        selecionador.setInitialDirectory(new File(diretorioProjeto + pasta));

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
            BufferedWriter escritor = new BufferedWriter(new FileWriter(diretorioProjeto + pasta + nomeArquivo + tipoArquivo));
            
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