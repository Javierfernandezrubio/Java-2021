package ejerciciosSecuenciales;

import java.util.Scanner;

/**
 * Ejercicio 3
 * 
 * Dados los catetos de un triángulo rectángulo, calcular su hipotenusa.
 * 
 * @author Javier Fernández Rubio Fecha 06/11/2020
 * 
 *         Variables: -cateto1: cateto 1, de tipo double -cateto2: catett 2, de
 *         tipo double -hipotenusa: raiz cuadrada de cateto1**2 + cateto2**2, de
 *         tipo double
 */
public class Ejercicio3Secuenciales {

	/**
	 * @param cateto1
	 * @param cateto2
	 * @param hipotenusa
	 */
	public static void main(String[] args) {

		// Declaramos variables
		double cateto1;
		double cateto2;
		double hipotenusa;
		Scanner s = new Scanner(System.in);

		System.out.println("Hola, vamos a averiguar la hipotenusa de un rectangulo!");

		// Pedimos datos
		System.out.println("Dame el primer cateto:");
		cateto1 = s.nextDouble();
		System.out.println("Dame el segundo cateto:");
		cateto2 = s.nextDouble();

		// Ejecutamos
		hipotenusa = Math.sqrt(Math.pow(cateto1, 2) + Math.pow(cateto2, 2));

		// Mostramos resultado
		System.out.printf("\nLa hipotenusa de un rectángulo de catetos %.3f y %.3f es de %.3f", cateto1, cateto2,
				hipotenusa);

		s.close(); // Cerramos Scanner

	}

}
