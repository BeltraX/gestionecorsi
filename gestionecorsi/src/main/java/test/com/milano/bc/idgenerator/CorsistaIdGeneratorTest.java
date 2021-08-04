package test.com.milano.bc.idgenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.milano.bc.idgenerator.CorsistaIdGenerator;

class CorsistaIdGeneratorTest {

	@Test
	void testIdGenerator() throws IOException, ClassNotFoundException, SQLException{
			CorsistaIdGenerator idGen =  CorsistaIdGenerator.getIstance();
			assertNotNull(idGen, "Istanza non creata tramite il singleton");
			long valore = idGen.getNextId();
			assertEquals(valore, idGen.getNextId() - 1);
		
	}

}
