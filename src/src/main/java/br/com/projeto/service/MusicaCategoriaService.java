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

import br.com.projeto.dao.MusicaCategoriaDao;

@Service
public class MusicaCategoriaService {

    @Autowired
    private MusicaCategoriaDao dao;
}