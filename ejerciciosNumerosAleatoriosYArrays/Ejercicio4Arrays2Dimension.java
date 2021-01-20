/**
 * 
 */
package ejerciciosNumerosAleatoriosYArrays;

/**
 * Ejercicio 4 
 * 
 * Modifica el programa anterior de tal forma que las sumas
 * parciales y la suma total aparezcan en la pantalla con un pequeño retardo,
 * dando la impresión de que el ordenador se queda “pensando” antes de mostrar
 * los números.
 * 
 * @author javier
 *
 */
public class Ejercicio4Arrays2Dimension {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Variables
		int[][] numbers = new int[4][5];
		int sumaTotal = 0;
		int sumaFila;
		int sumaColumna;
		System.out.println("Generando numeros enteros: ");
		for (int fila = 0; fila < 4; ++fila) {
			for (int columna = 0; columna < 5; ++columna) {
				numbers[fila][columna] = (int) (Math.random() * (999 - 100 + 1) + 100);
			}
		}

		// Muestra los datos y las sumas parciales de las filas

		for (int fila = 0; fila < 4; fila++) {
			sumaFila = 0;
			for (int columna = 0; columna < 5; columna++) {
				System.out.printf("%7d   ", numbers[fila][columna]);
				sumaFila += numbers[fila][columna];
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.printf("|%7d\n", sumaFila);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// Muestra las sumas parciales de las columnas
		for (int columna = 0; columna < 5; columna++) {
			System.out.print("----------");
		}
		System.out.println("-----------");

		for (int columna = 0; columna < 5; columna++) {
			sumaColumna = 0;
			for (int fila = 0; fila < 4; fila++) {
				sumaColumna += numbers[fila][columna];
			}

			sumaTotal += sumaColumna;
			System.out.printf("%7d   ", sumaColumna);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.printf("|%7d   ", sumaTotal);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
