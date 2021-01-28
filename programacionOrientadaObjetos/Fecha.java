/**
 * 
 */
package programacionOrientadaObjetos;

/**
 * 3. Crea una clase Fecha. Los objetos de la clase Fecha son fechas de tiempo y
 * se crean de la forma:
 * 
 * Fecha f = Fecha(1, 10, 2020);
 * 
 * Los parámetros que se le pasan al constructor son el día, el mes y el
 * año respectivamente. Si la fecha creada es incorrecta mostraremos un mensaje
 * de error en la salida estándar de errores (lo ideal sería lanzar una
 * excepción, ya lo haremos cuando se vea en clase).
 * 
 * Crea métodos para:
 * 
 * - Saber si la fecha almacenada es correcta. 
 * - Sumar y restar días a la fecha.
 * - Comparar la fecha almacenada con otra, el método devolverá un valor negativo
 * si la fecha almacenada es ANTERIOR a la otra, 0 si son IGUALES y un valor
 * positivo si es POSTERIOR. 
 * - Saber si el año de la fecha almacenada es bisiesto.
 * - El método toString() devuelve una cadena con el formato "<día del mes> de
 * <nombre del mes> de <año>".
 * 
 * Las opciones a partir de la segunda, solo se realizarán si la fecha
 * almacenada es correcta, en caso de no serlo, se dará un aviso, por la salida
 * estándar de errores, de que la operación no se puede realizar.
 * 
 * Puedes usar una variable de clase para almacenar el número de días de cada
 * mes del año (que no sea bisiesto).
 * 
 * 
 * @author javier fernandez rubio
 * @version 1.1
 * Fecha 20/01/2021
 *
 */
public class Fecha {
	
	// Atributos
	private int day;
	private int moth;
	private int year;
	
	
	// Construtor, getters y setters, toString
	
	/**
	 * Constructor de la clase Fecha
	 * 
	 * @param day
	 * @param moth
	 * @param year
	 */
	Fecha(int day, int moth, int year) {
		//super();
		this.day = day;
		this.moth = moth;
		this.year = year;
		
		if ( this.comprobarFecha() ) {
			this.day = day;
			this.moth = moth;
			this.year = year;
		} else {
			System.err.println("ERROR!!! La fecha no existe.");
		}
	}


	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		this.day = day;
	}


	/**
	 * @return the moth
	 */
	public int getMoth() {
		return moth;
	}

	/**
	 * @param moth the moth to set
	 */
	public void setMoth(int moth) {
		this.moth = moth;
	}


	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	
	// toString
	@Override
	public String toString() {
		return day + " de " + this.mes() + " de " + year;
	}
	
	
	// Resto de Métodos
	
	/**
	 * Metodo que calcula el nombre del mes de la fecha
	 * 
	 * @return mesString nombre del mes de la fecha
	 */
	public String mes() {
		int mes = this.getMoth();
		String mesString = "";
		switch (mes) {
		case 1:
			mesString = "Enero";
		case 2:
			mesString = "Febrero";
		case 3:
			mesString = "Marzo";
		case 4:
			mesString = "Abril";
		case 5:
			mesString = "Mayo";
		case 6:
			mesString = "Junio";
		case 7:
			mesString = "Julio";
		case 8:
			mesString = "Agosto";
		case 9:
			mesString = "Septiembre";
		case 10:
			mesString = "Octubre";
		case 11:
			mesString = "Noviembre";
		case 12:
			mesString = "Diciembre";
		}
		return mesString;
	}
	
	
	/**
	 * Metodo que calcula el numero de dias de cada mes
	 * 
	 * @return diaMes
	 */
	public int diasMes(int mes) {
		//int mes = this.getMoth();
		int diaMes = 0;
		switch (mes) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			diaMes = 31;
		case 4:
		case 6:
		case 9:
		case 11:
			diaMes = 30;
		case 2:
			if ( this.anyoBisiesto() ) {
				diaMes = 29;
			} else {
				diaMes = 28;
			}
		}
		return diaMes;
	}
	
	
	/**
	 * Metodo para ver si un año es bisiesto o no
	 * 
	 * @return true o false
	 */
	public boolean anyoBisiesto() {
		//if ( (this.year % 400 == 0) || ((this.year % 4 == 0) && (this.year % 100 != 0))) {
			//return true;
		//} else {
			//return false;
		//}
		
		return (this.year % 4 == 0 && (this.year % 100 != 0 || this.year % 400 == 0));
	}
	
	
	/**
	 * Comprueba su una fecha es correcta o no
	 * 
	 * @return true o false
	 */
	public boolean comprobarFecha() {
		if (this.year == 0) {
			return false;
		} else {
			if (this.moth < 1 || this.moth > 12) {
				return false;
			} else {
				if ( this.day < 1 || this.day > this.diasMes(this.moth) ) {
					return false;
				} else {
					return true;
				}
			}
		}
	}
	
	
	/**
	 * Compara dos objetos de tipo Fecha
	 * - Si la fecha 1 es mayor que la fecha 2 devuelve 1.
	 * - Si la fecha 1 es menor que la fecha 2 devuelve -1.
	 * - Si la fecha 1 es igual a la fecha 2 devuelve 0.
	 * 
	 * @param otra
	 * @return -1, 0, 1
	 */
	public int comparaFecha(Fecha otra) {
		int num = 0;
		if ( this.year == otra.year ) {
			if ( this.moth == otra.moth ) {
				if ( this.day == otra.day) {
					num = 0;
				} else {
					if (this.day < otra.day) {
						num = -1;
					} else {
						num = 1;
					}
				}
			} else {
				if (this.moth < otra.moth) {
					num = -1;
				} else {
					num = 1;
				}
			}
		} else {
			if (this.year < otra.year) {
				num = -1;
			} else {
				num = 1;
			}
		}
		return num;
	}
	
	
	/**
	 * Sumar dias a un objeto Fecha
	 * 
	 * 
	 * @param dias
	 */
	public void sumarDias(int dias) {
		int dia = this.getDay();
		int mes = this.getMoth();
		int anyo = this.getYear();
		
		for ( int i = 1; i <= dias; ++i ) {
			dia = dia + 1;
			if ( dia == this.diasMes(mes) ) {
				dia = 1;
				mes = mes + 1;
				if ( mes == 12 ) {
					mes = 1;
					anyo = anyo + 1;
				}
			}
		}
		
		this.setDay(dia);
		this.setMoth(mes);
		this.setYear(anyo);
	}
	
	
	/**
	 * Restar dias a un bojeto Fecha
	 * 
	 * 
	 * @param dias
	 */
	public void restarDias(int dias) {
		int dia = this.getDay();
		int mes = this.getMoth();
		int anyo = this.getYear();
		
		for ( int i = dias; i > 0; --i ) {
			--dia;
			if ( dia < 1 ) {
				--mes;
				if ( mes < 1 ) {
					mes = 12;
					--anyo;
				}
				dia = this.diasMes(mes);
			}
		}
		
		this.setDay(dia);
		this.setMoth(mes);
		this.setYear(anyo);
	}
	

}
