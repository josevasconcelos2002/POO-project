package com.myapplication.projetopoo2324.registroatividade;

import com.myapplication.projetopoo2324.atividade.Atividade;
import com.myapplication.projetopoo2324.utilizador.Utilizador;
import java.time.LocalDateTime;



public class RegistroAtividade {
    private final Utilizador utilizador;
    private final Atividade atividade;
    private final LocalDateTime dataHora;

   
    public RegistroAtividade(Utilizador utilizador, Atividade atividade, LocalDateTime dataHora) {
        this.utilizador = utilizador;
        this.atividade = atividade;
        this.dataHora = dataHora;
    }
    
    
     public RegistroAtividade(RegistroAtividade umRegistro) {
        this.utilizador = umRegistro.getUtilizador();
        this.atividade = umRegistro.getAtividade();
        this.dataHora = umRegistro.getDataHora();
    }
    
    
    
   
    public Utilizador getUtilizador() {
        return utilizador;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
    
    
 

    // sem setters para garantir a imutabilidade dos objetos RegistroAtividade apos serem criados 
}