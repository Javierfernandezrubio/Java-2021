package ejerciciosSecuenciales;

import java.util.Scanner;

/**
 * Ejercicio 9 
 * 
 * Escribe un programa que calcule el volumen de un cono según la
 * fórmula V = 1/3 πr 2 h
 * 
 * @author javier fernández rubio
 * @version 1.0 
 * Fecha 08/11/2020
 * 
 * Variables a usar:
 *  cono: volumen de un cono, de tipo double
 *  radio: radio de la bse del cono, de tipo double
 *  high: altura del cono, de tipo double
 *  PI: constante de pí.
 *
 */
public class Ejercicio9SecuencialesLibro {

	/**
	 * @param cono
	 * @param radio
	 * @param high
	 * @param PI
	 */
	public static void main(String[] args) {

		// Declaramos las variables
		double cono;
		double radio;
		double high;
		final double PI = 3.14159265358979; // También se puede usar Math.pi
		Scanner s = new Scanner(System.in);

		// Presentamos programa
		System.out.println("Hola, vamos a averiguar el volumen de un cono!!!");

		// Pedimos los datos
		System.out.print("Dame el radio en metros: ");
		radio = s.nextDouble();
		System.out.print("Dame la altura en metros: ");
		high = s.nextDouble();

		// Hacemos los calculos
		cono = 1.0/3.0 * PI * Math.pow(radio, 2) * high;

		// Mostramos resultado
		System.out.printf("El volumen del cono es: %.4f metros cúbicos", cono);
		
		// Cerramos Scanner
		s.close();

	}

}