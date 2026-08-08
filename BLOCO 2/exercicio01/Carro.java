package Bloco2;

public class Carro {
        private String marca;
        private String modelo;
        private int ano;

        public Carro(String marca, String modelo, int ano) {
            this.marca = marca;
            this.modelo = modelo;
            this.ano = ano;
        }

        public String getMarca() {
            return marca;
        }

        public String getModelo() {
            return modelo;
        }

        public int getAno() {
            return ano;
        }

        public void exibirInfo(){
            System.out.println("Marca: " + getMarca());
            System.out.println("Modelo: " + getModelo());
            System.out.println("Ano: " + getAno());
        }
    }
