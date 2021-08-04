package com.milano.bc.idgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.milano.architecture.dao.DAOConstants;
import com.milano.architecture.dbaccess.DBAccess;

public class CorsoIdGenerator implements DAOConstants {
	private static CorsoIdGenerator istanza;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	private CorsoIdGenerator() throws SQLException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public static CorsoIdGenerator getIstance() throws SQLException, ClassNotFoundException, IOException {
		if (istanza == null)
			istanza = new CorsoIdGenerator();
		return istanza;
	}

	public int getNextId() throws SQLException, ClassNotFoundException, IOException {
		int id = 0;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(SELECT_CORSOSEQ);
		rs.next();
		id = rs.getInt(1);
		return id;
	}

}
