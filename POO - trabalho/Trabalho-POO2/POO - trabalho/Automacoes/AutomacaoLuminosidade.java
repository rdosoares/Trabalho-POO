package Automacoes;
import java.util.ArrayList;
import Sensores.Sensor;
import Sensores.SensorLuz;
import Dispositivos.Dispositivo;
import Dispositivos.Lampada;


public class AutomacaoLuminosidade extends Automacao {
    private double limiarMinimo;

    public AutomacaoLuminosidade(double limiarMinimo) {
        super("Controle de Luz por Cômodo");
        this.limiarMinimo = limiarMinimo;
    }

    @Override
    public void verificarExecutar(ArrayList<Sensor> sensores, ArrayList<Dispositivo> dispositivos) {
        if (!ativa) return;

        for (Sensor s : sensores) {

            if (s instanceof SensorLuz) {
                SensorLuz sLuz = (SensorLuz) s;

                double leituraAtual = Double.parseDouble(sLuz.lerDado().split(" ")[0]);
                String local = sLuz.getLocal();

                for (Dispositivo d : dispositivos) {
                    if (d instanceof Lampada && d.getLocalDivisao().equalsIgnoreCase(local)) {
                        Lampada l = (Lampada) d;

                        if (leituraAtual < limiarMinimo) {
                            // 🔅 pouca luz → ligar
                            if (!l.isLigado()) {
                                l.ligar();
                                l.setIntensidade(100);
                                l.setTemperaturaCor(2700);

                                System.out.println("Luz baixa em: " + local);
                                System.out.println("Lâmpada " + l.getId() + " ligada a 100%");
                            }

                        } else {
                            // 💡 luz suficiente → desligar
                            if (l.isLigado()) {
                                l.desligar();
                                System.out.println("Luz suficiente em: " + local);
                                System.out.println("Lâmpada " + l.getId() + " desligada");
                            }
                        }
                    }
                }
            }
        }
    }
}