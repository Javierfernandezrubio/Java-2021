/**
 * 
 */
package apiRest;

import java.io.IOException;

/**
 * Test para probar el uso de APIRest en Java y la API
 * de Open
 * 
 * 
 * @author javier
 *
 */
public class TestApiTiempo {

  public static void main(String[] args) {
    validarArgs(args);
    String ciudad = args[0];
    
    try {
      
      
      String archivoJSON = GeneradorJSON.getResponseOpenWheather(ciudad);
      
      
      GeneradorJSON.generadorTiempo5Dias(archivoJSON);
      
      
    } catch (IOException | InterruptedException e) {
      System.out.println("Error con el archivo Json");
    }
  }

  private static void validarArgs(String[] args) {
    if (args.length != 1) {
      System.err.println("Numero de argumentos erroneo!");
      System.exit(1);
    }
  }

}
