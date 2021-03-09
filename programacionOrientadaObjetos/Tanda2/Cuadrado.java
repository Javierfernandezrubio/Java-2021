/**
 * 
 */
package programacionOrientadaObjetos.Tanda2;

/**
 * Crea la clase Cuadrado partiendo de la clase Rectángulo (hereda de esta) del
 * ejercicio anterior. Consideraciones:
 * 
 * Un cuadrado es un rectángulo con base==altura. 
 * El constructor de la clase Cuadrado solo tendrá un parámetro, su lado. 
 * No hay que crear atributos nuevos.
 * 
 * 
 * @author javier fernandez rubio
 * @version 1.0
 * Fecha 01/02/2021
 *
 */
public class Cuadrado extends Rectangulo {

  Cuadrado(double lado) {
    super(lado, lado);
  }

  // Metodos

  /**
   * 
   * @param lado
   */
  public void setLado(double lado) {
    super.setAlto(lado);
    super.setAncho(lado);
  }

  /**
   * 
   * @return
   */
  public double getLado() {
    return this.getAncho();
  }

  @Override
  public String toString() {
    return "Cuadrado, Lado = " +this.getLado();
  }

  @Override
  public void setAncho(double lado) {
    this.setLado(lado);
  }

  @Override
  public void setAlto(double lado) {
    this.setLado(lado);
  }

  @Override
  public Cuadrado clone() {
    return new Cuadrado(this.getLado());
  }
  


}
