package com.icaballero.app.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.icaballero.app.domain.Persona;

public class PersonaMapper implements RowMapper<Persona> {

	@Override
	public Persona mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return new Persona(rs.getString("nombre"), rs.getString("apellidos"), rs.getInt("edad"));
	}

}
