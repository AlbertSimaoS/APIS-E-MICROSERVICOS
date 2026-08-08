package Bloco2;

public class Veiculo {
    private String marca;
    private String modelo;

    // Classes que herdam desta: Bloco2.Car e Bloco2.Motorcycle

    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo;
    }
}
