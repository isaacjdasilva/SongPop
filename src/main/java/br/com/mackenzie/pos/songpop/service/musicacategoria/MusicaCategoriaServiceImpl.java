/**
 * 
 */
package br.com.mackenzie.pos.songpop.service.musicacategoria;

/**
 * @author Isaac
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mackenzie.pos.songpop.dao.musicacategoria.MusicaCategoriaDao;

@Service("musicaCategoriaService")
public class MusicaCategoriaServiceImpl implements MusicaCategoriaService {

    @Autowired
    private MusicaCategoriaDao dao;

//    @Override
//    public void createArtista(String uname, String upwd) {
//        Artista a = new Artista();
////        a.setArtistaname(uname);
////        a.setPassword(upwd);
//        dao.create(a);
//    }
}