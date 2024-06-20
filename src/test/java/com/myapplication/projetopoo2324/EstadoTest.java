package com.myapplication.projetopoo2324;

import com.myapplication.projetopoo2324.Estado;
import com.myapplication.projetopoo2324.utilizador.TipoUtilizador;
import com.myapplication.projetopoo2324.utilizador.Utilizador;
import com.myapplication.projetopoo2324.utilizador.Utilizadores;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class EstadoTest {

    private static final String NOME_FICHEIRO = "test_estado.txt";

    @AfterEach
    public void limparFicheiro() {
        // caso o arquivo exista, exclui-o 
        File file = new File(NOME_FICHEIRO);
        if (file.exists()) {
            file.delete();
        }
    }


        @Test
        public void testAddUtilizador() {
            Estado estado = new Estado();
            Utilizador user1 = new Utilizador("User1","Rua User1","user1@example.com", 60.0, TipoUtilizador.AMADOR);
            estado.addUtilizador(user1);
            assertEquals(1, estado.getListaDeUtilizadores().sizeUtilizadores());
            assertEquals(user1, estado.getListaDeUtilizadores().getUtilizadorByEmail("user1@example.com"));
        }

        @Test
        public void testExisteEmail() {
            Estado estado = new Estado();
            Utilizador user1 = new Utilizador("User1","Rua User1","user1@example.com", 60.0, TipoUtilizador.AMADOR);
            estado.addUtilizador(user1);
            assertTrue(estado.existeEmail("user1@example.com"));
            assertFalse(estado.existeEmail("user2@example.com"));
        }

        @Test
        public void testGuardarECarregarEstado() {
            Estado estadoOriginal = new Estado();
            Utilizador user1 = new Utilizador("User1","Rua User1","user1@example.com", 60.0, TipoUtilizador.AMADOR);
            estadoOriginal.addUtilizador(user1);

            String nomeFicheiro = NOME_FICHEIRO;

            try {
                estadoOriginal.guardarEstado(nomeFicheiro);

                Estado estadoCarregado = new Estado();
                estadoCarregado.carregaEstado(nomeFicheiro);

                assertEquals(estadoOriginal.getListaDeUtilizadores().sizeUtilizadores(), estadoCarregado.getListaDeUtilizadores().sizeUtilizadores());
                assertEquals(estadoOriginal.getListaDeUtilizadores().getUtilizadorByEmail("user1@example.com"), estadoCarregado.getListaDeUtilizadores().getUtilizadorByEmail("user1@example.com"));

            } catch (IOException | ClassNotFoundException e) {
                fail("Falha ao guardar ou carregar o estado.");
            }
        }

    @Test
    public void testLoginSucesso() {
        // cria um estado com um utilizador existente
        Estado estado = new Estado();
        Utilizador utilizador = new Utilizador("Nome", "Morada", "user@example.com", 60.0, TipoUtilizador.AMADOR);
        estado.addUtilizador(utilizador);

        // tenta fazer login com o email do utilizador
        assertTrue(estado.login("user@example.com"));

        // verifica se o utilizador logado é o mesmo que foi adicionado ao estado
        assertEquals(utilizador, estado.getUserLogged());
    }

    @Test
    public void testLoginFalha() {
        // cria um estado vazio
        Estado estado = new Estado();

        // tenta fazer login com um email que não existe
        assertFalse(estado.login("email@inexistente.com"));

        // Verifica se o usuário logado ainda é nulo
        assertNull(estado.getUserLogged());
    }
    }
