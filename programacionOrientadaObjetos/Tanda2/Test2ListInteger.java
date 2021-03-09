package programacionOrientadaObjetos.Tanda2;

public class Test2ListInteger {

  public static void main(String[] args) {

    IntegerList lista = new IntegerList(1,2,3,4,5,6,7,8,9,10,11);
    IntegerList lista1 = new IntegerList();
    IntegerList lista2 = new IntegerList(1,2,3,4,5,5,7,8,9);
    IntegerList lista3 = new IntegerList(1,2,3,4,5,6,7,8,9);

    System.out.println("Test clase ListInteger");

    System.out.println("Objetos:");
    System.out.println(lista);
    System.out.println(lista1);
    System.out.println(lista2);
    System.out.println(lista3);

    System.out.println();

    System.out.println("Uso del metodos insert:");
    System.out.println(lista.insert(25));
    System.out.println(lista1.insert(25));
    System.out.println(lista2.insert(25, 11));
    System.out.println(lista3.insert(25, 5));
    System.out.println(lista);
    System.out.println(lista1);
    System.out.println(lista2);
    System.out.println(lista3);

    System.out.println();

    System.out.println("Uso de clear, isFull y isEmpty con lista:");
    lista.clear();
    System.out.println(lista);
    System.out.println(lista.isFull());
    System.out.println(lista.isEmpty());

    System.out.println();
    /*
    System.out.println("Uso de remove con lista2:");
    System.out.println(lista2.remove(5));
    System.out.println(lista2);

    System.out.println("\nUso de pop():");
    System.out.println(lista3);
    System.out.println(lista3.pop());
    System.out.println(lista3);

    System.out.println("\nUso de clone():");
    System.out.println(lista3);
    IntegerList lista4 = lista3.clone();
    System.out.println("Lista3: " + lista3);
    System.out.println("Lista4: " + lista4);*/


    System.out.println("\nUso de remove():");
    System.out.println("Lista2: " + lista2);
    System.out.println("Remuevo el primer elemento 20: " + lista2.remove(20));
    System.out.println("Remuevo el primer elemento 5: " + lista2.remove(5));
    System.out.println("Lista2 sin el 5: " + lista2);

    System.out.println("\nUso de resize:");
    System.out.println("Lista2: " + lista2);
    System.out.println("Resize a 20: " + lista2.resize(20));
    System.out.println("Resize a 7: " + lista2.resize(7));
    System.out.println("Resize a 9: " + lista2.resize(9));
    System.out.println("Lista2 nueva con 9: " + lista2);

    /*
    System.out.println("\nUso de resize2:");
    System.out.println("Lista2: " + lista2);
    lista2 = lista2.resize2(20);
    System.out.println("Lista2 nueva: " + lista2);
     */

  }

}
