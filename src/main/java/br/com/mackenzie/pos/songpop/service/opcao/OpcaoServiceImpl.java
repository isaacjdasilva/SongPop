/**
 * 
 */
package br.com.mackenzie.pos.songpop.service.opcao;

/**
 * @author Isaac
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mackenzie.pos.songpop.dao.opcao.OpcaoDao;

@Service("opcaoService")
public class OpcaoServiceImpl implements OpcaoService {

    @Autowired
    private OpcaoDao dao;

//    @Override
//    public void createArtista(String uname, String upwd) {
//        Artista a = new Artista();
////        a.setArtistaname(uname);
////        a.setPassword(upwd);
//        dao.create(a);
//    }
}