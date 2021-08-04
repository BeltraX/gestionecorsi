package com.milano.bc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.milano.architecture.dao.CorsoDAO;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.bc.idgenerator.CorsoIdGenerator;
import com.milano.bc.model.Corso;

public class CorsoBC {
	private Connection conn;
	private CorsoIdGenerator idGen;
	
	public CorsoBC() throws SQLException, ClassNotFoundException, IOException{
		conn = DBAccess.getConnection();
		idGen = CorsoIdGenerator.getIstance();
	}
	
	public void create(Corso corso) throws SQLException, ClassNotFoundException, IOException {
		corso.setCodice(idGen.getNextId());
		CorsoDAO.getFactory().createCorso(conn, corso);
	}
	
	public void update(Corso corso) throws SQLException {
		CorsoDAO.getFactory().updateCorso(conn, corso);
	}
	
	public void delete(int cod) throws SQLException{
		CorsoDAO.getFactory().deleteCorso(conn, cod);
	}
	
	public Corso[] getCorsi() throws SQLException {
		return CorsoDAO.getFactory().getCorsi(conn);
	}
	
	public String getMigliorCorso() throws SQLException {
		return CorsoDAO.getFactory().getMigliorCorso(conn);
	}
	
	public Date getDataUltimoCorso() throws SQLException {
		return CorsoDAO.getFactory().getDataUltimoCorso(conn);
	}
	
	public double getAvgCorso() throws SQLException {
		return CorsoDAO.getFactory().getAvgCorso(conn);
	}
	
	public int getNumCommenti() throws SQLException {
		return CorsoDAO.getFactory().getNumCommenti(conn);
	}
	
	public Corso[] getCorsiDisp() throws SQLException {
		return CorsoDAO.getFactory().getCorsiDisp(conn);
	}
}
