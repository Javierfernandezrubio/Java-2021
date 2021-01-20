/**
 * 
 */
package ejerciciosSecuenciales;
import java.util.Scanner;

/**
 * Ejercicio 1
 * 
 * Escribir un programa que pregunte al usuario su nombre, y luego lo salude.
 * 
 * @author Javier Fernández Rubio Fecha: 06/11/2020
 * 
 * Variables: 
 * name: nombre del usuario, de tipo String.
 * 
 * Algoritmo: 
 * -Comenzamos el programaS 
 * -Solicitamos el nombre del usuario
 * -Saludamos
 *
 */
public class Ejercicio1Secuenciales {

	/**
	 * @param args
	 * @param name
	 * 
	 */
	public static void main(String[] args) {
			
		String name; // Declaro la variable
		Scanner s = new Scanner(System.in); // Declaro Scanner para usarla
		
		// Saludamos y pedimos datos
		System.out.println("Hola, cómo estás? Dime tu nombre!\n");
		
		// Rcogemos en la variable el dato 
		name = s.nextLine();
		
		// Saludamos de nuevo
		System.out.println("\nHola " + name + ", encantado de conocerte!");
		
		s.close(); // Cerramos Scanner
		
		// Fin programa
	}
}
