/**
 * 
 */
package examenPrimerTrimestre;

import java.util.Scanner;

/**
 * Examen 1º trimestre:
 * 
 * Haz un programa en Java que muestre y ejecute el siguiente menú:
 * 
 * 1.Generar aleatoriamente las calificaciones (enteros entre -1 y 10).
 * 
 * 2.Mostrar el número de ejercicios entregados por un estudiante.
 * 
 * 3.Mostrar la media de los ejercicios entregados por un estudiante (si los
 * entregó todos; en caso contrario, la media es 0).
 * 
 * 4.Mostrar la cantidad de estudiantes que han entregado todos los ejercicios y
 * tienen una media superior o igual a un 5.
 * 
 * 5.Mostrar el número de estudiantes que han presentado un ejercicio dado.
 * 
 * 6.Dado el número de un ejercicio, mostrar la nota media obtenida por los
 * estudiantes que lo presentaron.
 * 
 * 7.Dado el número de un ejercicio, mostrar la nota más alta obtenida.
 * 
 * 8.Dado el número de un ejercicio, mostrar la nota más baja obtenida.
 * 
 * 9.Mostrar la relación de estudiantes y sus notas.
 * 
 * 10.Finalizar.
 * 
 * 
 * 
 * 
 * @author Javier Fernández Rubio
 * @version 1.1 Fecha: 14/12/2020
 *
 */
public class EjercicioNotas {
	
	final static public int NUM_NOTAS = 5;
	final static public int NUM_ESTUDIANTES = 20;

	/**
	 * Main principal del programa, con el menú con las 10 opciones y las llamadas a
	 * las funciones.
	 * 
	 * 
	 * @param opcion opcion entre 1 y 10 para el menu del programa
	 * @param numeroEstudiante  estudiante seleccionado a ver sus notas o lo que se pida
	 * @param opcionEscogida opcion escogida entre las 10 posibles
	 * @param ejercicioEscogido ejercicio elegido
	 * @param notasGeneradas sirve para ver si las notas han sido generadas
	 */
	public static void main(String[] args) {
		// Variables del menú
		Scanner s = new Scanner(System.in);
		int[][] alumnosNotas = new int[NUM_ESTUDIANTES][NUM_NOTAS];
		String[] nombreAlumnos = new String[NUM_ESTUDIANTES];
		int opcion = 0;
		int numeroEstudiante;
		int opcionEscogida = 0;
		int ejercicioEscogido;
		boolean notasGeneradas = false;

		// Inicializacion del array de nombresAlumnos
		for (int i = 0; i < NUM_ESTUDIANTES; ++i) {
			nombreAlumnos[i] = "Estudiante " + (i + 1);
		}
		
		
		do {
			opcion = menu(opcionEscogida, notasGeneradas);
			switch (opcion) {
			case 1:
				generarNotas(alumnosNotas);
				notasGeneradas = true;
				break;
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:

				if (notasGeneradas) {

					switch (opcion) {

					case 2:
						do {
							System.out.print("Dame el numero del estudiante(1-" + NUM_ESTUDIANTES + "): ");
							numeroEstudiante = s.nextInt();
						} while (numeroEstudiante < 1 || numeroEstudiante > NUM_ESTUDIANTES);
						ejerciciosEntregados(numeroEstudiante, alumnosNotas);
						break;
					case 3:
						do {
							System.out.print("Dame el numero del estudiante(1-" + NUM_ESTUDIANTES + "): ");
							numeroEstudiante = s.nextInt();
						} while (numeroEstudiante < 1 || numeroEstudiante > NUM_ESTUDIANTES);
						mediaEjerciciosEntregados(numeroEstudiante, alumnosNotas);
						break;
					case 4:
						// cantidadEstudiantesSuperior5(alumnosNotas);
						break;
					case 5:
						do {
							System.out.print("Dame el numero del ejercicio(1-" + NUM_NOTAS + "): ");
							ejercicioEscogido = s.nextInt();
						} while (ejercicioEscogido < 1 || ejercicioEscogido > NUM_NOTAS);
						int alumnos = alumnosEjercicioHechos(ejercicioEscogido, alumnosNotas);
						System.out.println("\nAlumnos que han hecho el ejercicio " + ejercicioEscogido + " son " + alumnos);
						break;
					case 6:
						do {
							System.out.print("Dame el numero del ejercicio(1-" + NUM_NOTAS + "): ");
							ejercicioEscogido = s.nextInt();
						} while (ejercicioEscogido < 1 || ejercicioEscogido > NUM_NOTAS);
						double media = notaMediaPresentados(ejercicioEscogido, alumnosNotas);
						System.out.println("\nLa nota media es de " + media);
						break;
					case 7:
						do {
							System.out.print("Dame el numero del ejercicio(1-" + NUM_NOTAS + "): ");
							ejercicioEscogido = s.nextInt();
						} while (ejercicioEscogido < 1 || ejercicioEscogido > NUM_NOTAS);
						int notaMaxima = calcularNotaMaxima(ejercicioEscogido, alumnosNotas);
						System.out.println("\nLa nota maxima del ejercicio " + ejercicioEscogido + " es de " + notaMaxima);
						break;
					case 8:
						do {
							System.out.print("Dame el numero del ejercicio(1-" + NUM_NOTAS + "): ");
							ejercicioEscogido = s.nextInt();
						} while (ejercicioEscogido < 1 || ejercicioEscogido > NUM_NOTAS);
						int notaMinima = calcularNotaMinima(ejercicioEscogido, alumnosNotas);
						System.out.println("\nLa nota minima del ejercicio " + ejercicioEscogido + " es de " + notaMinima);
						break;
					case 9:
						mostrarTodasNotas(alumnosNotas, nombreAlumnos);
						break;
					}
					pausa();
				} else {
					System.out.println("Genera primero las notas, dale a la opción 1 antes de continuar.");
				}
				break;

			}

		} while (opcion != 10);
		System.out.println("\nFin del programa!!!");

	}

	
	/**
	 * Funcion para poner una pausa entre opcion y opcion
	 */
	public static void pausa() {
		Scanner s = new Scanner(System.in);
		System.out.print("\n\nPulse INTRO para continuar....");
		s.nextLine();
		System.out.println();
		
	}

	/**
	 * Funcion menu que sirve para mostrar el menu por pantalla, todas sus opciones
	 * y donde hay que tener en cuenta lo siguiente:
	 * 
	 * •Cuando una opción necesite saber a qué estudiante nos referimos damos su
	 * número (empezamos en 1) y al mostrar el resultado tiene que salir este número
	 * y su nombre.
	 * 
	 * •Cuando una opción necesite saber a qué ejercicio nos referimos damos su
	 * número (empezamos en 1).
	 * 
	 * •Si el array de calificaciones no se ha generado no funcionan las demás
	 * opciones.
	 * 
	 * •Si se da una opción equivocada en el menú se muestra un error
	 * 
	 * @param opcionEscogida
	 * @param notasGeneradas
	 * @return opcionSeleccionada
	 */
	public static int menu(int opcionEscogida, boolean notasGeneradas) {
		int opcionSeleccionada = 0;

		// Mostramos menu
		System.out.println("\nPrograma para mostrar notas de los diferentes alumnos:");
		System.out.println("Opciones:");
		System.out.println("1.Generar aleatoriamente las calificaciones (enteros entre -1 y 10).");
		System.out.println("2.Mostrar el número de ejercicios entregados por un estudiante.");
		System.out.println("3.Mostrar la media de los ejercicios entregados por un estudiante");
		System.out.println("4.Mostrar la cantidad de estudiantes que han entregado todos los ejercicios y "
				+ "tienen una mediasuperior o igual a un 5.");
		System.out.println("5.Mostrar el número de estudiantes que han presentado un ejercicio dado.");
		System.out.println("6.Dado el número de un ejercicio, mostrar la nota media obtenida por los "
				+ "estudiantes que lo presentaron.");
		System.out.println("7.Dado el número de un ejercicio, mostrar la nota más alta obtenida.");
		System.out.println("8.Dado el número de un ejercicio, mostrar la nota más baja obtenida.");
		System.out.println("9.Mostrar la relación de estudiantes y sus notas.");
		System.out.println("10.Finalizar.\n");

		// Pedimos la opcion
		System.out.print("Dime la opción: ");
		Scanner s = new Scanner(System.in);
		opcionSeleccionada = s.nextInt();
		System.out.println();

		// Comprueba que la opcion está entre 1 y 10
		while (opcionSeleccionada < 1 || opcionSeleccionada > 10) {
			System.out.println("ERROR, la opcion escogida no existe");
			System.out.print("Dame una opción correcta: ");
			opcionSeleccionada = s.nextInt();
		}

		return opcionSeleccionada;
	}

	/**
	 * Funcion que genera las notas de cada estudiante y ejercicio de manera
	 * aleatoria
	 * 
	 * @param alumnosNotas
	 * @return
	 */
	public static void generarNotas(int[][] alumnosNotas) {
		for (int i = 0; i < NUM_ESTUDIANTES; ++i) {
			for (int j = 0; j < NUM_NOTAS; ++j) {
				alumnosNotas[i][j] = (int) (Math.random() * 12) - 1;
			}
		}
	}

	/**
	 * Funcion que devuelve la cantidad de ejercicios hechos por un estudiante
	 * 
	 * @param ejerciciosHechos ejercicios hechos por el estudiante
	 * @param numeroEstudiante estudiante seleccionado
	 */
	public static void ejerciciosEntregados(int numeroEstudiante, int[][] alumnosNotas) {
		int ejerciciosHechos = 0;

		for (int j = 0; j < NUM_NOTAS; ++j) {
			if (alumnosNotas[numeroEstudiante - 1][j] != -1) {
				++ejerciciosHechos;
			}
		}
		System.out.println("El Estudiante " + numeroEstudiante + " ha hecho " + ejerciciosHechos + " ejercicios.");

	}

	/**
	 * Funcion que muestra la media de un estudiante si ha entregado todos los
	 * ejercicios
	 * 
	 * @param numeroEstudiante estudiante escogido
	 * @param alumnosNotas     array con las notas de los alumnos
	 */
	public static void mediaEjerciciosEntregados(int numeroEstudiante, int[][] alumnosNotas) {
		double mediaAlumno = 0;
		int notas = NUM_NOTAS;
		for (int j = 0; j < NUM_NOTAS; ++j) {
			if (alumnosNotas[numeroEstudiante - 1][j] == -1) {
				mediaAlumno = 0;
				notas--;
			} else {
				mediaAlumno = mediaAlumno + alumnosNotas[numeroEstudiante - 1][j];
			}
		}
		if (mediaAlumno == 0) {
			System.out.println("La media del Estudiante " + numeroEstudiante + " es 0 por no entregar todos los ejercicios");
		} else {
			System.out.println("La media es de " + mediaAlumno / notas);
		}

	}

	/**
	 * Funcion que muestra la cantidad de alumnos que han entregado todos los
	 * ejercicios y tienen media superior a 5
	 * 
	 * @param alumnosNotas
	 */
	// public static int cantidadEstudiantesSuperior5(int[][] alumnosNotas) {
	// for (int i = 0; i < 15; i++) {

	// }

	// return alumnos;

	// }

	/**
	 * Funcion que muestra la cantidad de alumnos que han hecho un ejercicio dado
	 * 
	 * @param alumnosNotas
	 * @return alumnos cantidad de alumnos
	 */
	public static int alumnosEjercicioHechos(int ejercicioEscogido, int[][] alumnosNotas) {
		int alumnos = NUM_ESTUDIANTES;

		for (int i = 0; i < NUM_ESTUDIANTES; i++) {
			if (alumnosNotas[i][ejercicioEscogido - 1] == -1) {
				--alumnos;
			}
		}

		return alumnos;
	}

	/**
	 * Funcion que muestra la nota media de los alumnos que presentaron un ejercicio
	 * seleccionado
	 * 
	 * @param ejercicioEscogido
	 * @param alumnosNotas
	 * @return media de todas las notas de los ejercicios presentados
	 */
	public static double notaMediaPresentados(int ejercicioEscogido, int[][] alumnosNotas) {
		double mediaTotal = 0;
		int alumnos = alumnosEjercicioHechos(ejercicioEscogido, alumnosNotas);

		for (int i = 0; i < NUM_ESTUDIANTES; i++) {
			if (alumnosNotas[i][ejercicioEscogido - 1] != -1) {
				mediaTotal = mediaTotal + alumnosNotas[i][ejercicioEscogido - 1];
			}
		}

		return mediaTotal / alumnos;

	}

	/**
	 * Funcion que devuelve la nota maxima dada en un ejercicio escogido
	 * 
	 * @param ejercicioEscogido
	 * @param alumnosNotas
	 * @return notaMaxima
	 */
	public static int calcularNotaMaxima(int ejercicioEscogido, int[][] alumnosNotas) {
		int notaMaxima = Integer.MIN_VALUE;

		for (int i = 0; i < NUM_ESTUDIANTES; i++) {
			if (alumnosNotas[i][ejercicioEscogido - 1] > notaMaxima) {
				notaMaxima = alumnosNotas[i][ejercicioEscogido - 1];
			}
		}

		return notaMaxima;
	}

	/**
	 * Funcion que devulve la nota minima da en un ejercicio escogido
	 * 
	 * @param ejercicioEscogido
	 * @param alumnosNotas
	 * @return notaMinima
	 */
	public static int calcularNotaMinima(int ejercicioEscogido, int[][] alumnosNotas) {
		int notaMinima = Integer.MAX_VALUE;

		for (int i = 0; i < NUM_ESTUDIANTES; i++) {
			if (alumnosNotas[i][ejercicioEscogido - 1] < notaMinima) {
				notaMinima = alumnosNotas[i][ejercicioEscogido - 1];
			}
		}

		return notaMinima;
	}

	/**
	 * Funcion que te muestra todas las notas formateadas
	 * 
	 * @param nombreAlumnos nombre de los estudiantes
	 * @param alumnosNotas  array con las notas de los estudiantes
	 */
	public static void mostrarTodasNotas(int[][] alumnosNotas, String[] nombreAlumnos) {
		System.out.printf("%-15s %19s %2s %2s %2s %2s %2s\n", "Alumnos:", " ", "1", "2", "3", "4", "5");
		System.out.println("----------------------------------------------------------------------");
		for (int a = 0; a < NUM_ESTUDIANTES; ++a) {
			System.out.printf("%2s.", a + 1);
			System.out.printf("%13s", nombreAlumnos[a]);
			System.out.printf("%20s", " ");
			for (int b = 0; b < NUM_NOTAS; ++b) {
				System.out.printf("%2d ", alumnosNotas[a][b]);
			}
			System.out.println();
		}

	}

}
