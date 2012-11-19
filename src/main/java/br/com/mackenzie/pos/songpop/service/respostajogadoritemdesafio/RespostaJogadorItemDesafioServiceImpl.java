/**
 * 
 */
package br.com.mackenzie.pos.songpop.service.respostajogadoritemdesafio;

/**
 * @author Isaac
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mackenzie.pos.songpop.dao.respostajogadoritemdesafio.RespostaJogadorItemDesafioDao;

@Service("respostaJogadorItemDesafioService")
public class RespostaJogadorItemDesafioServiceImpl implements RespostaJogadorItemDesafioService {

    @Autowired
    private RespostaJogadorItemDesafioDao dao;

//    @Override
//    public void createArtista(String uname, String upwd) {
//        Artista a = new Artista();
////        a.setArtistaname(uname);
////        a.setPassword(upwd);
//        dao.create(a);
//    }
}