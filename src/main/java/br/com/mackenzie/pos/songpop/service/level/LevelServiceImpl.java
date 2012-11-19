/**
 * 
 */
package br.com.mackenzie.pos.songpop.service.level;

/**
 * @author Isaac
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mackenzie.pos.songpop.dao.level.LevelDao;

@Service("levelService")
public class LevelServiceImpl implements LevelService {

    @Autowired
    private LevelDao dao;

//    @Override
//    public void createArtista(String uname, String upwd) {
//        Artista a = new Artista();
////        a.setArtistaname(uname);
////        a.setPassword(upwd);
//        dao.create(a);
//    }
}