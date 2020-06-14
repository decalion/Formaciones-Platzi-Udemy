package com.icaballero.repositorios.jpa;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.icaballero.repositorios.GenericRepository;

public class GenericRepositoryJPA<T,K> implements GenericRepository<T, K> {

	private EntityManager entityManager;
	private Class<T> type;
	
 public GenericRepositoryJPA(Class<T> type) {
		this.type = type;
	}
	
	
	@Override
	public T findOne(K k) {


		return entityManager.find(type, k);
	}

	@Override
	public Iterable<T> findAll() {
		
		//Construir un objeto de tipo creteria
		CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
		
		//Construir una consulta para el tipo generico
		CriteriaQuery<T> consulta = cb.createQuery(type);
		
		//Clausula from con el generico
		Root<T> raiz = consulta.from(type);
		
		//Añadir el select
		consulta.select(raiz);
		
		//Crear la consulta
		TypedQuery<T> consultaEjecurada = entityManager.createQuery(consulta);
		
		return consultaEjecurada.getResultList();
	}

	@Override
	public void save(T tipo) {
		entityManager.persist(tipo);
		
	}

	@Override
	public void delete(T tipo) {
		entityManager.remove(tipo);
		
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	

}
