/**
 * 
 */
package ejerciciosBucles;

/**
 * Ejercicio 6
 * 
 * Muestra los números del 320 al 160, contando de 20 en 20
 * utilizando un bucle do-while .
 * 
 * 
 * @author javier fernandez rubio
 * @version 1.0
 * Fecha 13/11/2020
 * 
 * Variable:
 *  number
 * 
 * Algoritmo:
 *
 */
public class Ejercicio6BuclesJava {

	public static void main(String[] args) {
		
		int number = 320;
		
		System.out.println("Cuenta atrás desde 320 a 160:");
		
		do {
			System.out.printf("%d ", number);
			number -= 20;
		} while ( number >= 160 );
		

	}

}
