package ejerciciosAlternativas;
import java.util.Scanner;

/**
 * Ejercicio 2 
 * 
 * Realiza un programa que pida una hora por teclado y que muestre
 * luego buenos días, buenas tardes o buenas noches según la hora. Se utilizarán
 * los tramos de 6 a 12, de 13 a 20 y de 21 a 5. respectivamente. Sólo se tienen
 * en cuenta las horas, los minutos no se deben introducir por teclado.
 * 
 * 
 * @author javier fernández rubio
 * @version 1.0
 * Fecha 08/11/2020
 * 
 * Variables:
 * 	hour: dato introducido por el usuario, de tipo int 
 *
 */
public class Ejercicio2AlternativasLibro {

	/**
	 * @param hour
	 */
	public static void main(String[] args) {
		
		// Declaramos las variables
		int hour;
		Scanner s = new Scanner(System.in);
		
		// Saludamos
		System.out.println("Hola, ¿qué tal?");
		
		// Pedimos los datos
		System.out.println("¿Qué hora es?(De 0 a 23, no introducir minutos)");
		hour = s.nextInt();
		
		// Comprobamos
		if ( hour >= 6  && hour <= 12 ) {
			System.out.println("Buenos dias!!!");
		}
		if ( hour >= 13  && hour <= 20 ) {
			System.out.println("Buenas tardes!!!");
		}
		if ( hour >= 0  && hour <= 5 ) {
			System.out.println("Buenas noches!!!");
		}
		if ( hour >= 21 && hour <= 23 ) {
			System.out.println("Buenas noches!!!");
		}
		
		s.close();
	 
	}

}
