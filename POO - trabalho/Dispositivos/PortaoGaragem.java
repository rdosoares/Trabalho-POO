package Dispositivos;

public class PortaoGaragem extends Dispositivo {
    private int percentagemAbertura; // 0 a 100%

    public PortaoGaragem(String id) {
        super(id);
        this.percentagemAbertura = 0; // Inicia fechado
    }

    // Método para controlar a abertura parcial
    public void ajustarAbertura(int valor) {
        if (valor >= 0 && valor <= 100) {
            this.percentagemAbertura = valor;
            
            // Lógica: se estiver 0% está "desligado" (fechado), 
            // se for > 0 está "ligado" (aberto/em uso)
            if (valor > 0) {
                super.ligar();
            } else {
                super.desligar();
            }
        } else {
            System.out.println("Erro: A abertura deve estar entre 0 e 100%.");
        }
    }

    // Métodos de conveniência
    public void abrirTotalmente() { ajustarAbertura(100); }
    public void fecharTotalmente() { ajustarAbertura(0); }

    @Override
    public String exibirStatus() {
        String descricao;
        descricao = switch (percentagemAbertura) {
            case 0 -> "FECHADO";
            case 100 -> "TOTALMENTE ABERTO";
            default -> "PARCIALMENTE ABERTO (" + percentagemAbertura + "%)";
        };
        
        return "[Portão Garagem " + getId() + "] Status: " + descricao;
    }
}