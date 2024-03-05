package br.edu.ufersa.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import br.edu.ufersa.questoes.EnunciadoDasQuestoes;
import br.edu.ufersa.App;

public class TelaQuestoesController {
    
    
    @FXML private BorderPane telaQuestoes;
    @FXML private Button buttonVoltar;
    @FXML private Button questao_1;
    @FXML private Button questao_2;
    @FXML private Button questao_3;
    @FXML private Button questao_4;
    @FXML private Button questao_5;
    @FXML private Button questao_6;
    @FXML private Button questao_7;
    @FXML private Button questao_8;
    @FXML private Button questao_9;
    @FXML private Button questao_10;
    @FXML private Button questao_11;
    @FXML private Button questao_12;
    @FXML private Button questao_13;
    @FXML private Button questao_14;
    @FXML private Button questao_15;
    @FXML private Button questao_16;
    @FXML private Button questao_17;
    @FXML private Button questao_18;
    @FXML private Button questao_19;
    @FXML private Button questao_20;
    @FXML private Button questao_21;
    @FXML private Button questao_22;
    @FXML private Button questao_23;
    @FXML private Button questao_24;
    @FXML private Button questao_25;
    @FXML private Button questao_26;
    @FXML private Button questao_27;
    @FXML private Button questao_28;
    @FXML private Button questao_29;
    @FXML private Button questao_30;
    @FXML private Button questao_31;
    @FXML private Button questao_32;
    @FXML private Button questao_33;
    @FXML private Button questao_34;
    @FXML private Button questao_35;
    @FXML private Button questao_36;
    @FXML private Button questao_37;
    @FXML private Button questao_38;
    @FXML private Button questao_39;
    @FXML private Button questao_40;
    @FXML private Label copyRight;
    @FXML private Label labelEnumQ;
    @FXML private Label labelListaQ;
    @FXML private TextArea enumTextArea;

    private final EnunciadoDasQuestoes questoes = new EnunciadoDasQuestoes();
    
    public void initialize() {
        acaoDosBotoes();
        setStilo();
        enumTextArea.setEditable(false);
    }



    private void setStilo() {
        if (App.darkMode) {
            telaQuestoes.setStyle("-fx-background-color: #282828");
            labelEnumQ.setStyle("-fx-text-fill: white;");
            labelListaQ.setStyle("-fx-text-fill: white;");
            buttonVoltar.getStyleClass().setAll("btn-voltar-DM");
            questao_1.getStyleClass().setAll("btn-questao-DM");
            questao_2.getStyleClass().setAll("btn-questao-DM");
            questao_3.getStyleClass().setAll("btn-questao-DM");
            questao_4.getStyleClass().setAll("btn-questao-DM");
            questao_5.getStyleClass().setAll("btn-questao-DM");
            questao_6.getStyleClass().setAll("btn-questao-DM");
            questao_7.getStyleClass().setAll("btn-questao-DM");
            questao_8.getStyleClass().setAll("btn-questao-DM");
            questao_9.getStyleClass().setAll("btn-questao-DM");
            questao_10.getStyleClass().setAll("btn-questao-DM");
            questao_11.getStyleClass().setAll("btn-questao-DM");
            questao_12.getStyleClass().setAll("btn-questao-DM");
            questao_13.getStyleClass().setAll("btn-questao-DM");
            questao_14.getStyleClass().setAll("btn-questao-DM");
            questao_15.getStyleClass().setAll("btn-questao-DM");
            questao_16.getStyleClass().setAll("btn-questao-DM");
            questao_17.getStyleClass().setAll("btn-questao-DM");
            questao_18.getStyleClass().setAll("btn-questao-DM");
            questao_19.getStyleClass().setAll("btn-questao-DM");
            questao_20.getStyleClass().setAll("btn-questao-DM");
            questao_21.getStyleClass().setAll("btn-questao-DM");
            questao_22.getStyleClass().setAll("btn-questao-DM");
            questao_23.getStyleClass().setAll("btn-questao-DM");
            questao_24.getStyleClass().setAll("btn-questao-DM");
            questao_25.getStyleClass().setAll("btn-questao-DM");
            questao_26.getStyleClass().setAll("btn-questao-DM");
            questao_27.getStyleClass().setAll("btn-questao-DM");
            questao_28.getStyleClass().setAll("btn-questao-DM");
            questao_29.getStyleClass().setAll("btn-questao-DM");
            questao_30.getStyleClass().setAll("btn-questao-DM");
            questao_31.getStyleClass().setAll("btn-questao-DM");
            questao_32.getStyleClass().setAll("btn-questao-DM");
            questao_33.getStyleClass().setAll("btn-questao-DM");
            questao_34.getStyleClass().setAll("btn-questao-DM");
            questao_35.getStyleClass().setAll("btn-questao-DM");
            questao_36.getStyleClass().setAll("btn-questao-DM");
            questao_37.getStyleClass().setAll("btn-questao-DM");
            questao_38.getStyleClass().setAll("btn-questao-DM");
            questao_39.getStyleClass().setAll("btn-questao-DM");
            questao_40.getStyleClass().setAll("btn-questao-DM");
        } else {
            telaQuestoes.setStyle(null);
            labelEnumQ.setStyle(null);
            labelListaQ.setStyle(null);
            buttonVoltar.getStyleClass().setAll("btn-voltar");
            questao_1.getStyleClass().setAll("btn-questao");
            questao_2.getStyleClass().setAll("btn-questao");
            questao_3.getStyleClass().setAll("btn-questao");
            questao_4.getStyleClass().setAll("btn-questao");
            questao_5.getStyleClass().setAll("btn-questao");
            questao_6.getStyleClass().setAll("btn-questao");
            questao_7.getStyleClass().setAll("btn-questao");
            questao_8.getStyleClass().setAll("btn-questao");
            questao_9.getStyleClass().setAll("btn-questao");
            questao_10.getStyleClass().setAll("btn-questao");
            questao_11.getStyleClass().setAll("btn-questao");
            questao_12.getStyleClass().setAll("btn-questao");
            questao_13.getStyleClass().setAll("btn-questao");
            questao_14.getStyleClass().setAll("btn-questao");
            questao_15.getStyleClass().setAll("btn-questao");
            questao_16.getStyleClass().setAll("btn-questao");
            questao_17.getStyleClass().setAll("btn-questao");
            questao_18.getStyleClass().setAll("btn-questao");
            questao_19.getStyleClass().setAll("btn-questao");
            questao_20.getStyleClass().setAll("btn-questao");
            questao_21.getStyleClass().setAll("btn-questao");
            questao_22.getStyleClass().setAll("btn-questao");
            questao_23.getStyleClass().setAll("btn-questao");
            questao_24.getStyleClass().setAll("btn-questao");
            questao_25.getStyleClass().setAll("btn-questao");
            questao_26.getStyleClass().setAll("btn-questao");
            questao_27.getStyleClass().setAll("btn-questao");
            questao_28.getStyleClass().setAll("btn-questao");
            questao_29.getStyleClass().setAll("btn-questao");
            questao_30.getStyleClass().setAll("btn-questao");
            questao_31.getStyleClass().setAll("btn-questao");
            questao_32.getStyleClass().setAll("btn-questao");
            questao_33.getStyleClass().setAll("btn-questao");
            questao_34.getStyleClass().setAll("btn-questao");
            questao_35.getStyleClass().setAll("btn-questao");
            questao_36.getStyleClass().setAll("btn-questao");
            questao_37.getStyleClass().setAll("btn-questao");
            questao_38.getStyleClass().setAll("btn-questao");
            questao_39.getStyleClass().setAll("btn-questao");
            questao_40.getStyleClass().setAll("btn-questao");
        }
    }



    
    private void acaoDosBotoes() {
        buttonVoltar.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("telaInicial");
            }
        });

        questao_1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(1));
            }
        });
        questao_2.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(2));
            }
        });
        questao_3.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(3));
            }
        });
        questao_4.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(4));
            }
        });
        questao_5.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(5));
            }
        });
        questao_6.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(6));
            }
        });
        questao_7.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(7));
            }
        });
        questao_8.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(8));
            }
        });
        questao_9.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(9));
            }
        });
        questao_10.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(10));
            }
        });
        questao_11.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(11));
            }
        });
        questao_12.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(12));
            }
        });
        questao_13.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(13));
            }
        });
        questao_14.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(14));
            }
        });
        questao_15.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(15));
            }
        });
        questao_16.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(16));
            }
        });
        questao_17.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(17));
            }
        });
        questao_18.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(18));
            }
        });
        questao_19.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(19));
            }
        });
        questao_20.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(20));
            }
        });
        questao_21.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(21));
            }
        });
        questao_22.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(22));
            }
        });
        questao_23.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(23));
            }
        });
        questao_24.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(24));
            }
        });
        questao_25.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(25));
            }
        });
        questao_26.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(26));
            }
        });
        questao_27.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(27));
            }
        });
        questao_28.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(28));
            }
        });
        questao_29.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(29));
            }
        });
        questao_30.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(30));
            }
        });
        questao_31.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(31));
            }
        });
        questao_32.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(32));
            }
        });
        questao_33.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(33));
            }
        });
        questao_34.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(34));
            }
        });
        questao_35.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(35));
            }
        });
        questao_36.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(36));
            }
        });
        questao_37.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(37));
            }
        });
        questao_38.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(38));
            }
        });
        questao_39.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(39));
            }
        });
        questao_40.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText(questoes.pegarQuestao(40));
            }
        });
        

        



        questao_1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao1");
            }
        });
        questao_2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao2");
            }
        });
        questao_3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao3");
            }
        });
        questao_4.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao4");
            }
        });
        questao_5.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao5");
            }
        });
        questao_6.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao6");
            }
        });
        questao_7.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao7");
            }
        });
        questao_8.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao8");
            }
        });
        questao_9.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao9");
            }
        });
        questao_10.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao10");
            }
        });
        questao_11.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao11");
            }
        });
        questao_12.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao12");
            }
        });
        questao_13.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao13");
            }
        });
        questao_14.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao14");
            }
        });
        questao_15.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao15");
            }
        });
        questao_16.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao16");
            }
        });
        questao_17.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao17");
            }
        });
        questao_18.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao18");
            }
        });
        questao_19.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao19");
            }
        });
        questao_20.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao20");
            }
        });
        questao_21.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao21");
            }
        });
        questao_22.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao22");
            }
        });
        questao_23.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao23");
            }
        });
        questao_24.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao24");
            }
        });
        questao_25.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao25");
            }
        });
        questao_26.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao26");
            }
        });
        questao_27.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao27");
            }
        });
        questao_28.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao28");
            }
        });
        questao_29.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao29");
            }
        });
        questao_30.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao30");
            }
        });
        questao_31.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao31");
            }
        });
        questao_32.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao32");
            }
        });
        questao_33.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao33");
            }
        });
        questao_34.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao34");
            }
        });
        questao_35.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao35");
            }
        });
        questao_36.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao36");
            }
        });
        questao_37.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao37");
            }
        });
        questao_38.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao38");
            }
        });
        questao_39.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao39");
            }
        });
        questao_40.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                App.trocarDeTela("questao40");
            }
        });
    }
}