package com.myapplication.projetopoo2324.atividade.tiposdeatividade; 

import com.myapplication.projetopoo2324.atividade.Atividade;
import com.myapplication.projetopoo2324.atividade.TipoAtividade;
import com.myapplication.projetopoo2324.utilizador.Utilizador;
import java.time.LocalDateTime;

/**
 *
 * @author tomas
 */
public class Repeticoes extends Atividade {

    private int repeticoes;

    public Repeticoes(String nome, TipoAtividade tipo, long duracao, int iteracoes, int repeticoes, LocalDateTime dataHoraRealizacao, LocalDateTime dataHoraAtual,boolean eHard) {
        super(nome, tipo, duracao, iteracoes, dataHoraRealizacao, dataHoraAtual, eHard);
        this.repeticoes = repeticoes;

    }

    public int getRepeticoes() {
        return this.repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    @Override
    public double calcularCalorias(Utilizador utilizador) {

        return (0.2 * utilizador.getFCM() * utilizador.calcularFatorMultiplicativo() * getRepeticoes()) * getDuracao();
    }

}
