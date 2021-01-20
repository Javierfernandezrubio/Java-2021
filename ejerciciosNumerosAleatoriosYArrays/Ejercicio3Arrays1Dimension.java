/**
 * 
 */
package ejerciciosNumerosAleatoriosYArrays;

import java.util.Scanner;

/**
 * Ejercicio 3 
 * 
 * Escribe un programa que lea 10 números por teclado y que luego
 * los muestre en orden inverso, es decir, el primero que se introduce es el
 * último en mostrarse y viceversa
 * 
 * @author javier
 *
 */
public class Ejercicio3Arrays1Dimension {

	public static void main(String[] args) {
		// Variable
		int[] number = new int[10];
		Scanner s = new Scanner(System.in);
		
		
		for ( int i = 0; i <= 9; ++i ) {
			System.out.print("Dame un numero: ");
			number[i] = s.nextInt();
		}
		
		for ( int i = 9; i >= 0; --i ) {
			System.out.println("simbolo[" + i + "]: " + number[i]);
		}
	}

}
