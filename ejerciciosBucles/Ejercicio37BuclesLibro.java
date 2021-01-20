/**
 * 
 */
package ejerciciosBucles;

import java.util.Scanner;

/**
 * Ejercicio 37 
 * 
 * Realiza un conversor del sistema decimal al sistema de
 * “palotes”.
 * 
 * 
 * @author javier
 *
 */
public class Ejercicio37BuclesLibro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number;
		int number2;
		String numberInvert = "";
		int numberInvert2;
		int number3 = 0;
		int number4 = 0;
		//int divisor = 1;
		Scanner s = new Scanner(System.in);
		
		
		System.out.println("Vamos a averiguar si un númer es capicúa");
		System.out.print("Dame un numero: ");
		number = s.nextInt();
		
		
		number2=number;
		
		for ( int i = 0; i < Integer.toString(number).length(); ++i) {
			numberInvert = numberInvert + Integer.toString(number2%10);
			number2 = number2/10;
		}
		
		numberInvert2 = Integer.parseInt(numberInvert);
		number4 = numberInvert2;
		for ( int i = 0; i < Integer.toString(number).length(); ++i) {
			// divisor *=10;
			number3 = number4%10;
			number4 = number4/10;
			
			
			if ( number3 != 0 ) {
				for ( int o = 0; o < number3; ++o ) {
					System.out.print("|");
				}
			} else {
				System.out.print(" ");
			}
			
			if ( i == Integer.toString(number).length()-1 ) {
				System.out.print("");
				
			} else {
				System.out.print("-");
			}
			
		}
		
		s.close();
	}

}
