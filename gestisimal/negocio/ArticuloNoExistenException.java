/**
 * 
 */
package gestisimal.negocio;


public class ArticuloNoExistenException extends Exception {

  private static final long serialVersionUID = 1L;

  public ArticuloNoExistenException(String message) {
    super(message);
  }
}
