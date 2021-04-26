/**
 * 
 */
package gestisimal.negocio;


public class PreciosArticuloException extends Exception {


  private static final long serialVersionUID = 1L;


  public PreciosArticuloException() {
    super("Precio no valido!");
  }


  public PreciosArticuloException(String message) {
    super(message);
  }


}
