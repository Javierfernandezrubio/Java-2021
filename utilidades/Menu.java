package utilidades;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Muestra un menú con las siguientes opciones:
 * 
 * -Introducir (por teclado) una fecha pidiendo por teclado año, mes y día en formato dd/mm/aaaa. 
 * Si no se introduce correctamente se devuelve un mensaje de error. Usa una función booleana 
 * para validar la fecha. 
 * -Añadir días a la fecha. Pide un número de días para sumar a la fecha
 * introducida previamente y actualiza su valor. Si el número es negativo restará los días. Esta
 * opción sólo podrá realizarse si hay una fecha introducida (se ha ejecutado la opción anterior),
 * si no la hay mostrará un mensaje de error. Añadir meses a la fecha. El mismo procedimiento que la
 * opción anterior. Añadir años a la fecha. El mismo procedimiento que la opción 2. Comparar la
 * fecha introducida con otra. Pide una fecha al usuario en formato dd/mm/aaaa (válida, si no lo es
 * da error) y la comparará con la que tenemos guardada, posteriormente mostrará si esta fecha es
 * anterior, igual o posterior a la que tenemos almacenada y el número de días comprendido entre las
 * dos fechas. Mostrar la fecha en formato largo (ejemplo: "lunes, 1 de febrero de 2021"). Terminar.
 * 
 * Consideraciones a tener en cuenta:
 * 
 * El menú lo hacemos con una clase a la que llamaremos Menú, esa clase permitirá ir añadiendo
 * opciones y escoger alguna opción. 
 * 
 * Las fechas las manejaremos con la clase LocalDate.
 * 
 * 
 * @author javier fernandez rubio
 * @version 1.0
 * Fecha 14-02-2021
 * @param <Arraylist>
 *
 */
public class Menu {
  
  // Atributos
  private int cantidadOpciones;
  private ArrayList<String> opciones = new ArrayList<String>();
  


  public Menu(ArrayList<String> conjuntoOpciones){
    this.cantidadOpciones = conjuntoOpciones.size();
    this.opciones = conjuntoOpciones;
  }


  public Menu(String... opciones) {
    this.cantidadOpciones = opciones.length;
    for (String string : opciones) {
      this.opciones.add(string);
    }
      
  }
  



  /**
   * @return the cantidadOpciones
   */
  public int getCantidadOpciones() {
    return cantidadOpciones;
  }



  /**
   * @param cantidadOpciones the cantidadOpciones to set
   */
  public void setCantidadOpciones(int cantidadOpciones) {
    this.cantidadOpciones = cantidadOpciones;
  }



  /**
   * @return the opciones
   */
  public ArrayList<String> getOpciones() {
    return opciones;
  }



  /**
   * @param opciones the opciones to set
   */
  public void setOpciones(ArrayList<String> opciones) {
    this.opciones = opciones;
  }


  /**
   * Metodo para mostrar el menu por pantalla
   * 
   */
  public void mostrarMenu() {
    //System.out.println("Menu de opciones");
    //System.out.println("Estas son tus opciones:");
    for (int i = 0; i < this.cantidadOpciones; i++ ) {
      System.out.println(i+1 + ". " + this.opciones.get(i));
    }
    
  }
  
  
  public int escoger() {
    int opcionEscogida;
    Scanner s = new Scanner(System.in);
    
    // Muestra del Menu con sus opciones
    this.mostrarMenu();
    
    // Escogida de la opción
    
    // comprobación de que la opcion es correcta
    
    do {
      System.out.println("Escoge una opción(1-" + this.cantidadOpciones + "): ");
      opcionEscogida = s.nextInt();
      if  ( opcionEscogida < 1 || opcionEscogida > this.cantidadOpciones ){
        System.out.println("Opción escogida no existe.");
      }
    } while ( opcionEscogida < 1 || opcionEscogida > this.cantidadOpciones );
    
    
    
    return opcionEscogida;
  }
  
  public void annadir(String opcion) {
    ++this.cantidadOpciones;
    this.opciones.add(opcion);
  }
  
  
  
  
}
