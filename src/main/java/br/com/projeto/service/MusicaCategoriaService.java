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

import br.com.projeto.dao.MusicaCategoriaDao;
import br.com.projeto.entity.MusicaCategoria;

@Service
public class MusicaCategoriaService {

    @Autowired
    private MusicaCategoriaDao dao;
    
    public List<MusicaCategoria> recuperarMusicasCategoriaAtivo(Long idCategoria) {
    	return dao.recuperarMusicasCategoriaAtivo(idCategoria);
    }
}