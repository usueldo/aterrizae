package modelo;

import java.util.Date;

public class LatinoAmericano extends Fecha implements IFormatoFecha {
	final private static String FORMATO_LATINOAMERICANO = "^(?:31\\/?(?:0?[13578]|1[02])|30\\/?(?:0[13-9]|1[12])|29\\/?02|(?:0[1-9]|[12][0-9])\\/?(?:0[1-9]|1[012]))\\/?[1-9][0-9]{3}$";
	

	public void formatear(String fechaSinFormatear) {
		String fecha = "";	
		this.dia	= fechaSinFormatear.substring(0, 2);
		this.mes	= fechaSinFormatear.substring(3, 5);
		this.anio	= fechaSinFormatear.substring(6, 10);
		
		fecha = this.dia + " " + this.mes + " " + this.anio;
		this.formatearFecha(fecha);
	}
	public boolean esValido(String fechaSinFormatear) {
		return fechaSinFormatear.matches(FORMATO_LATINOAMERICANO);
	}
	public Date getFecha() {
		return this.getFechaFormateada();
	}
	};


