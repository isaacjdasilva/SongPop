/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.persistencia.dao;

import br.com.mackenzie.pos.songpop.controle.util.Constantes;
import br.com.mackenzie.pos.songpop.domain.Artista;
import br.com.mackenzie.pos.songpop.domain.Musica;
import br.com.mackenzie.pos.songpop.persistencia.CrudBasico;

/**
 *
 * @author Isaac
 */
public class MusicaDAO extends CrudBasico<Musica> {

    public MusicaDAO() {
        setNomeArquivo(Constantes.BD_MUSICA_TXT);
        inicializarBaseDeDados();
    }

    @Override
    public void remover(Musica t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void alterar(Musica t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String objetoParaLinha(Musica objeto) {
        StringBuffer linha = new StringBuffer("");
        
        linha.append(objeto.getId()).append(Constantes.REGEX);
        linha.append(objeto.getNome()).append(Constantes.REGEX);
        linha.append(objeto.getPrimeraParte()).append(Constantes.REGEX);
        linha.append(objeto.getSegundaParte()).append(Constantes.REGEX);
        linha.append(objeto.getArtista().getId()).append(Constantes.REGEX);
        linha.append(objeto.iDsCategoriaLinha());
        
        return linha.toString();
    }

    @Override
    public Musica linhaParaObjeto(String linha) {
        
        String[] registro = linha.split(Constantes.REGEX);
        
        Musica musica = new Musica(Long.valueOf(registro[0].trim()));
        musica.setNome(registro[1]); 
        musica.setPrimeraParte(registro[2]);
        musica.setSegundaParte(registro[3]);
        musica.setArtista(new Artista(Long.valueOf(registro[4].trim())));
        musica.iDsLinhaParaCategoria(registro[5].trim());
        
        return musica;
    }
}
