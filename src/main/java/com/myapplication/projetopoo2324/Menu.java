package com.myapplication.projetopoo2324;

import com.myapplication.projetopoo2324.Estado;
import com.myapplication.projetopoo2324.atividade.Atividade;
import com.myapplication.projetopoo2324.atividade.TipoAtividade;
import com.myapplication.projetopoo2324.atividade.tiposdeatividade.Distancia;
import com.myapplication.projetopoo2324.atividade.tiposdeatividade.DistanciaAltimetria;
import com.myapplication.projetopoo2324.atividade.tiposdeatividade.Repeticoes;
import com.myapplication.projetopoo2324.atividade.tiposdeatividade.RepeticoesPeso;
import com.myapplication.projetopoo2324.planodetreino.PlanoDeTreino;
import com.myapplication.projetopoo2324.planodetreino.diadasemana.DiaDaSemana;
import com.myapplication.projetopoo2324.utilizador.TipoUtilizador;
import com.myapplication.projetopoo2324.utilizador.Utilizador;
import com.myapplication.projetopoo2324.estatisticas.VerEstatisticas;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.*;

import static com.myapplication.projetopoo2324.ControllerTempo.dataValida;

public class Menu {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    private static Scanner input = new Scanner(System.in);

    public static int menuInicial(Estado estado) {
        limpaTerminal();
        Scanner input = new Scanner(System.in);
        int i = -1;
        String sb = "\t\t\t\t\t -MENU INICIAL-  \t\t\t Data atual: " + estado.getTempoAtual() + "\n\n\n"
                + "[1] - Iniciar a sessao.\n"
                + "[2] - Registar utilizador.\n"
                + "[0] - Sair.\n"
                + "\n\nSelecione a opcao pretendida: ";
        System.out.println(sb);
        try {
            i = input.nextInt();
        } catch (java.util.InputMismatchException e) {
            Menu.limpaTerminal();
            Menu.errors(7);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e.printStackTrace();
            }
            Menu.pressToContinue();
        }
        return i;
    }

    public static int menuPrincipal(Estado estado, String email) {
        limpaTerminal();
        Scanner input = new Scanner(System.in);
        int i = -1;
        String sb = "\tNome: " + estado.getUserNameByKey(email) + "\tTipo do utilizador: " + estado.getTipoByKey(email) + "\t\t\t -MENU PRINCIPAL-  \t\t\t Data atual: " + estado.getTempoAtual() + "\n\n\n"
                +
                "[1] - Criar Atividades e Planos de Treino.\n"
                + "[2] - Avancar o tempo.\n"
                + "[3] - Mostrar Logs.\n"
                + "[4] - Guardar estado.\n"
                + "[5] - Carregar estado.\n"
                + "[6] - Estatisticas.\n"

                + "[7] - Voltar ao menu inicial.\n"

                + "\n\nSelecione a opcao pretendida: ";
        System.out.println(sb);
        try {
            i = input.nextInt();
        } catch (java.util.InputMismatchException e) {
            Menu.limpaTerminal();
            Menu.errors(7);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e.printStackTrace();
            }
            Menu.pressToContinue();
        }
        return i;
    }

    public static int menuEstatisticas() {
        limpaTerminal();
        Scanner input = new Scanner(System.in);
        int i = -1;

        String sb
                = "[1] - Utilizador que mais calorias dispensou num dado periodo.\n"
                + "[2] - Utilizador que mais calorias dispensou desde sempre.\n"
                + "[3] - Utilizador que mais atividades realizou num dado periodo.\n"
                + "[4] - Utilizador que mais atividade realizou desde sempre.\n"
                + "[5] - Listar o tipo de atividade mais realizada.\n"
                + "[6] - Quantos quilómetros um utilizador realizou num dado periodo. Por favor, indique o email do utilizador.\n"
                + "[7] - Quantos quilómetros um utilizador realizou desde sempre. Por favor, indique o email do utilizador.\n"
                + "[8] - Quantos metros de altimetria um utilizador totalizou num dado periodo. Por favor, indique o email do utilizador.\n"
                + "[9] - Quantos metros de altimetria um utilizador totalizou desde sempre. Por favor, indique o email do utilizador.\n"
                + "[10] - Listar o plano de treino mais exigente.\n"
                + "[11] - Listar as atividades de um dado utilizador. Por favor, indique o email do utilizador.\n"
                + "[0] - Voltar atras.\n"
                + "\n\nSelecione a opcao pretendida: ";
        System.out.println(sb);
        try {
            i = input.nextInt();
        } catch (java.util.InputMismatchException e) {
            Menu.limpaTerminal();
            Menu.errors(7);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e.printStackTrace();
            }
            Menu.pressToContinue();
        }
        return i;
    }
    
    
    
    
    
    
    
    
    // last 
    public static PlanoDeTreino registarNovoPlanoDeTreino(String email, Estado estado) {
    System.out.println("\t\t\t\t\t -REGISTAR NOVO PLANO DE TREINO-\n\n");
    System.out.println("Introduza os dados pedidos.\n");

    input.nextLine();
    String nomeDoPlano = lerNomeDoPlanoDeTreino("\nNome do Plano: ", email, estado);

    String emailUtilizador = email;
    System.out.println("\nEmail do utilizador: " + emailUtilizador + "\n");

    String recorrencia = lerRecorrenciaPlanoDeTreino("\nRecorrencia do Plano de Treino: ");
    double caloriasMinimas = lerDouble("\nCalorias Mínimas por Sessão: ");
    LocalDateTime dataHora = lerLocalDateTime("Data da realizacao (yyyy-MM-dd HH:mm:ss): ");
    DiaDaSemana diaDaSemanaIntroduzido = diaDaSemana(dataHora);

    while (!contemDiaDaSemana(recorrencia, diaDaSemanaIntroduzido)) {
        System.out.println("Erro! Dia introduzido não faz parte da recorrencia!\n");
        dataHora = lerLocalDateTime("Data da realizacao (yyyy-MM-dd HH:mm:ss): ");
        diaDaSemanaIntroduzido = diaDaSemana(dataHora);
    }

    List<Atividade> atividades = new ArrayList<>();
    while (atividades.size() < 3) {
        Atividade novaAtividade = lerAtividade(estado);
        if (novaAtividade != null) {
            if (novaAtividade.eHard()) {
                long countHard = atividades.stream().filter(Atividade::eHard).count();
                if (countHard >= 1) {
                    System.out.println("Não é possível adicionar mais de uma atividade 'Hard' no mesmo dia.");
                    continue; // Skip adding this hard activity
                }
            }
            atividades.add(novaAtividade);
        }
        if (atividades.size() == 3 || !querAdicionarMaisAtividades()) {
            break;
        }
    }

    System.out.println("\n\n");

    return new PlanoDeTreino(nomeDoPlano, dataHora, atividades, emailUtilizador, recorrencia, caloriasMinimas);
}


 
           
      private static boolean querAdicionarMaisAtividades() {
    System.out.println("Deseja adicionar mais uma atividade? (Sim/Não)");
    String resposta = input.nextLine().trim().toUpperCase();
    return resposta.equals("SIM");
}


 
      public static Atividade lerAtividade(Estado estado) {
    System.out.println("\n- REGISTAR ATIVIDADE PARA PLANO DE TREINO -\n");
    System.out.println("Introduza os dados pedidos.\n");

    String nome = lerNome("\nNome da Atividade: ");

    if (nome.isEmpty()) {
        System.out.println("Nome da atividade não foi lido corretamente. Por favor, tente novamente.");
        return null;  // Saída precoce se o nome não for lido corretamente
    }

    TipoAtividade tipo = lerTipoAtividade("\nTipo de Atividade: ");
    int iteracoes = lerInteiro("\nIteracoes: ");
    LocalDateTime dataHoraRealizacao = lerLocalDateTime("\nData da realizacao (yyyy-MM-dd HH:mm:ss): ");
    long duracao = lerLong("\nDuracao da Atividade (em segundos): ");
    boolean eHard = lerBooleano("\nHard (true || false): ");

    if (eHard && !estado.podeAdicionarAtividadeHard(dataHoraRealizacao.toLocalDate())) {
        System.out.println("Não é possível adicionar uma atividade 'Hard' neste dia ou em dias consecutivos.");
        return null;
    }

    switch (tipo) {
        case DISTANCIA:
            double distancia = lerDouble("\nDistancia: ");
            return new Distancia(nome, tipo, duracao, iteracoes, distancia, dataHoraRealizacao, estado.getTempoAtual(), eHard);
        case DISTANCIA_ALTIMETRIA:
            double distancia1 = lerDouble("\nDistancia: ");
            double altimetria = lerDouble("\nAltimetria: ");
            return new DistanciaAltimetria(nome, tipo, duracao, iteracoes, distancia1, altimetria, dataHoraRealizacao, estado.getTempoAtual(), eHard);
        case REPETICOES:
            int repeticoes = lerInteiro("\nRepeticoes: ");
            return new Repeticoes(nome, tipo, duracao, iteracoes, repeticoes, dataHoraRealizacao, estado.getTempoAtual(), eHard);
        case REPETICOES_COM_PESOS:
            int repeticoes1 = lerInteiro("\nRepeticoes: ");
            double peso = lerDouble("\nPeso: ");
            return new RepeticoesPeso(nome, tipo, duracao, iteracoes, repeticoes1, peso, dataHoraRealizacao, estado.getTempoAtual(), eHard);
        default:
            System.out.println("Tipo de atividade não suportado.");
            return null;
    }
}

    
    private static String lerRecorrenciaPlanoDeTreino(String prompt) {
    System.out.println(prompt);

    while (true) {
        String entrada = input.nextLine().toUpperCase(); 
        String[] dias = entrada.split(",\\s*"); // divide a entrada em substrings usando a vírgula como delimitador

        List<String> diasDaSemana = new ArrayList<>(); 

        boolean todosValidos = true;
        for (String dia : dias) {
            if (ehDiaDaSemanaValido(dia.trim())) {
                diasDaSemana.add(dia.trim());
            } else {
                todosValidos = false;
                break;
            }
        }

        if (todosValidos) {
            return diasDaSemana.toString(); 
        } else {
            System.out.println("Entrada inválida. Por favor, insira apenas dias da semana válidos.\n" +
                               "Opções válidas: SEGUNDA, TERCA, QUARTA, QUINTA, SEXTA, SABADO, DOMINGO\n");
            System.out.println(prompt);
        }
    }
}



    public static int menuAvancarTempo(Estado estado) {
        limpaTerminal();
        int i = -1;
        String sb = "\t\t\t\t\t -MAQUINA DO TEMPO-  \t\t\t Data atual: " + estado.getTempoAtual() + "\n\n\n"
                + "[1] - Avancar 1 dia.\n"
                + "[2] - Avancar 5 dias.\n"
                + "[3] - Avancar para uma determinada data.\n"
                + "[0] - Voltar atras.\n"
                + "\n\nSelecione a opcao pretendida: ";
        System.out.println(sb);
        try {
            i = input.nextInt();
        } catch (java.util.InputMismatchException e) {
            Menu.limpaTerminal();
            Menu.errors(7);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e.printStackTrace();
            }
            Menu.pressToContinue();
        }
        return i;
    }

    public static void menuAvancarData(Estado estado) {
        limpaTerminal();
        String s;
        String sb = "\t\t\t\t\t -MAQUINA DO TEMPO-  \t\t\t Data atual: " + estado.getTempoAtual() + "\n\n\n"
                + "Introduza a data pretendida (YYYY-MM-DD): ";
        System.out.println(sb);
        s = input.nextLine();
        Menu.limpaTerminal();
        if (!dataValida(s, estado.getTempoAtual())) {
            Menu.errors(24);
        } else {
            LocalDateTime data;
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            data = LocalDateTime.parse(s, formatter);
            estado.setTempoAtual(data);
            estado.escreverLog("Data avancou para o dia : " + estado.getTempoAtual() + "\n");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Menu.pressToContinue();
    }


    public static void limpaTerminal() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException ex) {

        }
    }

    public static String login() {
        String resultado = null;
        System.out.println("Introduza o seu email: ");
        try {
            if (input.hasNextLine()) {
                resultado = input.nextLine();
            }
        } catch (java.util.NoSuchElementException e) {
            errors(6);
        }
        return resultado.trim();
    }


    // ----------------------------------QUERIES------------------------------


    public static void firstQuery(Estado estado) { // feita
        System.out.println("\t\t\t\t\t -Número de calorias perdidas pelo utilizador num dado período de tempo-\n\n");
        input.nextLine();
        pressToContinue();

        LocalDateTime inicioPeriodo = lerLocalDateTime("Período inicial (yyyy-MM-dd HH:mm:ss): ");
        LocalDateTime fimPeriodo = lerLocalDateTime("Período final (yyyy-MM-dd HH:mm:ss): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd 'às' HH:mm:ss");
        String formattedDateI = inicioPeriodo.format(formatter);
        String formattedDateF = fimPeriodo.format(formatter);

        double maiorNumeroCalorias = VerEstatisticas.calcularTotalCaloriasDispendidas(estado.getListaDeUtilizadores(), inicioPeriodo, fimPeriodo);
        Utilizador utilizador = VerEstatisticas.encontrarUtilizadorComMaisCalorias(estado.getListaDeUtilizadores(), inicioPeriodo, fimPeriodo);

        if (utilizador != null) {
            System.out.println("O utilizador que mais calorias perdeu entre o dia " + formattedDateI + " e o dia " + formattedDateF + " foi " + utilizador.getNome() + " com um total de " + maiorNumeroCalorias + " calorias perdidas.");
        } else {
            System.out.println("Utilizador nao encontrado");
        }
    }


    public static void fourthQuery(Estado estado) {
        System.out.println("\t\t\t\t\t -Utilizador que mais atividades realizou desde sempre-\n\n");
        input.nextLine();
        pressToContinue();

        Utilizador utilizador = VerEstatisticas.encontrarUtilizadorComMaisAtividadesDesdeSempre(estado.getListaDeUtilizadores());

        if (utilizador != null) {
            System.out.println("Utilizador que mais atividades realizou desde sempre: " + utilizador.getNome() );
        } else {
            System.out.println("Utilizador nao encontrado");
        }
    }

    public static void fifthQuery(Estado estado) { // feita
        System.out.println("\t\t\t\t\t -Tipo de atividade mais realizada-\n\n");
        input.nextLine();
        pressToContinue();

        TipoAtividade tipo = VerEstatisticas.encontrarTipoAtividadeMaisRealizada(estado.getListaDeUtilizadores());
        if (tipo != null) {
            System.out.println("O tipo de atividade mais realizada é: " + tipo);
        } else {
            System.out.println("Atividade não encontrada");
        }

    }

    public static void sixthQuery(Estado estado) { //  quantos kms é que um utilizdor realizou num período ou desde sempre  // feita
        System.out.println("\t\t\t\t\t -Numero de quilómetros percorridos pelo utilizador num dado periodo de tempo-\n\n");
        input.nextLine();
        pressToContinue();

        Utilizador utilizador = lerUtilizadorPorEmail(estado);
        if (utilizador == null) {
            System.out.println("Utilizador nao encontrado");
            return;
        }

        LocalDateTime inicioPeriodo = lerLocalDateTime("Período inicial (yyyy-MM-dd HH:mm:ss): ");
        LocalDateTime fimPeriodo = lerLocalDateTime("Período final (yyyy-MM-dd HH:mm:ss): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd 'às' HH:mm:ss");
        String formattedDateI = inicioPeriodo.format(formatter);
        String formattedDateF = fimPeriodo.format(formatter);

        double total = VerEstatisticas.calcularTotalKms(utilizador, inicioPeriodo, fimPeriodo);

        System.out.println("O utilizador " + utilizador.getNome() + " percorreu entre o dia " + formattedDateI + " e o dia " + formattedDateF + " um total de " + total + " kms");

    }

    public static void seventhQuery(Estado estado) { //
        System.out.println("\t\t\t\t\t -Numero de quilómetros percorridos pelo utilizador desde sempre-\n\n");
        input.nextLine();
        pressToContinue();

        Utilizador utilizador = lerUtilizadorPorEmail(estado);
        if (utilizador == null) {
            System.out.println("Utilizador nao encontrado");
            return;
        }

        double total = VerEstatisticas.calcularTotalKmsDesdeSempre(utilizador);

        if (utilizador != null) {
            System.out.println("O utilizador " + utilizador.getNome() + " percorreu um total de " + total + " kms desde sempre");
        } else {
            System.out.println("Utilizador nao encontrado");
        }

    }

    public static void ninthQuery(Estado estado) { //
        System.out.println("\t\t\t\t\t -Numero de metros de altimetria totalizados pelo utilizador desde sempre-\n\n");
        input.nextLine();
        pressToContinue();

        Utilizador utilizador = lerUtilizadorPorEmail(estado);
        if (utilizador == null) {
            System.out.println("Utilizador nao encontrado");
            return;
        }

        double total = VerEstatisticas.calcularTotalAltimetriaDesdeSempre(utilizador);

        System.out.println("O utilizador " + utilizador.getNome() + " totalizou um total de " + total + " metros de altimetria desde sempre");

    }

    public static void eighthQuery(Estado estado) { //
        System.out.println("\t\t\t\t\t -Número de metros de altimetria totalizados num dado periodo de tempo-\n\n");
        input.nextLine();
        pressToContinue();

        Utilizador utilizador = lerUtilizadorPorEmail(estado);
        if (utilizador == null) {
            System.out.println("Utilizador nao encontrado");
            return;
        }

        LocalDateTime inicioPeriodo = lerLocalDateTime("Período inicial (yyyy-MM-dd HH:mm:ss): ");
        LocalDateTime fimPeriodo = lerLocalDateTime("Período final (yyyy-MM-dd HH:mm:ss): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd 'às' HH:mm:ss");
        String formattedDateI = inicioPeriodo.format(formatter);
        String formattedDateF = fimPeriodo.format(formatter);

        double total = VerEstatisticas.calcularTotalAltimetria(utilizador, inicioPeriodo, fimPeriodo);

        System.out.println("O utilizador " + utilizador.getNome() + " totalizou um total de " + total + " metros de altimetria entre os dias " + formattedDateI + " e o dia " + formattedDateF);

    }

    public static void tenthQuery(Estado estado) {
        System.out.println("\t\t\t\t\t -Plano de treino mais exigente-\n\n");
        input.nextLine();
        pressToContinue();

        PlanoDeTreino planoMaisExigente = VerEstatisticas.encontrarPlanoMaisExigente(estado.getListaDeUtilizadores());
        if (planoMaisExigente != null) {
            Utilizador utilizador = estado.getListaDeUtilizadores().getUtilizadorByEmail(planoMaisExigente.getEmailUtilizador());
            if (utilizador != null) {
                double caloriasPropostas = VerEstatisticas.calcularCaloriasPlano(planoMaisExigente, utilizador);
                String nomeDoPlano = planoMaisExigente.getNomeDoPlano();
                System.out.println("O plano de treino mais exigente em função do dispêndio de calorias proposto é o plano com "
                        + caloriasPropostas + " calorias, feito por " + utilizador.getNome() + " cujo nome é " + nomeDoPlano);
            } else {
                System.out.println("Utilizador associado ao plano de treino mais exigente não encontrado.");
            }
        } else {
            System.out.println("Nenhum plano de treino disponível ou capaz de ser determinado como o mais exigente.");
        }
    }





    public static void secondQuery(Estado estado) { // feita
        System.out.println("\t\t\t\t\t -Número de calorias perdidas pelo utilizador desde sempre-\n\n");
        input.nextLine();
        pressToContinue();

        double maiorNumeroCalorias = VerEstatisticas.calcularTotalCaloriasDispendidasDesdeSempre(estado.getListaDeUtilizadores());

        Utilizador utilizador = VerEstatisticas.encontrarUtilizadorComMaisCaloriasDesdeSempre(estado.getListaDeUtilizadores());

        System.out.println("O utilizador com mais calorias perdidas desde sempre é " + utilizador.getNome() + " com um total de " + maiorNumeroCalorias + " calorias perdidas");

    }

    public static void thirdQuery(Estado estado) { // feita
        System.out.println("\t\t\t\t\t -Utilizador que mais atividade realizou num dado periodo de tempo-\n\n");
        input.nextLine();
        pressToContinue();
        LocalDateTime inicioPeriodo = lerLocalDateTime("Periodo inicial (yyyy-MM-dd HH:mm:ss): ");
        LocalDateTime fimPeriodo = lerLocalDateTime("Periodo final (yyyy-MM-dd HH:mm:ss): ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd  'às' HH:mm:ss");
        String formattedDateI = inicioPeriodo.format(formatter);
        String formattedDateF = fimPeriodo.format(formatter);

        Utilizador utilizador = VerEstatisticas.encontrarUtilizadorComMaisAtividades(estado.getListaDeUtilizadores(), inicioPeriodo, fimPeriodo);

        if (utilizador != null) {
            System.out.println("O utilizador que mais atividades realizou entre o dia " + formattedDateI + " e o dia " + formattedDateF + " foi " + utilizador.getNome());
        } else {
            System.out.println("Nenhum utilizador encontrado ou nenhum dado disponível para o período fornecido.");
        }

    }

    public static void eleventhQuery(Estado estado) {   // feita
        System.out.println("\t\t\t\t\t -Listagem das atividades do utilizador-\n\n");
        input.nextLine();
        pressToContinue();
        Utilizador utilizador = lerUtilizadorPorEmail(estado);
        if (utilizador == null) {
            System.out.println("Utilizador não encontrado!");
            return;
        }

        List<Atividade> atividades = VerEstatisticas.listarAtividades(utilizador);

        System.out.println("Atividades de " + utilizador.getNome() + ":");
        for (Atividade atividade : atividades) {
            System.out.println(atividade);
        }
    }


    // ----------------------------------QUERIES------------------------------


    public static Utilizador lerUtilizadorPorEmail(Estado estado) {
        System.out.println("\nDigite o email do utilizador: ");
        String email = input.nextLine().trim();
        return estado.getUtilizadorByEmail(email);
    }

    public static Utilizador registarNovoUtilizador() {
        System.out.println("\t\t\t\t\t -REGISTAR NOVO UTILIZADOR-\n\n");
        System.out.println("Introduza os dados pedidos.\n");
        String email = lerString("\nEmail: ");
        String nome = lerString("\nNome: ");
        String morada = lerString("\nMorada: ");
        Double fcm = lerDouble("\nFCM: ");
        TipoUtilizador tipo = lerTipoUtilizador("\nTipo de Utilizador: ");

        System.out.println("\n\n");

        return new Utilizador(nome, morada, email, fcm, tipo);
    }

    private static boolean contemDiaDaSemana(String recorrencia, DiaDaSemana diaDaSemanaIntroduzido) {
        recorrencia = recorrencia.replaceAll("\\[|\\]", "");
        List<String> diasDaSemana = Arrays.asList(recorrencia.split("\\s*,\\s*"));
        
        return diasDaSemana.contains(diaDaSemanaIntroduzido.toString());
    }

    
 
    

    public static DiaDaSemana diaDaSemana(LocalDateTime dataHora){
        DayOfWeek diaDaSemana = dataHora.getDayOfWeek();

        String nomeDiaDaSemana = diaDaSemana.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("pt-PT"));

        System.out.println("Dia da semana: " + nomeDiaDaSemana);
        switch(nomeDiaDaSemana.toUpperCase()){
            case "SEGUNDA-FEIRA":
                return DiaDaSemana.SEGUNDA;

            case "TERÇA-FEIRA":
                return DiaDaSemana.TERCA;

            case "QUARTA-FEIRA":
                return DiaDaSemana.QUARTA;

            case "QUINTA-FEIRA":
                return DiaDaSemana.QUINTA;

            case "SEXTA-FEIRA":
                return DiaDaSemana.SEXTA;

            case "SÁBADO":
                return DiaDaSemana.SABADO;

            case "DOMINGO":
                return DiaDaSemana.DOMINGO;

            default:
                return DiaDaSemana.DOMINGO;

        }
    }

 



    public static int menuCriar() {
        limpaTerminal();
        int i = 0;
        String sb = "\t\t\t\t\t -MENU CRIAR-\n\n"
                + "[1] Criar Atividade Isolada.\n"
                + "[2] Criar Plano de Treino.\n"
                + "[3] Minimo de calorias.\n"
                + "[0] Voltar.\n\n"
                + "Selecione a opcao pretendida: ";
        System.out.println(sb);
        try {
            if (input.hasNextInt()) {
                i = input.nextInt();
            }
        } catch (java.util.InputMismatchException e) {
            Menu.errors(7);
        }

        //  limpaTerminal();
        return i;
    }

    public static Atividade registarNovaAtividadeParaPlanoDeTreino(Estado estado, String email, String nomeDoPlano) {
        System.out.println("\t\t\t\t\t -REGISTAR NOVA ATIVIDADE PARA UM PLANO DE TREINO-\n\n");
        System.out.println("Introduza os dados pedidos.\n");

        System.out.println(nomeDoPlano);

        if (estado.getUtilizadorByEmail(email).existePlanoDeTreino(nomeDoPlano)) {
            Menu.success(18);
            Atividade atividade = Menu.registarNovaAtividadeIsolada(estado);
            return atividade;
        } else {
            return null;
        }
    }

    public static Atividade registarNovaAtividadeIsolada(Estado estado) {
        System.out.println("\t\t\t\t\t -REGISTAR NOVA ATIVIDADE ISOLADA-\n\n");
        System.out.println("Introduza os dados pedidos.\n\n");

        input.nextLine();
        String nome = lerNome("\nNome da Atividade: ");

        if (nome.isEmpty()) {
            System.out.println("Nome da atividade não foi lido corretamente. Por favor, tente novamente.");
            return null;  
        }

        TipoAtividade tipo = lerTipoAtividade("\nTipo de Atividade: ");

        int iteracoes = lerInteiro("\nIteracoes: ");
      
        LocalDateTime dataHoraRealizacao = lerLocalDateTime("\nData da realizacao (yyyy-MM-dd HH:mm:ss): ");
        long duracao = lerLong("\nDuracao da Atividade (em segundos): ");
        LocalDateTime dataHoraResultante = dataHoraRealizacao.plusSeconds(duracao);


        LocalDateTime tempoAtual = estado.getTempoAtual();

        boolean jaRealizada = dataHoraResultante.isBefore(tempoAtual);

        switch (tipo) {
            case DISTANCIA:
                double distancia = lerDouble("\nDistancia: ");
                boolean eHard = lerBooleano("\nHard (true || false): ");

                Distancia atividade = new Distancia(nome, tipo, duracao, iteracoes, distancia, dataHoraRealizacao, tempoAtual,eHard ) ;   
                if(jaRealizada) {
                    Utilizador userLogged = estado.getUserLogged();
                    double caloriasGastas = atividade.calcularCalorias(userLogged);

                    estado.getUtilizadorByEmail(userLogged.getEmail()).setCaloriasGastas(userLogged.getCaloriasGastas() + caloriasGastas);
                    userLogged.setCaloriasGastas(userLogged.getCaloriasGastas() + caloriasGastas);
                }
                return atividade;

            case DISTANCIA_ALTIMETRIA:
                double distancia1 = lerDouble("\nDistancia: ");
                double altimetria = lerDouble("\nAltimetria: ");
                boolean eHard1 = nome.toLowerCase().trim().equals("trail no monte") || nome.toLowerCase().trim().equals("bicicleta no monte");

                DistanciaAltimetria atividade1 = new DistanciaAltimetria(nome, tipo, duracao, iteracoes, distancia1, altimetria, dataHoraRealizacao, tempoAtual,eHard1);

                if(atividade1.getJaRealizada()){
                    Utilizador userLogged1 = estado.getUserLogged();
                    double caloriasGastas1 = atividade1.calcularCalorias(userLogged1);

                    estado.getUtilizadorByEmail(userLogged1.getEmail()).setCaloriasGastas(userLogged1.getCaloriasGastas() + caloriasGastas1);
                    userLogged1.setCaloriasGastas(userLogged1.getCaloriasGastas() + caloriasGastas1);
                }
                return atividade1;

            case REPETICOES:
                int repeticoes = lerInteiro("\nRepeticoes: ");
                boolean eHard2 = lerBooleano("\nHard (true || false): ");

                Repeticoes atividade2 = new Repeticoes(nome, tipo, duracao, iteracoes, repeticoes, dataHoraRealizacao, tempoAtual,eHard2);

                if(atividade2.getJaRealizada()) {
                    Utilizador userLogged2 = estado.getUserLogged();
                    double caloriasGastas2 = atividade2.calcularCalorias(userLogged2);

                    estado.getUtilizadorByEmail(userLogged2.getEmail()).setCaloriasGastas(userLogged2.getCaloriasGastas() + caloriasGastas2);
                    userLogged2.setCaloriasGastas(userLogged2.getCaloriasGastas() + caloriasGastas2);
                }
                return atividade2;

            case REPETICOES_COM_PESOS:
                int repeticoes1 = lerInteiro("\nRepeticoes: ");
                double peso = lerDouble("\nPeso: ");
                boolean eHard3 = lerBooleano("\nHard (true || false): ");

                RepeticoesPeso atividade3 = new RepeticoesPeso(nome, tipo, duracao, iteracoes, repeticoes1, peso, dataHoraRealizacao, tempoAtual, eHard3);

                if(atividade3.getJaRealizada()) {
                    Utilizador userLogged3 = estado.getUserLogged();
                    double caloriasGastas3 = atividade3.calcularCalorias(userLogged3);

                    estado.getUtilizadorByEmail(userLogged3.getEmail()).setCaloriasGastas(userLogged3.getCaloriasGastas() + caloriasGastas3);
                    userLogged3.setCaloriasGastas(userLogged3.getCaloriasGastas() + caloriasGastas3);
                }
                return atividade3;

            default:
                return new Distancia();
        }
    }

    private static LocalDateTime lerLocalDateTime(String prompt) {
        System.out.println(prompt);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        while (true) {
            String entrada = input.nextLine();
            try {
                LocalDateTime data = LocalDateTime.parse(entrada, formatter);
                return data;
            } catch (Exception e) {
                Menu.errors(24);
            }
        }
    }


    public static String lerNomeDoPlanoDeTreino(String prompt, String email, Estado estado) {
        System.out.println(prompt);

        while (!input.hasNextLine()) {
            input.nextLine(); 
            System.out.println("Entrada inválida. Digite a String correspondente a um nome.");
            System.out.println(prompt);
        }

        String nome = input.nextLine();

        while (estado.existePlanoDeTreino(email, nome)) {
            Menu.errors(26);
            System.out.println(prompt);
            nome = input.nextLine();
        }

        return nome;
    }

    private static TipoUtilizador lerTipoUtilizador(String prompt) {
        System.out.println(prompt);
        while (true) {
            String entrada = input.nextLine().toUpperCase(); // converte para maiúsculas para evitar erros de entrada
            try {
                TipoUtilizador tipo = TipoUtilizador.valueOf(entrada.trim()); // tenta converter a entrada para um tipo de utilizador
                return tipo;
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo de utilizador inválido. Por favor, digite um tipo válido.\n Opções válidas: AMADOR, PRATICANTE_OCASIONAL, PROFISSIONAL\n");
                System.out.println(prompt);
            }
        }
    }

    
    
    private static boolean ehDiaDaSemanaValido(String dia) {
        boolean resultado = false;
        try {
            DiaDaSemana tipo = DiaDaSemana.valueOf(dia.trim());
            resultado = true;
        } catch (IllegalArgumentException e) {
            System.out.println("\nDia da semana inválido: \n" + dia);
        }
        return resultado;
    }

   
   

    private static TipoAtividade lerTipoAtividade(String prompt) {
        System.out.println(prompt);
        while (true) {
            String entrada = input.nextLine().toUpperCase(); // Converte para maiúsculas para evitar erros de entrada
            try {
                TipoAtividade tipo = TipoAtividade.valueOf(entrada.trim()); // Tenta converter a entrada para um tipo de atividade
                return tipo; // Se for bem-sucedido, retorna o tipo de atividade
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo de atividade inválido. Por favor, digite um tipo válido.\n Opções válidas: DISTANCIA_ALTIMETRIA, DISTANCIA, REPETICOES, REPETICOES_COM_PESOS\n");
                System.out.println(prompt);
            }
        }
    }

  
    private static int lerInteiro(String prompt) {
        System.out.println(prompt);
        while (!input.hasNextInt()) {
            input.nextLine(); 
            System.out.println("Entrada invalida. Digite um numero inteiro.");
            System.out.println(prompt);
        }
        int valor = input.nextInt();
        input.nextLine(); 
        return valor;
    }

    private static long lerLong(String prompt) {
        System.out.println(prompt);
        while (!input.hasNextLong()) {
            input.nextLine(); 
            System.out.println("Entrada invalida. Digite um numero decimal.");
            System.out.println(prompt);
        }
        long valor = input.nextLong();
        input.nextLine(); 
        return valor;
    }

    private static double lerDouble(String prompt) {
        System.out.println(prompt);
        while (!input.hasNextDouble()) {
            input.nextLine(); 
            System.out.println("Entrada invalida. Digite um numero decimal.");
            System.out.println(prompt);
        }
        double valor = input.nextDouble();
        input.nextLine(); 
        return valor;
    }

    public static String lerString(String prompt) {
        System.out.println(prompt);

        while (!input.hasNextLine()) {
            input.nextLine(); 
            System.out.println("Entrada invalida. Digite a String correspondente a uma atividade.");
            System.out.println(prompt);
        }

        String nome = input.nextLine();

        // input.nextLine(); 
        return nome;

    }

    public static String lerNome(String prompt) {
        System.out.println(prompt);

        while (!input.hasNextLine()) {
            input.nextLine(); 
            System.out.println("Entrada invalida. Digite a String correspondente a um nome.");
            System.out.println(prompt);
        }

        String nome = input.nextLine();

        input.nextLine();
        return nome;

    }

    public static String lerNome1(String prompt) {
        System.out.println(prompt);
        input.nextLine();

        while (!input.hasNextLine()) {
            input.nextLine(); 
            System.out.println("Entrada invalida. Digite a String correspondente a um nome.");
            System.out.println(prompt);
        }

        String nome = input.nextLine();

        input.nextLine();
        return nome;

    }

    private static boolean lerBooleano(String prompt) {
        System.out.println(prompt);
        while (!input.hasNextBoolean()) {
            input.nextLine();
            System.out.println("Entrada invalida. Digite 'true' ou 'false'.");
            System.out.println(prompt);
        }
        boolean valor = input.nextBoolean();
        input.nextLine(); 
        return valor;
    }


    public static void pressToContinue() {
        System.out.println("Para continuar pressione qualquer tecla...");
        input.nextLine();
    }

    public static String save() {
        return lerString("Escreve o nome do ficheiro onde vao ser guardados os dados: ");
    }

    public static String load() {
        return lerString("Escreve o nome do ficheiro de onde vao ser carregados os dados: ");
    }

    public static String printLogs() {
        StringBuilder logs = new StringBuilder();
        try {
            FileReader fileReader = new FileReader("logs/logs.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                logs.append(linha).append("\n");
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return logs.toString();
    }

    public static String errors(int i) {
        limpaTerminal();
        StringBuilder sb = new StringBuilder();
        if (i == 1) {
            sb.append(ANSI_RED).append("!!!! Email ja existe !!!!\n").append(ANSI_RESET);
        } else if (i == 2) {
            sb.append(ANSI_RED).append("!!!! Erro a encontrar o ficheiro !!!!\n").append(ANSI_RESET);
        } else if (i == 3) {
            sb.append(ANSI_RED).append("!!!! Nao foi possivel guardar o estado !!!!\n").append(ANSI_RESET);
        } else if (i == 4) {
            sb.append(ANSI_RED).append("!!!! Erro associado a classes !!!!\n").append(ANSI_RESET);
        } else if (i == 5) {
            sb.append(ANSI_RED).append("!!!! Não foi possivel carregar o estado !!!!\n").append(ANSI_RESET);
        } else if (i == 6) {
            sb.append(ANSI_RED).append("!!!! Email nao encontrado !!!!\n").append(ANSI_RESET);
        } else if (i == 7) {
            sb.append(ANSI_RED).append("!!!! Introduza uma opcao valida !!!!\n").append(ANSI_RESET);
        } // Erro ao atualizar
        else if (i == 8) {
            sb.append(ANSI_RED).append("!!!! Erro ao atualizar o NOME !!!!\n").append(ANSI_RESET);
        } else if (i == 9) {
            sb.append(ANSI_RED).append("!!!! Erro ao atualizar a MORADA !!!!\n").append(ANSI_RESET);
        } else if (i == 10) {
            sb.append(ANSI_RED).append("!!!! Erro ao atualizar o email !!!!\n").append(ANSI_RESET);
        } // Erro Estado
        else if (i == 13) {
            sb.append(ANSI_RED).append("!!!! Erro ao salvar estado !!!!\n").append(ANSI_RESET);
        } else if (i == 14) {
            sb.append(ANSI_RED).append("!!!! Erro ao carregar estado !!!!\n").append(ANSI_RESET);
      
        } // Erro ao criar
        else if (i == 19) {
            sb.append(ANSI_RED).append("--Erro ao criar Atividade!--\n").append(ANSI_RESET);
        } else if (i == 20) {
            sb.append(ANSI_RED).append("--Erro ao criar Utilizador!--\n").append(ANSI_RESET);
        } else if (i == 21) {
            sb.append(ANSI_RED).append("--Erro ao criar Plano de Treino!--\n").append(ANSI_RESET);
        } else if (i == 23) {
            sb.append(ANSI_RED).append("--Utilizador com esse email nao existe!--\n").append(ANSI_RESET);
        } else if (i == 24) {
            sb.append(ANSI_RED).append("--Data invalida!--\n").append(ANSI_RESET);
        } else if (i == 25) {
            sb.append(ANSI_RED).append("--Erro ao fazer login!--\n").append(ANSI_RESET);
        }
        else if(i == 26) sb.append(ANSI_RED).append("--O nome do plano já existe!--\n").append(ANSI_RESET);
        System.out.println(sb);
        return sb.toString();
    }

    public static String success(int i) {
        limpaTerminal();
        StringBuilder sb = new StringBuilder();
        // atualizar
        if (i == 1) {
            sb.append(ANSI_GREEN).append("--- NOME atualizado com sucesso! ---\n").append(ANSI_RESET);
        } else if (i == 2) {
            sb.append(ANSI_GREEN).append("--- MORADA atualizado com sucesso! ---\n").append(ANSI_RESET);
        } 
        else if (i == 4) {
            sb.append(ANSI_GREEN).append("--- Alteracoes guardadas com sucesso! ---\n").append(ANSI_RESET);
        } // Criar
        else if (i == 6) {
            sb.append(ANSI_GREEN).append("--Utilizador adicionado com successo!--\n").append(ANSI_RESET);
        } 
        else if (i == 10) {
            sb.append(ANSI_GREEN).append("--Utilizador removido com successo!--\n").append(ANSI_RESET);
        } else if (i == 11) {
            sb.append(ANSI_GREEN).append("--Artigo removido com successo!--\n").append(ANSI_RESET);
        } 
        else if (i == 13) {
            sb.append(ANSI_GREEN).append("--Estado salvo com successo!--\n").append(ANSI_RESET);
        } else if (i == 14) {
            sb.append(ANSI_GREEN).append("--Ficheiro carregado com successo!--\n").append(ANSI_RESET);
        } else if (i == 15) {
            sb.append(ANSI_GREEN).append("\n--Programa terminado com sucesso!--\n").append(ANSI_RESET);
        } else if (i == 17) {
            sb.append(ANSI_GREEN).append("\n--Bem vindo de volta ao menu inicial!--\n").append(ANSI_RESET);
        } // Perfil User
        else if (i == 16) {
            sb.append(ANSI_GREEN).append("\n--Seja bem-vindo!--\n").append(ANSI_RESET);
        } // Plano de Treino
        else if (i == 18) {
            sb.append(ANSI_GREEN).append("\n--Plano de Treino encontrado!--\n").append(ANSI_RESET);
        }
        System.out.println(sb);
        return sb.toString();
    }
}
