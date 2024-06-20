package com.myapplication.projetopoo2324;

import com.myapplication.projetopoo2324.utilizador.Utilizadores;
import com.myapplication.projetopoo2324.utilizador.Utilizador;
import com.myapplication.projetopoo2324.utilizador.TipoUtilizador;
import java.time.LocalDateTime;
import  com.myapplication.projetopoo2324.planodetreino.PlanoDeTreino; 
import com.myapplication.projetopoo2324.atividade.Atividade; 

import java.io.*;

import java.time.LocalDate;

public class Estado implements Serializable {

    private Utilizadores listaDeUtilizadores;
    private Utilizador userLogged;
    private LocalDateTime tempoAtual;

    public Estado() {
        this.listaDeUtilizadores = new Utilizadores();
        this.userLogged = null;
        this.tempoAtual = LocalDateTime.now();
    }

    public Estado(Estado estado) {
        this.listaDeUtilizadores = estado.listaDeUtilizadores;
        this.userLogged = estado.userLogged;
        this.tempoAtual = estado.tempoAtual;
    }

    public Utilizadores getListaDeUtilizadores() {
        return this.listaDeUtilizadores;
    }

    public Utilizador getUserLogged() {
        return this.userLogged;
    }

    public LocalDateTime getTempoAtual() {
        return this.tempoAtual;
    }

    public void setListaDeUtilizadores(Utilizadores utilizador) {
        this.listaDeUtilizadores = utilizador;
    }

    public void setUserLogged(Utilizador utilizador) {
        this.userLogged = utilizador;
    }

    public void setTempoAtual(LocalDateTime tempoAtual) {
        this.tempoAtual = tempoAtual;
    }

    public void setTempoAtualData(LocalDate data) {
        this.tempoAtual = data.atStartOfDay();
    }

  

     
    public boolean login(String email) {       // updated 
        email = email.trim().toLowerCase();
        Utilizador utilizador = listaDeUtilizadores.getUtilizadorByEmail(email);
        if (utilizador != null) {
            setUserLogged(utilizador);
            return true;
        } else {
            return false;
        }
    }

    // USER(s)
    public int getNewUserCode() {
        return listaDeUtilizadores.sizeUtilizadores() + 1;
    }

    public void addUtilizador(Utilizador utilizador) {
        listaDeUtilizadores.addUtilizador(utilizador);
    }

    public boolean existeEmail(String email) {
        return this.listaDeUtilizadores.existeEmail(email.trim()); // trim para nao haver erros no email 
    }

    public boolean existePlanoDeTreino(String email, String nome) {
        return this.listaDeUtilizadores.getUtilizadorByEmail(email).existePlanoDeTreino(nome);
    }

    public String printAllUsers() {
        return listaDeUtilizadores.stringUtilizadores();
    }

    public String getUserNameByKey(String email) {
        return listaDeUtilizadores.getUserNameByKey(email);
    }

    public Utilizador getUtilizadorByEmail(String email) {
        return this.listaDeUtilizadores.getUtilizadorByEmail(email);
    }

    public void addUtilizadorByEmail(String email) {
        this.listaDeUtilizadores.addUtilizador(getUtilizadorByEmail(email));
    }

    public String getMoradaByKey(String email) {
        return listaDeUtilizadores.getMoradaByKey(email);
    }

    public String getTipoByKey(String email) {
        TipoUtilizador tipo = listaDeUtilizadores.getTipoByKey(email);
        return tipo.toString();
    }
   
  
    public void escreverLog(String s) {
        try {
            File file = new File("logs/logs.txt");

            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(s);
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever a string no arquivo.");
            e.printStackTrace();
        }
    }

    // GUARDAR
    public void guardarEstado(String nomeFicheiro) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(nomeFicheiro);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(this);
        out.close();
        fileOut.close();
    }

    public void carregaEstado(String nomeFicheiro) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(nomeFicheiro);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Estado estado = (Estado) in.readObject();
        in.close();
        fileIn.close();

        this.listaDeUtilizadores = estado.listaDeUtilizadores;
        this.userLogged = estado.userLogged;
        this.tempoAtual = estado.tempoAtual;
    }
    
    
    

    
public boolean podeAdicionarAtividadeHard(LocalDate data) {
    if (userLogged == null) {
        System.out.println("Nenhum usuário está logado.");
        return false;
    }

    // verifica todos os planos de treino do usuário logado
    for (PlanoDeTreino plano : userLogged.getPlanosDeTreino()) {
        for (Atividade atividade : plano.getAtividades()) {
            LocalDate dataAtividade = atividade.getDataHora().toLocalDate();
            // verifica se a atividade é "Hard" e se ocorre no dia desejado, ou um dia antes, ou um dia depois
            if (atividade.eHard() && (dataAtividade.isEqual(data) || dataAtividade.isEqual(data.plusDays(1)) || dataAtividade.isEqual(data.minusDays(1)))) {
                return false;
            }
        }
    }
    return true;
    
    
    
}

    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
