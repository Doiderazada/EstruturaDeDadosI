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
        this.TelasDisponiveis.put("questao1", "questao1.fxml");
        this.TelasDisponiveis.put("questao2", "questao2.fxml");
        this.TelasDisponiveis.put("questao3", "questao3.fxml");
        this.TelasDisponiveis.put("questao4", "questao4.fxml");
        this.TelasDisponiveis.put("questao5", "questao5.fxml");
        this.TelasDisponiveis.put("questao6", "questao6.fxml");
        this.TelasDisponiveis.put("questao7", "questao7.fxml");
        this.TelasDisponiveis.put("questao8", "questao8.fxml");
        this.TelasDisponiveis.put("questao9", "questao9.fxml");
        this.TelasDisponiveis.put("questao10", "questao10.fxml");
        this.TelasDisponiveis.put("questao11", "questao11.fxml");
        this.TelasDisponiveis.put("questao12", "questao12.fxml");
        this.TelasDisponiveis.put("questao13", "questao13.fxml");
        this.TelasDisponiveis.put("questao14", "questao14.fxml");
        this.TelasDisponiveis.put("questao15", "questao15.fxml");
        this.TelasDisponiveis.put("questao16", "questao16.fxml");
        this.TelasDisponiveis.put("questao17", "questao17.fxml");
        this.TelasDisponiveis.put("questao18", "questao18.fxml");
        this.TelasDisponiveis.put("questao19", "questao19.fxml");
        this.TelasDisponiveis.put("questao20", "questao20.fxml");
        this.TelasDisponiveis.put("questao21", "questao21.fxml");
        this.TelasDisponiveis.put("questao22", "questao22.fxml");
        this.TelasDisponiveis.put("questao23", "questao23.fxml");
        this.TelasDisponiveis.put("questao24", "questao24.fxml");
        this.TelasDisponiveis.put("questao25", "questao25.fxml");
        this.TelasDisponiveis.put("questao26", "questao26.fxml");
        this.TelasDisponiveis.put("questao27", "questao27.fxml");
        this.TelasDisponiveis.put("questao28", "questao28.fxml");
        this.TelasDisponiveis.put("questao29", "questao29.fxml");
        this.TelasDisponiveis.put("questao30", "questao30.fxml");
        this.TelasDisponiveis.put("questao31", "questao31.fxml");
        this.TelasDisponiveis.put("questao32", "questao32.fxml");
        this.TelasDisponiveis.put("questao33", "questao33.fxml");
        this.TelasDisponiveis.put("questao34", "questao34.fxml");
        this.TelasDisponiveis.put("questao35", "questao35.fxml");
        this.TelasDisponiveis.put("questao36", "questao36.fxml");
        this.TelasDisponiveis.put("questao37", "questao37.fxml");
        this.TelasDisponiveis.put("questao38", "questao38.fxml");
        this.TelasDisponiveis.put("questao39", "questao39.fxml");
        this.TelasDisponiveis.put("questao40", "questao40.fxml");
    }


    public String trocarTelas(String nome) {
        return this.TelasDisponiveis.get(nome);
    }
}
