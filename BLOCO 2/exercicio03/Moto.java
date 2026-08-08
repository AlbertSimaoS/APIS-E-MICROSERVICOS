package Bloco2;

public class Moto extends Veiculo {
    private int cilindradas;

    @Override
    public String toString() {
        return super.toString() + ", Cilindradas: " + cilindradas;
    }
}
