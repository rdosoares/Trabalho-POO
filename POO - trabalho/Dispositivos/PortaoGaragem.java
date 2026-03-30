package Dispositivos; //PERGUNTAR AO PROFESSOR COMO FAZER

public class PortaoGaragem extends Dispositivo {
	
    // Ajuste no construtor para bater com a classe Dispositivo
    public PortaoGaragem(String id, String marca, String modelo, String localizacao, double consumo) {
        super(id, marca, modelo, localizacao, consumo);
    }
   
    // -- abrir/ligar e fechar/desligar --
    public void abrir() {
        if (!this.ligado) {
            super.ligar();
            System.out.println("O portão está a abrir...");
        } else {
            System.out.println("O portão já está aberto.");
        }
    }
    
    public void fechar() {
        if (this.ligado) {
            super.desligar();
            System.out.println("O portão está a fechar...");
        } else {
            System.out.println("O portão já está fechado.");
        }
    }
    
    @Override
    public String exibirStatus() {
        // Usamos o booleano 'ligado' da classe pai (que é protected)
        String estado = ligado ? "ABERTO" : "FECHADO";
        return "[Portão " + getMarca() + " " + getModelo() + "] ID: " + getId() + 
               " | Local: " + getLocalDivisao() + " | Status: " + estado;
    }
}   
