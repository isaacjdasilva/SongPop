package br.com.projeto.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.projeto.entity.Jogador;
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
	
	public List<MusicaCategoria> recuperarMusicasCategoriaAtivo(Long idCategoria) {
		
		StringBuffer consulta = new StringBuffer("from MusicaCategoria mc where mc.pk.categoria.id = :idCategoria ");
		consulta.append("and mc.pk.categoria.status = 1");
		consulta.append("and mc.pk.musica.status = 1");
		
		Query query = em.createQuery(consulta.toString());
		
		query.setParameter("idCategoria", idCategoria);
		 
		return query.getResultList();
	}
	
}