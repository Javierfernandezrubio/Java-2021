/**
 * 
 */
package ejerciciosIndependientes;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Numeros combinatorios sin función
 * 
 * @author javier
 *
 */
public class NumerosCombinatoriosSinFuncion {

	public static void main(String[] args) {
		// Variables
		long numMayor;
		long numMenor;
		BigInteger operacion;
		BigInteger factorialm = BigInteger.valueOf(m);
		BigInteger factorialn = BigInteger.valueOf(n);
		BigInteger factorialmn = BigInteger.valueOf(m - n);
		Scanner s = new Scanner(System.in);

		// Pedimos los numeros
		do {
			System.out.print("Escribe un numero mayor: ");
			numMayor = s.nextLong();
			System.out.print("Escribe un numero menor: ");
			numMenor = s.nextLong();
			if ( numMayor < numMenor || numMayor < 0 || numMenor < 0 ) {
				System.out.println("Me estás dando los números mal, vuelve a darmelos.");
			}
		} while (numMayor < numMenor || numMayor < 0 || numMenor < 0 );
		
		// Factorial de numMayor
		while ( numMayor >= 0 ) {
			factorialNumMayor =  
			
		}

	}

}
