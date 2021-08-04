package com.milano.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.milano.bc.CorsoBC;

@WebServlet("/rimuoviCorso")
public class rimuoviCorso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int codcorso = Integer.parseInt(request.getParameter("codcorso"));
		try {
			CorsoBC corsoBC = new CorsoBC();
			if (codcorso != 0) {
				corsoBC.delete(codcorso);

			}
		} catch (SQLException | ClassNotFoundException exc) {
			exc.printStackTrace();
			throw new ServletException();
		}
		response.sendRedirect("carrello.jsp");
	}

}
