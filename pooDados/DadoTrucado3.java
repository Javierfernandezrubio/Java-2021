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
 *  -Version 2.0: 
 *      -Version inicial
 * 
 * 
 * @author javier
 *
 */
public class DadoTrucado3 extends DadoSimple{

  // Atributos
  private static final int CARAS_MAXIMAS = 6;
  private HashMap<Integer,Double> dado = new HashMap<Integer,Double>(CARAS_MAXIMAS);
  private int cara;
  
  public DadoTrucado3() {
    for ( int i = 0; i < CARAS_MAXIMAS; ++i ) { // Rellenamos el dicionarios con cada cara y probabilidad 0.0
      this.dado.put(i+1, -1.0);
    }
  }
  
  public void trucar(int cara, double probabilidad) {
    
    if ( cara < 1 || cara > 6 || probabilidad < 0 || probabilidad > 1 ) {
      System.err.print("No se puede poner valores mayores o menores de 1 a " + CARAS_MAXIMAS +
          " y probabilidad menor ni mayor de 0 a 1.");
    }
    
    
    this.dado.replace(cara, probabilidad);
    
    
    
  }
  
  
  
  
  
  
  
  

}
