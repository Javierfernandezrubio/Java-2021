/**
 * 
 */
package ejerciciosAlternativas;
import java.util.Scanner;

/**
 * Ejercicio 20 
 * 
 * Realiza un programa que diga si un número entero positivo
 * introducido por teclado es capicúa. Se permiten números de hasta 5 cifras.
 * 
 * @author javier fernandez rubio
 * @version 1.0
 * fecha 08/11/2020
 *
 * Variables:
 *  number: numero a comprobar, de tipo int
 *  numberString: número a tipo String
 *  numberStringInvert: variable de tipo StrinBuffer que nos permite usar el método reverse
 *  
 */
public class Ejercicio20AlternativasLibro {

	public static void main(String[] args) {
		// Declaramos variables
		Integer number;
		String numberString;
		Scanner s = new Scanner(System.in);

		// Saludamos
		System.out.println("Hola, vamos a comprobar si un numero es capicúa.");
		
		// Pedimos los datos
		System.out.print("Dame un numero de máximo 5 cifras:  ");
		number = s.nextInt();
		
		// Comprobamos si es de 5 cifras
		if ( number > 99999 || number < 0 ) {
			System.out.println("Número introcucido mayor a 5 cifras");
			System.out.print("Vuelve a darme un número menor a 5 cifras y entero positivo: ");
			number = s.nextInt();
		}
		
		numberString = number.toString(); // Lo convertimos a String
		StringBuffer numberStringInvert = new StringBuffer(numberString); // Creamos un variable del tipo StringBuffer
		numberStringInvert = numberStringInvert.reverse(); // Invertimos con reverse
		
		// Comprobamos si es capicúa
		if ( numberString.equals(numberStringInvert.toString()) ) {
			System.out.printf("El numero %d es capicúa!!!!", number);
		} else {
			System.out.printf("El numero %d  no es capicúa!!!!", number);
		}
		
		s.close();
	}

}
