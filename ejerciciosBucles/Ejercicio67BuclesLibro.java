/**
 * 
 */
package ejerciciosBucles;

import java.util.Scanner;

/**
 * Ejercicio 67 
 * 
 * Realiza un programa que pinte una escalera que va descendiendo
 * de izquierda a derecha. El programa pedirá el número de escalones y la altura
 * de cada escalón. La anchura de los escalones siempre es la misma: 4
 * asteriscos.
 * 
 * @author javier
 *
 */
public class Ejercicio67BuclesLibro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Variables
		int escalones;
		int high;
		Scanner s = new Scanner(System.in);
		
		
		System.out.println("Vamos a construir una escalera:");
		
		System.out.print("¿Cuántos escalones quieres?");
		escalones = s.nextInt();
		System.out.print("¿Cuánto de alto cada escalón?");
		high = s.nextInt();
		
		
		for ( int i = 1; i <= escalones; ++i ) {
			for ( int o = 1; o <= high; ++o ) {
				for ( int f = 0; f < i; ++f ) {
					System.out.print("****");
				}
				System.out.println();
			}
			
		}
		
		s.close();
	}

}
