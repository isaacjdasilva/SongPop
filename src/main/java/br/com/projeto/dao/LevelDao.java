package br.com.projeto.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.projeto.entity.Level;

/**
 * @author Isaac, Waldir
 *
 */
@Repository
public class LevelDao {

	protected EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public Level recuperarPorNome(String nome) {
		final StringBuffer queryString = new StringBuffer(
		"SELECT o from ");

		queryString.append(Level.class.getSimpleName()).append(" o ");
		queryString.append(" where o.nomeLevel = '");
		queryString.append(nome);
		queryString.append("'");
		
		Query query = this.em.createQuery(queryString.toString());
		
		if (query.getResultList().size() == 1) {
			return (Level) query.getResultList().get(0);
		} else {
			return null;
		}
	}

	public void create(Level level) {
		this.em.persist(level);
	}

	public Level update(Level level) {
		return this.em.merge(level);
	}

	public void delete(Level level) {
		this.em.remove(level);
	}
	
	public Object find(final Long id, Object objeto) {
		return (Object) this.em.find(objeto.getClass(), id);
	}
}