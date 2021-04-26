/**
 * 
 */
package gestisimal.negocio;

/**
 * Clase Artículo que representa a los artículos del almacén.
 * 
 * -Su estado será: código, descripción, precio de compra, precio de venta, número de unidades (nunca
 * negativas), stock de seguridad y stock máximo. 
 * 
 * -Como comportamiento: Consideramos que el código va
 * a generarse de forma automática en el constructor, así no puede haber dos artículos con el mismo
 * código. Esto implica que no puede modificarse el código de un artículo, sí el resto de las
 * propiedades. Podremos mostrar el artículo, por lo que necesito una representación del artículo en
 * forma de cadena (toString).
 * 
 * 
 * @author javier fernandez rubio
 * @version 1.0
 *
 */
public class Articulo {

  // Atributos

  private static int articulosCreados = 0; // Contabilizador de articulos creados
  
  private int codigo;
  
  private String nombreArticulo;
  
  private String descripcion;
  
  private double precioCompra;
  
  private double precioVenta;
  
  private int numUnidades;
  
  private int stockSegu;
  
  private int stockMax;
  
  // Constructores
  Articulo(String nombre, String descripcion, double precioCompra, double precioVenta, int numUnidades, int stockSegu, int stockMax) throws UnidadesNegativasArticuloException, StockSeguridadException, StockMaximoException, PreciosArticuloException {
    
    this.nombreArticulo = nombre;
    setDescripcion(descripcion);
    setPrecioCompra(precioCompra);
    setPrecioVenta(precioVenta);
    setNumUnidades(numUnidades);
    setStockSegu(stockSegu);
    setStockMax(stockMax);
    
    // Generamos el codigo unico usando el nombre del articulo
    this.codigo = this.generarCodigo();
  }
  
  Articulo(String nombre, String descripcion) {
    this.nombreArticulo = nombre;
    setDescripcion(descripcion);
    
    // Generamos el codigo unico usando el nombre del articulo
    this.codigo = this.generarCodigo();
  }
  
  Articulo(int codigo){
    this.codigo = codigo;
  }
  
  /**
   * Metodo que genera un codigo unico para un Articulo.
   * Usará el nombre del Articulo más articulosCreados.
   * 
   * Formato: articulosCreados++
   * 
   * @return 
   */
  private int generarCodigo() {
    return articulosCreados++;
  }

  // Getters y Setters

  int getCodigo() {
    return codigo;
  }
  
  public String getNombreArticulo() {
    return nombreArticulo;
  }
  
  public void setNombreArticulo(String nombreArticulo) throws IllegalArgumentException{
    this.nombreArticulo = nombreArticulo;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) throws IllegalArgumentException{
    this.descripcion = descripcion;
  }

  public double getPrecioCompra() {
    return precioCompra;
  }

  public void setPrecioCompra(double precioCompra) {
    if (precioCompra < 0) {
      throw new IllegalArgumentException("Precio dado negativo.");
    }
    this.precioCompra = precioCompra;
  }

  public double getPrecioVenta() {
    return precioVenta;
  }

  public void setPrecioVenta(double precioVenta) {
    if (precioVenta < 0) {
      throw new IllegalArgumentException("Precio dado negativo.");
    }
    this.precioVenta = precioVenta;
  }

  public int getNumUnidades() {
    return numUnidades;
  }

  public void setNumUnidades(int numUnidades) {
    if (numUnidades < 0) {
      throw new IllegalArgumentException("No puede haber una cantidad negativa de este articulo.");
    }
    this.numUnidades = numUnidades;
  }

  public int getStockSegu() {
    return stockSegu;
  }

  public void setStockSegu(int stockSegu) {
    //if ( stockSegu < STOCK_SEGURIDAD ) {
      //throw new StockSeguridadException("Stock de Seguridad erroneo.");
    //}
    if ( stockSegu < 0) {
      throw new IllegalArgumentException("Introducido un numero negativo");
    }
    this.stockSegu = stockSegu;
  }

  public int getStockMax() {
    return stockMax;
  }

  public void setStockMax(int stockMax) {
    //if ( stockMax < this.stockSegu ) {
      //throw new StockMaximoException();
    //}
    if ( stockMax < 0) {
      throw new IllegalArgumentException("Introducido un numero negativo");
    }
    this.stockMax = stockMax;
  }
  
  // Otros Métodos
  
  public void incrementarUnidades(int unidades) throws UnidadesNegativasArticuloException {
    if ( unidades < 0 ) {
      throw new IllegalArgumentException("Introducido un numero negativo");
    }
    this.setNumUnidades(this.numUnidades + Math.abs(unidades));
  }
  
  public void decrementarUnidades(int unidades) throws UnidadesNegativasArticuloException {
    if ( unidades < 0 ) {
      throw new IllegalArgumentException("Introducido un numero negativo");
    }
    if ( unidades > this.numUnidades ) {
      throw new UnidadesNegativasArticuloException("Parametro mayor al numero de unidades en Stock");
    }
    this.setNumUnidades(this.numUnidades - Math.abs(unidades));
  }
  
 
  // Equals y HashCode
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + codigo;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Articulo other = (Articulo) obj;
    if (codigo != other.codigo)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Nombre: " + this.nombreArticulo + ". Codigo: " + this.codigo + ".\n";
  }
  
}
