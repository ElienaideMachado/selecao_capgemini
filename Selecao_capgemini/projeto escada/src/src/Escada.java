package src;

import java.util.Scanner;

public class Escada {
	
	private static String n = "";
    private static int tamanho;
	
	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in); int tamanho;

		System.out.println("Digite o tamanho da escada");
		tamanho = leitor.nextInt();
		
		for (int x = 0; x < tamanho -1 ;x++) {
			n = n + " ";
		}
		n = n + "*";
		System.out.println(n);
		
		for (int x = 0; x < tamanho -1;x++) {
			n = n.substring(1, n.length()) + "*";
			System.out.println(n);
		}
}
}