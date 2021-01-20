/**
 * 
 */
package ejerciciosBucles;

import java.util.Scanner;

/**
 * Ejercicio 12 
 * 
 * Escribe un programa que muestre los n primeros términos de la
 * serie de Fibonacci. El primer término de la serie de Fibonacci es 0, el
 * segundo es 1 y el resto se calcula sumando los dos anteriores, por lo que
 * tendríamos que los términos son 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89,
 * 144... El número n se debe introducir por teclado.
 * 
 * @author javier fernandez rubio
 * @version 1.0
 * fecha 13/11/2020
 * 
 *
 */
public class Ejercicio12BuclesLibro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Declaramos la variables
		int number;
		int numeroAnterior = 1;
		int numeroAnterior2 = 0;
		int numeroActual  = 1;
		Scanner s = new Scanner(System.in);
		
		
		System.out.println("Dame una cantidad de números de la serie fibonacci a mostrar: ");
		number = s.nextInt();
		
		System.out.printf("Los %d primeros números de la serie Fibonacci son:\n", number);
		
		if ( number < 2 ) {
			System.out.print("0");
		} else if ( number < 3 ) {
			System.out.print("0 1");
		} else if ( number < 4 ) {
			System.out.print("0 1 1");
		} else {
			System.out.print("0 1 1 ");
			for (int i = 0; i < (number - 3); ++i) {
				if (numeroAnterior2 <= numeroAnterior) {
					numeroAnterior = numeroActual;
					numeroAnterior2 = numeroAnterior - numeroAnterior2;
					numeroActual = numeroAnterior + numeroAnterior2;
				}
				System.out.printf("%d ", numeroActual);
			}
		}
			
			
		s.close();
		
	}

}
