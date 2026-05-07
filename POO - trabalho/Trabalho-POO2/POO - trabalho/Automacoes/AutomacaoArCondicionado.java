package Automacoes;
import java.util.ArrayList;
import Dispositivos.*;
import Sensores.Sensor;
import Sensores.SensorTemp;
import Sensores.SensorPresenca;

public class AutomacaoArCondicionado extends Automacao {
    private double temperaturaMinima;
    private double temperaturaMaxima;

    public AutomacaoArCondicionado(double temperaturaMinima, double temperaturaMaxima) {
        super("Controle de Temperatura por Cômodo");
        this.temperaturaMinima = temperaturaMinima;
        this.temperaturaMaxima = temperaturaMaxima;
    }

    @Override
    public void verificarExecutar(ArrayList<Sensor> sensores, ArrayList<Dispositivo> dispositivos) {
        if (!ativa) return;

        for (Sensor s : sensores) {
            if (s instanceof SensorTemp) {
                SensorTemp sTemp = (SensorTemp) s;
                String local = sTemp.getLocal();
                SensorPresenca sPresenca = null;

                for (Sensor outro : sensores) {
                    if (outro instanceof SensorPresenca &&
                        outro.getLocal().equalsIgnoreCase(local)) {

                        sPresenca = (SensorPresenca) outro;
                        break;
                    }
                }

                // sem sensor de presença
                if (sPresenca == null) {
                    throw new RuntimeException("Erro: Sensor de Presença não encontrado na lista de sensores!");
                }

                // sem presença -> desliga AC
                if (!sPresenca.haPresenca()) {
                    for (Dispositivo d : dispositivos) {
                        if (d instanceof ArCondicionado &&
                            d.getLocalDivisao().equalsIgnoreCase(local)) {

                            ArCondicionado ac = (ArCondicionado) d;
                            if (ac.isLigado()) {
                                ac.desligar();
                                System.out.println("Sem presença em: " + local);
                                System.out.println("AC " + ac.getId() + " desligado.");
                            }
                        }
                    }
                    continue;
                }

                // com presença -> regula temperatura
                double leituraAtual = Double.parseDouble(sTemp.lerDado().split(" ")[0]);

                for (Dispositivo d : dispositivos) {
                    if (d instanceof ArCondicionado &&
                        d.getLocalDivisao().equalsIgnoreCase(local)) {

                        ArCondicionado ac = (ArCondicionado) d;

                        if (leituraAtual < temperaturaMinima) {
                            if (!ac.isLigado()) ac.ligar();
                            ac.setTemperatura(20);

                            System.out.println("Temperatura baixa em: " + local);
                            System.out.println("AC " + ac.getId() + " a aquecer.");

                        } else if (leituraAtual > temperaturaMaxima) {
                            if (!ac.isLigado()) ac.ligar();
                            ac.setTemperatura(20);

                            System.out.println("Temperatura alta em: " + local);
                            System.out.println("AC " + ac.getId() + " a arrefecer.");

                        } else {
                            if (ac.isLigado()) {
                                ac.desligar();
                                System.out.println("Temperatura confortável em: " + local);
                                System.out.println("AC " + ac.getId() + " desligado.");
                            }
                        }
                    }
                }
            }
        }
    }
}