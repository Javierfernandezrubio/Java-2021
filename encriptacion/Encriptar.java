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
 * - Crea un programa que encripte un fichero que le pasamos como parámetro y almacene el resultado
 * en otro, que también pasamos como parámetro, de manera que:
 * 
 * .Si el programa no recibe el número de parámetros adecuado termina con un error 1. 
 * .Si el programa recibe un solo parámetro guardará la información encriptada en el mismo archivo del que lee, pero
 * antes advertirá al usuario de que machacará el archivo origen, dando opción a que la operación no
 * se haga. 
 * .Si el fichero origen no existe (da error al abrirlo como lectura) el programa termina
 * con un mensaje de error y código 2. 
 * .Si en el fichero destino no se puede escribir (da error al abrirlo como escritura) el programa 
 * termina con un mensaje de error y código 3. 
 * .Para encriptar usa el método César, necesitarás una clave que debes pedir al usuario.
 * 
 * 
 * @author javier
 *
 */
public class Encriptar {
  static Scanner scanner = new Scanner(System.in);

  public static void encriptarFichero (String ficheroLeido, String ficheroEscrito) {
    boolean seguirEnElCiclo = true;
    String diccionarioPrincipal = "abcdefghijklmnñopqrstuvwxyzABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789"; // 64 caracteres
    int clave = 0;
    do {
      try {
        System.out.println("Indica clave a utilizar en el fichero: ");
        clave = scanner.nextInt();
        seguirEnElCiclo = false;
      } catch (Exception e){
        System.out.println("La clave debe ser un número entero positivo.");
        scanner.nextLine(); // esta línea vacia el buffer para evitar entrar en un cilo infinito.
      }
    } while (seguirEnElCiclo);

    try {
      var f = new BufferedReader(new FileReader("src/encriptacion/"+ficheroLeido));
      String linea;
      StringBuilder lectura = new StringBuilder();

      while ((linea=f.readLine()) != null) {
        lectura.append(linea + "\n");
      }
      int posicion = lectura.length();
      f.close();

      // Abrimos archivo para escritura.
      var  fw = new BufferedWriter(new FileWriter("src/encriptacion/"+ficheroEscrito));

      StringBuilder escritura = new StringBuilder();
      for (int i=0; i < posicion-1;i++) {
        String caracterABuscar = Character.toString(lectura.charAt(i));
        if (diccionarioPrincipal.contains(caracterABuscar)){
          int indice = diccionarioPrincipal.indexOf(caracterABuscar);
          // Esta función falla en caso de utilizar claves muy grandes o negativas, falla.
          if (indice + clave < 64) {
            escritura.append(diccionarioPrincipal.charAt(indice+clave));
          } else {
            escritura.append(diccionarioPrincipal.charAt(indice+clave-64));
          }
        } else {
          escritura.append(lectura.charAt(i));
        }

      }
      fw.write(escritura.toString());
      fw.close();
      //System.out.println(escritura.toString());
      System.out.println("Archivo encriptado correctamente.");
    } catch (Exception e) {
      System.out.println("Archivo no encontrado");
      System.exit(1);
    }
  }
}
