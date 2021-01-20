/**
 * 
 */
package ejerciciosNumerosAleatoriosYArrays;

import java.util.Scanner;

/**
 * Ejercicio 4 
 * 
 * Realiza un programa que pinte por pantalla una serpiente con
 * un “serpenteo” aleatorio. La cabeza se representará con el carácter @ y se
 * debe colocar exactamente en la posición 13 (con 12 espacios delante). A
 * partir de ahí, el cuerpo irá serpenteando de la siguiente manera: se generará
 * de forma aleatoria un valor entre tres posibles que hará que el siguiente
 * carácter se coloque una posición a la izquierda del anterior, alineado con el
 * anterior o una posición a la derecha del anterior. La longitud de la
 * serpiente se pedirá por teclado y se supone que el usuario introducirá un
 * dato correcto.
 * 
 * @author javier
 *
 */
public class Ejercicio4NumerosAleatorios {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Variables
		int longSnake;
		int numberRamdom = 0;
		int espacios = 12;
		Scanner s = new Scanner(System.in);
		
		System.out.println("Vamos a dibujar una serpiente!!!");
		
		do {
			System.out.print("Dame su longitud: ");
			longSnake = s.nextInt();
			if ( longSnake <= 0 ) {
				System.err.println("La longitud dada es igual o menor a 0.");
				System.exit(1);
			}
		} while ( longSnake <= 0 );
		
		
		System.out.printf("%13s\n", "@");
		
		for ( int i = 0; i <= longSnake; ++i ) {
			numberRamdom = (int)(Math.random()*3) - 1 ;
			espacios += numberRamdom;
			System.out.println(" ".repeat(espacios) + "*");
			
		}
		
		
		/**
		 * for (int i = 0; i <= longSnake; ++i ) { numberRamdom =
		 * (int)(Math.random()*3+1); System.out.print(numberRamdom); if ( numberRamdom
		 * == 1 ) { if ( numberPrevio == 2 ) { System.out.printf("%11s*\n", " "); } else
		 * { System.out.printf("%11s*\n", " "); }
		 * 
		 * } else if ( numberRamdom == 2 || (numberPrevio == 1 || numberPrevio == 3)) {
		 * System.out.printf("%12s*\n", " "); } else if ( numberRamdom == 3 ||
		 * numberPrevio == 2) { System.out.printf("%13s*\n", " "); } numberPrevio =
		 * numberRamdom;
		 * 
		 * }
		 * 
		 * 
		 */
		
		
		s.close();

	}

}
