/**
 * 
 */
package ejerciciosBucles;

import java.util.Scanner;

/**
 * Ejercicio 68 
 * 
 * Escribe un programa que pida un número por teclado y que luego
 * lo “dislo- que” de tal forma que a cada dígito se le suma 1 si es par y se le
 * resta 1 si es impar. Usa long en lugar de int donde sea necesario para
 * admitir números largos.
 * 
 * @author javier
 *
 */
public class Ejercicio68BuclesLibro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Variables
		long number;
		long numberDigit; // cada digito del numero
		String numberFinal = "";
		Scanner s = new Scanner(System.in);
		
		System.out.println("Vamos a dislocar un número:");
		System.out.print("Dame un número a dislocar: ");
		number = s.nextLong();
		
		while ( number%10 != 0 ) {
			numberDigit = number % 10;
			number = number / 10;
			if ( numberDigit%2 == 0 ) {
				numberFinal = Long.toString(numberDigit+1) + numberFinal; 
			} else {
				numberFinal = Long.toString(numberDigit-1) + numberFinal; 
			}
		}
		
		System.out.printf("Número dislocado a %s", numberFinal);

		
		s.close();
	}

}
