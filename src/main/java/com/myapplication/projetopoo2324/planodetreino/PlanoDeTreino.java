package com.myapplication.projetopoo2324.planodetreino;


import com.myapplication.projetopoo2324.utilizador.Utilizador;
import com.myapplication.projetopoo2324.atividade.Atividade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime; 


/**
 *
 * @author tomas
 */


public class PlanoDeTreino implements Serializable {
    private String nomeDoPlano;
    private LocalDateTime dataHora;
    private List<Atividade> atividades;
    private String emailUtilizador; 
    private String recorrencia;
    private double caloriasMinimas; 
    
    
    
    
    
 public boolean verificarCaloriasPlano(Utilizador usuario) {
    double totalCalorias = this.atividades.stream()
                                .mapToDouble(atividade -> atividade.calcularCalorias(usuario))
                                .sum();
    return totalCalorias >= this.caloriasMinimas;
}

    
    
    
    public PlanoDeTreino(){
        this.nomeDoPlano = "";
        this.dataHora = LocalDateTime.now();
        this.atividades = new ArrayList<>();
        this.emailUtilizador = "";
        this.recorrencia = "";
        this.caloriasMinimas = 0 ; 
    }
    
    
    public PlanoDeTreino(String nomeDoPlano,LocalDateTime dataHora, List<Atividade> atividades , String emailUtilizador , String recorrencia , double caloriasMinimas) {
        this.nomeDoPlano = nomeDoPlano;
        this.dataHora = dataHora;
        this.emailUtilizador = emailUtilizador;
        this.atividades = atividades;
        this.recorrencia = recorrencia;
           this.caloriasMinimas = caloriasMinimas;
    }


    public PlanoDeTreino(PlanoDeTreino umPlanoDeTreino){
        this.nomeDoPlano = umPlanoDeTreino.getNomeDoPlano();
        this.dataHora = umPlanoDeTreino.getDataHora(); 
        this.emailUtilizador = umPlanoDeTreino.getEmailUtilizador(); 
        this.atividades = umPlanoDeTreino.getAtividades() ; 
        this.recorrencia = umPlanoDeTreino.getRecorrencia(); 
        this.caloriasMinimas = umPlanoDeTreino.getCaloriasMinimas(); 
    }

    public String getNomeDoPlano(){
        return this.nomeDoPlano;
    }

    public void setNomeDoPlano(String nomeDoPlano){
        this.nomeDoPlano = nomeDoPlano;
    }

    
         public void setRecorrencia(String recorrencia) {
        this.recorrencia = recorrencia;
    }

    public String getRecorrencia() {
        return recorrencia;
    }
    
    
    public String getEmailUtilizador() {
        return emailUtilizador;
    }

    public void setEmailUtilizador(String emailUtilizador){
        this.emailUtilizador = emailUtilizador;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    @Override
    public String toString() {
        return "\nPlano de Treino = {" +
                "\nNome = " + nomeDoPlano +
                "\nData = " + dataHora +
                "\nAtividades = " + atividades.toString() +
                "\nEmail = " + emailUtilizador +
                //"\nDias da semana = " + diasDaSemana +
                "\nRecorrencia = " + recorrencia +
                "\n}\n";
    }



    public void definirIteracoes(Atividade atividade, int iteracoes) {
        for (Atividade a : atividades) {
            if (a.equals(atividade)) {
                a.setIteracoes(iteracoes);
                return;
            }
        }

        System.err.println("Atividade não encontrada no plano de treino.");
    }
    
    
        public double getCaloriasMinimas() {
        return caloriasMinimas;
    }

    public void setCaloriasMinimas(double caloriasMinimas) {
        this.caloriasMinimas = caloriasMinimas;
    }

     
       
     public void adicionarAtividade(Atividade atividade ){   
        this.atividades.add(atividade);

        
    }
    
     
     public void removerAtividade(Atividade atividade) {
        this.atividades.remove(atividade);
    }
    
    

    
    @Override
    public PlanoDeTreino clone(){
        return new PlanoDeTreino((this));
    }
 



     
}
