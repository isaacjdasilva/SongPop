/**
 * 
 */
package br.com.mackenzie.pos.songpop.service.musica;

/**
 * @author Isaac
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mackenzie.pos.songpop.dao.musica.MusicaDao;

@Service("musicaService")
public class MusicaServiceImpl implements MusicaService {

    @Autowired
    private MusicaDao dao;

//    @Override
//    public void createArtista(String uname, String upwd) {
//        Artista a = new Artista();
////        a.setArtistaname(uname);
////        a.setPassword(upwd);
//        dao.create(a);
//    }
}