package source;

import java.util.HashMap;
import java.util.Map;

public class TelasDisponiveis {
    
    private Map<String, String> TelasDisponiveis;

    public TelasDisponiveis() {

        this.TelasDisponiveis = new HashMap<String, String>();
        this.TelasDisponiveis.put("telaInicial", "telaInicial.fxml");
        this.TelasDisponiveis.put("telaQuestoes", "telaQuestoes.fxml");
        this.TelasDisponiveis.put("telaSobre", "telaSobre.fxml");
    }


    public String trocarTelas(String nome) {
        return this.TelasDisponiveis.get(nome);
    }
}
