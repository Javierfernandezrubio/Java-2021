import java.util.Scanner;

public class TestListaPrimos {

  public TestListaPrimos() {
    // TODO Auto-generated constructor stub
  }

  public static void main(String[] args) {
    var s = new Scanner(System.in);

    System.out.print("Este programa genera una cantidad de numeros primos, ¿cuántos generamos? ");
    int cantidadAGenerar = s.nextInt();

    var listaPrimos = new ListaPrimos(cantidadAGenerar);

    int index = 1;
    for (int n: listaPrimos) {
      System.out.println(index++ + "º primo:\t" + n);
    }
  }

}
