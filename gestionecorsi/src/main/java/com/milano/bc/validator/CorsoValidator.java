package com.milano.bc.validator;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import com.milano.architecture.dao.DAOConstants;
import com.milano.architecture.dbaccess.DBAccess;
import com.milano.bc.model.Corso;

public class CorsoValidator implements DAOConstants {
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	public boolean checkNome(Corso corso) {
		return Pattern.matches("^[a-zA-Z ,.'-]{2,30}+$", corso.getNome());
	}

	public boolean checkDataInizio(Corso corso) {
		return Pattern.matches("^(0[1-9]|[12][0-9]|3[01])\\/(0[1-9]|1[0-2])\\/([12][0-9]{3})$",
				format.format(corso.getDataInizio()));
	}

	public boolean checkDataFine(Corso corso) {
		if (Pattern.matches("^(0[1-9]|[12][0-9]|3[01])\\/(0[1-9]|1[0-2])\\/([12][0-9]{3})$",
				format.format(corso.getDataFine()))
				& corso.getDataFine().getTime() - corso.getDataInizio().getTime() >= 2)
			return true;
		else
			return false;
	}

	public boolean checkCommento(Corso corso) {
		return Pattern.matches("^[a-zA-Z0-9 ,.'-]{0,200}$", corso.getCommento());
	}

	public boolean checkAula(Corso corso) {
		return Pattern.matches("^[a-zA-Z0-9 ,.'-]{2,30}+$", corso.getAula());
	}

	public boolean checkDocente(Corso corso) {
		String str = null;
		PreparedStatement ps;
		try {
			ps = DBAccess.getConnection().prepareStatement(SELECT_DOCENTI_BYID);
			ps.setInt(1, corso.getCodDocente());
			ResultSet rs = ps.executeQuery();
			rs.next();
			str = rs.getString(1);
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (str != null)
			return true;
		else
			return false;
	}

}
