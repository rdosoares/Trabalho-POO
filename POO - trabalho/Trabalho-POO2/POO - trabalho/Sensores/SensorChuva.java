package Sensores;

public class SensorChuva extends Sensor {
    private double milimetrosChuva;

    public SensorChuva(String id, String marca, String local) {
        super(id, "Chuva", marca, local);
        this.milimetrosChuva = 0.0;
    }

    public void atualizarLeitura(double valor) {
        if (valor < 0) {
            System.out.println("Aviso: Valor de chuva não pode ser negativo.");
        } else {
            this.milimetrosChuva = valor;
        }
    }

    public double getMilimetrosChuva() {
        return milimetrosChuva;
    }
    
    @Override
    public String lerDado() {
        return "Precipitação atual: " + milimetrosChuva + " mm";
    }
}