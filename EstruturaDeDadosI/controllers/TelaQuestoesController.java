package controllers;


import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import source.App;

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
                enumTextArea.setText("1. Inicialize variáveis adequadas para: sua idade, sua altura, "+
                "primeira letra do seu nome, seu nome completo. Depois exiba os dados na tela.");
            }
        });
        questao_2.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("2. Atribua com valores vindos do teclado variáveis adequadas para: sua idade, "+
                "sua altura, primeira letra do seu nome, seu nome completo. Depois exiba os dados na tela.");
            }
        });
        questao_3.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("3. Receba do teclado dois números inteiros, calcule e exiba os resultados "+
                "das seguintes operações: adição, subtração, multiplicação, quociente da divisão e o resto da divisão.");
            }
        });
        questao_4.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("4. Calcular e exibir a média aritmética de três números inteiros.");
            }
        });
        questao_5.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("5. Calcular e exibir a média aritmética de três números reais.");
            }
        });
        questao_6.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("6. Construa um programa que gerencia a conta de uma pizzaria.\r\n" + 
                        "Preço do refrigerante: R$ 1,50. Preço da fatia de pizza: R$ 3,00. Taxa do garçom: 10%.\r\n" + 
                        "Receba do usuário: a quantidade de refrigerantes, a quantidade de fatias e a quantidade de pessoas na mesa.\r\n" + 
                        "Calcule e exiba: o total sem a taxa, o total com a taxa, o rateio por pessoa com a taxa.");
            }
        });
        questao_7.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("7. Calcular uma divisão entre dois números reais. Produza um alerta em caso de divisão por zero.");
            }
        });
        questao_8.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("8. Calcular o IMC (índice de massa corporal) de uma pessoa. Produza um alerta em caso de divisão por zero.");
            }
        });
        questao_9.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("9. Construa um programa que calcule a área de um círculo, tendo como entrada o valor do raio, "+
                "que deve ser positivo. Use o valor da constante PI vindo da biblioteca matemática.");
            }
        });
        questao_10.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("10. Construa um programa que leia um número inteiro e identifique se ele é par ou ímpar.");
            }
        });
        questao_11.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("11. Construa um programa que simule uma transferência bancária, entre duas contas. "+
                "Primeiro, inicialize cada conta com R$ 100. Depois, permita que o usuário defina quanto deve transferir, "+
                "da conta1 para a conta2, porém a transferência só deve ser realizada caso haja saldo suficiente.");
            }
        });
        questao_12.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("12. Distinguir, com base na média parcial do aluno, se ele está aprovado, reprovado ou na final. Aplique as regras da UFERSA.");
            }
        });
        questao_13.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("13. Construa um programa que calcule para o aluno sua média parcial e informe sua "+
                "situação parcial (Aprovado, Recuperação ou Reprovado). \nCaso ele esteja em Recuperação, calcule quanto "+
                "ele precisa tirar na 4ª prova para ser aprovado (média final maior ou igual que 5,0). \nObservação: utilize os pesos e regras da UFERSA.");
            }
        });
        questao_14.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("14. Construa um programa que calcule uma equação do 2º grau. "+
                "\nCrie uma função com retorno para calcular o delta.");
            }
        });
        questao_15.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("15. Construa um programa que leia um número inteiro digitado pelo usuário. Caso o "+
                "número pertença ao intervalo de 1 a 5, exiba o número por extenso. Caso o número não pertença a este intervalo, exiba a mensagem \"valor invalido\".");
            }
        });
        questao_16.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("16. Construa um programa que leia do usuário um número inicial e um número final. Em seguida, exiba na tela uma sequência com os números desse\r\n" +
                        "intervalo informado pelo usuário. Exemplo: caso o usuário entre com os números 4 e 10, o resultado do programa seria: 4 5 6 7 8 9 10\r\n" + 
                        "a) Construa este programa utilizando a estrutura while .\r\n" +
                        "b) Construa este programa utilizando a estrutura do-while .\r\n" +
                        "c) Construa este programa utilizando a estrutura for .");
            }
        });
        questao_17.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("17. Construa um programa que leia do usuário um número inicial e um número final. Em seguida, exiba na tela uma sequência apenas com os\r\n" +
                        "números ímpares dentro deste intervalo informado pelo usuário. Exemplo: caso o usuário entre com os números 4 e 10, o resultado seria: 5 7 9\r\n" +
                        "a) Construa este programa utilizando a estrutura while .\r\n" +
                        "b) Construa este programa utilizando a estrutura do-while .\r\n" +
                        "c) Construa este programa utilizando a estrutura for .");
            }
        });
        questao_18.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("18. Verificar se a senha, informada durante a execução, é correta. Quando a senha estiver correta, exiba “senha correta” e o programa é encerrado.\r\n" + 
                        "Quando a senha estiver errada, exiba “senha incorreta”, e permita a entrada novamente da senha, repetindo esse processo até que a senha\r\n" +
                        "informada seja correta.\r\n" +
                        "a) Resolva esse problema utilizando a estrutura while .\r\n" +
                        "b) Resolva esse problema utilizando a estrutura do-while .");
            }
        });
        questao_19.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("19. Construa um programa para exibir a tabuada de qualquer número “n” (1 a 9), "+
                "sendo “n” um número fornecido pelo usuário. Utilize estrutura de repetição.");
            }
        });
        questao_20.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("20. Construa um programa que calcule o rendimento mensal de um investimento em poupança. "+
                "Variáveis: investimento inicial, investimento mensal, quantidade de meses, saldo acumulado, taxa de juros mensal, rendimento mensal.");
            }
        });
        questao_21.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("21. Construa um programa que identifique se um número é primo.");
            }
        });
        questao_22.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("22. Construa um programa que calcule o somatório dos números inteiros de um intervalo, "+
                "definido por um número inicial e um número final. \nExemplo: caso as entradas fossem 4 e 9, o resultado seria: 39");
            }
        });
        questao_23.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("23. Construa um programa que calcule o número fatorial de um número. "+
                "Use uma estrutura de repetição. Fatorial: n! = n (n - 1)! \nExemplo: 5! = 5 x 4 x 3 x 2 x 1 = 120 ou 5! = 1 x 2 x 3 x 4 x 5 = 120");
            }
        });
        questao_24.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("24. Construa um programa que simule uma calculadora. Disponibilize um menu de opções e simule a opção desejada, exibindo novamente o menu,\r\n" +
                        "até que o usuário escolha sair. Menu de opções:\r\n" +
                        "1 - potenciação                 Dica: utilize a função da biblioteca matemática.\r\n" +
                        "2 - raiz quadrada              Dica: utilize a função da biblioteca matemática.\r\n" +
                        "3 - fatorial                        Dica: crie e utilize uma função com a solução da questão anterior.\r\n" +
                        "0 - sair");
            }
        });
        questao_25.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("25. Construa um programa para ler e exibir um vetor de inteiros. "+
                "Em tempo de execução, o usuário pode definir o tamanho do vetor.");
            }
        });
        questao_26.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("26. Construa um programa para ler e exibir uma matriz de inteiros. "+
                "Em tempo de execução, o usuário pode definir o tamanho da matriz.");
            }
        });
        questao_27.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("27. Construa e use uma função que produz um novo vetor de "+
                "inteiros com a ordem inversa do vetor original passado por parâmetro.");
            }
        });
        questao_28.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("28. Construa um programa que identifique o "+
                "maior e o menor número de um vetor de inteiros.");
            }
        });
        questao_29.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("29. Construa um programa que mova o número da última posição de um vetor para a "+
                "primeira posição. Faça isso gradativamente: use uma estrutura de repetição, e em cada iteração do loop mova esse "+
                "número apenas uma posição, ou seja, troque esse número da posição n por n-1.");
            }
        });
        questao_30.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("30. Construa um programa que inverta a frase digitada pelo usuário. "+
                "Por exemplo, se string1 for “bom dia”, então string2 será “aid mob”.");
            }
        });
        questao_31.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("31. Construa um programa que registre objetos da classe Pessoa, com os "+
                "seguintes atributos: cpf, nome, idade, sexo, peso, altura, imc. Permita que o usuário defina "+
                "a quantidade de pessoas em tempo de execução. Ao cadastrar uma pessoa, calcule o IMC "+
                "(Índice de Massa Corporal). Ao final, exiba a lista de pessoas (com seus respectivos atributos).");
            }
        });
        questao_32.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("32. Evolua a questão anterior. Permita que o programa salve o resultado"+
                " em um arquivo binário. Permita que o programa abra o arquivo binário e exiba o conteúdo na tela.");
            }
        });
        questao_33.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("33. Construa um programa que conte a quantidade de letras de uma "+
                "palavra. Exemplo: “casa” Resultado: c=1 a =2 s =1");
            }
        });
        questao_34.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("34. Construa um programa que conte a quantidade de vezes que as palavras de "+
                "uma frase aparecem. \nExemplo: “estude muito sempre sempre estude” Resultado: estude=2 muito=1 sempre=2");
            }
        });
        questao_35.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("35. Evolua a questão anterior. Permita que o programa salve o resultado em "+
                "um arquivo de texto CSV. Permita que o programa abra o arquivo de texto CSV e exiba o conteúdo na tela.");
            }
        });
        questao_36.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("36. Construa e use uma função para calcular o número fatorial de um número utilizando recursividade.");
            }
        });
        questao_37.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("37. Calcule o somatório dos números inteiros do intervalo entre dois números. "+
                "No mesmo programa, implemente esse cálculo em duas funções:\r\n" + //
                        "a) Resolva o problema com estrutura de repetição.\r\n" + //
                        "b) Resolva o problema com recursividade.\r\n" + //
                        "c) Analise os pontos positivos e negativos de cada versão.");
            }
        });
        questao_38.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("38. Utilizando o recurso Generic de Java, faça um método para exibir um objeto "+
                "(usando seu método toString), e outro método para exibir os elementos de um vetor.");
            }
        });
        questao_39.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("39. Utilizando o recurso Generic de Java, construa um programa que tenha "+
                "funcionalidades de CRUD (create, read, update e delete) que se adeque para diferentes classes (ex: String, Pessoa, Produto, etc).");
            }
        });
        questao_40.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                enumTextArea.setText("40. Construa um programa CODIFICADOR que receba um arquivo de texto de entrada e codifique ele usando um padrão de troca de letras.\r\n" + //
                        "Após esse processamento, gere um arquivo codificado.\r\n" + //
                        "Construa outro programa, que funcionará como DECODIFICADOR, que seja capaz de ler o arquivo codificado e produzir um arquivo de\r\n" + //
                        "texto decodificado, que deve ser o mesmo texto original.\r\n" + //
                        "Padrão de troca de letras para codificar um texto: Z ⇔ P E ⇔ O N ⇔ L I ⇔ A T ⇔ R");
            }
        });
        
    }
}
