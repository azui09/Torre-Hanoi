package Torre_Hanoi.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import Torre_Hanoi.model.*;

public class Main {
    public static void main(String[] args) {
        exibirCabecalho();

        try (Scanner scanner = new Scanner(System.in)) {
            JogoHanoi simulador = new JogoHanoi();
            simulador.iniciar(scanner);
        } catch (Exception e) {
            System.out.println("\n[ERRO FATAL] Ocorreu uma falha inesperada no sistema: " + e.getMessage());
        } finally {
            System.out.println("Sistema encerrado com seguranca.");
        }
    }

    private static void exibirCabecalho() {
        System.out.println("=====================================================");
        System.out.println("    SIMULADOR - TORRE DE HANOI");
        System.out.println("    Estrutura de Dados I - Projeto 1");
        System.out.println("=====================================================\n");
    }
}