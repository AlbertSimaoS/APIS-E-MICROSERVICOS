import java.util.HashMap;
import java.util.Map;

public class Main
{
	public static void main(String[] args) {
	    HashMap<String, Integer> frequenciaPalavras = new HashMap<>();
	    
	    String texto = "Às vezes, a vida acontece nos pequenos intervalos: no aroma do café recém-passado que desacelera a manhã, no vento frio que avisa a mudança do tempo, ou no estalo de uma ideia simples que muda o rumo do dia. Não precisamos ter todas as respostas para hoje — basta dar o próximo passo e deixar que o caminho vá se desenhando aos poucos.";
	    String[] palavras = texto.toLowerCase().split("\\s+");
	    
	    for(String palavra : palavras){
	        palavra = palavra.replaceAll("[^\\p{L}\\p{N}-]", "");
	        
	        if(frequenciaPalavras.containsKey(palavra)){
	            frequenciaPalavras.put(palavra, frequenciaPalavras.get(palavra) + 1);
	        } else {
	            frequenciaPalavras.put(palavra, 1);
	        }
	    }
	    
	   for (Map.Entry<String, Integer> entrada : frequenciaPalavras.entrySet()) {
            System.out.printf("%s → %d%n", entrada.getKey(), entrada.getValue());
        }
    }
}
