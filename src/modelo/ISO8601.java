package modelo;

import java.util.Date;


public class ISO8601 extends Fecha implements IFormatoFecha {
	private static final String FORMATO_ISO8601 = "^(?:[1-9][0-9]{3})\\-?(?:(?:0[13578]|1[02])\\-?31|(?:0[469]|11)\\-?30|02\\-?29|(?:0[0-9]|1[012])\\-?(?:0[1-9]|[12][0-9]))$";

	public void formatear(String fechaSinFormatear) {
		String fecha = "";	
		this.dia   = fechaSinFormatear.substring(8);
		this.mes   = fechaSinFormatear.substring(5, 7);
		this.anio  = fechaSinFormatear.substring(0, 4);
		
		fecha = this.dia + " " + this.mes + " " + this.anio;
		
		this.formatearFecha(fecha);

	}
	
	public boolean esValido (String fechaSinFormatear) {
		return fechaSinFormatear.matches(FORMATO_ISO8601);
	}
	
	public Date getFecha() {
		return this.getFechaFormateada();
	}
}
