package test.com.milano.bc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.milano.bc.AmministratoreBC;
import com.milano.bc.model.Amministratore;

class AmministratoreBCTest {
	private static AmministratoreBC amministratoreBC;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		amministratoreBC = new AmministratoreBC();
	}

	@Test
	void testGetAmministratori() {
		try {
			Amministratore[] amministratori = amministratoreBC.getAmministratori();
			assertNotNull(amministratori);
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

}
