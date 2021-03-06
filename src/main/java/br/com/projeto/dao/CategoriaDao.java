/**
 * 
 */
package br.com.projeto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.projeto.entity.Categoria;

/**
 * @author Isaac, Waldir
 * 
 */
@Repository
public class CategoriaDao {
	
	protected EntityManager em;

	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public void create(Categoria categoria) {
		this.em.persist(categoria);
	}

	public Categoria update(Categoria categoria) {
		return this.em.merge(categoria);
	}

	public void delete(Categoria categoria) {
		this.em.remove(categoria);
	}
	
	public Object find(final Long id, Object objeto) {
		return (Object) this.em.find(objeto.getClass(), id);
	}

	public Categoria recuperarPorNome(String nome) {

		final StringBuffer queryString = new StringBuffer(
				"SELECT o from ");

		queryString.append(Categoria.class.getSimpleName()).append(" o ");
		queryString.append(" where o.nome = '");
		queryString.append(nome);
		queryString.append("'");

		Query query = this.em.createQuery(queryString.toString());
		
		if (query.getResultList().size() == 1) {
			return (Categoria) query.getResultList().get(0);
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Categoria> recuperarListaCtegoriaPorLevel(Long idLevel) {

		final StringBuffer queryString = new StringBuffer("SELECT distinct cate FROM Categoria cate, Level lev ");
		queryString.append(" where cate.quantidadeMoeda <= lev.pontosMaximo ");
		
		queryString.append(" and lev.status = 1 ");
		
		if (idLevel != null) {
			queryString.append(" and lev.id = ");
			queryString.append(idLevel.intValue());
		}
		
		queryString.append(" order by cate.nome ");

		Query query = this.em.createQuery(queryString.toString());
		
		return (List<Categoria>) query.getResultList();

	}
	

}