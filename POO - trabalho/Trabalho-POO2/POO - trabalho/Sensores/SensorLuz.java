package Sensores;

public class SensorLuz extends Sensor {
	public enum Localizacao {INTERNO, EXTERNO}
	private double intensidadeLuz;
    private Localizacao localizacao;

    public SensorLuz(String id, String marca, String local, Localizacao localizacao) {
        super(id, "Luminosidade", marca, local);
        this.localizacao = localizacao;
        this.intensidadeLuz = 0.0;
    }

    public void atualizarLeitura(double lux) {
        if (lux < 0) {
            System.out.println("Aviso: Intensidade de luz não pode ser negativa.");
        } else {
            this.intensidadeLuz = lux;
        }
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public boolean isExterno() {
        return this.localizacao == Localizacao.EXTERNO;
    }

    @Override
    public String lerDado() {
        return intensidadeLuz + " lx (" + localizacao + ")";
    }

    public void setLeituraSimulada(String dado) {
        this.intensidadeLuz = Double.parseDouble(dado.split(" ")[0]);
    }
}