package br.com.projeto.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GenericDao  {
	
	protected EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	@Transactional
	public <T> void insert(T entity) {
		em.persist(entity);
	}

	@Transactional
	public <T> void update(T entity) {
		em.merge(entity);
	}
	
	@Transactional
	public <T> void remove(Class<T> entityClass, Object id) {
		T entity = findById(entityClass, id);
		em.remove(entity);
	}

	@Transactional
	public <T> void remove(Class<T> entityClass, Integer[] ids) {
		for(int i = 0; i < ids.length; i++) {
			Integer id = ids[i];
			this.remove(entityClass, id);
		}
	}

	@Transactional(readOnly=true)
	public <T> T findById(Class<T> entityClass, Object id) {
		return em.find(entityClass, id);
	}
	
}
