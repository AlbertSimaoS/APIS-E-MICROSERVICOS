package Bloco2;

public class Motorcycle extends Veiculo {
    private int cilindradas;

    @Override
    public String toString() {
        return super.toString() + ", Cilindradas: " + cilindradas;
    }
}
