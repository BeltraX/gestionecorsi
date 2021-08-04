package com.milano.architecture.dao;

import java.sql.Connection;
import java.sql.SQLException;

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
}
