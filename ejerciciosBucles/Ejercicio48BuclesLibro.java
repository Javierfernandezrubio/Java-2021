/**
 * 
 */
package ejerciciosBucles;

import java.util.Scanner;

/**
 * Ejercicio 48 
 * 
 * Realiza un programa que diga los dígitos que aparecen y los que
 * no aparecen en un número entero introducido por teclado. El orden es el que
 * se muestra en los ejemplos. Utiliza el tipo long para que el usuario pueda
 * introducir números largos.
 * 
 * 
 * @author javier
 *
 */
public class Ejercicio48BuclesLibro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long number;
		String numberString;
		String digits = "0123456789";
		char c;
		char d;
		boolean numberFind;
		Scanner s = new Scanner(System.in);
		
		
		System.out.print("Dame un numero: ");
		number = s.nextLong();
		numberString = Long.toString(number);
		
		
		
		System.out.print("Digitos presentes en el número: ");
		for (int n = 0; n < digits.length(); n++) {
			numberFind = false;
			c = digits.charAt(n);
			for ( int i = 0; i < numberString.length(); ++i ) {
				d = numberString.charAt(i);
				if ( d == c ) {
					numberFind = true;
				}
			}
			
			if ( numberFind ) {
				System.out.printf("%s ", n);
			}
			
		}
		
		System.out.println();
		
		System.out.print("Digitos no presentes en el número: ");
		for (int n = 0; n < digits.length(); n++) {
			numberFind = false;
			c = digits.charAt(n);
			for ( int i = 0; i < numberString.length(); ++i ) {
				d = numberString.charAt(i);
				if ( d == c ) {
					numberFind = true;
				}
			}
			
			if ( !numberFind ) {
				System.out.printf("%s ", n);
			}
			
		}
		
		s.close();
		
	}

}
