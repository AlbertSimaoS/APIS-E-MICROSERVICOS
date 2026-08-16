import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> listOfNumbers = new ArrayList<>();
        
        Random random = new Random();
        
        random.ints(10).forEach(listOfNumbers::add);
        
        Collections.sort(listOfNumbers);
        
        System.out.print(listOfNumbers);
    }

    
}
