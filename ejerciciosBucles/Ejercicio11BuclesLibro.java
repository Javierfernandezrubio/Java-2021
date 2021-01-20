/**
 * 
 */
package ejerciciosBucles;

import java.util.Scanner;

/**
 * 
 * Ejercicio 11 
 * 
 * Escribe un programa que muestre en tres columnas, el cuadrado y
 * el cubo de los 5 primeros números enteros a partir de uno que se introduce
 * por teclado.
 * 
 * @author javier fernandez rubio
 * @version 1.0
 * fecha 13/11/2020
 * 
 *
 */
public class Ejercicio11BuclesLibro {

	/**
	 * @param number
	 * @param cuadrado
	 * @param cubico
	 */
	public static void main(String[] args) {
		// Declaracion de variables
		int number;
		int cuadrado;
		int cubico;
		Scanner s = new Scanner(System.in);

		
		System.out.print("Dame un numero entero: ");
		number = s.nextInt();
		
		System.out.printf("%-10s %-10s %-10s\n", "Número", "Cuadrado", "Cubo");
		
		for ( int i = number+1; i <= (number+5); ++i ) {
			cuadrado = (int) Math.pow(i, 2);
			cubico = (int) Math.pow(i, 3);
			System.out.printf("%-10d %-10d %-10d\n", i, cuadrado, cubico);
		}
		
		s.close();
	}

}
