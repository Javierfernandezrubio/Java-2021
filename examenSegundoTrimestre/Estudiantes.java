/**
 * 
 */
package examenSegundoTrimestre;

import examenSegundoTrimestreRafa.ErrorEstudianteException;

/**
 * 
 * Clase Estudiantes conformado por su nombre y sus notas.
 * 
 * @author javier fernandez rubio
 *
 */
public class Estudiantes implements Comparable<Estudiantes>{

  String nombre;
  int[] notas = new int[5];

  public Estudiantes(String nombre, int[] notas) {
    this.nombre = nombre;
    this.notas = notas;
  }


  public String getNombre() {
    return nombre;
  }


  public int[] getNotas() {
    return notas;
  }
  
  public String getNotasString(int[] notas) {
    return notas.toString();
  }

  public int getNotaEjercicio(int ejercicio) {
    return this.notas[ejercicio - 1];
  }
  
  public void setNota(int ejercicio, int nota) {
    if (nota < -1 || nota > 10) {
      throw new ErrorEstudianteException("Valor de nota erróneo: " + nota);
    }
    notas[ejercicio - 1] = nota;
  }
  
  public boolean haRealizadoEjercicio(int ejercicio) {
    return (getNotaEjercicio(ejercicio) != -1);
  }

  public double getNotaMedia(int[] notas) {
    double total = 0;
    for (int t: notas) {
      if ( t > -1) {
        total += t;
      }else {
      return 0;
      }
    } 
    return total/5;
  }
  
  public String getNotaMediaString(double media) {
    return Double.toString(media);
  }


  @Override
  public int compareTo(Estudiantes arg0) {
    return this.nombre.compareTo(arg0.nombre);
  }

}
