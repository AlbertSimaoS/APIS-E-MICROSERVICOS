import java.util.LinkedHashMap;
import java.util.Map;

public class ExemploLinkedHashMap {

    public static void main(String[] args) {
        Map<Integer, String> produtos = new LinkedHashMap<>();

        produtos.put(502, "Teclado Mecânico");
        produtos.put(101, "Mouse Gamer");
        produtos.put(305, "Monitor 144Hz");
        produtos.put(204, "Headset Surround");
        produtos.put(400, "Cadeira Ergonômica");

        System.out.println("Ordem de inserção no código:");
        System.out.println("1º: 502 -> Teclado Mecânico");
        System.out.println("2º: 101 -> Mouse Gamer");
        System.out.println("3º: 305 -> Monitor 144Hz");
        System.out.println("4º: 204 -> Headset Surround");
        System.out.println("5º: 400 -> Cadeira Ergonômica\n");

        // 3. Iterar sobre o mapa e exibir os produtos
        System.out.println("--- Saída da Iteração no LinkedHashMap ---");
        for (Map.Entry<Integer, String> entrada : produtos.entrySet()) {
            System.out.println("Código: " + entrada.getKey() + " | Produto: " + entrada.getValue());
        }
    }
}
