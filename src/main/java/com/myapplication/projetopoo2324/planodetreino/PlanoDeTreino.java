package com.myapplication.projetopoo2324.planodetreino;


import com.myapplication.projetopoo2324.atividade.Atividade;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author tomas
 */


public class PlanoDeTreino {
    private int codigo;
    private String emailUtilizador;
    private String data;
    private List<Atividade> atividades;    // ou ArrayList ?
    

    public PlanoDeTreino(int codigo, String email, String data, List<Atividade> atividades) {
        this.codigo = codigo;
        this.emailUtilizador = email;
        this.data = data;
        this.atividades = atividades;
    }

    public PlanoDeTreino(int codigo, String email, String data) {
        this.codigo = codigo;
        this.emailUtilizador = email;
        this.data = data;
        this.atividades = new ArrayList<>();
    }

 
    public void adicionarAtividade(Atividade atividade) {
        this.atividades.add(atividade);
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

    public int getCodigo(){
        return codigo;
    }

    public void setCodigo(int codigo){
        // apenas fazer set se o codigo nao existir na lista de atividades !
        this.codigo = codigo;
    }

    public String getEmailUtilizador() {
        return emailUtilizador;
    }

    public void setEmailUtilizador(String email){
        // fazer set apenas se for um email valido !
        this.emailUtilizador = email;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }
}
