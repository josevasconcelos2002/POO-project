package com.myapplication.projetopoo2324.utilizador;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.Serializable;
import com.myapplication.projetopoo2324.utilizador.Utilizador;


public class Utilizadores implements Serializable {

    private Map<String, Utilizador> utilizadores;
    // chave-> email valor-> Objeto Utilizador 
    
    
    public Utilizadores(){
        this.utilizadores = new HashMap<String, Utilizador>();
    }
    
    public Utilizadores(Map<String,Utilizador> utilizadores){
        this.setUtilizadores(utilizadores);
    }
    
    public Map<String,Utilizador> getUtilizadores() {
        return this.utilizadores.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a,b) -> a, HashMap::new));
    }

    public void setUtilizadores(Map<String,Utilizador> utilizadores){
        this.utilizadores = utilizadores.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e->e.getValue().clone(), (a,b)->a, HashMap::new));
    }



    public Utilizadores clone(){
        Map<String, Utilizador> clonedUtilizadores = new HashMap<>(this.utilizadores.size());

        for (Map.Entry<String, Utilizador> entry : this.utilizadores.entrySet()) {
            clonedUtilizadores.put(entry.getKey(), entry.getValue().clone());
        }

        return new Utilizadores(clonedUtilizadores);
    }

    

    
   
       public Utilizador getUtilizadorByEmail(String email) {  // retorna Utilizador dando o email 
        return this.utilizadores.get(email.trim().toLowerCase());
    }



    public String stringUtilizadores(){
        StringBuilder sb = new StringBuilder();
        sb.append("Utilizadores: \n");
        for(Utilizador utilizador : utilizadores.values()){
            sb.append("\t").append(utilizador.toString()).append("\n");
        }
        return sb.toString();
    }
    
    // updated 
    public String getUserNameByKey(String email) {  // retorna o nome do utilizador dando o email 
        Utilizador user = getUtilizadorByEmail(email);
        if (user != null) {
            return user.getNome();
        } else {
            return null;
        }
    }
    
    
    
     public String getMoradaByKey(String email) {  // retorna a morada do utilizador dando o email 
        Utilizador user = getUtilizadorByEmail(email);
        if (user != null) {
            return user.getMorada();
        } else {
            return null;
        }
    }  
    
     
    public TipoUtilizador getTipoByKey(String email) {  // retorna o tipo do utilizador dando o email 
        Utilizador user = getUtilizadorByEmail(email);
        if (user != null) {
            return user.getTipo();
        } else {
            return null;
        }
    }  
    

    public boolean existeEmail(String email){   // updated para evitar erros 
    return this.utilizadores.containsKey(email.trim().toLowerCase());
}
    
    

 public void addUtilizador(Utilizador usuario){    
    String emailKey = usuario.getEmail().trim().toLowerCase(); // normalizar o email
    if(!existeEmail(emailKey)) {
        this.utilizadores.put(emailKey, usuario.clone());
        System.out.println("Email do utilizador adicionado: " + emailKey); 
    } else {
        System.out.println("Tentativa de adicionar utilizador falhada");
    }
}
 

  
    public int sizeUtilizadores(){
        return utilizadores.size();
    }
    

    
}
