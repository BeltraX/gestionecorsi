package test.com.milano.bc.validator;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.sql.SQLException;
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
		corso.setDataFine(new GregorianCalendar(2020,10,2).getTime());
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
		if (x) {
			System.out.println("Inserimento nome corretto");
		} else
			System.out.println("Inserimento nome errato");
	}
	
	@Test
	void testCheckDataInizio() {
		boolean x = false;
		x = cv.checkDataInizio(corso);
		if (x) {
			System.out.println("Inserimento data inizio corretto");
		} else
			System.out.println("Inserimento data inizio errato");
	}
	
	@Test
	void testCheckDataFine() {
		boolean x = false;
		x = cv.checkDataFine(corso);
		if (x) {
			System.out.println("Inserimento data fine corretto");
		} else
			System.out.println("Inserimento data fine errato");
	}
	
	@Test
	void testCheckCommento() {
		boolean x = false;
		x = cv.checkCommento(corso);
		if (x) {
			System.out.println("Inserimento commento corretto");
		} else
			System.out.println("Inserimento commento errato");
	}
	
	@Test
	void testCheckAula() {
		boolean x = false;
		x = cv.checkAula(corso);
		if (x) {
			System.out.println("Inserimento aula corretto");
		} else
			System.out.println("Inserimento aula errato");
	}
	
	@Test
	void testCheckDocente() {
		boolean x = false;
		x = cv.checkDocente(corso);
		if (x) {
			System.out.println("Inserimento docente corretto");
		} else
			System.out.println("Inserimento docente errato");
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		corso = null;
		cv = null;
	}
}
