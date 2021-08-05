package test.com.milano.bc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.milano.architecture.dao.CorsistaDAO;
import com.milano.architecture.dao.CorsoDAO;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.bc.CorsoCorsistaBC;
import com.milano.bc.model.Corsista;
import com.milano.bc.model.Corso;
import com.milano.bc.model.CorsoCorsista;

class CorsoCorsistaBCTest {
	private static Corsista corsista;
	private static Corso corso;
	private static CorsoCorsista cc;
	private static CorsoCorsistaBC corsoCorsistaBC;
	private static Connection conn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		corsoCorsistaBC = new CorsoCorsistaBC();
		corso = new Corso();
		corso.setCodice(1);
		corso.setNome("JAVA");
		corso.setDataInizio(new GregorianCalendar(2020,10,1).getTime());
		corso.setDataFine(new GregorianCalendar(2020,10,10).getTime());
		corso.setCosto(1000);
		corso.setCommento("bello");
		corso.setAula("B123");
		corso.setCodDocente(1);
		
		corsista = new Corsista();
		corsista.setCodCorsista(1);
		corsista.setNomeCorsista("Marco");
		corsista.setCognomeCorsista("Verde");
		corsista.setPrecedentiformativi(1);
		
		cc = new CorsoCorsista();
		cc.setCodCorso(1);
		cc.setCodCorsista(1);
	}

	@Test
	void test() {
		try {
			CorsoDAO.getFactory().createCorso(conn, corso);
			CorsistaDAO.getFactory().create(conn, corsista);
			corsoCorsistaBC.create(cc);
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
	
	@Test
	void testGetAll() {
		try {
			CorsoCorsista[] corsiCorsisti = corsoCorsistaBC.getAll();
			assertNotNull(corsiCorsisti);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			CorsoDAO.getFactory().deleteCorso(conn, 1);
			CorsistaDAO.getFactory().delete(conn, corsista);
			cc = null;
			conn.commit();
			DBAccess.closeConnection();
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
	

}
