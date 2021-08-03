package test.com.milano.bc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.milano.bc.DocenteBC;
import com.milano.bc.model.Docente;

class DocenteBCTest {
	private static DocenteBC docenteBC;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		docenteBC = new DocenteBC();
	}

	@Test
	void testGetAmministratori() {
		try {
			Docente[] docenti = docenteBC.getAmministratori();
			assertNotNull(docenti);
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

}
