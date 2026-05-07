package Dispositivos;

public class ArCondicionado extends Dispositivo {
    private int temperatura;

    public ArCondicionado(String id, String marca, String modelo, String localizacao, double consumo) {
        super(id, marca, modelo, localizacao, consumo);
        this.temperatura = 20;
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        if (temperatura < 16 || temperatura > 30) {
            System.out.println("Temperatura inválida (16-30)");
            return;
        }
        this.temperatura = temperatura;
    }

    public int aumentarTemperatura() {
        if (temperatura < 30) temperatura++;
        return temperatura;
    }

    public int diminuirTemperatura() {
        if (temperatura > 16) temperatura--;
        return temperatura;
    }

    @Override
    public String exibirStatus() {
        String status = isLigado() ? "Ligado" : "Desligado";
        // Formatação base seguindo o padrão "Classe [ID] | Modelo | Status"
        String info = String.format("Ar Condicionado [%s] | %s | Status: %s", 
                                    getId(), getModelo(), status);
        
        // Detalhes exibidos apenas se o dispositivo estiver operando
        if (isLigado()) {
            info += String.format(" | Temp: %d°C | Local: %s | Consumo Acumulado: %.2f Wh", 
                                  temperatura, getLocalDivisao(), getConsumoTotal());
        }
        
        return info;
    }
}