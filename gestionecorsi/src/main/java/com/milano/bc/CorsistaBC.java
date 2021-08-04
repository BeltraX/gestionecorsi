package com.milano.bc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.milano.architecture.dao.CorsistaDAO;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.bc.idgenerator.CorsistaIdGenerator;
import com.milano.bc.model.Corsista;

public class CorsistaBC {
	private Connection conn;
	private CorsistaIdGenerator idGen;

	public CorsistaBC() throws SQLException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
		idGen = CorsistaIdGenerator.getIstance();
	}

	public void create(Corsista corsista) throws SQLException, ClassNotFoundException, IOException {
		corsista.setCodCorsista(idGen.getNextId());
		CorsistaDAO.getFactory().create(conn, corsista);
	}

	public void delete(Corsista articolo) throws SQLException {
		CorsistaDAO.getFactory().delete(conn, articolo);
	}

	public Corsista[] getCorsisti() throws SQLException {

		return CorsistaDAO.getFactory().getAll(conn);
	}

	public int getTotale() throws SQLException {
		return CorsistaDAO.getFactory().getTot(conn);
	}
}
