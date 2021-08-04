package com.milano.bc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.milano.architecture.dao.CorsoCorsistaDAO;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.bc.model.CorsoCorsista;

public class CorsoCorsistaBC {
	private Connection conn;

	public CorsoCorsistaBC() throws SQLException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public void create(CorsoCorsista cc) throws SQLException {
		CorsoCorsistaDAO.getFactory().create(conn, cc);
	}
}
