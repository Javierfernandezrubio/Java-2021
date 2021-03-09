package programacionOrientadaObjetos.Tanda2;

import java.util.Arrays;

/**
 * Esta clase implementará una estructura de datos tipo lista de números
 * enteros.
 * 
 * Estado de los objetos:
 * 
 * - content: array de enteros donde guardaremos los elementos de la lista. 
 * - size: número de elementos guardados en la lista.
 * 
 * Comportamiento:
 * 
 * - ListInteger(): crea una lista vacía cuyo tamaño máximo va a estar
 * determinado por una constante de la clase (10).
 * 
 * - ListInteger(ele1, ..., eleN): crea una lista con los elementos ele1 ...
 * eleN.
 * 
 * - pop(): me devuelve el último elemento de la lista y lo saca de la lista.
 * 
 * - pop(posición): me devuelve el elemento que está en "posición" y lo saca de
 * la lista.-
 * 
 * - remove(elemento): borra la primera ocurrencia de "elemento" en la lista.
 * Devolverá true o false en función del éxito de la operación.
 * 
 * - insert(elemento): añadir "elemento" al final de la lista. Devolveremos true
 * o false en función del éxito de la operación.
 * 
 * - insert(elemento, posición): añadir "elemento" en la posición "posición" de
 * la lista. Devolveremos true o false en función del éxito de la operación.
 * 
 * - clear(): vacía la lista.
 * 
 * - isFull(): me dice si la lista está llena.
 * 
 * - isEmpty(): me dice si la lista está vacía.
 * 
 * - resize(): cambia el tamaño máximo de la lista si el nuevo tamaño máximo no
 * es menor que el número de elementos que tiene. Devolveremos true o false en
 * función del éxito de la operación.
 * 
 * - contentSize(): nos devuelve el número de elementos que hay en la lista.
 * 
 * - maxSize(): tamaño máximo de la lista.
 * 
 * 
 * @author Javier Fernandez Rubio
 * @version 1.0
 * Fecha 01/02/2021
 *
 */

public class IntegerList implements Cloneable, Comparable<IntegerList> {

  // variables de clase

  private static final int DEFAULT_MAX_SIZE = 10;

  // variables de instancia

  private int[] content;
  private int size;

  // Comportamiento

  // Constructores

  /**
   * Constructor de la clase
   * 
   */
  IntegerList() {
    this.size = 0;
    this.content = new int[DEFAULT_MAX_SIZE];
  }


  /**
   * Constructor alternativo que permite la creacion de objetos
   * pasando como parametro el tamaño de array que va atener la lista
   * 
   * 
   * @param tamanno
   */
  IntegerList(int tamanno) {
    this.size = 0;
    this.content = new int[tamanno];
  }

  /**
   * 2º constructor pasandole los elemento del array, donde:
   * 
   * 1. Comprobar si el número de parámetros que llegan es mayor que DEFAULT_MAX_SIZE,
   * si lo es el tamaño máximo de mi array aumenta a esta cantidad.
   * 
   * 2. Crear el nuevo array con el tamaño máximo y asignarle los elementos
   * recibidos como parámetro.
   * 
   * 3. Poner el valor correcto de size.
   * 
   * @param content
   */
  IntegerList(int... content) {
    this.size = content.length;

    // Comprobamos si el nº de parametros pasados es mayor que DEFAULT_MAX_SIZE
    if ( content.length > DEFAULT_MAX_SIZE ) {
      this.content = new int[content.length];  // Ponemos nuevo tamaño
    } else {
      this.content = new int[DEFAULT_MAX_SIZE]; // Ponemos tamaño por defecto
    }

    for (int i = 0; i < content.length; ++i) {
      this.content[i] = content[i];
    }


  }


  // Getters y Setters

  /**
   * @return the content
   */
  public int[] getContent() {
    return content;
  }

  /**
   * @param content the content to set
   */
  public void setContent(int[] content) {
    this.content = content;
  }

  /**
   * @return the size
   */
  public int getSize() {
    return size;
  }

  /**
   * @param size the size to set
   */
  public void setSize(int size) {
    this.size = size;
  }


  //resto métodos

  @Override
  public int compareTo(IntegerList lista) {
    return this.size - lista.size;
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + Arrays.hashCode(content);
    result = prime * result + size;
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
    IntegerList other = (IntegerList) obj;
    if (!Arrays.equals(content, other.content))
      return false;
    if (size != other.size)
      return false;
    return true;
  }

  @Override
  public String toString() {
    // Uso de metodos especiales de los Arrays para facilitar el toSting
    int[] arrayAux = Arrays.copyOfRange(this.content, 0, this.size);
    return Arrays.toString(arrayAux);
  }

  @Override
  public IntegerList clone() {
    IntegerList clon = new IntegerList();

    clon.size = this.contentSize();
    clon.content = this.content;

    return clon;
  }

  /**
   * Añade un elemento al final de la lista.
   * 
   * @param element
   * @return éxito de la operación
   */
  public boolean insert(int element) {
    int elementos = this.contentSize() + 1;
    int tamanno = this.maxSize();

    if ( elementos <= tamanno  ) {
      this.content[elementos-1] = element;
      this.setSize(elementos);
      return true;
    } else {
      return false;
    }

  }

  /**
   * Añade un elemento en la posición indicada de la lista.
   * 
   * @param element
   * @param pos
   * @return éxito de la operación
   */
  public boolean insert(int element, int pos) {
    int elementos = this.contentSize() + 1;
    int tamanno = this.maxSize();

    // Comprobacion si la lista esta llena o pos es negativo
    if ( this.isFull() || pos < 0 ) {
      return false;
    }

    // Co probacion de si la pos pasada es mayor
    if ( pos > this.maxSize() ) {
      pos = this.maxSize();
    }

    if ( elementos < tamanno || pos <= tamanno  ) {
      for ( int i = tamanno - 1; i >= 0; i-- ) {
        if ( i == pos - 1 ) {
          this.content[i] = element;
        } else if ( i < pos - 1 ) {
          this.content[i] = this.content[i];
        } else {
          this.content[i] = this.content[i - 1];
        }
      }
      this.setSize(elementos);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Devuelve el último elemento de la lista y lo elimina.
   * 
   * @return último elemento de la lista
   */
  public int pop() {
    if ( this.isEmpty() ) {
      System.err.println("Error. La Lista es vacia.");
      return 0;
    }

    int ultimoElemento = this.content[this.contentSize() - 1]; // Recoleccion del ultimo elemento

    this.content[this.contentSize() - 1] = 0; // Eliminación del ultimo elemento

    this.setSize(this.contentSize() - 1); // Reduccion del Size

    return ultimoElemento;
  }


  public int pop(int pos) {
    // lista vacía o posición inexistente (deberíamos lanzar una excepción, en una siguiente versión)
    if (this.isEmpty() || pos >= this.size || pos < 0) {   
      System.err.println("Excepción. Posición errónea.");
      return 0;
    }

    // situación común
    int aDevolver = this.content[pos];
    for (int i = pos; i < this.size-1; i++) {
      this.content[i] = this.content[i+1];
    }
    --this.size;
    return aDevolver;
  }

  /**
   * Borra la primera ocurrencia de un elemento en la lista.
   * 
   * @param element
   * @return éxito de la operación.
   */
  public boolean remove(int element) {
    if ( this.isEmpty() ) {
      System.err.println("Error. La Lista es vacia.");
      return false;
    }

    int pos = contentSize();

    for (int i = 0; i < pos; i++) {
      if (this.content[i] == element) {
        this.content[i] = 0;
        pos = i;
      } 
    }

    if (pos != contentSize()) {
      for (int i = pos; i < contentSize(); i++) {
        this.content[i] = this.content[i + 1];
      }
      this.size = this.size - 1;
      return true;
    } 
    return false;
  }

  /**
   * Vacía la lista.
   */
  public void clear() {
    for ( int i = 0; i < this.content.length; ++i ) {
      this.content[i] = 0;
    }
    this.setSize(0); 
  }

  /**
   * 
   * @return si la lista está llena.
   */
  public boolean isFull() {
    return this.contentSize() == this.maxSize();
  }

  /**
   * 
   * @return devuelve si la lista está vacía.
   */
  public boolean isEmpty() {
    return this.contentSize() == 0 ;

  }

  /**
   * Cambia el tamaño máximo de la lista si el nuevo tamaño máximo no es menor que
   * el número de elementos que tiene.
   * 
   * @return éxito de la operación.
   */
  public boolean resize(int nuevoTamanno) {
    if (nuevoTamanno <= this.contentSize()) {
      return false;
    }


    int[] arrayAux = new int[nuevoTamanno]; // nuevo array al que copiamos los datos de la lista
    for (int i = 0; i < this.size; i++) {
      arrayAux[i] = this.content[i];
    }
    this.content = arrayAux;
    return true;
  }

  /**
   * Metodo resize2 que devuelve un nuevo objeto con el nuevo tamaño del array
   * y con los mismo elementos del objeto actual
   * 
   * 
   * @param nuevoTamanno
   * @return
   */
  public IntegerList resize2(int nuevoTamanno) {
    /* if ( nuevoTamanno <= DEFAULT_MAX_SIZE && nuevoTamanno > this.size ) {
      this.size = nuevoTamanno;
    } else {*/
    IntegerList nuevaLista = new IntegerList(nuevoTamanno);
    for ( int i = 0; i < this.size; ++i ) {
      nuevaLista.content[i] = this.content[i];
    }
    return nuevaLista;
  }


  /**
   * 
   * @return número de elementos que hay en la lista.
   */
  public int contentSize() {
    return this.size;
  }

  /**
   * 
   * @return máximo número de elementos que caben en la lista.
   */
  public int maxSize() {
    return this.content.length;
  }

}