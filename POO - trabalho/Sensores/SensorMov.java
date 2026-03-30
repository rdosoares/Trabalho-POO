package Sensores;

public class SensorMov extends Sensor {
    private boolean movimentoDetectado;

    public SensorMov(String id, String marca) {
        super(id, "Movimento", marca);
        this.movimentoDetectado = false;
    }

    public void atualizarLeitura(boolean detectado) {
        this.movimentoDetectado = detectado;
        if (detectado) {
            System.out.println("Alerta: Movimento detectado na divisão!");
        } else {
            System.out.println("Status: Divisão vazia.");
        }
    }
    
    public boolean isMovimentoDetectado() {
        return movimentoDetectado;
    }

    @Override
    public String lerDado() {
        return String.valueOf(movimentoDetectado);
    }
}