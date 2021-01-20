/**
 * 
 */
package ejerciciosBucles;

/**
 * Ejercicio 2 
 * 
 * Muestra los números múltiplos de 5 de 0 a 100 utilizando un bucle
 * while
 * 
 * @author javier fernandez rubio
 * @version 1.0
 * fecha 13/11/2020
 * 
 * Variable:
 *  number: número de 0 al 100 que son multiplos de 5, tipo int
 *  
 * Algoritmo:
 *  -
 *
 */
public class Ejercicio2BuclesLibro {

	public static void main(String[] args) {
		// Declaramos la variable
		int number = 0;
		
		System.out.println("Los números multiplos de 5 del 0 al 100 son:");
		
		// Calculamos y mostramos
		while ( number <= 100 ) {
			number += 1;
			if ( number % 5 == 0 ) {
				System.out.printf("%d ", number);
			}
		}

	}
}

