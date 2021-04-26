/**
 * 
 */
package gestisimal.negocio;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author javier
 *
 */
class AlmacenXMLReader {

  private Almacen almacen;
  private Document ficheroXML;

  AlmacenXMLReader() {
    this.almacen = new Almacen();
  }

  AlmacenXMLReader(Almacen almacen) {
    this.almacen = almacen;
  }

  Almacen getAlmacen() {
    return almacen;
  }

  /**
   * Rellena el xml a partir del fichero CSV.
   * @throws PreciosArticuloException 
   * @throws StockMaximoException 
   * @throws StockSeguridadException 
   * @throws UnidadesNegativasArticuloException 
   */
  void cargarXML(String fichero) throws IOException, AlmacenXMLException, UnidadesNegativasArticuloException, StockSeguridadException, StockMaximoException, PreciosArticuloException {
    try { 
      cargarDocumentoXML(fichero);
      NodeList articulos = ficheroXML.getElementsByTagName(AlmacenXML.ARTICULO);
      for (int i = 0; i < articulos.getLength(); i++) {
        Articulo articulo = nuevoArticulo(articulos.item(i));
        almacen.add(articulo);
      }

    } catch (ParserConfigurationException | SAXException | ArticuloErrorException e) {
      throw new AlmacenXMLException("Error al cargar XML: " + e.getMessage());
    } 
  }

  private void cargarDocumentoXML(String fichero) throws ParserConfigurationException, SAXException, IOException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    ficheroXML = builder.parse(new File(fichero));
    ficheroXML.getDocumentElement().normalize();
  }

  private static Articulo nuevoArticulo(Node itemArticulo) throws UnidadesNegativasArticuloException, StockSeguridadException, StockMaximoException, PreciosArticuloException {
    String nombre = cargarCamposArticulo(AlmacenXML.NOMBRE, itemArticulo);
    String descripcion = cargarCamposArticulo(AlmacenXML.DESCRIPCION, itemArticulo);
    double precioCompra = Double.parseDouble(cargarCamposArticulo(AlmacenXML.PRECIO_COMPRA, itemArticulo));
    double precioVenta = Double.parseDouble(cargarCamposArticulo(AlmacenXML.PRECIO_VENTA, itemArticulo));
    int numUnidades = Integer.parseInt(cargarCamposArticulo(AlmacenXML.NUMERO_UNIDADES, itemArticulo));
    int stockSegu = Integer.parseInt(cargarCamposArticulo(AlmacenXML.STOCK_SEGURIDAD, itemArticulo));
    int stockMax = Integer.parseInt(cargarCamposArticulo(AlmacenXML.STOCK_MAXIMO, itemArticulo));
    return new Articulo(nombre, descripcion, precioCompra, precioVenta, numUnidades, stockSegu, stockMax);
  }

  private static String cargarCamposArticulo(String campo, Node itemArticulo) {
    Element elementContact = (Element) itemArticulo;
    String textField = elementContact.getElementsByTagName(campo).item(0).getTextContent();
    return textField;
  }

}
