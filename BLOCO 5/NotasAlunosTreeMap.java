import java.util.Map;
import java.util.TreeMap;

public class NotasAlunosTreeMap {

    public static void main(String[] args) {
        Map<String, Double> notasAlunos = new TreeMap<>();

        notasAlunos.put("Gisele", 8.5);
        notasAlunos.put("Bruno", 7.0);
        notasAlunos.put("Ana", 9.5);
        notasAlunos.put("Eduardo", 6.0);
        notasAlunos.put("Carla", 8.0);

        System.out.println("--- Alunos e Notas (Ordenados Alfabeticamente) ---");
        for (Map.Entry<String, Double> entrada : notasAlunos.entrySet()) {
            System.out.println("Aluno(a): " + entrada.getKey() + " | Nota: " + entrada.getValue());
        }
    }
}
