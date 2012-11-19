/**
 * 
 */
package br.com.mackenzie.pos.songpop.dao.artista;

import br.com.mackenzie.pos.songpop.dao.GenericDao;
import br.com.mackenzie.pos.songpop.entity.Artista;

/**
 * @author Isaac
 *
 */
public interface ArtistaDao extends GenericDao<Artista> {
    /**
     * Returns an Artista object that matches the username given
     *
     * @param username
     * @return
     */
    public Artista loadArtistaByArtistaName(String username);
}