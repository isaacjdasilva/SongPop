/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.controle;

import br.com.mackenzie.pos.songpop.domain.Artista;
import br.com.mackenzie.pos.songpop.domain.Categoria;
import br.com.mackenzie.pos.songpop.domain.Desafio;
import br.com.mackenzie.pos.songpop.domain.Jogador;
import br.com.mackenzie.pos.songpop.domain.Musica;
import java.util.Collection;

/**
 *
 * @author Isaac
 */
public class Facade {

    private static Facade songPopFacade = null;
    private Controler controler = null;

    private Facade() {
        controler = Controler.getInstance();
    }

    public synchronized static Facade getInstance() {
        if (songPopFacade == null) {
            songPopFacade = new Facade();
        }
        
        return songPopFacade;
    }
    
    public Desafio criarDesafio(Jogador desafiante, Jogador desafiado, Categoria categoria)
    {
        return this.controler.criarDesafio(desafiante, desafiado, categoria);
    }
    
    public Categoria obterCategoriaPorId(Long id) {
        return this.controler.obterCateriaPorId(id);
    }
    
    public Jogador obterJogadorPorId(Long id) {
        return this.controler.obterJogadorPorId(id);
    }
    
    public Artista obterArtistaPorId(Long id) {
        return this.controler.obterArtistaPorId(id);
    }
    
    public Collection<Artista> pesquisarTudosArtistas() {
        return this.controler.pesquisarTudosArtistas();
    }
    
    public Collection<Musica> pesquisarTudosMusicas() {
        return this.controler.pesquisarTudosMusicas();
    }
}