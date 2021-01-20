/**
 * 
 */
package ejerciciosNumerosAleatoriosYArrays;

import java.util.Scanner;

/**
 * En general, para conseguir un número entero entre M y N con M menor que N y
 * ambos incluídos, debemos usar esta fórmula
 * 
 * int valorEntero = Math.floor(Math.random()*(N-M+1)+M); // Valor entre M y N,
 * ambos incluidos.
 * 
 * Si no queremos un valor entero sino double, la fórmula es sin el +1
 * 
 * double valorAleatorio = Math.random()*(N-M)+M;
 * 
 * eso sí, recuerda que el valor N queda excluido y no saldrá nunca.
 * 
 * 
 * 
 * Ejercicio 1
 * 
 * Escribe un programa que muestre tres apuestas de la quiniela en tres columnas
 * para los 14 partidos y el pleno al quince (15 filas) de forma que la
 * probabilidad de que salga un 1 sea de 1/2, la probabilidad de que salga X sea
 * de 1/3 y la probabilidad de que salga 2 sea de 1/6. Pista: 1/2 = 3/6 y 1/3 =
 * 2/6.
 * 
 * 
 * @author javier
 *
 */
public class Ejercicio1NumerosAleatorios {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Variables
		int ramdomNumber;
		int equipo1;
		int equipo2;
		Scanner s = new Scanner(System.in);
		
		System.out.println("Vamos a hacer la quiniela!!!");
		System.out.println("Para el pleno al 15, damos el resultado:");
		System.out.println("Goles del equipo 1: ");
		equipo1 = s.nextInt();
		System.out.println("Goles del equipo 2: ");
		equipo2 = s.nextInt();
		
		
		for ( int i = 1; i <= 14; ++i ) {
			ramdomNumber = (int) (Math.random()*(6)+1);
			System.out.print("Partido nº" + i + ": ");
			if ( ramdomNumber < 4 && ramdomNumber > 0 ) {
				System.out.println("|  1  |     |     |");
			} else if ( ramdomNumber == 4 || ramdomNumber == 5  ) {
				System.out.println("|     |  x  |     |");
			} else if ( ramdomNumber == 6 ) {
				System.out.println("|     |     |  2  |");
			}
			
		}
		
		System.out.printf("Pleno al 15: |  %d:%d  |", equipo1, equipo2);

		s.close();
	}

}
