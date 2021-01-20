/**
 * 
 */
package ejerciciosBucles;

import java.util.Scanner;

/**
 * 
 * Ejercicio 28 
 * 
 * Escribe un programa que calcule el factorial de un número entero
 * leído por teclado.
 * 
 * @author javier
 *
 */
public class Ejercicio28BuclesLibro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Declaracion de variable
		int number;
		int factorial = 1;
		Scanner s = new Scanner(System.in);
		
		System.out.println("Vamos a averiguar el factorial de un número");
		
		System.out.print("Dame un número entero: ");
		number = s.nextInt();
		
		if ( number > 0 ) {
			for ( int i = 1; i <= number; ++i ) {
			factorial *= i;
			}
		} else {
			System.out.println("Has introducido un número negativo!!!");
		}
		
		System.out.printf("%d! = %d", number, factorial);
	
		s.close();
	}

}
