package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
public class Fecha {
	Date fechaFormateada = null;
	String day 	 = "";
	String month = "";
	String year  = "";
	SimpleDateFormat formato = new SimpleDateFormat("dd MM yyyy");

	//Quita caracteres especiales de una fecha (/,-,+,etc...)
	public String dejarNumeros() {
		return "";
	}
	public void setFechaFormateada(Date fechaFormateada) {
		this.fechaFormateada = fechaFormateada;
	}	
	
	public SimpleDateFormat getFormato() {
		return formato;
	}

	public Date getFechaFormateada() {
		return fechaFormateada;
	}

	
	public void formatearCualquierFecha(String fechaSinFormatear) throws ParseException {
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
		LatinoAmericano latin = new LatinoAmericano();
		ISO8601 ISO = new ISO8601();
		ArrayList<IFormatoFecha> tiposDeFecha = new ArrayList<IFormatoFecha>();
		tiposDeFecha.add(ISO);
		tiposDeFecha.add(latin);
		//TipoDeFecha seria una interfaz que incluya ISO,Latin,etc..
		for(IFormatoFecha tipoFecha: tiposDeFecha) {
			//No pueden existir dos patrones validos,
			//es decir, una fecha con dos patrones
			if(tipoFecha.esValido(fechaSinFormatear)) {
				tipoFecha.formatear(fechaSinFormatear);
			}
		}
		
		if(!this.fechaEstaFormateada()) {
			System.out.println("Fecha no esta formateada");
		}else {
			System.out.println("Fecha esta formateada !");
		}

	}
	
	public boolean fechaEstaFormateada() {
		return this.fechaFormateada != null;
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

	public boolean esValido(String Fecha) { return false;};
	
}
