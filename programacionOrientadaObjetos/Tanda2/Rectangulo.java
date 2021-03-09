/**
 * 
 */
package programacionOrientadaObjetos.Tanda2;


/**
 * Crea una clase que represente objetos de tipo Rectángulo, de forma que:
 * 
 * En el estado de cada objeto guardemos el ancho y el alto del mismo. Usaremos estos datos para
 * construirlo.
 * 
 * Las acciones que podemos realizar con objetos de esta clase son: Cálculo del perímetro. Cálculo
 * del área. Dibujarlo (con *). Compararlo con otros. Devolver una copia del mismo en otro objeto
 * (clonarlo). Transformar su estado a una cadena (toString()).
 * 
 * 
 * @author javier fernandez rubio
 * @version 1.1 
 * Fecha 03/02/2021
 * 
 *      Version 1.1:
 *          - Añadido de Equals y HashCode.
 *      
 *
 */
public class Rectangulo implements Cloneable, Comparable<Rectangulo> {

  // Atributos
  private double ancho;
  private double alto;

  /**
   * Constructor de la clase
   * 
   * @param ancho
   * @param alto
   */
  Rectangulo(double ancho, double alto) {
    this.ancho = ancho;
    this.alto = alto;
  }

  // Getters y Setters

  /**
   * @return the ancho
   */
  public double getAncho() {
    return ancho;
  }

  /**
   * @param ancho the ancho to set
   */
  public void setAncho(double ancho) {
    this.ancho = ancho;
  }

  /**
   * @return the alto
   */
  public double getAlto() {
    return alto;
  }

  /**
   * @param alto the alto to set
   */
  public void setAlto(double alto) {
    this.alto = alto;
  }


  // ToString, Cloneable, CompareTo, Equals y HashCode

  @Override
  public String toString() {
    return "Rectangulo [ancho=" + ancho + ", alto=" + alto + "]";
  }

  @Override
  public int compareTo(Rectangulo otro) {
      return (int) (this.area() - otro.area());
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    long temp;
    temp = Double.doubleToLongBits(alto);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    temp = Double.doubleToLongBits(ancho);
    result = prime * result + (int) (temp ^ (temp >>> 32));
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
    Rectangulo other = (Rectangulo) obj;
    if (Double.doubleToLongBits(alto) != Double.doubleToLongBits(other.alto))
      return false;
    if (Double.doubleToLongBits(ancho) != Double.doubleToLongBits(other.ancho))
      return false;
    return true;
  }

  @Override
  public Rectangulo clone() {
    return new Rectangulo(this.ancho, this.alto);
  }


  // Retos de Metodos

  /**
   * Metodo que devuelve el perimetro tras pasarle ancho y alto
   * 
   * @param ancho
   * @param alto
   * @return
   */
  public double perimetro(double ancho, double alto) {
    return (2 * alto) + (2 * ancho);
  }

  /**
   * Metodo que devuelve el perimetro del objeto
   * 
   * @return
   */
  public double perimetro() {
    return (2 * this.ancho) + (2 * this.alto);
  }

  /**
   * Metodo que devuelve el area tras pasarle ancho y alto
   * 
   * @param ancho
   * @param alto
   * @return
   */
  public double area(double ancho, double alto) {
    return alto * ancho;
  }

  /**
   * Metodo que devuelve el area del objeto
   * 
   * @return
   */
  public double area() {
    return this.ancho * this.alto;
  }

  /**
   * Metodo que dibuja por pantalla el Rectangulo
   * 
   */
  public void dibujar() {
    int alto = (int) Math.round(this.alto * 10d / 10d);
    int ancho = (int) Math.round(this.ancho * 10d / 10d);

    System.out.println("*".repeat(ancho));
    for (int i = 1; i < alto; ++i) {
      System.out.print("*");
      for (int o = 1; o <= ancho; ++o) {
        System.out.print(" ");
      }
      System.out.println("*");
    }
    System.out.println("*".repeat(ancho));
  }

}
