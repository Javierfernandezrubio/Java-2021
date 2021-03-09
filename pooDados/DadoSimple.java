/**
 * 
 */
package pooDados;

/**
 * Clase Dado.
 * 
 * Estado: valor del dado (1 a 6). 
 * Comportamiento: tirar el dado y obtener su valor.
 * 
 * 
 * @author javier fernandez rubio
 * @version 1.0
 * Fecha 18-02-2021
 * 
 *  -Version 1.0: 
 *      -Version inicial
 *
 */
public class DadoSimple {

  // Atributos
  private int valor;

  // Constructor
  public DadoSimple() {
    this.tirar();
  }

  // Metodos
  /**
   * @return the valor
   */
  public int getValor() {
    return valor;
  }
  
  public void tirar() {
    this.valor = (int)(Math.random()*6 + 1);
  }
}
