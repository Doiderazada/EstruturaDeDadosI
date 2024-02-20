package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Duration;
import questoes.EnunciadoDasQuestoes;
import questoes.Questao40;
import source.App;

public class Questao40Controller {


    @FXML private Button buttonAbrirTexto;
    @FXML private Button buttonConfirmarSave;
    @FXML private Button buttonConfirmarTexto;
    @FXML private Button buttonEditarTexto;
    @FXML private Button buttonHome;
    @FXML private Button buttonNovoTexto;
    @FXML private Button buttonSalvarTexto;
    @FXML private Button buttonVisualizar;
    @FXML private Button buttonVoltar;
    @FXML private Label copyRight;
    @FXML private HBox hBoxElements;
    @FXML private Label labelMensagem;
    @FXML private Label labelNomeArquivo;
    @FXML private Pane paneView;
    @FXML private Text questao;
    @FXML private ScrollPane sPaneView;
    @FXML private TextArea taMensagem;
    @FXML private BorderPane telaQuestao40;
    @FXML private Text textEnunciado;
    @FXML private Text textView;
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
    private String fraseLida;
    private String mensagemCodificada;
    private String mensagemDecoficicada;
    private String mensagem;
    private Questao40 coderDecoder;
    

    public void initialize() {
        acaoDosBotoes();
        setStilo();
        exibirConteudo();
        estadoInicial();

    }



    private void estadoInicial(){
        coderDecoder = new Questao40();
        hBoxElements.getChildren().removeAll(vBoxSave, vBoxTexto, sPaneView);
        buttonEditarTexto.setDisable(true);
        buttonVisualizar.setDisable(true);
        buttonSalvarTexto.setDisable(true);
    }




    private void acaoDosBotoes() {

        buttonVoltar.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("telaQuestoes");
            }
        });
        buttonHome.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("telaInicial");
            }
        });


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
                    mensagemCodificada = coderDecoder.getFraseCodificada();
                    textView.setText("Mensagem original: " + mensagemDecoficicada + "\n" +
                                     "Mensagem codificada: " + mensagemCodificada);
                    textoAberto = false;
                }
                else {
                    textView.setText("Mensagem original: " + mensagem + "\n" + 
                                     "Mensagem codificada: " + mensagemCodificada);
                }
                hBoxElements.getChildren().add(sPaneView);
            }
        });
        buttonAbrirTexto.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                removerElementos();
                if(abrirArquivo()) {
                    textView.setText("O arquivo foi aberto com sucesso, clique para visualiza-lo");
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
                    } else showPopup("Ops... Ocorreu um erro ao salvar o arquivo");
                }
            }
        });
        
    }




    protected boolean validarNome() {
        if (tfNomeArquivo.getText().isBlank()) {
            showPopup("O nome do arquivo não pode estar em branco");
            return false;
        }
        return true;
    }



    protected boolean validarMensagem() {
        if (taMensagem.getText().isBlank()) {
            showPopup("O campo não pode ficar vazio");
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
                
                String linha;
                
                while ((linha = leitor.readLine()) != null) {
                    fraseLida += linha;
                }
                mensagem = fraseLida;
                textoAberto = true;

                leitor.close();
                return true;
                
            } catch (IOException e) {
                showPopup("Infelizmente não foi possível ler o arquivo...");
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
            showPopup("Não foi possível criar o arquivo desejado...");
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            showPopup("Infelizmente não foi possível escrever o arquivo...");
            e.printStackTrace();
            return false;
        }
    }



   





    private void showPopup(String texto) {
        try{
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/telaPopupErro.fxml"));
            Parent root = loader.load();
            
            TelaPopupErroController controller = loader.getController();
            controller.initialize(texto);
            
            
            Popup popup = new Popup();

            popup.getContent().add(root);
            popup.setAutoHide(true);
            popup.setHideOnEscape(true);
            
            double winX = buttonHome.getScene().getWindow().getX();
            double winY = buttonHome.getScene().getWindow().getY();
            double halfX = buttonHome.getScene().getWindow().getWidth()/2;
            double halfY = buttonHome.getScene().getWindow().getHeight()/2;

            double newX = (winX + halfX) - (popup.getWidth()/2);
            double newY = (winY + halfY) - (popup.getHeight()/2);

            popup.setX(newX);
            popup.setY(newY);
            
            
            popup.show(buttonHome.getScene().getWindow());

            PauseTransition closeDelay = new PauseTransition(Duration.seconds(2.5));
            closeDelay.setOnFinished(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent arg0) {
                    popup.hide();
                }
            });
            closeDelay.play();

            
        }catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }





    private void exibirConteudo() { 
        questao.setText(questao.getText() + "\t");
        textEnunciado.setText(EnunciadoDasQuestoes.questao40.substring(3));
    }



    

    private void setStilo() {
        if (App.darkMode) {
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            buttonHome.getStyleClass().setAll("btn-questao-DM");
            buttonAbrirTexto.getStyleClass().setAll("btn-questao-DM");
            buttonConfirmarSave.getStyleClass().setAll("btn-questao-DM");
            buttonConfirmarTexto.getStyleClass().setAll("btn-questao-DM");
            buttonEditarTexto.getStyleClass().setAll("btn-questao-DM");
            buttonNovoTexto.getStyleClass().setAll("btn-questao-DM");
            buttonSalvarTexto.getStyleClass().setAll("btn-questao-DM");
            buttonVisualizar.getStyleClass().setAll("btn-questao-DM");
            telaQuestao40.setStyle("-fx-background-color: #282828");
            paneView.setStyle("-fx-background-color: #282828");


            labelMensagem.setTextFill(Color.WHITE);
            labelNomeArquivo.setTextFill(Color.WHITE);
            
            questao.setFill(Color.WHITE);
            textEnunciado.setFill(Color.WHITE);
            textView.setFill(Color.WHITE);
            
        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            buttonAbrirTexto.getStyleClass().setAll("btn-questao");
            buttonConfirmarSave.getStyleClass().setAll("btn-questao");
            buttonConfirmarTexto.getStyleClass().setAll("btn-questao");
            buttonEditarTexto.getStyleClass().setAll("btn-questao");
            buttonNovoTexto.getStyleClass().setAll("btn-questao");
            buttonSalvarTexto.getStyleClass().setAll("btn-questao");
            buttonVisualizar.getStyleClass().setAll("btn-questao");
            telaQuestao40.setStyle(null);
            paneView.setStyle(null);

            
            labelMensagem.setTextFill(Color.BLACK);
            labelNomeArquivo.setTextFill(Color.BLACK);
            
            questao.setFill(Color.BLACK);
            textEnunciado.setFill(Color.BLACK);
            textView.setFill(Color.BLACK);
        }
    }
}