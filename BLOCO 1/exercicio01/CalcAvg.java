package Bloco1;

import java.util.Scanner;

public class calcAvg {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Digite a primeira nota: ");
		double score1 = scan.nextDouble();
		System.out.println("Digite a segunda nota: ");
		double score2 = scan.nextDouble();
		System.out.println("Digite a terceira nota: ");
		double score3 = scan.nextDouble();
		

		double average = (score1 + score2 + score3) / 3;

		if(average >= 7){
			System.out.println("APROVADO ");		
		}else if(average >= 5){
			System.out.println("Recuperação");
		} else{
			System.out.println("REPROVADO!! DUMB");
		}
	}
} 
