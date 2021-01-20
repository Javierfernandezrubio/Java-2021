/**
 * 
 */
package ejerciciosNumerosAleatoriosYArrays;

/**
 * Ejercicio 3
 * 
 * Realiza un programa que llene la pantalla de caracteres aleatorios (a lo
 * Matrix) con el código ascii entre el 32 y el 126. Puedes hacer casting con
 * (char) para convertir un entero en un carácter.
 * 
 * @author javier
 *
 */
public class Ejercicio3NumerosAleatorios {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Variables
		int number;
		char character;
		int longitud;
		
		do {
			number = (int)(Math.random()*126+32);
			character = (char) number;
			longitud = (int)(Math.random()*50+1);
			do {
				System.out.print(character);
			} while ( longitud != 25 );
			System.out.println()
			
		} while ( number > 0);
		
		
		

	}

}
