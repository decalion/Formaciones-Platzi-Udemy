package com.icaballero.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.icaballero.domain.Visitor;
import com.icaballero.exceptions.DAOException;
import com.icaballero.interfaces.daos.IVisitorDAO;
import com.icaballero.utils.FERSDataConnection;
import com.icaballero.utils.FERSDbQuery;

/**
 * 
 * @author Ismael Caballero
 *
 */
public class VisitorDAO implements IVisitorDAO {

	private Connection con;
	private PreparedStatement statment = null;
	private ResultSet result = null;
	private FERSDbQuery query = new FERSDbQuery();

	/**
	 * Constructor
	 * @param con conexion con la base de datos
	 */
	public VisitorDAO(Connection con) {
		this.con = con;
	}

	/**
	 * Metodo para insertar un visitor
	 */
	@Override
	public boolean insertData(Visitor visitor) throws DAOException {
		boolean status = false;
		try {
			statment = con.prepareStatement(query.getInsertQuery());
			statment.setInt(1, visitor.getVisitorId());
			statment.setString(2, visitor.getUserName());
			statment.setString(3, visitor.getPassword());
			statment.setString(4, visitor.getFirstName());
			statment.setString(5, visitor.getLastName());
			statment.setString(6, visitor.getEmail());
			statment.setString(7, visitor.getPhoneNumber());
			statment.setString(8, visitor.getAddres());
			statment.setString(9, visitor.getDni());
			statment.setBoolean(10, visitor.isAdmin());

			status = statment.execute();

		} catch (Exception e) {
			throw new DAOException("Error en VisitorDAO insertData");
		} finally {
			FERSDataConnection.closeStatement(statment);
			FERSDataConnection.closeResulSet(result);
		}

		return status;
	}

	/**
	 * Metodo para buscar un visitor
	 */
	@Override
	public Visitor searchUser(Visitor user) throws DAOException {
		Visitor visitor = new Visitor();
		try {
			statment = con.prepareStatement(query.getSearchQuery());
			statment.setString(1, user.getUserName());
			result = statment.executeQuery();
			if(result.next()){
				
			visitor.setVisitorId(result.getInt("id"));
			visitor.setFirstName(result.getString("firstname"));
			visitor.setLastName(result.getString("lastname"));
			visitor.setDni(result.getString("dni"));
			visitor.setEmail(result.getString("email"));
			visitor.setPhoneNumber(result.getString("phone_number"));
			visitor.setAddres(result.getString("address"));
			visitor.setUserName(result.getString("username"));
			visitor.setPassword(result.getString("password"));
			visitor.setAdmin(result.getBoolean("isadmin"));
			}

		} catch (Exception e) {
			throw new DAOException("Error en VisitorDAO searchUser");
		
		} finally {
			FERSDataConnection.closeStatement(statment);
			FERSDataConnection.closeResulSet(result);
		}

		return visitor;
	}

	/**
	 * Metodo para actualizar un Visitor
	 */
	@Override
	public int updateVisitor(Visitor visitor) throws DAOException {
		int status = -1;
		try {
			statment = con.prepareStatement(query.getUpdateQuery());
			statment.setString(1, visitor.getFirstName());
			statment.setString(2, visitor.getLastName());
			statment.setString(3, visitor.getUserName());
			statment.setString(4, visitor.getDni());
			statment.setString(5, visitor.getEmail());
			statment.setString(6, visitor.getPhoneNumber());
			statment.setString(7, visitor.getAddres());
			statment.setInt(8, visitor.getVisitorId());
			

			status = statment.executeUpdate();

		} catch (Exception e) {
			throw new DAOException("Error en VisitorDAO updateVisitor");
		} finally {
			FERSDataConnection.closeStatement(statment);
			FERSDataConnection.closeResulSet(result);
		}

		return status;
	}

	/**
	 * Metodo para actulizar la Password de un Visitor
	 */
	@Override
	public int changePassword(Visitor visitor) throws DAOException {
		int status = -1;
		try {
			statment = con.prepareStatement(query.getChangePWDQuery());
			statment.setInt(2, visitor.getVisitorId());
			statment.setString(1, visitor.getPassword());
			

			status = statment.executeUpdate();

		} catch (Exception e) {
			throw new DAOException("Error en VisitorDAO changePassword");

		} finally {
			FERSDataConnection.closeStatement(statment);
			FERSDataConnection.closeResulSet(result);
		}

		return status;
	}

}
