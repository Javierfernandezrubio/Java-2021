/**
 * 
 */
package ejerciciosIndependientes;

/**
 * @author javier
 *
 */
public class Intercambia {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int primero = 5;
		int segundo = 10;
		
		intercambia(primero, segundo);
		
		
		System.out.println("primero es " + n + " y segundo es " + segundo);
		System.out.println(intercambia(primero, segundo));
		

	}
	
	public static void intercambia(int n1, int n2) {
		int aux = n1;
		n1 = n2;
		n2 = aux;
	}

}
