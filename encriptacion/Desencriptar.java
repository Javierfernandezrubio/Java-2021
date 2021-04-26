/**
 * 
 */
package encriptacion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * - Haz un programa que reciba como parámetro un fichero encriptado con el método César, lo
 * desencripte y almacene el resultado en otro archivo, que también pasamos como parámetro, de
 * manera que:
 * 
 * Si el programa no recibe el número de parámetros adecuado termina con un error 1. Si el programa
 * recibe un solo parámetro guardará la información encriptada en el mismo archivo del que lee, pero
 * antes advertirá al usuario de que machacará el archivo origen, dando opción a que la operación no
 * se haga. Si el fichero origen no existe (da error al abrirlo como lectura) el programa termina
 * con un mensaje de error y código 2. Si en el fichero destino no se puede escribir (da error al
 * abrirlo como escritura) el programa termina con un mensaje de error y código 3. Para desencriptar
 * necesitas una clave que debes pedir al usuario. ¿Se te ocurre alguna forma de desencriptar este
 * archivo sin pedir clave? Coméntala, y si te atreves... ¡impleméntala!
 * 
 * 
 * @author javier
 *
 */
public class Desencriptar {

  static Scanner scanner = new Scanner(System.in);

  public static void desencriptarFichero (String ficheroLeido, String ficheroEscrito) {
    int clave = -1;
    String diccionarioPrincipal = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789"; // 64 caracteres
    while (clave == -1) {
      try {
        System.out.println("Indica clave a utilizar en el fichero: ");
        clave = -(scanner.nextInt());
      } catch (Exception e){
        System.out.println("La clave debe ser un número entero positivo.");
      }
    }  
    // Leemos archivo recibido y guardamos en variable.
    try {
      var f = new BufferedReader(new FileReader("src/encriptacion/"+ficheroLeido));
      String linea;
      StringBuilder lectura = new StringBuilder();

      while ((linea= f.readLine()) != null) {
        lectura.append(linea + "\n");;
      }
      int posicion = lectura.length();
      f.close();

      // Abrimos archivo para escritura.
      var fw = new BufferedWriter(new FileWriter("src/encriptacion/"+ficheroEscrito));

      StringBuilder escritura = new StringBuilder();
      for (int i=0; i < posicion-1;i++) {
        String caracterABuscar = Character.toString(lectura.charAt(i));
        if (diccionarioPrincipal.contains(caracterABuscar)){
          int indice = diccionarioPrincipal.indexOf(caracterABuscar);
          if (indice + clave >= 0) {
            escritura.append(diccionarioPrincipal.charAt(indice+clave));
          } else {
            escritura.append(diccionarioPrincipal.charAt(indice+clave+64));
          }
        } else {
          escritura.append(lectura.charAt(i));
        }

      }
      fw.write(escritura.toString());
      fw.close();
      //System.out.println(escritura.toString());
      System.out.println("Archivo desencriptado correctamente.");
    } catch (Exception e) {
      System.out.println("Archivo no encontrado");
      System.exit(1);
    }
  }

}
