package ejerciciosSecuenciales;
import java.util.Scanner;

/**
 * Ejercicio 3 
 * 
 * Realiza un conversor de pesetas a euros. La cantidad de pesetas
 * que se quiere convertir debe ser introducida por teclado.
 * 
 * @author javier fernández rubio
 * @version 1.0 Fecha 08/11/2020
 * 
 * Variables a usar: 
 *  quantity: cantidad de pesetas a convertir a euros,
 *    de tipo double. 
 *  euros: cantidad de euros(euros / 166), de tipo
 *    double.
 *
 */
public class Ejercicio3SecuencialesLibro {

	/**
	 * @param quantity
	 * @param euros
	 */
	public static void main(String[] args) {

		// Declaramos las variables
		double quantity;
		double euros;
		Scanner s = new Scanner(System.in);

		// Presentamos programa
		System.out.println("Hola, vamos a pasar de pesetas a euros!!!");

		// Pedimos los datos
		System.out.print("Dame una cantidad en pesetas: ");
		quantity = s.nextDouble();

		// Hacemos los calculos
		euros = quantity / 166;

		// Mostramos resultado
		System.out.printf("%.2f pesetas son %.2f euros.", quantity, euros);

		// Cerramos Scanner
		s.close();

	}

}
