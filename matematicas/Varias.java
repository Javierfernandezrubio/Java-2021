/**
 * 
 */
package matematicas;

/**
 * 
 * Conjunto de funciones matematicas
 * 
 * @author javier
 *
 */
public class Varias {

	/**
	 * Función que comprueba si un número dado es Capicúa o no.
	 * 
	 * 
	 * @param number
	 * @param numberAux
	 * @return true si es Capicúa
	 * @return false si no es Capicúa
	 */
	public static boolean esCapicua(long number) {
		long numberAux = voltea(number);
		if ( numberAux == number ) {
			return true;
		} else {
			return false;
		}
		
	}

	
	/**
	 * Función que nos permite saber si un número es primo o no.
	 * 
	 * 
	 * @param number
	 * @return verdadero si es primo y falso si no lo es
	 */

	public static boolean esPrimo(int number) {
		boolean primo = true;
		if ( number < 2 ) {
			primo = false;
    } else {
      for (long i = number / 2; i >= 2; i--) {
        if ( number % i == 0) {
        	primo = false;
        }
      }
    }
		return primo;
	}
	
	/**
	 * Función que nos devuelve el primo siguiente a un numero que se le pasa 
	 * 
	 * 
	 * @param number
	 * @param limite limite a numeros a comprobar si son 
	 * @return primoSiguiente númro primo siguiente
	 */
	public static int siguientePrimo(int number) {
		int primoSiguiente = number + 1;
		
		do {
			++primoSiguiente;
		} while ( !esPrimo(primoSiguiente) ) ;
		
		/**
		 * for ( int i = number + 1; i <= limite; ++i ) { if ( esPrimo(i) ) {
		 * primoSiguiente = i; break; } }
		 * 
		 */
			
		return primoSiguiente;
		
	}

	/**
	 * Función que voltea un numero que se le pasa
	 * 
	 * 
	 * @param number
	 * @return number2 
	 */
	public static long voltea(long number) {

		long number2 = number;
		String numberInvert = "";
		
		for (int i = 0; i < Long.toString(number2).length(); ++i) {
			numberInvert = numberInvert + Long.toString(number2 % 10);
			number2 = number2 / 10;
		}
		
		number2 = Long.parseLong(numberInvert);
		return number2;
	}
	

}
