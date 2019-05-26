package modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FlexibleTest {

	
	@Test
	void formatearCualquierFecha_fechaFormateadaSinErrorISO(){
		Fecha fechatest = new Fecha();
		fechatest.formatearCualquierFecha("2018-01-12");
        Calendar fechaEsperada = Calendar.getInstance();
        fechaEsperada.clear();
        fechaEsperada.set(2018, Calendar.JANUARY, 12);

        assertTrue("Las fechas no son iguales", fechaEsperada.getTime().equals(fechatest.getFechaFormateada()));
 
	}

	@Test
	void formatearCualquierFecha_fechaFormateadaSinErrorLatin(){
		Fecha fechatest = new Fecha();
		fechatest.formatearCualquierFecha("12/01/2019");
        Calendar fechaEsperada = Calendar.getInstance();
        fechaEsperada.clear();
        fechaEsperada.set(2019, Calendar.JANUARY, 12);

        assertTrue("Las fechas no son iguales", fechaEsperada.getTime().equals(fechatest.getFechaFormateada()));
 
	}

	@Test
	void formatearCualquierFecha_fechaFormateadaSinErrorNorte(){
		Fecha fechatest = new Fecha();
		fechatest.formatearCualquierFecha("01-12-2019");
        Calendar fechaEsperada = Calendar.getInstance();
        fechaEsperada.clear();
        fechaEsperada.set(2019, Calendar.JANUARY, 12);

        assertTrue("Las fechas no son iguales", fechaEsperada.getTime().equals(fechatest.getFechaFormateada()));
 
	}
	
	@Test
	void formatearCualquierFecha_fechaDesconocida(){
		Fecha fechatest = new Fecha();
        Calendar fechaEsperada = Calendar.getInstance();
        fechaEsperada.clear();
        fechaEsperada.set(2019, Calendar.JANUARY, 12);

        Assertions.assertThrows(FechaInvalidaException.class,
        						() -> fechatest.formatearCualquierFecha("43-54-2019"));
	}

	@Test
    public void calcularDias_HayDosDiasDeDiferencia() {
		Fecha fechaFlexible1 = new Fecha();
		Fecha fechaFlexible2 = new Fecha();
		fechaFlexible1.formatearCualquierFecha("2018-04-04");
		fechaFlexible2.formatearCualquierFecha("2018-04-02");

        assertEquals("No hay dos dias de diferencia",
        		2,
        		fechaFlexible1.calcularDias(fechaFlexible2.getFechaFormateada()));
    }
	@Test
    public void esAnteriorA_25DeMayoEsAnteriorA9DeJulio() {
		Fecha fechaFlexible1 = new Fecha();
		Fecha fechaFlexible2 = new Fecha();
		fechaFlexible1.formatearCualquierFecha("2018-05-25");
		fechaFlexible2.formatearCualquierFecha("2019-07-09");

       assertTrue("25 de Mayo no es anterior a 9 de Julio",
    		   	   fechaFlexible1.esAnteriorA(fechaFlexible2.getFechaFormateada()));
    }
}
