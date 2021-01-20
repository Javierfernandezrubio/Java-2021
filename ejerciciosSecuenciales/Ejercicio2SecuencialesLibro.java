package ejerciciosSecuenciales;
import java.util.Scanner;

/**
 * Ejercicio 2
 * 
 * Realiza un conversor de euros a pesetas. La cantidad de euros que
 * se quiere convertir debe ser introducida por teclado.
 * 
 * @author javier fernández rubio
 * @version 1.0
 * Fecha 08/11/2020
 * 
 * Variables a usar:
 *  quantity: cantidad de euros a convertir a pesetas, de tipo double.
 *  pesetas: cantidad en pesetas(166 * n euros), de tipo double
 *
 */
public class Ejercicio2SecuencialesLibro {

	/**
	 * @param quantity
	 * @param pesetas
	 */
	public static void main(String[] args) {
		
		// Declaramos las variables
		double quantity;
		double pesetas;
		Scanner s = new Scanner(System.in);
		
		// Presentamos programa
		System.out.println("Hola, vamos a pasar de euros a pesetas!!!");
		
		// Pedimos los datos
		System.out.print("Dame una cantidad en euros: ");
		quantity = s.nextDouble();
		
		// Hacemos los calculos
		pesetas = quantity * 166;
		
		// Mostramos resultado
		System.out.printf("%.2f euros son %.2f pesetas.",quantity, pesetas);
		
		// Cerramos Scanner
		s.close();

	}

}
