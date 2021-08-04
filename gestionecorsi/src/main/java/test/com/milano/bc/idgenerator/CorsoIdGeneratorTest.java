package test.com.milano.bc.idgenerator;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.milano.bc.idgenerator.CorsoIdGenerator;

class CorsoIdGeneratorTest {

	@Test
	void testIdGenerator() {
		try {
			CorsoIdGenerator idGen = CorsoIdGenerator.getIstance();
			assertNotNull(idGen, "Istanza non creata tramite il singleton");
			long valore = idGen.getNextId();
			assertEquals(valore, idGen.getNextId() - 1);
		} catch (ClassNotFoundException | SQLException | IOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
}
