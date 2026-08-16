import java.util.Scanner;
import java.util.HashMap;

public class Main
{
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    HashMap<String, String> traducoes = new HashMap<>();
	    
	    String palavra;
	    int opcao;
	    
	    traducoes.put("hello", "ola");
	    traducoes.put("bye", "tchau");
	    traducoes.put("welcome", "bem-vindo");
	    
	    do {
	        System.out.printf("============= Tradutor ============\n");
	        System.out.printf("1 - Traduzir palavra\n");
	        System.out.printf("0 - Sair\n");
	        System.out.printf("Digite opcao que deseja: \n");
	        opcao = scanner.nextInt();
	        scanner.nextLine();
	        
	        if(opcao == 1){
	            System.out.printf("Digite uma palavra: ");
	            palavra = scanner.nextLine();
	            
	            if(traducoes.containsKey(palavra)){
	                System.out.println("\n\nTraducao: " + traducoes.get(palavra));
	            } else{
	                System.out.println("\nA palavra nao consta nos dados.\n\n");
	            }
	        }
	    } while(opcao != 0);
	    
	    scanner.close();
    }
}
