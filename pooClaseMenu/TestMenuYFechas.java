/**
 * 
 */
package pooClaseMenu;

import java.util.ArrayList;

/**
 * Test donde generamos un menu con opciones hecho exclusivo para la manipulacion
 * de fechas
 * 
 * 
 * 
 * @author javier fernandez rubio
 * @version 1.0
 * Fecha 14-02-2021
 *
 */
public class TestMenuYFechas {

  /**
   * @param args
   */
  public static void main(String[] args) {
    
    ArrayList<String> opciones = new ArrayList<String>();
    opciones.add("Primera opcion");
    opciones.add("Segunda opcion");
    opciones.add("Tercera opcion");
    
    
    Menu menuEjemplo = new Menu(opciones);
    Menu menuEjemplo2 = new Menu("Sumar", "Dividir", "Restar");
    
    
    
    menuEjemplo2.mostrarMenu();
    menuEjemplo2.escoger();
    menuEjemplo2.annadir("Cuarta opcion");
    
    menuEjemplo2.mostrarMenu();
    
    
  }
}
