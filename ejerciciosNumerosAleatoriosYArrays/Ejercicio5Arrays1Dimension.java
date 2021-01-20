/**
 * 
 */
package ejerciciosNumerosAleatoriosYArrays;

import java.util.Scanner;

/**
 * 
 * Ejercicio 5 
 * 
 * Escribe un programa que pida 10 números por teclado y que luego
 * muestre los números introducidos junto con las palabras “máximo” y “mínimo”
 * al lado del máximo y del mínimo respectivamente
 * 
 * @author javier
 *
 */
public class Ejercicio5Arrays1Dimension {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Variable
		int[] number = new int[10];
		int maximo = Integer.MIN_VALUE;
		int minimo = Integer.MAX_VALUE;
		Scanner s = new Scanner(System.in);

		for (int i = 0; i < 10; ++i) {
			System.out.print("Dame un numero: ");
			number[i] = s.nextInt();
			
			if ( number[i] > maximo ) {
				maximo = number[i];
			}
			if ( number[i] < minimo ) {
				minimo = number[i];
			}
		}
		
		for ( int i = 0; i < 10; ++i ) {
			if ( number[i] == maximo ) {
				System.out.printf("(maximo)%d ", number[i]);
			} else if ( number[i] == minimo ) {
				System.out.printf("(minimo)%d ", number[i]);
			} else {
				System.out.printf("%d ", number[i]);
			}
			
		}

	}

}
