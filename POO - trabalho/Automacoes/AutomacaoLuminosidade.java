package Automacoes;

import Sensores.Sensor;
import Sensores.SensorLuz;
import Dispositivos.Dispositivo;
import Dispositivos.Lampada;
import java.util.List;

public class AutomacaoLuminosidade extends Automacao {
    private double limiarMinimo;

    public AutomacaoLuminosidade(double limiarMinimo) {
        super("Controle de Luz por Cômodo");
        this.limiarMinimo = limiarMinimo;
    }

    @Override
    public void verificarExecutar(Sensor sensor, List<Dispositivo> dispositivos) {
        if (!ativa) return;

        // Verifica se o sensor é do tipo correto
        if (sensor instanceof SensorLuz) {
            SensorLuz sLuz = (SensorLuz) sensor;
            
            // Extraímos o valor numérico (lux) da String retornada pelo lerDado
            double leituraAtual = Double.parseDouble(sLuz.lerDado().split(" ")[0]);

            if (leituraAtual < limiarMinimo) {
                String localDoSensor = sLuz.getLocal(); // Novo método da classe Sensor
                
                System.out.println("Luz baixa detectada em: " + localDoSensor);

                // Filtra dispositivos: deve ser Lâmpada E estar no mesmo local
                for (Dispositivo d : dispositivos) {
                    if (d instanceof Lampada && d.getLocalDivisao().equalsIgnoreCase(localDoSensor)) {
                        Lampada l = (Lampada) d;
                        
                        if (!l.isLigado()) {
                            l.ligar();
                        }
                        l.setIntensidade(100);
                        l.setTemperaturaCor(2700);
                        
                        System.out.println("Ação: Lâmpada " + l.getId() + " ajustada para 100%.");
                    }
                }
            }
        }
    }
}