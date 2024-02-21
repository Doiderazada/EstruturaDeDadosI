package controllers;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
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
import questoes.Questao31;
import questoes.Questao39;

public class Questao39Controller extends BaseController{


    @FXML private BorderPane telaQuestao39;
    @FXML private Button buttonConfirmDelete;
    @FXML private Button buttonConfirmPessoa;
    @FXML private Button buttonConfirmRead;
    @FXML private Button buttonConfirmUpdate;
    @FXML private Button buttonCDR;
    @FXML private Button buttonCreate;
    @FXML private Button buttonCriarObjeto;
    @FXML private Button buttonDelete;
    @FXML private Button buttonDeleteAll;
    @FXML private Button buttonInteger;
    @FXML private Button buttonPessoa;
    @FXML private Button buttonRead;
    @FXML private Button buttonReadAll;
    @FXML private Button buttonString;
    @FXML private Button buttonUpdate;
    @FXML private ChoiceBox<Character> choiceBoxSexo;
    @FXML private Label copyRight;
    @FXML private HBox hBoxElements;
    @FXML private Label labelAltura;
    @FXML private Label labelCPF;
    @FXML private Label labelCDR;
    @FXML private Label labelElemento;
    @FXML private Label labelIdade;
    @FXML private Label labelInfoPessoa;
    @FXML private Label labelNome;
    @FXML private Label labelObjeto;
    @FXML private Label labelPeso;
    @FXML private Label labelPosicao;
    @FXML private Label labelSexo;
    @FXML private Pane paneView;
    @FXML private ScrollPane sPaneView;
    @FXML private Text textView;
    @FXML private TextField tfAltura;
    @FXML private TextField tfCPF;
    @FXML private TextField tfCDR;
    @FXML private TextField tfElemento;
    @FXML private TextField tfIdade;
    @FXML private TextField tfNome;
    @FXML private TextField tfPeso;
    @FXML private TextField tfPosicao;
    @FXML private VBox vBoxButtons;
    @FXML private VBox vBoxCDR;
    @FXML private VBox vBoxDelete;
    @FXML private VBox vBoxObjeto;
    @FXML private VBox vBoxPessoa;
    @FXML private VBox vBoxRead;
    @FXML private VBox vBoxUpdate;


    private final char masc = 'M'; private final char femn = 'F';
    private ObservableList<Character> opcoesSexos = FXCollections.observableArrayList(masc, femn);

    private Questao39<Object> objeto;
    private String tipoObjeto;
    private boolean tipoPessoa = false;
    private boolean tipoInteger = false;
    private boolean create = false;
    private boolean delete = false;
    private boolean read = false;
    
    public void initialize() {
        BaseController.numQuestao = 39;
        super.initialize();
        setStilo(new Button[]{buttonCDR, buttonConfirmDelete, buttonConfirmPessoa, buttonConfirmRead, buttonConfirmUpdate, 
                              buttonCreate, buttonCriarObjeto, buttonDelete, buttonDeleteAll, buttonInteger, 
                              buttonPessoa, buttonRead, buttonReadAll, buttonString, buttonUpdate}, 
                new Label[]{  labelAltura, labelCDR, labelCPF, labelElemento,
                              labelIdade, labelInfoPessoa, labelNome, labelObjeto, 
                              labelPeso, labelPosicao, labelSexo},
                new Pane[]{   paneView, telaQuestao39}, null,
                new Text[]{   textView});
        acaoDosBotoes();
        estadoInicial();
    }


    private void estadoInicial(){
        hBoxElements.setPadding(new Insets(0, 0, 0, 200));
        hBoxElements.getChildren().removeAll(vBoxUpdate, vBoxPessoa, vBoxObjeto, vBoxRead, vBoxDelete, vBoxCDR, sPaneView);
        vBoxButtons.getChildren().removeAll(buttonCreate, buttonRead, buttonUpdate, buttonDelete);

        choiceBoxSexo.setItems(opcoesSexos);
        choiceBoxSexo.setValue(opcoesSexos.get(0));
    }


    private void acaoDosBotoes() {

        buttonCriarObjeto.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent arg0){
                hBoxElements.getChildren().addAll(vBoxObjeto);
            }
        });
        buttonCreate.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent arg0){
                removerElementos();
                create = true;
                delete = false;
                read = false;

                if (tipoPessoa) 
                    hBoxElements.getChildren().add(vBoxPessoa);
                else {
                    labelCDR.setText("Novo elemento");
                    tfCDR.clear();
                    hBoxElements.getChildren().add(vBoxCDR);
                }
            }
        });
        buttonRead.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                removerElementos();
                hBoxElements.getChildren().add(vBoxRead);
            }
        });
        buttonUpdate.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                removerElementos();
                hBoxElements.getChildren().add(vBoxUpdate);
            }
        });
        buttonDelete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                removerElementos();
                hBoxElements.getChildren().add(vBoxDelete);
            }
        });


        buttonPessoa.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                objeto = new Questao39<>();
                tipoObjeto = "Pessoa";
                tipoPessoa = true;
                tipoInteger = false;
                objetoCriado();
            }
        });
        buttonString.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                objeto = new Questao39<>();
                tipoObjeto = "Pessoa";
                tipoPessoa = false;
                tipoInteger = false;
                objetoCriado();
            }
        });
        buttonInteger.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                objeto = new Questao39<>();
                tipoObjeto = "Integer";
                tipoPessoa = false;
                tipoInteger = true;
                objetoCriado();
            }
        });
        
        
        buttonConfirmRead.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                removerElementos();
                create = false;
                delete = false;
                read = true;
                labelCDR.setText("Posição do elemento");
                tfCDR.clear();
                hBoxElements.getChildren().add(vBoxCDR);
            }
        });
        buttonReadAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                removerElementos();
                List<?> lista = objeto.readAll();
                String textoString = "";
                for (int i = 0; i < lista.size(); i++) {
                    textoString += tipoObjeto + " " + (i+1) + "= ";
                    textoString += lista.get(i) + "\n\n";
                }
                textView.setText(textoString);
                hBoxElements.getChildren().add(sPaneView);
            }
        });
        
        
        buttonConfirmDelete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                removerElementos();
                create = false;
                delete = true;
                read = false;
                labelCDR.setText("Posição do elemento");
                tfCDR.clear();
                hBoxElements.getChildren().add(vBoxCDR);
            }
        });
        buttonDeleteAll.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                removerElementos();
                if (objeto.deleteAll()) {
                    textView.setText("O objeto foi deletado com sucesso!");
                    hBoxElements.getChildren().addAll(sPaneView);
                    buttonRead.setDisable(true);
                    buttonUpdate.setDisable(true);
                    buttonDelete.setDisable(true);
                }
            }
        });
        
        
        buttonConfirmUpdate.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                if (validarUpdate()) {
                    removerElementos();

                    textView.setText("Elemento editado com sucesso!");
                    hBoxElements.getChildren().add(sPaneView);
                } else showPopup("Ops... Ocorreu um erro inesperado ao editar o elemento", false);
            }
        });
        buttonConfirmPessoa.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                if(adicionarPessoa()){
                    removerElementos();
                    
                    textView.setText("Pessoa adicionada com sucesso!");
                    hBoxElements.getChildren().add(sPaneView);

                    tfAltura.clear();
                    tfCPF.clear();
                    tfIdade.clear();
                    tfNome.clear();
                    tfPeso.clear();
                    choiceBoxSexo.setValue(opcoesSexos.get(0));

                    if(buttonRead.isDisabled()) buttonRead.setDisable(false);
                    if(buttonUpdate.isDisabled()) buttonUpdate.setDisable(false);
                }
            }
        });
        buttonCDR.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                if (create) {
                    if(validarCreate()) {
                        removerElementos();

                        textView.setText("Elemento cadastrado com sucesso!");
                        hBoxElements.getChildren().add(sPaneView);
                        if(buttonRead.isDisabled()) buttonRead.setDisable(false);
                        if(buttonUpdate.isDisabled()) buttonUpdate.setDisable(false);
                    } else showPopup("Ops... Ocorreu um erro inesperado ao cadastrar o elemento", false);
                }
                if (delete) {
                    if (validarDelete()) {
                        removerElementos();

                        textView.setText("Elemento deletado com sucesso!");
                        hBoxElements.getChildren().add(sPaneView);
                    }
                }
                if (read) {
                    if (validarRead()) {
                        removerElementos();

                        int posicao = Integer.parseInt(tfCDR.getText());
                        String elemento = String.valueOf(objeto.read(posicao));
                        
                        textView.setText(elemento);
                        hBoxElements.getChildren().add(sPaneView);
                    }
                }
            }
        });

        tfCPF.setOnKeyTyped(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent arg0) {
                autoCompleteCPF();
            }
        });
    }

    
    
    private boolean validarUpdate() {
        if(validarCamposUpdate()){
            if (tipoInteger) {
                Integer elemento = Integer.parseInt(tfElemento.getText());
                int posicao = Integer.parseInt(tfPosicao.getText());
                return objeto.update(elemento, posicao);
            } else {
                String elemento = tfElemento.getText();
                int posicao = Integer.parseInt(tfPosicao.getText());
                return objeto.update(elemento, posicao);
            }
        } 
        return false;
    }

    private boolean validarCamposUpdate() {
        if (tfPosicao.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        } else if (tfPosicao.getText().matches("\\D")) {
            showPopup("A posição não pode conter letras", false);
            return false;
        } else if (tfPosicao.getText().matches("[0-9^.]+")) {
            double num =  Double.parseDouble(tfPosicao.getText());
            if (num < 0 ) {
                showPopup("A posição não pode ser negativa", false);
                return false;
            }
        }

        if (tipoInteger) {
            if (tfElemento.getText().isEmpty()) {
                showPopup("O campo não pode ser vazio, tente novamente", false);
                return false;
            } else if (tfElemento.getText().matches("\\D")) {
                showPopup("O campo é do tipo Integer, portanto não pode conter letras", false);
                return false;
            }
        } else {
            if (tfElemento.getText().isEmpty()) {
                showPopup("O campo não pode ser vazio, tente novamente", false);
                return false;
            }
        }
        return true;
    }
    


    private boolean validarRead() {
        return validarPosicao();
    }

    private boolean validarDelete() {
        if (validarPosicao()) {
            int posicao = Integer.parseInt(tfCDR.getText());
            return objeto.delete(posicao);
        }
        return false;
    }

    private boolean validarCreate() {
        if (tipoInteger){ 
            if (validarIntCreate()) {
                Integer elemento = Integer.parseInt(tfCDR.getText());
                return objeto.create(elemento);
            } 
        } else {
            if (validarStringCreate()) {
                String elemento = tfCDR.getText();
                return objeto.create(elemento);
            } 
        } 
        return false;
    }


    private boolean validarStringCreate() {
        if (tfCDR.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        }
        return true;
    }
    private boolean validarIntCreate() {
        if (tfCDR.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        } else if (tfCDR.getText().matches("\\D")) {
            showPopup("O campo é do tipo Integer, portanto não pode conter letras", false);
            return false;
        }
        return true;
    }



    private boolean validarPosicao() {
        if (tfCDR.getText().isEmpty()) {
            showPopup("O campo não pode ser vazio, tente novamente", false);
            return false;
        } else if (tfCDR.getText().matches("\\D")) {
            showPopup("A posição não pode conter letras", false);
            return false;
        } else if (tfCDR.getText().matches("[0-9^.]+")) {
            double num =  Double.parseDouble(tfCDR.getText());
            if (num < 0 ) {
                showPopup("A posição não pode ser negativa", false);
                return false;
            }
        }
        return true;
    }


    private boolean adicionarPessoa() {
        String nome = tfNome.getText();
        String cpf = tfCPF.getText();
        char sexo = choiceBoxSexo.getSelectionModel().getSelectedItem();
        int idade = Integer.parseInt(tfIdade.getText());
        double altura = Double.parseDouble(tfAltura.getText());
        double peso = Double.parseDouble(tfPeso.getText());

        Questao31 pessoa = new Questao31(cpf, nome, sexo, idade, peso, altura);
        
        return objeto.create(pessoa);
    }


    private void removerElementos() {
        if(hBoxElements.getChildren().contains(vBoxUpdate)) hBoxElements.getChildren().remove(vBoxUpdate);
        if(hBoxElements.getChildren().contains(vBoxPessoa)) hBoxElements.getChildren().remove(vBoxPessoa);
        if(hBoxElements.getChildren().contains(vBoxObjeto)) hBoxElements.getChildren().remove(vBoxObjeto);
        if(hBoxElements.getChildren().contains(vBoxRead)) hBoxElements.getChildren().remove(vBoxRead);
        if(hBoxElements.getChildren().contains(vBoxDelete)) hBoxElements.getChildren().remove(vBoxDelete);
        if(hBoxElements.getChildren().contains(vBoxCDR)) hBoxElements.getChildren().remove(vBoxCDR);
        if(hBoxElements.getChildren().contains(sPaneView)) hBoxElements.getChildren().remove(sPaneView);
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
    }

    protected void objetoCriado() {
        vBoxButtons.getChildren().remove(buttonCriarObjeto);

        vBoxButtons.getChildren().addAll(buttonCreate, buttonRead, buttonUpdate, buttonDelete);
        buttonRead.setDisable(true);
        buttonUpdate.setDisable(true);

        hBoxElements.getChildren().remove(vBoxObjeto);

        textView.setText("Objeto instanciado com sucesso!");
        hBoxElements.getChildren().addAll(sPaneView);
    }
}