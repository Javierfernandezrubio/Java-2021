/**
 * 
 */
package gestisimal.negocio;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author javier
 *
 */
class AlmacenXML {

  static final String ALMACEN = "almacen";
  static final String ARTICULO = "articulo";
  static final String NOMBRE = "nombre";
  static final String DESCRIPCION = "descripcion";
  static final String PRECIO_COMPRA = "precio_compra";
  static final String PRECIO_VENTA = "precio_venta";
  static final String NUMERO_UNIDADES = "unidades";
  static final String STOCK_SEGURIDAD = "stock_seguridad";
  static final String STOCK_MAXIMO = "stock_maximo";
  
  static void guardar(Almacen almacen, String fichero) throws FileNotFoundException, IOException, AlmacenXMLException {
    var escritura = new AlmacenXMLWriter(almacen);
    escritura.guardarXML(fichero);
  }
  
  static Almacen cargar(String fichero) throws IOException, AlmacenXMLException, UnidadesNegativasArticuloException, StockSeguridadException, StockMaximoException, PreciosArticuloException {
    var lectura = new AlmacenXMLReader();
    lectura.cargarXML(fichero);
    return lectura.getAlmacen();
  }
}
