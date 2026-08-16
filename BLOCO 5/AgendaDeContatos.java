import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AgendaDeContatos {
    public static void main(String[] args) {
        Map<String, String> agenda = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\n1 - Adicionar contato");
            System.out.println("2 - Buscar telefone");
            System.out.println("3 - Listar contatos");
            System.out.println("4 - Sair");
            System.out.print("Opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();

                    agenda.put(nome, telefone);
                    System.out.println("Contato adicionado.");
                    break;

                case 2:
                    System.out.print("Nome: ");
                    nome = scanner.nextLine();

                    if (agenda.containsKey(nome)) {
                        System.out.println("Telefone: " + agenda.get(nome));
                    } else {
                        System.out.println("Contato nao encontrado.");
                    }
                    break;

                case 3:
                    for (Map.Entry<String, String> contato : agenda.entrySet()) {
                        System.out.println(
                            contato.getKey() + " - " + contato.getValue()
                        );
                    }
                    break;

                case 4:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opcao invalida.");
            }

        } while (opcao != 4);

        scanner.close();
    }
}
