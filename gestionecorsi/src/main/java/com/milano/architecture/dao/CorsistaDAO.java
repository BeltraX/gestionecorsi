package com.milano.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.milano.bc.model.Corsista;

public class CorsistaDAO implements DAOConstants {
	private  CachedRowSet rowSet;
	
	public static CorsistaDAO getFactory() throws SQLException {
		return new CorsistaDAO();
	}	
	
	private CorsistaDAO() throws SQLException {
		rowSet = RowSetProvider.newFactory().createCachedRowSet();
	}

	public void create(Connection conn, Corsista c) throws SQLException {
		rowSet.setCommand(SELECT_CORSISTI);
		rowSet.execute(conn);
		rowSet.moveToInsertRow();
		rowSet.updateInt(1, c.getCodCorsista());
		rowSet.updateString(2, c.getNomeCorsista());
		rowSet.updateString(3, c.getCognomeCorsista());
		rowSet.updateInt(4, c.getPrecedentiformativi());
		rowSet.insertRow();
		rowSet.moveToCurrentRow();
		rowSet.acceptChanges();
	}

	public Corsista[] getAll(Connection conn) throws SQLException {
		Corsista[] corsisti = null;

		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(SELECT_CORSISTI);
		rs.last();
		corsisti = new Corsista[rs.getRow()];
		rs.beforeFirst();
		for (int i = 0; rs.next(); i++) {
			Corsista c = new Corsista();
			c.setCodCorsista(rs.getInt(1));
			c.setNomeCorsista(rs.getString(2));
			c.setCognomeCorsista(rs.getString(3));
			c.setPrecedentiformativi(rs.getInt(4));
			corsisti[i] = c;
		}
		rs.close();
		return corsisti;
	}

	public int getTot(Connection conn) throws SQLException {
		int x = 0;
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(SELECT_TOT_CORSISTI);
		rs.next();
		x = rs.getInt(1);
		rs.close();
		return x;
	}

	public void delete(Connection conn, Corsista a) throws SQLException {
		PreparedStatement ps;

		ps = conn.prepareStatement(DELETE_CORSISTA);
		ps.setInt(1, a.getCodCorsista());
		ps.execute();
		conn.commit();

	}

}
