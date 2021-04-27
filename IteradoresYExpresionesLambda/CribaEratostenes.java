import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CribaEratostenes implements Iterable<Integer>{

  private List<Integer> numerosPrimos = new ArrayList<>();


  public CribaEratostenes(int size) {
    if (size < 2) {
      throw new IllegalArgumentException("Cantidad de numeros primos inferior a 2.");
    }
    this.numerosPrimos = CribaEratostenes.generarLista(size); 
  }

  @Override
  public Iterator<Integer> iterator() {
    return numerosPrimos.iterator();
  }

  public static List<Integer> generarLista(int size) {
    List<Integer> lista = new ArrayList<>();
    int index = 0;
    
    for (int i = 2; i <= size; i++) {
      lista.add(i);
    }
    
    while (Math.pow(lista.get(index),2) <= size) {
      long primo = lista.get(index);
      lista.subList(index+1, lista.size()).removeIf(n -> (n % primo) == 0);
      index++;
    }
    
    return lista;
    
  }

}
