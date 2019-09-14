package com.icaballero.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.icaballero.exceptions.DAOException;
import com.icaballero.interfaces.daos.ISequencerDAO;
import com.icaballero.utils.FERSDataConnection;
import com.icaballero.utils.FERSDbQuery;

public class SequencerDAO implements ISequencerDAO {

	private Connection conn = null;
	private PreparedStatement statment = null;
	private ResultSet result = null;
	private FERSDbQuery query = new FERSDbQuery();

	public SequencerDAO(Connection conn) {
		this.conn = conn;
	}

	/**
	 * Metodo para actualizar el id y devolver el id Actulizado
	 */
	@Override
	public int getNext(String classname) {

		return updateSequencer(classname) >= 1 ? getCurrent(classname) : -1;
	}

	/**
	 * metodo para actualizar el id
	 * 
	 * @param classname
	 * @return
	 */
	private int updateSequencer(String classname) {
		int status = -1;

		try {
			statment = conn.prepareStatement(query.getActualizaSequencer());
			statment.setString(1, classname);
			status = statment.executeUpdate();

		} catch (Exception e) {
			throw new DAOException("Error en SequencerDAO updateSequencer");
		} finally {
			FERSDataConnection.closeStatement(statment);
			FERSDataConnection.closeResulSet(result);

		}

		return status;
	}

	/**
	 * metodo que devuelve el id actual
	 * 
	 * @param classname
	 * @return
	 */
	private int getCurrent(String classname) {

		int status = -1;

		try {
			statment = conn.prepareStatement(query.getSequencerActual());
			statment.setString(1, classname);
			result = statment.executeQuery();
			if (result.next()) {
				status = result.getInt("value");
			}

		} catch (Exception e) {
			throw new DAOException("Error en SequencerDAO getCurrent");

		} finally {
			FERSDataConnection.closeStatement(statment);
			FERSDataConnection.closeResulSet(result);

		}

		return status;
	}

}
