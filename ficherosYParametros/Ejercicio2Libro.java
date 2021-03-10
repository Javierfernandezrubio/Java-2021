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
    // Abre fichero Ejercicio1Primos.txt con try-with-resources
    try (BufferedReader lectura = new BufferedReader(new FileReader("Ejercicio1Primos.dat"))){
      
      // Creamos variable de control.
      String linea;
    
      // Leemos hasta el final del archivo y mostramos por pantalla.
      while ((linea = lectura.readLine()) != null){
        System.out.println(linea);
      }
      System.out.println("Fin del contenido del archivo \"Ejercicio1Primos.dat\"");
    } catch (FileNotFoundException e){
      System.err.println("No se encuentra el archivo.");
      System.exit(1);
    } catch (IOException e) {
      System.err.println("Error de entrada/salida al manejar el fichero");
      System.exit(2);
    }
  }
}
