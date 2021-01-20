/**
 * 
 */
package programacionOrientadaObjetos;

/**
 * Clase Fraccion de forma que podamos hacer las siguientes operaciones:
 * 
 * Contruir un objeto Fraccion pasándole el numerador y el denominador. Obtener
 * la fracción como cadena de caracteres. Obtener y modificar numerador y
 * denominador. No se puede dividir por cero. Obtener resultado de la fracción
 * (número real). Multiplicar la fracción por un número (el resultado es otro
 * objeto fracción). Multiplicar, sumar y restar fracciones (el resultado es
 * otro objeto fracción). Simplificar la fracción (cambia el objeto actual).
 * 
 * 
 * @author javier fernandez rubio
 * @version 1.0 
 * Fecha 19/01/2021
 *
 */
public class Fraccion {

	// Atributos

	private int numerador;
	private int denominador;

	/*try
	{
		Persona persona = new Persona();
		persona.setEdad(-10);
	}catch(
	RuntimeException e)
	{
    System.out.println(e.getMessage());
	}*/

	/**
	 * Constructor de la calse Fraccion
	 * 
	 * @param a numerador
	 * @param b denominador
	 */
	public Fraccion(int a, int b) {
		if (b == 0) {
			throw new RuntimeException("El denominador no puede ser cero.");
		}

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
		if (denominador == 0) {
			throw new RuntimeException("El denominador no puede ser cero.");
		}

		this.denominador = denominador;
	}

	// ToString

	@Override

	/**
	 * Formateo de la Fraccion en forma de cadena
	 */
	public String toString() {
		return "Fraccion [numerador=" + numerador + ", denominador=" + denominador + "]";
	}

	// Resto de métodos

	/**
	 * Resultado de la fraccion en número real
	 * 
	 * @param fraccion
	 * @return
	 */
	public double resultado(Fraccion fraccion) {

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
		return new Fraccion(this.numerador * otraFraccion.numerador, this.denominador * otraFraccion.denominador);
	}
	
	/**
	 * Simplificar una fraccion
	 * 
	 * @param numero
	 */
	public void simplificar(int numero) {
		if ( this.numerador % numero == 0 && this.denominador % numero == 0 ) {
			this.numerador = this.numerador  / numero;
			this.denominador = this.denominador / numero;
		}
	}
	
	
	/**
	 * Suma de dos objetos Fraccion
	 * 
	 * @param otraFraccion
	 * @return fraccionResultante objeto de tipo Fraccion
	 */
	public Fraccion sumarFrac(Fraccion otraFraccion) {
		if ( this.denominador == otraFraccion.denominador ) {
			return new Fraccion(this.numerador + otraFraccion.numerador, this.denominador );
		} else {
			return new Fraccion(this.numerador*otraFraccion.denominador + this.denominador*otraFraccion.numerador, this.denominador*otraFraccion.denominador );
		}
		
	}
	
	/**
	 * Suma de dos objetos Fraccion
	 * 
	 * @param otraFraccion
	 * @return fraccionResultante objeto de tipo Fraccion
	 */
	public Fraccion restarFrac(Fraccion otraFraccion) {
		if ( this.denominador == otraFraccion.denominador ) {
			return new Fraccion(this.numerador - otraFraccion.numerador, this.denominador );
		} else {
			return new Fraccion(this.numerador*otraFraccion.denominador - this.denominador*otraFraccion.numerador, this.denominador*otraFraccion.denominador );
		}
		
	}
	
	
	

}
