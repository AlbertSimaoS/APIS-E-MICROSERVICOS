package Bloco2;

public class Carro extends Veiculo {
    private int numeroDePortas;

    @Override
    public String toString() {
        return super.toString() + ", Numero de Portas: " + numeroDePortas;
    }
}
