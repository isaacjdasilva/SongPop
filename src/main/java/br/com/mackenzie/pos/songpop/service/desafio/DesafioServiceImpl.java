/**
 * 
 */
package br.com.mackenzie.pos.songpop.service.desafio;

/**
 * @author Isaac
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mackenzie.pos.songpop.dao.desafio.DesafioDao;

@Service("desafioService")
public class DesafioServiceImpl implements DesafioService {

    @Autowired
    private DesafioDao dao;

//    @Override
//    public void createArtista(String uname, String upwd) {
//        Artista a = new Artista();
////        a.setArtistaname(uname);
////        a.setPassword(upwd);
//        dao.create(a);
//    }
}