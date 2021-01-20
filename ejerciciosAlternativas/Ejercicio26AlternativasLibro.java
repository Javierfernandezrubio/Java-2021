/**
 * 
 */
package ejerciciosAlternativas;

import java.util.Scanner;

/**
 * 
 * Ejercicio 26 
 * 
 * Realiza un programa que calcule el precio de unas entradas de
 * cine en función del número de personas y del día de la semana. El precio base
 * de una entrada son 8 euros. El miércoles (día del espectador), el precio base
 * es de 5 euros. Los jueves son el día de la pareja, por lo que la entrada para
 * dos cuesta 11 euros. Con la tarjeta CineCampa se obtiene un 10% de descuento.
 * Si un jueves, un grupo de 6 personas compran entradas, el precio total sería
 * de 33 euros ya que son 3 parejas; pero si es un grupo de 7, pagarán 3
 * entradas de pareja más 1 individual que son 41 euros (33 + 8).
 * 
 * @author javier fernández rubio
 * @version 1.0
 * fecha 11/11/2020
 *
 * Variables:
 * 
 */
public class Ejercicio26AlternativasLibro {

	public static void main(String[] args) {
		// Declaración de variables
		int dayOfWeek;
		String nameDay = "";
		int people = 0;
		int person = 0;
		int couple = 0;
		double ticketBase = 8;
		final double DESCUENTO = 0.10;
		double price = 0;
		double priceFinal = 0;
		String cardCine = "";
		Scanner s = new Scanner(System.in);
		
		System.out.println("Bienvenido/os al cine CineCampa!!!!");
		System.out.println("-------------------------------------");
		
		// Pedimos datos
		System.out.print("¿Para qué día de la semana quiere sus entradas?(1-7): ");
		dayOfWeek = s.nextInt();
		System.out.print("¿Cuántas personas son?: ");
		people = s.nextInt();
		System.out.print("¿Tiene tarjeta de CineCampa?(Si/No): ");
		cardCine = s.next();
		cardCine = cardCine.toUpperCase();
		
		// 
		switch (dayOfWeek) {
			case 1:
				nameDay = "Lunes";
				break;
			case 2:
				nameDay = "Martes";
				break;
			case 3:
				nameDay = "Miércoles";
				break;
			case 4:
				nameDay = "Jueves";
				break;
			case 5:
				nameDay = "Viernes";
				break;
			case 6:
				nameDay = "Sábado";
				break;
			case 7:
				nameDay = "Domingo";
				break;
		}
		
		// Calculos
		if ( dayOfWeek == 3 ) {
			ticketBase = 5;
			if ( cardCine == "SI" || cardCine == "SI") {
				price = ticketBase * (double)people;
				priceFinal = price - (price * DESCUENTO);
			}
			if ( cardCine == "NO" ) {
				price = ticketBase * people;
				priceFinal = price;
			}
		}
		if ( dayOfWeek == 4 ) {
			ticketBase = 8;
			couple = people / 2;
			person = people % 2;
			if ( couple >= 1 ) {
				if ( cardCine == "SI" || cardCine == "SI") {
					price = (11 * (double)couple) + ((double)person * ticketBase);
					priceFinal = price - (price * DESCUENTO);
				}
				if ( cardCine == "NO" ) {
					price = (11 * (double)couple) + ((double)person * ticketBase);
					priceFinal = price;
				}
			}
			if ( couple == 0 ) {
				if ( cardCine == "SI" || cardCine == "SI") {
					price = person * (double)ticketBase;
					priceFinal = (person * (double)ticketBase) - (price * DESCUENTO);
				} 
				if ( cardCine == "NO" ) {
					price = (double)person * ticketBase;
					priceFinal = price;
				}
			}
		} 
		if ( dayOfWeek != 3 || dayOfWeek != 4 ){
			ticketBase = 8;
			if ( cardCine == "SI" || cardCine == "SI") {
				price = ticketBase * (double)people;
				priceFinal = price - (price * DESCUENTO);
			}
			if ( cardCine == "NO" ) {
				price = ticketBase * (double)people;
				priceFinal = price;
			}
		}
		
		double priceFinal2 = priceFinal;
		
		
		
		// Mostramos la factura
		System.out.println("-----------------------------------------");
    System.out.printf("Día de la semana     %s \n", nameDay);
    System.out.printf("¿Tiene tarjeta CineCampa? (SI/NO): %s\n", cardCine); 
    System.out.println("Aquí tiene sus entradas. Gracias por su compra.");
    System.out.printf("Entradas           %d\n", people);
    System.out.printf("Entradas por parejas   %d\n", couple);
    if (cardCine == "SI" || cardCine == "SI") {
    	System.out.printf("Descuento                   %s\n", "10%");
    } else if ( cardCine == "NO" ) {
    	System.out.printf("Descuento                   %s\n", "0%");
    }
    System.out.printf("Precio a pagar           %f", priceFinal2);
		
		
		
	}

}
