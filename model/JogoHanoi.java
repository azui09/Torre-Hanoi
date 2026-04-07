package Torre_Hanoi.model;

import java.util.Scanner;

public class JogoHanoi {
    private Torre torre1;
    private Torre torre2;
    private Torre torre3;
    private int quantidadeDiscos;
    private int movimentos;

    public JogoHanoi() {
        this.movimentos = 0;
    }

    public void iniciar(Scanner scanner) {
        System.out.print("Informe a quantidade de discos: ");
        quantidadeDiscos = scanner.nextInt();

        inicializarTorres();

        int opcao = 0;
        while (opcao != 4) {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Mover disco");
            System.out.println("2 - Mostrar torres");
            System.out.println("3 - Reiniciar jogo");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    realizarMovimento(scanner);
                    break;
                case 2:
                    mostrarTorres();
                    break;
                case 3:
                    System.out.println("\nReiniciando o jogo...");
                    this.movimentos = 0;
                    inicializarTorres();
                    break;
                case 4:
                    System.out.println("\nEncerrando a simulacao interna.");
                    break;
                default:
                    System.out.println("\nOpcao invalida!");
            }
        }
    }

    public void inicializarTorres() {
        this.torre1 = new Torre("Torre_1", quantidadeDiscos);
        this.torre2 = new Torre("Torre_2", quantidadeDiscos);
        this.torre3 = new Torre("Torre_3", quantidadeDiscos);
        try {
            for (int i = quantidadeDiscos; i >= 1; i--) {
                torre1.adicionarDisco(new Disco(i));
            }
        } catch (Exception e) {
            System.out.println("Erro critico ao inicializar discos: " + e.getMessage());
        }
    }

    public void realizarMovimento(Scanner scanner) {
        System.out.print("Informe a torre de origem (1, 2 ou 3): ");
        int origemStr = scanner.nextInt();
        Torre origem = selecionarTorre(origemStr);

        if (origem == null) {
            System.out.println("\nErro: Torre de origem invalida! Escolha 1, 2 ou 3.");
            return;
        }

        if (origem.isEmpty()) {
            System.out.println("\nErro: A torre de origem esta vazia. Nao ha disco para mover.");
            return;
        }

        System.out.print("Informe a torre de destino (1, 2 ou 3): ");
        int destinoStr = scanner.nextInt();
        Torre destino = selecionarTorre(destinoStr);

        if (destino == null) {
            System.out.println("\nErro: Torre de destino invalida! Escolha 1, 2 ou 3.");
            return;
        }

        try {
            Disco discoMovido = origem.removerDisco();

            try {
                destino.adicionarDisco(discoMovido);
                this.movimentos++;
                System.out.println("\nDisco movido com sucesso");

                verificarVitoria();
            } catch (Exception e) {
                origem.adicionarDisco(discoMovido); // Rollback
                System.out.println("\nErro: Movimento invalido. Um disco maior nunca pode ficar sobre um disco menor.");
            }
        } catch (Exception e) {
            System.out.println("\nErro ao mover: " + e.getMessage());
        }
    }

    public Torre selecionarTorre(int indice) {
        return switch (indice) {
            case 1 -> torre1;
            case 2 -> torre2;
            case 3 -> torre3;
            default -> null;
        };
    }

    public void mostrarTorres() {
        System.out.println("\n" + torre1.getNome() + ":");
        torre1.mostrarDiscos();

        System.out.println("\n" + torre2.getNome() + ":");
        torre2.mostrarDiscos();

        System.out.println("\n" + torre3.getNome() + ":");
        torre3.mostrarDiscos();

        System.out.println("\nMovimentos realizados ate agora: " + movimentos);
    }

    public void verificarVitoria() {
        if (torre1.isEmpty() && torre2.isEmpty() || torre1.isEmpty() && torre3.isEmpty()) {
            System.out.println("\n*** PARABENS! JOGO RESOLVIDO! ***");
            System.out.println("Quantidade total de movimentos: " + movimentos);
        }
    }
}