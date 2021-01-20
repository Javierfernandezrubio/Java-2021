/**
 * 
 */
package ejerciciosBucles;

import java.util.Scanner;

/**
 * Ejercicio 16 
 * 
 * Escribe un programa que diga si un número introducido por
 * teclado es o no primo. Un número primo es aquel que sólo es divisible entre
 * él mismo y la unidad.
 * 
 * @author javier fernandez rubio
 * @version 1.0
 * fecha 13/11/2020
 *
 */
public class Ejercicio16BuclesLibro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Declaracion de variables
		int number;
		boolean primo;
		int divisor;
		Scanner s = new Scanner(System.in);
		
		System.out.println("Vamos a ver si un número es primo o no.");
		
		do {
			System.out.print("Dame un número(Introduce un número negativo para salir): ");
			number = s.nextInt();
			primo = true;
			if ( number > 1 ) {
				primo = true;
				divisor = 2;
				while (divisor < number && primo ) {
					if ( number % divisor == 0 ) {
						primo = false;
					}
					++divisor;
				}
			}
			
			if ( primo ) {
				System.out.printf("El número %d es primo.", number);
			} else {
				System.out.printf("El número %d no es primo.", number);
			}
			
			
		} while ( number < 0 );
		
		
		s.close();
	}

}
