package Bloco2;

public class Car extends Veiculo {
    private int numeroDePortas;

    @Override
    public String toString() {
        return super.toString() + ", Numero de Portas: " + numeroDePortas;
    }
}
