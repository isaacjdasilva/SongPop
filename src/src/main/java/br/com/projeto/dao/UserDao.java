package br.com.projeto.dao;
 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.projeto.entity.Level;
import br.com.projeto.entity.User;
import br.com.projeto.util.Util;

@Repository
public class UserDao  {

	protected EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public User get(String login,String password) {
		Query query = em.createQuery("from User u where u.login = :login and u.password = :password ");
		query.setParameter("login", login);
		query.setParameter("password", password);
		 
		if (!Util.isNullOrVazio(query.getResultList())) {
			return (User)query.getResultList().get(0);
		}
		
		return null;
		
	}

	public void create(User objeto) {
		this.em.persist(objeto);
	}

	public User update(User objeto) {
		return this.em.merge(objeto);
	}

	public void delete(User objeto) {
		this.em.remove(objeto);
	}
	
	public Object find(final Long id, Object objeto) {
		return (Object) this.em.find(objeto.getClass(), id);
	}

}
