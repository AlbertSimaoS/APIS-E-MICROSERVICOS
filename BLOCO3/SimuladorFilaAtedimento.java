import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<String> filaDeAtendimento = new LinkedList<>();
        
        filaDeAtendimento.addLast("José");
        filaDeAtendimento.addLast("Bruno");
        filaDeAtendimento.addLast("Albert");
        filaDeAtendimento.addLast("Marcos");
        filaDeAtendimento.addLast("Ana");
        
        System.out.println("Fila: " + filaDeAtendimento);
        
        System.out.println("Atendendo: " + filaDeAtendimento.getLast());
        filaDeAtendimento.removeLast();
        System.out.println("Atendendo: " + filaDeAtendimento.getLast());
        filaDeAtendimento.removeLast();
    }

    
}
