/**
 * 
 */
package ejerciciosIndependientes;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Ejercicio Números Combinatorios
 * 
 * Pididendo dos numeros, uno menor que el otro, 
 * 
 * @author javier
 *
 */
public class NumerosCombinatorios {

	public static void main(String[] args) {
		int n = 0, m = 0;

		Scanner lector = new Scanner(System.in);

		System.out.println("Escribe un numero:");
		m = lector.nextInt();

		System.out.println("Escribe otro numero:");
		n = lector.nextInt();
		if (m > n) {
			System.out.println("El resultado de la funcion combinatoria es: " + getCombinatorio(m, n));
		} else {
			System.out.println("El valor de M debe ser mayor a N\nReinicia el programa");
		}
		lector.close();
	}

	public static BigInteger getCombinatorio(int m, int n) {

		BigInteger operacion;
		BigInteger factorialm = BigInteger.valueOf(m);
		BigInteger factorialn = BigInteger.valueOf(n);
		BigInteger factorialmn = BigInteger.valueOf(m - n);

		int mn = m - n;

		for (int i = m - 1; i >= 1; i--) {
			factorialm = factorialm.multiply(BigInteger.valueOf(i));
		}
		System.out.println("m " + factorialm);

		for (int j = n - 1; j >= 1; j--) {
			factorialn = factorialn.multiply(BigInteger.valueOf(j));
		}
		System.out.println("n " + factorialn);
		if (mn > 2) {
			for (int k = mn - 1; k >= 1; k--) {
				factorialmn = factorialmn.multiply(BigInteger.valueOf(k));
			}
		} else {
			factorialmn = BigInteger.valueOf(mn);
		}
		System.out.println("mn " + factorialmn);
		operacion = factorialm.divide(factorialn.multiply(factorialmn));

		return operacion;
	}

}
