package com.milano.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.milano.bc.CorsistaBC;
import com.milano.bc.CorsoCorsistaBC;
import com.milano.bc.idgenerator.CorsistaIdGenerator;
import com.milano.bc.model.Corsista;
import com.milano.bc.model.CorsoCorsista;

@WebServlet("/inserisciCorsi")
public class InserisciCorsisti extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Corsista corsista = new Corsista();
		
		try {
			corsista.setNomeCorsista(request.getParameter("nome"));
			corsista.setCognomeCorsista(request.getParameter("cognome"));
			corsista.setPrecedentiformativi(Integer.parseInt(request.getParameter("preformativi")));
			CorsistaBC corsistaBC = new CorsistaBC();
			if (corsistaBC.create(corsista)) {
				CorsoCorsista corsoCorsista = new CorsoCorsista();
				corsoCorsista.setCodCorsista(CorsistaIdGenerator.getIstance().getNextId()-1);
				corsoCorsista.setCodCorso(Integer.parseInt(request.getParameter("corso")));
				CorsoCorsistaBC corsoCorsistaBC = new CorsoCorsistaBC();
				corsoCorsistaBC.create(corsoCorsista);
			} else {
				
			}
			
		} catch (SQLException | ClassNotFoundException exc) {
			exc.printStackTrace();
		}
	}

}
