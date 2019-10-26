package com.arquitecturajava.temp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ServletInsertar
 */
@WebServlet("/ServletInsertar")
public class ServletInsertar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Resource(name="jdbc/cursoWeb")
	private DataSource fuente;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String sql= "insert into cursos (nombre,nivel) values ('java',1)";
		try {
			Connection con = fuente.getConnection();
			Statement sentencia = con.createStatement();
			sentencia.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	

}
