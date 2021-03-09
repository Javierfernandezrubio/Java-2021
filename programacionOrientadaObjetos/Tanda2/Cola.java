/**
 * 
 */
package programacionOrientadaObjetos.Tanda2;

/**
 * Clase Cola que deriva de la superclase Rectangulo
 * 
 * 
 * @author javier fernandez rubio
 * @version 1.0
 * Fecha 11-02-2021
 *
 */
public class Cola extends IntegerList {

  /**
   * Constructor de la clase Cola sin valores
   * 
   * 
   */
  Cola() {
    super();
  }

  /**
   * Constructor con de la clase Cola con valores
   * 
   * 
   * @param content
   */
  Cola(int... content){
    super(content);
  }

  /**
   * Constructor con el tamaño de la Cola
   * 
   * @param tamanno
   */
  Cola(int tamanno) {
    super(tamanno);
  }
  
//Metodos nuevos
  
 /**
  * Metodo push:  se añade un elemento a la cola. Se añade al final de esta.
  * 
  * @param element
  */
 public void push(int element) {
   super.insert(element, this.contentSize() - 1);
 }
 
 
 /**
  * Metodo front: Leer el elemento frontal de la cola, es decir, 
  * el primer elemento que entró, sin retirarlo.
  * 
  */
 public int front() {
   int[] arrayAux = super.getContent();
   return arrayAux[0];
 }
  

}
