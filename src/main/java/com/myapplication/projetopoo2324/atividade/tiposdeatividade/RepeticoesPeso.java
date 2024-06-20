package com.myapplication.projetopoo2324.atividade.tiposdeatividade; 

import com.myapplication.projetopoo2324.atividade.Atividade;
import com.myapplication.projetopoo2324.atividade.TipoAtividade;
import com.myapplication.projetopoo2324.utilizador.Utilizador;
import java.time.LocalDateTime;

/**
 *
 * @author tomas
 */
public class RepeticoesPeso extends Atividade {

    protected int repeticoes;
    private double peso;

    public int getRepeticoes() {
        return this.repeticoes;
    }

     public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public RepeticoesPeso(String nome, TipoAtividade tipo, long duracao, int iteracoes, int repeticoes, double peso, LocalDateTime dataHoraRealizacao, LocalDateTime dataHoraAtual, boolean eHard) {
        super(nome, tipo, duracao, iteracoes, dataHoraRealizacao, dataHoraAtual, eHard);
        this.peso = peso;
        this.repeticoes = repeticoes;

    }

   
    @Override
    public double calcularCalorias(Utilizador utilizador) {

        return (0.2 * utilizador.getFCM() * utilizador.calcularFatorMultiplicativo()) * (getRepeticoes() + 0.1 * utilizador.calcularFatorMultiplicativo() * getPeso()) * getDuracao();
    }

}
