/**
 * 
 */
package ejerciciosBucles;

/**
 * Ejercicio 22
 * 
 * Muestra por pantalla todos los números primos entre 2 y 100, ambos incluidos.
 * 
 * @author javier fernandez rubio
 * @version 1.0 fecha 13/11/2020
 *
 */
public class Ejercicio22BuclesLibro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int divisor;
		boolean primo;
		
		
		System.out.println("Los números primos entre el 2 y el 100 son:");
		for (int i = 2; i <= 100; ++i) {
			primo = true;
			if (i > 1) {
				primo = true;
				divisor = 2;
				while (divisor < i && primo) {
					if (i % divisor == 0) {
						primo = false;
					}
					++divisor;
				}
			}

			if (primo) {
				System.out.printf("%d ", i);
			}
		}

	}

}
