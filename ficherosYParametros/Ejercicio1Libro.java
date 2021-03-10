/**
 * 
 */
package ficherosYParametros;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Ejercicio 1 
 * 
 * Escribe un programa que guarde en un fichero con nombre primos.dat los números primos
 * que hay entre 1 y 500.
 * 
 * 
 * @author javier
 * @version 1.0
 * Fecha 07-03-2021
 *
 */
public class Ejercicio1Libro {

  public static void main(String[] args) {

    int NUMERO = 500; // Constante que indica cuantos números primos obtendremos.
    // Abre fichero Ejercicio1Primo.dat
    try {
      BufferedWriter escritura = new BufferedWriter(new FileWriter("Ejercicio1Primos.dat"));
      // Escribimos el número 2 como inicio del archivo.
      escritura.write("2");
      escritura.newLine();

      // Comenzamos la comprobación de números primos.
      int numEsPrimo = 3;

      while (numEsPrimo <= NUMERO){
        int divisor = 3;
        boolean esPrimo = true;
        while ((divisor <= Math.sqrt(numEsPrimo)) && esPrimo) {
          if (numEsPrimo%divisor == 0) {
            esPrimo = false;
          }
          divisor +=2;
        }
        if (esPrimo) {
          // guardamos número en el archivo
          escritura.write(Integer.toString(numEsPrimo));
          escritura.newLine();
          System.out.println(numEsPrimo);
        }
        numEsPrimo +=2;
      }
      escritura.close();
      System.out.println("Archivo \"Ejercicio1Primos.dat\" con los números primos entre 1 y "+ NUMERO + " creado correctamente.");
    } catch (FileNotFoundException e){
      System.err.println("No se encuentra el archivo.");
      System.exit(1);
    } catch (IOException e) {
      System.err.println("Error de entrada/salida al manejar el fichero");
      System.exit(2);
    }
  }

}
