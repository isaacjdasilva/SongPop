/**
 * 
 */
package br.com.mackenzie.pos.songpop.service.artista;

import org.springframework.transaction.annotation.Transactional;

/**
 * @author Isaac
 *
 */
public interface ArtistaService {
	
	@Transactional
    void createArtista(String uname, String upwd);
}
