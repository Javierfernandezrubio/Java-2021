/**
 * 
 */
package ejerciciosNumerosAleatoriosYArrays;

/**
 * Ejercicio 4 
 * 
 * Define tres arrays de 20 números enteros cada una, con nombres
 * numero , cuadrado y cubo . Carga el array numero con valores aleatorios entre
 * 0 y 100. En el array cuadrado se deben almacenar los cuadrados de los valores
 * que hay en el array numero . En el array cubo se deben almacenar los cubos de
 * los valores que hay en numero . A continuación, muestra el contenido de los
 * tres arrays dispuesto en tres columnas.
 * 
 * @author javier
 *
 */
public class Ejercicio4Arrays1Dimension {

	public static void main(String[] args) {
		// Variable
		int[] numero = new int[20];
		int[] cuadrado = new int[20];
		int[] cubo = new int[20];

		
		for ( int i = 0; i < 20; ++i ) {
			numero[i] = (int)(Math.random()*100);
			cuadrado[i] = (int) Math.pow(numero[i], 2);
			cubo[i] = (int) Math.pow(numero[i], 3);
		}
		
		
		System.out.printf("%10s   %10s   %10s", "Numero", "Cuadrado", "Cubo\n");
		for ( int i = 0; i < 20; ++i ) {	
			System.out.printf("%10d   %10d   %10d\n", numero[i], cuadrado[i], cubo[i]);
		}
		
		
		
	}

}
