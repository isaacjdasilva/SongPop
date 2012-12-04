/**
 * 
 */
package br.com.projeto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.projeto.entity.Jogador;
import br.com.projeto.entity.User;
import br.com.projeto.util.Util;

/**
 * @author Isaac, Waldir
 *
 */
@Repository
public class JogadorDao {
	
	protected EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public void create(Jogador objeto) {
		this.em.persist(objeto);
	}

	public Jogador update(Jogador objeto) {
		return this.em.merge(objeto);
	}

	public void delete(Jogador objeto) {
		this.em.remove(objeto);
	}
	
	public Object find(final Long id, Object objeto) {
		return (Object) this.em.find(objeto.getClass(), id);
	}

	public boolean existeJogadorComEmail(String email) {
		Query query = em.createQuery("from Jogador g where g.email = :email ");
		query.setParameter("email", email);
		 
		if (!Util.isNullOrVazio(query.getResultList())) {
			return true;
		}
		
		return false;
	}
	
	public List<Jogador> jogadoresAtivo(Long id) {
		Query query = em.createQuery("from Jogador g where g.id <> :id and g.status = 1");
		query.setParameter("id", id);
		 
		return query.getResultList();
	}

}