package com.myapplication.projetopoo2324.atividade.tiposdeatividade.distancia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.myapplication.projetopoo2324.utilizador.Utilizador;
import com.myapplication.projetopoo2324.atividade.tiposdeatividade.distancia.Distancia;
import com.myapplication.projetopoo2324.atividade.TipoAtividade;

import java.time.LocalDateTime;

public class DistanciaTest {

    private Distancia distancia;
    private Utilizador mockUtilizador;

    
    
    @BeforeEach
    public void setUp() { //     public Distancia(String nome, TipoAtividade tipo, long duracao (seg) , int iteracoes, double distancia, LocalDateTime dataHoraRealizacao, boolean eHard) {
        distancia = new Distancia("Corrida", TipoAtividade.DISTANCIA, 450 , 5, 10.0,  LocalDateTime.now(),true);
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
    public void testGetDistancia() {
        assertEquals(10.0, distancia.getDistancia(), 0.01);
    }

    @Test
    public void testSetDistancia() {
        distancia.setDistancia(15.0);
        assertEquals(15.0, distancia.getDistancia(), 0.01);
    }

    @Test
    public void testCalcularCalorias() {
        double calorias = distancia.calcularCalorias(mockUtilizador);

        // Cálculo esperado: 0.5 * 1.0 * 10.0 = 5.0
        assertEquals(5.0, calorias, 0.01);
    }
}
