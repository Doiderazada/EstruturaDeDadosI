package source;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class GerenciadorDeTelas {
    
    private TelasDisponiveis telasDisponiveis = new TelasDisponiveis();

    public Scene carregarTela(String nome) {
        try {
            try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/" + telasDisponiveis.trocarTelas(nome)));
            Parent root = loader.load();
            Scene tela = new Scene(root);
            
            return tela;
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        return null;
    }
}
