package br.edu.ufersa;

import java.io.IOException;
import br.edu.ufersa.controllers.BaseController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class GerenciadorDeTelas {
    
    private Scene tela;
    private BaseController controller = new BaseController();

    @SuppressWarnings("exports")
    public Scene carregarTela(String nome) {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource(nome + ".fxml"));
            Parent root = loader.load();
            tela = new Scene(root);
            
            return tela;
        } catch(IOException e) {
            System.out.println(e.getMessage());
            controller.showPopup("Ocorreu um erro ao carregar a tela desejada", false, App.getJanela());
            return this.carregarTela("telaInicial");
        }
    }
}
