package com.milano.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.milano.bc.model.CorsoCorsista;

public class CorsoCorsistaDAO implements DAOConstants {
	private CachedRowSet rowSet;

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
		for (int i = 0; i < arrayCC.length; i++) {
			CorsoCorsista cc = new CorsoCorsista();
			cc.setCodCorso(rs.getInt(1));
			cc.setCodCorsista(rs.getInt(2));
			arrayCC[i] = cc;
		}
		return arrayCC;
	}

	public int[] getCodCorsi(Connection conn, int codCorsista) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(SELECT_CORSO_CORSISTABYID);
		ps.setInt(1, codCorsista);
		ResultSet rs = ps.executeQuery();
		ArrayList<Integer> codCorsi = new ArrayList<Integer>();
		while (rs.next()) {
			codCorsi.add(rs.getInt(1));
		}
		int[] codiciCorsi = new int[codCorsi.size()];
		for (int i = 0; i < codiciCorsi.length; i++) {
			codiciCorsi[i] = codCorsi.get(i);
		}
		return codiciCorsi;
	}
}
