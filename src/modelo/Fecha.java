package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fecha {
	Date fechaFormateada = new Date();
	SimpleDateFormat formato = new SimpleDateFormat("dd MM yyyy");
	String day = "";
	String month = "";
	String year = "";

	public void setFechaFormateada(Date fechaFormateada) {
		this.fechaFormateada = fechaFormateada;
	}	
	
	public String getDay() {
		return day;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public SimpleDateFormat getFormato() {
		return formato;
	}

	public Date getFechaFormateada() {
		return fechaFormateada;
	}

	public void formatear(String fechaSinFormatear) throws ParseException {
	}
	
	public long calcularDias(Date fecha) {
		if(this.esAnteriorA(fecha)) {
			//Fecha formateada es menor a la fecha ingresada
			return fecha.getTime() - this.getFechaFormateada().getTime();
		}
		//Fecha formateada es mayor a la fecha ingresada
		return this.getFechaFormateada().getTime() - fecha.getTime();
	}
	
	public boolean esAnteriorA(Date fecha) {
		//La fecha formateada es anterior a la fecha ingresada
		return this.getFechaFormateada().compareTo(fecha) < 0;
	}
}
