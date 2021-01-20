/**
 * 
 */
package ejerciciosBucles;

import java.util.Scanner;

/**
 * Ejercicio 10
 * 
 * Escribe un programa que calcule la media de un conjunto de números positivos
 * introducidos por teclado. A priori, el programa no sabe cuántos números se
 * introducirán. El usuario indicará que ha terminado de introducir los datos
 * cuando meta un número negativo.
 * 
 * @author javier fernandez rubio
 * @version 1.0 fecha 13/11/2020
 * 
 *          Variables:
 * 
 *
 */
public class Ejercicio10BuclesLibro {

	/**
	 * @param number
	 * @param quantityNumber
	 * @param plusNumber
	 */
	public static void main(String[] args) {
		// Declaramos variables
		double number = 0;
		double quantityNumber = -1;
		double plusNumber = 0;
		Scanner s = new Scanner(System.in);
		
		/**
		 * while ( number >= 0) {
			plusNumber = plusNumber + number;
			System.out.print("Dame un numero positivo. Da uno negativo para parar: ");
			number = s.nextInt();
			++quantityNumber;
		}
		 * 
		 * 
		 */
			
		
		do {
			
			plusNumber = plusNumber + number;
			System.out.print("Dame un numero positivo. Da uno negativo para parar: ");
			number = s.nextInt();
			++quantityNumber;
			
		} while (number >= 0);
		
		
		System.out.printf("La media de los %.0f números positivos es de %.4f", quantityNumber, plusNumber / quantityNumber);
		
		
		s.close();
	}

}
