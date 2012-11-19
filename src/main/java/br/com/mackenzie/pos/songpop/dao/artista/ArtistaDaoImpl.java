/**
 * 
 */
package br.com.mackenzie.pos.songpop.dao.artista;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.com.mackenzie.pos.songpop.dao.GenericDaoImpl;
import br.com.mackenzie.pos.songpop.entity.Artista;

/**
 * @author Isaac
 *
 */
//@Component("artistaDao")
@Repository
public class ArtistaDaoImpl extends GenericDaoImpl<Artista> implements ArtistaDao {

    public Artista loadArtistaByArtistaName(String artistaname) {
        Query query = this.em
                .createQuery("select u FROM Artista u where u.artistaname= :artistaname");
        query.setParameter("artistaname", artistaname);
        List<Artista> artistas = query.getResultList();
        if (artistas != null && artistas.size() == 1) {
            return artistas.get(0);
        }
        return null;
    }
}