/**
 * 
 */
package examenSegundoTrimestre;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import examenSegundoTrimestreRafa.CSVEstudiantesException;

/**
 * Clase Calificaciones que extiende de arrayList y contiene objetos Estudiantes
 * 
 * 
 * @author javier fernandez rubio
 *
 */
public class Calificaciones extends ArrayList<Estudiantes>{

  private static final long serialVersionUID = 1L;
  public static final int NUM_ESTUDIANTES = 6;
  public static final int NUM_NOTAS = 5;
  private static final String CABECERA_CSV = "Nombre,Nota1,Nota2,Nota3,Nota4,Nota5";





  static public Calificaciones importarCSV(String fichero) throws Exception {
    Calificaciones nuevaClase = new Calificaciones();
    var archivo = Files.newBufferedReader(Paths.get(fichero));
    validarCabeceraCSV(archivo);

    String linea;
    while ((linea = archivo.readLine()) != null) {
      Estudiantes estudiante = cargarEstudianteCSV(linea);
      nuevaClase.add(estudiante);
    }
    archivo.close();

    return nuevaClase;
  }

  private static void validarCabeceraCSV(BufferedReader archivo) throws Exception {
    String head = archivo.readLine().trim();
    if (! head.equalsIgnoreCase("Nombre,Nota1,Nota2,Nota3,Nota4,Nota5")) {
      throw new Exception("Cabecera errónea en el CSV.");
    }
  }

  private static Estudiantes cargarEstudianteCSV(String linea) throws Exception {
    validarEstudianteCSV(linea);
    
    // Extraemos los campos del articulo quitando las comillas de inicio y fin
    String nombre = getNombreEstudiante(linea);
    int[] notasTotal = getNotasEstudiante(linea);

    Estudiantes nuevoEstudiante;
    try {
      nuevoEstudiante = new Estudiantes(nombre, notasTotal);
    } catch (Exception e) {
      throw new Exception();
    }

    return nuevoEstudiante;
  }

  private static int[] getNotasEstudiante(String linea) {
    String[] camposEstudiante = linea.split(",");
    int primerIndiceNotas = camposEstudiante.length - NUM_NOTAS;
    int[] notas = new int[NUM_NOTAS];
    for (int i = primerIndiceNotas; i < camposEstudiante.length; i++) {
      notas[i - primerIndiceNotas] = Integer.valueOf(camposEstudiante[i]);
    }
    return notas;
  }

  private static String getNombreEstudiante(String linea) {
    return linea.substring(1, linea.indexOf("\","));
  }

  private static void validarEstudianteCSV(String linea) throws Exception {
 // ¿El nombre del estudiante está encerrado entre comillas?
    if (! linea.startsWith("\"")) {
      throw new CSVEstudiantesException("Nombre del estudiante no empieza con \": " + linea);
    }

    int posFinNombre = linea.indexOf("\",", 1);
    if (posFinNombre == -1) {
      throw new CSVEstudiantesException("Nombre del estudiante no termina con \": " + linea);
    }

    // ¿Resto de campos (notas) son la cantidad correcta y numéricos?
    String notas = linea.substring(posFinNombre + 2);
    validaNotas(notas);
  }

  private static void validaNotas(String notas) throws CSVEstudiantesException {
    String[] campos = notas.split(","); 
    int numCamposEsperado = CABECERA_CSV.split(",").length - 1;
    if (campos.length != numCamposEsperado) {
      throw new CSVEstudiantesException("Número de campos del CSV incorrecto en línea con: " + notas);
    }
    // ¿Son los campos numéricos?
    for (String num: campos) {
      if (! esEntero(num)) {
        throw new CSVEstudiantesException(num + " no es numérico.");
      }
    }
  }

  private static boolean esEntero(String cadena) {
    try {
      Integer.parseInt(cadena);
      return true;
    } catch (NumberFormatException e){
      return false;
    }
  }

  public int estudiantesEjercicioHechos(int ejercicioEscogido) {
    int alumnos = NUM_ESTUDIANTES;
    for (int i = 0; i < this.size(); ++i) {
      if (this.get(i).getNotaEjercicio(ejercicioEscogido) == -1) {
        --alumnos;
      }
    }

    return alumnos;
  }


  public double notaMediaPresentados(int ejercicioEscogido) {
    double mediaTotal = 0;
    int alumnos = estudiantesEjercicioHechos(ejercicioEscogido);

    for (int i = 0; i < NUM_ESTUDIANTES; i++) {
      if (this.get(i).getNotaEjercicio(ejercicioEscogido) != -1) {
        mediaTotal = mediaTotal + this.get(i).getNotaEjercicio(ejercicioEscogido);
      }
    }

    return mediaTotal / alumnos;
  }

  public Estudiantes alumnoNotaMaximaEjercicio(int ejercicioEscogido) {
    int notaMaxima = Integer.MIN_VALUE;
    Estudiantes alumnoNotaMaxima = null;

    for (int i = 0; i < NUM_ESTUDIANTES; i++) {
      if (this.get(i).getNotaEjercicio(ejercicioEscogido) > notaMaxima) {
        notaMaxima = this.get(i).getNotaEjercicio(ejercicioEscogido);
        alumnoNotaMaxima = this.get(i);
      }
    }

    return alumnoNotaMaxima;
  }
  
  public int notaMaximaEjercicio(int ejercicioEscogido) {
    int notaMaxima = Integer.MIN_VALUE;

    for (int i = 0; i < NUM_ESTUDIANTES; i++) {
      if (this.get(i).getNotaEjercicio(ejercicioEscogido) > notaMaxima) {
        notaMaxima = this.get(i).getNotaEjercicio(ejercicioEscogido);
      }
    }

    return notaMaxima;
  }
  
  @Override
  public String toString() {
    Calificaciones notas = (Calificaciones) this.clone();
    String toString = "ALUMNOS:" + " [\n";
    Collections.sort(notas);
    for (Estudiantes e: notas) {
      toString += e + "\n";    
    }
    toString += "]";
    return toString;
  }

  public double notaMediaAlta() {
    double notaMedia = 0;
    double[] notaAlta = new double[this.size()];
    
    for (Estudiantes alumno : this) {
      if (comprobarAlumno(alumno)) {
        notaMedia = alumno.getNotaMedia(alumno.getNotas());
        notaAlta[this.indexOf(alumno)] = notaMedia;
      }
    }
    
    Arrays.sort(notaAlta);
    
    return notaAlta[0];
  }

  private boolean comprobarAlumno(Estudiantes alumno) {
    int notas[] = alumno.getNotas();
    int ejercicioNoHecho = 0;
    boolean noNotaMedia = false;
    
    for (int i : notas) {
      if (i == -1) {
        ejercicioNoHecho++;
      } 
    }
    
    if (ejercicioNoHecho > 0) {
      noNotaMedia = false;
    } else {
      noNotaMedia = true;
    }
    
    return noNotaMedia;
  }

  public String[] estudiantesMediaAlta() {
    String[] alumnos = new String[this.size()];
    
    for (Estudiantes alumno : this) {
      if (comprobarAlumno(alumno)) {
        alumnos[this.indexOf(alumno)] = alumno.getNombre();
      }
    }
    
    Arrays.sort(alumnos);
    
    return alumnos;
  }

  /**
   * Metodo para exportar a un fichero xml los datos
   * 
   * 
   * @param fichero
   * @throws Exception 
   */
  public void saveXML(String fichero) throws Exception{
    try {   
      Document xml = createDocumentXML();
      saveRootXML(xml);
      for (Estudiantes alumno : this) {
        saveEstudianteXML(alumno, xml);
      }
      saveFileXML(xml, fichero);
      
    } catch (ParserConfigurationException | TransformerException e) {
      throw new Exception("Error al generar XML: " + e.getMessage());
    }
  }

  private void saveFileXML(Document xml, String fichero) throws TransformerFactoryConfigurationError, IOException, TransformerException {
    Transformer transformer = TransformerFactory.newInstance().newTransformer();
    DOMSource xmlSource = new DOMSource(xml);
    StreamResult output = new StreamResult(new FileWriter(fichero));
    transformer.transform(xmlSource, output);
  }

  private void saveEstudianteXML(Estudiantes alumno, Document xml) {
    Element root = xml.getDocumentElement();

    Element estudianteElement = xml.createElement("Alumno");
    root.appendChild(estudianteElement);

    saveCampoEstudianteXML("Nombre", alumno.getNombre(), estudianteElement);
    saveCampoEstudianteXML("Media", alumno.getNotaMediaString(alumno.getNotaMedia(alumno.getNotas())), estudianteElement);
    for (int i = 1; i <= 5; i++) {
      saveCampoEstudianteXML("Nota" + i , String.valueOf(alumno.getNotaEjercicio(i)), estudianteElement);
    }
    
  }

  private void saveCampoEstudianteXML(String atributo, String valor, Element estudianteElement) {
    Document xml = estudianteElement.getOwnerDocument();
    Element attrElement = xml.createElement(atributo);
    attrElement.appendChild(xml.createTextNode(valor));
    estudianteElement.appendChild(attrElement);
  }

  private void saveRootXML(Document xml) {
    Element root = xml.createElement("Calificaciones");
    xml.appendChild(root);
  }

  private Document createDocumentXML() throws ParserConfigurationException{
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.newDocument();
    return document;
  }



}
