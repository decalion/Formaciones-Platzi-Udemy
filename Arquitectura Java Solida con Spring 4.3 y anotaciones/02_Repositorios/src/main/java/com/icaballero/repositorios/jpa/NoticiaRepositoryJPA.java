package com.icaballero.repositorios.jpa;

import javax.persistence.EntityManager;

import com.icaballero.bo.Noticia;
import com.icaballero.repositorios.NoticiaRepositorio;

public class NoticiaRepositoryJPA  implements NoticiaRepositorio{

	private EntityManager entityManager;
	
	
	@Override
	public Noticia findOne(String tipo) {
		
		return entityManager.find(Noticia.class, tipo);
	}

	@Override
	public Iterable<Noticia> findAll() {
		
		return entityManager.createQuery("select n from Noticia n",Noticia.class).getResultList();
	}

	@Override
	public void save(Noticia noticia) {
		entityManager.persist(noticia);
		
	}

	@Override
	public void delete(Noticia noticia) {
		entityManager.remove(noticia);
		
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
	
	
}
