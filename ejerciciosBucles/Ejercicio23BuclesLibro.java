/**
 * 
 */
package ejerciciosBucles;

import java.util.Scanner;

/**
 * Ejercicio 23 
 * 
 * Escribe un programa que permita ir introduciendo una serie
 * indeterminada de números mientras su suma no supere el valor 10000. Cuando
 * esto último ocurra, se debe mostrar el total acumulado, el contador de los
 * números introducidos y la media.
 * 
 * @author javier fernandez rubio
 * @version 1.0
 * fecha 13/11/2020
 *
 */
public class Ejercicio23BuclesLibro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Declaracion de variables
		double number;
		double totalAcum = 0;
		int quantityNum = 0;
		Scanner s = new Scanner(System.in);
		
		
		do {
			System.out.print("Dame un numero: ");
			number = s.nextDouble();
			
			totalAcum += number;
			++quantityNum;
						
		} while ( totalAcum < 10000 );
		
		System.out.printf("%.4f de total acumulado.\n", totalAcum);
		System.out.printf("%d cantidad de números introducidos.\n", quantityNum);
		System.out.printf("La media es de %.4f", totalAcum / quantityNum);
		
		s.close();
	}

}
