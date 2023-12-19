package questoes;

import java.util.Date;
import java.util.Random;

public class Questao11 {
    private String proprietario;
    private int numConta;
    private float saldo;
    private Date ultimoAcesso;
        

    public Questao11(String proprietario) {
        setProprietario(proprietario);
        Random numRandom = new Random();
        setNumConta(numRandom.nextInt(1000));
        setSaldo(100);
        Date acesso = new Date();
        setUltimoAcesso(acesso);
    }

    // public Questao11(int numConta, float saldo) {
    //     this.setNumConta(numConta);
    //     this.setSaldo(saldo);
    //     Date acesso = new Date();
    //     setUltimoAcesso(acesso);
    // }

    public int getNumConta() {
        return numConta;
    }
    private void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public float getSaldo() {
        return saldo;
    }
    private void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Date getUltimoAcesso() {
        return ultimoAcesso;
    } 
    private void setUltimoAcesso(Date ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public String getProprietario() {
        return proprietario;
    }
    private void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }


    

    public boolean transferir(Questao11 conta, float valor) {
        if (valor <= 0) return false;
        if (conta == null) return false;

        float novoSaldo = this.getSaldo() - valor;

        this.setSaldo(novoSaldo);
        Date acesso = new Date();
        this.setUltimoAcesso(acesso);

        conta.depositar(valor);

        return true;
    }

    public boolean depositar(float valor) {
        if (valor <= 0) return false;

        float novoSaldo = this.getSaldo() + valor;
        this.setSaldo(novoSaldo);

        return true;
    }

}