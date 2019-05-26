package modelo;

public class FechaInvalidaException extends RuntimeException {
	public FechaInvalidaException() {
		super("La fecha ingresada es invalida, no se pudo formatear");
	}
}
