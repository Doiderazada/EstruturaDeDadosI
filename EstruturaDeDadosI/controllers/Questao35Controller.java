package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;
import questoes.EnunciadoDasQuestoes;
import questoes.Questao35;
import source.App;

public class Questao35Controller {

    
    @FXML private BorderPane telaQuestao35;
    @FXML private Button buttonAbrirCSV;
    @FXML private Button buttonConfirmar;
    @FXML private Button buttonHome;
    @FXML private Button buttonNovaFrase;
    @FXML private Button buttonSalvarCSV;
    @FXML private Button buttonVisualizar;
    @FXML private Button buttonVoltar;
    @FXML private HBox hBoxOutput;
    @FXML private Label copyRight;
    @FXML private Label labelFrase;
    @FXML private Pane paneView;
    @FXML private ScrollPane sPaneView;
    @FXML private Text questao;
    @FXML private Text textEnunciado;
    @FXML private Text textView;
    @FXML private TextField tfFrase;
    @FXML private VBox vBoxButtons;
    @FXML private VBox vBoxFrase;



    private final String diretorioProjeto = System.getProperty("user.dir");
    private final String pastaArquivo = "/EstruturaDeDadosI/arquivos/";
    private final String tipoArquivo = ".CSV";
    private String nomeArquivo = "frase";
    private String caminhoSalvo;
    private boolean novaFrase = false;

    private FileChooser selecionador = new FileChooser();
    private ArrayList<String> linhasLidas = new ArrayList<>(1);
    
    private Questao35 fraseQ35 = new Questao35(" ");
    

    public void initialize() {
        acaoDosBotoes();
        setStilo();
        exibirConteudo();
        estadoInicial();

    }



    private void estadoInicial(){
        buttonVisualizar.setDisable(true);
        buttonSalvarCSV.setDisable(true);
        hBoxOutput.getChildren().removeAll(vBoxFrase, sPaneView);
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


        buttonNovaFrase.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (hBoxOutput.getChildren().contains(sPaneView)) hBoxOutput.getChildren().remove(sPaneView);
                if (hBoxOutput.getChildren().contains(vBoxFrase)) hBoxOutput.getChildren().remove(vBoxFrase);

                novaFrase = true;
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
                realizarAbertura();
            }
        });
        buttonSalvarCSV.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                if (hBoxOutput.getChildren().contains(sPaneView)) hBoxOutput.getChildren().remove(sPaneView);
                if (hBoxOutput.getChildren().contains(vBoxFrase)) hBoxOutput.getChildren().remove(vBoxFrase);

                labelFrase.setText("Digite um nome para o arquivo, se assim desejar");
                tfFrase.clear();
                hBoxOutput.getChildren().addAll(vBoxFrase);
            }
            
        });

        buttonConfirmar.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent arg0) {
                if(novaFrase){
                    novaFrase();
                    
                    hBoxOutput.getChildren().remove(vBoxFrase);

                    if (buttonVisualizar.isDisable()) buttonVisualizar.setDisable(false);
                    if (buttonSalvarCSV.isDisable()) buttonSalvarCSV.setDisable(false);
                } else {
                    if (validarFrase()) {
                        nomeArquivo = tfFrase.getText();
                    }

                    realizarSalvamento();
                }
			}
        });

    }




    

    private void realizarSalvamento() {
        novaFrase = false;
        if (hBoxOutput.getChildren().contains(vBoxFrase)) hBoxOutput.getChildren().remove(vBoxFrase);
        if (hBoxOutput.getChildren().contains(sPaneView)) hBoxOutput.getChildren().remove(sPaneView);

        if (salvarArquivoCSV()) {
            textView.setText("O arquivo foi salvo com sucesso! \nSalvo sob o diretório: " + caminhoSalvo);
            hBoxOutput.getChildren().addAll(sPaneView);
        }
    }

    protected void realizarAbertura() {
        
        if (hBoxOutput.getChildren().contains(vBoxFrase)) hBoxOutput.getChildren().remove(vBoxFrase);
        if (hBoxOutput.getChildren().contains(sPaneView)) hBoxOutput.getChildren().remove(sPaneView);

        if (abrirArquivoCSV()) {
            if (converterConteudoLido()) {

                textView.setText("O arquivo foi aberto com sucesso. Clique no botão \"Visualizar\" para poder acessa-lo.");
                buttonVisualizar.setDisable(false);
                buttonSalvarCSV.setDisable(false);
                hBoxOutput.getChildren().addAll(sPaneView);
            } else showPopup("Ops... Ocorreu um erro abrindo o arquivo desejado. :(");
        }
    }




    private boolean converterConteudoLido() {

        String fraseLida = linhasLidas.get(0);
        fraseLida = fraseLida.replace("\"", "");
        fraseQ35.setFrase(fraseLida);
        fraseQ35.setPalavras();
        fraseQ35.setQuantidade();
        
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
        selecionador.getExtensionFilters().addAll(new ExtensionFilter("Comma-separated values", "*.CSV"));
        selecionador.setTitle("Selecione o aquivo CSV que deseja abrir");
        selecionador.setInitialDirectory(new File(diretorioProjeto + pastaArquivo));

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
                showPopup("Infelizmente não foi possível ler o arquivo...");
                e.printStackTrace();
                return false;
            } 
        } 
        else return false;
    }
    private boolean salvarArquivoCSV() {

        try {
            File arquivo = new File(diretorioProjeto + pastaArquivo + nomeArquivo + tipoArquivo);
            PrintWriter escritorCSV = new PrintWriter(arquivo);

            escritorCSV.println("\"" + fraseQ35.getFrase() + "\"");
            
            for (int i = 0; i < fraseQ35.getPalavras().size(); i++) {
                escritorCSV.printf("%s, %d\n", fraseQ35.getPalavras().get(i), fraseQ35.getQuantidade().get(i));
            }

            caminhoSalvo = diretorioProjeto + pastaArquivo;
            escritorCSV.close();

            return true;

        } catch (FileNotFoundException e) {
            showPopup("Não foi possível criar o arquivo desejado...");
            e.printStackTrace();
            return false;
        } 
    }



    private void novaFrase(){

        if (validarFrase()) {
            String frase = tfFrase.getText();
            
            fraseQ35.setFrase(frase);
            fraseQ35.setPalavras();
            fraseQ35.setQuantidade();

            fraseQ35.contarPalavras();

            textView.setText("A frase foi cadastrada com sucesso.");
            hBoxOutput.getChildren().add(sPaneView);

            novaFrase = false;
        }
    }

    private void visualizarFrase(){
        textView.setText("Informações sobre a frase \"" + fraseQ35.getFrase() + "\".\n\n" +
        fraseQ35.exibirConteudo());
    }


    
    
    private boolean validarFrase() {

        if (tfFrase.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente");
            return false;
        } 
        return true;
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
        textEnunciado.setText(EnunciadoDasQuestoes.questao35.substring(3));
    }



    

    private void setStilo() {
        if (App.darkMode) {
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            buttonHome.getStyleClass().setAll("btn-questao-DM");
            buttonConfirmar.getStyleClass().setAll("btn-questao-DM");
            buttonNovaFrase.getStyleClass().setAll("btn-questao-DM");
            buttonVisualizar.getStyleClass().setAll("btn-questao-DM");
            buttonAbrirCSV.getStyleClass().setAll("btn-questao-DM");
            buttonSalvarCSV.getStyleClass().setAll("btn-questao-DM");
            telaQuestao35.setStyle("-fx-background-color: #282828");
            paneView.setStyle("-fx-background-color: #282828");

            labelFrase.setTextFill(Paint.valueOf("WHITE"));
            
            questao.setFill(Paint.valueOf("WHITE"));
            textEnunciado.setFill(Paint.valueOf("WHITE"));
            textView.setFill(Paint.valueOf("WHITE"));
            
        } else {
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            buttonHome.getStyleClass().setAll("btn-questao");
            buttonConfirmar.getStyleClass().setAll("btn-questao");
            buttonNovaFrase.getStyleClass().setAll("btn-questao");
            buttonVisualizar.getStyleClass().setAll("btn-questao");
            buttonAbrirCSV.getStyleClass().setAll("btn-questao");
            buttonSalvarCSV.getStyleClass().setAll("btn-questao");
            telaQuestao35.setStyle(null);
            paneView.setStyle(null);

            labelFrase.setTextFill(Paint.valueOf("BLACK"));
            
            questao.setFill(Paint.valueOf("BLACK"));
            textEnunciado.setFill(Paint.valueOf("BLACK"));
            textView.setFill(Paint.valueOf("BLACK"));
        }
    }
}