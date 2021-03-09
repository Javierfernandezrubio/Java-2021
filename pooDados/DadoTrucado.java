/**
 * 
 */
package pooDados;

/**
 * Clase DadoTrucado usando Arrays.
 * 
 * Estado: valor del dado y probabilidad de aparición de los números especiales (aquellos que se
 * desea favorecer). 
 * 
 * Comportamiento: tirar el dado, obtener su valor y establecer la probabilidad de
 * aparición para un valor concreto.
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
public class DadoTrucado extends DadoSimple {

  // Atributos
  private int valorTrucado;
  private double[] probabilidad;
  
  // Constructor
  public DadoTrucado() {
    //this.tirar();
  }
  
  
  public boolean trucarValor(int valor, double probabilidades) {
    
    if ( valor < 1 || valor > 6 || probabilidades < 0 || probabilidades >1 ) {
      return false;
    }
    
    
    
    // Si es el primer valor a trucar creamos el array de probabilidades
    if ( this.probabilidad == null) {
      this.probabilidad = new double[6];
      for ( int i = 0; i < 6; ++i ) {
        this.probabilidad[i] = -1;
      }
      // Suma de probabilidades no es > 1
    } else if ( ! this.esProbabilidadCorrecta(valor,probabilidades) ) {
      return false; 
    }
    
    this.probabilidad[valor - 1] = probabilidades;
    return true;
  }
  
  
  public boolean esProbabilidadCorrecta(int valor, double probabilidad) {
    
    // Calculamos la suma de probabilidades y vemos si es menor que 1
    double sumaProbabilidadesTrucadas = probabilidad;
    for (double p: this.probabilidad) {
      if (p >= 0) {
        sumaProbabilidadesTrucadas += p;
      }
    }
    if (this.probabilidad[valor - 1] > 0) { // esta cara ya estaba trucada de antes y se ha sumado de mas
      sumaProbabilidadesTrucadas -= this.probabilidad[valor-1];
    }
    
    return sumaProbabilidadesTrucadas <= 1;
  }
  

  @Override
  public int getValor() {
    return valorTrucado;
  }

  @Override
  public void tirar() {
    
    // Si no hay truco
    if ( this.probabilidad == null ) {
      super.tirar();
      this.valorTrucado = super.getValor();
      return;
    }
    
    // Necesitamos conocer la probabilidad de cada número, trucados o no, para ello tengo que saber
    // primero cuantos números hay trucados y la suma de sus probabilidades. 
    // Con esto puedo calcular la probabilidad de aparición de los números no trucados.
    
    int numeroTrucados = 0;
    double sumaProbalidadesTrucadas = 0;
    double probabilidadNoTrucados = 0;
    
    for ( double p: this.probabilidad ) { // cálculo de la suma números y probabilidades trucadas
      if ( p >= 0 ) {
        numeroTrucados++;
        sumaProbalidadesTrucadas += p;
      }
    }
    
    if ( numeroTrucados < 6 ) { // por si estuvieran todos trucados
      probabilidadNoTrucados = (1-sumaProbalidadesTrucadas) / (6-numeroTrucados);
    }

    double aleatorio = Math.random(); // me servirá para escoger el valor del dado
      
    // Me quedo con la cara del dado cuya probabilidad de aparición, sumada a las anteriores, 
    // supere el valor aleatorio
    double sumaProbabilidades = 0;
    this.valorTrucado = 0;
    do {
      ++this.valorTrucado;
      if (this.probabilidad[this.valorTrucado-1] < 0) { // no es una cara del dado trucada
        sumaProbabilidades += probabilidadNoTrucados;
      } else {
        sumaProbabilidades += this.probabilidad[this.valorTrucado-1];
      }
      
    } while (sumaProbabilidades < aleatorio && valorTrucado < 6);
    
    
  }
  

}
