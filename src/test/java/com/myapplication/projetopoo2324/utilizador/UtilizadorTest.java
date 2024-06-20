package com.myapplication.projetopoo2324.utilizador;

import com.myapplication.projetopoo2324.utilizador.TipoUtilizador;
import org.junit.jupiter.api.Test;

import static com.myapplication.projetopoo2324.utilizador.TipoUtilizador.PROFISSIONAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UtilizadorTest {

    @Test
    void testUser() {
        String email = "user@gmail.com";
        String nome = "User";
        String morada = "123 Main St.";
        Double fcm = 60.0;
        TipoUtilizador tipoEsperado = PROFISSIONAL;

        Utilizador utilizador = new Utilizador(nome, morada, email, fcm, tipoEsperado);

        assertEquals(email, utilizador.getEmail());
        assertEquals(nome, utilizador.getNome());
        assertEquals(morada, utilizador.getMorada());
        assertEquals(fcm, utilizador.getFCM());

        // UUID is generated automatically
        assertNotNull(utilizador.getCodigo());
        assertEquals(36, utilizador.getCodigo().toString().length());

        TipoUtilizador tipoObtido = utilizador.getTipo();
        assertEquals(tipoEsperado, tipoObtido);
    }
}
