package com.milano.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.milano.bc.CorsoBC;
import com.milano.bc.model.Corso;

@WebServlet("/inserisciCorsisti")
public class InserisciCorsi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		Corso corso = new Corso();
		try {
			corso.setNome(request.getParameter("corso"));
			corso.setDataInizio(format.parse(request.getParameter("datainizio")));
			corso.setDataInizio(format.parse(request.getParameter("datafine")));
			corso.setCosto(Double.parseDouble(request.getParameter("costo")));
			corso.setCommento(request.getParameter("commento"));
			corso.setAula(request.getParameter("aula"));
			corso.setCodDocente(Integer.parseInt(request.getParameter("docente")));
			CorsoBC corsoBC = new CorsoBC();
			if(!corsoBC.create(corso)) {
				
			}
		} catch (ParseException | ClassNotFoundException | SQLException exc) {
			exc.printStackTrace();
		}
		
	}

}
