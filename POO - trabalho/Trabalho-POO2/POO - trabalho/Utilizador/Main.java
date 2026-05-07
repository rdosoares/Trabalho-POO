package Utilizador;

import Dispositivos.*;
import Automacoes.*;
import Sensores.*;
import java.util.Scanner;
import HorasContador.Horario;
import Menu.TextUI;
import Escalonamentos.EscalonamentoHorarioLampada;

public class Main {

    public static void main(String[] args) throws InterruptedException { //Tudo isto serve para testar a correr o menu
        System.out.println("1 - Abrir Menu");
        System.out.println("2 - Correr Simulação");
        System.out.print("Opção: ");

        Scanner sc = new Scanner(System.in);
        int op = Integer.parseInt(sc.nextLine());

        switch (op) {
            case 1 -> new TextUI().run(); //escolher se queremos testar o menu ou a simulação
            case 2 -> correrSimulacao();
        }
    }

    private static void correrSimulacao() throws InterruptedException {
        Horario relogio = new Horario(7, 59, 50, 1.0, 10.0);
        EscalonamentoHorarioLampada gerenciador = new EscalonamentoHorarioLampada(relogio);

        gerenciador.addRegra(8,  0,  "Ligar lâmpada da sala",     () -> System.out.println("    💡 Lâmpada LIGADA"));
        gerenciador.addRegra(8,  30, "Ligar lâmpada do corredor",  () -> System.out.println("    💡 Lâmpada corredor LIGADA"));
        gerenciador.addRegra(9,  0,  "Desligar lâmpada da sala",   () -> System.out.println("    🌙 Lâmpada DESLIGADA"));
        gerenciador.addRegra(22, 0,  "Ligar lâmpada da sala",      () -> System.out.println("    💡 Lâmpada noturna LIGADA"));

        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║     SIMULAÇÃO INICIADA           ║");
        System.out.println("╚══════════════════════════════════╝\n");

        int totalTicks = 400;
        for (int tick = 1; tick <= totalTicks; tick++) {
            relogio.tick();
            gerenciador.verificar();
            if (relogio.getSegundos() == 0) {
                System.out.printf("🕐 %s  (tick %d)%n", relogio, tick);
            }
            Thread.sleep(50);
        }

        System.out.println("\n╔══════════════════════════════════╗");
        System.out.printf ("║  Fim. Total de ticks: %-6d     ║%n", totalTicks);
        System.out.println("╚══════════════════════════════════╝");
    }
}