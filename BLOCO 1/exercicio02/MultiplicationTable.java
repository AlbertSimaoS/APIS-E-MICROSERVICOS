package Bloco1;

import java.util.Scanner;

public class multiplicationTable {
    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("\t\t Tabuada");
        System.out.println("======================================");
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite um valor: ");
        int value = scan.nextInt();

        for (int i = 1; i <= 10; i++) {
            System.out.println("-> " + value + " * " + i + " = " + value*i);
        }

        scan.close();
    }
}
