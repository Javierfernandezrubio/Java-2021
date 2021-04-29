import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CribaEratostenes implements Iterable<Integer>{

  private int maximo;
  private List<Integer> numerosPrimos = new ArrayList<>();


  public CribaEratostenes(int maximo) {
    if (maximo < 2) {
      throw new IllegalArgumentException("Cantidad de numeros primos inferior a 2.");
    }
    this.maximo = maximo;
    this.numerosPrimos = generarLista(); 
  }

  @Override
  public Iterator<Integer> iterator() {
    return numerosPrimos.iterator();
  }

  public List<Integer> generarLista() {
    List<Integer> lista = new ArrayList<>();
    
    
    rellenarLista(lista);
    cribaEratostenes(lista);
    
    return lista;
  }

  private void rellenarLista(List<Integer> lista) {
    for (int i = 2; i <= maximo; i++) {
      lista.add(i);
    }
  }

  private void cribaEratostenes(List<Integer> lista) {
    int index = 0;
    while (Math.pow(lista.get(index),2) <= maximo) {
      int numPrimo = lista.get(index);
      lista.subList(index+1, lista.size()).removeIf(numero -> (numero % numPrimo) == 0);
      index++;
    }
  }

}
