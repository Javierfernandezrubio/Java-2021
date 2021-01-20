/**
 * 
 */
package ejerciciosBucles;

import java.util.Scanner;

/**
 * Ejercicio 7 
 * 
 * Realiza el control de acceso a una caja fuerte. La combinación
 * será un número de 4 cifras. El programa nos pedirá la combinación para
 * abrirla. Si no acertamos, se nos mostrará el mensaje “Lo siento, esa no es la
 * combinación” y si acertamos se nos dirá “La caja fuerte se ha abierto
 * satisfactoriamente”. Tendremos cuatro oportunidades para abrir la caja
 * fuerte.
 * 
 * 
 * @author javier fernandez rubio
 * @version 1.0
 * Fecha 13/11/2020
 * 
 * Variables:
 *  passKey: 
 * 
 * 
 * Algoritmo:
 * 
 * 
 *
 */
public class Ejercicio7BuclesLibro {

	public static void main(String[] args) {
		// Declaramos variables
		int passKey = 9999; 
		int numberUser;
		int tried = 4;
		Scanner s = new Scanner(System.in);
		
		// Generamos la clave
		passKey = (int)(Math.random()*(999-10000+1)+10000);
		
		// Presentamos
		System.out.println("Caja fuerte con clave. Se necesita la clave la abrirla.");
		
		
		// Ejecutamos
		do {
			System.out.print("Dame la clave: "); // Pido la clave
			numberUser = s.nextInt();
			
			if ( numberUser > 1000  && numberUser < 10000 ) { // Comprobamos su tamaño
				if (numberUser == passKey) {  // Comprobamos si es correcta la clave
					System.out.print("La caja fuerte se ha abierto satisfactoriamente.");
					break;  // Salimos del bucle si es correcta
				} else {  // Si no es correcta
					--tried;  // El paso es negativo en 1 intento 
					System.out.print("Lo siento, esa no es la combinación correcta.");
					System.out.printf("Te quedan %d intentos.\n", tried);
				}
			} else {  // Si no es de tamaño adecuado
				System.out.println("Error,la clave tiene que tener 4 digitos.");
			}
			
		} while ( tried > 0 ); // El ciclo acaba cuando el n intentos llega a 0
		
		
		
		s.close();
	}

}
