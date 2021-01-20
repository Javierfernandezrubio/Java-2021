/**
 * 
 */
package ejerciciosAlternativas;

import java.util.Scanner;

/**
 * Ejercicio 3 
 * 
 * Escribe un programa en que dado un número del 1 a 7 escriba el
 * correspondiente nombre del día de la semana.
 * 
 * @author javier fernández rubio
 * @version 1.0 Fecha 08/11/2020
 *
 * Variables:
 *  day: dia de la semana, de tipo int
 * 
 */
public class Ejercicio3AlternativasLibro {

	/**
	 * @param day
	 */
	public static void main(String[] args) {
		
		// Declaramos variables
		int day;
		Scanner s = new Scanner(System.in); // Iniciamos Scanner

		// Presentamos
		System.out.println("Hola, ¿qué tal?");
		
		// Pedimos datos
		System.out.println("¿Qué día es hoy?(1-7)");
		day = s.nextInt();
		
		// Comprobamos
		switch (day) {
		  case 1:
			  System.out.println("Hoy es lunes, vaya mierda!!!!");
			  break;
		  case 2:
			  System.out.println("Hoy es martes, ni te cases ni te embarques!!!!");
			  break;
		  case 3:
			  System.out.println("Hoy es miercoles, ¿qué esperas?!!!!");
			  break;
		  case 4:
			  System.out.println("Hoy es jueves, mejor dicho juernes!!!!");
			  break;
		  case 5:
			  System.out.println("Hoy es viernes, toca siesta!!!!");
			  break;
		  case 6:
			  System.out.println("Hoy es sábado, hoy se sale pero solo hasta las 10!!!!");
			  break;
		  case 7:
			  System.out.println("Hoy es domingo, día de brasero y vagancia!!!!");
			  break;
		}
		
		s.close(); // Cerramos Scanner
	}

}
