package com.icaballero.repositorios.jpa;

import javax.persistence.EntityManager;

import com.icaballero.bo.Comentario;
import com.icaballero.bo.Noticia;
import com.icaballero.repositorios.ComentarioRepositorio;

public class ComentarioRepositoryJPA implements ComentarioRepositorio {

	private EntityManager entityManager;
	
	
	@Override
	public Comentario findOne(int numero) {
		//
		return entityManager.find(Comentario.class, numero);
	}

	@Override
	public Iterable<Comentario> findAll() {
		
		return entityManager.createQuery("select c from Comentario c",Comentario.class).getResultList();
	}
	

	@Override
	public void save(Comentario comentario) {
		entityManager.persist(comentario);

	}

	@Override
	public void delete(Comentario comentario) {
		entityManager.remove(comentario);

	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	

}
