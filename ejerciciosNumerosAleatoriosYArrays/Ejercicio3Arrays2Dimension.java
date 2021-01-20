/**
 * 
 */
package ejerciciosNumerosAleatoriosYArrays;


/**
 * 
 * Ejercicio 3 
 * 
 * Modifica el programa anterior de tal forma que los números que se
 * introducen en el array se generen de forma aleatoria (valores entre 100 y
 * 999).
 * 
 * @author javier
 *
 */
public class Ejercicio3Arrays2Dimension {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Variables
		int[][] numbers = new int[4][5];
		int sumaTotal = 0;
		int sumaFila;
		int sumaColumna;
		System.out.println("Generando numeros enteros: ");
		for (int fila = 0; fila < 4; ++fila) {
			for (int columna = 0; columna < 5; ++columna) {
				numbers[fila][columna] = (int) (Math.random()*(999-100+1)+100);
			}
		}

		// Muestra los datos y las sumas parciales de las filas
		
		for (int fila = 0; fila < 4; fila++) {
			sumaFila = 0;
			for (int columna = 0; columna < 5; columna++) {
				System.out.printf("%7d   ", numbers[fila][columna]);
				sumaFila += numbers[fila][columna];
			}
			System.out.printf("|%7d\n", sumaFila);
		}

		// Muestra las sumas parciales de las columnas
		for (int columna = 0; columna < 5; columna++) {
			System.out.print("----------");
		}
		System.out.println("-----------");

		
		for (int columna = 0; columna < 5; columna++) {
			sumaColumna = 0;
			for (int fila = 0; fila < 4; fila++) {
				sumaColumna += numbers[fila][columna];
			}

			sumaTotal += sumaColumna;
			System.out.printf("%7d   ", sumaColumna);
		}
		System.out.printf("|%7d   ", sumaTotal);

	}

}
