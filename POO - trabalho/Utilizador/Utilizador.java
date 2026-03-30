package Utilizador;

import java.util.ArrayList;
import java.util.List;

public class Utilizador {
    private final String nome;
    private final List<PermissaoCasa> minhasCasas;

    public Utilizador(String nome) {
        this.nome = nome;
        this.minhasCasas = new ArrayList<>();
    }

    public void adicionarCasa(Casa casa, TipoUtilizador papel) {
        this.minhasCasas.add(new PermissaoCasa(casa, papel));
    }

    public void listarMinhasCasas() {
        System.out.println("Casas de " + nome + ":");
        for (PermissaoCasa p : minhasCasas) {
            System.out.println("- " + p.getCasa().getNome() + " (Papel: " + p.getPapel() + ")");
        }
    }

    public boolean eAdministrador(Casa casa) {
    for (PermissaoCasa p : minhasCasas) {
        // Se a casa for a mesma e o papel for ADMIN
        if (p.getCasa().equals(casa) && p.getPapel() == TipoUtilizador.ADMINISTRADOR) {
            return true;
        }
    }
    return false;
}
}