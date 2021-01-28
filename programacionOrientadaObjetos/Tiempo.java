package programacionOrientadaObjetos;

/**
 * Clase Tiempo cuyos objetos son intervalos de tiempo en formato
 * hora-minutos-segundos
 * 
 * 
 * @author Javier Fernandez Rubio
 * @version 1.0 Fecha 17/01/2021
 * 
 *
 */
public class Tiempo implements Cloneable {

	// Atributos

	private int horas;
	private int minutos;
	private int segundos;

	/**
	 * Constructor de la clase Tiempo
	 * 
	 * @param horas
	 * @param minutos
	 * @param segundos
	 */
	Tiempo(int horas, int minutos, int segundos) {
		int segundosTotales = horas * 3600 + minutos * 60 + segundos;

		this.horas = segundosTotales / 3600;
		this.minutos = (segundosTotales % 3600) / 60;
		this.segundos = (segundosTotales % 3600) % 60;
	}
	
	@Override
	public Tiempo clone() {
		Tiempo clon = new Tiempo(this.horas, this.minutos, this.segundos);
		return clon;
	}

	// Getters y setters de los atributos

	/**
	 * @return horas
	 */
	public int getHoras() {
		return horas;
	}

	/**
	 * @return minutos
	 */
	public int getMinutos() {
		return minutos;
	}

	/**
	 * @return segundos
	 */
	public int getSegundos() {
		return segundos;
	}

	/**
	 * @param horas the horas to set
	 */
	public void setHoras(int horas) {
		this.horas = horas;
	}

	/**
	 * @param minutos the minutos to set
	 */
	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}

	/**
	 * @param segundos the segundos to set
	 */
	public void setSegundos(int segundos) {
		this.segundos = segundos;
	}

	// Métodos

	/**
	 * Suma entre dos objetos que resulta un nuevo objeto
	 * 
	 * @param otro
	 * @return
	 */
	public Tiempo suma(Tiempo otro) {
		return new Tiempo(this.horas + otro.horas, this.minutos + otro.minutos, this.segundos + otro.segundos);
	}

	/**
	 * Resta entre dos objetos que resulta un nuevo objeto
	 * 
	 * @param otro
	 * @return
	 */
	public Tiempo resta(Tiempo otro) {
		return new Tiempo(this.horas - otro.horas, this.minutos - otro.minutos, this.segundos - otro.segundos);
	}

	/**
	 * Suma segundos a un objeto
	 * 
	 * @param segundo
	 */
	public void sumarSeg(int segundo) {
		Tiempo auxiliar = new Tiempo(this.horas, this.minutos, this.segundos + segundo);
		
		this.horas = auxiliar.horas;
		this.minutos = auxiliar.minutos;
		this.segundos = auxiliar.segundos;
	}

	/**
	 * Resta segundos a un objeto
	 * 
	 * @param segundo
	 */
	public void restarSeg(int segundo) {
		this.sumarSeg(-1*segundo);
	}

	
	/**
	 * Suma de minutos a un objeto
	 * 
	 * @param minuto
	 */
	public void sumarMin(int minuto) {
		this.sumarSeg(60*minuto);
	}
	
	/**
	 * Resta de minutos a un objeto
	 * 
	 * @param minuto
	 */
	public void restarMin(int minuto) {
		this.sumarSeg(-60*minuto);
	}
	
	/**
	 * Suma de horas a un objeto
	 * 
	 * @param minuto
	 */
	public void sumarHor(int hora) {
		this.sumarSeg(3600*hora);
	}
	
	/**
	 * Resta de horas a un objeto
	 * 
	 * @param minuto
	 */
	public void restarHor(int hora) {
		this.sumarSeg(-3600*hora);
	}
	
	/**
	 * Formateo de un tiempo objeto
	 * 
	 * @param tiempo
	 */
	public static String formateo(Tiempo tiempo) {
		String hora = Integer.toString(tiempo.getHoras());
		String minutos = Integer.toString(tiempo.getMinutos());
		String segundos = Integer.toString(tiempo.getSegundos());
		return hora + "h " + minutos + "m " + segundos + "s ";
	}

	@Override
	/**
	 * Formateo de un tiempo objeto usando toString
	 */
	public String toString() {
		return horas + "h " + minutos + "m " + segundos + "s ";
	}

}
