package modelo;

import java.text.ParseException;

public class LatinoAmericano extends Fecha {
	public void formatear(String fechaSinFormatear) throws ParseException {
		String fecha = "";
		this.setDay(fechaSinFormatear.substring(0, 2)); //Dia
		this.setMonth(fechaSinFormatear.substring(3, 5)); // Mes 
		this.setYear(fechaSinFormatear.substring(6, 10));	//Año
		
		fecha = this.getDay() + " " + this.getMonth() + " " + this.getYear();
		this.setFechaFormateada(formato.parse(fecha));
	}
	public boolean esValido(String fechaSinFormatear) {
		return fechaSinFormatear.matches("\\\\d{2}-\\\\d{2}-\\\\d{4}\"");
	}
	};


