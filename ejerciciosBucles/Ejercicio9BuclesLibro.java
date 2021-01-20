/**
 * 
 */
package ejerciciosBucles;

import java.util.Scanner;

/**
 * Ejercicio 9 
 * 
 * Realiza un programa que nos diga cuántos dígitos tiene un número
 * introducido por teclado. Este ejercicio es equivalente a otro realizado
 * anteriormente, con la salvedad de que el anterior estaba limitado a números
 * de 5 dígitos como máximo. En esta ocasión, hay que realizar el ejercicio
 * utilizando bucles; de esta manera, la única limitación en el número de
 * dígitos la establece el tipo de dato que se utilice ( int o long ).
 * 
 * @author javier fernandez rubio
 * @version 1.0
 * fecha 13/11/2020
 * 
 * 	Variables:
 * 
 * 
 * 
 *
 */
public class Ejercicio9BuclesLibro {

	/**
	 * @param number
	 * @param digit
	 */
	public static void main(String[] args) {
		// Declaramos las variables
		long number;
		long digit = 1;
		Scanner s = new Scanner(System.in);
		
		
		
		// Pedimos el numero
		System.out.print("Dame un numero entero: ");
		number = s.nextLong();

		
		// Comprobamos dividiendo comenzando con la division entre 10
		/**
		 * for ( long i = 10; i <= number; ) {
				if ( number / 10 > 0 ) { // Si el 
					++digit; 
				}
			i *= 10;
			}
		 */
		
		long i = 10;
		while ( i <= number ) {
			if ( number / i > 0 ) { // Si el 
				++digit; 
			}
			i *= 10;
		}
		
		System.out.printf("El número %d tiene %d digitos.",number,digit);
		
		
		s.close();
	}

}
