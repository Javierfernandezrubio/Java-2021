/**
 * 
 */
package ejerciciosBucles;

import java.util.Scanner;

/**
 * Ejercicio 13 
 * 
 * Escribe un programa que lea una lista de diez números y
 * determine cuántos son positivos, y cuántos son negativos.
 * 
 * 
 * @author javier fernandez rubio
 * @version 1.0
 * fecha 13/11/2020
 * 
 * 
 * Variables:
 *
 */
public class Ejercicio13BuclesLibro {

	/**
	 * @param number
	 * @param negative
	 * @param positive
	 */
	public static void main(String[] args) {
		// Declaración de variables
		double number;
		int negative = 0;
		int positive = 0;
		Scanner s = new Scanner(System.in);
		
		System.out.println("Hola, me vas a dar un serie de 10 números y vamos a averiguar cuántos son + y cuańtos son -");
		
		for ( int i = 0; i < 10; ++i ) {
			System.out.print("Dame un número: ");
			number = s.nextDouble();
			
			if ( number < 0 ) {
				++negative;
			} else {
				++positive;
			}
		}
		
		
		System.out.printf("De los números dados, %d son positivos y %d son negativos.", positive, negative);
		
		s.close();

	}

}
