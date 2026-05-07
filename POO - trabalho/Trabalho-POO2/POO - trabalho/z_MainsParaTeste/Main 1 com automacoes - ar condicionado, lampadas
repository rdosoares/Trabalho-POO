package Utilizador;

import Dispositivos.*; // Importa todos os dispositivos (Lampada, Rele, Portao, etc.)
import Automacoes.*;
import Sensores.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // LAMPADAS
        AutomacaoLuminosidade autoLuz = new AutomacaoLuminosidade(50.0);
        autoLuz.setAtiva(true);
        Lampada lampadaSala = new Lampada("id:123","LG","L01", "Sala",0.0f);
        Lampada lampadaQuarto = new Lampada("ID:321","SAMSUNG","L02", "Quarto",0.0f);
        
        // AR CONDICIONADO
        AutomacaoArCondicionado autoar = new AutomacaoArCondicionado(5,30);
        autoar.setAtiva(true);
        ArCondicionado condSala = new ArCondicionado("id:234","LG","C01","Sala",0.0f);
        ArCondicionado condQuarto = new ArCondicionado("id:245","LG","C02","Quarto",0.0f);
        
        ArrayList<Dispositivo> dispositivos = new ArrayList<>();
        dispositivos.add(lampadaSala);
        dispositivos.add(lampadaQuarto);
        dispositivos.add(condSala);
        dispositivos.add(condQuarto);

        
        // 3. Criamos um sensor de luz localizado na "Sala"
        // Simulando uma leitura de "10.0 lux" (está escuro!)
        SensorLuz sensorSala = new SensorLuz("S01","LG", "Sala",SensorLuz.Localizacao.INTERNO);
        SensorLuz sensorQuarto = new SensorLuz("S02","LG","Quarto",SensorLuz.Localizacao.INTERNO);
        sensorSala.setLeituraSimulada("10.0 lux");
        sensorQuarto.setLeituraSimulada("100.0 lux");
        
        SensorTemp sensorTsala = new SensorTemp("SO3","LG","Sala");
        SensorTemp sensorTquarto = new SensorTemp("SO4","LG","Quarto");
        sensorTsala.setLeituraSimulada("0.0 ºC");
        sensorTquarto.setLeituraSimulada("40.0 ºC");

        SensorPresenca sensorPsala = new SensorPresenca("S04","LG","Sala");
        SensorPresenca sensorPquarto = new SensorPresenca("S05","LG","Quarto");
        sensorPsala.setLeituraSimulada(true);
        sensorPquarto.setLeituraSimulada(false);

        ArrayList<Sensor> sensoresQuarto = new ArrayList<>();
        sensoresQuarto.add(sensorQuarto);
        sensoresQuarto.add(sensorTquarto);
        sensoresQuarto.add(sensorPquarto);	
        ArrayList<Sensor> sensoresSala = new ArrayList<>();
        sensoresSala.add(sensorSala);
        sensoresSala.add(sensorTsala);
        sensoresSala.add(sensorPsala);
        

        System.out.println("--- Iniciando Simulação ---");
        System.out.println("Status Lampada Sala: " + (lampadaSala.isLigado() ? "Ligada" : "Desligada"));
        System.out.println("Status Lampada Quarto: " + (lampadaSala.isLigado() ? "Ligada" : "Desligada"));
        
        // 4. Executamos a verificação
        autoLuz.verificarExecutar(sensoresSala, dispositivos);
        autoLuz.verificarExecutar(sensoresQuarto, dispositivos);

        // 5. Verificamos os resultados
        System.out.println("\n--- Resultado Final ---");
        System.out.println("Status Lampada Sala: " + (lampadaSala.isLigado() ? "Ligada" : "Desligada"));
        System.out.println("Intensidade Sala: " + lampadaSala.getIntensidade() + "%");
        System.out.println("Status Lampada Quarto: " + (lampadaQuarto.isLigado() ? "Ligada" : "Desligada") + " (Não deve ter mudado)");
   
        
        System.out.println("\n\n\n ---AR CONDICIONADO--- \n\n\n");
        
        System.out.println("--- Iniciando Simulação ---");
        System.out.println("Status Ar condicionado Sala: " + (condSala.isLigado() ? "Ligada" : "Desligado"));
        System.out.println("Status Ar condicionado Quarto: " + (condQuarto.isLigado() ? "Ligada" : "Desligado"));
        
        autoar.verificarExecutar(sensoresSala, dispositivos);
        autoar.verificarExecutar(sensoresQuarto, dispositivos);
        
        System.out.println("\n--- Status Após Automação (Final) ---");
     // Aqui você vê o resultado real nos objetos:
     System.out.println("Ar Sala Final: " + (condSala.isLigado() ? "Ligado" : "Desligado") + " | Temp Final: " + condSala.getTemperatura() + "°C");
     System.out.println("Ar Quarto Final: " + (condQuarto.isLigado() ? "Ligado" : "Desligado") + " | Temp Final: " + condQuarto.getTemperatura() + "°C");
    
    
    
    
    }
}