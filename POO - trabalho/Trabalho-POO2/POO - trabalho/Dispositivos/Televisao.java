package Dispositivos;

public class Televisao extends Dispositivo {
    private int canal;
    private int volume;

    public Televisao(String id, String marca, String modelo, String localizacao, double consumo) {
        super(id, marca, modelo, localizacao, consumo);
        this.canal = 1;     
        this.volume = 15;   
    }

    // Métodos específicos da Televisão
    public void mudarCanal(int novoCanal) {
        if (this.ligado && novoCanal > 0) {
            this.canal = novoCanal;
        }
    }

    public void ajustarVolume(int novoVolume) {
        if (this.ligado && novoVolume >= 0 && novoVolume <= 100) {
            this.volume = novoVolume;
        }
    }

    @Override
    public String exibirStatus() {
        String estado = ligado ? "Ligada" : "Desligada";
        String infoBase = String.format("TV [%s] - %s %s | Local: %s | Status: %s", 
                            getId(), getMarca(), getModelo(), getLocalDivisao(), estado);
        
        if (ligado) {
            return infoBase + String.format(" | Canal: %d | Volume: %d | Consumo Atual: %.2f Wh", 
                                canal, volume, getConsumoTotal());
        }
        return infoBase;
    }
}