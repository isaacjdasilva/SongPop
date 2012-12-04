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

import br.com.projeto.dao.LevelDao;
import br.com.projeto.entity.Level;

@Service
public class LevelService {

    @Autowired
    private LevelDao dao;
    
    public Level recuperarMenorLevel() {
    	return dao.recuperarMenorLevel();
    }
    
    public void create(Level objeto) {
		dao.create(objeto);
	}

	public Level update(Level objeto) {
		return dao.update(objeto);
	}

	public void delete(Level objeto) {
		dao.delete(objeto);
	}
	
	public Object find(final Long id, Level objeto) {
		return (Object) dao.find(id, objeto.getClass());
	}
}