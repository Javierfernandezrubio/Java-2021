/**
 * 
 */
package ejerciciosNumerosAleatoriosYArrays;

/**
 * Ejercicio 5
 * 
 * Realiza un programa que rellene un array de 6 filas por 10 columnas con
 * números enteros positivos comprendidos entre 0 y 1000 (ambos incluidos). A
 * continuación, el programa deberá dar la posición tanto del máximo como del
 * mínimo.
 * 
 * @author javier
 *
 */
public class Ejercicio5Arrays2Dimension {

	public static void main(String[] args) {
		// Variables
		int[][] numbers = new int[6][9];
		int maximo = Integer.MIN_VALUE;
		int minimo = Integer.MAX_VALUE;
		
		
		System.out.println("Generando numeros enteros: ");
		for (int fila = 0; fila < 6; ++fila) {
			for (int columna = 0; columna < 9; ++columna) {
				numbers[fila][columna] = (int) (Math.random() * (1000 - 0 + 1) + 0);
				if ( maximo < numbers[fila][columna] ) {
					maximo = numbers[fila][columna];
				}
				if ( minimo > numbers[fila][columna] ) {
					minimo = numbers[fila][columna];
				}
			}
		}
		
		for (int fila = 0; fila < 6; fila++) {
			for (int columna = 0; columna < 9; columna++) {
				if ( maximo == numbers[fila][columna] ) {
					System.out.printf("(MAX)%7d   ", numbers[fila][columna]);
				}
				if ( minimo == numbers[fila][columna] ) {
					System.out.printf("(MIN)%7d   ", numbers[fila][columna]);
				}
				System.out.printf("     %7d   ", numbers[fila][columna]);
			}
			System.out.println();
		}

	}

}
