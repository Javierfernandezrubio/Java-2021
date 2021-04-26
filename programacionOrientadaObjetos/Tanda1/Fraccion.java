/**
 * 
 */
package programacionOrientadaObjetos.Tanda1;

/**
 * Clase Fraccion de forma que podamos hacer las siguientes operaciones:
 * 
 * · Contruir un objeto Fraccion pasándole el numerador y el denominador. · Obtener la fracción como
 * cadena de caracteres. · Obtener y modificar numerador y denominador. No se puede dividir por
 * cero. · Obtener resultado de la fracción (número real). · Multiplicar la fracción por un número
 * (el resultado es otro objeto fracción). · Multiplicar, sumar y restar fracciones (el resultado es
 * otro objeto fracción). · Simplificar la fracción (cambia el objeto actual).
 * 
 * 
 * @author javier fernandez rubio
 * @version 1.2 Fecha 01/02/2021
 *
 *          - Version 1.2: -Añadidos interfaz Cloneable y Comparable
 */
public class Fraccion implements Cloneable, Comparable<Fraccion> {

  // Atributos

  private int numerador;
  private int denominador;

  /*
   * try { Persona persona = new Persona(); persona.setEdad(-10); }catch( RuntimeException e) {
   * System.out.println(e.getMessage()); }
   */

  /**
   * Constructor de la calse Fraccion
   * 
   * @param a numerador
   * @param b denominador
   */
  public Fraccion(int a, int b) {
    this.numerador = a;
    this.denominador = b;
  }


  // Getters y Setters

  /**
   * @return the numerador
   */
  public int getNumerador() {
    return numerador;
  }

  /**
   * @param numerador the numerador to set
   */
  public void setNumerador(int numerador) {
    this.numerador = numerador;
  }

  /**
   * @return the denominador
   */
  public int getDenominador() {
    return denominador;
  }

  /**
   * @param denominador the denominador to set
   */
  public void setDenominador(int denominador) {
    this.denominador = denominador;

    if (denominador == 0) {
      // throw new RuntimeException("El denominador no puede ser cero.");
      System.err.println("El denominador no puede ser cero.");
    }
  }


  /**
   * Formateo de la Fraccion en forma de cadena
   */
  @Override
  public String toString() {
    return "Fraccion [numerador=" + numerador + ", denominador=" + denominador + "]";
  }


  @Override
  public int compareTo(Fraccion otra) {




    int resultado = 0;
    if (this.equals(otra)) {
      resultado = 0;
    } else if (this.resultado() < otra.resultado()) {
      resultado = -1;
    } else {
      resultado = 1;
    }
    return resultado;
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + denominador;
    result = prime * result + numerador;
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
    Fraccion other = (Fraccion) obj;
    if (denominador != other.denominador)
      return false;
    if (numerador != other.numerador)
      return false;
    return true;
  }


  @Override
  public Fraccion clone() {
    Fraccion clon = new Fraccion(this.numerador, this.denominador);
    return clon;
  }


  // Resto de métodos

  /**
   * Resultado de la fraccion en número real
   * 
   * @return resultado en numero real
   */
  public double resultado() {
    return (double) (this.numerador / this.denominador);
  }

  /**
   * Multiplica la fraccion por un numero generando un numero objeto Fraccion
   * 
   * @param numero
   * @return
   */
  public Fraccion multiplicar(int numero) {
    return new Fraccion(numero * this.numerador, this.denominador);
  }

  /**
   * Multiplica un objeto fraccion con otro objeto fraccion
   * 
   * @param otraFraccion
   * @return
   */
  public Fraccion multiplicarFrac(Fraccion otraFraccion) {
    return new Fraccion(this.numerador * otraFraccion.numerador,
        this.denominador * otraFraccion.denominador);
  }

  /**
   * Simplificar una fraccion
   * 
   */
  public void simplificar() {
    int dividir = mcd();
    this.numerador /= dividir;
    this.denominador /= dividir;
  }

  /**
   * Metodo privado para calcular el multiplo comun denominador
   * 
   * @return numera multiplo comun denominador
   */
  private int mcd() {
    int numera = Math.abs(this.numerador);
    int denomina = Math.abs(this.denominador);
    if (denomina == 0) {
      return numera;
    }
    int resto;
    while (denomina != 0) {
      resto = numera % denomina;
      numera = denomina;
      denomina = resto;
    }
    return numera;
  }


  /**
   * Suma de dos objetos Fraccion
   * 
   * @param otraFraccion
   * @return fraccionResultante objeto de tipo Fraccion
   */
  public Fraccion sumarFrac(Fraccion otraFraccion) {
    if (this.denominador == otraFraccion.denominador) {
      return new Fraccion(this.numerador + otraFraccion.numerador, this.denominador);
    } else {
      return new Fraccion(
          this.numerador * otraFraccion.denominador + this.denominador * otraFraccion.numerador,
          this.denominador * otraFraccion.denominador);
    }
  }

  /**
   * Resta de dos objetos Fraccion
   * 
   * @param otraFraccion
   * @return fraccionResultante objeto de tipo Fraccion
   */
  public Fraccion restarFrac(Fraccion otraFraccion) {
    if (this.denominador == otraFraccion.denominador) {
      return new Fraccion(this.numerador - otraFraccion.numerador, this.denominador);
    } else {
      return new Fraccion(
          this.numerador * otraFraccion.denominador - this.denominador * otraFraccion.numerador,
          this.denominador * otraFraccion.denominador);
    }

  }

}
