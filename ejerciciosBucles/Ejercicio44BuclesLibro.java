/**
 * 
 */
package ejerciciosBucles;

import java.util.Scanner;

/**
 * Ejercicio 44 
 * 
 * Escribe un programa que sea capaz de insertar un dígito dentro
 * de un número indicando la posición. El nuevo dígito se colocará en la
 * posición indicada y el resto de dígitos se desplazará hacia la derecha. Las
 * posiciones se cuentan de izquierda a derecha empezando por el 1. Suponemos
 * que el usuario introduce correctamente los datos. Se recomienda usar long en
 * lugar de int ya que el primero admite números más largos.
 * 
 * @author javier
 *
 */
public class Ejercicio44BuclesLibro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Declarando variables
		int number;
		String numberString;
		int position;
		int numberDigit; // Digito a insertar
		String numberDigitString;
		String numberFinalString = "";
		Scanner s = new Scanner(System.in);
		
		System.out.println("Vamos a insertar un numero donde tú quieras dentro de otro más grande");
		
		// Pedir numero grande positivo
		System.out.print("Dame un numero grande: ");
		number = s.nextInt();
		// Ver si hay error si es negativo
		if ( number <= 0 ) {
			System.err.println( number + "es un numero negativo, no se puede ejecutar el programa.");
			System.exit(1);
		}
		
		int tamaño = 0; // Calcular tamaño del numero grande
		int aux = number;
		while ( aux > 0 ) {
			aux = aux/10;
			++tamaño;
		}
		
	//number2 = number;
		
		// Posicion 
		System.out.print("La posicion donde integrar el numero: ");
		position = s.nextInt();
		// Comprobar si hay error si la posicion es menor a 0 o mayor al tamaño del numero grande
		if ( position < 0 || position > tamaño ) {
			System.err.println("La posición introducida es menor a 0 o mayor que el tamaño del número introducido.");
			System.exit(2);
		}
		
		
		// Numeroo digito a insertar
		System.out.print("Dame el numero a integrar(de un digito): ");
		numberDigit = s.nextInt();
		// Comprobar si es menor a 0 o mayor a 9
		if ( numberDigit < 0 || numberDigit > 9 ) {
			System.err.println("Digito introducido erroneo.");
			System.exit(3);
		}
		
		// Paso de los numeros a tipo String
		numberString = Integer.toString(number);
		numberDigitString = Integer.toString(numberDigit);
		
		
		// Ejecutamos
		char c; // Variable de tipo caracter que se iran concatenando para formar el String final
		for (int n = 0; n < numberString.length() + 1; ++n) {
			if (n == position - 1 ) {
				c = numberDigitString.charAt(0);
				numberFinalString = numberFinalString + c;
			} else if ( n > position - 1 ){
				c = numberString.charAt(n-1);
				numberFinalString = numberFinalString + c;
			} else {
				c = numberString.charAt(n);
				numberFinalString = numberFinalString + c;
			}
		}
		
		number = Integer.parseInt(numberFinalString); // Volvemos  pasar a tipo int
		
		// Mostramos resultado
		System.out.print("El número finalmente queda así: " + number);
		
		s.close();
		
		
	}

}
