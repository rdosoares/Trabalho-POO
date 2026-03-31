package Dispositivos;

public class Lampada extends Dispositivo {
    private int intensidade;    // 0 a 100%
    private int temperaturaCor; // 2700K a 4000K

    public Lampada(String id, String marca, String modelo, String localizacao, double consumo) {
        super(id, marca, modelo, localizacao, consumo);
        
        // Valores iniciais padrão
        this.intensidade = 100;
        this.temperaturaCor = 2700;
    }

    // --- Métodos Específicos da Lâmpada ---
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
  
    public void setIntensidadeLuz(double intensidadeLuz) {
        this.intensidade = intensidade;
    }
    
    public int getIntensidade() { return intensidade; }
    public int getTemperatura() { return temperaturaCor; }

    // --- Status ---
    @Override
    public String exibirStatus() {
        String estado = ligado ? "LIGADA" : "DESLIGADA";
        
        // Usamos String.format para deixar o texto limpo e organizado
        return String.format(
            "[%s] Lâmpada %s %s (ID: %s)\n" +
            "Estado: %s | Intensidade: %d%% | Cor: %dK\n" +
            "Consumo Total Acumulado: %.4f Wh",
            getLocalDivisao(), getMarca(), getModelo(), getId(),
            estado, intensidade, temperaturaCor, getConsumoTotal()
        );
    }
}