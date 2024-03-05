package br.edu.ufersa.questoes;

import java.util.HashMap;
import java.util.Map;

public class EnunciadoDasQuestoes {

    private static final String questao1 = "1. Inicialize variáveis adequadas para: sua idade, sua altura, "+
    "primeira letra do seu nome, seu nome completo. Depois exiba os dados na tela.";

    private static final String questao2 = "2. Atribua com valores vindos do teclado variáveis adequadas para: sua idade, "+
    "sua altura, primeira letra do seu nome, seu nome completo. Depois exiba os dados na tela.";

    private static final String questao3 = "3. Receba do teclado dois números inteiros, calcule e exiba os resultados "+
    "das seguintes operações: adição, subtração, multiplicação, quociente da divisão e o resto da divisão.";

    private static final String questao4 = "4. Calcular e exibir a média aritmética de três números inteiros.";

    private static final String questao5 = "5. Calcular e exibir a média aritmética de três números reais.";

    private static final String questao6 = "6. Construa um programa que gerencia a conta de uma pizzaria.\r\n" + 
    "Preço do refrigerante: R$ 1,50. Preço da fatia de pizza: R$ 3,00. Taxa do garçom: 10%.\r\n" + 
    "Receba do usuário: a quantidade de refrigerantes, a quantidade de fatias e a quantidade de pessoas na mesa.\r\n" + 
    "Calcule e exiba: o total sem a taxa, o total com a taxa, o rateio por pessoa com a taxa.";

    private static final String questao7 = "7. Calcular uma divisão entre dois números reais. Produza um alerta em caso de divisão por zero.";

    private static final String questao8 = "8. Calcular o IMC (índice de massa corporal) de uma pessoa. Produza um alerta em caso de divisão por zero.";

    private static final String questao9 = "9. Construa um programa que calcule a área de um círculo, tendo como entrada o valor do raio, "+
    "que deve ser positivo. Use o valor da constante PI vindo da biblioteca matemática.";

    private static final String questao10 = "10. Construa um programa que leia um número inteiro e identifique se ele é par ou ímpar.";

    private static final String questao11 = "11. Construa um programa que simule uma transferência bancária, entre duas contas. "+
    "Primeiro, inicialize cada conta com R$ 100. Depois, permita que o usuário defina quanto deve transferir, "+
    "da conta1 para a conta2, porém a transferência só deve ser realizada caso haja saldo suficiente.";

    private static final String questao12 = "12. Distinguir, com base na média parcial do aluno, se ele está aprovado, reprovado ou na final. Aplique as regras da UFERSA.";

    private static final String questao13 = "13. Construa um programa que calcule para o aluno sua média parcial e informe sua "+
    "situação parcial (Aprovado, Recuperação ou Reprovado). \nCaso ele esteja em Recuperação, calcule quanto "+
    "ele precisa tirar na 4ª prova para ser aprovado (média final maior ou igual que 5,0). \nObservação: utilize os pesos e regras da UFERSA.";

    private static final String questao14 = "14. Construa um programa que calcule uma equação do 2º grau. "+
    "\nCrie uma função com retorno para calcular o delta.";

    private static final String questao15 = "15. Construa um programa que leia um número inteiro digitado pelo usuário. Caso o "+
    "número pertença ao intervalo de 1 a 5, exiba o número por extenso. Caso o número não pertença a este intervalo, exiba a mensagem \"valor invalido\".";

    private static final String questao16 = "16. Construa um programa que leia do usuário um número inicial e um número final. Em seguida, exiba na tela uma sequência com os números desse\r\n" +
    "intervalo informado pelo usuário. Exemplo: caso o usuário entre com os números 4 e 10, o resultado do programa seria: 4 5 6 7 8 9 10\r\n" + 
    "a) Construa este programa utilizando a estrutura while .\r\n" +
    "b) Construa este programa utilizando a estrutura do-while .\r\n" +
    "c) Construa este programa utilizando a estrutura for .";

    private static final String questao17 = "17. Construa um programa que leia do usuário um número inicial e um número final. Em seguida, exiba na tela uma sequência apenas com os\r\n" +
    "números ímpares dentro deste intervalo informado pelo usuário. Exemplo: caso o usuário entre com os números 4 e 10, o resultado seria: 5 7 9\r\n" +
    "a) Construa este programa utilizando a estrutura while .\r\n" +
    "b) Construa este programa utilizando a estrutura do-while .\r\n" +
    "c) Construa este programa utilizando a estrutura for .";

    private static final String questao18 = "18. Verificar se a senha, informada durante a execução, é correta. Quando a senha estiver correta, exiba “senha correta” e o programa é encerrado.\r\n" + 
    "Quando a senha estiver errada, exiba “senha incorreta”, e permita a entrada novamente da senha, repetindo esse processo até que a senha\r\n" +
    "informada seja correta.\r\n" +
    "a) Resolva esse problema utilizando a estrutura while .\r\n" +
    "b) Resolva esse problema utilizando a estrutura do-while .";

    private static final String questao19 = "19. Construa um programa para exibir a tabuada de qualquer número “n” (1 a 9), "+
    "sendo “n” um número fornecido pelo usuário. Utilize estrutura de repetição.";

    private static final String questao20 = "20. Construa um programa que calcule o rendimento mensal de um investimento em poupança. "+
    "Variáveis: investimento inicial, investimento mensal, quantidade de meses, saldo acumulado, taxa de juros mensal, rendimento mensal.";

    private static final String questao21 = "21. Construa um programa que identifique se um número é primo.";

    private static final String questao22 = "22. Construa um programa que calcule o somatório dos números inteiros de um intervalo, "+
    "definido por um número inicial e um número final. \nExemplo: caso as entradas fossem 4 e 9, o resultado seria: 39";

    private static final String questao23 = "23. Construa um programa que calcule o número fatorial de um número. "+
    "Use uma estrutura de repetição. Fatorial: n! = n (n - 1)! \nExemplo: 5! = 5 x 4 x 3 x 2 x 1 = 120 ou 5! = 1 x 2 x 3 x 4 x 5 = 120";

    private static final String questao24 = "24. Construa um programa que simule uma calculadora. Disponibilize um menu de opções e simule a opção desejada, exibindo novamente o menu,\r\n" +
    "até que o usuário escolha sair. Menu de opções:\r\n" +
    "1 - potenciação                 Dica: utilize a função da biblioteca matemática.\r\n" +
    "2 - raiz quadrada              Dica: utilize a função da biblioteca matemática.\r\n" +
    "3 - fatorial                        Dica: crie e utilize uma função com a solução da questão anterior.\r\n" +
    "0 - sair";

    private static final String questao25 = "25. Construa um programa para ler e exibir um vetor de inteiros. "+
    "Em tempo de execução, o usuário pode definir o tamanho do vetor.";

    private static final String questao26 = "26. Construa um programa para ler e exibir uma matriz de inteiros. "+
    "Em tempo de execução, o usuário pode definir o tamanho da matriz.";

    private static final String questao27 = "27. Construa e use uma função que produz um novo vetor de "+
    "inteiros com a ordem inversa do vetor original passado por parâmetro.";

    private static final String questao28 = "28. Construa um programa que identifique o "+
    "maior e o menor número de um vetor de inteiros.";

    private static final String questao29 = "29. Construa um programa que mova o número da última posição de um vetor para a "+
    "primeira posição. Faça isso gradativamente: use uma estrutura de repetição, e em cada iteração do loop mova esse "+
    "número apenas uma posição, ou seja, troque esse número da posição n por n-1.";

    private static final String questao30 = "30. Construa um programa que inverta a frase digitada pelo usuário. "+
    "Por exemplo, se string1 for “bom dia”, então string2 será “aid mob”.";

    private static final String questao31 = "31. Construa um programa que registre objetos da classe Pessoa, com os "+
    "seguintes atributos: cpf, nome, idade, sexo, peso, altura, imc. Permita que o usuário defina "+
    "a quantidade de pessoas em tempo de execução. Ao cadastrar uma pessoa, calcule o IMC "+
    "(Índice de Massa Corporal). Ao final, exiba a lista de pessoas (com seus respectivos atributos).";

    private static final String questao32 = "32. Evolua a questão anterior. Permita que o programa salve o resultado"+
    " em um arquivo binário. Permita que o programa abra o arquivo binário e exiba o conteúdo na tela.";

    private static final String questao33 = "33. Construa um programa que conte a quantidade de letras de uma "+
    "palavra. Exemplo: “casa” Resultado: c=1 a =2 s =1";

    private static final String questao34 = "34. Construa um programa que conte a quantidade de vezes que as palavras de "+
    "uma frase aparecem. \nExemplo: “estude muito sempre sempre estude” Resultado: estude=2 muito=1 sempre=2";

    private static final String questao35 = "35. Evolua a questão anterior. Permita que o programa salve o resultado em "+
    "um arquivo de texto CSV. Permita que o programa abra o arquivo de texto CSV e exiba o conteúdo na tela.";

    private static final String questao36 = "36. Construa e use uma função para calcular o número fatorial de um número utilizando recursividade.";

    private static final String questao37 = "37. Calcule o somatório dos números inteiros do intervalo entre dois números. "+
    "No mesmo programa, implemente esse cálculo em duas funções:\r\n" +
            "a) Resolva o problema com estrutura de repetição.\r\n" +
            "b) Resolva o problema com recursividade.\r\n" +
            "c) Analise os pontos positivos e negativos de cada versão.";

    private static final String questao38 = "38. Utilizando o recurso Generic de Java, faça um método para exibir um objeto "+
    "(usando seu método toString), e outro método para exibir os elementos de um vetor.";

    private static final String questao39 = "39. Utilizando o recurso Generic de Java, construa um programa que tenha "+
    "funcionalidades de CRUD (create, read, update e delete) que se adeque para diferentes classes (ex: String, Pessoa, Produto, etc).";

    private static final String questao40 = "40. Construa um programa CODIFICADOR que receba um arquivo de " +
    "texto de entrada e codifique ele usando um padrão de troca de letras." +
    "Após esse processamento, gere um arquivo codificado." +
    "Construa outro programa, que funcionará como DECODIFICADOR, que seja capaz de ler o arquivo codificado e produzir um arquivo de" +
    "texto decodificado, que deve ser o mesmo texto original." +
    "Padrão de troca de letras para codificar um texto: Z ⇔ P E ⇔ O N ⇔ L I ⇔ A T ⇔ R";

    private Map<Integer, String> listaDeQuestoes;

    public EnunciadoDasQuestoes(){
        this.listaDeQuestoes = new HashMap<Integer, String>();
        listaDeQuestoes.put(1, questao1);
        listaDeQuestoes.put(2, questao2);
        listaDeQuestoes.put(3, questao3);
        listaDeQuestoes.put(4, questao4);
        listaDeQuestoes.put(5, questao5);
        listaDeQuestoes.put(6, questao6);
        listaDeQuestoes.put(7, questao7);
        listaDeQuestoes.put(8, questao8);
        listaDeQuestoes.put(9, questao9);
        listaDeQuestoes.put(10, questao10);
        listaDeQuestoes.put(11, questao11);
        listaDeQuestoes.put(12, questao12);
        listaDeQuestoes.put(13, questao13);
        listaDeQuestoes.put(14, questao14);
        listaDeQuestoes.put(15, questao15);
        listaDeQuestoes.put(16, questao16);
        listaDeQuestoes.put(17, questao17);
        listaDeQuestoes.put(18, questao18);
        listaDeQuestoes.put(19, questao19);
        listaDeQuestoes.put(20, questao20);
        listaDeQuestoes.put(21, questao21);
        listaDeQuestoes.put(22, questao22);
        listaDeQuestoes.put(23, questao23);
        listaDeQuestoes.put(24, questao24);
        listaDeQuestoes.put(25, questao25);
        listaDeQuestoes.put(26, questao26);
        listaDeQuestoes.put(27, questao27);
        listaDeQuestoes.put(28, questao28);
        listaDeQuestoes.put(29, questao29);
        listaDeQuestoes.put(30, questao30);
        listaDeQuestoes.put(31, questao31);
        listaDeQuestoes.put(32, questao32);
        listaDeQuestoes.put(33, questao33);
        listaDeQuestoes.put(34, questao34);
        listaDeQuestoes.put(35, questao35);
        listaDeQuestoes.put(36, questao36);
        listaDeQuestoes.put(37, questao37);
        listaDeQuestoes.put(38, questao38);
        listaDeQuestoes.put(39, questao39);
        listaDeQuestoes.put(40, questao40);
    }

    public String pegarQuestao(int questao) {
        return listaDeQuestoes.get(questao);
    }
}