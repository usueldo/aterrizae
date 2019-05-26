package modelo;

import java.text.ParseException;
import java.util.Date;

public interface IFormatoFecha {
	public void formatear(String fechaSinFormatear) throws ParseException;
	public boolean esValido (String fechaSinFormatear);
	public Date getFecha();
}
