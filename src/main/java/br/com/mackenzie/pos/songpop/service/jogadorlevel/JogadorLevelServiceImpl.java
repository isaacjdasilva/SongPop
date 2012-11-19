/**
 * 
 */
package br.com.mackenzie.pos.songpop.service.jogadorlevel;

/**
 * @author Isaac
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mackenzie.pos.songpop.dao.jogadorlevel.JogadorLevelDao;

@Service("jogadorLevelService")
public class JogadorLevelServiceImpl implements JogadorLevelService {

    @Autowired
    private JogadorLevelDao dao;

//    @Override
//    public void createArtista(String uname, String upwd) {
//        Artista a = new Artista();
////        a.setArtistaname(uname);
////        a.setPassword(upwd);
//        dao.create(a);
//    }
}