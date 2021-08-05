package com.milano.bc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;

import com.milano.architecture.dao.DocenteDAO;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.bc.model.Docente;

public class DocenteBC {
	private Connection conn;

	public DocenteBC() throws ClassNotFoundException, SQLException, IOException {
		conn = DBAccess.getConnection();
	}

	public Docente[] getDocenti() throws SQLException {
		return DocenteDAO.getFactory().getDocenti(conn);
	}

	public HashSet<Docente> getNumCorsi() throws SQLException {
		return DocenteDAO.getFactory().getCorsiDocente(conn);
	}
}
