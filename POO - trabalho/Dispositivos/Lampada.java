package Dispositivos;

public class Lampada extends Dispositivo {
    private int intensidade; // 0 a 100
    private int temperaturaCor; // 2700 a 4000

    public Lampada(String id) {
        super(id);
        this.intensidade = 100; // Valor padrão
        this.temperaturaCor = 2700; // Valor padrão
    }

    // Métodos específicos da lâmpada
    public void setIntensidade(int intensidade) {
        if (intensidade >= 0 && intensidade <= 100) {
            this.intensidade = intensidade;
        }
    }

    public void setTemperaturaCor(int kelvin) {
        if (kelvin >= 2700 && kelvin <= 4000) {
            this.temperaturaCor = kelvin;
        }
    }

    @Override
    public String exibirStatus() {
        String estado = ligado ? "Ligada" : "Desligada";
        return "[Lampada] Status: " + estado + 
               " | Intensidade: " + intensidade + "%" + 
               " | Cor: " + temperaturaCor + "K";
    }
}