package Bloco2;

public class Circulo {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        if (raio <= 0) {
            throw new IllegalArgumentException("o raio não pode ser negativo");
        }
    
        this.raio = raio;
    }
    
    public double calcularArea(){
        return Math.PI * (raio * raio);
    }
}
