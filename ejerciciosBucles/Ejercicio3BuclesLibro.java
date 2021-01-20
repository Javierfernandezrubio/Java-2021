/**
 * 
 */
package ejerciciosBucles;

/**
 * Ejercicio 3 
 * 
 * Muestra los números múltiplos de 5 de 0 a 100 utilizando un bucle
 * do-while .
 * 
 * @author javier fernandez rubio
 * @version 1.0
 * fecha 13/11/2020
 * 
 * Variables:
 *  number: número de 0 al 100 que son multiplos de 5, tipo int
 * 
 * Algoritmo:
 * 
 *
 */
public class Ejercicio3BuclesLibro {

	public static void main(String[] args) {
		// Declaramos la variable
		int number = 0;
		
		// Calculamos y mostramos
		do {
			if ( number % 5 == 0 ) {
				System.out.printf("%d ", number);
			}
			++number;
		} while ( number <= 100 );
			

	}

}
