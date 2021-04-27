import java.util.Iterator;

/**
 * @author javier
 *
 */
public class ListaPrimos implements Iterable<Integer>{

  private int size;
  
  public ListaPrimos(int size) {
    if (size < 2) {
      throw new IllegalArgumentException("Cantidad de numeros primos inferior a 2.");
    }
    
   this.size = size;
  }

  @Override
  public Iterator<Integer> iterator() {
    Iterator<Integer> iterator = new Iterator<Integer>() {

      int index = 2;
      int numeroPrimo = 0;
      
      @Override
      public boolean hasNext() {
        return index <= size;
      }
      

      @Override
      public Integer next() {
        numeroPrimo = index;
        index++;
        while (!isPrime(index)) {
          index++;
        }        
        return numeroPrimo;
      }
    };

    return iterator;
  }

  protected boolean isPrime(int n) {
      if (n%2==0) return false;
      for(int i=3;i*i<=n;i+=2) {
          if(n%i==0)
              return false;
      }
      return true;
  }

}
