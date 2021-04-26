/**
 * 
 */
package gestisimal.negocio;

public class StockSeguridadException extends Exception {


  private static final long serialVersionUID = 1L;

  public StockSeguridadException() {
    super("Stock de Seguridad demasiado bajo.");
  }
  
  public StockSeguridadException(String message) {
    super(message);
  }


}
