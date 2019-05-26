package modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NorteAmericanoTest {

	@Test
	void formatear_NorteAmericanoLasFechasCoinciden(){
		NorteAmericano fechaNorteAmericano = new NorteAmericano();
		fechaNorteAmericano.formatear("12-31-2019");
        Calendar fechaEsperada = Calendar.getInstance();
        fechaEsperada.clear();
        fechaEsperada.set(2019, Calendar.DECEMBER, 31);

        assertTrue("Las fechas son distintas", fechaEsperada.getTime().equals(fechaNorteAmericano.getFechaFormateada()));
    }

	@Test
	void formatear_NorteAmericanoLasFechasNoCoinciden(){
		NorteAmericano fechaNorteAmericano = new NorteAmericano();
		fechaNorteAmericano.formatear("12-30-2019");
        Calendar fechaEsperada = Calendar.getInstance();
        fechaEsperada.clear();
        fechaEsperada.set(2019, Calendar.DECEMBER, 31);

        assertFalse("Las fechas son iguales", fechaEsperada.getTime().equals(fechaNorteAmericano.getFechaFormateada()));
    }

	@Test
	void formatear_NorteAmericanoNoSePuedeFormatear(){
		NorteAmericano fechaLatinoAmericano = new NorteAmericano();
		Assertions.assertThrows(StringIndexOutOfBoundsException.class,() -> fechaLatinoAmericano.formatear("2012-30"));
	}
    
	@Test
    public void calcularDias_HayDosDiasDeDiferencia() {
		NorteAmericano fechaNorteAmericano1 = new NorteAmericano();
		NorteAmericano fechaNorteAmericano2 = new NorteAmericano();
		fechaNorteAmericano1.formatear("12-30-2019");
		fechaNorteAmericano2.formatear("12-28-2019");

        assertEquals("No hay dos dias de diferencia",
        		2,
        		fechaNorteAmericano1.calcularDias(fechaNorteAmericano2.getFechaFormateada()));
    }
	
	@Test
    public void esAnteriorA_25DeMayoEsAnteriorA9DeJulio() {
		NorteAmericano fechaNorteAmericano1 = new NorteAmericano();
		NorteAmericano fechaNorteAmericano2 = new NorteAmericano();
		fechaNorteAmericano1.formatear("05-25-2018");
		fechaNorteAmericano2.formatear("07-09-2018");

       assertTrue("25 de Mayo no es anterior a 9 de Julio",
    		   	   fechaNorteAmericano1.esAnteriorA(fechaNorteAmericano2.getFechaFormateada()));
    }
}
