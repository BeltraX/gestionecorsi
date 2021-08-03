package com.milano.architecture.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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

}
