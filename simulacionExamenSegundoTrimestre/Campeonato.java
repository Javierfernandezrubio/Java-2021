/**
 * 
 */
package simulacionExamenSegundoTrimestre;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import negocio.AlmacenCSVException;
import negocio.PreciosArticuloException;
import negocio.StockMaximoException;
import negocio.StockSeguridadException;
import negocio.UnidadesNegativasArticuloException;

/**
 * @author javier
 *
 */
public class Campeonato extends ArrayList<Ciclista>{

  private static final long serialVersionUID = 1L;
  
  private static final String CSV_CABECERA = "Nombre,Dorsal,Etapa1,Etapa2,Etapa3,Etapa4,Etapa5";

  //private ArrayList<Ciclista> campeonato;

  //Campeonato() {
    //this.campeonato = new ArrayList<Ciclista>();
  //}
  /*
  public ganadorCadaEtapa(){
    
  }*/
  
  
  
  // Metodos para cargar CSV
  
  /**
   * 
   * @param fichero
   * @return
   * @throws Exception 
   * @throws AlmacenCSVException
   * @throws UnidadesNegativasArticuloException
   * @throws StockSeguridadException
   * @throws StockMaximoException
   * @throws PreciosArticuloException
   */
  static public Campeonato importarCSV(String fichero) throws Exception {
    Campeonato nuevoCampeonato = new Campeonato();
    var archivo = Files.newBufferedReader(Paths.get(fichero));
    validarCabeceraCSV(archivo);

    String linea;
    while ((linea = archivo.readLine()) != null) {
      Ciclista ciclista = cargarCiclistaCSV(linea);
      nuevoCampeonato.add(ciclista);
    }
    archivo.close();

    return nuevoCampeonato;
  }

  
  private static void validarCabeceraCSV(BufferedReader archivo) throws Exception {
    String head = archivo.readLine().trim();
    if (! head.equalsIgnoreCase("Nombre,Dorsal,Etapa1,Etapa2,Etapa3,Etapa4,Etapa5")) {
      throw new Exception("Cabecera errónea en el CSV.");
    }
  }


  private static Ciclista cargarCiclistaCSV(String linea) throws Exception {
    //validarArticuloCSV(linea);
    String[] camposCiclistas = linea.split("\","); // solo las comas de separación de campos

    // Extraemos los campos del articulo quitando las comillas de inicio y fin
    String nombre = camposCiclistas[0].replace("\"", "");
    int dorsal = Integer.parseInt(camposCiclistas[1].replace("\"", ""));
    int etapa1 = Integer.parseInt(camposCiclistas[2].replace("\"", ""));
    int etapa2 = Integer.parseInt(camposCiclistas[3].replace("\"", ""));
    int etapa3 = Integer.parseInt(camposCiclistas[4].replace("\"", ""));
    int etapa4 = Integer.parseInt(camposCiclistas[5].replace("\"", ""));
    int etapa5 = Integer.parseInt(camposCiclistas[6].replace("\"", ""));
    int[] tiempos = new int[5];
    tiempos[0] = etapa1;
    tiempos[1] = etapa2;
    tiempos[2] = etapa3;
    tiempos[3] = etapa4;
    tiempos[4] = etapa5;

    Ciclista nuevoCiclista;
    try {
    nuevoCiclista = new Ciclista(nombre, dorsal, tiempos);
    } catch (Exception e) {
      throw new Exception();
    }

    return nuevoCiclista;
  }
  /*
  public void exportarCSV(String fichero) throws IOException {
    var archivo = Files.newBufferedWriter(Paths.get(fichero), StandardOpenOption.CREATE);
    guardarCabeceraCSV(archivo);
    for (Ciclista ciclista: this) {
      guardarCiclistasCSV(ciclista, archivo);
    }
    archivo.close();
  }
  private void guardarCabeceraCSV(BufferedWriter archivo) throws IOException {
    archivo.write("Etapa,Dorsal,Nombre,Tiempo");
    archivo.newLine();
  }
  /*
  private void guardarCiclistasCSV(Ciclista ciclista, BufferedWriter archivo) {
    archivo.write("\"" + ciclista.getNombre()() + "\",");
    //fichero.write("\"" + articulo.getCodigo() + "\",");
    archivo.write("\"" + ciclista.getDescripcion() + "\",");
    archivo.write("\"" + ciclista.getPrecioCompra() + "\",");
    archivo.write("\"" + ciclista.getPrecioVenta() + "\",");
    archivo.write("\"" + ciclista.getNumUnidades() + "\",");
    archivo.write("\"" + ciclista.getStockSegu() + "\",");
    archivo.write("\"" + ciclista.getStockMax() + "\"");
    archivo.newLine();
  }*/


  public Ciclista ganadorEtapa(int etapa) {
    int[] tiempos = new int[6];

    for (int i = 0; i < tiempos.length; ++i) {
      tiempos[i] = this.get(i).getTiempoEtapa(etapa);
    }
    Arrays.sort(tiempos);
    
    Ciclista ciclistaGanador = null;
    
    for (int i = 0; i < this.size(); ++i) {
      if (this.get(i).getTiempoEtapa(etapa) == tiempos[0]) {
        ciclistaGanador = this.get(i);
      }
    }
    
    return ciclistaGanador;
  }
  


  @Override
  public String toString() {
    Campeonato campeonato = (Campeonato) this.clone();
    String toString = "CICLISTAS:" + " [\n";
    Collections.sort(campeonato);
    for (Ciclista c: campeonato) {
      toString += c + "\n";    
    }
    toString += "]";
    return toString;
  }
  
 
}
