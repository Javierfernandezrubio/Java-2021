/**
 * 
 */
package gestisimal.negocio;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase Almacén que realice el alta, baja, modificación, entrada de mercancía (incrementa
 * unidades), salida de mercancía (decrementa unidades). 
 * 
 * El estado será un ArrayList de artículos. Esta clase es un envoltorio de un ArrayList. 
 * 
 * -Su comportamiento será: añadir artículos (no puede haber dos artículos iguales), 
 * eliminar artículos, incrementar las existencias de un artículo (se delega en la clase Artículo), 
 * decrementar las existencias de un artículo (nunca por debajo de cero, se delega en la clase Artículo), 
 * devolver un artículo (para mostrarlo). Para listar el almacén podría devolverse una cadena con 
 * todos los artículos del almacén (toString).
 * 
 * @author javier fernandez rubio
 * @version 1.0
 *
 */
public class Almacen extends ArrayList<Articulo>{

  // Atributos

  private static final long serialVersionUID = 1L;

  private static final String CSV_CABECERA = "Nombre,Descripcion,Precio de Compra,Precio de Venta,Numero de Unidades,Stock Seguridad,Stock Maximo";

  //private ArrayList<Articulo> almacen;


  /*Almacen() {
    this.almacen = new ArrayList<Articulo>();
  }*/


  // Metodos

  public void annadirArticulo(String nombre, String descripcion, double precioCompra, double precioVenta, int numUnidades, int stockSegu, int stockMax) throws ArticuloYaExistenteException, UnidadesNegativasArticuloException, StockSeguridadException, StockMaximoException, PreciosArticuloException {

    Articulo nuevo = new Articulo(nombre, descripcion, precioCompra, precioVenta, numUnidades, stockSegu, stockMax);

    if (!this.contains(nuevo)) {
      this.add(nuevo);
    } else {
      throw new ArticuloYaExistenteException("Este articulo ya existe en el inventario del almacen.");
    }

  }



  public void eliminarArticulo(int codigo) throws ArticuloNoExistenException{
    if (!(this.remove(new Articulo(codigo)))) {
      throw new ArticuloNoExistenException("Articulo no existente en el almacen.");
    } 
  }


  public void incrementarUnidades(int codigo, int unidades) throws UnidadesNegativasArticuloException {
    getArticulo(codigo).incrementarUnidades(unidades);
  }

  public void decrementarUnidades(int codigo, int unidades) throws UnidadesNegativasArticuloException {
    getArticulo(codigo).decrementarUnidades(unidades);
  }

  public Articulo getArticulo(int codigo) {
    return this.get(this.indexOf(new Articulo(codigo)));
  }


  @Override
  public String toString() {
    Almacen almacen = (Almacen) this.clone();
    String toString = getClass().getSimpleName() + " [\n";
    for (Articulo c: almacen) {
      toString += c + "\n";    
    }
    toString += "]";
    return toString;
  }


  // Metodos para CSV  XML  JSON

  /**
   * Guarda el almacen como fichero CSV.
   * 
   */
  public void exportarCSV(String fichero) throws IOException {
    AlmacenCSV.guardar(this, fichero);
  }

  /**
   * Metodo para importar un archivo CSV y cargarlo 
   * 
   * @param fichero
   * @return
   * @throws IOException
   * @throws AlmacenCSVException 
   * @throws PreciosArticuloException 
   * @throws StockMaximoException 
   * @throws StockSeguridadException 
   * @throws UnidadesNegativasArticuloException 
   */
  static public Almacen importarCSV(String fichero) throws IOException, AlmacenCSVException, UnidadesNegativasArticuloException, StockSeguridadException, StockMaximoException, PreciosArticuloException {
    var nuevoAlmacen = AlmacenCSV.cargar(fichero);
    return nuevoAlmacen;
  }

  /**
   * Guarda el almacen como fichero XML.
   * @throws AlmacenXMLException 
   * 
   */
  public void exportarXML(String fichero) throws IOException, AlmacenXMLException {
    AlmacenXML.guardar(this, fichero);
  }

  static public Almacen importarXML(String fichero) throws IOException, AlmacenXMLException, UnidadesNegativasArticuloException, StockSeguridadException, StockMaximoException, PreciosArticuloException, AlmacenXMLException {
    var nuevoAlmacen = AlmacenXML.cargar(fichero);
    return nuevoAlmacen;
  }

  /**
   * Guarda el almacen como fichero JSON.
   * @throws AlmacenXMLException 
   * 
   */
  public void exportarJSON(String fichero) throws IOException, AlmacenJSONException {
    AlmacenJSON.guardar(this, fichero);
  }

  static public Almacen importarJSON(String fichero) throws IOException, AlmacenJSONException, UnidadesNegativasArticuloException, StockSeguridadException, StockMaximoException, PreciosArticuloException, AlmacenXMLException, AlmacenJSONException {
    var nuevoAlmacen = AlmacenJSON.cargar(fichero);
    return nuevoAlmacen;
  }


  /**
   * Metodo privado para obtener un objeto de tipo Articulo
   * 
   * 
   * @param nombre
   * @param codigo
   * @param descripcion
   * @param precioCompra
   * @param precioVenta
   * @param numUnidades
   * @param stockSegu
   * @param stockMax
   * @return
   * @throws UnidadesNegativasArticuloException
   * @throws StockSeguridadException
   * @throws StockMaximoException
   * @throws PreciosArticuloException
   */
  private static Articulo getArticulo(String nombre, String descripcion,
      String precioCompra, String precioVenta, String numUnidades, String stockSegu,
      String stockMax) throws UnidadesNegativasArticuloException, StockSeguridadException, StockMaximoException, PreciosArticuloException {

    // Paso de String a double o int debido l constructor de Articulo
    //int codigoI = Integer.parseInt(codigo);
    double precioCompraD = Double.parseDouble(precioCompra);
    double precioVentaD = Double.parseDouble(precioVenta);
    int numUnidadesI = Integer.parseInt(numUnidades);
    int stockSeguI = Integer.parseInt(stockSegu);
    int stockMaxI = Integer.parseInt(stockMax);

    Articulo articulo;
    articulo = new Articulo(nombre, descripcion, precioCompraD, precioVentaD, numUnidadesI, stockSeguI, stockMaxI);
    //if (! email.isBlank()) {
    //contact.setEmail(email);
    //}
    //if (! phone.isBlank()) {
    // contact.setPhone(phone);
    // }
    return articulo;
  }


}
