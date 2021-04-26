/**
 * 
 */
package programacionOrientadaObjetos.Tanda1;
import java.util.Scanner;

/**
 * Programa para probar la clase Tiempo
 * 
 * 
 * @author Javier Fernandez Rubio
 * @version 1.0
 * Fecha 17/01/2021
 *
 */
public class PruebaTiempo {

	public static void main(String[] args) {
		
		Tiempo objeto1 = new Tiempo(1, 20, 300);
		Tiempo objeto2 = new Tiempo(0, 65, 50);

		System.out.println("Suma y resta de dos objetos:");
		System.out.println("Objeto 1: " + objeto1);
		System.out.println("Objeto 2: " + objeto2);
		System.out.println("Suma: ");
		System.out.println("Objeto resultante: " + objeto1.suma(objeto2));
		System.out.println("Resta: ");
		System.out.println("Objeto resultante: " + objeto1.resta(objeto2));
		System.out.println();
		
		System.out.println("Prueba del metodo clonar");
		Tiempo objeto3 = objeto1.clone();
		System.out.println("El objeto 1 es " + objeto1 + " y el objeto 3 clone es " + objeto3);
		
		System.out.println("Suma y resta de horas, minutos y segundos al tiempo " + objeto1);
		Scanner s = new Scanner(System.in);
		System.out.println("Dame una hora: ");
		int hora = s.nextInt();
		System.out.println("Suma:");
		objeto1.sumarHor(hora);
		System.out.println(objeto1);
		System.out.println("Resta:"); 
		objeto1.restarHor(hora);
		System.out.println(objeto1);
		
		System.out.println("Dame unos minutos: ");
		int min = s.nextInt();
		System.out.println("Suma:");
		objeto1.sumarMin(min);
		System.out.println(objeto1);
		System.out.println("Resta:"); 
		objeto1.restarMin(min);
		System.out.println(objeto1);
		
		
		System.out.println("Dame unos segundos: ");
		int seg = s.nextInt();
		System.out.println("Suma:");
		objeto1.sumarSeg(seg);
		System.out.println(objeto1);
		System.out.println("Resta:"); 
		objeto1.restarSeg(seg);
		System.out.println(objeto1);
		
		s.close();
		
		
		
		
	}

}
