/**
 * 
 */
package programacionOrientadaObjetos.Tanda2;

/**
 * Clase Pila que es una subclase de la clase IntegerList
 * 
 * 
 * 
 * @author javier fernandez rubio
 * @version 1.0
 * Fecha 10-02-2021
 *
 */
public class Pila extends IntegerList{

  /**
   * Constructor de la clase Pila sin valores
   * 
   * 
   */
  Pila() {
    super();
  }
  
  /**
   * Constructor con de la clase Pila con valores
   * 
   * 
   * @param content
   */
  Pila(int... content){
    super(content);
  }

  /**
   * Constructor con el tamaño de la pila
   * 
   * @param tamanno
   */
  public Pila(int tamanno) {
    super(tamanno);
    // TODO Auto-generated constructor stub
  }

  // ToString
  @Override
  public String toString() {
    return super.toString();
  }

  @Override
  public void clear() {
    // TODO Auto-generated method stub
    super.clear();
  }

  @Override
  public boolean isFull() {
    // TODO Auto-generated method stub
    return super.isFull();
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return super.isEmpty();
  }

  @Override
  public boolean resize(int nuevoTamanno) {
    // TODO Auto-generated method stub
    return super.resize(nuevoTamanno);
  }

  @Override
  public int contentSize() {
    // TODO Auto-generated method stub
    return super.contentSize();
  }

  // Metodos nuevos
  
  /**
   * Metodo push:  se añade un elemento a la pila. Se añade al principio de esta.
   * 
   * @param element
   */
  public void push(int element) {
    super.insert(element, 0);
  }
  
  /**
   * Metodo pop: se saca (debe devolverse) un elemento de la pila y se elimina.
   * 
   * @param element
   * @return
   */
  public int pop(int element) {
    super.remove(element);
    return element;
  }
  
  
  /**
   * Metodo top: Leer el elemento superior de la pila sin retirarlo.
   * 
   * 
   */
  public int top() {
    int[] arrayAux = super.getContent();
    return arrayAux[this.contentSize() - 1];
  }

}
