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
	//Quita caracteres especiales de una fecha (/,-,+,etc...)
	public String dejarNumeros() {
		return "";
	}
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

	protected void formatear(String fechaSinFormatear) throws ParseException {

	}
	
	public void formatearFecha(String fechaSinFormatear) {
		/*if(esISO){
		formatear(yyyy-mm-dd)
		}
		elseif(esLatin){
			formatear(dd/mm/yyyy)
		}
		else{
		 removerSeparadores(yyyy-dd-mm)
		 formatear(ddmmyyyy)
		}*/
		/*
		int cantidadDeFechas  = tiposDeFecha.size() - 1;
		for(int indice = 0; indice < cantidadFechas && 
							tiposFecha[indice].esValido(fechaSinFormatear); indice++){
			tiposFecha[indice].formatear(fechaSinFormatear);
		}*/

		//TipoDeFecha seria una interfaz que incluya ISO,Latin,etc..
		for(TiposFecha tipoFecha: tiposDeFecha) {
			//No pueden existir dos patrones validos,
			//es decir, una fecha con dos patrones
			if(tipoFecha.esValido(fechaSinFormatear)) {
				tipoFecha.formatear(fechaSinFormatear);
			}
		}
		
		if(!this.fechaEstaFormateada()) {
			this.getPattern()//trato de obtener patron, si no lo encuentro lanzo excepcion
			//Lanzar excepcion
		}

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
