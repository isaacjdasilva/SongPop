package br.com.projeto.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.projeto.entity.User;

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
		return (User)query.getSingleResult();
	}

}
