/**
 * 
 */
package br.com.mackenzie.pos.songpop.service.itemdesafio;

/**
 * @author Isaac
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mackenzie.pos.songpop.dao.itemdesafio.ItemDesafioDao;

@Service("itemDesafioService")
public class ItemDesafioServiceImpl implements ItemDesafioService {

    @Autowired
    private ItemDesafioDao dao;

//    @Override
//    public void createArtista(String uname, String upwd) {
//        Artista a = new Artista();
////        a.setArtistaname(uname);
////        a.setPassword(upwd);
//        dao.create(a);
//    }
}