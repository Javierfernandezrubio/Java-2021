/**
 * 
 */
package ejerciciosBucles;

/**
 * Ejercicio 5 
 * 
 * Muestra los números del 320 al 160, contando de 20 en 20 hacia
 * atrás utilizando un bucle while .
 * 
 * @author javier
 *
 */
public class Ejercicio5BuclesLibro {

	public static void main(String[] args) {
		int number = 320;
		
		System.out.println("Cuenta atrás desde 320 a 160:");
		
		while ( number >= 160 ) {
			System.out.printf("%d ", number);
			number -= 20;
		}

	}

}
