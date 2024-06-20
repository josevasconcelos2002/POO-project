package com.myapplication.projetopoo2324;

import com.myapplication.projetopoo2324.Menu;
import com.myapplication.projetopoo2324.Estado;
import com.myapplication.projetopoo2324.planodetreino.PlanoDeTreino;
import com.myapplication.projetopoo2324.utilizador.Utilizador;
import java.io.*;

public class ControllerCriar {

    public static void run(Estado estado, String email) throws IOException {

        while (true) {
            try {
                int opcao = -1;
                while (opcao < 0 || opcao > 9) {
                    opcao = Menu.menuCriar();
                }
                switch (opcao) {
                    case 1:
                        System.out.println(estado.getUtilizadorByEmail(email));
                        Utilizador utilizador = estado.getUtilizadorByEmail(email);
                        utilizador.registrarAtividadeIsolada(Menu.registarNovaAtividadeIsolada(estado));
                        System.out.println(utilizador.getCaloriasGastas());
                        System.out.println(estado.getUtilizadorByEmail(email));

                        break;
                    case 2:

                        PlanoDeTreino planoDeTreino = Menu.registarNovoPlanoDeTreino(email, estado);
                        System.out.println(planoDeTreino);
                        System.out.println(estado.getUtilizadorByEmail(email));
                        estado.getUtilizadorByEmail(email).adicionarPlanoDeTreino(planoDeTreino);
                        System.out.println(estado.getUtilizadorByEmail(email));
                        break;

                    case 3:
                        String nomeDoPlano = Menu.lerNome1("Digite o nome do Plano para verificar as calorias: ");
                        PlanoDeTreino plano = estado.getUtilizadorByEmail(email).getPlanoDeTreinoByName(nomeDoPlano);
                        if (plano != null) {
                            Utilizador usuarioLogado = estado.getUserLogged();  // Certifique-se de que o usuário está realmente logado
                            if (usuarioLogado != null) {
                                boolean cumpreCalorias = plano.verificarCaloriasPlano(usuarioLogado);
                                System.out.println("O plano " + nomeDoPlano + " " + (cumpreCalorias ? "cumpre" : "não cumpre") + " o mínimo de calorias.");
                            } else {
                                System.out.println("Nenhum usuário está logado.");
                            }
                        } else {
                            System.out.println("Plano de Treino não encontrado.");
                        }
                        break;

                    case 0:
                        Menu.limpaTerminal();
                        ControllerUtilizador.run(estado, email);
                        break;
                }
            } catch (java.util.InputMismatchException e) {
                Menu.errors(7);
                Menu.pressToContinue();
            }
        }
    }
}
