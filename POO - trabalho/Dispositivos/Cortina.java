package Dispositivos;

public class Cortina extends Dispositivo {
    private int grauAbertura;
    
    public Cortina(String id, String marca, String modelo, String localizacao, double consumo) {
        super(id, marca, modelo, localizacao, consumo);
        this.grauAbertura = 0;
    }

    // Método para definir abertura
    public void setAbertura(int percentagem) {
        if (percentagem >= 0 && percentagem <= 100) {
            this.grauAbertura = percentagem;

            if (percentagem > 0) {
            	this.ligar();
            } else {
                this.desligar();
            }
        }
    }

    public void abrirTotalmente() { 
        setAbertura(100); 
    }
    
    public void fecharTotalmente() { 
        setAbertura(0); 
    }

    @Override
    public String exibirStatus() {
        String estadoTexto;
        if (grauAbertura == 0) {
            estadoTexto = "Fechada";
        } else if (grauAbertura == 100) {
            estadoTexto = "Totalmente Aberta";
        } else {
            estadoTexto = "Aberta a " + grauAbertura + "%";
        }

        return String.format("[Cortina ID: %s] Local: %s | Estado: %s | Consumo Atual: %.2f Wh", 
                             getId(), getLocalDivisao(), estadoTexto, getConsumoTotal());
    }
}