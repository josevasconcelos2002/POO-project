package com.myapplication.projetopoo2324.atividade.tiposdeatividade;

import com.myapplication.projetopoo2324.atividade.Atividade;
import com.myapplication.projetopoo2324.atividade.TipoAtividade;
import com.myapplication.projetopoo2324.utilizador.Utilizador;
import java.time.LocalDateTime;

/**
 *
 * @author tomas
 */
public class DistanciaAltimetria extends Atividade {

    protected double distancia;
    protected double altimetria;

    public double getDistancia() {
        return this.distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getAltimetria() {
        return this.altimetria;
    }

    public void setAltimetria(double altimetria) {
        this.altimetria = altimetria;
    }

    public DistanciaAltimetria(String nome, TipoAtividade tipo, long duracao, int iteracoes, double distancia, double altimetria, LocalDateTime dataHoraRealizacao, LocalDateTime dataHoraAtual, boolean eHard) {
        super(nome, tipo, duracao, iteracoes, dataHoraRealizacao, dataHoraAtual, eHard);
        this.distancia = distancia;
        this.altimetria = altimetria;
    }

    @Override
    public double calcularCalorias(Utilizador utilizador) {

        return ((0.5 * utilizador.getFCM() * utilizador.calcularFatorMultiplicativo() * getDistancia()) + (0.1 * utilizador.calcularFatorMultiplicativo() * getAltimetria())) * getDuracao();
    }

}
