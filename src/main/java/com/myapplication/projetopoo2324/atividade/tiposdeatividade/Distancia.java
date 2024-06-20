
package com.myapplication.projetopoo2324.atividade.tiposdeatividade; 
import com.myapplication.projetopoo2324.atividade.Atividade; 
import com.myapplication.projetopoo2324.atividade.TipoAtividade;
import com.myapplication.projetopoo2324.utilizador.Utilizador; 
import java.time.LocalDateTime;

/**
 *
 * @author tomas
 */
public class Distancia extends Atividade {

    protected double distancia;

    public Distancia(String nome, TipoAtividade tipo, long duracao, int iteracoes, double distancia, LocalDateTime dataHoraRealizacao, LocalDateTime dataHoraAtual, boolean eHard) {
        super(nome, tipo, duracao, iteracoes, dataHoraRealizacao, dataHoraAtual, eHard);
        this.distancia = distancia;

    }

    public Distancia() {
        super();
        this.distancia = 0.0;
    }

    public double getDistancia() {
        return this.distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    @Override
    public double calcularCalorias(Utilizador utilizador) {

        return (0.5 * utilizador.getFCM() * utilizador.calcularFatorMultiplicativo() * getDistancia()) * getDuracao();
    }

}
