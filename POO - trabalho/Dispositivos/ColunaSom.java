package Dispositivos;

// Correção: 'extends' no plural e nome correto da classe 'Dispositivo'
public class ColunaSom extends Dispositivo {
    private int volume;
    private String bluetoothDevice;

    public ColunaSom(String id, String marca, String modelo, String localizacao, double consumo) {
        super(id, marca, modelo, localizacao, consumo);
        this.volume = 20;
        this.bluetoothDevice = "Nenhum";
    }

    // Métodos específicos
    public void ajustarVolume(int novoVolume) {
        if (this.ligado) {
            if (novoVolume < 0) this.volume = 0;
            else if (novoVolume > 100) this.volume = 100;
            else this.volume = novoVolume;
        }
    }

    public void conectarBluetooth(String dispositivo) {
        if (this.ligado) {
            this.bluetoothDevice = dispositivo;
        }
    }

    @Override
    public String exibirStatus() {
        String status = ligado ? "Ligada" : "Desligada";
        String info = String.format("Coluna [%s] | %s | Status: %s", 
                                    getId(), getModelo(), status);
        
        if (ligado) {
            info += String.format(" | Volume: %d%% | BT: %s | Consumo Acumulado: %.2f Wh", 
                                  volume, bluetoothDevice, getConsumoTotal());
        }
        
        return info;
    }
}