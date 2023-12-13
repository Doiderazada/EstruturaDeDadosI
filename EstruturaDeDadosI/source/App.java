package source;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static Stage janela;
    private static GerenciadorDeTelas gerenciador = new GerenciadorDeTelas();
    public static boolean darkMode = false;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        janela = primaryStage;
        janela.setTitle("Estrutura de Dados I");
        janela.setResizable(false);

        Scene primeiraTela = gerenciador.carregarTela("telaInicial");

        janela.setScene(primeiraTela);
        janela.show();
    }
    

    public static void trocarDeTela(String nome) {
        janela.setY(janela.getScene().getWindow().getY());
        janela.setX(janela.getScene().getWindow().getX());
        janela.setScene(gerenciador.carregarTela(nome));
    }
}