package com.icaballero.controler;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icaballero.bean.SuppRequest;
import com.icaballero.util.DBConnection;

/**
 * Servlet implementation class Controler
 */
@WebServlet("/controler")
public class Controler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controler() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		execute(request, response);
	}

	private void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PreparedStatement statment = null;
		ResultSet result = null;
		Connection con = null;
		ArrayList<SuppRequest> suppList = new ArrayList<>();

		try {
			con = DBConnection.getConnection();
			statment = con.prepareStatement("SELECT * FROM supp_requests");
			result = statment.executeQuery();

			while (result.next()) {
				SuppRequest supp = new SuppRequest();
				supp.setId(result.getInt("request_id"));
				supp.setEmail(result.getString("email"));
				supp.setSoftware(result.getString("software"));
				supp.setOs(result.getString("os"));
				supp.setProblem(result.getString("problem"));
				suppList.add(supp);

			}

			request.getSession().setAttribute("suppList", suppList);

		} catch (SQLException e) {

			e.printStackTrace();
		}

		RequestDispatcher disparcher = request.getRequestDispatcher("/mostrar.jsp");
		disparcher.forward(request, response);

	}

}
