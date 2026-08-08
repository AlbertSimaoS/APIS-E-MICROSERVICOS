package Bloco1;

public class SumOddNumbers {
    public static void main(String[] args) {
        int[] numbers = {2,3,5};
        int total = 0;

        for (int number : numbers) {
            if(number % 2 != 0){
                total = total + number;
            }
        }

        System.out.println("Soma dos impares: " + total);
    }
}
