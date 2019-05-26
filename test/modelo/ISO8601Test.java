package modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ISO8601Test {

	@Test
	void formatear_ISO8601LasFechasCoinciden(){
		ISO8601 fechaISO = new ISO8601();
		fechaISO.formatear("2019-12-31");
        Calendar fechaEsperada = Calendar.getInstance();
        fechaEsperada.clear();
        fechaEsperada.set(2019, Calendar.DECEMBER, 31);

        assertTrue("Las fechas son distintas", fechaEsperada.getTime().equals(fechaISO.getFechaFormateada()));
    }

	@Test
	void formatear_ISO8601LasFechasNoCoinciden(){
		ISO8601 fechaISO = new ISO8601();
		fechaISO.formatear("2019-12-30");
        Calendar fechaEsperada = Calendar.getInstance();
        fechaEsperada.clear();
        fechaEsperada.set(2019, Calendar.DECEMBER, 31);

        assertFalse("Las fechas son iguales", fechaEsperada.getTime().equals(fechaISO.getFechaFormateada()));
    }

	@Test
	void formatear_ISO8601NoSePuedeFormatear(){
		ISO8601 fechaISO = new ISO8601();
		Assertions.assertThrows(StringIndexOutOfBoundsException.class,() -> fechaISO.formatear("2012-30"));
	}
    
	@Test
    public void calcularDias_HayDosDiasDeDiferencia() {
		ISO8601 fechaISO1 = new ISO8601();
		ISO8601 fechaISO2 = new ISO8601();
		fechaISO1.formatear("2019-12-30");
		fechaISO2.formatear("2019-12-28");

        assertEquals("No hay dos dias de diferencia",
        		2,
        		fechaISO1.calcularDias(fechaISO2.getFechaFormateada()));
    }
	
	@Test
    public void esAnteriorA_25DeMayoEsAnteriorA9DeJulio() {
		ISO8601 fechaISO1 = new ISO8601();
		ISO8601 fechaISO2 = new ISO8601();
		fechaISO1.formatear("2018-05-25");
		fechaISO2.formatear("2019-07-09");

       assertTrue("25 de Mayo no es anterior a 9 de Julio",
    		   	   fechaISO1.esAnteriorA(fechaISO2.getFechaFormateada()));
    }
}
