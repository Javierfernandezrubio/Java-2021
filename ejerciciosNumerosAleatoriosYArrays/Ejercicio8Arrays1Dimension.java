/**
 * 
 */
package ejerciciosNumerosAleatoriosYArrays;

import java.util.Scanner;

/**
 * Ejercicio 8 
 * 
 * Realiza un programa que pida la temperatura media que ha hecho en
 * cada mes de un determinado año y que muestre a continuación un diagrama de
 * barras horizontales con esos datos. Las barras del diagrama se pueden dibujar
 * a base de asteriscos o cualquier otro carácter.
 * 
 * @author javier
 *
 */
public class Ejercicio8Arrays1Dimension {

	public static void main(String[] args) {
		// Variables
		double[] tempMedia = new double[12];
		Scanner s = new Scanner(System.in);
		
		for (int i = 0; i < 12; ++i) {
			System.out.printf("Dame la temperatura del mes %d: ", i + 1);
			tempMedia[i] = s.nextDouble();
		}
		
		System.out.println("Diagrama de barras con las temperaturas:");
		
		for (int i = 0; i < 12; ++i) {
			for ( int j = 0; j < tempMedia[i]; ++j ) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		s.close();
		
	}

}
