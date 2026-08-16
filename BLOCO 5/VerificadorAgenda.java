import java.util.HashMap;
import java.util.Map;

public class VerificadorAgenda {
    public static void main(String[] args) {
        Map<String, String> agenda = new HashMap<>();

        agenda.put("Ana Silva", "(11) 98765-4321");
        agenda.put("Bruno Souza", "(11) 91234-5678");
        agenda.put("Carla Dias", "(21) 99999-8888");

        String nome = "Bruno Souza";
        String telefone = "(21) 99999-8888";

        if (agenda.containsKey(nome)) {
            System.out.println("Nome encontrado: " + agenda.get(nome));
        } else {
            System.out.println("Nome nao encontrado.");
        }

        if (agenda.containsValue(telefone)) {
            System.out.println("Telefone encontrado.");
        } else {
            System.out.println("Telefone nao encontrado.");
        }
    }
}
