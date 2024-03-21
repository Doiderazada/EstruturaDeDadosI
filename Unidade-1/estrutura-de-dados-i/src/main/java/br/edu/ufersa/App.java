package br.edu.ufersa;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    private static Stage janela;
    private static GerenciadorDeTelas gerenciador = new GerenciadorDeTelas();
    public static boolean darkMode = true;
    public static final String raizProjeto = System.getProperty("user.dir");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    @SuppressWarnings("exports")
    public void start(Stage primaryStage) throws Exception {
        janela = primaryStage;

        janela.setTitle("Estrutura de Dados I");
        janela.setResizable(false);

        Image logo = new Image("br/edu/ufersa/visual-elements/Logo.png");
        janela.getIcons().add(logo);

        Scene tela = gerenciador.carregarTela("telaInicial");
        Scene primeiraTela = tela;
        
        janela.centerOnScreen();
        janela.setScene(primeiraTela);
        janela.show();
    }


    public static void trocarDeTela(String nome) {
        janela.setY(janela.getScene().getWindow().getY());
        janela.setX(janela.getScene().getWindow().getX());
        janela.setScene(gerenciador.carregarTela(nome));
    }

    @SuppressWarnings("exports")
    public static Stage getJanela() {
        return janela;
    }
}