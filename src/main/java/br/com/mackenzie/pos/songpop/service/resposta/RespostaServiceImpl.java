/**
 * 
 */
package br.com.mackenzie.pos.songpop.service.resposta;

/**
 * @author Isaac
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mackenzie.pos.songpop.dao.resposta.RespostaDao;

@Service("respostaService")
public class RespostaServiceImpl implements RespostaService {

    @Autowired
    private RespostaDao dao;

//    @Override
//    public void createArtista(String uname, String upwd) {
//        Artista a = new Artista();
////        a.setArtistaname(uname);
////        a.setPassword(upwd);
//        dao.create(a);
//    }
}