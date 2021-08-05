package com.milano.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

import com.milano.bc.model.Corso;
import com.milano.bc.model.Docente;

public class DocenteDAO implements DAOConstants {

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
	
	public HashSet<Docente> getCorsiDocente(Connection conn) throws SQLException {
		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = stmt.executeQuery(SELECT_CORSI);
		HashSet<Docente> docenti = new HashSet<Docente>();
		rs.last();
		Corso[] corsi = new Corso[rs.getRow()];
		rs.beforeFirst();
		//carico i corsi in un array
		for (int i = 0; rs.next(); i++) {
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
		rs.beforeFirst();
		//doppio ciclo, uno per scorrere l'array di corsi
		//l'altro per paragonare il codice del corso per vedere ripetizione
		for (int i = 0; rs.next(); i++) {
			int codDoc = corsi[i].getCodDocente();
			PreparedStatement ps = conn.prepareStatement(COUNT_DOCENTI);
			ps.setInt(1, codDoc);
			ResultSet rs2 = ps.executeQuery();
			rs2.next();
			if(rs2.getInt(1) > 1) {
				PreparedStatement ps2 = conn.prepareStatement(SELECT_DOCENTI_BYID);
				ps2.setInt(1, codDoc);
				ResultSet rs3 = ps2.executeQuery();
				rs3.next();
				Docente d = new Docente();
				d.setNomeDocente(rs3.getString(1));
				d.setCognomeDocente(rs3.getString(2));
				d.setCvDocente(rs3.getString(3));
				d.setCodDocente(rs3.getInt(4));
				docenti.add(d);
			}
		}
	    return docenti;
	}
}
