package com.myapplication.projetopoo2324.utilizador;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class UtilizadoresTest {

    @Test
    void testAddAndRemoveUtilizador() {
        Utilizador utilizador = new Utilizador("User", "123 Main St.", "user@gmail.com", 60.0, TipoUtilizador.PROFISSIONAL);
        Utilizadores utilizadores = new Utilizadores();

        utilizadores.addUtilizador(utilizador);

        assertTrue(utilizadores.existeEmail("user@gmail.com"));
        assertEquals(1, utilizadores.sizeUtilizadores());

        utilizadores.removeUtilizador(utilizador);

        assertFalse(utilizadores.existeEmail("user@gmail.com"));
        assertEquals(0, utilizadores.sizeUtilizadores());
    }

    @Test
    void testGetUtilizadorByEmail() {
        Utilizador utilizador = new Utilizador("User", "123 Main St.", "user@gmail.com", 60.0, TipoUtilizador.PROFISSIONAL);
        Utilizadores utilizadores = new Utilizadores();

        utilizadores.addUtilizador(utilizador);

        Utilizador usuarioObtido = utilizadores.getUtilizadorByEmail("user@gmail.com");

        assertNotNull(usuarioObtido);
        assertEquals("User", usuarioObtido.getNome());
    }

    @Test
    void testGetUserNameByKey() {
        Utilizador utilizador = new Utilizador("User", "123 Main St.", "user@gmail.com", 60.0, TipoUtilizador.PROFISSIONAL);
        Utilizadores utilizadores = new Utilizadores();

        utilizadores.addUtilizador(utilizador);

        String nomeObtido = utilizadores.getUserNameByKey("user@gmail.com");

        assertEquals("User", nomeObtido);
    }

    @Test
    void testClone() {
        Utilizador utilizador = new Utilizador("User", "123 Main St.", "user@gmail.com", 60.0, TipoUtilizador.PROFISSIONAL);
        Utilizadores utilizadores = new Utilizadores();
        utilizadores.addUtilizador(utilizador);

        Utilizadores cloneUtilizadores = utilizadores.clone();

        // Verifica se o clone é uma instância diferente
        assertNotSame(utilizadores, cloneUtilizadores);

        // Verifica se o conteúdo é o mesmo
        assertEquals(utilizadores.getUtilizadores(), cloneUtilizadores.getUtilizadores());
    }
}
