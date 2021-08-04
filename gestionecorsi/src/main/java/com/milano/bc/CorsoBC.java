package com.milano.bc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import com.milano.architecture.dao.CorsoDAO;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.bc.idgenerator.CorsoIdGenerator;
import com.milano.bc.model.Corso;
import com.milano.bc.validator.CorsistaValidator;
import com.milano.bc.validator.CorsoValidator;

public class CorsoBC {
	private Connection conn;
	private CorsoIdGenerator idGen;
	private CorsoValidator cv;

	public CorsoBC() throws SQLException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
		idGen = CorsoIdGenerator.getIstance();
		cv = new CorsoValidator();
	}

	public boolean create(Corso corso) throws SQLException, ClassNotFoundException, IOException {
		if (!cv.checkNome(corso)) {
			return false;
		} else if (!cv.checkDataInizio(corso)) {
			return false;
		} else if (!cv.checkDataFine(corso)) {
			return false;
		} else if (!cv.checkCommento(corso)) {
			return false;
		} else if (!cv.checkAula(corso)) {
			return false;
		} else if (!cv.checkDocente(corso)) {
			return false;
		} else {
			corso.setCodice(idGen.getNextId());
			CorsoDAO.getFactory().createCorso(conn, corso);
			return true;
		}
	}

	public boolean update(Corso corso) throws SQLException {
		if (!cv.checkNome(corso)) {
			return false;
		} else if (!cv.checkDataInizio(corso)) {
			return false;
		} else if (!cv.checkDataFine(corso)) {
			return false;
		} else if (!cv.checkCommento(corso)) {
			return false;
		} else if (!cv.checkAula(corso)) {
			return false;
		} else if (!cv.checkDocente(corso)) {
			return false;
		} else {
			CorsoDAO.getFactory().updateCorso(conn, corso);
			return true;
		}
		
	}

	public void delete(int cod) throws SQLException {
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
