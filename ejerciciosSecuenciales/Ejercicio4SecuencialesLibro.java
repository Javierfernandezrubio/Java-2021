package ejerciciosSecuenciales;
import java.util.Scanner;

/**
 * Ejercicio 4 
 * 
 * Escribe un programa que sume, reste, multiplique y divida dos
 * números introducidos por teclado.
 * 
 * @author javier fernández rubio
 * @version 1.0 Fecha 08/11/2020
 * 
 * Variables a usar: 
 *  num1: de tipo double. 
 *  num2: de tipo double.
 *  plus: suma de los dos númros, de tipo double
 *  minus: resta de los doa númros, de tipo double
 *  multiply: multiplicacion, de tipo double
 *  divide: division, de tipo double
 *
 */
public class Ejercicio4SecuencialesLibro {

	/**
	 * @param num1
	 * @param num2
	 * @param plus
	 * @param minus
	 * @param multiply
	 * @param divide
	 */
	public static void main(String[] args) {

		// Declaramos las variables
		double num1;
		double num2;
		double plus;
		double minus;
		double multiply;
		double divide;
		Scanner s = new Scanner(System.in);

		// Presentamos programa
		System.out.println("Hola, vamos a sumar, restar, dividir y multiplicar unos números!!!");

		// Pedimos los datos
		System.out.print("Dame un primer número: ");
		num1 = s.nextDouble();
		System.out.print("Dame un segundo número: ");
		num2 = s.nextDouble();

		// Hacemos los calculos
		plus = num1 + num2;
		minus = num1 - num2;
		multiply = num1 * num2;
		divide = num1 / num2;

		// Mostramos resultado
		System.out.println("Resultados:");
		System.out.printf("Suma: %.4f", plus);
		System.out.printf("\nResta: %.4f", minus);
		System.out.printf("\nMultiplicación: %.4f", multiply);
		System.out.printf("\nDivisión: %.4f", divide);

		// Cerramos Scanner
		s.close();

	}

}
