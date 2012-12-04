/**
 * 
 */
package br.com.projeto.dao;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.projeto.entity.Desafio;
import br.com.projeto.util.Util;

/**
 * @author Isaac, Waldir
 *
 */
@Repository
public class DesafioDao {

	protected EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	public long countAll(final Map<String, Object> params, Object objeto) {

		final StringBuffer queryString = new StringBuffer(
				"SELECT count(o) from ");

		queryString.append(objeto.getClass().getSimpleName()).append(" o ");
		queryString.append(Util.getQueryClauses(params, null));

		final Query query = this.em.createQuery(queryString.toString());

		return (Long) query.getSingleResult();

	}
	
	public void create(Desafio Desafio) {
		this.em.persist(Desafio);
	}

	public Desafio update(Desafio Desafio) {
		return this.em.merge(Desafio);
	}

	public void delete(Desafio Desafio) {
		this.em.remove(Desafio);
	}
	
	public Object find(final Long id, Object objeto) {
		return (Object) this.em.find(objeto.getClass(), id);
	}
	
}