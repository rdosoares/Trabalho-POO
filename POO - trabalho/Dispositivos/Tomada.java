package Dispositivos;

public class Tomada extends Dispositivo {

    private double consumoAtual; // Watts instantâneos

    public Tomada(String id, String marca, String modelo, String localizacao, double consumoBase) {
        super(id, marca, modelo, localizacao, consumoBase);
        this.consumoAtual = 0.0;
    }

    // Define consumo atual (simulação)
    public void setConsumoAtual(double watts) {
        boolean estavaLigado = ligado;
        
        if (estavaLigado) {
            super.desligar();
            consumoPorHora = watts; // Acesso direto (protected)
            super.ligar();
        } else {
            consumoPorHora = watts;
        }S
        this.consumoAtual = watts;
    }

    @Override
    public String exibirStatus() {
        String estado = ligado ? "ON" : "OFF";
        return "[Tomada " + getId() + "] Status: " + estado + " | Consumo: " + consumoAtual + "W";
    }
}