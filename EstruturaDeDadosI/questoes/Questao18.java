package questoes;

public abstract class Questao18 {
    private static String senha = "senhaDeDoidera123";

    public static boolean validarSenha(String senha) {

        if (Questao18.senha.equals(senha)) {
            return true;
        }

        return false;
    }
}
