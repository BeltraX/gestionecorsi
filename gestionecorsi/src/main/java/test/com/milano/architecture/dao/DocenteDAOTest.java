package test.com.milano.architecture.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.milano.architecture.dao.DocenteDAO;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.bc.model.Docente;

class DocenteDAOTest {

	private static Connection conn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
	}

	@Test
	void testGetAll() {
		try {
			Docente[] docenti = DocenteDAO.getFactory().getDocenti(conn);
			assertNotNull(docenti);
		} catch (SQLException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
	
	@Test
	void testGetCorsiDocente() {
		try {
			Set<Docente> docenti = DocenteDAO.getFactory().getCorsiDocente(conn);
			assertNotNull(docenti);
		}  catch (SQLException sql){
			sql.printStackTrace();
			fail(sql.getMessage());
		}
	}
}
