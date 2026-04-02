package Utilizador;

import Dispositivos.*; // Importa todos os dispositivos (Lampada, Rele, Portao, etc.)
import Automacoes.*;
import Sensores.*;
import java.util.ArrayList;
import HorasContador.Horario;
import Escalonamentos.EscalonamentoHorarioLampada;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        // === CONFIGURAÇÃO DO RELÓGIO ===
        // Começa às 07:59:50 — assim em 10 ticks já chega em 08:00:00
        // 1 tick = 1 segundo, velocidade 10x
        Horario relogio = new Horario(7, 59, 50, 1.0, 10.0);

        // === GERENCIADOR DE REGRAS ===
        EscalonamentoHorarioLampada gerenciador = new EscalonamentoHorarioLampada(relogio);

        // === CADASTRO DAS REGRAS ===
        gerenciador.addRegra(8,  0,  "Ligar lâmpada da sala",      () -> System.out.println("    💡 Lâmpada LIGADA"));
        gerenciador.addRegra(8,  30, "Ligar lâmpada do corredor",   () -> System.out.println("    💡 Lâmpada corredor LIGADA"));
        gerenciador.addRegra(9,  0,  "Desligar lâmpada da sala",    () -> System.out.println("    🌙 Lâmpada DESLIGADA"));
        gerenciador.addRegra(22, 0,  "Ligar lâmpada da sala",       () -> System.out.println("    💡 Lâmpada noturna LIGADA"));

        // === LOOP DA SIMULAÇÃO ===
        System.out.println("╔══════════════════════════════════╗");
        System.out.println("║     SIMULAÇÃO INICIADA           ║");
        System.out.println("╚══════════════════════════════════╝\n");

        int totalTicks = 400; // simula ~400 ticks

        for (int tick = 1; tick <= totalTicks; tick++) {
            relogio.tick();
            gerenciador.verificar();

            // Imprime o horário a cada virada de minuto (segundo == 0)
            if (relogio.getSegundos() == 0) {
                System.out.printf("🕐 %s  (tick %d)%n", relogio, tick);
            }

            // Pausa real de 50ms para não voar no console
            Thread.sleep(50);
        }

        System.out.println("\n╔══════════════════════════════════╗");
        System.out.printf ("║  Fim. Total de ticks: %-6d     ║%n", totalTicks);
        System.out.println("╚══════════════════════════════════╝");
    }
}