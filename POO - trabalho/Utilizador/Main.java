package Utilizador;

import Dispositivos.*; // Importa todos os dispositivos (Lampada, Rele, Portao, etc.)
import Automacoes.*;
import Sensores.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // 1. Criamos a automação com um limiar de 50.0 lux
        // Se a leitura for menor que 50, as luzes devem acender.
        AutomacaoLuminosidade autoLuz = new AutomacaoLuminosidade(50.0);
        autoLuz.setAtiva(true);

        // 2. Criamos dispositivos para diferentes cômodos
        Lampada lampadaSala = new Lampada("id:123","LG","L01", "Sala",0.0f);
        Lampada lampadaQuarto = new Lampada("ID:321","SAMSUNG","L02", "Quarto",0.0f);
        
        ArrayList<Dispositivo> dispositivos = new ArrayList<>();
        dispositivos.add(lampadaSala);
        dispositivos.add(lampadaQuarto);

        // 3. Criamos um sensor de luz localizado na "Sala"
        // Simulando uma leitura de "10.0 lux" (está escuro!)
        SensorLuz sensorSala = new SensorLuz("S01","LG", "Sala",SensorLuz.Localizacao.INTERNO);
        sensorSala.setLeituraSimulada("10.0 lux"); 

        System.out.println("--- Iniciando Simulação ---");
        System.out.println("Status inicial Lampada Sala: " + (lampadaSala.isLigado() ? "Ligada" : "Desligada"));

        // 4. Executamos a verificação
        autoLuz.verificarExecutar(sensorSala, dispositivos);

        // 5. Verificamos os resultados
        System.out.println("\n--- Resultado Final ---");
        System.out.println("Status Lampada Sala: " + (lampadaSala.isLigado() ? "Ligada" : "Desligada"));
        System.out.println("Intensidade Sala: " + lampadaSala.getIntensidade() + "%");
        System.out.println("Status Lampada Quarto: " + (lampadaQuarto.isLigado() ? "Ligada" : "Desligada") + " (Não deve ter mudado)");
    }
}