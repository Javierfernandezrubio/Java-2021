/**
 * 
 */
package simulacionExamenSegundoTrimestre;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import utilidades.Menu;

/**
 * @author javier
 *
 */
public class TestCiclistaConMenu {

  static Menu menuPrincipal = new Menu("Cargar datos etapa", "Mostrar ganador de la vuelta", "Mostrar ganador de una etapa",
      "Mostrar ganadores de cada etapa", "Guardar ganadores de cada etapa en un fichero CSV", "Mostrar tablas de tiempos",
      "Salir");

  static Campeonato campeonato = new Campeonato();



  public static void main(String[] args) throws Exception {

    boolean datosCargados = false;

    do {
      try {
        switch (menuPrincipal.escoger()) {
          case 1:
            cargarCSV();
            System.out.println(campeonato);
            datosCargados = true;
            pausa();
            break;
          case 2:
          case 3:
          case 4:
          case 5:
          case 6:

            if (datosCargados) {
              switch(menuPrincipal.escoger()) {

                case 2:
                  //ganadorVuelta();
                  pausa();
                  break;
                case 3:
                  ganadorEtapa();
                  pausa();
                  break;
                case 4:
                  //ganadoresCadaEtapa();
                  pausa();
                  break;
                case 5:
                  ganadoresCadaEtapaCsv();
                  pausa();
                  break;
                case 6:
                  //mostrarTablasTiempo();
                  pausa();
                  break;
              }
              pausa();
            } else {
              System.out.println("\nCarga primero los datos, dale a la opción 1 antes de continuar.\n");
            }
            break;

          default:
            System.out.println("Adios");
            return;

        }
      } catch (InputMismatchException e) {
        System.out.println("Debes insertar un número");
      }

    } while (true);
  }


  private static void ganadorEtapa() {
    try {
      int etapa;
      do {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dame un etapa: ");
        etapa = sc.nextInt();
      } while (etapa < 0 || etapa > 5);
      
      System.out.println(campeonato.ganadorEtapa(etapa));
    } catch (Exception e) {
      System.out.println("Error!");
    }
  }


  private static void ganadoresCadaEtapaCsv() {
    // TODO Auto-generated method stub
    
  }


  //Metodos
  
  private static void pausa() {
    Scanner s = new Scanner(System.in);
    System.out.print("\n\nPulse INTRO para continuar....");
    s.nextLine();
    System.out.println();
  }
  
  private static void cargarCSV() throws Exception {
    try {
      Scanner s = new Scanner(System.in);
      System.out.print("\nNombre del fichero con formato CSV: ");
      String fichero = s.nextLine();
      
      campeonato = Campeonato.importarCSV(fichero);
      campeonato = ordenarCiclistas(campeonato);
    } catch (IOException e) {
      System.err.println("Ha habido problemas al cargar el fichero.\n");
    }
    
  }


  private static Campeonato ordenarCiclistas(Campeonato campeonato) {
    Campeonato campeonatoOrdenado = new Campeonato();
    Ciclista ciclistaX;
    int j = 0;
    for (int i = 0; i < campeonato.size(); i++) {
      ciclistaX = campeonato.get(i);
      
      if (ciclistaX.compareTo(campeonato.get(j)) > 0) {
        if (!campeonatoOrdenado.contains(campeonato.get(j))) {
          campeonatoOrdenado.add(ciclistaX);
        }
      } else {
        campeonatoOrdenado.add(ciclistaX);
      }
      j++;
    }
    

    
    
    return campeonatoOrdenado;
  }
  
}
