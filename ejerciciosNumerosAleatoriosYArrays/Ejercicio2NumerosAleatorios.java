/**
 * 
 */
package ejerciciosNumerosAleatoriosYArrays;

/**
 * Ejercicio 2
 * 
 * Realiza un programa que vaya generando números aleatorios pares entre 0 y
 * 100 y que no termine de generar números hasta que no saque el 24. El programa
 * deberá decir al final cuántos números se han generado.
 * 
 * @author javier
 *
 */
public class Ejercicio2NumerosAleatorios {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Variables
		int quantityNumber = 0;
		int number;
		
		
		
		do {
			
			number = (int)(Math.random()*100-0);
			if ( number % 2 == 0 ) {
				++quantityNumber;
			}
			 
		} while ( number != 24 );
		
		System.out.print("Numeros generados pares totales: " + quantityNumber);
		
		

	}

}
