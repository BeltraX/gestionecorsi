package com.milano.bc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.milano.architecture.dao.AmministratoreDAO;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.bc.model.Amministratore;

public class AmministratoreBC {
	private Connection conn;
	
	public AmministratoreBC() throws ClassNotFoundException, SQLException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public Amministratore[] getAmministratori() throws SQLException{
		return AmministratoreDAO.getFactory().getAmministratori(conn);
	}

}
