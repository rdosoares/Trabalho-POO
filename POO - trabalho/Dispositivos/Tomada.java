package Dispositivos;

public class Tomada extends Dispositivo {
    private double consumoAtual; // Exemplo de atributo extra: Watts

    public Tomada(String id) {
        super(id);
        this.consumoAtual = 0.0;
    }

    // Simulação de leitura de consumo
    public void setConsumoAtual(double watts) {
        if (this.ligado) {
            this.consumoAtual = watts;
        } else {
            this.consumoAtual = 0.0;
        }
    }

    @Override
    public String exibirStatus() {
        String estado = ligado ? "ON" : "OFF";
        return "[Tomada] Status: " + estado + " | Consumo: " + consumoAtual + "W";
    }
}