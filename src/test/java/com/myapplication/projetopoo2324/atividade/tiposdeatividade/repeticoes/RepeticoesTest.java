package com.myapplication.projetopoo2324.atividade.tiposdeatividade.repeticoes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import com.myapplication.projetopoo2324.atividade.tiposdeatividade.repeticoes.Repeticoes;
import com.myapplication.projetopoo2324.utilizador.Utilizador;
import com.myapplication.projetopoo2324.atividade.TipoAtividade;

public class RepeticoesTest {

    private Repeticoes repeticoes;
    private Utilizador mockUtilizador;

    @BeforeEach
    public void setUp() { //   public Repeticoes(String nome, TipoAtividade tipo, long duracao, int iteracoes, int repeticoes, LocalDateTime dataHoraRealizacao , boolean eHard) {
        repeticoes = new Repeticoes("Flexões", TipoAtividade.REPETICOES, 0 , 6, 4, LocalDateTime.now(), false);

        // Mock de Utilizador para os testes
        mockUtilizador = new Utilizador() {
            @Override
            public double calcularFatorMultiplicativo() {
                // Simulando um fator multiplicativo de 1.0 para o mock
                return 1.0;
            }
        };
    }

    @Test
    public void testGetRepeticoes() {
        assertEquals(10, repeticoes.getRepeticoes());
    }

    @Test
    public void testSetRepeticoes() {
        repeticoes.setRepeticoes(15);
        assertEquals(15, repeticoes.getRepeticoes());
    }

    @Test
    public void testCalcularCalorias() {
        double calorias = repeticoes.calcularCalorias(mockUtilizador);

        // Cálculo esperado: 0.2 * 1.0 * 10 = 2.0
        assertEquals(2.0, calorias, 0.01);
    }
}
