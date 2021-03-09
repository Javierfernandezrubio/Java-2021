package ficherosYParametros;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


/**
 * Ejercicio 6 
 * 
 * Realiza un programa que diga cuántas ocurrencias de una palabra hay en un fichero.
 * Tanto el nombre del fichero como la palabra se deben pasar como argumentos en la línea de
 * comandos.
 * 
 * @author javier
 * @version 1.0
 * fecha 08-03-2021
 *
 */
public class Ejercicio6Libro {

  public static void main(String[] args) {
    // ¿Número de parámetros correcto?
    if (args.length != 2) {
      System.err.println("Error en el número de parámetros"); // mensaje a la salida de error
      System.exit(1);
    }
    
    // Establecemos el fichero y la palabra a buscar
    String fichero = args[0];
    String palabra = args[1];
    
    
    // Proceso
    try {
      // Creamos un contador
      int contador = 0;
      // Abrimos fichero a buscar
      List<String> lineas = Files.readAllLines(Paths.get(fichero));
      // Leemos cada linea del fichero para buscar la palabra
      for (String linea : lineas) {
        if ( linea.contains(palabra) ) {
          ++contador;
        }
      }
      
      System.out.println("El archivo " + fichero + " contiene " + contador + "concurrencias de la "
          + "palabra <<" + palabra + ">>");
      
    } catch (FileNotFoundException error) {
      System.err.println("No se encuentra el archivo.");
      System.exit(1);
    } catch (IOException error) {
      System.err.println("Error de entrada/salida al manejar el fichero");
      System.exit(2);
    }
  }

}
