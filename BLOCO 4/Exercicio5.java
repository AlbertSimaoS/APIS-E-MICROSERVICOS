import java.util.TreeSet;

public class Main
{
	public static void main(String[] args) {
		TreeSet<Produto> produtos = new TreeSet<>();
		
		produtos.add(new Produto("Calçao", 10.99));
		produtos.add(new Produto("Manga", 5.99));
		produtos.add(new Produto("Celular", 99.99));
		
		System.out.println("Lista de produtos e precos: " + produtos);
	}
}

class Produto implements Comparable<Produto> {
    private String nome;
    private double preco;
    
    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }
    
    @Override
    public int compareTo(Produto outro) {
        return Double.compare(this.preco, outro.preco);
    }
    
     @Override
    public String toString() {
        return nome + " - R$ " + preco;
    }
}
