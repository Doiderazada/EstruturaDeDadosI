package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import questoes.Questao31;
import questoes.Questao8;
import source.App;

public class Questao31Controller extends BaseController{


    @FXML private BorderPane telaQuestao31;
    @FXML private Button buttonCadastrar;
    @FXML private Button buttonPrincipal;
    @FXML private Button buttonEditar;
    @FXML private Button buttonInicial;
    @FXML private Button buttonVisualizar;
    @FXML private ChoiceBox<Character> choiceBoxSexo;
    @FXML private HBox hBoxOutput;
    @FXML private Label copyRight;
    @FXML private Label labelAltura;
    @FXML private Label labelCPF;
    @FXML private Label labelIdade;
    @FXML private Label labelInfoCad;
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
    @FXML private VBox vBoxPrincipal;
    @FXML private VBox vBoxInicial;

    private int cont;
    private int tamanho;
    private Questao31[] listaPessoas;
    private boolean cad = false;

    private char masc = 'M';
    private char femn = 'F';
    private ObservableList<Character> opcoesSexos = FXCollections.observableArrayList(masc, femn);
    

    public void initialize() {
        BaseController.numQuestao = 31;
        super.initialize();
        acaoDosBotoes();
        setStilo(new Button[] { buttonCadastrar, buttonEditar, buttonInicial, buttonPrincipal, buttonVisualizar},
                 new Label[]  { labelAltura, labelCPF, labelIdade, labelInfoCad, labelInicial, labelNome, labelPeso, labelSexo},
                 new Pane[]   { paneView, telaQuestao31}, null,
                 new Text[]   { textView});
        estadoInicial();

        cont = 0;
    }



    private void estadoInicial(){
        buttonEditar.setDisable(true);
        buttonVisualizar.setDisable(true);

        hBoxOutput.getChildren().removeAll(vBoxInicial, vBoxPrincipal, sPaneView);

        choiceBoxSexo.setItems(opcoesSexos);
        choiceBoxSexo.setValue(opcoesSexos.get(0));
    }




    private void acaoDosBotoes() {
        buttonCadastrar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                iniciarCadastro();
            }
        });
        buttonEditar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                iniciarEdicao();
            }
        });
        buttonVisualizar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                visualizarPessoas();
            }
        });


        buttonInicial.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                if(cad) realizarCadastro();
                else realizarEdicao();
            }
        });
        buttonPrincipal.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
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
                if (!cad) autoCompleteCPF();
            }
        });


        Tooltip dica = new Tooltip("Use a questão seguinte que é melhor, clique aqui para ir para ela");
        dica.setAutoHide(true);
        dica.setShowDelay(Duration.millis(100));
        dica.setShowDuration(Duration.seconds(3.2));
        Tooltip.install(copyRight, dica);

        copyRight.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao32");
            }
        });
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
            
            labelInfoCad.setText("Informação da " + (cont+1) + "ª pessoa");
            buttonPrincipal.setText("Próximo");
            if(tamanho == 1) buttonPrincipal.setText("Concluir");
            hBoxOutput.getChildren().addAll(vBoxPrincipal);
            
            listaPessoas = new Questao31[tamanho];
        }
    }


    private void iniciarEdicao(){
        if (hBoxOutput.getChildren().contains(sPaneView)) hBoxOutput.getChildren().remove(sPaneView);

        labelInicial.setText("Digite o CPF da pessoa que deseja editar");

        cad = false;

        tfInicial.clear();
        hBoxOutput.getChildren().addAll(vBoxInicial);
    }
    private void realizarEdicao(){
        hBoxOutput.getChildren().removeAll(vBoxInicial);
        String cpf = tfInicial.getText();
        cont = 0;

        for (int i = 0; i < listaPessoas.length; i++) {
            if(listaPessoas[i].getCpf().equals(cpf)) cont = i;
        }


        tfNome.setText(listaPessoas[cont].getNome());
        tfCPF.setText(listaPessoas[cont].getCpf());
        tfIdade.setText(String.valueOf(listaPessoas[cont].getIdade()));
        tfAltura.setText(String.valueOf(listaPessoas[cont].getAltura()));
        tfPeso.setText(String.valueOf(listaPessoas[cont].getPeso()));
        choiceBoxSexo.setValue(listaPessoas[cont].getSexo());

        labelInfoCad.setText("Edite o dado desejado");
        hBoxOutput.getChildren().addAll(vBoxPrincipal);
    }


    private void visualizarPessoas(){
        if (hBoxOutput.getChildren().contains(vBoxInicial)) hBoxOutput.getChildren().remove(vBoxInicial);
        if (hBoxOutput.getChildren().contains(vBoxPrincipal)) hBoxOutput.getChildren().remove(vBoxPrincipal);
        if (hBoxOutput.getChildren().contains(sPaneView)) hBoxOutput.getChildren().remove(sPaneView);

        textView.setText("");
        int contTemp = 1;
        for (Questao31 questao31 : listaPessoas) {
            textView.setText(textView.getText() + "Dados da " + contTemp + "ª pessoa \n\n");
            textView.setText(textView.getText() + questao31.exibirInfoPessoa() + "\n\n");
            contTemp++;
        }
        hBoxOutput.getChildren().addAll(sPaneView);
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




    
    private void cadastarPessoas(){
        if(validarCampos()){
            if (cont < tamanho) {
                String nome = tfNome.getText();
                String cpf = tfCPF.getText();
                char sexo = choiceBoxSexo.getSelectionModel().getSelectedItem();
                int idade = Integer.parseInt(tfIdade.getText());
                double altura = Double.parseDouble(tfAltura.getText());
                double peso = Double.parseDouble(tfPeso.getText());

                listaPessoas[cont] = new Questao31(cpf, nome, sexo, idade, peso, altura);
                cont++;

                labelInfoCad.setText("Informação da " + (cont+1) + "ª pessoa");
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

            listaPessoas[cont].setNome(nome);
            listaPessoas[cont].setCpf(cpf);
            listaPessoas[cont].setSexo(sexo);
            listaPessoas[cont].setIdade(idade);
            listaPessoas[cont].setAltura(altura);
            listaPessoas[cont].setPeso(peso);

            Questao8 imc = new Questao8(altura, peso);
            listaPessoas[cont].setImc(imc.getIMC());

            hBoxOutput.getChildren().remove(vBoxPrincipal);
            textView.setText("Dados da pessoa editado com sucesso!");
            hBoxOutput.getChildren().add(sPaneView);
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
                showPopup("A quantidade mínima de pessoa a cadastrar é 1", false);
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