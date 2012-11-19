/**
 * 
 */
package br.com.mackenzie.pos.songpop.service.categoria;

/**
 * @author Isaac
 *
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mackenzie.pos.songpop.dao.categoria.CategoriaDao;

@Service("categoriaService")
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaDao dao;

//    @Override
//    public void createArtista(String uname, String upwd) {
//        Artista a = new Artista();
////        a.setArtistaname(uname);
////        a.setPassword(upwd);
//        dao.create(a);
//    }
}