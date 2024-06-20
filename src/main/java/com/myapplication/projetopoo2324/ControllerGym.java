package com.myapplication.projetopoo2324;

import com.myapplication.projetopoo2324.Menu;
import com.myapplication.projetopoo2324.Estado;
import com.myapplication.projetopoo2324.GymApplication;
import com.myapplication.projetopoo2324.ControllerUtilizador;
import com.myapplication.projetopoo2324.utilizador.Utilizador;

import java.io.*;

public class ControllerGym {

    public static void run(Estado estado) throws IOException {

        if (estado == null) {
            estado = new Estado();
        }

        GymApplication app = new GymApplication();

        
        app.init(estado);

        while (true) {
            try {
                int opcao = -1;
                while (opcao < 0 || opcao > 9) {
                    opcao = Menu.menuInicial(estado);
                }
                switch (opcao) {
                    case 1:
                        Menu.limpaTerminal();
                        String email = Menu.login();
                        if (estado.existeEmail(email)) {
                            if (estado.login(email)) {
                                Menu.limpaTerminal();
                                Menu.success(16);
                                Menu.pressToContinue();
                                ControllerUtilizador.run(estado, email);
                                estado.escreverLog("Utilizador -> " + estado.getUserLogged().getEmail() + "fez login " + estado.getTempoAtual() + "\n");
                            } else {
                                Menu.limpaTerminal();
                                Menu.errors(23);
                                Menu.pressToContinue();
                            }
                        } else {
                            Menu.limpaTerminal();
                            Menu.errors(23);
                            Menu.pressToContinue();
                        }
                        break;

                    case 2:
                        Menu.limpaTerminal();
                        Utilizador novoUtilizador = Menu.registarNovoUtilizador();
                        if (!estado.existeEmail(novoUtilizador.getEmail())) {
                            estado.addUtilizador(novoUtilizador);
                            System.out.println(novoUtilizador);
                            if (estado.existeEmail(novoUtilizador.getEmail())) {
                                estado.escreverLog(Menu.success(6).replace("\n", " ") + " " + estado.getTempoAtual() + " \n");
                                estado.escreverLog("Novo utilizador -> " + novoUtilizador.getEmail() + " " + estado.getTempoAtual() + "\n");
                                System.out.println(estado.printAllUsers());
                            } else {
                                estado.escreverLog(Menu.errors(20).replace("\n", " ") + " " + estado.getTempoAtual() + " \n");
                            }

                        } else {
                            Menu.limpaTerminal();
                            Menu.errors(1);
                            System.out.println(estado.printAllUsers());
                            Menu.pressToContinue();
                        }
                        break;
                    case 0:
                        Menu.success(15);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Menu.limpaTerminal();
                        System.exit(0);
                        break;

                }

            } catch (java.util.InputMismatchException e) {
                Menu.errors(7);
                Menu.pressToContinue();
            }

        }
    }
}
