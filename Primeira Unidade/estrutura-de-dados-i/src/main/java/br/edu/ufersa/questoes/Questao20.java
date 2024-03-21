package br.edu.ufersa.questoes;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Questao20 {
    private double investimentoInicial;
    private double investimentoMensal;
    private double saldoAcumulado;
    private double taxaJuros;
    private double[] rendimentoMensal;
    private int mesesRendendo;


    public Questao20(double investimentoInicial, double investimentoMensal, double taxaJuros, int mesesRendendo) {
        setInvestimentoInicial(investimentoInicial);
        setInvestimentoMensal(investimentoMensal);
        setTaxaJuros(taxaJuros);
        setMesesRendendo(mesesRendendo);

        rendimentoMensal = new double[mesesRendendo];
        this.deixarRender(mesesRendendo, investimentoInicial, investimentoMensal, taxaJuros);
    }


    public double getInvestimentoInicial() {
        return investimentoInicial;
    }
    private final void setInvestimentoInicial(double investimentoInicial) {
        this.investimentoInicial = investimentoInicial;
    }


    public double getInvestimentoMensal() {
        return investimentoMensal;
    }
    private final void setInvestimentoMensal(double investimentoMensal) {
        this.investimentoMensal = investimentoMensal;
    }


    public double getSaldoAcumulado() {
        return saldoAcumulado;
    }
    private void setSaldoAcumulado(double saldoAcumulado) {
        this.saldoAcumulado = saldoAcumulado;
    }


    public double getTaxaJuros() {
        return taxaJuros;
    }
    private final void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    
    public int getMesesRendendo() {
        return mesesRendendo;
    }


    public final void setMesesRendendo(int mesesRendendo) {
        this.mesesRendendo = mesesRendendo;
    }


    public double getRendimentoMensal(int mesDesejado) {
        if (mesDesejado < 0 || mesDesejado >= getMesesRendendo()) {
            return 0;
        }
        return rendimentoMensal[mesDesejado];
    }
    private void setRendimentoMensal(int mesDesejado, double valorRendido) throws Exception {
        if (mesDesejado < 0 || mesDesejado > getMesesRendendo()) {
            throw new Exception("Valor para o mês é inválido"); 
        }
        this.rendimentoMensal[mesDesejado] = valorRendido;
    }


    public double deixarRender(int mesesRendendo, double investimentoInicial, double investimentoMensal, double taxaJuros) {
        if (mesesRendendo == 0) {
            setSaldoAcumulado(investimentoInicial);
            return getSaldoAcumulado();
        }

        if (mesesRendendo == getMesesRendendo()) {
            investimentoMensal = 0;
        }

        double resultado = (investimentoInicial+investimentoMensal) + ((investimentoInicial+investimentoMensal)*(taxaJuros/100));
        int i = getMesesRendendo() - mesesRendendo;

        resultado = BigDecimal.valueOf(resultado).setScale(2, RoundingMode.HALF_DOWN).doubleValue();

        try {
            setRendimentoMensal(i, resultado);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


        return deixarRender(mesesRendendo-1, resultado, getInvestimentoMensal(), getTaxaJuros());
    }




    
    public String toString(){
        String classe = getClass().getName() + "\n\n" + 
            "Atributos \n" + 
            "double: investimentoInicial -> " + getInvestimentoInicial() + "\n" +
            "double: investimentoMensal -> " + getInvestimentoMensal() + "\n" +
            "double: saldoAcumulado -> " + getSaldoAcumulado() + "\n" +
            "double: taxaJuros -> " + getTaxaJuros() + "\n" +
            "double[]: rendimentoMensal -> " + getRendimentoMensal(getMesesRendendo()-1) + "\n" +
            "int: mesesRendendo -> " + getMesesRendendo() + "\n";

        return classe;
    }
}