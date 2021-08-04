package com.milano.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		ServletContext application = request.getServletContext();
		int tentativi = (int)application.getAttribute("tentativi");
		
		Amministratore[] admin;
		String redirect = "";
		try {
			if (nome != null && cognome != null && codice != 0) {
				Amministratore utente = new Amministratore();
				utente.setNome(nome);
				utente.setCognome(cognome);
				utente.setCodice(codice);
				AmministratoreBC adminBC = new AmministratoreBC();
				admin = adminBC.getAmministratori();
				for (Amministratore a : admin) {
					if (utente.getNome().equals(a.getNome()) && utente.getCognome().equals(a.getCognome()) && utente.getCodice() == a.getCodice()) {
						redirect = "home.jsp";
						break;
					} else {
						if (tentativi < 5) {
							redirect = "index.jsp";
						} else {
							redirect = "tentativiEsauriti.jsp";
						}
					}
				}
				if(redirect == "index.jsp") {
					response.sendRedirect(redirect);
				} else {
					response.sendRedirect(redirect);
				}
			} else {
				response.sendRedirect("index.jsp");
			}
		} catch (ClassNotFoundException | IOException | SQLException exc) {
			exc.printStackTrace();
			throw new ServletException();
		}
	}
}
