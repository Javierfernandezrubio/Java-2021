/**
 * 
 */
package ejerciciosNumerosAleatoriosYArrays;

import java.util.Arrays;

/**
 * Ejercicio 5 
 * 
 * Muestra 50 números enteros aleatorios entre 100 y 199 (ambos
 * incluidos) separados por espacios. Muestra también el máximo, el mínimo, la
 * moda, la media, la mediana y la desviación típica de esos números.
 * 
 * @author javier
 *
 */
public class Ejercicio5NumerosAleatorios {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Variables
		int[] number = new int[50];
		int maximo = Integer.MIN_VALUE;
		int numeroActual;
		int numeroAnterior = 0;
		int minimo = Integer.MAX_VALUE;
		double suma = 0;
		double mediana;
		double moda = 0;
		double media;
		double desviacionTipica;
		double varianza;
		double sumaVarianza = 0;
		
		
		// Creacion de los numeros aleatorios, su suma y su maximo y minimo
		for ( int i = 0; i < 50; ++i ) {
			number[i] = (int)(Math.random()*99+100);
			suma = suma + number[i];
			if ( minimo > number[i] ) {
				minimo = number[i];
			}
			if ( maximo < number[i] ) {
				maximo = number[i];
			}
			
		}
		
		
		// Calculo de la moda
		int maximoNumRepeticiones = 0;
		for (int i = 0; i < number.length; i++) {
			int numRepeticiones = 0;
			for (int j = 0; j < number.length; j++) {
				if (number[i] == number[j]) {
					numRepeticiones++;
				} // fin if
				if (numRepeticiones > maximoNumRepeticiones) {
					moda = number[i];
					maximoNumRepeticiones = numRepeticiones;
				} // fin if
			}
		} // fin for
		
		// Calculo media
		media = suma/50;
		
		// Ordenamos el array
		Arrays.sort(number);
		
		// Calculo mediana
		mediana = number[25];
		
		// Calculo varianza par desviación tipica
		for ( int i : number ) {
			sumaVarianza = sumaVarianza + Math.pow(i - media, 2);
		}
		varianza = sumaVarianza / 50;
		
		// Calculo de la desviacion tipica
		desviacionTipica = Math.sqrt(varianza);
		
		
		// Resultados
		System.out.println("Los números aleatorios son:");
		for (int i : number) {
			System.out.printf("%d ", i);
		}
		System.out.printf("\nMáximo: %d\n", maximo);
		System.out.printf("Mínimo: %d\n", minimo);
		System.out.printf("Moda: %.4f\n", moda);
		System.out.printf("Media: %.4f\n", media);
		System.out.printf("Mediana: %.4f\n", mediana);
		System.out.printf("Desviación típica: %.4f", desviacionTipica);

	}

}
