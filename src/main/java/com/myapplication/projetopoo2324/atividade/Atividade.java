package com.myapplication.projetopoo2324.atividade;


import com.myapplication.projetopoo2324.atividade.TipoAtividade;

import com.myapplication.projetopoo2324.utilizador.Utilizador;
import java.time.LocalDateTime;


public class Atividade {
    private String nome;
    private TipoAtividade tipo;
    private double tempoGasto;
    private double fcm;
    private Utilizador utilizador;
    private int iteracoes;
    private final LocalDateTime dataHora;
    
    
  public Atividade(String nome, TipoAtividade tipo, double tempoGasto, double fcm, Utilizador utilizador, int iteracoes, LocalDateTime dataHora) {
        this.nome = nome;
        this.tipo = tipo;
        this.tempoGasto = tempoGasto;
        this.fcm = fcm;
        this.utilizador = utilizador;
        this.iteracoes = iteracoes;
        this.dataHora = dataHora;
  }

   public Atividade() {
        this.nome = "";
        this.tipo = null; 
        this.tempoGasto = 0 ; 
        this.fcm= 60; 
        this.utilizador = null ;
        this.iteracoes = 0 ;
        this.dataHora = null;
   }
  
  public Atividade(Atividade umaAtividade) {
        this.nome = umaAtividade.getNome(); 
        this.tipo = umaAtividade.getTipo(); 
        this.tempoGasto = umaAtividade.getTempoGasto(); 
        this.fcm= umaAtividade.getFCM(); 
        this.utilizador = umaAtividade.getUtilizador();
        this.iteracoes = umaAtividade.getIteracoes();
        this.dataHora = umaAtividade.getDataHora();
  }

  
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTempoGasto() {
        return tempoGasto;
    }

    public void setTempoGasto(double tempoGasto) {
        this.tempoGasto = tempoGasto;
    }
    
    
    public int getIteracoes() {
        return iteracoes;
    }
     
    public void setIteracoes(int iteracoes) {
        this.iteracoes = iteracoes; 
    }
    
    
    public double getFCM() {
        return fcm;
    }
     
    public void setFCM(double fcm) {
        this.fcm = fcm; 
    }
     
    public TipoAtividade getTipo(){
        return tipo; 
    }
    
    public void setTipo(TipoAtividade tipo){
        this.tipo = tipo; 
    }

    
     public Utilizador getUtilizador() {
        return this.utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public LocalDateTime getDataHora(){
      return this.dataHora;
    }
    
    
   
    /*
   
public double calcularCalorias() {
   

    double calorias = 0.0;

  
    switch (this.tipo) {
        case DISTANCIA_ALTIMETRIA:
            
            calorias = 10 * this.tempoGasto; 
            break;
        case DISTANCIA:
          
            calorias = 8 * this.tempoGasto; 
            break;
        case REPETICOES:
            
            calorias = 5 * this.tempoGasto;
            break;
        case REPETICOES_COM_PESOS:
       
            calorias = 7 * this.tempoGasto; 
            break;
    }

       calorias *= this.getUtilizador().calcularFatorMultiplicativo();


    return calorias;
}
*/ 

    
   
   //public abstract double calcularCalorias(Utilizador utilizador);

    @Override
    public String toString(){
        return "{Nome=" + nome +
                ", tipo='" + tipo + '\'' +
                ", Tempo Gasto='" + tempoGasto + '\'' +
                ", fcm='" + fcm + '\'' +
                ", Utilizador=" + utilizador +
                ", iteracoes=" + iteracoes +
                ", data=" + dataHora +
                "}";
    }


   @Override
    public Atividade clone(){
       return new Atividade(this);
   }
  
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    





