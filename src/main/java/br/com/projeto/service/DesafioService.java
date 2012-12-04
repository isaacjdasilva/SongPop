/**
 * 
 */
package br.com.projeto.service;

/**
 * @author Isaac, Waldir
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.dao.DesafioDao;
import br.com.projeto.entity.Desafio;

@Service
public class DesafioService {

    @Autowired
    private DesafioDao dao;
    
    public void create(Desafio objeto) {
		dao.create(objeto);
	}

	public Desafio update(Desafio objeto) {
		return dao.update(objeto);
	}

	public void delete(Desafio objeto) {
		dao.delete(objeto);
	}
	
	public Object find(final Long id, Object objeto) {
		return (Object) dao.find(id, objeto.getClass());
	}
}