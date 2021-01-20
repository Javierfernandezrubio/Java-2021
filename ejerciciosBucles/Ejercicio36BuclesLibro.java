/**
 * 
 */
package ejerciciosBucles;

import java.util.Scanner;

/**
 * Ejercicio 36 
 * 
 * Escribe un programa que diga si un número introducido por
 * teclado es o no capicúa. Los números capicúa se leen igual hacia delante y
 * hacia atrás. El programa debe aceptar números de cualquier longitud siempre
 * que lo permita el tipo, en caso contrario el ejercicio no se dará por bueno.
 * Se recomienda usar long en lugar de int ya que el primero admite números más
 * largos.
 * 
 * @author javier
 *
 */
public class Ejercicio36BuclesLibro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Declarando variables
		long number;
		long number2;
		String numberInvert = "";
		Scanner s = new Scanner(System.in);
		
		
		System.out.println("Vamos a averiguar si un númer es capicúa");
		System.out.print("Dame un numero: ");
		number = s.nextLong();
		
		
		number2=number;
		
		for ( int i = 0; i < Long.toString(number).length(); ++i) {
			numberInvert = numberInvert + Long.toString(number2%10);
			number2 = number2/10;
		}
		
		if ( numberInvert.equals(Long.toString(number)) ) {
			System.out.printf("El número %d es capicúa.", number);
		} else {
			System.out.printf("El número %d no es capicúa.", number);
		}
		
		s.close();
		

	}

}
