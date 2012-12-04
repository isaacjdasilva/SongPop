/**
 * 
 */
package br.com.projeto.service;

/**
 * @author Isaac, Waldir
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projeto.dao.CategoriaDao;
import br.com.projeto.entity.Categoria;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaDao dao;
    
    public List<Categoria> recuperarListaCtegoriaPorLevel(Long idLevel) {
    	return dao.recuperarListaCtegoriaPorLevel(idLevel);
    }
    
	public void create(Categoria objeto) {
		dao.create(objeto);
	}

	public Categoria update(Categoria objeto) {
		return dao.update(objeto);
	}

	public void delete(Categoria objeto) {
		dao.delete(objeto);
	}
	
	public Object find(final Long id, Object objeto) {
		return (Object) dao.find(id, objeto.getClass());
	}
}