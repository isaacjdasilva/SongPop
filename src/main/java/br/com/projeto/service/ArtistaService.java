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

import br.com.projeto.dao.ArtistaDao;
import br.com.projeto.entity.Artista;

@Service
public class ArtistaService {

    @Autowired
    private ArtistaDao dao;

	public List<Artista> findAll() {
		return dao.findAll();
	}
}
