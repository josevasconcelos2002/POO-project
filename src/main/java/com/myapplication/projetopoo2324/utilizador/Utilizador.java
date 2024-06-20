package com.myapplication.projetopoo2324.utilizador;

import java.util.Objects;
import java.util.UUID;
import com.myapplication.projetopoo2324.planodetreino.PlanoDeTreino;
import com.myapplication.projetopoo2324.atividade.Atividade;
import com.myapplication.projetopoo2324.utilizador.TipoUtilizador;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.LocalDate;
import com.myapplication.projetopoo2324.Estado; 

public class Utilizador implements Serializable {

    private UUID codigo;
    private String nome;
    private String morada;
    private String email;
    private double fcm;
    private TipoUtilizador tipo;
    private double caloriasGastas;
    private List<PlanoDeTreino> planosDeTreino;
    private List<Atividade> atividadesIsoladas;

    public Utilizador(String nome, String morada, String email, double fcm, TipoUtilizador tipo, double caloriasGastas, List<PlanoDeTreino> planosDeTreino, List<Atividade> atividadesIsoladas) {
        this.codigo = UUID.randomUUID();
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.fcm = fcm;
        this.tipo = tipo;
        this.caloriasGastas = caloriasGastas;
        this.planosDeTreino = planosDeTreino;
        this.atividadesIsoladas = atividadesIsoladas;
    }

    public Utilizador(String nome, String morada, String email, double fcm, TipoUtilizador tipo) {
        this.codigo = UUID.randomUUID();
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.fcm = fcm;
        this.tipo = tipo;
        this.caloriasGastas = 0;
        this.planosDeTreino = new ArrayList<>();
        this.atividadesIsoladas = new ArrayList<>();
    }

    public Utilizador() {
        this.codigo = UUID.randomUUID();
        this.nome = "";
        this.morada = "";
        this.email = "";
        this.fcm = 65;
        this.tipo = null;
        this.caloriasGastas = 0.0;
        this.planosDeTreino = new ArrayList<>();
        this.atividadesIsoladas = new ArrayList<>();
    }

    public Utilizador(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Utilizador(Utilizador outroUtilizador) {
        this.codigo = outroUtilizador.getCodigo();
        this.nome = outroUtilizador.getNome();
        this.morada = outroUtilizador.getMorada();
        this.email = outroUtilizador.getEmail();
        this.fcm = outroUtilizador.getFCM();
        this.tipo = outroUtilizador.getTipo();
        this.caloriasGastas = outroUtilizador.getCaloriasGastas();
        this.planosDeTreino = new ArrayList<>(outroUtilizador.getPlanosDeTreino());
        this.atividadesIsoladas = new ArrayList<>(outroUtilizador.getAtividadesIsoladas());
    }

    // up 
    public List<Atividade> getAtividadesIsoladas() {
        return atividadesIsoladas;
    }

    public void setAtividadesIsoladas(List<Atividade> atividadesIsoladas) {
        this.atividadesIsoladas = new ArrayList<>(atividadesIsoladas);
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        if (morada == null || morada.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome da morada não pode ser nulo ou vazio");
        }
        this.morada = morada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email não pode ser nulo ou vazio");
        }
        this.email = email;
    }

    public double getFCM() {
        return fcm;
    }

    public void setFCM(double fcm) {
        this.fcm = fcm;
    }

    public TipoUtilizador getTipo() {
        return tipo;
    }

    public void setTipo(TipoUtilizador tipo) {
        this.tipo = tipo;
    }

    public double getCaloriasGastas() {
        return this.caloriasGastas;
    }

    public void setCaloriasGastas(double caloriasGastas) {
        this.caloriasGastas = caloriasGastas;
    }

    public List<PlanoDeTreino> getPlanosDeTreino() {
        return planosDeTreino;
    }

    public void adicionarPlanoDeTreino(PlanoDeTreino planoDeTreino) {
        planosDeTreino.add(planoDeTreino);
    }

    public void adicionarAtividade(Atividade atividade) {
        atividadesIsoladas.add(atividade);
    }

    public String stringPlanosDeTreino() {
        StringBuilder sb = new StringBuilder();
        sb.append("Planos de Treino: \n");
        for (PlanoDeTreino planoDeTreino : planosDeTreino) {
            sb.append("\t").append(planoDeTreino.toString()).append("\n");
        }
        return sb.toString();
    }

  
    

    @Override
    public String toString() {
        return "\nUtilizador = {"
                + "\nCodigo = " + codigo
                + "\nNome = '" + nome + '\''
                + "\nMorada = '" + morada + '\''
                + "\nEmail = '" + email + '\''
                + "\nFCM = " + fcm
                + "\nTipo = " + tipo
                + "\nCalorias Gastas = " + caloriasGastas
                + "\nPlanos de Treino = " + planosDeTreino.toString()
                + "\nAtividades Isoladas = " + atividadesIsoladas.toString()
                + '}';
    }

    // updated
    public boolean existePlanoDeTreino(String nomePlano) {
        return planosDeTreino.stream().anyMatch(plano -> plano.getNomeDoPlano().equals(nomePlano));
    }

    // updated
    public PlanoDeTreino getPlanoDeTreinoByName(String nomePlano) {
        return planosDeTreino.stream()
                .filter(plano -> plano.getNomeDoPlano().equals(nomePlano))
                .findFirst()
                .orElse(null);
    }

    // updated 
    public boolean equalsByEmail(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Utilizador that = (Utilizador) o;
        return Objects.equals(email, that.email); // considera users iguais se os emails forem iguais
    }

    public int hashCodeByEmail() {
        return Objects.hash(email);
    }

    @Override
    public Utilizador clone() {
        return new Utilizador(this);
    }

   

    public double calcularFatorMultiplicativo() {
        double fator = 1.0; // padrao

        // calcula o fator mult tendo em conta os dif tipos de user
        switch (this.tipo) {
            case PROFISSIONAL:
                fator *= 1.2; // aumento de 20%
                break;
            case AMADOR:
                fator *= 1.0; // sem alteraçao
                break;
            case PRATICANTE_OCASIONAL:
                fator *= 0.8; // reducao de 20%
                break;
            default:
                break;
        }

        return fator;
    }

    // registra uma dada atividade num plano de treino 
    public void registrarAtividadeRealizada(Atividade atividade, PlanoDeTreino planoDeTreino) {
        if (planoDeTreino != null && planoDeTreino.getAtividades().contains(atividade)) {
            System.out.println("Atividade realizada registrada com sucesso!");
        } else {
            System.out.println("A atividade nao esta incluída no plano de treino especificado.");
        }

    }

// adiciona a atividade a lista de atividades isoladas
    public void registrarAtividadeIsolada(Atividade atividade) {
        this.atividadesIsoladas.add(atividade);
        System.out.println("Atividade isolada realizada registrada com sucesso!");
    }

  
    


    
  
    public void executarPlano(PlanoDeTreino planoDeTreino, Estado estado) {
    if (planoDeTreino != null) {
        List<Atividade> atividadesDoPlano = planoDeTreino.getAtividades();
        for (Atividade atividade : atividadesDoPlano) {
            if (atividade.eHard() && estado.podeAdicionarAtividadeHard(atividade.getDataHora().toLocalDate())) {
                registrarAtividadeRealizada(atividade, planoDeTreino);
            }
        }
        System.out.println("Plano de treino executado com sucesso!");
    } else {
        System.out.println("O utilizador não possui um plano de treino definido.");
    }
}
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
 

 
 
 
 
 

}


    
    
    
    
    
    
    
    
    
    
    
    
    
    


