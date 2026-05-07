package Sensores;

public class SensorPresenca extends Sensor {
    private boolean presenca;

    public SensorPresenca(String id, String marca, String local) {
        super(id, "Presenca", marca, local);
        this.presenca = false;
    }

    public void atualizarLeitura(boolean presencaDetectada) {
        this.presenca = presencaDetectada;

        if (presencaDetectada) {
            System.out.println("Presença detectada na divisão.");
        } else {
            System.out.println("Divisão vazia.");
        }
    }

    public boolean haPresenca() {
        return presenca;
    }

    @Override
    public String lerDado() {
        return String.valueOf(presenca);
    }

	public void setLeituraSimulada(boolean b) {
		this.presenca = b;
	}
}