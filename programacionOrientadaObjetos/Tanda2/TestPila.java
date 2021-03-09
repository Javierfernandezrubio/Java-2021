/**
 * 
 */
package programacionOrientadaObjetos.Tanda2;

/**
 * @author javier
 *
 */
public class TestPila {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    
    Pila pilaVacia = new Pila();
    Pila pilaMedia = new Pila(1,2,3,4,5);
    Pila pilaLlena = new Pila(1,2,3,4,5,6,7,8,9,10);
    Pila pilaTamanno = new Pila(15);
    
    System.out.println("Pila vacia: "+pilaVacia);
    System.out.println("Pila media: "+pilaMedia);
    System.out.println("Pila llena: "+pilaLlena);
    System.out.println("Pila tamaño: "+pilaTamanno);

  }

}
