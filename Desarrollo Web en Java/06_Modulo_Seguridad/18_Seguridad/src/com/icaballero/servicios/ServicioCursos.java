package com.icaballero.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.sql.DataSource;

import com.icaballero.negocio.Curso;


@Named
public class ServicioCursos {
	
	   @Resource(name="jdbc/cursoWeb")
		private DataSource fuente;


	   public List<Curso> buscarPorNombre(String nombre) {

			List<Curso> lista= new ArrayList<Curso>();
			try (Connection conn = fuente.getConnection();
				PreparedStatement stmt = busquedaParametrizada(conn, nombre);
				ResultSet rs=stmt.executeQuery();) {

				while(rs.next()) {
					lista.add(new Curso(rs.getString("nombre"),rs.getInt("nivel")));
				}

			} catch (Exception se) {

				throw new RuntimeException("error SQL", se);
			}
			return lista;
		}

	public List<Curso> buscarTodos() {

		List<Curso> lista= new ArrayList<Curso>();
		String sql = "select * from Cursos";
		try (Connection conn = fuente.getConnection();
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs=stmt.executeQuery(sql);) {

			while(rs.next()) {
				lista.add(new Curso(rs.getString("nombre"),rs.getInt("nivel")));
			}

		} catch (Exception se) {

			throw new RuntimeException("error SQL", se);
		}
		return lista;
	}

	public void insertar(Curso c) {

		String sql = "insert into cursos (nombre,nivel) values (?,?) ";
		try (Connection conn = fuente.getConnection(); 
			PreparedStatement stmt = conn.prepareStatement(sql);) {
            stmt.setString(1, c.getNombre());
			stmt.setInt(2, c.getNivel());
			
			stmt.execute();
		} catch (Exception se) {

			throw new RuntimeException("error SQL", se);
		}
	}
	public void borrar(Curso c) {

		String sql = "delete from Cursos where nombre = ? and nivel = ?";
		try (Connection conn = fuente.getConnection(); 
			PreparedStatement stmt = conn.prepareStatement(sql);) {
			stmt.setString(1, c.getNombre());
			stmt.setInt(2, c.getNivel());
			stmt.execute();
		} catch (Exception se) {

			throw new RuntimeException("error SQL", se);
		}
	}
	
	private PreparedStatement busquedaParametrizada(Connection con, String nombre) throws SQLException {
	    String sql = "select * from Cursos where nombre like ? ";
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setString(1, nombre+"%");
	    return ps;
	}

}
