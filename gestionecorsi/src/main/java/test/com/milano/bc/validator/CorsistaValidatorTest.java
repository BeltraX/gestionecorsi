package test.com.milano.bc.validator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.milano.bc.model.Corsista;
import com.milano.bc.validator.CorsistaValidator;

class CorsistaValidatorTest {
	private static CorsistaValidator cv;
	private static Corsista corsista;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		corsista = new Corsista();
		corsista.setCodCorsista(1);
		corsista.setNomeCorsista("Luca");
		corsista.setCognomeCorsista("Gialli");
		corsista.setPrecedentiformativi(0);
		cv = new CorsistaValidator();
	}

	@Test
	void testCheckNome() {
		boolean x = false;
		x = cv.checkNome(corsista);
		if (x) {
			System.out.println("Inserimento nome corretto");
		} else
			System.out.println("Inserimento nome errato");
	}

	@Test
	void testCheckCognome() {
		boolean y = false;
		y = cv.checkCognome(corsista);
		if (y) {
			System.out.println("Inserimento cognome corretto");
		} else
			System.out.println("Inserimento cognome errato");
	}

	@Test
	void testCheckPrecFormativi() {
		boolean z = false;
		z = cv.checkPrecFormativi(corsista);
		if (z) {
			System.out.println("Inserimento precedenti formativi corretto");
		} else
			System.out.println("Inserimento precedenti formativi errato");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		corsista = null;
	}

}
