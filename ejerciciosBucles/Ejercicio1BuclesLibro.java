/**
 * 
 */
package ejerciciosBucles;

/**
 * Ejercicio 1 
 * 
 * Muestra los números múltiplos de 5 de 0 a 100 utilizando un bucle
 * for .
 * 
 * @author javier fernandez rubio
 * @version 1.0
 * Fecha 13/11/2020
 *
 * Variables:
 *  i: variable de control del bucle, de tipo int
 * 
 * Algoritmo:
 *  -Recorremos los números del 0 al 100
 *  -Cada número lo dividimos entre 5, division quedandonos con su resto
 *    -Si el resto sale 0 es multiplo de 5 y lo mostramos.
 *
 */
public class Ejercicio1BuclesLibro {

	public static void main(String[] args) {
		
		System.out.println("Los números multiplos de 5 del 0 al 100 son:");
		
		// Calculos y mostrando resultado
		for ( int i = 5; i < 100; ++i ) {
			if ( i % 5 == 0 ) {
				System.out.printf("%d ", i);
			}
				
		}

	}

}
