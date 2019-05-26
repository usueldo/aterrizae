package modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LatinoAmericanoTest {

	@Test
	void formatear_LatinoAmericanoLasFechasCoinciden(){
		LatinoAmericano fechaLatinoAmericano = new LatinoAmericano();
		fechaLatinoAmericano.formatear("31-12-2019");
        Calendar fechaEsperada = Calendar.getInstance();
        fechaEsperada.clear();
        fechaEsperada.set(2019, Calendar.DECEMBER, 31);

        assertTrue("Las fechas son distintas", fechaEsperada.getTime().equals(fechaLatinoAmericano.getFechaFormateada()));
    }

	@Test
	void formatear_LatinoAmericano1LasFechasNoCoinciden(){
		LatinoAmericano fechaLatinoAmericano = new LatinoAmericano();
		fechaLatinoAmericano.formatear("30-12-2019");
        Calendar fechaEsperada = Calendar.getInstance();
        fechaEsperada.clear();
        fechaEsperada.set(2019, Calendar.DECEMBER, 31);

        assertFalse("Las fechas son iguales", fechaEsperada.getTime().equals(fechaLatinoAmericano.getFechaFormateada()));
    }

	@Test
	void formatear_LatinoAmericanoNoSePuedeFormatear(){
		LatinoAmericano fechaLatinoAmericano = new LatinoAmericano();
		Assertions.assertThrows(StringIndexOutOfBoundsException.class,() -> fechaLatinoAmericano.formatear("2012-30"));
	}
    
	@Test
    public void calcularDias_HayDosDiasDeDiferencia() {
		LatinoAmericano fechaLatinoAmericano1 = new LatinoAmericano();
		LatinoAmericano fechaLatinoAmericano = new LatinoAmericano();
		fechaLatinoAmericano1.formatear("30-12-2019");
		fechaLatinoAmericano.formatear("28-12-2019");

        assertEquals("No hay dos dias de diferencia",
        		2,
        		fechaLatinoAmericano1.calcularDias(fechaLatinoAmericano.getFechaFormateada()));
    }
	
	@Test
    public void esAnteriorA_25DeMayoEsAnteriorA9DeJulio() {
		LatinoAmericano fechaLatinoAmericano1 = new LatinoAmericano();
		LatinoAmericano fechaLatinoAmericano2 = new LatinoAmericano();
		fechaLatinoAmericano1.formatear("25-05-2018");
		fechaLatinoAmericano2.formatear("09-07-2018");

       assertTrue("25 de Mayo no es anterior a 9 de Julio",
    		   	   fechaLatinoAmericano1.esAnteriorA(fechaLatinoAmericano2.getFechaFormateada()));
    }
}
