/**
 * 
 */
package ficherosYParametros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Ejercicio 2 
 * 
 * Realiza un programa que lea el fichero creado en el ejercicio anterior y que muestre
 * los números por pantalla.
 * 
 * @author javier
 * @version 1.0
 * Fecha 07-03-2021
 *
 */
public class Ejercicio2Libro {
  
  public static void main(String[] args) {
    // Abre fichero Ejercicio1Primos.txt
    try {
      BufferedReader lectura = new BufferedReader(new FileReader("Ejercicio1Primos.txt"));
      
      // Leemos y mostramos la primera línea por pantalla.
      System.out.println(lectura.readLine());
    
      // Continuamos leyendo hasta el final del archivo.
      while (lectura.readLine() != null){
        System.out.println(lectura.readLine());
      }
      lectura.close();
      System.out.println("Fin del contenido del archivo \"Ejercicio1Primos.txt\"");
    } catch (FileNotFoundException e){
      System.err.println("No se encuentra el archivo.");
      System.exit(1);
    } catch (IOException e) {
      System.err.println("Error de entrada/salida al manejar el fichero");
      System.exit(2);
    }
  }
}
