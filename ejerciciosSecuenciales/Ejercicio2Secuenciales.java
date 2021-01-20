package ejerciciosSecuenciales;

import java.util.Scanner;

/**
 * Ejercicio 2
 * 
 * Calcular el perí­metro y área de un rectángulo dada su base y su altura.
 * 
 * @author Javier Fernánez Rubio Fecha 06/11/2020
 * 
 * Variables: 
 *  -base: base del rectaulo, de tipo double
 *  -altura: altura del rectangulo, de tipo double 
 *  -perimeter: 2*(base + altura), de tipo double 
 *  -área: base*altura, de tipo double
 * 
 */
public class Ejercicio2Secuenciales {

	/**
	 * @param base
	 * @param high
	 * @param perimeter
	 * @param area
	 * 
	 */
	public static void main(String[] args) {
		
		// Declaramos variables
		double base;
		double high;
		double perimeter;
		double area;
		Scanner s = new Scanner(System.in); // Declaramos Scanner para recoger datos por teclado
		
		System.out.println("Hola, vamos a averiguar perimetro y área de un rectangulo:");
		
		// Pedimos los datos
		System.out.println("Dame la base:");
		base = s.nextDouble();
		System.out.println("Dame la altura:");
		high = s.nextDouble();
		
		// Ejecutamos las formulas
		perimeter = 2*(base + high);
		area = base*high;
		
		// Mostamos resultados
		System.out.printf("El perimetro del rectangulo de base %.3f y altura %.3f es de %.3f", base, high, perimeter);
		System.out.printf("\nEl área del rectangulo de base %.3f y altura %.3f es de %.3f", base, high, area);
	
		s.close(); // Cerramos Scanner
	}

}
