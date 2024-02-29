package source;

import java.io.IOException;
import controllers.BaseController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class GerenciadorDeTelas {
    
    private TelasDisponiveis telasDisponiveis = new TelasDisponiveis();
    private Scene tela;
    private BaseController controller = new BaseController();

    public Scene carregarTela(String nome) {
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/" + telasDisponiveis.trocarTelas(nome)));
            Parent root = loader.load();
            tela = new Scene(root);
            
            return tela;
        } catch(IOException e) {
            System.out.println(e.getMessage());
            controller.showPopup("Ocorreu um erro ao carregar a tela desejada", false, App.janela);
            return this.carregarTela("telaInicial");
        }

    }
}
