/**
 * 
 */
package ejerciciosAlternativas;
import java.util.Scanner;

/**
 * 
 * Ejercicio 9 
 * 
 * Realiza un programa que resuelva una ecuación de segundo grado
 * (del tipo ax 2 + bx + c = 0 ).
 * 
 * @author javier fernández rubio
 * @version 1.0
 * Fecha 08/11/2020
 * 
 * Variables:
 *  a: valor de a, de tipo double
 *  b: valor de b, de tipo double
 *  c: valor de c, de tipo double
 *  x: valor de la ecuacion, de tipo double
 */
public class Ejercicio9AlternativasLibro {
	public static void main(String[] args) {
		
		// Declaramos variables
		double a;
		double b;
		double c;
		double x;
		double x1;
		double x2;
		Scanner s = new Scanner(System.in); // Iniciamos Scanner

		// Presentamos
		System.out.println("Hola, ¿qué tal?,vamos a resolver ecuaciones de 2º grado.");

		// Pedimos datos
		System.out.print("Dame valor de a: ");
		a = s.nextDouble();
		System.out.print("Dame valor de b: ");
		b = s.nextDouble();
		System.out.print("Dame valor de c: ");
		c = s.nextDouble();

		// Comprobamos
		if (( a == 0 ) && ( b == 0) && ( c == 0 )) {
			System.out.println("x puede tomar cualquier valor");
		} else {
			if ( a == 0 ) { // Ecuación de 1º grado
				if ( b == 0 && c != 0 ) {
					System.out.println("La ecuación es de 1º grado pero no tiene solución");
				}
				if ( b != 0 && c == 0 ) {
					System.out.println("La ecuación es de 1º y x tiene valor 0");
				}
				if ( b != 0 && c != 0 ){
				 	x = (-1 * c)/b;
				 	System.out.printf("La ecuación es de 1º y x tiene valor %.4f", x);
				}
			}
			if ( a != 0 && b != 0 ) {
				if ( Math.pow(b, 2) - ( 4 * a *c) < 0 ) {
					System.out.println("La ecuación es indeterminada.");
				} else {
					x1 = ( ( -1 * b ) + Math.sqrt( Math.pow(b, 2) - ( 4 * a *c) ) )  / ( 2 * a );
					x2 = ( ( -1 * b ) - Math.sqrt( Math.pow(b, 2) - ( 4 * a *c) ) )  / ( 2 * a );
					System.out.printf("Los valores que toma x son x1: %.4f y x2: %.4f", x1, x2);
				}
				
			}
		}
		
	 
		
		
		s.close();
	}

}


