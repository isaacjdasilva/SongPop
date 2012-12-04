/**
 * 
 */
package br.com.projeto.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

/**
 * @author Isaac, Waldir
 *
 */
@Repository
public class ItemDesafioDao {

	protected EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
}