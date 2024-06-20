package com.myapplication.projetopoo2324.utilizador;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import com.myapplication.projetopoo2324.utilizador.Utilizador;


public class Utilizadores {

    private Map<String, Utilizador> utilizadores;
    
    
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


    public Utilizador getUtilizadorByEmail(String email){
        if (this.utilizadores.containsKey(email))
            return this.utilizadores.get(email);
        return null;
    }



    public String getUserNameByKey(String email){
        return getUtilizadorByEmail(email).getNome();
    }

    public boolean existeEmail(String email){
        return this.utilizadores.containsKey(email);
    }

    public void addUtilizador(Utilizador us){
        this.utilizadores.put(us.getEmail(), us.clone());
    }
    public void removeUtilizador(Utilizador u){
        if(existeEmail(u.getEmail()))
            this.utilizadores.remove(u.getEmail());
    }

    public int sizeUtilizadores(){
        return utilizadores.size();
    }
}
