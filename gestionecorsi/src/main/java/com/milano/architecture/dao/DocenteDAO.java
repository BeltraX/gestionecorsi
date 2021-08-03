package com.milano.architecture.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.milano.bc.model.Amministratore;
import com.milano.bc.model.Docente;

public class DocenteDAO implements DAOConstants{

	public static DocenteDAO getFactory() {
		return new DocenteDAO();
	}

	private DocenteDAO() {
	}

	public Docente[] getDocenti(Connection conn) throws SQLException {
		Docente[] docenti = null;
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(SELECT_DOCENTI);
		rs.last();
		docenti = new Docente[rs.getRow()];
		rs.beforeFirst();
		for (int i = 0; rs.next(); i++) {
			Docente d = new Docente();
			d.setNomeDocente(rs.getString(1));
			d.setCognomeDocente(rs.getString(2));
			d.setCvDocente(rs.getString(3));
			d.setCodDocente(rs.getInt(4));
			docenti[i] = d;
		}
		rs.close();
		return docenti;
	}

}
