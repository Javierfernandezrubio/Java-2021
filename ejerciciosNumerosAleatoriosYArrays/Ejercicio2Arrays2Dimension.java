/**
 * 
 */
package ejerciciosNumerosAleatoriosYArrays;

import java.util.Scanner;

/**
 * Ejercicio 2 
 * 
 * Escribe un programa que pida 20 números enteros. Estos números se
 * deben introducir en un array de 4 filas por 5 columnas. El programa mostrará
 * las sumas parciales de filas y columnas igual que si de una hoja de cálculo
 * se tratara. La suma total debe aparecer en la esquina inferior derecha.
 * 
 * @author javier
 *
 */
public class Ejercicio2Arrays2Dimension {

	
	public static void main(String[] args) {
		// Variables
		int[][] numbers = new int[4][5];
		int sumaTotal = 0;
		int sumaFila;
		int sumaColumna;
		Scanner s = new Scanner(System.in);
		
		
		System.out.println("Introduce numeros enteros: ");
		for ( int fila = 0; fila < 4; ++fila) {
			for ( int columna = 0; columna < 5; ++columna) {
				System.out.print("Fila " + fila + ", columna " + columna + ": ");
				numbers[fila][columna] = s.nextInt();
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
		
		s.close();

	}

}
