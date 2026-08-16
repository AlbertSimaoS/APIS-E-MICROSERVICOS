import java.util.*;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>(List.of(1,1,2,2,3,3,6,7,7,8));
		
		HashSet<Integer> semDuplicados = new HashSet<>();
		for (Integer number : numbers){
		    if(!semDuplicados.add(number)){
		        System.out.println("Duplicado: " + number);
		    }
		}
		System.out.println("Lista sem os duplicados: " + semDuplicados);
	}
}
