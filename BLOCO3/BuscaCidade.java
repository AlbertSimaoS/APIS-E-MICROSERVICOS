import java.util.ArrayList;
import java.util.Scanner;

public class BuscaCidade {
    public static void main(String[] args) {
        ArrayList<String> cidades = new ArrayList<>();

        cidades.add("São Paulo");
        cidades.add("Rio de Janeiro");
        cidades.add("Curitiba");

        Scanner scanner = new Scanner(System.in);
      
        System.out.print("Digite uma cidade: ");
        String cidade = scanner.nextLine();

        if (cidades.contains(cidade)) {
            System.out.println("Cidade encontrada!");
            System.out.println("Índice: " + cidades.indexOf(cidade));
        } else {
            System.out.println("Cidade não encontrada.");
        }

        scanner.close();
    }
}
