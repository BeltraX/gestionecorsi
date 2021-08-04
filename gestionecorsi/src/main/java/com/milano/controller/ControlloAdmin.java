package com.milano.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.milano.bc.AmministratoreBC;
import com.milano.bc.model.Amministratore;

@WebServlet("/controlloAdmin")
public class ControlloAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		int codice = Integer.parseInt(request.getParameter("codice"));

		HttpSession session = request.getSession();
		int i = (int) (session.getAttribute("tentativi"));

		Amministratore[] admin;
		try {
			if (nome != null && cognome != null && codice != 0) {
				Amministratore utente = new Amministratore();
				utente.setNome(nome);
				utente.setCognome(cognome);
				utente.setCodice(codice);
				AmministratoreBC adminBC = new AmministratoreBC();
				admin = adminBC.getAmministratori();
				for (Amministratore a : admin) {
					if (utente.equals(a)) {
						session.setAttribute("nome", nome);
						response.sendRedirect("home.jsp");
					}
				}

				if (i < 6) {
					response.sendRedirect("index.jsp");
					i++;
					session.setAttribute("tentativi", i);
				}else {
					response.sendRedirect("tentativiEsauriti.jsp");
				}
			} else {
				
			}
		} catch (ClassNotFoundException | IOException | SQLException exc) {

		}
	}
}
