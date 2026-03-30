package Dispositivos;

public class Cortina extends Dispositivo {
    private int grauAbertura; // 0 (fechada) a 100 (totalmente aberta)

    public Cortina(String id) {
        super(id);
        this.grauAbertura = 0; // Começa fechada
    }

    // Método para definir abertura parcial (ex: 50%)
    public void setAbertura(int percentagem) {
        if (percentagem >= 0 && percentagem <= 100) {
            this.grauAbertura = percentagem;
            // Se abrir qualquer coisa, podemos considerar o dispositivo "ligado" (ativo)
            this.ligado = (percentagem > 0);
        }
    }

    public void abrirTotalmente() { setAbertura(100); }
    public void fecharTotalmente() { setAbertura(0); }

    @Override
    public String exibirStatus() {
        String estado = (grauAbertura == 0) ? "Fechada" : (grauAbertura == 100 ? "Totalmente Aberta" : "Aberta a " + grauAbertura + "%");
        return "[Cortina " + getId() + "] Estado: " + estado;
    }
}