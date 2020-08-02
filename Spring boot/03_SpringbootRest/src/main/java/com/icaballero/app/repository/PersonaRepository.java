package com.icaballero.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icaballero.app.domain.Persona;

@Repository
public interface PersonaRepository  extends CrudRepository<Persona, String>{
	
//	@Autowired
//	private JdbcTemplate plantilla;
//	
//	Logger logger = LoggerFactory.getLogger(PersonaRepository.class);
//	
//	
//	public List<Persona> buscarTodos() {
//		return plantilla.query("select * from Persona",new PersonaMapper());
//		
//		
//	}
//	
//	public void borrar(Persona persona) {
//		
//		plantilla.update("delete from Persona where nombre=?",persona.getNombre());
//	}
//	
//	public void insertar(Persona persona) {
//		
//		logger.info(persona.toString());
//		
//		plantilla.update("insert into Persona (nombre,apellidos,edad) values(?,?,?)",persona.getNombre(),persona.getApellidos(),persona.getEdad());
//	}

}
