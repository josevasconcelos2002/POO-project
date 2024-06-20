package com.myapplication.projetopoo2324.estatisticas;

import com.myapplication.projetopoo2324.atividade.TipoAtividade; 
import java.util.HashMap; 
import com.myapplication.projetopoo2324.utilizador.Utilizadores;
import com.myapplication.projetopoo2324.utilizador.Utilizador;
import com.myapplication.projetopoo2324.atividade.Atividade;
import java.time.LocalDate; 
import java.time.LocalDateTime ; 
import java.util.List; 
import java.util.ArrayList ;
import java.util.Map;

import com.myapplication.projetopoo2324.planodetreino.PlanoDeTreino; 
import com.myapplication.projetopoo2324.atividade.tiposdeatividade.DistanciaAltimetria ; 
import com.myapplication.projetopoo2324.atividade.tiposdeatividade.Distancia;



public class VerEstatisticas {
    
    
    
    // 3.2.1 
     
 
    public static double calcularTotalCaloriasDispendidas(Utilizadores utilizadores, LocalDateTime inicioPeriodo, LocalDateTime fimPeriodo) {
        double totalCalorias = 0.0;

        for (Utilizador utilizador : utilizadores.getUtilizadores().values()) {
            for (PlanoDeTreino plano : utilizador.getPlanosDeTreino()) {
                for (Atividade atividade : plano.getAtividades()) {
                    LocalDateTime dataHoraAtividade = atividade.getDataHora();
                    if (dataHoraAtividade.isAfter(inicioPeriodo) && dataHoraAtividade.isBefore(fimPeriodo)) {
                        totalCalorias += atividade.calcularCalorias(utilizador);
                    }
                }
            }
        }

        for (Utilizador utilizador : utilizadores.getUtilizadores().values()) {

            List<Atividade> listaIsoladas = listarAtividadesIsoladas(utilizador);

            if (listaIsoladas != null) {
                for (Atividade atividadeIsolada : listaIsoladas) {
                    LocalDateTime dataHoraAtividade = atividadeIsolada.getDataHora();

                    if (dataHoraAtividade.isAfter(inicioPeriodo) && dataHoraAtividade.isBefore(fimPeriodo)) {

                        totalCalorias += atividadeIsolada.calcularCalorias(utilizador);
                    }
                }
            }

        }

        return totalCalorias; // feita 
    }

    
   
     
    public static double calcularTotalCaloriasDispendidasDesdeSempre(Utilizadores utilizadores) { /// feita 
        double totalCalorias = 0.0;

        for (Utilizador utilizador : utilizadores.getUtilizadores().values()) {
            for (PlanoDeTreino plano : utilizador.getPlanosDeTreino()) {
                for (Atividade atividade : plano.getAtividades()) {
                    totalCalorias += atividade.calcularCalorias(utilizador);
                }
            }
        }

        for (Utilizador utilizador : utilizadores.getUtilizadores().values()) {

            List<Atividade> listaIsoladas = listarAtividadesIsoladas(utilizador);

            if (listaIsoladas != null) {

                for (Atividade atividadeIsolada : listaIsoladas) {
                    totalCalorias += atividadeIsolada.calcularCalorias(utilizador);
                }

            }

        }


        
        return totalCalorias;
    }
       
       
        public static Utilizador encontrarUtilizadorComMaisCalorias(Utilizadores utilizadores, LocalDateTime inicioPeriodo, LocalDateTime fimPeriodo) {
        Utilizador utilizadorComMaisCalorias = null;
        double maxCalorias = Double.MIN_VALUE;

        for (Utilizador utilizador : utilizadores.getUtilizadores().values()) {
            double totalCalorias = calcularTotalCaloriasDispendidas(utilizadores, inicioPeriodo, fimPeriodo);
            if (totalCalorias > maxCalorias) {
                maxCalorias = totalCalorias;
                utilizadorComMaisCalorias = utilizador;
            }
        }

        return utilizadorComMaisCalorias;
    }

        
        
           public static Utilizador encontrarUtilizadorComMaisCaloriasDesdeSempre(Utilizadores utilizadores) {
        Utilizador utilizadorComMaisCalorias = null;
        double maxCalorias = Double.MIN_VALUE;

        for (Utilizador utilizador : utilizadores.getUtilizadores().values()) {
            double totalCalorias = calcularTotalCaloriasDispendidasDesdeSempre(utilizadores);
            if (totalCalorias > maxCalorias) {
                maxCalorias = totalCalorias;
                utilizadorComMaisCalorias = utilizador;
            }
        }

        return utilizadorComMaisCalorias;
    }  
  
    
    // 3.2.2 
    
    
    
    public static Utilizador encontrarUtilizadorComMaisAtividades(Utilizadores utilizadores, LocalDateTime inicioPeriodo, LocalDateTime fimPeriodo) { // 
        Utilizador utilizadorComMaisAtividades = null;
        int maxAtividades = Integer.MIN_VALUE;

        for (Utilizador utilizador : utilizadores.getUtilizadores().values()) {
            int totalAtividades = calcularTotalAtividadesRealizadas(utilizador, inicioPeriodo, fimPeriodo);
            if (totalAtividades > maxAtividades) {
                maxAtividades = totalAtividades;
                utilizadorComMaisAtividades = utilizador;
            }
        }

        return utilizadorComMaisAtividades;
    }


    public static int calcularTotalAtividadesRealizadas(Utilizador utilizador, LocalDateTime inicioPeriodo, LocalDateTime fimPeriodo) {  // feita 
        int totalAtividades = 0;
        for (PlanoDeTreino plano : utilizador.getPlanosDeTreino()) {
            for (Atividade atividade : plano.getAtividades()) {
                LocalDateTime dataHoraAtividade = atividade.getDataHora();
                if (dataHoraAtividade.isAfter(inicioPeriodo) && dataHoraAtividade.isBefore(fimPeriodo)) {
                    totalAtividades++;
                }
            }
        }

        List<Atividade> listaIsoladas = listarAtividadesIsoladas(utilizador);

        if (listaIsoladas != null) {
            for (Atividade atividade : listaIsoladas) {

                LocalDateTime dataHoraAtividade = atividade.getDataHora();
                if (dataHoraAtividade.isAfter(inicioPeriodo) && dataHoraAtividade.isBefore(fimPeriodo)) {
                    totalAtividades++;
                }

            }
        }


        
        return totalAtividades;
    }


    public static Utilizador encontrarUtilizadorComMaisAtividadesDesdeSempre(Utilizadores utilizadores) {  // feita 
        Utilizador utilizadorComMaisAtividades = null;
        int maxAtividades = Integer.MIN_VALUE;

        for (Utilizador utilizador : utilizadores.getUtilizadores().values()) {
            int totalAtividades = calcularTotalAtividadesRealizadasDesdeSempre(utilizador);
            if (totalAtividades > maxAtividades) {
                maxAtividades = totalAtividades;
                utilizadorComMaisAtividades = utilizador;
            }
        }

        return utilizadorComMaisAtividades;
    }

    public static int calcularTotalAtividadesRealizadasDesdeSempre(Utilizador utilizador) { // 
        int totalAtividades = 0;
        for (PlanoDeTreino plano : utilizador.getPlanosDeTreino()) {
            totalAtividades += plano.getAtividades().size();
        }

        List<Atividade> listaIsoladas = listarAtividadesIsoladas(utilizador);

        if (listaIsoladas != null) {
            for (Atividade atividade : listaIsoladas) {
                totalAtividades++;
            }

        }

        return totalAtividades;
    }


    
    // 3.2.3 
    
public static TipoAtividade encontrarTipoAtividadeMaisRealizada(Utilizadores utilizadores) {
    Map<TipoAtividade, Integer> contagemAtividadesPorTipo = new HashMap<>();

    for (Utilizador utilizador : utilizadores.getUtilizadores().values()) {
        for (PlanoDeTreino plano : utilizador.getPlanosDeTreino()) {
            for (Atividade atividade : plano.getAtividades()) {
                incrementarContagem(contagemAtividadesPorTipo, atividade.getTipo());
            }
        }

        for (Atividade atividadeIsolada : listarAtividadesIsoladas(utilizador)) {
            incrementarContagem(contagemAtividadesPorTipo, atividadeIsolada.getTipo());
        }
    }

    return contagemAtividadesPorTipo.entrySet().stream()
                                    .max(Map.Entry.comparingByValue())
                                    .map(Map.Entry::getKey)
                                    .orElse(null);
}


private static void incrementarContagem(Map<TipoAtividade, Integer> mapa, TipoAtividade tipo) {
    mapa.put(tipo, mapa.getOrDefault(tipo, 0) + 1);
}


    
    // 3.2.4 
    

    public static double calcularTotalKmsDesdeSempre(Utilizador utilizador ){
        
       double total = 0 ;  
       
       for ( PlanoDeTreino plano : utilizador.getPlanosDeTreino() ){
           
           for (Atividade atividade : plano.getAtividades() ) {
               if ( atividade instanceof Distancia ) {
                   Distancia atividadeDistancia = (Distancia) atividade ; 
                   total += atividadeDistancia.getDistancia(); 
                   
               }
               
               else if (atividade instanceof DistanciaAltimetria ) {
                   DistanciaAltimetria atividadeDistanciaAltimetria  = (DistanciaAltimetria) atividade; 
                   total+= atividadeDistanciaAltimetria.getDistancia(); 
               }
           }
           
           
       }  
       
       
 List<Atividade> listaIsoladas = listarAtividadesIsoladas(utilizador);

        if (listaIsoladas != null) {

            for (Atividade atividadeIsolada : listaIsoladas) {
                  if ( atividadeIsolada instanceof Distancia ) {
                   Distancia atividadeDistancia = (Distancia) atividadeIsolada ; 
                   total += atividadeDistancia.getDistancia(); 
                   
               }
               
               else if (atividadeIsolada instanceof DistanciaAltimetria ) {
                   DistanciaAltimetria atividadeDistanciaAltimetria  = (DistanciaAltimetria) atividadeIsolada; 
                   total+= atividadeDistanciaAltimetria.getDistancia(); 
               }
            }

        }


       
       return total ; 
    }
    
    
    
    
    
      public static double calcularTotalKms(Utilizador utilizador, LocalDateTime inicioPeriodo, LocalDateTime fimPeriodo) {
        double total = 0;

        for (PlanoDeTreino plano : utilizador.getPlanosDeTreino()) {
            for (Atividade atividade : plano.getAtividades()) {
                if (atividade instanceof Distancia || atividade instanceof DistanciaAltimetria) {
                    LocalDateTime dataAtividade = atividade.getDataHora();
                    if (dataAtividade.isAfter(inicioPeriodo) || dataAtividade.isEqual(inicioPeriodo)) {
                        if (dataAtividade.isBefore(fimPeriodo) || dataAtividade.isEqual(fimPeriodo)) {
                            if (atividade instanceof Distancia) {
                                Distancia atividadeDistancia = (Distancia) atividade;
                                total += atividadeDistancia.getDistancia();
                             
                            } else if (atividade instanceof DistanciaAltimetria) {
                                DistanciaAltimetria atividadeDistanciaAltimetria = (DistanciaAltimetria) atividade;
                                total += atividadeDistanciaAltimetria.getDistancia();
                            }
                        }
                    }
                }
            }
        }
        
        
        // feita 
        List<Atividade> listaIsoladas = listarAtividadesIsoladas(utilizador);

        if (listaIsoladas != null) {

            for (Atividade atividadeIsolada : listaIsoladas) {
                if (atividadeIsolada instanceof Distancia) {

                    LocalDateTime dataAtividade = atividadeIsolada.getDataHora();
                    if (dataAtividade.isAfter(inicioPeriodo) || dataAtividade.isEqual(inicioPeriodo)) {
                        if (dataAtividade.isBefore(fimPeriodo) || dataAtividade.isEqual(fimPeriodo)) {
                            Distancia atividadeDistancia = (Distancia) atividadeIsolada;
                            total += atividadeDistancia.getDistancia();

                        }
                    }

                } else if (atividadeIsolada instanceof DistanciaAltimetria) {

                    LocalDateTime dataAtividade = atividadeIsolada.getDataHora();
                    if (dataAtividade.isAfter(inicioPeriodo) || dataAtividade.isEqual(inicioPeriodo)) {
                        if (dataAtividade.isBefore(fimPeriodo) || dataAtividade.isEqual(fimPeriodo)) {

                            DistanciaAltimetria atividadeDistanciaAltimetria = (DistanciaAltimetria) atividadeIsolada;
                            total += atividadeDistanciaAltimetria.getDistancia();
                        }
                    }
                }
            }

        }

        return total;
    }


    
    
    // 3.2.5 
    
    
    public static double calcularTotalAltimetriaDesdeSempre(Utilizador utilizador) {
        double totalAltimetria = 0.0;

        for (PlanoDeTreino plano : utilizador.getPlanosDeTreino()) {
            for (Atividade atividade : plano.getAtividades()) {

                if (atividade instanceof DistanciaAltimetria) {
                    DistanciaAltimetria atividadeDistanciaAltimetria = (DistanciaAltimetria) atividade;
                    totalAltimetria += atividadeDistanciaAltimetria.getAltimetria();
                }
            }
        }
        
        
        
        
        List<Atividade> listaIsoladas = listarAtividadesIsoladas(utilizador);

        if (listaIsoladas != null) {

            for (Atividade atividadeIsolada : listaIsoladas) {

                if (atividadeIsolada instanceof DistanciaAltimetria) {
                    DistanciaAltimetria atividadeDistanciaAltimetria = (DistanciaAltimetria) atividadeIsolada;
                    totalAltimetria += atividadeDistanciaAltimetria.getDistancia();
                }
            }

        }

        return totalAltimetria;  // feita 
    }

      
      
     public static double calcularTotalAltimetria(Utilizador utilizador, LocalDateTime inicioPeriodo, LocalDateTime fimPeriodo) {
        double totalAltimetria = 0.0;

        for (PlanoDeTreino plano : utilizador.getPlanosDeTreino()) {
            for (Atividade atividade : plano.getAtividades()) {
                if (atividade instanceof DistanciaAltimetria) {

                    LocalDateTime dataAtividade = atividade.getDataHora();
                    if (dataAtividade.isAfter(inicioPeriodo) || dataAtividade.isEqual(inicioPeriodo)) {
                        if (dataAtividade.isBefore(fimPeriodo) || dataAtividade.isEqual(fimPeriodo)) {
                          
                                DistanciaAltimetria atividadeDistanciaAltimetria = (DistanciaAltimetria) atividade;
                                totalAltimetria += atividadeDistanciaAltimetria.getAltimetria();
                            
                        }
                    }
                }
            }
        }
        
        
        
        
        
        
         List<Atividade> listaIsoladas = listarAtividadesIsoladas(utilizador);

         if (listaIsoladas != null) {

             for (Atividade atividadeIsolada : listaIsoladas) {

                 if (atividadeIsolada instanceof DistanciaAltimetria) {

                     LocalDateTime dataAtividade = atividadeIsolada.getDataHora();
                     if (dataAtividade.isAfter(inicioPeriodo) || dataAtividade.isEqual(inicioPeriodo)) {
                         if (dataAtividade.isBefore(fimPeriodo) || dataAtividade.isEqual(fimPeriodo)) {

                             DistanciaAltimetria atividadeDistanciaAltimetria = (DistanciaAltimetria) atividadeIsolada;
                             totalAltimetria += atividadeDistanciaAltimetria.getDistancia();
                         }
                     }

                 }

             }   // feita 
         }
        

        return totalAltimetria;
    }



    // 3.2.6 up 
    
    
    
    public static PlanoDeTreino encontrarPlanoMaisExigente(Utilizadores utilizadores) {
        Map<PlanoDeTreino, Double> dispendidoPorPlano = new HashMap<>();

        for (Utilizador utilizador : utilizadores.getUtilizadores().values()) {
            for (PlanoDeTreino plano : utilizador.getPlanosDeTreino()) {
                double caloriasPropostas = calcularCaloriasPlano(plano, utilizador);
                dispendidoPorPlano.put(plano, caloriasPropostas);
            }
        }

        PlanoDeTreino planoMaisExigente = null;
        double maxCaloriasPropostas = Double.MIN_VALUE;
        for (Map.Entry<PlanoDeTreino, Double> entry : dispendidoPorPlano.entrySet()) {
            if (entry.getValue() > maxCaloriasPropostas) {
                maxCaloriasPropostas = entry.getValue();
                planoMaisExigente = entry.getKey();
            }
        }

        return planoMaisExigente;
    }
    

    public static double calcularCaloriasPlano(PlanoDeTreino plano, Utilizador utilizador ) { 
        double caloriasPlano = 0.0;
        for (Atividade atividade : plano.getAtividades()) {
            caloriasPlano += atividade.calcularCalorias(utilizador);
        }
        return caloriasPlano;
    }
    
    
   
    
    
    
    
    // 3.2.7 
   
    
    // 
       public static List<Atividade> listarAtividadesIsoladas(Utilizador utilizador) {  // feita 
        return new ArrayList<>( utilizador.getAtividadesIsoladas() );
    }
   
   // 
   
    public static List<Atividade> listarAtividades(Utilizador utilizador ) {  // feita 
        List<Atividade> todasAtividades = new ArrayList<>();

     
        
        
       if (utilizador.getPlanosDeTreino() != null) {
        for (PlanoDeTreino plano : utilizador.getPlanosDeTreino()) {
            if (plano.getAtividades() != null) {
                todasAtividades.addAll(plano.getAtividades());
            }
        }
    }

    if (utilizador.getAtividadesIsoladas() != null) {
        todasAtividades.addAll(utilizador.getAtividadesIsoladas());
    }

    
    
        return todasAtividades;
    }
    
    
    
}
