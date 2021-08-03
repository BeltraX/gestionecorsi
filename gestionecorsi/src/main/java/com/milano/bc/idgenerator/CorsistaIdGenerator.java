package com.milano.bc.idgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.milano.architecture.dao.DAOConstants;
import com.milano.architecture.dbaccess.DBAccess;

public class CorsistaIdGenerator implements DAOConstants {
	private static CorsistaIdGenerator istanza;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	private CorsistaIdGenerator() throws SQLException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public static CorsistaIdGenerator getIstance() throws SQLException, ClassNotFoundException, IOException {
		if (istanza == null)
			istanza = new CorsistaIdGenerator();
		return istanza;
	}

	public int getNextId() throws SQLException, ClassNotFoundException, IOException {
		int id = 0;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(SELECT_CORSISTASEQ);
		rs.next();
		id = rs.getInt(1);
		return id;
	}

}
