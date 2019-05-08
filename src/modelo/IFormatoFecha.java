package modelo;

import java.text.ParseException;

public interface IFormatoFecha {
	public void formatear(String fechaSinFormatear) throws ParseException;
	public boolean esValido (String fechaSinFormatear);
}
