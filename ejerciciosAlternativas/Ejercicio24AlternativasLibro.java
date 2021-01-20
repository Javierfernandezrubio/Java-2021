/**
 * 
 */
package ejerciciosAlternativas;

import java.util.Scanner;

/**
 * Ejercicio 24 
 * 
 * Escribe un programa que genere la nómina (bien desglosada) de un
 * empleado según las siguientes condiciones: 
 * 	
 *  • Se pregunta el cargo del empleado (1 - Prog. junior, 2 - Prog. senior, 3 - Jefe de proyecto), 
 *  los días que ha estado de viaje visitando clientes durante el mes y su estado civil (1- Soltero, 2 - Casado). 
 *  
 *  • El sueldo base según el cargo es de 950, 1200 y 1600 euros según si se trata de 
 *  un prog. junior, un prog. senior o un jefe de proyecto respectivamente. 
 *  
 *  • Por cada día de viaje visitando clientes se pagan 30 euros extra en concepto de dietas. 
 *  Al sueldo neto hay que restarle el IRPF, que será de un 25% en caso de estar soltero y 
 *  un 20% en caso de estar casado.
 * 
 * @author javier fernández rubio
 * @version 1.0
 * fecha 08/11/2020
 * 
 * Variables a usar:
 * cargo:
 * viaje:
 * estadoCivil: 
 * sueldoBase:
 * sueldoViaje:
 * sueldoFinal:
 * irpf:
 *
 */
public class Ejercicio24AlternativasLibro {

	public static void main(String[] args) {
		// Declaramos variables
		int cargo;
		int viaje;
		int estadoCivil;
		double sueldoBase;
		double sueldoViaje;
		double irpf;
		double sueldoFinal;
		Scanner s = new Scanner(System.in);
		
		// Iniciamos
		System.out.println("Hola, vamos a generar tu nomina.");
		
		System.out.println("Primero vamos a hacer unas serie de preguntas para conformar tu nómina:");
		
		// Pedimos los datos
		System.out.print("Puesto en la empresa(1 - Prog. junior | 2 - Prog. senior | 3 - Jefe de proyecto): ");
		cargo = s.nextInt();
		System.out.print("Cantidad de días de visita durante el mes: ");
		viaje = s.nextInt();
		System.out.print("Estado civil(1 - Soltero | 2 - Casado): ");
		estadoCivil = s.nextInt();
		
		// Comprobamos y ejecutamos
		if ( cargo == 1 ) {
			sueldoBase = 950;
			sueldoViaje = sueldoBase + 30*viaje;
			if ( estadoCivil == 1 ) {
				irpf = 0.25;
				sueldoFinal = sueldoViaje - (irpf * sueldoViaje);
			} else {
				irpf = 0.20;
				sueldoFinal = sueldoViaje - (irpf * sueldoViaje);
			}
		} else if ( cargo == 2 ) {
			sueldoBase = 1200;
			sueldoViaje = sueldoBase + 30*viaje;
			if ( estadoCivil == 1 ) {
				irpf = 0.25;
				sueldoFinal = sueldoViaje - (irpf * sueldoViaje);
			} else {
				irpf = 0.20;
				sueldoFinal = sueldoViaje - (irpf * sueldoViaje);
			}
		} else {
			sueldoBase = 1600;
			sueldoViaje = sueldoBase + 30*viaje;
			if ( estadoCivil == 1 ) {
				irpf = 0.25;
				sueldoFinal = sueldoViaje - (irpf * sueldoViaje);
			} else {
				irpf = 0.20;
				sueldoFinal = sueldoViaje - (irpf * sueldoViaje);
			}
		}
		
		// Mostrando la nómina
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
    System.out.printf("┃ Sueldo base            %7.2f ┃\n", sueldoBase);
    System.out.printf("┃ Dietas (%2d viajes)     %7.2f ┃\n", viaje, 30.0*viaje);
    System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
    System.out.printf("┃ Sueldo bruto           %7.2f ┃\n", sueldoViaje);
    System.out.printf("┃ Retención IRPF (%.0f%%)   %7.2f ┃\n", irpf*100, irpf * sueldoViaje);
    System.out.println("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
    System.out.printf("┃ Sueldo Final           %7.2f ┃\n", sueldoFinal);
    System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

    s.close();
	}

}
