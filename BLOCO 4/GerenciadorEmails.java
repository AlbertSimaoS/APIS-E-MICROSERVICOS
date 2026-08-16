import java.util.*;

public class Main {
	public static void main(String[] args) {
		HashSet<String> emails = new HashSet<>();
	    
	    emails.add("ana@gmail.com");
	    emails.add("marcos@gmail.com");
	    emails.add("jose@gmail.com");
	    emails.add("simao@gmail.com");
	    emails.add("simao@gmail.com");
	    
	    System.out.println("Emails: " + emails);
	    System.out.println("Tamanho do Set: " + emails.size());
	}
}
