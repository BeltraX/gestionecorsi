package com.milano.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.milano.bc.model.Corso;


public class CorsoDAO implements DAOConstants{
	private CachedRowSet rowSet;
	
	public static CorsoDAO getFactory() throws SQLException {
		return new CorsoDAO();
	}
	
	private CorsoDAO() throws SQLException {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
	}
	
	public void createCorso(Connection conn, Corso c ) throws SQLException {
		rowSet.setCommand(SELECT_CORSI);
		rowSet.execute(conn);
		rowSet.moveToInsertRow();
		rowSet.updateInt(1, c.getCodice());
		rowSet.updateString(2, c.getNome());
		rowSet.updateDate(3, new java.sql.Date(c.getDataInizio().getTime()));
		rowSet.updateDate(4, new java.sql.Date(c.getDataFine().getTime()));
		rowSet.updateDouble(5, c.getCosto());
		rowSet.updateString(6, c.getCommento());
		rowSet.updateString(7, c.getAula());
		rowSet.updateInt(8, c.getCodDocente());
		rowSet.insertRow();
		rowSet.moveToCurrentRow();
		rowSet.acceptChanges();
	}
	
	public void deleteCorso(Connection conn, int codCorso) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(DELETE_CORSO);
		ps.setInt(1, codCorso);
		ps.execute();
		conn.commit();
	}
	
	public void updateCorso(Connection conn, Corso c) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(UPDATE_CORSO);
		ps.setString(1, c.getNome());
		ps.setDate(2, new java.sql.Date(c.getDataInizio().getTime()));
		ps.setDate(3, new java.sql.Date(c.getDataFine().getTime()));
		ps.setDouble(4, c.getCosto());
		ps.setString(5, c.getCommento());
		ps.setString(6, c.getAula());
		ps.setInt(7, c.getCodDocente());
		ps.setInt(8, c.getCodice());
		ps.execute();
		conn.commit();
	}
	
	public Corso[] getCorsi(Connection conn) throws SQLException{
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE, 
				ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(SELECT_CORSI);
		rs.last();
		Corso[] corsi = new Corso[rs.getRow()];
		rs.beforeFirst();
		for(int i = 0; rs.next(); i++ ) {
			Corso c = new Corso();
			c.setCodice(rs.getInt(1));
			c.setNome(rs.getString(2));
			c.setDataInizio(rs.getDate(3));
			c.setDataFine(rs.getDate(4));
			c.setCosto(rs.getDouble(5));
			c.setCommento(rs.getString(6));
			c.setAula(rs.getString(7));
			c.setCodDocente(rs.getInt(8));
			corsi[i] = c;
		}
		rs.close();
		return corsi;
	}
	
	public String getMigliorCorso(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE, 
				ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(SELECT_CORSI);
		int partecip = 0;
		String nomeCorso = "";
		while(rs.next()) {
			PreparedStatement ps = conn.prepareStatement(COUNT_PARTECIP_BYID);
			ps.setInt(1, rs.getInt(1));
			ResultSet rs2 = ps.executeQuery();
			rs2.next();
			int partecipantiCorso = rs2.getInt(1);
			if(partecipantiCorso > partecip) {
				partecip = partecipantiCorso;
				nomeCorso = rs.getString(2);
			}
		}
		return nomeCorso;
	}
	
	public Date getDataUltimoCorso(Connection conn) throws SQLException{
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(SELECT_DATA_ULTIMOCORSO);
		rs.next();
		return rs.getDate(1);
	}
	
	public double getAvgCorso(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE, 
				ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(SELECT_CORSI);
		int sommaG = 0;
		int nCorsi = 0;
		while(rs.next()) {
			PreparedStatement ps = conn.prepareStatement(SELECT_DURATA_GG_CORSO);
			ps.setInt(1, rs.getInt(1));
			ResultSet rs2 = ps.executeQuery();
			rs2.next();
			int durataCorso = rs2.getInt(1);
			int lavorativiCorso = durataCorso / 7;
			sommaG += durataCorso - (lavorativiCorso * 2);
			nCorsi ++;
		}
		return sommaG/nCorsi;
	}
	
	public int getNumCommenti(Connection conn) throws SQLException{
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(COUNT_COMMENTI);
		rs.next();
		return rs.getInt(1);
	}
	
	public Corso[] getCorsiDisp(Connection conn) throws SQLException{
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE, 
				ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(SELECT_CORSI);
		List<Corso> corsi = new ArrayList<Corso>();
		while(rs.next()) {
			int codCorso = rs.getInt(1);
			PreparedStatement ps = conn.prepareStatement(COUNT_PARTECIP_BYID);
			ps.setInt(1, codCorso);
			ResultSet rs2 = ps.executeQuery();
			rs2.next();
			int nPartecipanti = rs2.getInt(1);
			if(nPartecipanti < 13) {
				PreparedStatement ps2 = conn.prepareStatement(SELECT_CORSI_BYID);
				ps2.setInt(1, codCorso);
				ResultSet rs3 = ps2.executeQuery();
				rs3.next();
				Corso c = new Corso();
				c.setCodice(rs3.getInt(1));
				c.setNome(rs3.getString(2));
				c.setDataInizio(rs3.getDate(3));
				c.setDataFine(rs3.getDate(4));
				c.setCosto(rs3.getDouble(5));
				c.setCommento(rs3.getString(6));
				c.setAula(rs3.getString(7));
				c.setCodDocente(rs3.getInt(8));
				corsi.add(c);
			}
		}
		Corso[] arrayC = new Corso[corsi.size()];
		for(int i = 0; i < arrayC.length; i++) {
			arrayC[i] = corsi.get(i);
		}
		return arrayC;
	}
}
