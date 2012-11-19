/**
 * 
 */
package br.com.mackenzie.pos.songpop.service.jogador;

/**
 * @author Isaac
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mackenzie.pos.songpop.dao.jogador.JogadorDao;

@Service("jogadorService")
public class JogadorServiceImpl implements JogadorService {

    @Autowired
    private JogadorDao dao;

//    @Override
//    public void createArtista(String uname, String upwd) {
//        Artista a = new Artista();
////        a.setArtistaname(uname);
////        a.setPassword(upwd);
//        dao.create(a);
//    }
}