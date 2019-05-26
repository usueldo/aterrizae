package modelo;

import java.util.Date;

public class NorteAmericano extends Fecha implements IFormatoFecha {
    private static final String FORMATO_NORTEAMERICANO = "^(?:(?:0[13578]|1[02])\\-?31|(?:0[13-9]|1[12])\\-?30|02\\-?29|(?:0[1-9]|1[012])\\-?(?:0[1-9]|[12][0-9]))\\-?[1-9][0-9]{3}$";

    public void formatear(String fechaSinFormatear) {
		String fecha = "";		
		this.dia   = fechaSinFormatear.substring(3, 5);
		this.mes   = fechaSinFormatear.substring(0, 2);
		this.anio  = fechaSinFormatear.substring(6, 10);
		
		fecha = this.dia + " " + this.mes + " " + this.anio;
		this.formatearFecha(fecha);
	}
	public boolean esValido (String fechaSinFormatear) {
		return fechaSinFormatear.matches(FORMATO_NORTEAMERICANO);
	}
	
	public Date getFecha() {
		return this.getFechaFormateada();
	}
}
