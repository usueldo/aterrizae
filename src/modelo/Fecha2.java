package modelo;

import java.util.Date;

public abstract class Fecha2 {
	Date fechaFormateada = new Date();
	void formatear(String fechaSinFormatear) {}
	void calcularDias(Fecha2 primerFecha, Fecha2 segundaFecha) {}
	void obtenerAnterior(Fecha2 primerFecha, Fecha2 segundaFecha) {}
	void esAnteriorA(Fecha2 fecha) {}
}
