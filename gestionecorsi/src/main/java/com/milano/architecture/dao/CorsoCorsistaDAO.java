package com.milano.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.milano.bc.model.CorsoCorsista;

public class CorsoCorsistaDAO implements DAOConstants {
private  CachedRowSet rowSet;
	
	public static CorsoCorsistaDAO getFactory() throws SQLException {
		return new CorsoCorsistaDAO();
	}	
	
	private CorsoCorsistaDAO() throws SQLException {
		rowSet = RowSetProvider.newFactory().createCachedRowSet();
	}

	public void create(Connection conn, CorsoCorsista cc) throws SQLException {
		rowSet.setCommand(SELECT_CORSO_CORSISTA);
		rowSet.execute(conn);
		rowSet.moveToInsertRow();
		rowSet.updateInt(1, cc.getCodCorso());
		rowSet.updateInt(2, cc.getCodCorsista());
		rowSet.insertRow();
		rowSet.moveToCurrentRow();
		rowSet.acceptChanges();
	}
	
	public CorsoCorsista[] getAll(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(SELECT_CORSO_CORSISTA);
		rs.last();
		CorsoCorsista[] arrayCC = new CorsoCorsista[rs.getRow()];
		for(int i = 0; i < arrayCC.length; i++) {
			CorsoCorsista cc = new CorsoCorsista();
			cc.setCodCorso(rs.getInt(1));
			cc.setCodCorsista(rs.getInt(2));
			arrayCC[i] = cc;
		}
		return arrayCC;
	}
}
