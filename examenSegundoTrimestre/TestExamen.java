/**
 * 
 */
package examenSegundoTrimestre;

import java.io.IOException;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import utilidades.Menu;

/**
 * Test de las clases Estudiantes y Calificaciones
 * 
 * @author javier fernandez rubio
 *
 */
public class TestExamen {

  private static final int NUM_NOTAS = 5;

  static Menu menuPrincipal = new Menu("Cargar datos alumnos", 
      "Mostrar la cantidad de estudiantes que han entregado todos los ejercicios y tienen una mediasuperior o igual a un 5.", 
      "Mostrar el número de estudiantes que han presentado un ejercicio dado.",
      "Dado el número de un ejercicio, mostrar la nota media obtenida por los estudiantes que lo presentaron", 
      "Dado el número de un ejercicio, mostrar la nota más alta obtenida y quién (quienes) la obtuvo (obtuvieron)", 
      "Mostrar la media más alta y quién (quienes) la obtuvo (obtuvieron). Para que la media sea distinta de 0 tiene que haber entregado TODOS los ejercicios",
      "Mostrar la relación de estudiantes y sus notas",
      "Guardar en un fichero XML las calificaciones de cada estudiante y su media",
      "Finalizar");

  static Calificaciones clase = new Calificaciones();
  

  public static void main(String[] args) throws Exception {
    Scanner s = new Scanner(System.in);
    int ejercicioEscogido = 0;
    boolean datosCargados = false;

    do {
      try {
        switch (menuPrincipal.escoger()) {
          case 1:
            cargarCSV();
            System.out.println(clase);
            datosCargados = true;
            pausa();
            break;
          case 2:
          case 3:
          case 4:
          case 5:
          case 6:
          case 7:
          case 8:

            if (datosCargados) {
              switch(menuPrincipal.escoger()) {

                case 2:
                  System.out.println("Opción no disponible!");
                  //cantidadEstudiantesSuperior5(clase);
                  break;
                case 3:
                  do {
                    System.out.print("Dame el numero del ejercicio(1-" + NUM_NOTAS + "): ");
                    ejercicioEscogido = s.nextInt();
                  } while (ejercicioEscogido < 1 || ejercicioEscogido > NUM_NOTAS);
                  int alumnos = alumnosEjercicioHechos(ejercicioEscogido);
                  System.out.println("\nAlumnos que han hecho el ejercicio " + ejercicioEscogido
                      + " son " + alumnos);
                  break;
                case 4:
                  do {
                    System.out.print("Dame el numero del ejercicio(1-" + NUM_NOTAS + "): ");
                    ejercicioEscogido = s.nextInt();
                  } while (ejercicioEscogido < 1 || ejercicioEscogido > NUM_NOTAS);
                  double media = notaMediaPresentados(ejercicioEscogido);
                  System.out.println("\nLa nota media es de " + media);
                  break;
                case 5:
                  do {
                    System.out.print("Dame el numero del ejercicio(1-" + NUM_NOTAS + "): ");
                    ejercicioEscogido = s.nextInt();
                  } while (ejercicioEscogido < 1 || ejercicioEscogido > NUM_NOTAS);
                  int notaMaxima = calcularNotaMaxima(ejercicioEscogido);
                  Estudiantes alumno = calcularAlumnoNotaMaxima(ejercicioEscogido);
                  System.out.println(
                      "\nLa nota maxima del ejercicio " + ejercicioEscogido + " es de " + notaMaxima
                      + " y pertenece al alumno " + alumno.getNombre());
                  break;
                case 6:
                  mostrarMediaMasAlta();
                  break;
                case 7:
                  mostrarTodasNotas();
                  break;
                case 8:
                  exportarFicheroXML();
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
  

  private static void pausa() {
    Scanner s = new Scanner(System.in);
    System.out.print("\n\nPulse INTRO para continuar....");
    s.nextLine();
    System.out.println();
  }
  

  /**
   * Metodo que carga informacion del archivo CSV
   * @throws Exception 
   */
  private static void cargarCSV() throws Exception {
    try {
      Scanner s = new Scanner(System.in);
      System.out.print("\nNombre del fichero con formato CSV: ");
      String fichero = s.nextLine();
      
      clase = Calificaciones.importarCSV(fichero);
      ordenarAlumnos(clase);
    } catch (IOException e) {
      System.err.println("Ha habido problemas al cargar el fichero.\n");
    } catch (Exception e) {
      System.err.println("El formato del Archivo es Erroneo!.\n");
    }

  }

  private static void ordenarAlumnos(Calificaciones clase2) {
    Collections.sort(clase2);
  }
  
  
  private static int alumnosEjercicioHechos(int ejercicioEscogido) {
    return clase.estudiantesEjercicioHechos(ejercicioEscogido);
  }
  
  private static double notaMediaPresentados(int ejercicioEscogido) {
    return clase.notaMediaPresentados(ejercicioEscogido);
  }

  
  private static int calcularNotaMaxima(int ejercicioEscogido) {
    return clase.notaMaximaEjercicio(ejercicioEscogido);
  }
  
  private static Estudiantes calcularAlumnoNotaMaxima(int ejercicioEscogido) {
    return clase.alumnoNotaMaximaEjercicio(ejercicioEscogido);
  }
  
  
  private static void mostrarTodasNotas() {
    System.out.println(clase);
  }



  private static void mostrarMediaMasAlta() {
    double mediaAlta = clase.notaMediaAlta();
    String[] alumnosMedia = clase.estudiantesMediaAlta();
    
    System.out.println("La nota media más alta es de: " + mediaAlta);
    System.out.println("Y los alumnos que la tienen son :");
    for (int i = 0; i < alumnosMedia.length; ++i) {
      if (alumnosMedia[i] != null) {
        System.out.println(alumnosMedia[i]);
      }
    }
  }

  
  private static void exportarFicheroXML() {
    try {
      Scanner s = new Scanner(System.in);
      System.out.print("\nNombre del fichero con formato XML que quires crear: ");
      String fichero = s.nextLine();
      clase.saveXML(fichero);

    } catch (IOException e) {
      System.err.println("No se ha podido exportar a XML: " + e.getMessage() + "\n");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
