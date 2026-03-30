package Utilizador;

public class PermissaoCasa {
    private final Casa casa;
    private final TipoUtilizador papel;

    public PermissaoCasa(Casa casa, TipoUtilizador papel) {
        this.casa = casa;
        this.papel = papel;
    }

    public Casa getCasa() { return casa; }
    public TipoUtilizador getPapel() { return papel; }
}