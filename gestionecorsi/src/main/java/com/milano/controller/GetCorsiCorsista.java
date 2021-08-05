package com.milano.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.milano.bc.CorsoBC;
import com.milano.bc.CorsoCorsistaBC;
import com.milano.bc.model.Corso;
import com.milano.bc.model.CorsoCorsista;

@WebServlet("/getCorsiCorsista")
public class GetCorsiCorsista extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		try {
			int codCorsista = Integer.parseInt(request.getParameter("cod"));
			ArrayList<Corso> corsiCorsista = new ArrayList<Corso>();
			CorsoBC corsoBC = new CorsoBC();
			Corso[] corsi = corsoBC.getCorsi();
			CorsoCorsistaBC corsoCorsistaBC = new CorsoCorsistaBC();
			CorsoCorsista[] arrayCC = corsoCorsistaBC.getAll();
			for (int i = 0; i < arrayCC.length; i++) {
				if (codCorsista == arrayCC[i].getCodCorsista()) {
					for (Corso c : corsi) {
						if (arrayCC[i].getCodCorso() == c.getCodice()) {
							corsiCorsista.add(c);
						}
					}
				}
			}
			session.setAttribute("corsi", corsiCorsista);
			response.sendRedirect("elencoCorsiCorsista.jsp");
		} catch (SQLException | ClassNotFoundException exc) {
			exc.printStackTrace();
			throw new ServletException();
		}
	}
}
