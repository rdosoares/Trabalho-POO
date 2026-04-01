package Sensores;

public class SensorTemp extends Sensor {
    private double temperatura;

    public SensorTemp(String id, String marca, String local) {
        super(id, "Temperatura", marca, local);
        this.temperatura = 0.0;
    }

    public void atualizarLeitura(double novoValor) {
        if (novoValor < -50 || novoValor > 100) {
            System.out.println("Aviso: Leitura de temperatura fora do intervalo realista: " + novoValor);
        } else {
            this.temperatura = novoValor;
        }
    }

    public double getTemperatura() {
        return temperatura;
    }
    
    public void setLeituraSimulada(String dado) {
        this.temperatura = Double.parseDouble(dado.split(" ")[0]);
    }

    @Override
    public String lerDado() {
        return temperatura + " ºC";
    }
}