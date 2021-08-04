package test.com.milano.bc;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.milano.bc.CorsistaBC;
import com.milano.bc.model.Corsista;

class CorsistaBCTest {
	private static CorsistaBC corsistaBC;
	private static Corsista corsista;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		corsistaBC = new CorsistaBC();
		corsista = new Corsista();
		corsista.setCodCorsista(1);
		corsista.setNomeCorsista("Luca");
		corsista.setCognomeCorsista("Gialli");
		corsista.setPrecedentiformativi(0);
		boolean x;
		try {
			x=corsistaBC.create(corsista);
			assertTrue(x);
			
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

	@Test
	void testGetAll() {
		Corsista[] corsisti;
		try {
			corsisti = corsistaBC.getCorsisti();
			assertNotNull(corsisti);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	void testGetTotale() {
		int x;
		try {
			x = corsistaBC.getTotale();
			System.out.println(x);
			assertNotNull(x);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			corsistaBC.delete(corsista);
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
}
