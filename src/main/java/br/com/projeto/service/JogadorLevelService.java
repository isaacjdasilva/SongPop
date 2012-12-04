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

import br.com.projeto.dao.GenericDao;
import br.com.projeto.dao.JogadorLevelDao;
import br.com.projeto.entity.JogadorLevel;

@Service
public class JogadorLevelService {

    @Autowired
    private JogadorLevelDao dao;
    
    @Autowired
    private GenericDao genericDao;
    
	public void create(JogadorLevel objeto) {
		genericDao.insert(objeto);
	}

	public void update(JogadorLevel objeto) {
		genericDao.update(objeto);
	}

	public void delete(JogadorLevel objeto) {
		genericDao.remove(objeto.getClass(), objeto.getId());
	}
	
	public Object find(final Long id, JogadorLevel objeto) {
		return (Object) genericDao.findById(objeto.getClass(), id);
	}
}