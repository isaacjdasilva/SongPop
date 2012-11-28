package br.com.projeto.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.projeto.entity.MusicaCategoria;

/**
 * @author Isaac, Waldir
 *
 */
@Repository
public class MusicaCategoriaDao {

	protected EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	public void create(MusicaCategoria objeto) {
		this.em.persist(objeto);
	}

	public MusicaCategoria update(MusicaCategoria objeto) {
		return this.em.merge(objeto);
	}

	public void delete(MusicaCategoria objeto) {
		this.em.remove(objeto);
	}
	
	public Object find(final Long id, Object objeto) {
		return (Object) this.em.find(objeto.getClass(), id);
	}
	
}