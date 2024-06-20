package com.myapplication.projetopoo2324;

import java.io.*;

import com.myapplication.projetopoo2324.utilizador.Utilizador;
import com.myapplication.projetopoo2324.atividade.TipoAtividade;
import com.myapplication.projetopoo2324.atividade.Atividade; 
import com.myapplication.projetopoo2324.atividade.tiposdeatividade.Distancia;
import com.myapplication.projetopoo2324.atividade.tiposdeatividade.DistanciaAltimetria; 
import com.myapplication.projetopoo2324.atividade.tiposdeatividade.Repeticoes; 
import com.myapplication.projetopoo2324.atividade.tiposdeatividade.RepeticoesPeso; 
import com.myapplication.projetopoo2324.planodetreino.PlanoDeTreino;  




import java.time.LocalDateTime;
import java.util.*;

import static com.myapplication.projetopoo2324.utilizador.TipoUtilizador.*;

public class GymApplication {

    private static final String INIT_FILE_NAME = "init.txt";

    public GymApplication(){

    }

    public void init(com.myapplication.projetopoo2324.Estado estado) {
        File initFile = new File(INIT_FILE_NAME);

        if (!initFile.exists() || initFile.length() == 0) {
            salvarNoArquivo(estado);
            carregarDoArquivo(estado);
        } else {
            initFile.delete();
            salvarNoArquivo(estado); 
            carregarDoArquivo(estado);
        }
    }



    private void salvarNoArquivo(Estado estado) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(INIT_FILE_NAME))) {
            // Criar utilizadores
            Utilizador utilizador1 = new Utilizador("João", "Rua A", "joao@gmail.com", 80.0, AMADOR);
            Utilizador utilizador2 = new Utilizador("Maria", "Rua B", "maria@gmail.com", 65.0, PROFISSIONAL);
            Utilizador utilizador3 = new Utilizador("Carlos", "Rua C", "carlos@gmail.com", 90.0, PRATICANTE_OCASIONAL);
            Utilizador utilizador4 = new Utilizador("Joaquim", "Rua D", "joaquim@gmail.com", 60.0, PRATICANTE_OCASIONAL);


            ///// PARA ATIVIDADES ISOLADAS 




            Atividade atividade11 = new DistanciaAltimetria("Corrida na Estrada", TipoAtividade.DISTANCIA_ALTIMETRIA, 300, 1, 10.0, 450, LocalDateTime.now().minusDays(1), estado.getTempoAtual(),false);    // atividade isolada do do joao
            //    public DistanciaAltimetria(String nome, TipoAtividade tipo, long duracao, int iteracoes, double distancia, double altimetria, LocalDateTime dataHoraRealizacao, boolean eHard) {

            Atividade atividade12 = new DistanciaAltimetria("Bicicleta de Estrada", TipoAtividade.DISTANCIA_ALTIMETRIA, 350, 1, 8.0, 70, LocalDateTime.now(), estado.getTempoAtual(),false); // atividade isolada da maria

            //     public Repeticoes(String nome, TipoAtividade tipo, long duracao, int iteracoes, int repeticoes, LocalDateTime dataHoraRealizacao , boolean eHard) { 
            Atividade atividade13 = new Repeticoes("Abdominais", TipoAtividade.REPETICOES, 350, 15, 10, LocalDateTime.now(), estado.getTempoAtual(),false); // para carlos

            Atividade atividade14 = new DistanciaAltimetria("Trail no monte", TipoAtividade.DISTANCIA_ALTIMETRIA, 300, 1, 10.0, 450, LocalDateTime.now().minusDays(1), estado.getTempoAtual(),true);    // atividade isolada do do joao

            //      public RepeticoesPeso(String nome, TipoAtividade tipo, long duracao, int iteracoes, int repeticoes,  double peso  , LocalDateTime dataHoraRealizacao ,  boolean eHard) {
            Atividade atividade15 = new RepeticoesPeso("Extensao de pernas", TipoAtividade.REPETICOES_COM_PESOS, 450, 3, 40, 70.0, LocalDateTime.now().minusDays(2), estado.getTempoAtual(),false);

            // Criar atividades isoladas
            Atividade atividade16 = new DistanciaAltimetria("Bicicleta de montanha", TipoAtividade.DISTANCIA_ALTIMETRIA, 700, 1, 10.0, 450, LocalDateTime.now().minusDays(1), estado.getTempoAtual(),true);    // atividade isolada do do joao

            ///// PARA ATIVIDADES ISOLADAS 
            Atividade atividade17 = new Repeticoes("Abdominais", TipoAtividade.REPETICOES, 700, 10, 450, LocalDateTime.now().minusDays(1), estado.getTempoAtual(),false);    // atividade isolada do joaquim 
            Atividade atividade18 = new Repeticoes("Alongamentos", TipoAtividade.REPETICOES, 790, 50, 350, LocalDateTime.now().minusDays(5), estado.getTempoAtual(),false);    // atividade isolada do joaquim 




            ////// ATIVIDADES PARA PLANOS DE TREINO     

            //  public Distancia(String nome, TipoAtividade tipo, long duracao, int iteracoes, double distancia, LocalDateTime dataHoraRealizacao, boolean eHard) {
            Atividade atividade21 = new Distancia("Remo", TipoAtividade.DISTANCIA, 300, 1, 10.0, LocalDateTime.now().minusDays(1), estado.getTempoAtual(),true); // para o joao
            Atividade atividade22 = new Distancia("Corrida na pista de atletismo", TipoAtividade.DISTANCIA, 200, 1, 10.0, LocalDateTime.now().minusDays(1), estado.getTempoAtual(),true);  // para o joao

            //     public Repeticoes(String nome, TipoAtividade tipo, long duracao, int iteracoes, int repeticoes, LocalDateTime dataHoraRealizacao , boolean eHard) {

            Atividade atividade23 = new Repeticoes("Flexoes", TipoAtividade.REPETICOES, 350, 5, 20 , LocalDateTime.now(), estado.getTempoAtual(),false);  // plano da maria


            Atividade atividade24 = new Distancia("Patinagem", TipoAtividade.DISTANCIA, 150, 3, 30, LocalDateTime.now().minusDays(1), estado.getTempoAtual(),false);  // para a maria

            ///////  ATIVIDADES PARA PLANOS DE TREINO  



            // Adicionar atividades isoladas aos users !!!!!!!1
            utilizador1.adicionarAtividade(atividade11);  // adicionar atividade isolada 1 ao utilizador 
            utilizador2.adicionarAtividade(atividade12); // adicionar atividade isolada a maria 
            utilizador3.adicionarAtividade(atividade13 ) ;
            utilizador3.adicionarAtividade(atividade14 ) ;
            utilizador2.adicionarAtividade(atividade15 ) ;
            utilizador3.adicionarAtividade(atividade16 ) ;
             utilizador4.adicionarAtividade(atividade17 ) ;
             utilizador4.adicionarAtividade(atividade18 ) ;


            // Criar planos de treino a partir das atividades associadas a planos de treino  !!!!!!!!!!!!!!
            PlanoDeTreino planoJoao = new PlanoDeTreino("Plano Intenso", LocalDateTime.now(), new ArrayList<>(), utilizador1.getEmail(), "SEGUNDA", 60000);
            planoJoao.adicionarAtividade(atividade21);     // adicionar aqui uma atividade a um plano de treino
            utilizador1.adicionarPlanoDeTreino(planoJoao);

            PlanoDeTreino planoMaria = new PlanoDeTreino("Plano Moderado", LocalDateTime.now(), new ArrayList<>(), utilizador2.getEmail(), "SEGUNDA", 80000);
            planoMaria.adicionarAtividade(atividade23);  // adicionar atividade a plano de treino da maria 
            planoMaria.adicionarAtividade(atividade24);  // adicionar atividade a plano de treino da maria 
            utilizador2.adicionarPlanoDeTreino(planoMaria);



            PlanoDeTreino planoCarlos = new PlanoDeTreino("Plano Moderado", LocalDateTime.now(), new ArrayList<>(), utilizador3.getEmail(), "SEGUNDA", 10000 );

            planoCarlos.adicionarAtividade(atividade22) ;
            utilizador3.adicionarPlanoDeTreino(planoCarlos) ;

            
            PlanoDeTreino planoJoaquim = new PlanoDeTreino("Plano Moderado", LocalDateTime.now(), new ArrayList<>(), utilizador4.getEmail(), "DOMINGO", 10000 );

            
            
            
            // Salvar os objetos no arquivo
            oos.writeObject(utilizador1);
            oos.writeObject(utilizador2);
            oos.writeObject(utilizador3);
            oos.writeObject(utilizador4);
            




            oos.writeObject(planoJoao);
            oos.writeObject(planoMaria);
            oos.writeObject(planoCarlos);
           oos.writeObject(planoJoaquim);
           

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void carregarDoArquivo(com.myapplication.projetopoo2324.Estado estado) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(INIT_FILE_NAME))) {
            Utilizador utilizador1 = (Utilizador) ois.readObject();
            Utilizador utilizador2 = (Utilizador) ois.readObject();


            Utilizador utilizador3 = (Utilizador) ois.readObject();

             Utilizador utilizador4 = (Utilizador) ois.readObject();

            PlanoDeTreino planoJoao = (PlanoDeTreino) ois.readObject();
            PlanoDeTreino planoMaria = (PlanoDeTreino) ois.readObject();


            PlanoDeTreino planoCarlos= (PlanoDeTreino) ois.readObject();
            
            PlanoDeTreino planoJoaquim = (PlanoDeTreino) ois.readObject();


            System.out.println("Informações carregadas do arquivo init.txt:\n");
            System.out.println("Utilizador 1: " + utilizador1);
            System.out.println("Utilizador 2: " + utilizador2);


            System.out.println("Utilizador 3: " + utilizador3);
 System.out.println("Utilizador 4: " + utilizador4);


            System.out.println("Plano de Treino 1: " + planoJoao);
            System.out.println("Plano de Treino 2: " + planoMaria);



            System.out.println("Plano de Treino 3: " + planoCarlos);
            System.out.println("Plano de Treino 4: " + planoJoaquim);


            estado.addUtilizador(utilizador1);
            estado.addUtilizador(utilizador2);


            estado.addUtilizador(utilizador3);
estado.addUtilizador(utilizador4); 

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}