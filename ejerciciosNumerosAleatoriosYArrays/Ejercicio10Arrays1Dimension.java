/**
 * 
 */
package ejerciciosNumerosAleatoriosYArrays;

/**
 * 
 * Ejercicio 10 
 * 
 * Escribe un programa que genere 20 números enteros aleatorios
 * entre 0 y 100 y que los almacene en un array. El programa debe ser capaz de
 * pasar todos los números pares a las primeras posiciones del array (del 0 en
 * adelante) y todos los números impares a las celdas restantes. Utiliza arrays
 * auxiliares si es necesario.
 * 
 * @author javier
 *
 */
public class Ejercicio10Arrays1Dimension {

	public static void main(String[] args) {
		// Variables
		int pares = 0;
		int impares = 19;
		int[] numbersOrdenado = new int[20];
		int[] numbers = new int[20];
		
		
		for (int i = 0; i < 20; ++i) {
			numbers[i] = (int) (Math.random() * 100);
			if (numbers[i] % 2 == 0) {
				numbersOrdenado[pares] = numbers[i];
				++pares;
			} else {
				numbersOrdenado[impares] = numbers[i];
				--impares;
			}
		}
		
		System.out.println("Array original:");
		for (int i = 0; i < 20; ++i ) {
			System.out.printf("%d ", numbers[i]);

		}
		
		System.out.println("\nArray ordenado en pares e impares:");
		for (int i = 0; i < 20; ++i ) {
			System.out.printf("%d ", numbersOrdenado[i]);

		}
		
		
	}

}
