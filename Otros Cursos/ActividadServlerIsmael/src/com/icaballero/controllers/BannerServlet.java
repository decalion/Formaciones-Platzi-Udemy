package com.icaballero.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.coritel.util.DBConnector;
import es.coritel.util.DBQuery;

/**
 * Servlet implementation class BannerServlet
 */
@WebServlet("/BannerServlet")
public class BannerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BannerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			String email = (String) session.getAttribute("email");
			Connection con = (Connection) session.getAttribute("con");
			DBQuery query = new DBQuery(con);
			String name = query.getCustomerName(email);
			PrintWriter salida = response.getWriter();
			salida.println("Hola : " + name);
	}

}
