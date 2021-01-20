package ejerciciosAlternativas;

import java.util.Scanner;

/**
 * 
 * Ejercicio 8 
 * 
 * Realiza un programa que calcule la media de tres notas. 
 * Amplía el programa anterior para que diga la nota del boletín
 * (insuficiente, suficiente, bien, notable o sobresaliente).
 * 
 * @author javier fernández rubio
 * @version 1.0 Fecha 08/11/2020
 *
 * Variables: 
 * mark1: nota 1, de tipo double 
 * mark2: nota 2, de tipo double 
 * mark3: nota 3, de tipo double
 * markHalf: nota media, de tipo double
 * 
 */
public class Ejercicio8AlternativasLibro {

	/**
	 * @param mark1
	 * @param mark2
	 * @param mark3
	 * 
	 */
	public static void main(String[] args) {

		// Declaramos variables
		double mark1;
		double mark2;
		double mark3;
		double markHalf;
		Scanner s = new Scanner(System.in); // Iniciamos Scanner

		// Presentamos
		System.out.println("Hola, ¿qué tal?,vamos a ver qué nota tienes");
		

		// Pedimos datos
		System.out.println("Dame las notas de tus examenes:");
		System.out.print("1º: ");
		mark1 = s.nextDouble();
		System.out.print("2º: ");
		mark2 = s.nextDouble();
		System.out.print("3º: ");
		mark3 = s.nextDouble();

		// Hacemos los calculos
		markHalf = ( mark1 + mark2 + mark3 ) / 3;
		
		// Comprobamos
		if ( markHalf < 5 ) {
			System.out.printf("Insuficiente, tu nota es %.2f", markHalf);
		}
		if ( markHalf >= 5 && markHalf <= 6 ) {
			System.out.printf("Suficiente,  tu nota es %.2f", markHalf);
		}
		if ( markHalf >= 6 && markHalf <= 7 ) {
			System.out.printf("Bien,  tu nota es %.2f", markHalf);
		}
		if ( markHalf >= 7 && markHalf <= 9 ) {
			System.out.printf("Notable,  tu nota es %.2f", markHalf);
		}
		if ( markHalf >= 9 && markHalf <= 10 ) {
			System.out.printf("Sobresaliente,  tu nota es %.2f", markHalf);
		}
		

		s.close(); // Cerramos Scanner
	}

}