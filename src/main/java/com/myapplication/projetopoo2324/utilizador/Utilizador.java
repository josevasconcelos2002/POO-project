package com.myapplication.projetopoo2324.utilizador;

import java.util.Objects;
import java.util.UUID;
import com.myapplication.projetopoo2324.utilizador.TipoUtilizador;

/**
 *
 * @author tomas
 */


public class Utilizador {
    private UUID codigo;
    private String nome;
    private String morada;
    private String email;
    private double fcm;
    private TipoUtilizador tipo;

    
    
     public Utilizador(UUID codigo, String nome, String morada, String email, double fcm, TipoUtilizador tipo) {
        this.codigo = codigo;
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.fcm = fcm;
        this.tipo = tipo;
    }

    public Utilizador(String nome, String morada, String email, double fcm, TipoUtilizador tipo) {
        this.codigo = UUID.randomUUID();
        this.nome = nome;
        this.morada = morada;
        this.email = email;
        this.fcm = fcm;
        this.tipo = tipo;
    }
    
     

    public Utilizador() {
        this.codigo = UUID.randomUUID();
        this.nome = ""; 
        this.morada = ""; 
        this.email = ""; 
        this.fcm = 60; 
        this.tipo = null; 
    }
    
    
     public Utilizador(Utilizador umUtilizador) {
        this.codigo = umUtilizador.getCodigo(); 
        this.nome = umUtilizador.getNome(); 
        this.morada = umUtilizador.getMorada(); 
        this.email = umUtilizador.getEmail(); 
        this.fcm = umUtilizador.getFCM(); 
        this.tipo = umUtilizador.getTipo(); 
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
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
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
    
    
    
    
    
    
    // indico aqui a funçao como abstrata? 
    //public abstract double calcularFatorMultiplicativo();


    @Override
    public String toString() {
        return "{Codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", morada='" + morada + '\'' +
                ", email='" + email + '\'' +
                ", fcm=" + fcm +
                ", tipo=" + tipo +
                "}";
    }



    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Utilizador utilizador = (Utilizador) o;
        return codigo == utilizador.codigo
                && Objects.equals(nome, utilizador.nome) && Objects.equals(morada, utilizador.morada)
                && Objects.equals(email, utilizador.email) && Double.compare(fcm, utilizador.fcm) == 0
                && tipo == utilizador.tipo;
    }
    
    @Override
    public Utilizador clone(){
        return new Utilizador(this);
    }
    
}

