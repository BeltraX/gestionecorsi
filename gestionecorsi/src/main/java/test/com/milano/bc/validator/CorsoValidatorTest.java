package test.com.milano.bc.validator;

import static org.junit.Assert.assertTrue;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.milano.bc.model.Corso;
import com.milano.bc.validator.CorsoValidator;

class CorsoValidatorTest {
	private static CorsoValidator cv;
	private static Corso corso;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		corso = new Corso();
		corso.setCodice(1);
		corso.setNome("Java");
		corso.setDataInizio(new GregorianCalendar(2020,10,1).getTime());
		corso.setDataFine(new GregorianCalendar(2020,10,3).getTime());
		corso.setCosto(20.99);
		corso.setCommento("");
		corso.setAula("12inf");
		corso.setCodDocente(1);
		cv = new CorsoValidator();
	}
	
	@Test
	void testCheckNome() {
		boolean x = false;
		x = cv.checkNome(corso);
		assertTrue(x);
	}
	
	@Test
	void testCheckDataInizio() {
		boolean x = false;
		x = cv.checkDataInizio(corso);
		assertTrue(x);
	}
	
	@Test
	void testCheckDataFine() {
		boolean x = false;
		x = cv.checkDataFine(corso);
		assertTrue(x);
	}
	
	@Test
	void testCheckCommento() {
		boolean x = false;
		x = cv.checkCommento(corso);
		assertTrue(x);
	}
	
	@Test
	void testCheckAula() {
		boolean x = false;
		x = cv.checkAula(corso);
		assertTrue(x);
	}
	
	@Test
	void testCheckDocente() {
		boolean x = false;
		x = cv.checkDocente(corso);
		assertTrue(x);
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		corso = null;
		cv = null;
	}
}
