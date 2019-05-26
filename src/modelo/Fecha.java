package modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

public class Fecha {
	protected Date fechaFormateada;
	protected String dia	 = "";
	protected String mes	 = "";
	protected String anio	 = "";
	SimpleDateFormat formato = new SimpleDateFormat("dd MM yyyy");

	protected void setFechaFormateada(Date fechaFormateada) {
	this.fechaFormateada = fechaFormateada;
	}	
	
	protected SimpleDateFormat getFormato() {
		return formato;
	}

	public Date getFechaFormateada() {
		return fechaFormateada;
	}

	protected void formatearFecha(String fecha) {
		Date fechaObtenida;
		try {
			fechaObtenida = formato.parse(fecha);
			this.setFechaFormateada(fechaObtenida);
		} catch (ParseException exception) {
			System.out.println(exception);
		}
	}
	public void formatearCualquierFecha(String fechaSinFormatear) throws FechaInvalidaException {
		ArrayList<IFormatoFecha> tiposDeFecha = new ArrayList<IFormatoFecha>();
		//Se cargan todos los formatos de fechas compatibles
		tiposDeFecha.add(new ISO8601());
		tiposDeFecha.add(new NorteAmericano());
		tiposDeFecha.add(new LatinoAmericano());	
		
		//TipoDeFecha seria una interfaz que incluya ISO,Latin,etc..
		for(IFormatoFecha tipoFecha: tiposDeFecha) {
			//No pueden existir dos patrones validos,
			//es decir, una fecha con dos patrones
			if(tipoFecha.esValido(fechaSinFormatear)) {
				try {
					tipoFecha.formatear(fechaSinFormatear);
				} catch (ParseException exception) {
					System.out.println(exception);
				}
				//Se asigna la  fecha formateada
				this.setFechaFormateada(tipoFecha.getFecha());
			}
		}	
		//Se comprueba si se formateo la fecha
		if(!this.fechaEstaFormateada()) 
		{
			//Se informa que no se pudo formatear la fecha
			throw new FechaInvalidaException();
		}
	}
	
	public boolean fechaEstaFormateada() {
		return this.fechaFormateada != null;
	}
	
	public long calcularDias(Date fecha) {
		long diferenciaEnMilesimas;
		if(this.esAnteriorA(fecha)) {
			//Fecha formateada es menor a la fecha ingresada
			diferenciaEnMilesimas= fecha.getTime() - this.getFechaFormateada().getTime();
		}
		
		//Fecha formateada es mayor a la fecha ingresada
		diferenciaEnMilesimas = this.getFechaFormateada().getTime() - fecha.getTime();
		
		//Se convierte las milesimas en dias
		return TimeUnit.DAYS.convert(diferenciaEnMilesimas, TimeUnit.MILLISECONDS);
	}
	
	public boolean esAnteriorA(Date fecha) {
		//La fecha formateada es anterior a la fecha ingresada
		return this.getFechaFormateada().compareTo(fecha) < 0;
	}


	
}
