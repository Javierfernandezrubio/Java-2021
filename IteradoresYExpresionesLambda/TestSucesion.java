import java.util.function.Function;

/**
 * Crea la clase iterable Sucesion que permita iterar sobre los N primeros números de una sucesión
 * de números enteros (long) representada por una expresión lambda que devuelve el término iésimo de
 * la sucesión.
 * 
 * @author javier
 *
 */
public class TestSucesion {
  private static int SIZE = 10;

  public static void main(String[] args) {
    
    muestraSucesion("pares", n -> n*2L);
    muestraSucesion("impares", n -> (n-1)*2L + 1);
    muestraSucesion("múltiplos de 5", n -> n*5L);
    muestraSucesion("potencias de 2", n -> (long) Math.pow(2, n));
    //muestraSucesion("Fibonnacci", n -> Matematicas.Fibonacci(n));
    muestraSucesion("aleatorios entre 1 y 100", n -> (long) (100 * Math.random()) + 1); // no uso n
  }
  
  static void muestraSucesion(String nombre, Function<Integer,Long> lambda) {
    var sucesion = new Sucesion(SIZE, lambda);
    System.out.print("Sucesión de " + nombre + ": ");
    sucesion.forEach(elemento -> System.out.print(elemento + " "));
    System.out.println("\n");
  }
}
