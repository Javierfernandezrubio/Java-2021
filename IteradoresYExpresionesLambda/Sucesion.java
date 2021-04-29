import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/**
 * 
 * Crea la clase iterable Sucesion que permita iterar sobre los N primeros 
 * números de una sucesión de números enteros (long) representada por una 
 * expresión lambda que devuelve el término iésimo de la sucesión.
 * 
 * @author javier
 *
 */
public class Sucesion implements Iterable<Long>{

  private long maximo;
  private List<Long> sucesion = new ArrayList<Long>();
  Function<Integer, Long> lamdba;

  public Sucesion(int maximo, Function<Integer, Long> lamdba) {
    if (maximo < 1) {
      throw new IllegalArgumentException("Así no se puede hacer una sucesión!");
    }

    this.maximo = maximo;
    this.lamdba = lamdba;
    this.sucesion = generarLista(lamdba);
  }

  @Override
  public Iterator<Long> iterator() {
    return sucesion.iterator();
  }

  private List<Long> generarLista(Function<Integer, Long> lamdba2) {
    List<Long> lista = new ArrayList<>();

    rellenarLista(lista, lamdba2);

    return lista;
  }

  private void rellenarLista(List<Long> lista, Function<Integer, Long> lamdba2) {
    for (int i = 1; i < this.maximo; i++ ) {
      lista.add(lamdba.apply(i));
    }
    
  }
}
