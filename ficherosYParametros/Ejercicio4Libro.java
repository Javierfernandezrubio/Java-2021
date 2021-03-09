/**
 * 
 */
package ficherosYParametros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Ejercicio 4
 * 
 * Realiza un programa que sea capaz de ordenar alfabéticamente las palabras contenidas en un
 * fichero de texto. El nombre del fichero que contiene las palabras se debe pasar como argumento en
 * la línea de comandos. El nombre del fichero resultado debe ser el mismo que el original añadiendo
 * la coletilla sort , por ejemplo palabras_sort.txt . Suponemos que cada palabra ocupa una línea.
 * 
 * 
 * @author javier
 * @version 1.0 fecha 08-03-2021
 * 
 *
 */
public class Ejercicio4Libro {

  public static void main(String[] args) {
    // Comprobamos los argumentos recibidos
    try {
      if (args.length != 1) {
        System.err.println("Número de parámetros recibido incorrecto.");
        System.exit(2);
      }
    } catch (Exception e) {
      System.out.println("Se ha producido un error.");
      System.exit(1);
    }
    // Abrimos archivos de lectura y archivo de escritura
    try {
      BufferedReader archivo = new BufferedReader(new FileReader(args[0]));

      // leemos el archivo y guardamos las palabras en un arrayList
      ArrayList<String> lecturaPalabras = new ArrayList<String>();

      String linea = archivo.readLine();
      do {
        lecturaPalabras.add(linea);
        linea = archivo.readLine();
      } while (linea != null);

      // Cerramos fichero de lectura.
      archivo.close();

      // Ordenamos el arrayList antes de proceder a guardarlo en el nuevo archivo.
      Collections.sort(lecturaPalabras);

      // Otenemos nombre para el fichero de escritura
      String archivoOrdenado = null;
      if (args[0].contains(".")) {
        int indice = args[0].lastIndexOf(".");
        archivoOrdenado =
            args[0].substring(0, indice) + "_sort" + args[0].substring(indice, args[0].length());
      } else {
        archivoOrdenado = args[0] + "_sort";
      }
      // Abrimos fichero de escritura
      BufferedWriter listadoOrdenado = new BufferedWriter(new FileWriter(archivoOrdenado));

      for (int i = 0; i < lecturaPalabras.size() - 1; i++) {
        listadoOrdenado.write(lecturaPalabras.get(i));
        listadoOrdenado.newLine();
      }
      // Cerramos fichero de escritura.
      listadoOrdenado.close();

      System.out.println("Archivos mezclados correctamente en el fichero " + archivoOrdenado);

    } catch (FileNotFoundException error) {
      System.err.println("No se encuentra el archivo.");
      System.exit(1);
    } catch (IOException error) {
      System.err.println("Error de entrada/salida al manejar el fichero");
      System.exit(2);
    }
  }

}
