package modelo;

import java.text.ParseException;
import java.util.Date;

public class LatinoAmericano extends Fecha implements IFormatoFecha {
	public void formatear(String fechaSinFormatear) throws ParseException {
		String fecha = "";	
		this.day   = fechaSinFormatear.substring(0, 2);
		this.month = fechaSinFormatear.substring(3, 5);
		this.year  = fechaSinFormatear.substring(6, 10);
		
		fecha = this.day + " " + this.month + " " + this.year;
		this.setFechaFormateada(formato.parse(fecha));
	}
	public boolean esValido(String fechaSinFormatear) {
		return fechaSinFormatear.matches("^(?:31\\/?(?:0?[13578]|1[02])|30\\/?(?:0[13-9]|1[12])|29\\/?02|(?:0[1-9]|[12][0-9])\\/?(?:0[1-9]|1[012]))\\/?[1-9][0-9]{3}$");
	}
	};


