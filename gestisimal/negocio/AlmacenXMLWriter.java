/**
 * 
 */
package gestisimal.negocio;

import java.io.FileWriter;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * @author javier
 *
 */
class AlmacenXMLWriter {

  private Almacen almacen;
  private Document ficheroXML;

  AlmacenXMLWriter(Almacen almacen) {
    this.almacen = almacen;
  }

  void guardarXML(String fichero) throws AlmacenXMLException, IOException {
    try {   
      crearDocumentoXML();
      saveRoot();
      for (Articulo articulo : almacen) {
        guardarArticulo(articulo);
      }
      guardarFichero(fichero);

    } catch (ParserConfigurationException | TransformerException e) {
      throw new AlmacenXMLException("Error al generar XML: " + e.getMessage());
    }
  }

  private void crearDocumentoXML() throws ParserConfigurationException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    ficheroXML = builder.newDocument();
  }

  private void saveRoot() {
    Element root = ficheroXML.createElement(AlmacenXML.ALMACEN);
    ficheroXML.appendChild(root);
  }

  private void guardarArticulo(Articulo articulo) {
    Element root = ficheroXML.getDocumentElement();

    Element articuloElement = ficheroXML.createElement(AlmacenXML.ARTICULO);
    root.appendChild(articuloElement);

    guardarCamposArticulo(AlmacenXML.NOMBRE, articulo.getNombreArticulo(), articuloElement);
    guardarCamposArticulo(AlmacenXML.DESCRIPCION, articulo.getDescripcion(), articuloElement);
    guardarCamposArticulo(AlmacenXML.PRECIO_COMPRA, Double.toString(articulo.getPrecioCompra()), articuloElement);
    guardarCamposArticulo(AlmacenXML.PRECIO_VENTA, Double.toString(articulo.getPrecioVenta()), articuloElement);
    guardarCamposArticulo(AlmacenXML.NUMERO_UNIDADES, Integer.toString(articulo.getNumUnidades()), articuloElement);
    guardarCamposArticulo(AlmacenXML.STOCK_SEGURIDAD, Integer.toString(articulo.getStockSegu()), articuloElement);
    guardarCamposArticulo(AlmacenXML.STOCK_MAXIMO, Integer.toString(articulo.getStockMax()), articuloElement);
  }

  private void guardarCamposArticulo(String attr, String value, Element contactElement) {
    Element attrElement = ficheroXML.createElement(attr);
    attrElement.appendChild(ficheroXML.createTextNode(value));
    contactElement.appendChild(attrElement);
  }

  private void guardarFichero(String fichero) throws IOException, TransformerException {
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    DOMSource xmlSource = new DOMSource(ficheroXML);
    StreamResult output = new StreamResult(new FileWriter(fichero));
    transformer.transform(xmlSource, output);
  }

}
