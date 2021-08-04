package test.com.milano.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.milano.architecture.dao.CorsistaDAO;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.bc.model.Corsista;

class CorsistaDAOTest {
	private static Corsista corsista;
	private static Connection conn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		corsista = new Corsista();
		corsista.setCodCorsista(1);
		corsista.setNomeCorsista("Marco");
		corsista.setCognomeCorsista("Verde");
		corsista.setPrecedentiformativi(1);
	}

	@Test
	void testCreate() {
		try {
			CorsistaDAO.getFactory().create(conn, corsista);
			System.out.println("Creato corsista");
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

	@Test
	void testGetAll() {
		try {
			Corsista[] corsisti = CorsistaDAO.getFactory().getAll(conn);
			assertNotNull(corsisti);
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

	@Test
	void testGetTot() {
		try {
			int x = CorsistaDAO.getFactory().getTot(conn);
			System.out.println(x);
			assertNotNull(x);
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			CorsistaDAO.getFactory().delete(conn, corsista);
			DBAccess.closeConnection();
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
}
