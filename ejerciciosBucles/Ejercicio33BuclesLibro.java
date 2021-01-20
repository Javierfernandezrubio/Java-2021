/**
 * 
 */
package ejerciciosBucles;

import java.util.Scanner;

/**
 * Ejercicio 33
 * 
 * Realiza un programa que pinte la letra U por pantalla hecha con asteriscos.
 * El programa pedirá la altura. Fíjate que el programa inserta un espacio y
 * pinta dos asteriscos menos en la base para simular la curvatura de las
 * esquinas inferiores.
 * 
 * @author javier
 *
 */
public class Ejercicio33BuclesLibro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Declarando variables
		int high;
		int width;
		Scanner s = new Scanner(System.in);

		System.out.println("Vamos a dibujar una U");

		System.out.print("Dame la altura: ");
		high = s.nextInt();
		
		while ( high <= 2  ) {
			System.out.println("Con esa altura dada no puedo hacer una U");
			System.out.print("Dame la altura: ");
			high = s.nextInt();
		}

		width = high - 2;

		for (int i = 1; i < high; ++i) {
			System.out.print("*");
			for ( int o = 1; o <= width; ++o ) {
				System.out.print(" ");
			}
			System.out.println("*");
		}
		System.out.print(" ");
		for (int i = 1; i <= width; ++i) {
			System.out.print("*");
		}
		System.out.print(" ");

		s.close();

	}

}
