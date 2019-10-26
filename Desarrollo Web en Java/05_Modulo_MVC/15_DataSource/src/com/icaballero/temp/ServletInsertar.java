package com.icaballero.temp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
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
       
	/**
	 * Hace referencia al nombre que hay en el context.xml
	 */
	@Resource(name="jdbc/cursoWeb")
	private DataSource fuente;

	/**
	 * Ejemplo para instanciar el datasource y hacer un insert
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String sql = "insert into cursos (nombre,nivel) values ('net',1)";
		
			try {
				Connection con = fuente.getConnection();
				Statement sentencia = con.createStatement();
				sentencia.executeUpdate(sql);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				//e.printStackTrace();
			}
	}

}
