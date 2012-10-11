/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.pos.songpop.persistencia.dao;

import br.com.mackenzie.pos.songpop.controle.util.Constantes;
import br.com.mackenzie.pos.songpop.domain.Artista;
import br.com.mackenzie.pos.songpop.persistencia.CrudBasico;

/**
 *
 * @author Isaac
 */
public class ArtistaDAO extends CrudBasico<Artista> {

    public ArtistaDAO() {
        setNomeArquivo(Constantes.BD_ARTISTA_TXT);
        inicializarBaseDeDados();
    }

    @Override
    public void remover(Artista t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void alterar(Artista t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String objetoParaLinha(Artista objeto) {
        StringBuffer linha = new StringBuffer("");

        linha.append(objeto.getId()).append(Constantes.REGEX);
        linha.append(objeto.getNome()).append(Constantes.REGEX);
        linha.append(objeto.iDsMusicaLinha());

        return linha.toString();
    }

    @Override
    public Artista linhaParaObjeto(String linha) {

        Artista artista = null;
        
        if (linha != null && linha.trim().length() != 0) {
            String[] registro = linha.split(Constantes.REGEX);

            artista = new Artista(Long.valueOf(registro[0].trim()));
            artista.setNome(registro[1]);
            artista.iDsLinhaParaMusica(registro[2]);
        }

        return artista;
    }
}
