package Bloco1;

import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int aleatoryNumber = (int)(Math.random() * 100) + 1;
        
        int number = 0, attempts = 0;
        do{
            System.out.println("Chute o valor entre 1 e 100: ");
            number = scan.nextInt();
            if(number > aleatoryNumber){
                System.out.println("Valor muito alto");
                attempts++;
            } else if(number < aleatoryNumber){
                System.out.println("Valor muito baixo");
                attempts++;
            } else{
                attempts++;
                System.out.println("Parabens! você acertou em: " + attempts + ", tentativas");
            }
        } while(number != aleatoryNumber);
    }
}
