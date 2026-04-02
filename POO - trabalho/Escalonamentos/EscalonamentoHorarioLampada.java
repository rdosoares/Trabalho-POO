package Escalonamentos;

import HorasContador.Horario;
import java.util.ArrayList;
import java.util.List;

public class EscalonamentoHorarioLampada {
    // Classe interna que representa "às HH:MM, faça X"
    public static class Regra {
        private int horaAgendada;
        private int minutoAgendado;
        private String descricao;
        private Runnable acao;

        public Regra(int hora, int minuto, String descricao, Runnable acao) {
            this.horaAgendada   = hora;
            this.minutoAgendado = minuto;
            this.descricao      = descricao;
            this.acao           = acao;
        }

        public int getHoraAgendada()    { return horaAgendada; }
        public int getMinutoAgendado()  { return minutoAgendado; }

        public void executar() {
            System.out.println("[Regra disparada] " + descricao);
            acao.run();
        }
    }

    // --- ESTADO DO GERENCIADOR ---
    private List<Regra> regras = new ArrayList<>();
    private Horario relogio;

    public EscalonamentoHorarioLampada(Horario relogio) {
        this.relogio = relogio;
    }

    public void addRegra(int hora, int minuto, String descricao, Runnable acao) {
        regras.add(new Regra(hora, minuto, descricao, acao));
    }

    // --- BASE DO GERENCIADOR ---
    // Chamado a cada tick da simulação
    public void verificar() {
        int horaAtual    = relogio.getHoras();
        int minutoAtual  = relogio.getMinutos();
        int segundoAtual = relogio.getSegundos();

        // apenas qnd o segundo == 0
        // evita executar a regra 60 vezes no mesmo minuto
        if (segundoAtual != 0) return;

        for (Regra regra : regras) {
            if (regra.getHoraAgendada()   == horaAtual &&
                regra.getMinutoAgendado() == minutoAtual) {
                regra.executar();
            }
        }
    }
}