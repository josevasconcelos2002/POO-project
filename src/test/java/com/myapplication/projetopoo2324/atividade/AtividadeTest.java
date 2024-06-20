package com.myapplication.projetopoo2324.atividade;

import com.myapplication.projetopoo2324.utilizador.Utilizador;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class AtividadeTest {

    @Test
    void testConstructorAndGetters() {
        TipoAtividade tipo = TipoAtividade.DISTANCIA;
        Utilizador utilizador = new Utilizador();
        LocalDateTime dataHora = LocalDateTime.now();

        Atividade atividade = new Atividade("Corrida", tipo, 30.0, 60.0, utilizador, 5, dataHora);

        assertEquals("Corrida", atividade.getNome());
        assertEquals(tipo, atividade.getTipo());
        assertEquals(30.0, atividade.getTempoGasto());
        assertEquals(60.0, atividade.getFCM());
        assertEquals(utilizador, atividade.getUtilizador());
        assertEquals(5, atividade.getIteracoes());
        assertEquals(dataHora, atividade.getDataHora());
    }

    @Test
    void testSetters() {
        Atividade atividade = new Atividade();

        atividade.setNome("Natação");
        atividade.setTipo(TipoAtividade.DISTANCIA_ALTIMETRIA);
        atividade.setTempoGasto(45.0);
        atividade.setFCM(65.0);
        atividade.setUtilizador(new Utilizador());
        atividade.setIteracoes(3);

        assertEquals("Natação", atividade.getNome());
        assertEquals(TipoAtividade.DISTANCIA_ALTIMETRIA, atividade.getTipo());
        assertEquals(45.0, atividade.getTempoGasto());
        assertEquals(65.0, atividade.getFCM());
        assertNotNull(atividade.getUtilizador());
        assertEquals(3, atividade.getIteracoes());
    }

    @Test
    void testClone() {
        Utilizador utilizador = new Utilizador();
        Atividade original = new Atividade("Caminhada", TipoAtividade.DISTANCIA, 40.0, 55.0, utilizador, 4, LocalDateTime.now());
        Atividade cloned = original.clone();

        assertNotSame(original, cloned);
        assertEquals(original.getNome(), cloned.getNome());
        assertEquals(original.getTipo(), cloned.getTipo());
        assertEquals(original.getTempoGasto(), cloned.getTempoGasto());
        assertEquals(original.getFCM(), cloned.getFCM());
        assertEquals(original.getUtilizador(), cloned.getUtilizador());
        assertEquals(original.getIteracoes(), cloned.getIteracoes());
        assertEquals(original.getDataHora(), cloned.getDataHora());
    }

    @Test
    void testToString() {
        Utilizador utilizador = new Utilizador();
        LocalDateTime dataHora = LocalDateTime.of(2022, 4, 18, 15, 30);
        Atividade atividade = new Atividade("Yoga", TipoAtividade.REPETICOES, 60.0, 50.0, utilizador, 6, dataHora);

        String expected = "{Nome=Yoga, tipo='REPETICOES', Tempo Gasto='60.0', fcm='50.0', Utilizador=" + utilizador + ", iteracoes=6, data=2022-04-18T15:30}";
        assertEquals(expected, atividade.toString());
    }
}
