/**
 * 
 */
package ejerciciosBucles;

/**
 * Ejercicio 4 
 * 
 * Muestra los números del 320 al 160, contando de 20 en 20 hacia
 * atrás utilizando un bucle for .
 * 
 * @author javier
 *
 */
public class Ejercicio4BuclesLibro {

	public static void main(String[] args) {
		
		
		System.out.println("Cuenta atrás desde 320 a 160:");
		for ( int i = 320; i >= 160; i -= 20  ) {
			System.out.printf("%d ", i);
		}
	}

}
