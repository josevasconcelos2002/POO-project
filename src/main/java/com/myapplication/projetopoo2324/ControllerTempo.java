package com.myapplication.projetopoo2324;

import com.myapplication.projetopoo2324.Estado;
import com.myapplication.projetopoo2324.Menu;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDateTime;

public class ControllerTempo {

    // tenta converter a string para LocalDateTime
    public static boolean dataValida(String dataString, LocalDateTime now) {
        LocalDate data = dataConverter(dataString); // supõe que retorna um LocalDate
        return data != null && data.isAfter(now.toLocalDate()); // converte now para LocalDate antes da comparação
    }

    public static LocalDate dataConverter(String dataString) {
        LocalDate data = LocalDate.of(2000, 1, 1);
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            data = LocalDate.parse(dataString, formatter);
        } catch (Exception e) {
            Menu.errors(24);
            Menu.pressToContinue();
            return data;
        }
        return data;
    }

    public static void run(Estado estado) {
        boolean exit = false;
        Scanner input = new Scanner(System.in);
        try {
            while (!exit) {
                int opcao = -1;
                while (opcao < 0 || opcao > 3) {
                    opcao = Menu.menuAvancarTempo(estado);
                }

                switch (opcao) {

                    case 1:
                        Menu.limpaTerminal();
                        estado.setTempoAtual(estado.getTempoAtual().plusDays(1));
                        estado.escreverLog("Data avancou 1 dia. \n");
                        break;

                    case 2:
                        Menu.limpaTerminal();
                        estado.setTempoAtual(estado.getTempoAtual().plusDays(5));
                        estado.escreverLog("Data avancou 5 dias. \n");
                        break;

                    case 3:
                        Menu.limpaTerminal();
                        System.out.println("Digite a nova data no formato AAAA-MM-DD:");
                        String inputData = input.next();
                        LocalDate novaData = LocalDate.parse(inputData);
                        estado.setTempoAtualData(novaData);
                        estado.escreverLog("Data avançou para " + novaData + ". \n");
                        break;

                    case 0:
                        exit = true;
                        Menu.limpaTerminal();
                        break;
                }
            }
        } catch (java.util.InputMismatchException e) {
            Menu.errors(7);
            Menu.pressToContinue();
        }
    }
}
