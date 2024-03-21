package br.edu.ufersa.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import br.edu.ufersa.App;
import br.edu.ufersa.questoes.Questao32;
import br.edu.ufersa.questoes.Questao8;

public class Questao32Controller extends BaseController{


    @FXML private BorderPane telaQuestao32;
    @FXML private Button buttonAbrirArquivo;
    @FXML private Button buttonEditar;
    @FXML private Button buttonInicial;
    @FXML private Button buttonPrincipal;
    @FXML private Button buttonCadastrar;
    @FXML private Button buttonSalvarArquivo;
    @FXML private Button buttonVisualizar;
    @FXML private ChoiceBox<Character> choiceBoxSexo;
    @FXML private HBox hBoxOutput;
    @FXML private Label copyRight;
    @FXML private Label labelAltura;
    @FXML private Label labelCPF;
    @FXML private Label labelIdade;
    @FXML private Label labelInfoPessoal;
    @FXML private Label labelInicial;
    @FXML private Label labelNome;
    @FXML private Label labelPeso;
    @FXML private Label labelSexo;
    @FXML private Pane paneView;
    @FXML private ScrollPane sPaneView;
    @FXML private Text textView;
    @FXML private TextField tfAltura;
    @FXML private TextField tfCPF;
    @FXML private TextField tfIdade;
    @FXML private TextField tfInicial;
    @FXML private TextField tfNome;
    @FXML private TextField tfPeso;
    @FXML private VBox vBoxButtons;
    @FXML private VBox vBoxInicial;
    @FXML private VBox vBoxPrincipal;

    private int cont;
    private int pos = 0;
    private int tamanho;
    private Questao32[] listaPessoas;
    private boolean cad = false;
    private boolean edit = false;

    
    private String caminhoSalvo;
    private final String tipoArquivo = ".bin";
    private String nomeArquivo = "pessoa";
    private File arquivoSelecionado;
    private FileChooser selecionador = new FileChooser();
    
    private char masc = 'M';
    private char femn = 'F';
    private ObservableList<Character> opcoesSexos = FXCollections.observableArrayList(masc, femn);
    

    public void initialize() {
        BaseController.numQuestao = 32;
        super.initialize();
        acaoDosBotoes();
        setStilo(new Button[] { buttonAbrirArquivo, buttonCadastrar, buttonEditar, buttonInicial, 
                                buttonPrincipal, buttonSalvarArquivo, buttonVisualizar},
                 new Label[]  { labelAltura, labelCPF, labelIdade, labelInfoPessoal, 
                                labelInicial, labelNome, labelPeso, labelSexo},
                 new Pane[]   { paneView, telaQuestao32}, null,
                 new Text[]   { textView});
        estadoInicial();

        cont = 0;
    }



    private void estadoInicial(){
        buttonEditar.setDisable(true);
        buttonVisualizar.setDisable(true);
        buttonSalvarArquivo.setDisable(true);

        hBoxOutput.getChildren().removeAll(vBoxInicial, vBoxPrincipal, sPaneView);

        choiceBoxSexo.setItems(opcoesSexos);
        choiceBoxSexo.setValue(opcoesSexos.get(0));
    }




    private void acaoDosBotoes() {
        buttonCadastrar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                removerElementos();
                iniciarCadastro();
            }
        });
        buttonEditar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                removerElementos();
                iniciarEdicao();
            }
        });
        buttonVisualizar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                removerElementos();
                visualizarPessoas();
            }
        });
        buttonAbrirArquivo.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                removerElementos();
                realizarAbertura();
            }
        });
        buttonSalvarArquivo.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent arg0) {
                removerElementos();
                realizarSalvamento();
            }
        });


        buttonInicial.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                if(cad) realizarCadastro();
                if(edit) realizarEdicao();
            }
        });
        buttonPrincipal.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                removerElementos();
                if(cad) cadastarPessoas();
                else editarPessoas();
            }
        });
        

        tfCPF.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent arg0) {
                autoCompleteCPF();
            }
        });
        tfInicial.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent arg0) {
                if (edit) autoCompleteCPF();
            }
        });

    }





    private void removerElementos() {
        if(hBoxOutput.getChildren().contains(vBoxInicial)) hBoxOutput.getChildren().remove(vBoxInicial);
        if(hBoxOutput.getChildren().contains(sPaneView)) hBoxOutput.getChildren().remove(sPaneView);
    }



    private void realizarAbertura() {
        if(abrirArquivo()){
            showPopup("O arquivo foi aberto com sucesso. ", true);

            textView.setText("Clique no botão \"Visualizar\" para poder acessa-lo.");
            buttonCadastrar.setDisable(true);
            buttonEditar.setDisable(false);
            buttonVisualizar.setDisable(false);
            buttonSalvarArquivo.setDisable(false);
            hBoxOutput.getChildren().addAll(sPaneView);
        } else showPopup("Ops... Ocorreu um erro ao abrir o arquivo desejado.", false);
    }

    private void realizarSalvamento() {
        if(salvarArquivo()){
            textView.setText("O arquivo foi salvo com sucesso! \nSalvo em: " + caminhoSalvo);
            hBoxOutput.getChildren().addAll(sPaneView);
        } else showPopup("Ops... Ocorreu um erro ao salvar o arquivo, por favor, tente novamente", false);
    }



    
    private boolean abrirArquivo() {
        selecionador.getExtensionFilters().addAll(new ExtensionFilter("Binary files", "*"+tipoArquivo));
        selecionador.setTitle("Selecione o aquivo binário que deseja abrir");
        selecionador.setInitialDirectory(new File(App.raizProjeto));

        Stage janela = (Stage) buttonAbrirArquivo.getScene().getWindow();
        arquivoSelecionado = selecionador.showOpenDialog(janela);

        if(arquivoSelecionado != null){
            try {
                FileInputStream fileInput = new FileInputStream(arquivoSelecionado);
                ObjectInputStream objectInput = new ObjectInputStream(fileInput);
                listaPessoas = (Questao32[]) objectInput.readObject();

                objectInput.close();
                fileInput.close();

                return true;
                
            } catch (IOException e) {
                showPopup("Infelizmente não foi possível ler o arquivo...", false);
                e.printStackTrace();
                return false;
            } catch (ClassNotFoundException e) {
                showPopup("A classe selecionada para a leitura não existe.", false);
                e.printStackTrace();
                return false;
            } 
        } 
        else return false;
    }
    private boolean salvarArquivo() {
        try {
            
            Stage janela = (Stage) buttonSalvarArquivo.getScene().getWindow();
            selecionador.getExtensionFilters().addAll(new ExtensionFilter("Binary files", "*"+tipoArquivo));
            selecionador.setInitialFileName(nomeArquivo);
            selecionador.setInitialDirectory(new File(App.raizProjeto));
            File arquivoSalvo = selecionador.showSaveDialog(janela);
            if (arquivoSalvo == null)
                return false;
            
            nomeArquivo = arquivoSalvo.getName();
            caminhoSalvo = arquivoSalvo.getPath();
            caminhoSalvo = caminhoSalvo.replace(nomeArquivo, "");

            FileOutputStream fileOutput = new FileOutputStream(arquivoSalvo);
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
            objectOutput.writeObject(listaPessoas);

            objectOutput.close();
            fileOutput.close();

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

    



    private void iniciarCadastro(){
        tfInicial.clear();

        if (hBoxOutput.getChildren().contains(vBoxPrincipal)) hBoxOutput.getChildren().remove(vBoxPrincipal);
        if (hBoxOutput.getChildren().contains(vBoxInicial)) hBoxOutput.getChildren().remove(vBoxInicial);

        cad = true;

        hBoxOutput.getChildren().addAll(vBoxInicial);
    }
    private void realizarCadastro(){
        if(validarQuantidade()){
            hBoxOutput.getChildren().remove(vBoxInicial);

            tamanho = Integer.parseInt(tfInicial.getText());
            
            labelInfoPessoal.setText("Informação da " + (cont+1) + "ª pessoa");
            buttonPrincipal.setText("Próximo");
            if(tamanho == 1) buttonPrincipal.setText("Concluir");
            hBoxOutput.getChildren().addAll(vBoxPrincipal);
            
            listaPessoas = new Questao32[tamanho];
        }
    }


    private void iniciarEdicao(){
        if (hBoxOutput.getChildren().contains(sPaneView)) hBoxOutput.getChildren().remove(sPaneView);
        if (hBoxOutput.getChildren().contains(vBoxInicial)) hBoxOutput.getChildren().remove(vBoxInicial);
        if (hBoxOutput.getChildren().contains(vBoxPrincipal)) hBoxOutput.getChildren().remove(vBoxPrincipal);
        

        edit = true;

        labelInicial.setText("Digite o CPF da pessoa que deseja editar");

        tfInicial.clear();
        hBoxOutput.getChildren().addAll(vBoxInicial);
    }
    private void realizarEdicao(){
        hBoxOutput.getChildren().removeAll(vBoxInicial);
        String cpf = tfInicial.getText();
        tfInicial.clear();
        cont = 0;

        for (Questao32 questao32 : listaPessoas) {
            if (questao32.getCpf().equals(cpf)) {
                pos = cont;
                cont--;
            }
            cont++;
        }

        if (cont == listaPessoas.length) {
            textView.setText("O CPF não pertence a nenhum usuário cadastrado");
            hBoxOutput.getChildren().addAll(sPaneView);   
        } else {
            tfNome.setText(listaPessoas[pos].getNome());
            tfCPF.setText(listaPessoas[pos].getCpf());
            tfIdade.setText(String.valueOf(listaPessoas[pos].getIdade()));
            tfAltura.setText(String.valueOf(listaPessoas[pos].getAltura()));
            tfPeso.setText(String.valueOf(listaPessoas[pos].getPeso()));
            choiceBoxSexo.setValue(listaPessoas[pos].getSexo());

            labelInfoPessoal.setText("Edite o dado desejado");
            hBoxOutput.getChildren().addAll(vBoxPrincipal);
        }

        edit = false;
    }





    private void visualizarPessoas(){
        if (hBoxOutput.getChildren().contains(vBoxInicial)) hBoxOutput.getChildren().remove(vBoxInicial);
        if (hBoxOutput.getChildren().contains(vBoxPrincipal)) hBoxOutput.getChildren().remove(vBoxPrincipal);
        if (hBoxOutput.getChildren().contains(sPaneView)) hBoxOutput.getChildren().remove(sPaneView);

        textView.setText("");
        int contTemp = 1;
        for (Questao32 questao32 : listaPessoas) {
            textView.setText(textView.getText() + "Dados da " + contTemp + "ª pessoa \n\n");
            textView.setText(textView.getText() + questao32.exibirInfoPessoa() + "\n\n");
            contTemp++;
        }

        hBoxOutput.getChildren().addAll(sPaneView);
    }


    private void cadastarPessoas(){
        if(validarCampos()){
            if (cont < tamanho) {
                String nome = tfNome.getText();
                String cpf = tfCPF.getText();
                char sexo = choiceBoxSexo.getSelectionModel().getSelectedItem();
                int idade = Integer.parseInt(tfIdade.getText());
                double altura = Double.parseDouble(tfAltura.getText());
                double peso = Double.parseDouble(tfPeso.getText());

                listaPessoas[cont] = new Questao32(cpf, nome, sexo, idade, peso, altura);
                cont++;

                labelInfoPessoal.setText("Informação da " + (cont+1) + "ª pessoa");
                tfAltura.clear();
                tfCPF.clear();
                tfIdade.clear();
                tfNome.clear();
                tfPeso.clear();
                choiceBoxSexo.setValue(opcoesSexos.get(0));
            } 

            if (cont+1 == tamanho) {
              buttonPrincipal.setText("Concluir");  
            }

            if (cont == tamanho) {
                hBoxOutput.getChildren().remove(vBoxPrincipal);

                textView.setText("As pessoas foram cadastradas com sucesso!");
                hBoxOutput.getChildren().add(sPaneView);

                buttonCadastrar.setDisable(true);
                buttonEditar.setDisable(false);
                buttonVisualizar.setDisable(false);
                buttonSalvarArquivo.setDisable(false);
                
                cad = false;
            }
        }
    }
    private void editarPessoas(){
        if(validarCampos()){
        
            String nome = tfNome.getText();
            String cpf = tfCPF.getText();
            char sexo = choiceBoxSexo.getSelectionModel().getSelectedItem();
            int idade = Integer.parseInt(tfIdade.getText());
            double altura = Double.parseDouble(tfAltura.getText());
            double peso = Double.parseDouble(tfPeso.getText());

            listaPessoas[pos].setNome(nome);
            listaPessoas[pos].setCpf(cpf);
            listaPessoas[pos].setSexo(sexo);
            listaPessoas[pos].setIdade(idade);
            listaPessoas[pos].setAltura(altura);
            listaPessoas[pos].setPeso(peso);


            Questao8 imc = new Questao8(altura, peso);
            listaPessoas[pos].setImc(imc.getIMC());

            hBoxOutput.getChildren().remove(vBoxPrincipal);
            textView.setText("Dados da pessoa editado com sucesso!");
            hBoxOutput.getChildren().add(sPaneView);

            edit = false;
        }
    }





    private void autoCompleteCPF(){
        if(tfCPF.getText().length() == 3){
            tfCPF.setText(tfCPF.getText() + ".");
            tfCPF.end();
        };
        if(tfCPF.getText().length() == 7){
            tfCPF.setText(tfCPF.getText() + ".");
            tfCPF.end();
        };
        if(tfCPF.getText().length() == 11){
            tfCPF.setText(tfCPF.getText() + "-");
            tfCPF.end();
        };

        if (!cad) {
            if(tfInicial.getText().length() == 3){
                tfInicial.setText(tfInicial.getText() + ".");
                tfInicial.end();
            };
            if(tfInicial.getText().length() == 7){
                tfInicial.setText(tfInicial.getText() + ".");
                tfInicial.end();
            };
            if(tfInicial.getText().length() == 11){
                tfInicial.setText(tfInicial.getText() + "-");
                tfInicial.end();
            };
        }
    }





    private boolean validarQuantidade() {
        if (tfInicial.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        } else if (tfInicial.getText().matches("\\D")) {
            showPopup("O campo não pode conter letras", false);
            return false;
        } else if (tfInicial.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfInicial.getText());
            if (num < 1 ) {
                showPopup("A quantidade mínima de pessoas a cadastrar é 1", false);
                return false;
            }
        }
        return true;
    }
    private boolean validarCampos() {
        if (tfNome.getText().isEmpty()) {
            showPopup("O campo Nome não pode ser vazio, tente novamente", false);
            return false;
        } else if (tfNome.getText().matches("^[a-zA-Z\\s^áéíóúãâêõ]{1,60}$")) {} 
          else {
            showPopup("O campo Nome não pode conter números ou mesmo símbolos", false);
            return false;
        }

        if (tfCPF.getText().isEmpty()) {
            showPopup("O campo CPF não pode ser vazio, tente novamente", false);
            return false;

        } else if (tfCPF.getText().matches("^[0-9]{3}[.][0-9]{3}[.][0-9]{3}[-][0-9]{2}$")){} 
          else {
            showPopup("O conteúdo do campo CPF é inválido", false);
            return false;
        }

        if (tfIdade.getText().isEmpty()) {
            showPopup("O campo Idade não pode ser vazio, tente novamente", false);
            return false;
        } else if (tfIdade.getText().matches("\\D")) {
            showPopup("O campo Idade não pode conter letras", false);
            return false;
        } else if (tfIdade.getText().matches("[0-9]+")) {
            int num =  Integer.parseInt(tfIdade.getText());
            if (num <= 0 ) {
                showPopup("A idade não pode ser 0 ou mesmo negativa", false);
                return false;
            }
        }

        if (tfAltura.getText().isEmpty()) {
            showPopup("O campo Altura não pode ser vazio, tente novamente", false);
            return false;
        } else if (tfAltura.getText().matches("\\D")) {
            showPopup("O campo Altura não pode conter letras", false);
            return false;
        } else if (tfAltura.getText().matches("[0-9^.]+")) {
            double num =  Double.parseDouble(tfAltura.getText());
            if (num <= 0 ) {
                showPopup("A altura não pode ser nula ou negativa", false);
                return false;
            }
        }

        if (tfPeso.getText().isEmpty()) {
            showPopup("O campo Peso não pode ser vazio, tente novamente", false);
            return false;
        } else if (tfPeso.getText().matches("\\D")) {
            showPopup("O campo Peso não pode conter letras", false);
            return false;
        } else if (tfPeso.getText().matches("[0-9^.]+")) {
            double num =  Double.parseDouble(tfPeso.getText());
            if (num <= 0 ) {
                showPopup("O peso não pode ser nulo ou negativo", false);
                return false;
            }
        }
        return true;
    }    
}