package com.myapplication.projetopoo2324;

import com.myapplication.projetopoo2324.Menu;
import com.myapplication.projetopoo2324.Estado;
import com.myapplication.projetopoo2324.ControllerTempo;
import com.myapplication.projetopoo2324.ControllerCriar;
import java.io.*;

public class ControllerUtilizador {

    public static void run(Estado estado, String email) throws IOException {

        while (true) {
            try {
                int opcao = -1;
                while (opcao < 0 || opcao > 9) {
                    opcao = Menu.menuPrincipal(estado, email);
                }
                switch (opcao) {
                    case 1:
                        Menu.limpaTerminal();
                        ControllerCriar.run(estado, email);
                        break;

                    case 2:
                        Menu.limpaTerminal();
                        ControllerTempo.run(estado);
                        break;

                    case 3:
                        Menu.limpaTerminal();
                        System.out.println("\t\t\t\t\t - LOGS -\n\n" + Menu.printLogs());
                        Menu.pressToContinue();
                        break;

                    case 4:
                        Menu.limpaTerminal();
                        String saveName = Menu.save();
                        System.out.println(saveName);
                        try {
                            estado.guardarEstado(saveName);
                            Menu.success(13);
                        } catch (FileNotFoundException e) {
                            Menu.errors(2);
                            Menu.pressToContinue();
                        } catch (IOException e) {
                            Menu.errors(3);
                            Menu.pressToContinue();
                        }
                        Menu.pressToContinue();
                        break;
                    case 5:
                        Menu.limpaTerminal();
                        String loadName = Menu.load();
                        try {
                            estado.carregaEstado(loadName);
                            Menu.success(14);
                        } catch (FileNotFoundException e) {
                            Menu.errors(2);
                        } catch (IOException e) {
                            Menu.errors(4);
                        } catch (ClassNotFoundException e) {
                            Menu.errors(5);
                        }
                        System.out.println(estado.printAllUsers());
                        Menu.pressToContinue();
                        break;

                    case 6:
                        Menu.limpaTerminal();
                        ControllerEstatistica.run(estado, email);
                        break;

                    case 7:
                        Menu.success(17);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Menu.limpaTerminal();
                        ControllerGym.run(estado);

                        break;
                }
            }
            catch(java.util.InputMismatchException e){
                Menu.errors(7);
                Menu.pressToContinue();
            }
        }
    }
}
