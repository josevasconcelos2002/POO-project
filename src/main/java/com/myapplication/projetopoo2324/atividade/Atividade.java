package com.myapplication.projetopoo2324.atividade;


import com.myapplication.projetopoo2324.atividade.TipoAtividade;
import com.myapplication.projetopoo2324.utilizador.Utilizador;
import java.io.Serializable;
import java.time.LocalDateTime;

public abstract class Atividade implements Serializable{
    private String nome;
    private TipoAtividade tipo;
    private int iteracoes;
    private LocalDateTime dataHoraRealizacao;
    private long duracao; // em segundos
    private boolean jaRealizada;
    private boolean eHard ;

  public Atividade(String nome, TipoAtividade tipo, long duracao, int iteracoes, LocalDateTime dataHoraRealizacao , LocalDateTime dataHoraAtual, boolean eHard){
        this.nome  = nome ;
        this.tipo = tipo;
        this.iteracoes = iteracoes;
        this.dataHoraRealizacao = dataHoraRealizacao;
        this.duracao = duracao;
        this.eHard = eHard ; 
        this.jaRealizada = atividadeJaRealizada(dataHoraRealizacao, duracao, dataHoraAtual);
  }
  

   public Atividade() {
        this.nome = "";
        this.tipo = null;
        this.iteracoes = 0 ;
        this.dataHoraRealizacao = null;
        this.duracao = 0 ;
        eHard = false;
        jaRealizada = false;
   }
  
  public Atividade(Atividade umaAtividade) {
        this.nome = umaAtividade.getNome(); 
        this.tipo = umaAtividade.getTipo();
        this.iteracoes = umaAtividade.getIteracoes();
        this.dataHoraRealizacao = umaAtividade.getDataHora();
        this.duracao = umaAtividade.getDuracao();
        this.eHard = umaAtividade.eHard();
        this.jaRealizada = umaAtividade.getJaRealizada();
  }

  public boolean getJaRealizada(){
      return this.jaRealizada;
  }

  public void setJaRealizada(boolean jaRealizada){
      this.jaRealizada = jaRealizada;
  }
  
  public boolean eHard() {
        return eHard;
    }

    public void setHard(boolean eHard) {
        this.eHard = eHard;
    }

  
    public void setDuracao(long duracao){
      this.duracao = duracao ; 
  }
  
    public long getDuracao(){
      return this.duracao ; 
  }
  
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

 
    
    public int getIteracoes() {
        return iteracoes;
    }
     
    public void setIteracoes(int iteracoes) {
        this.iteracoes = iteracoes; 
    }
    
    
  
     
    public TipoAtividade getTipo(){
        return tipo; 
    }
    
    public void setTipo(TipoAtividade tipo){
        this.tipo = tipo; 
    }

    

    public LocalDateTime getDataHora(){
      return this.dataHoraRealizacao;
    }
    
    public void setDataHora(LocalDateTime dataHoraRealizacao){
      this.dataHoraRealizacao = dataHoraRealizacao;
    }
    
    
 
    @Override
    public String toString(){
        return "\nAtividade = {" +
                "\nNome = " + getNome() +
                "\nTipo = '" + getTipo()+ '\'' +
                "\nDuracao = '" + getDuracao() +
                "\nIteracoes = " + getIteracoes() +
                "\nData = " + getDataHora() +
                "\njaRealizada = " + getJaRealizada() +
                "\neHard = " + eHard() +
                "\n}\n";
    }


        public abstract double calcularCalorias(Utilizador utilizador);

        

        
public boolean atividadeJaRealizada(LocalDateTime dataHoraRealizacao, long duracao, LocalDateTime tempoAtual){
    LocalDateTime dataHoraResultante = dataHoraRealizacao.plusSeconds(duracao);
    return dataHoraResultante.isBefore(tempoAtual);
}



        
        
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    





