/**
 * 
 */
package ejerciciosBucles;

import java.util.Scanner;

/**
 * Ejercicio 8
 * 
 * Muestra la tabla de multiplicar de un número introducido por teclado.
 * 
 * 
 * @author javier fernandez rubio 
 * @version1.0 
 * fecha 13/11/2020
 *
 *
 *         Variables:
 * 	number(int): número del que se va a mostrar la tabla de multiplicar
 *  multiply(int): resultado de la multiplicacion
 * 
 */
public class Ejercicio8BuclesLibro {

	/**
	 * @param number
	 * @param multiply
	 */
	public static void main(String[] args) {
		// Declaramos variables
		int number = 0;
		int multiply = 0;
		Scanner s = new Scanner(System.in);

		System.out.println("Hola, vamos a dar la tabla de multiplicar de un número que nos des!!!!");

		// Pedimos los datos
		do {
			System.out.print("Dame un numero entero positivo: ");
			number = s.nextInt();
		} while (number < 0);

		
		System.out.println("Tabla de multiplicar del " + number + ":");
		// Si el númro es menor a 10 hacemos estas intrucciones
		if (number <= 11) {
			for (int i = 0; i <= 10; ++i) {
				multiply = i * number;
				System.out.printf("%d x %d = %d\n", i, number, multiply);

			}

		} else { // Si es mayor hacemos estas otras
			for (int i = 0; i <= number; ++i) {
				multiply = i * number;
				System.out.printf("%d x %d = %d\n", i, number, multiply);

			}
		}
		
		s.close();

	}

}
