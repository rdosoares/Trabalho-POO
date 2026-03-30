package Utilizador;

import java.util.ArrayList;
import java.util.List;

public class Casa {
    private final String nome;
    private final List<Divisao> divisoes;

    public Casa(String nome) {
        this.nome = nome;
        this.divisoes = new ArrayList<>();
    }

    public void adicionarDivisao(Divisao d) {
        this.divisoes.add(d);
    }

    public String getNome() { return nome; }
}