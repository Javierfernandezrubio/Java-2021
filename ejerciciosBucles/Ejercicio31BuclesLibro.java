/**
 * 
 */
package ejerciciosBucles;

import java.util.Scanner;

/**
 * Ejercicio 31 
 * 
 * Realiza un programa que pinte la letra L por pantalla hecha con
 * asteriscos. El programa pedirá la altura. El palo horizontal de la L tendrá
 * una longitud de la mitad (división entera entre 2) de la altura más uno.
 * 
 * @author javier
 *
 */
public class Ejercicio31BuclesLibro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Declarando variables
		int high;
		int width;
		Scanner s = new Scanner(System.in);

		
		System.out.println("Vamos a dibujar una L");
		
		System.out.print("Dame la altura: ");
		high = s.nextInt();
		
		width = high / 2;
		
		for ( int i = 1; i < high; ++i) {
			System.out.println("*");
		}
		for ( int i = 0; i <= width; ++i ) {
			System.out.print("*");
		}
		
		s.close();
		
	}

}
