package modelo;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.Test;

class ProcesadorFechaTest {

	@Test
	void formatear() throws ParseException {
		
		LatinoAmericano dlatin1 = new LatinoAmericano();
		LatinoAmericano dlatin2 = new LatinoAmericano();
		dlatin1.formatear("10/12/2019");
		dlatin2.formatear("11/12/2019");
		//Verifico que uno es anterior a otro
		dlatin1.esAnteriorA(dlatin2.getFechaFormateada());

		//Calculo dias
		dlatin1.calcularDias(dlatin2.getFechaFormateada());
	}

}
