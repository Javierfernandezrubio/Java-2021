/**
 * 
 */
package gestisimal.negocio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Clase del paquete que te permite leer ficheros de tipo CSV para
 * cargar sus datos en memoria.
 * 
 * @author javier
 *
 */
class AlmacenCSVReader {
  
  private Almacen almacen;
  private BufferedReader nuevoFichero;

  AlmacenCSVReader() {
    this.almacen = new Almacen();
  }
  
  AlmacenCSVReader(Almacen almacen) {
    this.almacen = almacen;
  }
  
  Almacen getAlmacen() {
    return almacen;
  }

  void cargar(String fichero) throws IOException, AlmacenCSVException {
    nuevoFichero = Files.newBufferedReader(Paths.get(fichero));
    validarCabeceraCSV();
    
    String linea;
    while ((linea = nuevoFichero.readLine()) != null) {
      Articulo articulo = cargarArticuloCSV(linea);
      almacen.add(articulo);
    }
    nuevoFichero.close();
  }

  

  void validarCabeceraCSV() throws IOException, AlmacenCSVException {
    String cabecera = nuevoFichero.readLine().trim();
    if (! AlmacenCSV.CSV_CABECERA.equalsIgnoreCase(cabecera)) {
      throw new AlmacenCSVException("Cabecera errónea en el CSV.");
    }
  }
  
  private static Articulo cargarArticuloCSV(String linea) throws AlmacenCSVException {
    validarArticuloCSV(linea);
    String[] camposArticulo = linea.split("\","); // solo las comas de separación de campos

    // Extraemos los campos del articulo quitando las comillas de inicio y fin
    String nombre = camposArticulo[0].replace("\"", "");
    //String codigo = camposArticulo[1].replace("\"", "");
    String descripcion = camposArticulo[1].replace("\"", "");
    double precioCompra = Double.parseDouble(camposArticulo[2].replace("\"", ""));
    double precioVenta = Double.parseDouble(camposArticulo[3].replace("\"", ""));
    int numUnidades = Integer.parseInt(camposArticulo[4].replace("\"", ""));
    int stockSegu = Integer.parseInt(camposArticulo[5].replace("\"", ""));
    int stockMax = Integer.parseInt(camposArticulo[6].replace("\"", ""));

    Articulo articulo;
    try {
      articulo = new Articulo(nombre, descripcion, precioCompra, precioVenta, numUnidades, stockSegu, stockMax);
    } catch (Exception e) {
      throw new AlmacenCSVException("Articulo erroneo!");
    }

    return articulo;
  }

  private static void validarArticuloCSV(String linea) throws AlmacenCSVException {
    int camposPorLinea = linea.split("\",").length;   // solo las comas de separación de campos
    int camposPorArticulo = AlmacenCSV.CSV_CABECERA.split(",").length;

    if (camposPorLinea != camposPorArticulo) {
      throw new AlmacenCSVException(linea + ": no es un formato válido para convertirlo en Articulo.");
    }
  }

}
