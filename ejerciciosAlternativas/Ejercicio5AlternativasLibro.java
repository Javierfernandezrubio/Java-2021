package ejerciciosAlternativas;
import java.util.Scanner;

/**
 * Ejercicio 5 
 * 
 * Realiza un programa que resuelva una ecuación de primer grado
 * (del tipo ax+b = 0 ).
 * 
 * @author javier fernández rubio
 * @version 1.0 Fecha 08/11/2020
 *
 * Variables:
 *  a: introducido por el usuario, de tipo double
 *  b: idem a "a", de tipo double
 *  x: valor de x, de tipo double
 *  
 */
public class Ejercicio5AlternativasLibro {

	/**
	 * @param a
	 * @param b
	 * @param x
	 * 
	 */
	public static void main(String[] args) {

		// Declaramos variables
		double a;
		double b;
		double x;
		Scanner s = new Scanner(System.in); // Iniciamos Scanner

		// Presentamos
		System.out.println("Hola, ¿qué tal?,vamos a resolver ecuaciones de primer grado.");
		System.out.println("Ecuaciones de tipo ax+b = 0");

		// Pedimos datos
		System.out.print("Dame valor de a: ");
		a = s.nextDouble();
		System.out.print("Dame valor de b: ");
		b = s.nextDouble();

		// Comprobamos
		if ( a == 0 ) {
			System.out.println("La ecuación no tiene solución");
		} else {
			if ( b == 0 ) {
			System.out.println("x tiene valor 0");
		  } else {
		  	x = (-1 * b)/a;
		  	System.out.printf("x tiene valor %.4f", x);
		  }
		}
		
		
		
		
		s.close(); // Cerramos Scanner
	}

}
