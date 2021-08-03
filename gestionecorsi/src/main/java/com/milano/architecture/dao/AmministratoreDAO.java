package com.milano.architecture.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.milano.bc.model.Amministratore;

public class AmministratoreDAO implements DAOConstants {
	
	public static AmministratoreDAO getFactory() {
		return new AmministratoreDAO();
	}

	private AmministratoreDAO() {
	}

	public Amministratore[] getAmministratori(Connection conn) throws SQLException {
		Amministratore[] amministratori = null;
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(SELECT_ADMIN);
		rs.last();
		amministratori = new Amministratore[rs.getRow()];
		rs.beforeFirst();
		for (int i = 0; rs.next(); i++) {
			Amministratore a = new Amministratore();
			a.setNome(rs.getString(1));
			a.setCognome(rs.getString(2));
			a.setCodice(rs.getInt(3));
			amministratori[i] = a;
		}
		rs.close();
		return amministratori;
	}
}
