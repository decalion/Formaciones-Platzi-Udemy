package com.icaballero.controllers;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.coritel.util.DBConnector;
import es.coritel.util.DBQuery;

/**
 * Servlet implementation class TeachSupportServlet
 */
@WebServlet("/teachsupport")
public class TeachSupportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeachSupportServlet() {
        super();
        
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
		String email = request.getParameter("txtEmail");
		String software = request.getParameter("selSoftware");
		String so = request.getParameter("selSo");
		String descripcion = request.getParameter("txtDes");
		HttpSession session = request.getSession();
		session.setAttribute("email", email);
		session.setAttribute("software", software);
		session.setAttribute("so", so);
		session.setAttribute("desc", descripcion);
		Connection con = DBConnector.getConnection();
		RequestDispatcher dispatcher;
		DBQuery query = new DBQuery(con);
		session.setAttribute("con", con);
		
		if(query.isRegister(email)){
			
			dispatcher = request.getRequestDispatcher("/response");
		}else{
			dispatcher = request.getRequestDispatcher("/register.html");
		}
		
		dispatcher.forward(request, response);
		
		
	}

}
