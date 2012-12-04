/**
 * 
 */
package br.com.projeto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.projeto.entity.Artista;
import br.com.projeto.entity.User;

/**
 * @author Isaac, Waldir
 *
 */
@Repository
public class ArtistaDao {
	
	protected EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public List<Artista> findAll() {
		final StringBuffer queryString = new StringBuffer("SELECT o from ");
		queryString.append(Artista.class.getSimpleName()).append(" o ");
		final Query query = this.em.createQuery(queryString.toString());
		return (List<Artista>) query.getResultList();
	}
	
	public void create(Artista objeto) {
		this.em.persist(objeto);
	}

	public Artista update(Artista objeto) {
		return this.em.merge(objeto);
	}

	public void delete(Artista objeto) {
		this.em.remove(objeto);
	}
	
	public Object find(final Long id, Object objeto) {
		return (Object) this.em.find(objeto.getClass(), id);
	}
}