package Utilizador;

import Dispositivos.*; // Importa todos os dispositivos (Lampada, Rele, Portao, etc.)
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("=== DOMUSCONTROL: TESTE DE FUNCIONALIDADES ===\n");

        // 1. TESTE DE UTILIZADORES E CASAS
        Utilizador adminJoao = new Utilizador("João");
        Utilizador userMaria = new Utilizador("Maria");

        Casa casaPrincipal = new Casa("Vivenda Santo António");
        
        // João é ADMIN, Maria é apenas UTILIZADORA nesta casa
        adminJoao.adicionarCasa(casaPrincipal, TipoUtilizador.ADMINISTRADOR);
        userMaria.adicionarCasa(casaPrincipal, TipoUtilizador.UTILIZADOR_COMUM);

        System.out.println("> Utilizadores criados e associados à casa.");

        // 2. TESTE DE ESTRUTURA (DIVISÕES E DISPOSITIVOS)
        // O Admin cria divisões
        Divisao sala = new Divisao("Sala de Estar");
        Divisao garagem = new Divisao("Garagem");

        // Criar dispositivos variados
        Lampada luzTeto = new Lampada("L01");
        Tomada tomadaTV = new Tomada("T01");
        PortaoGaragem portaoPrincipal = new PortaoGaragem("P01");
        Rele releCaldeira = new Rele("R01");

        // Associar dispositivos às divisões
        sala.adicionarDispositivo(luzTeto);
        sala.adicionarDispositivo(tomadaTV);
        garagem.adicionarDispositivo(portaoPrincipal);
        garagem.adicionarDispositivo(releCaldeira);

        casaPrincipal.adicionarDivisao(sala);
        casaPrincipal.adicionarDivisao(garagem);

        System.out.println("> Estrutura da casa montada (Divisões e Dispositivos).");

        // 3. TESTE DE COMPORTAMENTOS ESPECÍFICOS (POLIMORFISMO)
        System.out.println("\n--- TESTANDO INTERAÇÕES ---");

        // Testar Lâmpada (Intensidade e Cor)
        luzTeto.ligar();
        luzTeto.setIntensidade(80);
        luzTeto.setTemperaturaCor(3500);
        System.out.println(luzTeto.exibirStatus());

        // Testar Portão (Grau de abertura)
        portaoPrincipal.ajustarAbertura(45);
        System.out.println(portaoPrincipal.exibirStatus());

        // Testar Tomada (Consumo)
        tomadaTV.ligar();
        tomadaTV.setConsumoAtual(120.5);
        System.out.println(tomadaTV.exibirStatus());

        // 4. TESTE DE LISTAGEM GERAL
        System.out.println("\n--- LISTAGEM DE ACESSOS DO UTILIZADOR ---");
        adminJoao.listarMinhasCasas();

        // 5. TESTE DE EXTENSIBILIDADE (VERIFICAÇÃO FINAL)
        // Criamos uma lista genérica para provar que a Classe Principal não precisa mudar
        ArrayList<Dispositivo> todosOsDispositivos = new ArrayList<>();
        todosOsDispositivos.add(luzTeto);
        todosOsDispositivos.add(tomadaTV);
        todosOsDispositivos.add(portaoPrincipal);
        todosOsDispositivos.add(releCaldeira);

        System.out.println("\n--- STATUS GLOBAL DA INSTALAÇÃO ---");
        for (Dispositivo d : todosOsDispositivos) {
            System.out.println(d.exibirStatus());
        }

            // Cenário: João quer adicionar uma "Cozinha" à "Casa da Praia"
        if (adminJoao.eAdministrador(casaPrincipal)) {
            Divisao cozinha = new Divisao("Cozinha");
            casaPrincipal.adicionarDivisao(cozinha);
            System.out.println("Divisão adicionada com sucesso por um Administrador.");
        } else {
            System.out.println("Erro: Utilizador não tem permissão para administrar esta casa.");
        }
    }
}