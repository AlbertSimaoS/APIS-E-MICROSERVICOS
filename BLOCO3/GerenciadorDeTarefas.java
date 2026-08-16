package Bloco3;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorDeTarefas {

    public static void main(String[] args) {
        ArrayList<String> tarefas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            exibirMenu();
            System.out.print("Escolha uma opção: ");

            int opcao;
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\nOpção inválida! Digite apenas números.\n");
                continue;
            }

            switch (opcao) {
                case 1:
                    adicionarTarefa(scanner, tarefas);
                    break;
                case 2:
                    removerTarefa(scanner, tarefas);
                    break;
                case 3:
                    listarTarefas(tarefas);
                    break;
                case 4:
                    executando = false;
                    System.out.println("\nPrograma encerrado. Até logo!");
                    break;
                default:
                    System.out.println("\nOpção inválida! Escolha um número de 1 a 4.\n");
            }
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("=== GERENCIADOR DE TAREFAS ===");
        System.out.println("1. Adicionar tarefa");
        System.out.println("2. Remover tarefa por índice");
        System.out.println("3. Listar tarefas");
        System.out.println("4. Sair");
        System.out.println("==============================");
    }

    private static void adicionarTarefa(Scanner scanner, ArrayList<String> tarefas) {
        System.out.print("\nDigite a descrição da tarefa: ");
        String tarefa = scanner.nextLine().trim();

        if (tarefa.isEmpty()) {
            System.out.println(" tarefa não pode estar vazia!\n");
        } else {
            tarefas.add(tarefa);
            System.out.println("Tarefa Adicionada com sucesso!\n");
        }
    }

    private static void removerTarefa(Scanner scanner, ArrayList<String> tarefas) {
        if (tarefas.isEmpty()) {
            System.out.println("\nA lista de tarefas está vazia. Nada para remover.\n");
            return;
        }

        listarTarefas(tarefas);
        System.out.print("Digite o número da tarefa que deseja remover: ");

        try {
            int numero = Integer.parseInt(scanner.nextLine());
            int indice = numero - 1; 

            if (indice >= 0 && indice < tarefas.size()) {
                String removida = tarefas.remove(indice);
                System.out.println("Tarefa \"" + removida + "\" removida com sucesso!\n");
            } else {
                System.out.println("Número fora do intervalo da lista!\n");
            }
        } catch (NumberFormatException e) {
            System.out.println("Digite um número válido!\n");
        }
    }

    private static void listarTarefas(ArrayList<String> tarefas) {
        System.out.println("\n--- SUAS TAREFAS ---");
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
        } else {
            for (int i = 0; i < tarefas.size(); i++) {
                System.out.println((i + 1) + ". " + tarefas.get(i));
            }
        }
        System.out.println("--------------------\n");
    }
}
