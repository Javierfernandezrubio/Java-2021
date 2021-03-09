/**
 * 
 */
package pooDados;

import java.util.HashMap;

/**
 * Clase DadoTrucado usando HashMap.
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
 * Fecha 20-02-2021
 * 
 *  -Version 1.0: 
 *      -Version inicial
 *      
 */
public class DadoTrucado2 extends DadoSimple{

  // Atributos
  private static final int CARAS_MAXIMAS = 6;
  private HashMap<Integer,Double> dado = new HashMap<Integer,Double>(CARAS_MAXIMAS);

  // Constructor
  public DadoTrucado2() {
  }
  
  
  public boolean trucarValor(int valor, double probabilidades) {

    if ( valor < 1 || valor > 6 || probabilidades < 0 || probabilidades > 1 ) {
      return false;
    }


    if ( this.dado == null) {
      for ( int i = 0; i < CARAS_MAXIMAS; ++i ) { // Rellenamos el dicionarios con cada cara y probabilidad 0.0
        this.dado.put(i+1, -1.0);
      }
      // Suma de probabilidades no es > 1
    } else if ( ! this.esProbabilidadCorrecta(valor,probabilidades) ) {
      return false; 
    }

    this.dado.replace(valor, probabilidades);
    return true;
  }
  
  
  public boolean esProbabilidadCorrecta(int valor, double probabilidad) {
    
    // Calculamos la suma de probabilidades y vemos si es menor que 1
    double sumaProbabilidadesTrucadas = probabilidad;
    for (int k: this.dado.keySet() ) {
      if (this.dado.get(k) > 0.0) {
        sumaProbabilidadesTrucadas += this.dado.get(k);
      }
    }
    if (this.dado.get(valor) > 0) { // esta cara ya estaba trucada de antes y se ha sumado de mas
      sumaProbabilidadesTrucadas -= this.dado.get(valor);
    }
    
    return sumaProbabilidadesTrucadas <= 1;
  }
  
  
  @Override
  public int getValor() {
    return 0;
  }

  @Override
  public void tirar() {
    
    // Si no hay truco
    if ( this.dado == null ) {
      super.tirar();
      //this.valorTrucado = super.getValor();
      return;
    }
    
    // Necesitamos conocer la probabilidad de cada número, trucados o no, para ello tengo que saber
    // primero cuantos números hay trucados y la suma de sus probabilidades. 
    // Con esto puedo calcular la probabilidad de aparición de los números no trucados.
    
    int numeroTrucados = 0;
    double sumaProbalidadesTrucadas = 0;
    double probabilidadNoTrucados = 0;
    
    for ( double p: this.dado.keySet() ) { // cálculo de la suma números y probabilidades trucadas
      if ( this.dado.get(p) >= 0 ) {
        numeroTrucados++;
        sumaProbalidadesTrucadas += this.dado.get(p);
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
    int i = 1;
    do {
      ++i;
      ++this.valorTrucado;
      if (this.probabilidad[this.valorTrucado-1] < 0) { // no es una cara del dado trucada
        sumaProbabilidades += probabilidadNoTrucados;
      } else {
        sumaProbabilidades += this.probabilidad[this.valorTrucado-1];
      }
      
    } while (sumaProbabilidades < aleatorio && this.dado.keySet(i) < 6);
    
    
  }
  
  
  
}
