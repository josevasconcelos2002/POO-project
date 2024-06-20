package com.myapplication.projetopoo2324;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List; 
import com.myapplication.projetopoo2324.utilizador.Utilizador; 
import com.myapplication.projetopoo2324.atividade.Atividade; 
import com.myapplication.projetopoo2324.planodetreino.PlanoDeTreino; 
import java.time.LocalDateTime; 
import java.util.ArrayList; 
import com.myapplication.projetopoo2324.atividade.TipoAtividade; 
import java.util.Map;
import java.util.HashMap;
import com.myapplication.projetopoo2324.GymApplication; 
import com.myapplication.projetopoo2324.ControllerGym;  

/**
 *
 * @author tomas
 */

public class Main {

    public static void main(String [] args) throws IOException {
        Estado estadoInicial = new Estado(); 
        ControllerGym.run(estadoInicial);  // passa o estado inicial 
    }
}
